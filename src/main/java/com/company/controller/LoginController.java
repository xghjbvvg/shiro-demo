package com.company.controller;

import com.company.domain.User;
import com.company.enums.StatusEnums;
import com.company.util.ResponseCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 14:51
 * @Description:
 */
@RestController
public class LoginController {

    /**
     * 登录操作
     * @param
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseCode login(@RequestParam String username,@RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Subject userSubject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            // 登录验证
            userSubject.login(token);
            return ResponseCode.success();
        } catch (UnknownAccountException e) {
            return ResponseCode.error(StatusEnums.ACCOUNT_UNKNOWN);
        } catch (DisabledAccountException e) {
            return ResponseCode.error(StatusEnums.ACCOUNT_IS_DISABLED);
        } catch (IncorrectCredentialsException e) {
            return ResponseCode.error(StatusEnums.INCORRECT_CREDENTIALS);
        } catch (Throwable e) {
            e.printStackTrace();
            return ResponseCode.error(StatusEnums.SYSTEM_ERROR);
        }
    }


//    @GetMapping("/login")
//    public ResponseCode login() {
//        return ResponseCode.error(StatusEnums.NOT_LOGIN_IN);
//    }

    @GetMapping("/auth")
    public String auth() {
        return "已成功登录";
    }

    @GetMapping("/role")
    @RequiresRoles("vip")
    public ResponseCode role() {
        try {
            // 登录验证
            System.out.println("测试Vip角色");
            return ResponseCode.success();
        } catch (UnknownAccountException e) {
            return ResponseCode.error(StatusEnums.ACCOUNT_UNKNOWN);
        } catch (DisabledAccountException e) {
            return ResponseCode.error(StatusEnums.ACCOUNT_IS_DISABLED);
        } catch (IncorrectCredentialsException e) {
            return ResponseCode.error(StatusEnums.INCORRECT_CREDENTIALS);
        }catch (AuthorizationException e){
            return ResponseCode.error(StatusEnums.PERMISSION_ERROR);
        } catch (Throwable e) {
            e.printStackTrace();
            return ResponseCode.error(StatusEnums.SYSTEM_ERROR);
        }

    }

    @GetMapping("/permission")
    @RequiresPermissions(value = {"add", "update"}, logical = Logical.AND)
    public ResponseCode permission() {

        try {
            // 登录验证
            System.out.println("测试Add和Update权限");
            return ResponseCode.success();
        } catch (UnknownAccountException e) {
            return ResponseCode.error(StatusEnums.ACCOUNT_UNKNOWN);
        } catch (DisabledAccountException e) {
            return ResponseCode.error(StatusEnums.ACCOUNT_IS_DISABLED);
        } catch (IncorrectCredentialsException e) {
            return ResponseCode.error(StatusEnums.INCORRECT_CREDENTIALS);
        } catch (AuthorizationException e){
            return ResponseCode.error(StatusEnums.PERMISSION_ERROR);
        } catch(Throwable e) {
            e.printStackTrace();
            return ResponseCode.error(StatusEnums.SYSTEM_ERROR);
        }
    }

    /**
     * 登出
     * @return
     */
    @GetMapping("/logout")
    public ResponseCode logout() {
      //  getSubject().logout();
        return ResponseCode.success();
    }


    /**
     * 登出
     *
     * @return
     */
    @RequestMapping("/unauth")
    public ResponseCode unauth() {
        //  getSubject().logout();
        return ResponseCode.error(StatusEnums.PERMISSION_ERROR);

    }
}
