package com.luoanforum.user.service.cache;

import com.luoanforum.user.dao.*;
import com.luoanforum.user.domain.entity.UserOptTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserCache {
    /**
     * 角色dao
     */
    @Autowired
    private IRoleDao roleDao;
    /**
     * 权限dao
     */
    @Autowired
    private IPermissionDao permissionDao;
    /**
     * 角色权限dao
     */
    @Autowired
    private IRolePermissionDao rolePermissionDao;
    /**
     * 用户权限dao
     */
    @Autowired
    private IUserPermissionDao userPermissionDao;
    /**
     * 用户角色dao
     */
    @Autowired
    private IUserRoleDao userRoleDao;
    /**
     * 用户dao
     */
    @Autowired
    private IUserBaseDataDao userBaseDataDao;
    /**
     * 用户操作时间dao
     */
    @Autowired
    private IUserOptTimeDao userOptTimeDao;
    /**
     * 用户绑定第三方dao
     */
    @Autowired
    private IUserBindThirdPartyDao userBindThirdPartyDao;

    /**
     * 获取用户记录
     */
    @Cacheable(cacheNames = "user", key = "'user:'+#uid")
    public UserOptTime getUserOptTime(Long uid) {
        return userOptTimeDao.getById(uid);
    }
}
