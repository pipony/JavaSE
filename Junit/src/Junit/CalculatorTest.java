package Junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
用以测试Calculator的测试类，注意命名
 */
public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator cc = new Calculator();
        int res = cc.add(1,2);
        Assert.assertEquals(3, res);  //使用Assert来判断正误,arg1是预期结果
    }

    @Test
    public void testSub(){
        Calculator cc = new Calculator();
        int res = cc.sub(1,2);
        Assert.assertEquals(-1, res);  //使用Assert来判断正误,arg2是预期结果
    }

    @Before   //在测试方法之前执行，注意B是大写的
    public void init(){
        System.out.println("init...");
    }

    @After
    public void last(){
        System.out.println("finally..");
    }
}
