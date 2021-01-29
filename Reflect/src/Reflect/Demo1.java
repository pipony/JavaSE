package Reflect;
/*
 利用反射，获得类对象（三种方法）。
 值得注意的是，返回值是Class类型。
 */
public class Demo1 {

    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName("xxx");
        Class cl1 = Class.forName("Reflect.Person");
        //2.xxx.class   属性
        Class cl2 = Reflect.Person.class;
        //3.Object.getClass()
        Class cl3 = new Reflect.Person().getClass();

        //输出一个看看
        System.out.println(cl1);

        //测试它们的相等性
        System.out.println(cl1==cl2);
        System.out.println(cl2==cl3);
        //三个都相等，结论：class只能被加载一次
    }

}
