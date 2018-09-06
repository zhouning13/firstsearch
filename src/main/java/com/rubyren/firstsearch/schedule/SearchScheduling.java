package com.rubyren.firstsearch.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rubyren.firstsearch.model.LoginInfo;
import com.rubyren.firstsearch.model.TopicDb;
import com.rubyren.firstsearch.service.LoginService;
import com.rubyren.firstsearch.service.SearchService2;
import com.rubyren.firstsearch.service.TopicDbService;

@Component
public class SearchScheduling {
	protected static final Logger log = LoggerFactory.getLogger(SearchScheduling.class);

	@Scheduled(initialDelay = 6000, fixedDelay = 1000 * 60 * 2)
	public void schedule() {

		LoginService loginService = new LoginService();
		LoginInfo loginInfo = loginService.random();
		String url = loginService.login(loginInfo);

		TopicDb topicDb = new TopicDbService().random();
		SearchService2 searchService = new SearchService2();
		searchService.search(url, topicDb, "java");
		log.info("登陆 {} 并检索 {}", loginInfo.getName(), topicDb.name());
	}
}
