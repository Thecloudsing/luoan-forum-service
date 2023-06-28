package com.example.luoanforumservice.module.user.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.luoanforumservice.module.user.domain.entity.UserRole;

import java.util.List;

/**
 * <p>
 * 用户权限表 数据类
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:26
 */
public interface UserRoleDao extends IService<UserRole> {

    List<UserRole> listByUid(Long uid);
}
