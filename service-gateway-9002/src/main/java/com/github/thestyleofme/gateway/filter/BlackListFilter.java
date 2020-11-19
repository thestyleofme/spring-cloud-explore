package com.github.thestyleofme.gateway.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 自定义全局过滤器实现IP访问控制即黑白名单
 * </p>
 *
 * @author isaac 2020/11/20 1:56
 * @since 1.0.0
 */
@Slf4j
// @Component 让容器扫描到，等同于注册了
public class BlackListFilter implements GlobalFilter, Ordered {

    /**
     * 模拟黑名单（实际可以去数据库或者redis中查询）
     */
    private static final List<String> BLACK_LIST = new ArrayList<>();

    static {
        // 模拟本机地址
        BLACK_LIST.add("0:0:0:0:0:0:0:1");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 思路：获取客户端ip，判断是否在黑名单中，在的话就拒绝访问，不在的话就放行
        // 从上下文中取出request和response对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        // 从request对象中获取客户端ip
        String clientIp = Objects.requireNonNull(request.getRemoteAddress()).getHostString();
        // 拿着clientIp去黑名单中查询，存在的话就决绝访问
        if (BLACK_LIST.contains(clientIp)) {
            // 决绝访问，返回
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            log.debug("=====> IP: [{}] in the blacklist, access will be denied!", clientIp);
            String data = "Request be denied!";
            DataBuffer wrap = response.bufferFactory().wrap(data.getBytes());
            return response.writeWith(Mono.just(wrap));
        }
        // 合法请求，放行，执行后续的过滤器
        return chain.filter(exchange);
    }

    /**
     * 返回值表示当前过滤器的顺序(优先级)，数值越小，优先级越高
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
