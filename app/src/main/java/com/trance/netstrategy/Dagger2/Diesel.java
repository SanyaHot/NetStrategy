package com.trance.netstrategy.Dagger2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;


/**
 * 1.@Named也可以用@Qualifier来实现
 * 2.@Named传递的值只能是字符串
 * 而@Qualifier则更灵活一些，@Qualifier不是直接标记在属性上的，而是用来自定义注解的
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Diesel {

}
