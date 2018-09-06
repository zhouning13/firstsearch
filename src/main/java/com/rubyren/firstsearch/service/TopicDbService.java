package com.rubyren.firstsearch.service;

import java.util.Random;

import com.rubyren.firstsearch.model.TopicDb;

public class TopicDbService {

	private TopicDb[] topicDbs = TopicDb.values();

	public TopicDb random() {
		int index = new Random().nextInt(200);
		if (index < topicDbs.length) {
			return topicDbs[index];
		} else {
			return TopicDb.WorldCat;
		}
	}
}
