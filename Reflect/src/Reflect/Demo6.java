package Reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
完成一个综合需求：写一个"框架"，不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中任意方法
途径：反射，配置文件
 */
public class Demo6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.根据需要完成配置文件pro.properties
        //2.读取配置文件
        //2.1 创建Properties对象
        Properties pro = new Properties();
        //2.2 获取配置文件内容
        ClassLoader cr = Reflect.Demo6.class.getClassLoader();
        InputStream is = cr.getResourceAsStream("pro.properties");
        pro.load(is);
        //3.读取类名和类方法
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //4.利用反射加载类，新建类，并执行相应的类方法
        Class cl = Class.forName(className);
        Constructor constructor = cl.getDeclaredConstructor(int.class, String.class, int.class);
        Person person = (Person) constructor.newInstance(1,"cindy", 25);
        Method md = cl.getDeclaredMethod(methodName);
        md.setAccessible(true);
        String res = (String) md.invoke(person);
        System.out.println("result is: "+res);
    }
}
