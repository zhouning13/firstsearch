package com.rubyren.firstsearch.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rubyren.firstsearch.feign.LoginRest;
import com.rubyren.firstsearch.model.LoginInfo;

import feign.Feign;
import feign.codec.StringDecoder;
import feign.form.FormEncoder;
import feign.jackson.JacksonEncoder;

public class LoginService {
	protected static final Logger log = LoggerFactory.getLogger(LoginService.class);

	public LoginInfo random() {
		LoginInfo[] loginInfos = LoginInfo.values();
		int index = new Random().nextInt(loginInfos.length - 1);
		return loginInfos[index];
	}

	public String login(LoginInfo loginInfo) {
		log.debug("作为 {} 登陆", loginInfo.getName());
		LoginRest loginRest = Feign.builder()
				// 定义request内容处理方式
				.encoder(new FormEncoder(new JacksonEncoder()))
				// 定义response内容处理方式
				.decoder(new StringDecoder())
				// 接口类和地址绑定
				.target(LoginRest.class, "http://firstsearch.oclc.org/");

		Map<String, String> params = new HashMap<>();
		params.put("autho", loginInfo.getAuth());
		params.put("password", loginInfo.getPassword());
		params.put("language", "zs");
		params.put("next", "html/home.html");
		params.put("bad", "error/badlogin_zs.html");
		params.put("entityjavascript", "true");
		params.put("entityscreensize", "large");

		String searchUrl;
		String result = null;
		try {
			result = loginRest.login(params);
			Document doc = Jsoup.parse(result);
			Element form = doc.selectFirst("form[name=main]");
			searchUrl = form.attr("action");
		} catch (Exception e) {
			if (result == null) {
				log.debug("登陆 {} 失败，无响应信息", loginInfo.getName());
				return null;
			}
			log.debug("登陆 {} 失败 <a href=\"#\">查看失败记录</a> ", loginInfo.getName());
			return null;
		}

		log.debug("登陆 {} 成功  ", loginInfo.getName());
		return searchUrl;
	}
}
