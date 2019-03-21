package com.shengxi.xxwork.utils.eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 *需要使用eventbus的activit和Fragment都需要以注解的方式绑定到此
 * 注解类
 *
 * 使用时需要在activity或fragment类前添加注解@BindEventBus
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindEventBus {
}