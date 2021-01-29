package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
利用反射得到的class对象，获取四种类型的对象
 */
public class Demo2 {
    //1.获取类的成员变量
    public void get1(Class cl) throws NoSuchFieldException {
        //有以下四种获取方法。上面两种仅限public，下面两种是获取全部
        Field[] fd1 = cl.getFields();
        Field fd2 = cl.getField("age");
        Field[] fd3 = cl.getDeclaredFields();
        Field fd4 = cl.getDeclaredField("name");
        //输出看看
        for(Field ff: fd1) System.out.print(ff+" ");
        System.out.println();
        System.out.println(fd2);
        for(Field ff: fd3) System.out.print(ff+" ");
        System.out.println();
        System.out.println(fd4);
    }
    //2.获取类的构造器
    public void get2(Class cl) throws NoSuchMethodException {
        //有以下四种获取方法，性质同理
        Constructor[] cn1 = cl.getConstructors();
        Constructor cn2 = cl.getConstructor(int.class);
        Constructor[] cn3 = cl.getDeclaredConstructors();
        Constructor cn4 = cl.getDeclaredConstructor(int.class, String.class, int.class);
        //输出看看
        for(Constructor cn: cn1) System.out.print(cn+" ");
        System.out.println();
        System.out.println(cn2);
        for(Constructor cn: cn3) System.out.print(cn+" ");
        System.out.println();
        System.out.println(cn4);
    }
    //3.获取类的方法
    public void get3(Class cl) throws NoSuchMethodException {
        //有以下四种获取方法，性质同理
        Method[] md1 = cl.getMethods();
        Method md2 = cl.getMethod("getNumber");
        Method[] md3 = cl.getDeclaredMethods();
        Method md4 = cl.getDeclaredMethod("getName");
        //输出看看
        for(Method md: md1) System.out.print(md+" ");
        System.out.println();
        System.out.println(md2);
        for(Method md: md3) System.out.print(md+" ");
        System.out.println();
        System.out.println(md4);
    }
    //4.获取全类名
    public void get4(Class cl){
        System.out.println(cl.getName());
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        //获取类
        Class cl = Class.forName("Reflect.Person");
        //获取成员变量
        new Demo2().get1(cl);
        System.out.println("-----------------");
        //获取构造器
        new Demo2().get2(cl);
        System.out.println("-----------------");
        //获取方法
        new Demo2().get3(cl);
        System.out.println("-----------------");
        //获取全类名
        new Demo2().get4(cl);
    }

}
