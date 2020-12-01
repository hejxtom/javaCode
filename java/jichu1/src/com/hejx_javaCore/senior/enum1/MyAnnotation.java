package com.hejx_javaCore.senior.enum1;


import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

/**
 * @Classname MyAnnotation
 * @Description TODO
 * @Date 2020/10/13 16:46
 * @Created by hejx
 */
@Inherited
@Repeatable(MyAnnotations.class)   ////jdk8的重复注解实现
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hello";



}
