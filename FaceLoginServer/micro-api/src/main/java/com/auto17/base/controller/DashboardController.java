package com.auto17.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.auto17.base.domain.AjaxResult;
import com.auto17.faceLogin.domain.AppUser;
import com.auto17.faceLogin.service.IAppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * dashboard
 *
 * @author jianxiang sun
 */

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class DashboardController extends BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private IAppUserService appUserService;

    @PostMapping("/demo")
    public AjaxResult demo() {
        if(getLoginUser()==null){
            return AjaxResult.error("no login");
        }
        JSONObject object=new JSONObject();
        AppUser user=appUserService.selectAppUserById(getLoginUser().getUserId());
        JSONObject objectUser=(JSONObject) JSON.toJSON(user);
        if(user.getUserTrueName()==null || user.getUserNickName()==null){
            objectUser.put("first",0);
        }else {
            objectUser.put("first",1);
        }
        object.put("loginUser",objectUser);
        object.put("clients",clients());
        object.put("tableExample",tableExample());
        return AjaxResult.success(object);
    }

    private int clients(){
        AppUser user=new AppUser();
        List<AppUser> list=appUserService.selectAppUserList(user);
        if(list!=null){
            return list.size();
        }else {
            return 0;
        }
    }

    private JSONArray tableExample(){
        AppUser user=new AppUser();
        List<AppUser> list=appUserService.selectAppUserList(user);
        if(list!=null){
            return JSONArray.parseArray(JSON.toJSONString(list));
        }else {
            return null;
        }
    }

}
