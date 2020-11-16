package all.reflect.reflection;

//什么叫反射
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的对象
        Class c1 = Class.forName("reflect.reflection.User");
        System.out.println(c1);
        Class c2 = Class.forName("reflect.reflection.User");

        //一个类在内存中只有一个class对象
        //一个类被加载后，类的整个结构都会被封装在class对象中
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }
}


//实体类
class User{
    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}