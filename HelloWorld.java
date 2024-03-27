import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {

        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}


class A extends Thread {

    private boolean loop = true;

    @Override
    public void run() {
        // 输出1-100的数字

        while (loop) {
            System.out.println((int) (Math.random() * 100 + 1));

            // 休眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setLoop(boolean loop) {// 可以修改loop
        this.loop = loop;

    }
}

class B extends Thread {
    private A a;
    private Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            // 接收到用户的输入
            System.out.println("请输入你的指令(Q)表示退出");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                // 已通知的方式结束A线程
                a.setLoop(false);
                System.out.println("B线程退出");
                break;
            }

        }

    }

}