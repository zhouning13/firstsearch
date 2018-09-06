package com.rubyren.firstsearch.feign;

import java.util.Map;

import org.springframework.web.bind.annotation.ResponseBody;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

public interface SearchRest {

	@RequestLine("POST /WebZ/FSHome?next=html/home.html:bad=html/home.html:sessionid={sessionid}:entitypagenum=1:0")
	@Headers({ "Content-Type: application/x-www-form-urlencoded",
			"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36",
			"Upgrade-Insecure-Requests: 1" })
	@ResponseBody
	public String search(@Param("sessionid") String sessionid, @QueryMap Map<String, String> obj);
}
