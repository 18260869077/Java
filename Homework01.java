import java.io.*;

import javax.print.DocFlavor.STRING;

public class Homework01 {
  public static void main(String[] args) throws IOException {

    // 先创建文件对象
    File file = new File("e:\\mytemp");
    File file2 = new File("e:\\mytemp\\hello.txt");

    if (file.isDirectory() == false) {
      file.mkdir();

    }
    if (file2.isFile() == true) {
      System.out.println("文件已存在~");
    } else {
      // 创建 FileOutputStream 对象

      String filePath = "e:\\mytemp\\hello.txt";

      FileOutputStream fileOutputStream = null;

      String str = "hello,world~";

      fileOutputStream = new FileOutputStream(filePath);

      fileOutputStream.write(str.getBytes());

      fileOutputStream.close();
    }

  }

}