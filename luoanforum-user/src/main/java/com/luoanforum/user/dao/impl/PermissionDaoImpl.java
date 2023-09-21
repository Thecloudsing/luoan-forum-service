package com.luoanforum.user.dao.impl;

import com.luoanforum.user.domain.entity.Permission;
import com.luoanforum.user.mapper.PermissionMapper;
import com.luoanforum.user.dao.IPermissionDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-07-24
 */
@Service
public class PermissionDaoImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionDao {

}
