package com.spring.componet;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 区域信息解析器
 * 为视图提供不同语言支持
 */
public class MyLocaleResolver implements LocaleResolver {
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String lan = request.getParameter("lan");
		// 如果没有设置，则获取浏览器默认的设置
		Locale locale = Locale.getDefault();
		// StringUtils为springFrameWork的帮助类
		if(!StringUtils.isEmpty(lan)){
			String[] strings = lan.split("_");
			locale = new Locale(strings[0],strings[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

	}
}
