package com.github.thestyleofme.autodeliver.autoconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * <p>
 * EnableResourceServer 开启资源服务器功能
 * EnableWebSecurity 开启web访问安全
 * </p>
 *
 * @author isaac 2020/11/26 0:26
 * @since 1.0.0
 */
@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    /**
     * 该方法用于定义资源服务器向远程认证服务器发起请求，进行token校验等事宜
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // 设置当前资源服务的资源id
        resources.resourceId("autodeliver");
        // 定义token服务对象（token校验就应该靠token服务对象）
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        // 校验端点/接口设置
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:9999/oauth/check_token");
        // 携带客户端id和客户端安全码
        remoteTokenServices.setClientId("c1");
        remoteTokenServices.setClientSecret("secret");

        // 别忘了这一步
        resources.tokenServices(remoteTokenServices);
    }

    /**
     * 场景：一个服务中可能有很多资源（API接口）
     * 某一些API接口，需要先认证，才能访问
     * 某一些API接口，压根就不需要认证，本来就是对外开放的接口
     * 我们就需要对不同特点的接口区分对待（在当前configure方法中完成），设置是否需要经过认证
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                // 设置session的创建策略（根据需要创建即可）
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authorizeRequests()
                // autodeliver为前缀的请求需要认证
                .antMatchers("/autodeliver/**").authenticated()
                // demo为前缀的请求需要认证
                .antMatchers("/demo/**").authenticated()
                // 其他请求不认证
                .anyRequest().permitAll();
    }
}
