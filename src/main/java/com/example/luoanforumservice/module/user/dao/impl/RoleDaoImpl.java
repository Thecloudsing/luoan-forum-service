package com.example.luoanforumservice.module.user.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.luoanforumservice.module.user.dao.RoleDao;
import com.example.luoanforumservice.module.user.domain.entity.Role;
import com.example.luoanforumservice.module.user.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 数据实现类
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:26
 */
@Service
public class RoleDaoImpl extends ServiceImpl<RoleMapper, Role> implements RoleDao {

}
