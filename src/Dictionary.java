import java.io.*;

public class Dictionary {
    String res;
    private ManualHash hashTable = new ManualHash();

    Dictionary (String res) throws IOException {
        this.res = res;
        createDictionary();
    }

    public void createDictionary() throws IOException {       // Метод разбивает файл на строки, и передает строки
        FileInputStream stream = new FileInputStream(res); // методу setDictionary
        int length = stream.available();
        byte [] data = new byte[ length ];
        stream.read(data);
        stream.close();
        String text = new String(data);
        String[] st = text.split("\n");
        for(String x : st) {
            setDictionary(x);
        }
    }

    public void setDictionary(String word) {                      // Метод разделяет строку на ключ и значение
        String key = word.substring(0, word.indexOf(';')); // и вызывает метод push из твоего класса
        String val = word;
        hashTable.push(key, val);
    }

    public void getValue(String key) {    // Метод вызывает твой метод который
        hashTable.hashSearch(key);  // возвращает значение ключа, хотя по мне как-то не очень
    }                                       // \__( -_-)__/

}
