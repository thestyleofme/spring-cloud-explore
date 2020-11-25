package com.github.thestyleofme.oauth.autoconfiguration;

import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/26 2:44
 * @since 1.0.0
 */
@Component
public class CusAccessTokenConverter extends DefaultAccessTokenConverter {

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        Map<String, Object> map = (Map<String, Object>) super.convertAccessToken(token, authentication);
        // 获取到request对象
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (Objects.nonNull(requestAttributes)) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            // 获取客户端ip（注意：如果是经过代理之后到达当前服务的话，那么这种方式获取的并不是真实的浏览器客户端ip）
            String remoteAddr = request.getRemoteAddr();
            map.put("clientIp", remoteAddr);
        }
        return map;
    }
}
