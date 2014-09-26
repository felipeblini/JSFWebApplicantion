/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdmobile.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author blini
 */
 
public class BeanFactory {
 
    private static ClassPathXmlApplicationContext ctx;
 
    static {
        ctx = new ClassPathXmlApplicationContext("com/crowdmobile/config/spring.xml");
    }
 
    private BeanFactory() {
    }
 
    public static Object getBean(String beanName) {
        return ctx.getBean(beanName);
    }
 
    public static Object getBean(String beanName, Class classe) {
        return ctx.getBean(beanName, classe);
    }
}