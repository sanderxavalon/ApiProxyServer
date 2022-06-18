package com.sanderxavalon.ApiProxyServer;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.net.URIBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest
class ApiProxyServerApplicationTests {

	@Value("${api.url}")
	String apiUrl;


	@Test
	void contextLoads() throws URISyntaxException, IOException {
		URI uri = new URIBuilder(apiUrl).addParameter("q","Taiwan").addParameter("appid","60f9a1a074fc78cf908ae9c00ee6d264").build();
		HttpGet httpGet = new HttpGet(uri);
		log.info(uri.getPath());
		log.info(uri.toURL().toString());
		Content content = Request.get(uri).execute().returnContent();

		JSONObject jsonObject = JSONObject.parseObject(content.asString());
		JSONObject mainObject = jsonObject.getJSONObject("main");

		log.info(mainObject.getBigDecimal("temp").toString());

	}

}
