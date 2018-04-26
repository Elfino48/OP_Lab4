import java.util.ArrayList;

public class ManualHash  {
    int size = 10;
    int numEl = 0;
    private ArrayList<LinkedList> arr = new ArrayList<>();

    ManualHash(int s){ // Конструктор, резервирующий 1 пустое место
        this.size = s;
        for ( int i = 0; i < size; i++ ){
            arr.add(new LinkedList());
        }
    }

    public void push(String key, String val){ // Вставка элемента в соответствующую ячейку по хеш-коду
        if ( size*0.8 < numEl )
            reBuild();
        numEl++;
        int hash = HashingMachine(key);
        //System.out.println(hash);
        arr.get(hash).addEl(key.toLowerCase(), val);
    }

    public void hashSearch(String key){ // Поиск элемента по хешкоду
        int hash = HashingMachine(key);
        arr.get(hash).find(key, arr.get(hash).firstElement);
    }

    public void print(){ // Вывод значений всех элементов ( функция для себя )
        for ( int i = 0; i < 10; i++ ){
            arr.get(i).print(arr.get(i).firstElement);
        }
    }

    private int HashingMachine(String key) { // Функция хеширования, суммирует все символы строки и делит на размер массива
        int elHash = 0;

        /*for (int i = 0; i < key.length(); i++) {
            elHash += key.charAt(i);
        }*/

        for (int i = 0; i < key.length(); i++)
            elHash = (31 * elHash + key.charAt(i)) % size;

       // elHash %= size;

        return elHash;
    }

    private void reBuild(){
        ManualHash hash2 = new ManualHash(size*2);

        for ( int i = 0; i < size; i++ ){
            hash2 = arr.get(i).getElementArray(hash2, arr.get(i).firstElement);
        }
        arr = hash2.arr;
        numEl = hash2.numEl;
        size = hash2.size;
        //System.out.println(size);
    }
}
