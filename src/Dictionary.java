import java.io.*;

public class Dictionary {
    String res;
    Dictionary (String res) {
        this.res = res;
    }

    public void setDictionary() throws IOException {       // Метод разбивает файл на строки, и передает строки
        FileInputStream stream = new FileInputStream(res); // методу setDictionary
        int length = stream.available();
        byte [] data = new byte[ length ];
        stream.read(data);
        stream.close();
        String text = new String(data);
        String[] st = text.split("\n");
        for(String x : st)
            setDictionary(x);
    }

    public static void setDictionary(String word) {                      // Метод разделяет строку на ключ и значение
        String key = word.substring(0, word.indexOf(';')).toLowerCase(); // и вызывает метод push из твоего класса
        String val = word;
        ManualHash.push(key, val);
    }

    public String getValue(String key) {  // Метод вызывает твой метод который
        return ManualHash.hashSearch(key);  // возвращает значение ключа, хотя по мне как-то не очень
    }                                     // \__( -_-)__/

}
