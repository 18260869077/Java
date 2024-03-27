import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Homework01Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务端 （IP,端口）
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客户端 socket返回" + socket.getClass());

        //2.连接上之后，生成socket，通过socket,getOutputStream() 得到和scoket 对象关联的输出流对象

        OutputStream outputStream = socket.getOutputStream();

        //3.通过输出流，写入数据到 数据通道 使用 字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        //从键盘读取用户的问题
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题");
        String question = scanner.next();
        bufferedWriter.write(question);
        bufferedWriter.newLine();//插入一个换行符，表示写入内容结束，注意要求对方使用，readLine()
        bufferedWriter.flush();//使用字符流要手动刷新，否则数据不会写入数据通道



        //4.获得和socketg 关联的输入流，读取数据(字符) ，并显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        //5.关闭流对象和soket,必须关闭
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出...");







    }
}
