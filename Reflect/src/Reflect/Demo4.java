package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.function.DoubleToIntFunction;

/*
利用反射执行构造器
 */
public class Demo4 {
    Class cl;
    public Demo4(Class cl) throws NoSuchFieldException {
        this.cl = cl;
    }
    public void work() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //先获得一个构造器反射对象
        Constructor cn = cl.getDeclaredConstructor(int.class, String.class, int.class);
        //利用cn进行构造器来新建一个类
        Person person = (Person) cn.newInstance(1, "cindy", 25);
        //输出看看
        System.out.println(person.toString());
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        new Demo4(Class.forName("Reflect.Person")).work();
    }
}
