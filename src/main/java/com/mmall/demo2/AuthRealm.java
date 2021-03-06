package com.mmall.demo2;

import com.mmall.demo2.model.Permission;
import com.mmall.demo2.model.Role;
import com.mmall.demo2.model.User;
import com.mmall.demo2.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User) principal.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new ArrayList<>();
        List<String> roleList = new ArrayList<>();
        Set<Role> roleSet =user.getRoles();
        if(CollectionUtils.isNotEmpty(roleSet)){
            for(Role role:roleSet){
                roleList.add(role.getRname());
                Set<Permission> permissions = role.getPermissions();
                if(CollectionUtils.isNotEmpty(permissions)){
                    for(Permission permission : permissions){
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        info.addRoles(roleList);
        return info;
    }

    //认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken =(UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = userService.findUserByUserName(username);
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
