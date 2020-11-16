package all.reflect.annotation;

import java.lang.annotation.*;


//定义一个注解
//Target 表示自定义的注解可以用在什么地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})

//Retention 表示注解在什么地方还有效
//runtime>class>sources
@Retention(RetentionPolicy.RUNTIME)

//Documented 表示是否将我们的注解生成在Javadoc中
@Documented

//Inherited 子类可以继承父类的注解
@Inherited
@interface MyAnnotation{

}


@MyAnnotation
public class Test01 {
    public void test(){
    }
}
