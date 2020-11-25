package com.github.thestyleofme.autodeliver.autoconfiguration;

import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

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

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        OAuth2Authentication oAuth2Authentication = super.extractAuthentication(map);
        // 将map放入认证对象中
        oAuth2Authentication.setDetails(map);
        return oAuth2Authentication;
    }
}
