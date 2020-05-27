package com.mt.user.config;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        /*
         * 添加内置过滤器
         * anon:无需认证
         * authc:需要认证
         * user: 记住我时
         * perms:拥有资源权限
         * role:拥有角色权限
         * */
//        Map<String,String> map = new LinkedHashMap<>();
        //授权
//        map.put("/user/add", "perms[user:add]");
        //认证
//        map.put("/user/*","authc");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
//        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        return shiroFilterFactoryBean;
    }

    //DafaultWebSecurityManager
    @Bean("securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    //realm,自定义
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

   /* @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }*/
}
