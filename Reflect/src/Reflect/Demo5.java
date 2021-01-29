package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
利用反射操作类中的方法
 */
public class Demo5 {
    Class cl;
    public Demo5(Class cl) throws NoSuchFieldException {
        this.cl = cl;
    }
    public void work() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //先获得一个方法反射对象
        Method md = cl.getDeclaredMethod("getName");
        //构造一个类对象
        Person person = new Person(1,"cindy", 25);
        //执行类的相应方法
        md.setAccessible(true);  //因为getName()是private，因此需要暴力破解
        System.out.println(md.invoke(person));
        //并获取方法名称
        System.out.println(md.getName());
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        new Demo5(Class.forName("Reflect.Person")).work();
    }
}
