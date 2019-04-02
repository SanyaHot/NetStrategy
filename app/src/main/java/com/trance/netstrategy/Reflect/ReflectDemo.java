package com.trance.netstrategy.Reflect;

import com.trance.netstrategy.DesignMode.o;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        ReflectDemo reflectDemo = new ReflectDemo();
        reflectDemo.getClassName();
        reflectDemo.getClassMethod();
        reflectDemo.getMethods();
        reflectDemo.getField();
        reflectDemo.getFields();
        reflectDemo.getConstructor();
        reflectDemo.getConstructors();
        reflectDemo.reflectEX();
    }

    public void getClassName() throws ClassNotFoundException {
        //第一种：Class c1 = Code.class
        Class c1 = ReflectDemo.class;
        o.p(c1.getName());

        //第二种：Class c2 = code1.getClass()
        ReflectDemo reflectDemo = new ReflectDemo();
        Class c2 = reflectDemo.getClass();
        o.p(c2.getName());

        //第三种：Class c3 = Class.forName("com.trance.Code")
        Class c3 = Class.forName("com.trance.netstrategy.Reflect.ReflectDemo");
        o.p(c3.getName());
    }

    public void getClassMethod() {
        try {
            Class c = Class.forName("com.trance.netstrategy.Reflect.Person");
            Object o = c.newInstance();
            Method method = c.getMethod("fun", String.class, int.class);
            method.invoke(o, "wsf", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMethods() {
        try {
            Class c = Class.forName("com.trance.netstrategy.Reflect.Person");
            Method[] methods1 = c.getDeclaredMethods();      //获取该类的所有方法，不包括父类的
            Method[] methods2 = c.getMethods();             //获取该类的所有public方法，包括父类的
            for (Method method : methods1) {
                o.p(method.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getField() {
        try {
            Class c = Class.forName("com.trance.netstrategy.Reflect.Person");
            //获取成员变量
            Field field = c.getDeclaredField("msg");    //因为msg是私有的，所以不能用getField方法
            Object obj = c.newInstance();
            field.setAccessible(true);  //设置是否允许访问，因为该变量是私有的，所以需手动设置。如果msg是public的就不需要这行了
            Object msg = field.get(obj);
            o.p(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getFields() {
        try {
            Class c = Class.forName("com.trance.netstrategy.Reflect.Person");
//            Field[] fields = c.getFields();     //获取public属性
            Field[] fields = c.getDeclaredFields();     //获取public属性
            for (Field field : fields) {
                o.p(field.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getConstructor() {
        try {
            Class c = Class.forName("com.trance.netstrategy.Reflect.Person");
            Constructor constructor = c.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            constructor.newInstance("wsf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getConstructors() {
        try {
            Class c = Class.forName("com.trance.netstrategy.Reflect.Person");
            Constructor[] constructors = c.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                o.p(constructor);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void reflectEX() {
        List list1 = new ArrayList(); // 没有泛型
        List<String> list2 = new ArrayList<String>(); // 有泛型


        /*
         * 1.首先观察正常添加元素方式，在编译器检查泛型，
         * 这个时候如果list2添加int类型会报错
         */
        list2.add("hello");
//      list2.add(20); // 报错！list2有泛型限制，只能添加String，添加int报错
        System.out.println("list2的长度是：" + list2.size()); // 此时list2长度为1


        /*
         * 2.然后通过反射添加元素方式，在运行期动态加载类，首先得到list1和list2
         * 的类类型相同，然后再通过方法反射绕过编译器来调用add方法，看能否插入int
         * 型的元素
         */
        Class c1 = list1.getClass();
        Class c2 = list2.getClass();
        System.out.println(c1 == c2); // 结果：true，说明类类型完全相同

        // 验证：我们可以通过方法的反射来给list2添加元素，这样可以绕过编译检查
        try {
            Method m = c2.getMethod("add", Object.class); // 通过方法反射得到add方法
            m.invoke(list2, 20); // 给list2添加一个int型的，上面显示在编译器是会报错的
            System.out.println("list2的长度是：" + list2.size()); // 结果：2，说明list2长度增加了，并没有泛型检查
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Object obj :
                list2) {
            o.p(obj);
        }

        /*
         * 综上可以看出，在编译器的时候，泛型会限制集合内元素类型保持一致，但是编译器结束进入
         * 运行期以后，泛型就不再起作用了，即使是不同类型的元素也可以插入集合。
         */
    }
}
