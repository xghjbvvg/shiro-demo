package com.company.config;

import com.company.util.AuthRealm;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 13:54
 * @Description:
 */
@Configuration
public class ShiroConfig {
    /**
     * 配置shiro过滤器
     * @author zhengkai
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        //1.定义shiroFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //2.设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //3.LinkedHashMap是有序的，进行顺序拦截器配置
        Map<String,String> filterChainMap = new LinkedHashMap<String,String>();
        //4.配置logout过滤器
        filterChainMap.put("/logout", "logout");
        //5.所有url必须通过认证才可以访问
        filterChainMap.put("/**","authc");
        //6.设置默认登录的url
        shiroFilterFactoryBean.setLoginUrl("/login");
        //7.设置成功之后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //8.设置未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
        //9.设置shiroFilterFactoryBean的FilterChainDefinitionMap
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }
    /**
     * 自定义身份认证Realm（包含用户名密码校验，权限校验等）
     * @return
     */
    @Bean
    public AuthRealm authRealm() {
        return new AuthRealm();
    }

    /**
     * Session Manager：会话管理
     * 即用户登录后就是一次会话，在没有退出之前，它的所有信息都在会话中；
     * 会话可以是普通JavaSE环境的，也可以是如Web环境的；
     */
    @Bean("sessionManager")
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        // 去掉shiro登录时url里的JSESSIONID
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }




    /**
     * 开启Shiro注解模式，可以在Controller中的方法上添加注解
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }



}