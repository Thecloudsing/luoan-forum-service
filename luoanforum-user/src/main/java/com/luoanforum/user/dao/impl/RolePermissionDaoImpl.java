package com.luoanforum.user.dao.impl;

import com.luoanforum.user.domain.entity.RolePermission;
import com.luoanforum.user.mapper.RolePermissionMapper;
import com.luoanforum.user.dao.IRolePermissionDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-07-24
 */
@Service
public class RolePermissionDaoImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionDao {

}
