package com.lh.starkey.dao;


import com.lh.starkey.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    /**
     * 通过主键删除
     * @param id 主键ID
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据用户删除
     * @param user
     * @return
     */
    int deleteByUser(User user);

    /**
     * 添加更新
     * @param user
     * @return
     */
    int insertOrUpdate(User user);

    /**
     * 批量插入
     * @param userList
     * @return
     */
    int insertBatch(List<User> userList);

    /**
     * 同时添加用户和用户信息
     * @param map
     * @return
     */
    int insertUserAndUserInfo(Map map);

    /**
     * 主键查询获得user对象
     * @param id 用户ID
     * @return User对象
     */
    User selectByPrimaryKey(Long id);

    /**
     * 获得用户列表
     * @param user 用户对象
     * @return List<User>
     */
    List<User> selectUserList(User user);

    /**
     * 角色id查询用户列表
     * @param roleId 角色ID
     * @return
     */
    List<User> selectByRoeId(long roleId);

    /**
     * 查询用户的详细信息
     * @param user
     * @return
     */
   List selectUserAndUserInfo(User user);

    /**
     * 分组分页排序查询
     * @param map
     * @return
     */
   List selectUserListByGroup(Map map);
}