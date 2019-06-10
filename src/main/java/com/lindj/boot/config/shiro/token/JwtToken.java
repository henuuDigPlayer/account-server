package com.lindj.boot.config.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author lindj
 * @date 2019/5/29 0029
 * @description
 */
public class JwtToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
