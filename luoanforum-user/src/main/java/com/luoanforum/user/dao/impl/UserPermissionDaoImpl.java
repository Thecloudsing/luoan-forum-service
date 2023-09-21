package com.luoanforum.user.dao.impl;

import com.luoanforum.user.domain.entity.UserPermission;
import com.luoanforum.user.mapper.UserPermissionMapper;
import com.luoanforum.user.dao.IUserPermissionDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户权限表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-07-24
 */
@Service
public class UserPermissionDaoImpl extends ServiceImpl<UserPermissionMapper, UserPermission> implements IUserPermissionDao {

}
