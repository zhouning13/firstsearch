package com.rubyren.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rubyren.firstsearch.model.LoginInfo;
import com.rubyren.firstsearch.model.TopicDb;
import com.rubyren.firstsearch.service.LoginService;
import com.rubyren.firstsearch.service.SearchService2;

public class SearchServiceTests {
	protected static final Logger log = LoggerFactory.getLogger(SearchServiceTests.class);

	@Test
	public void test() {
		LoginService loginService = new LoginService();
		String url = loginService.login(LoginInfo.FJSFDX);
		SearchService2 searchService = new SearchService2();
		searchService.search(url, TopicDb.WorldCat, "java");
	}
}
