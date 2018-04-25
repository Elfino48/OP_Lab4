import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary b = new Dictionary("res/dd"); // Создаем словарь

        Scanner in = new Scanner(System.in); // Scanner для проверки ввода в консоль

        while(true) { // Бесконечный ввод
            System.out.print("Type a word to get definition: ");
            String key = in.next();
            b.getValue(key);
        }
    }
}
//Тут думаю всё понятно