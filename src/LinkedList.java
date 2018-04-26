import java.util.ArrayList;

public class LinkedList {

    Element firstElement = null;

    // Стандартная реализация двусвязного массива..

    class Element{

        String key;
        Element next = null;
        ArrayList<String> innerList = new ArrayList<>();

        Element(String k, String v){
            this.key = k;
            innerList.add(v);
        }
    }

    public void addEl(String k, String v){
        if ( firstElement == null ){
            firstElement = new Element(k, v);
        }
        else {
            addElReq(firstElement, k, v);
        }
    }

    private void addElReq(Element el, String k, String v){

        if ( k.equals(el.key) ){
            el.innerList.add(v);
            return;
        }

        if (el.next != null )
            addElReq(el.next, k, v);
        else {
            el.next = new Element(k, v);
        }
    }

    public void print(Element el){
        if ( firstElement == null )
            return;

        System.out.println(el.key + " ");
        if ( el.next != null )
            print(el.next);
    }

    public void find(String k, Element el){

        if ( firstElement == null )
            return;

        if ( k.equals(el.key) ) {
            for( int i = 0; i < el.innerList.size(); i++ ){
                System.out.println(el.innerList.get(i));
            }
            return;
        }

        if ( el.next != null )
            find(k, el.next);

    }

    public ManualHash getElementArray(ManualHash hash2, Element el){

        if ( firstElement == null )
            return hash2;


        for ( int i = 0; i < el.innerList.size(); i++){
            hash2.push(el.key, el.innerList.get(i));
        }


        if ( el.next != null )
            getElementArray(hash2, el.next);

        return hash2;
    }


}
