package Reflect;
/*
用以测试反射功能的类
 */
public class Person {
    private int number;
    String name;
    public int age;

    public Person(int age){
        this.age = age;
    }
    public Person(int number, String name, int age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }
    public Person() {
    }

    public int getNumber(){
        return number;
    }
    private String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
