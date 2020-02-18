package com.mmall.demo2;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
//自定义密码校验规则

public class CredentialMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //相当于从session中拿出密码
        String password = new String(usernamePasswordToken.getPassword());
        //从数据库中拿出密码
        String dbPassword = (String) info.getCredentials();
        return this.equals(password,dbPassword);
    }
}
