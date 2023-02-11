package com.auto17.faceLogin.mapper;

import java.util.List;
import com.auto17.faceLogin.domain.AppUser;
import org.springframework.stereotype.Component;

/**
 * appUser Mapper
 *
 * @author jianxiang sun
 * @date 2023-02-10
 */
@Component
public interface AppUserMapper
{
    /**
     * @param userId appUserID
     * @return appUser
     */
    public AppUser selectAppUserById(Long userId);

    /**
     * @param appUser appUser
     * @return appUser
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

    /**
     * delete more appUser
     *
     * @param userIds ID
     * @return int
     */
    public int deleteAppUserByIds(String[] userIds);
}
