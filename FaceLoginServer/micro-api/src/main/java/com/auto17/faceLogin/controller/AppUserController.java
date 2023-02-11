package com.auto17.faceLogin.controller;

import java.util.List;

import com.auto17.base.controller.BaseController;
import com.auto17.base.domain.AjaxResult;
import com.auto17.base.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.auto17.faceLogin.domain.AppUser;
import com.auto17.faceLogin.service.IAppUserService;

/**
 * appUserController
 *
 * @author jianxiang sun
 * @date 2023-02-10
 */
@Controller
@RequestMapping("/system/user")
@CrossOrigin
public class AppUserController extends BaseController
{

    @Autowired
    private IAppUserService appUserService;

    /**
     * appUser list
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AppUser appUser)
    {
        startPage();
        List<AppUser> list = appUserService.selectAppUserList(appUser);
        return getDataTable(list);
    }


    /**
     * add appUser
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AppUser appUser)
    {
        return toAjax(appUserService.insertAppUser(appUser));
    }

    /**
     * edit appUser
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AppUser appUser)
    {
        return toAjax(appUserService.updateAppUser(appUser));
    }

    /**
     * DELETE appUser
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(appUserService.deleteAppUserById(Long.valueOf(ids)));
    }
}
