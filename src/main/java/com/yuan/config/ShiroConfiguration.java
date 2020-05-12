package com.yuan.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {


    /**
     * 自定义shiro拦截器
     * 自定义URL，权限从上到下
     * 1. anon 匿名访问，无需登录
     * 2. anthc 登陆后才能访问
     * 3. logout 登出
     * 4. roles 觉得过滤器
     * <p>
     * URL匹配风格
     * 1）. ？:匹配一个字符
     * 2）. *:匹配零或者多个字符串
     * 3）. **:匹配零个或者多个路径
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/static/**", "anon");//允许匿名访问静态资源
        filterChainDefinitionMap.put("/user/subLogin", "anon");//允许匿名访问登录页
        filterChainDefinitionMap.put("/user/hello", "anon");
        filterChainDefinitionMap.put("/logout", "logout");//登出
        filterChainDefinitionMap.put("/**", "authc");//拦截所有路径
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        shiroFilterFactoryBean.setLoginUrl("/login.html");//设置登陆请求
        return shiroFilterFactoryBean;
    }

    //配置shiro的生命周期
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    //配置Realm
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }

    //配置SecurityManager,安全管理器，shiro的核心
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        return securityManager;
    }


    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1);
        return hashedCredentialsMatcher;
    }

}
