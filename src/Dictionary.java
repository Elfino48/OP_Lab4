import java.io.*;
import java.util.regex.*;

public class Dictionary {
    String res;
    Dictionary (String res) {
        this.res = res;
    }
    public void qw() throws IOException {
        String alphaber = "abcdefghijklmnopqrstuvwxyz";

        String dictionary[] = new String[26];
        try (FileReader reader = new FileReader(res)) {
            String stroka = "";
            int c;
            while ((c = reader.read()) != -1) {
                stroka += String.valueOf(c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }


    }

}
