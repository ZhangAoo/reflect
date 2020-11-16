package all.reflect.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("reflect.reflection.User");
        //构造一个对象
        User user = (User) c1.newInstance();//本质是调用了类的无参构造器
        System.out.println(user);
        //通过构造器传递对象
        Constructor constructor = c1.getDeclaredConstructor( int.class,String.class, int.class);
        User user2 =(User) constructor.newInstance( 001, "嘿嘿嘿",22);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3,"巴扎嘿");//invoke:激活的意思
        System.out.println(user3.getName());

        //通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");

        //不能直接操作私有属性，我们需要关闭程序的安全检测
        name.setAccessible(true);//设置可访问的（设置访问性）：true可以访问，false不可以访问
        name.set(user4,"张三");
        System.out.println(user4.getName());

    }
}
