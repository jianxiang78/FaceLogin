package com.auto17.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.auto17.base.domain.AjaxResult;
import com.auto17.base.security.JWTUtils;
import com.auto17.base.utils.DateUtils;
import com.auto17.faceLogin.domain.AppUser;
import com.auto17.faceLogin.service.IAppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Login Controller
 *
 * @author jianxiang sun
 */

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController
{
    protected final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IAppUserService appUserService;

    @PostMapping("/signUp")
    public AjaxResult signUp(@RequestBody JSONObject userInfo) {
        if(!userInfo.containsKey("facialId") || userInfo.getString("facialId")==null){
            return AjaxResult.error("signUp fail");
        }
        AppUser user=new AppUser();
        user.setFacialId(userInfo.getString("facialId"));
        user=appUserService.selectAppUserOne(user);
        JSONObject objectDetails=userInfo.getJSONObject("details");
        String timestamp=userInfo.getString("timestamp");

        AppUser userNew=new AppUser();
        if(user==null){
            userNew.setFacialId(userInfo.getString("facialId"));
            userNew.setUserAge(objectDetails.getIntValue("age"));
            userNew.setUserGender(objectDetails.getString("gender"));
            userNew.setRegTime(DateUtils.dateTime("yyyy-MM-dd'T'HH:mm:ss",timestamp));
            userNew.setLastLoginTime(DateUtils.getNowDate());
            appUserService.insertAppUser(userNew);
            logger.info("user registration completed");
            JSONObject object=new JSONObject();
            object.put("Authorization",JWTUtils.getToken(userNew));
            return AjaxResult.success(object);
        }else {
            return AjaxResult.error("signUp fail. The user has already registered");
        }
    }


    @PostMapping("/signIn")
    public AjaxResult signIn(@RequestBody JSONObject userInfo) {
        if(!userInfo.containsKey("facialId") || userInfo.getString("facialId")==null){
            return AjaxResult.error("signIn fail");
        }
        AppUser user=new AppUser();
        user.setFacialId(userInfo.getString("facialId"));
        user=appUserService.selectAppUserOne(user);
        if(user==null){
            logger.info("user signIn fail");
            return AjaxResult.error("signIn fail, need reg");
        }else {
            AppUser userUp=new AppUser();
            userUp.setUserId(user.getUserId());
            userUp.setLastLoginTime(DateUtils.getNowDate());
            appUserService.updateAppUser(userUp);
            logger.info("user ["+user.getUserTrueName()+"] login success");
            JSONObject object=new JSONObject();
            object.put("Authorization",JWTUtils.getToken(user));
            object.put("userTrueName",user.getUserTrueName());
            return AjaxResult.success(object);
        }
    }
}
