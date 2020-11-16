package all.reflect.reflection;
//测试class类的创建方式有哪些
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println(person.getName());

        //1.通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());
        //2.通过forName获得
        Class c2 = Class.forName("reflect.reflection.Student");
        System.out.println(c2.hashCode());
        //3.通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());
        //4.基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4.hashCode());

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);


    }

}


class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student() {
        this.setName("学生");
    }
}

class Teacher extends Person{
    public Teacher(){
        this.setName("老师");
    }
}