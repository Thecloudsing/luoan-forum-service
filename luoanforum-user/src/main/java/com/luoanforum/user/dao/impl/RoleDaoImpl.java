package com.luoanforum.user.dao.impl;

import com.luoanforum.user.dao.IRoleDao;
import com.luoanforum.user.domain.entity.Role;
import com.luoanforum.user.mapper.RoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-07-24
 */
@Service
public class RoleDaoImpl extends ServiceImpl<RoleMapper, Role> implements IRoleDao {

}
