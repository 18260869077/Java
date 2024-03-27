import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Homework02 {
    public static void main(String[] agrs) {
        String filePath = "e:\\note.txt";
        // 创建bufferedReder
        BufferedReader br = null;
        String line = "";
        int lineNum = 0;

        try {

            InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "utf-8");
            br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                System.out.println(++lineNum + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (br != null) {

                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
