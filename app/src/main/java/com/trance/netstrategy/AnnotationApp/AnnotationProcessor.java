package com.trance.netstrategy.AnnotationApp;

import com.trance.netstrategy.DesignMode.o;

import java.lang.reflect.Method;

import retrofit2.http.GET;

/**
 * 运行时注解处理器
 */
public class AnnotationProcessor {
    public static void main(String[] args) {
        Method[] methods = AnnotationTest.class.getDeclaredMethods();
        for (Method m : methods) {
            GET get = m.getAnnotation(GET.class);
            o.p(get.value());
        }
    }
}
