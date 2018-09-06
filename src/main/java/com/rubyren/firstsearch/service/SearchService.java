package com.rubyren.firstsearch.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rubyren.firstsearch.feign.SearchRest;

import feign.Feign;
import feign.FeignException;
import feign.Logger.JavaLogger;
import feign.Logger.Level;
import feign.codec.StringDecoder;
import feign.form.FormEncoder;
import feign.jackson.JacksonEncoder;

public class SearchService {
	protected static final Logger log = LoggerFactory.getLogger(SearchService.class);

	public void search(String url, String keyword) {
		log.debug("检索 {} 开始", keyword);

		SearchRest searchRest = Feign.builder().logLevel(Level.FULL).logger(new JavaLogger())
				// 定义request内容处理方式
				.encoder(new FormEncoder(new JacksonEncoder()))
				// 定义response内容处理方式
				.decoder(new StringDecoder())
				// 接口类和地址绑定
				.target(SearchRest.class, "http://firstsearch.oclc.org/");

		Map<String, String> params = new HashMap<>();
		params.put("termqs", keyword);
		params.put("topicdb", "ECO");
		params.put("action", "Search");

		String result = null;
		try {
			result = searchRest.search(url.substring(62, 90), params);
			log.debug("检索成功，结果为 ：{} ", result);
		} catch (FeignException e) {
			// TODO Auto-generated catch block
			log.debug("检索失败 ");
		}

	}
}
