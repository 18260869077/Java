import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void  main (String [] agrs) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//ZS8-190228213/10.41.31.36

        InetAddress host2 = InetAddress.getByName("ZS8-190228213");
        System.out.println(host2);//ZS8-190228213/10.41.31.36

        InetAddress host3 = InetAddress.getByName("www.baidu.com");
        System.out.println(host3);//www.baidu.com/103.235.46.40


        //获取 InetAddress 对象的主机名 getHostName
       String host3Name = host3.getHostName();
       System.out.println(host3Name);

       String host3Address = host3.getHostAddress();

       System.out.println(host3Address);
    }
}
