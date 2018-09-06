package com.rubyren.firstsearch.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rubyren.firstsearch.model.TopicDb;

public class SearchService2 {
	protected static final Logger log = LoggerFactory.getLogger(SearchService2.class);

	public void search(String url, TopicDb TopicDb, String keyword) {
		try {
			Map<String, String> params = new HashMap<>();
			params.put("termqs", keyword);
			params.put("topicdb", TopicDb.name());
			params.put("action", "Search");

			@SuppressWarnings("unused")
			Document doc = Jsoup.connect("http://firstsearch.oclc.org" + url).data(params).post();
		} catch (IOException e) {
			log.error("网络异常", e);
		}
	}
}
