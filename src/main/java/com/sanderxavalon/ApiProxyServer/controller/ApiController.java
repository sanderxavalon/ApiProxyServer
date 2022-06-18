package com.sanderxavalon.ApiProxyServer.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Slf4j
@RestController
public class ApiController {

    @Value("${api.url}")
    String apiUrl;

    @Value("${api.key}")
    String apiKey;

    @RequestMapping(path = "/api", method = RequestMethod.POST)
    public String apiRequest(@RequestBody Map<String, String> location) throws URISyntaxException {
        log.info(location.get("location"));

        URI uri = new URIBuilder(apiUrl)
                .addParameter("q", "Taiwan")
                .addParameter("appid", apiKey).build();

        return null;
    }
}
