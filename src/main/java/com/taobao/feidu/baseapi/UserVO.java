package com.taobao.feidu.baseapi;

/**
 * User: feidu
 * Date: 13-2-22
 * Time: 上午11:00
 */

import java.io.Serializable;
import java.util.Date;

/**
 * @author Michael
 * @blog http://sjsky.iteye.com
 */
public class UserVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6846034858002233878L;

    private String userId;

    private String userName;

    private int age;

    private Date born;

    public UserVO() {
    }

    public UserVO(String userId, String userName, int age, Date born) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.born = born;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the born
     */
    public Date getBorn() {
        return born;
    }

    /**
     * @param pUserId the userId to set
     */
    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    /**
     * @param pUserName the userName to set
     */
    public void setUserName(String pUserName) {
        userName = pUserName;
    }

    /**
     * @param pAge the age to set
     */
    public void setAge(int pAge) {
        age = pAge;
    }

    /**
     * @param pBorn the born to set
     */
    public void setBorn(Date pBorn) {
        born = pBorn;
    }

    @Override
    public String toString() {
        return "userId=[ " + userId + " ] userName=[ " + userName + " ] age=[ "
                + age + " ] born=[ " + born + "] .";
    }

}
