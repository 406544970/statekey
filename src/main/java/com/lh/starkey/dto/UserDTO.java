package com.lh.starkey.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author panjin
 * @create 2019-02-02 16:01
 */
@Data
public class UserDTO {

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 分组个数
     */
    private int num;
    /**
     * 起始位置
     */
    private int startIndex;
    /**
     * 结束位置
     */
    private int endIndex;
    /**
     * 年龄
     */
    private Byte age;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 角色名称
     */
    private String roleName;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
