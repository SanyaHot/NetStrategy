package com.trance.netstrategy.Annotation;

import com.trance.netstrategy.DesignMode.o;

import java.lang.reflect.Field;

/**
 * 注解处理器
 * <p>
 * 其实用的是反射
 */
public class FruitAnnotationProcessor {
    public static void getFruitInfo(Class<?> clazz) {
        String strFruitName = "水果名称：";
        String strFruitColor = "水果颜色：";
        String strFruitProvider = "供应商信息：";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName += fruitName.value();
                o.p(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor += fruitColor.fruitColor();
                o.p(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = strFruitProvider
                        + "\n\t供应商编号：" + fruitProvider.id()
                        + "\n\t供应商名称：" + fruitProvider.name()
                        + "\n\t供应商地址：" + fruitProvider.address();
                o.p(strFruitProvider);
            }
        }
    }
}
