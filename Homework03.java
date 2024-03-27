import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] agrs) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileReader("e:\\dog.properties"));
        properties.list(System.out);
        String name = properties.getProperty("name") + "";
        int age = Integer.parseInt(properties.getProperty("age") + "");
        String color = properties.getProperty("color") +"";
        Dog dog = new Dog(name,  age, color) ;

        System.out.println(dog);


        String filePath = "e:\\dog.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));

        objectOutputStream.writeObject(dog);
        objectOutputStream.close();
    }
}

class Dog implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private int age;
    private String color;

    public Dog() {

    }

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;

    }

    @Override
    public String toString() {

        return "Dog{" + "name='" + name + '\'' + " ,age=" + age + " ,color='" + color + '\''+ "}";
    }

}
