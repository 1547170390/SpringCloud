package com.zl.gateway.filter;

import com.zl.gateway.config.AuthProperties;
import com.zl.gateway.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Component
@EnableConfigurationProperties({AuthProperties.class})
public class AuthGlobalFilter implements GlobalFilter {

    @Autowired
    private AuthProperties authProperties;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        //判断是否不需要拦截
        if (isExclude(request.getPath().toString())){
            //无需拦截直接放行
            return chain.filter(exchange);
        }
        //获取请求头中的token
        String token = null;
        List<String> headers = request.getHeaders().get("Authorization");
        if (headers != null && headers.size() > 0) {
            token = headers.get(0);
        }
        //校验并解析token
        String userId = null;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //token 有效
        System.out.println(userId);

        //传递用户信息
        String userInfo = userId.toString();
        ServerWebExchange ex = exchange.mutate()
                .request(b -> b.header("user-info", userInfo)).build();


        return chain.filter(ex);
    }
    private boolean isExclude(String antPath) {
        for (String pathPattern : authProperties.getExcludePaths()) {
            if(antPathMatcher.match(pathPattern, antPath)){
                return true;
            }
        }
        return false;
    }

}
