package all.reflect.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//反射操作注解
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class c1 = Class.forName("reflect.reflection.Student02");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解value的值
        DataTable dataTable = (DataTable)c1.getAnnotation(DataTable.class);
        System.out.println(dataTable.value());

        //获得类指定的注解
        Field name = c1.getDeclaredField("name");
        FileTable annotation = name.getAnnotation(FileTable.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@DataTable("localhost_student")
class Student02{
    @FileTable(columnName = "student_id",type ="int",length = 10)
    private int id;
    @FileTable(columnName = "student_name",type = "String",length = 10)
    private String name;

    Student02(){}
    Student02(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DataTable{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FileTable{
    String columnName();
    String type();
    int length();


}