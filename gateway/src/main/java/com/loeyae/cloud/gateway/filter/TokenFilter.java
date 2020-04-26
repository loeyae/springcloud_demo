package com.loeyae.cloud.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * TokenFilter
 *
 * @author ZhangYi<loeyae @ gmail.com>
 * @version 1.0
 * @date 2020/4/26 17:50
 */
@Slf4j
public class TokenFilter implements GlobalFilter, Ordered {

    Logger logger= LoggerFactory.getLogger( TokenFilter.class );

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null || token.isEmpty()) {
            return message(exchange.getResponse(), "Token is Null");
        }
        //@TODO token校验
        return chain.filter(exchange);
    }
    /**
     * 认证错误输出
     * @param resp 响应对象
     * @param message 错误信息
     * @return
     */
    private Mono<Void> message(ServerHttpResponse resp, String message) {
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type","application/json;charset=UTF-8");
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpStatus.UNAUTHORIZED.value());
        map.put("msg", message);
        DataBuffer buffer = resp.bufferFactory().wrap(JSONObject.toJSONString(map).getBytes(StandardCharsets.UTF_8));
        return resp.writeWith(Flux.just(buffer));
    }

    /**
     * getOrder
     *
     * @return int
     */
    @Override
    public int getOrder() {
        return -100;
    }
}
