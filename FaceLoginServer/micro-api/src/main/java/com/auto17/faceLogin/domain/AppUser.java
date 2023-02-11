package com.auto17.faceLogin.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * appUser object app_user
 *
 * @author jianxiang sun
 * @date 2023-02-10
 */
public class AppUser
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long userId;

    /**  */
    private String facialId;

    /**  */
    private String userNickName;

    /**  */
    private String userTrueName;

    /**  */
    private Integer userAge;

    /**  */
    private String userGender;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regTime;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setFacialId(String facialId)
    {
        this.facialId = facialId;
    }

    public String getFacialId()
    {
        return facialId;
    }
    public void setUserNickName(String userNickName)
    {
        this.userNickName = userNickName;
    }

    public String getUserNickName()
    {
        return userNickName;
    }
    public void setUserTrueName(String userTrueName)
    {
        this.userTrueName = userTrueName;
    }

    public String getUserTrueName()
    {
        return userTrueName;
    }
    public void setUserAge(Integer userAge)
    {
        this.userAge = userAge;
    }

    public Integer getUserAge()
    {
        return userAge;
    }
    public void setUserGender(String userGender)
    {
        this.userGender = userGender;
    }

    public String getUserGender()
    {
        return userGender;
    }
    public void setRegTime(Date regTime)
    {
        this.regTime = regTime;
    }

    public Date getRegTime()
    {
        return regTime;
    }
    public void setLastLoginTime(Date lastLoginTime)
    {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastLoginTime()
    {
        return lastLoginTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("facialId", getFacialId())
            .append("userNickName", getUserNickName())
            .append("userTrueName", getUserTrueName())
            .append("userAge", getUserAge())
            .append("userGender", getUserGender())
            .append("regTime", getRegTime())
            .append("lastLoginTime", getLastLoginTime())
            .toString();
    }
}
