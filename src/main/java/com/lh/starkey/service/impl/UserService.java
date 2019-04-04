package com.lh.starkey.service.impl;



import com.lh.starkey.model.Role;
import com.lh.starkey.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author panjin
 * @create 2019-01-31 11:50
 */
@Service
public interface UserService {
    /**
     * 通过主键删除
     * @param id 主键ID
     * @return
     */
    boolean deleteByPrimaryKey(Long id);

    /**
     * 根据用户删除
     * @param user
     * @return
     */
    boolean deleteByUser(User user);

    /**
     * 添加更新
     * @param user
     * @return
     */
    boolean insertOrUpdate(User user);

    /**
     * 批量插入
     * @param user
     * @return
     */
    boolean insertBatch(List<User> user);

    /**
     * 同时添加用户和用户信息
     * @param map
     * @return
     */
    boolean insertUserAndUserInfo(Map map);

    /**
     * 主键查询获得user对象
     * @param id 用户ID
     * @return User对象
     */
    List<User> selectByPrimaryKey(Long id);

    /**
     * 获得用户列表
     * @param user 用户对象
     * @return List<User>
     */
    List<User> selectUserList(User user);

    /**
     * 角色ID查询角色
     * @param id 角色ID
     * @return
     */
    List<Role> selectRoleById(long id);

    /**
     * 查询用户详细信息
     * @param user
     * @return
     */
    List<?> selectUserAndUserInfo(User user);

    /**
     * 分组排序查询
     * @param map
     * @return
     */
    List<User> selectUserList(Map map);
}
