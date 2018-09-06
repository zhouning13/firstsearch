package com.rubyren.firstsearch.feign;

import java.util.Map;

import org.springframework.web.bind.annotation.ResponseBody;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

public interface LoginRest {

	@RequestLine("POST /WebZ/FSLogin?sessionid=0")
	@Headers({ "Content-Type: application/x-www-form-urlencoded",
			"User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36" })
	@ResponseBody
	public String login(@QueryMap Map<String, String> obj);
}
