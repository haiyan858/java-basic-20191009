package com.myself1009;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cuihaiyan
 * @Create_Time 2019-10-09 09:37
 */
public class CatTest {

    @Test
    public void test(){
        String x = "string";
        String y = "string";
        String z = new String("string");
        System.out.println(x==y); // true
        System.out.println(x==z); // false
        System.out.println(x.equals(y)); // true
        System.out.println(x.equals(z)); // true

        Integer i = 1;
        Integer j = 1;
        System.out.println(i.equals(j));
    }

    @Test
    public void test1(){
        Cat c1 = new Cat("王磊");
        Cat c2 = new Cat("王磊");
        System.out.println(c1.equals(c2)); // false
        System.out.println(c1 == c2); //false
    }

    /**
     * 重写equals方法
     */
    @Test
    public void test2(){
        Cat2 c1 = new Cat2("王磊");
        Cat2 c2 = new Cat2("王磊");
        System.out.println(c1.equals(c2)); // true
        System.out.println(c1 == c2); //false
    }

    /**
     * 代码解读：很显然“通话”和“重地”的 hashCode() 相同，然而 equals() 则为 false，
     * 因为在散列表中，hashCode()相等即两个键值对的哈希值相等，然而哈希值相等，并不一定能得出键值对相等。
     */
    @Test
    public void test3(){
        String str1 = "通话";
        String str2 = "重地";
        System.out.println(String.format("str1：%d | str2：%d", str1.hashCode(),str2.hashCode()));
        System.out.println(str1.equals(str2));

        Map<String,String> map = new HashMap<>();
        map.put(str1,"v1");
        map.put(str2,"v2");

        System.out.println(map.get(str1)); // v1
        System.out.println(map.get(str2)); // v2
    }


    @Test
    public void test4(){
        int a = 10;
        int b = 10;
        System.out.print("基本类型a==b:");
        System.out.println(a == b);
        System.out.println("-----"); //true

        String s1 = "abc";
        String s2 = "abc";
        System.out.print("String类型是s1==s2:");
        System.out.println(s1 == s2);//true
        System.out.println("-----");

        String s3 = new String("abc");
        String s4 = new String("abc");//可以看出==比较的是栈的地址是否相同
        System.out.print("String类型用new String()是s1==s2:");
        System.out.println(s3 == s4); //false
        System.out.println(s1 == s3); //false
        System.out.println("-----");

        Integer i1 = 1;
        Integer i2 = 1;
        System.out.print("包装类型是i1==i2:");
        System.out.println(i1 == i2); //true
        System.out.println("-----");

        //(-128,127)会有缓存
        Integer i3 = 128;
        Integer i4 = 128;//此时输出false是因为Integer在(-128,127)之间会缓存，超出这个范围就不会缓存了
        System.out.print("包装类型是i3==i4:");
        System.out.println(i3 == i4); //false
        System.out.println("-----");

        Integer i5 = new Integer("1");
        Integer i6 = new Integer("1");
        System.out.print("包装类型用new Integer()是i5==i6:");
        System.out.println(i5 == i6);//用new Integer()多少都不会缓存 //false
        System.out.println("-----");

        A a1 = new A(1);
        A a2 = new A(1);
        A a3 = a2;
        System.out.print("普通引用类型a1 == a2：");
        System.out.println(a1 == a2); //false
        System.out.println(a2 == a3);//对象赋给新对象连地址都是相同的 //true
        System.out.println("-----");
    }



    @Test
    public void test5(){
        System.out.println("基本类型没有equals方法");
        System.out.println("-----");

        String s1 = "abc";
        String s2 = "abc";
        System.out.print("String类型的equals方法:");
        System.out.println(s1.equals(s2)); //true
        System.out.println("-----");

        String s3 = new String("abc");
        String s4 = new String("abc");//可以看出比较equals方法比较的是堆里的值是否相同
        System.out.print("String类型的new String()的equals方法：");
        System.out.println(s3.equals(s4)); //true
        System.out.println("-----");

        System.out.print("String用==赋值和用new String()赋值的比较：");
        System.out.println(s1.equals(s3)); //true
        System.out.println("-----");

        Integer i1 = 1;
        Integer i2 = 1;
        System.out.print("包装类的equals方法：");
        System.out.println(i1.equals(i2)); //true
        System.out.println("-----");

        Integer i3 = new Integer(1);
        Integer i4 = new Integer(1);
        System.out.print("包装类的new Integer()用equals方法：");
        System.out.println(i3.equals(i4)); //true
        System.out.println("-----");

        System.out.print("Integer用==赋值和用new Integer()赋值的比较：");
        System.out.println(i1.equals(i3)); //true
        System.out.println("-----");
    }


    @Test
    public void test6(){
        Student s1 = new Student("阿坤",21);
        Student s2 = new Student("阿坤",21);
        Student s3 = new Student();
        Student s4 = new Student();
        Student s5 = s1;
        System.out.print("普通类对象的==非默认构造：");
        System.out.println(s1 == s2); //false
        System.out.println(s1 == s5); //true
        System.out.println("-----");

        System.out.print("普通类对象的equals非默认构造：");
        System.out.println(s1.equals(s2)); //false
        System.out.println(s1.equals(s5)); //true
        System.out.println("-----");

        System.out.print("普通类对象的==默认构造：");
        System.out.println(s3 == s4); //false
        System.out.println("-----");

        System.out.print("普通类对象的equals默认构造：");
        System.out.println(s3.equals(s4)); //false
        System.out.println("-----");

        System.out.print("对普通对象的属性进行比较equals：");
        System.out.println(s1.name.equals(s2.name)); //true
        System.out.print("对普通对象的属性进行比较==：");

        System.out.println(s1.name);
        System.out.println(s2.name);
        System.out.println(s1.name == s2.name); //true
    }
}
