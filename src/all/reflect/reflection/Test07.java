package all.reflect.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("reflect.reflection.User");



        Field[] fields = c1.getFields();//只能找到public的属性
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("======================================");
        Field[] declaredFields = c1.getDeclaredFields();//可以找到所有属性，包括private
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        //获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);
        System.out.println("=======================================");

        //获取类的方法
        Method[] methods = c1.getMethods();//获取本类及父类所有的public方法
        for (Method method : methods) {
            System.out.println("11111:"+method);
        }
        methods=c1.getDeclaredMethods();//只获取本类的所有方法
        for (Method method : methods) {
            System.out.println("22222:"+method);
        }

        //获得指定的方法
        //重载
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);


    }
}
