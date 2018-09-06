package com.rubyren.service;

import java.util.Random;

import org.junit.Test;

import com.rubyren.firstsearch.model.TopicDb;

public class TopicDbServiceTest {
	@Test
	public void testLength() {
		TopicDb[] topicDbs = TopicDb.values();
		for (int i = 0; i < 100000; i++) {

			TopicDb t = null;
			int index = new Random().nextInt(200);
			if (index < topicDbs.length) {
				t = topicDbs[index];
			} else {
				t = TopicDb.WorldCat;
			}
			System.out.println(t);
		}
	}
}
