package Reflect;

import java.lang.reflect.Field;

/*
利用反射操作成员变量
 */
public class Demo3 {
    Class cl;
    public Demo3(Class cl) throws NoSuchFieldException {
        this.cl = cl;
    }
    public void work() throws IllegalAccessException, NoSuchFieldException {
        //选取想要操作的成员变量
        Field fieldNumber = cl.getDeclaredField("number");  //非public
        Field fieldAge = cl.getDeclaredField("age"); //public
        //设置成员变量的值
        Person person = new Person();
        //fieldNumber.set(person, 1);   //因为Person.number是private，所以会报错
        fieldAge.set(person, 12);
        //获取成员变量的值
        //System.out.println("the value of number is: "+fieldNumber.get(person));   //因为Person.number是private，所以会报错
        System.out.println("the value of age is: "+fieldAge.get(person));
        //忽略访问权限修饰符的安全检查：setAccessible
        fieldNumber.setAccessible(true);
        //此时可以了！
        fieldNumber.set(person, 1);
        System.out.println("the value of number is: "+fieldNumber.get(person));
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        new Demo3(Class.forName("Reflect.Person")).work();
    }
}
