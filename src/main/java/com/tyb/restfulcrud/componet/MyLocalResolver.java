package com.tyb.restfulcrud.componet;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Auther: TYB
 * @Date: 2021/2/3 - 02 - 03 - 17:21
 * @Description: springboot-web-restfulcrud - IntelliJ IDEA
 * @Version: 1.0
 */

/**
 *区域信息解析
 */
public class MyLocalResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        Locale locale = Locale.getDefault();
        String language = httpServletRequest.getParameter("language");
        if(StringUtils.hasLength(language)){
            String[] tmp_value = language.split("_");
            locale = new Locale(tmp_value[0], tmp_value[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {}
}