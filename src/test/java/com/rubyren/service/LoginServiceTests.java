package com.rubyren.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rubyren.firstsearch.model.LoginInfo;
import com.rubyren.firstsearch.service.LoginService;

public class LoginServiceTests {
	protected static final Logger log = LoggerFactory.getLogger(LoginServiceTests.class);

	@Test
	public void testRandom() {
		LoginService loginService = new LoginService();
		loginService.random();
	}

	@Test
	public void testLogin() {
		LoginService loginService = new LoginService();
		loginService.login(LoginInfo.FJSFDX);
	}

	@Test
	public void testAllAccount() {
		LoginService loginService = new LoginService();

		for (LoginInfo li : LoginInfo.values()) {
			String s = loginService.login(li);
			if (s == null) {
				log.warn("返回空！");
			}
		}
	}
}
