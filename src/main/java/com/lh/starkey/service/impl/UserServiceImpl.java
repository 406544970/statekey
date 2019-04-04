package com.lh.starkey.service.impl;

import com.lh.starkey.dao.RoleMapper;
import com.lh.starkey.dao.UserMapper;
import com.lh.starkey.model.Role;
import com.lh.starkey.model.User;
import com.lh.starkey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @author panjin
 * @create 2019-01-31 11:53
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userDao;
    @Autowired
    RoleMapper roleDao;

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return false;
    }

    @Override
    public boolean deleteByUser(User user) {
        return false;
    }

    @Override
    public boolean insertOrUpdate(User user) {
        return false;
    }

    @Override
    public boolean insertBatch(List<User> user) {
        return false;
    }

    @Override
    public boolean insertUserAndUserInfo(Map map) {
        return false;
    }

    @Override
    public List<User> selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<User> selectUserList(User user) {
        return null;
    }

    @Override
    public List<Role> selectRoleById(long id) {
        return null;
    }

    @Override
    public List<?> selectUserAndUserInfo(User user) {
        return null;
    }

    @Override
    public List<User> selectUserList(Map map) {
        return null;
    }
/*
    @Autowired
    UserRespository userRespository;
*/

//    @Override
//    public R deleteByPrimaryKey(Long id) {
//        int i = 0;
//        try {
//            i = userDao.deleteByPrimaryKey (id);
//            return R.ok (i + "");
//        } catch (Exception e) {
//            return R.error (e.getMessage ());
//        }
//    }
//
//    @Override
//    public R deleteByUser(User user) {
//        int i=0;
//
//        try {
////            userRespository.delete (user);
//            i=userDao.deleteByUser (user);
//            return R.ok (i+"");
//        } catch (Exception e) {
//            return R.error (e.getMessage ());
//        }
//
//
//    }
//
//    @Override
//    public R insertOrUpdate(User user) {
//        int i=0;
//        try {
//            i=userDao.insertOrUpdate (user);
//            return R.ok (i+"");
//        } catch (Exception e) {
//            return R.error (e.getMessage ());
//        }
//
//    }
//
//    @Override
//    public R insertBatch(List<User> userList) {
//        int i=0;
//        try {
//            i=userDao.insertBatch (userList);
//            return R.ok (i+"");
//        } catch (Exception e) {
//            return R.error (e.getMessage ());
//        }
//
//    }
//
//    @Override
//    public R insertUserAndUserInfo(Map map) {
//        int i = 0;
//        try {
//            i = userDao.insertUserAndUserInfo (map);
//            return R.ok (i + "");
//        } catch (Exception e) {
//            return R.error (e.getMessage ());
//        }
//    }
//
//    @Override
//    public R selectByPrimaryKey(Long id) {
//        User user=new User ();
//        Role role;
//        Map map=new HashMap ();
//        try {
//            user=userDao.selectByPrimaryKey (id);
//            role = roleDao.selectByPrimaryKey((long) 2);
//            map.put ("user",user);
//            map.put ("role",role);
//            return R.ok (map);
//        } catch (Exception e) {
//            return R.error (e.getMessage ());
//        }
//    }
//
//    @Override
//    public R selectUserList(User user) {
//        List<User> list=new ArrayList<> ();
//        Map map=new HashMap ();
//        try {
//            list= userDao.selectUserList (user);
//            map.put ("list",list);
//            return R.ok (map);
//        } catch (Exception e) {
//            return R.error (e.getMessage ());
//        }
//
//    }
//
//    @Override
//    public R selectRoleById(long id) {
//        Role role=new Role ();
//        Map map=new HashMap ();
//        try {
//            role= roleDao.selectByPrimaryKey (id);
//            map.put("role",role);
//            return R.ok (map);
//        } catch (Exception e) {
//           return R.error (e.getMessage ());
//        }
//    }
//
//    @Override
//    public R selectUserAndUserInfo(User user) {
//        List list=new ArrayList ();
//        Map map=new HashMap ();
//        try {
//            list= userDao.selectUserAndUserInfo (user);
//            map.put ("list",list);
//            return R.ok (map);
//        } catch (Exception e) {
//            return R.error (e.getMessage ());
//        }
//    }
//
//    @Override
//    public R selectUserList(Map map) {
//        List list=new ArrayList ();
//        Map map1=new HashMap ();
//        try {
//            userDao.selectUserListByGroup (map);
//            map1.put ("list",list);
//            return R.ok (map1);
//        } catch (Exception e) {
//            return R.error (e.getMessage ());
//        }
//    }
}



