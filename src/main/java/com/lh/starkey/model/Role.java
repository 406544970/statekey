package com.lh.starkey.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色对象
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 4652959824966326894L;
    /**
     * 角色ID
     */
    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    private Role role;
    /**
     * 权限下的用户列表
     * @return
     */
    private List<User> userList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(role.id);
        sb.append(", roleName=").append(role.roleName);
        sb.append(", createTime=").append(role.createTime);
        sb.append(", updateTime=").append(role.updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(" [");
        sb.append(",UseList =");
        for (User e:userList
             ) {
            sb.append(", getName=").append(e.getName());
            sb.append(", getPwd=").append(e.getPwd());
            sb.append(", getRoleId=").append(e.getRoleId());
        }
        sb.append("]");
        sb.append("]");
        return sb.toString();
    }
}