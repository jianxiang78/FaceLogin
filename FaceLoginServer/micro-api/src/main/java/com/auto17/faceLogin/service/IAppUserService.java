package com.auto17.faceLogin.service;

import java.util.List;
import com.auto17.faceLogin.domain.AppUser;

/**
 * appUserService
 *
 * @author jianxiang sun
 * @date 2023-02-10
 */
public interface IAppUserService
{
    /**
     * @param userId appUserID
     * @return appUser
     */
    public AppUser selectAppUserById(Long userId);

    public AppUser selectAppUserOne(AppUser appUser);
    /**
     * @param appUser appUser
     * @return appUser List
     */
    public List<AppUser> selectAppUserList(AppUser appUser);

    /**
     * @param appUser appUser
     * @return int
     */
    public int insertAppUser(AppUser appUser);

    /**
     * @param appUser appUser
     * @return int
     */
    public int updateAppUser(AppUser appUser);

    /**
     * @param userId appUserID
     * @return int
     */
    public int deleteAppUserById(Long userId);
}
