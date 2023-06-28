package com.example.luoanforumservice.module.user.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.luoanforumservice.module.user.dao.UserInfoDao;
import com.example.luoanforumservice.module.user.domain.entity.UserInfo;
import com.example.luoanforumservice.module.user.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 数据实现类
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:26
 */
@Service
public class UserInfoDaoImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoDao {

}
