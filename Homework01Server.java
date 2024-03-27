import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在 9999 端口监听，等待连接");

        // 2. 当没有客户端连接 9999 端口时，程序会 阻塞, 等待连接
        Socket socket = serverSocket.accept();

        System.out.println("服务端 socket =" + socket.getClass());

        // 3. 通过 socket.getInputStream() 读取客户端写入到数据通道的数据, 显示

        InputStream inputStream = socket.getInputStream();

        // 4. IO 读取, 使用字符流, 老师使用 InputStreamReader 将 inputStream 转成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String s = bufferedReader.readLine();
        String answer = "";
        if ("name".equals(s)) {
            answer = "我是韩顺平";
        } else if ( "hobby".equals(s) ) {
            answer = "编写 java 程序";
        } else {
            answer = "你说啥子";
        }

        System.out.println(s);

        // 5. 获取 socket 相关联的输出流

        OutputStream outputStream = socket.getOutputStream();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        bufferedWriter.write(answer);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        // 6.关闭流和 socket
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();// 关闭
    }

}
