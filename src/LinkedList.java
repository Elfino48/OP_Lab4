public class LinkedList {

    Element firstElement = null;

    // Стандартная реализация двусвязного массива..

    class Element{

        String key, val;
        Element next = null, prev = null;

        Element(String k, String v){
            this.key = k;
            this.val = v;
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
            System.out.println(el.val);
            return;
        }

        if ( el.next != null )
            find(k, el.next);

    }

    public ManualHash getElementArray(ManualHash hash2, Element el){

        if ( firstElement == null )
            return hash2;

        hash2.push(el.key, el.val);

        if ( el.next != null )
            getElementArray(hash2, el.next);

        return hash2;
    }


}
