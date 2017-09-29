package com.github.paweladamski.condition;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;
import org.hamcrest.Matcher;

public class HostCondition implements Condition {

    private final String url;

    public HostCondition(String url) {
        this.url = url;
    }

    @Override
    public boolean matches(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        String path = httpRequest.getRequestLine().getUri().replaceAll("[\\?#].*", "");
        return path.equals(url);
    }


}
