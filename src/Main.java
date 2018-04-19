import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        ManualHash a = new ManualHash();
        Dictionary b = new Dictionary("res/dictionary.csv");
        a.createHashTable();
        b.setDictionary();
        System.out.println(b.getValue(args[0].toLowerCase()));
    }
}
//Тут думаю всё понятно