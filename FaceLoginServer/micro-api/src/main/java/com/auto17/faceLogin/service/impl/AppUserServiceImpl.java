package com.auto17.faceLogin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auto17.faceLogin.mapper.AppUserMapper;
import com.auto17.faceLogin.domain.AppUser;
import com.auto17.faceLogin.service.IAppUserService;

/**
 * appUserService
 *
 * @author jianxiang sun
 * @date 2023-02-10
 */
@Service
public class AppUserServiceImpl implements IAppUserService
{
    @Autowired
    private AppUserMapper appUserMapper;

    /**
     * @param userId appUserID
     * @return appUser
     */
    @Override
    public AppUser selectAppUserById(Long userId)
    {
        return appUserMapper.selectAppUserById(userId);
    }


    public AppUser selectAppUserOne(AppUser appUser){
        List<AppUser> userList=selectAppUserList(appUser);
        if(userList!=null && userList.size()>0){
            return userList.get(0);
        }else {
            return null;
        }
    }

    /**
     * @param appUser appUser
     * @return appUser
     */
    @Override
    public List<AppUser> selectAppUserList(AppUser appUser)
    {
        return appUserMapper.selectAppUserList(appUser);
    }

    /**
     * @param appUser appUser
     * @return int
     */
    @Override
    public int insertAppUser(AppUser appUser)
    {
        return appUserMapper.insertAppUser(appUser);
    }

    /**
     * @param appUser appUser
     * @return int
     */
    @Override
    public int updateAppUser(AppUser appUser)
    {
        return appUserMapper.updateAppUser(appUser);
    }

    /**
     * @param userId appUserID
     * @return int
     */
    @Override
    public int deleteAppUserById(Long userId)
    {
        return appUserMapper.deleteAppUserById(userId);
    }
}
