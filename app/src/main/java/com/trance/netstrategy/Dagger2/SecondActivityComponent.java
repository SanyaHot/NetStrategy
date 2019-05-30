package com.trance.netstrategy.Dagger2;

import com.trance.netstrategy.SecondActivity;

import javax.inject.Singleton;

import dagger.Component;

//@Component

/**
 * Gson 在 MainActivity 中是单例，如果再创建一个 SecondActivity，
 * SecondActivity 创建的Gson 的内存地址和 MainActivity 创建的 Gson 的内存地址是不同的。
 * 因为 Gson 只是保证在MainActivityComponent中是单例的，我们创建SecondActivity，就会重新创建一个Component，
 * 这样只能保证Gson是局部单例（MainActivity中）。如果想要实现全局单例，就需要保证对应的Component只有一个实例
 *
 * 其实就是用@Scope 标识的注解。为了使 Gson 变为全局单例，我们可以用@Scope 结合Application来实现。
 * 当然也可以用@Singleton结合Application来实现，只是用@Scope可以自定义注解名称，这更灵活一些。先来定义@ApplicationScope注解
 */

//@Singleton
//@Component(modules = {GsonModule.class,EngineModule.class})
//public interface SecondActivityComponent {
//    void inject(SecondActivity activity);
//}
