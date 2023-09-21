package com.luoanforum.user.dao.impl;

import com.luoanforum.user.domain.entity.UserRole;
import com.luoanforum.user.mapper.UserRoleMapper;
import com.luoanforum.user.dao.IUserRoleDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-07-24
 */
@Service
public class UserRoleDaoImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleDao {

}
