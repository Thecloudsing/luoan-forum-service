package com.example.luoanforumservice.module.user.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.luoanforumservice.module.user.dao.UserRoleDao;
import com.example.luoanforumservice.module.user.domain.entity.UserRole;
import com.example.luoanforumservice.module.user.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 用户权限表 数据实现类
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:26
 */
@Service
public class UserRoleDaoImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleDao {

    @Override
    public List<UserRole> listByUid(Long uid) {
        return lambdaQuery()
                .eq(UserRole::getUid, Objects.requireNonNull(uid))
                .list();
    }
}
