package all.reflect.reflection;

public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException{

        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类--》扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类--》根加载器（C / C++）
        ClassLoader parentParent = parent.getParent();
        System.out.println(parentParent);

        //测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("reflect.reflection.Test06").getClassLoader();
        System.out.println(classLoader);

        //测试JDK内置的类是谁加载
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        //如何获取系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

    }
}
