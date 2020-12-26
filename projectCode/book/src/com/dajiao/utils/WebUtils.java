package com.dajiao.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.Cookie;
import java.util.Map;

/**
 * @program: javawebExecise
 * @description:封装表单数据到相关的类中
 * @author: Mr.Yu
 * @create: 2020-11-16 21:49
 **/
public class WebUtils {

    /**
     * @Description: 封装表单数据到相关的类中
     * @Param: [map：这里可以传入request.getParameterMap()，但是为了可以让Dao层和Service层也可使用，传进map，增加了代码的耦合性, bean：具体的实体类]
     * @return: T
     * @Author: Mr.Yu
     * @Date: 2020/11/16
     */
    public static <T> T copyParamToBean(Map map, T bean){
        try {
            BeanUtils.populate(bean, map);
            System.out.println(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    public static int parseInt(String str, Integer defaultNum){
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultNum;
    }

    public static Cookie getCookie(String key, Cookie[] cookies) {

        if (key == null || cookies == null || cookies.length == 0 ) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (key.equals(cookie.getValue())) {
                return cookie;
            }
        }
        return  null;
    }

}
