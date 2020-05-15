package com.mobiusvision.qrcode.config;


import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfiguration {

    @Value("${spring.httpclient.connectTimeout}")
    private Integer connectTimeout;//创建连接的最长时间
    @Value("${spring.httpclient.socketTimeout}")
    private Integer socketTimeout;//数据传输的最长时间
    @Value("${spring.httpclient.agent}")
    private String agent;
    @Value("${spring.httpclient.maxPerRoute}")
    private Integer maxPerRoute;//设置每个路由的并发数
    @Value("${spring.httpclient.maxTotal}")
    private Integer maxTotal;//最大连接数


    @Bean
    public HttpClient httpClient() {
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout).build();

        HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig)
                .setUserAgent(agent).setMaxConnPerRoute(maxPerRoute)
                .setConnectionReuseStrategy(new NoConnectionReuseStrategy()).build();
        return httpClient;
    }
}
