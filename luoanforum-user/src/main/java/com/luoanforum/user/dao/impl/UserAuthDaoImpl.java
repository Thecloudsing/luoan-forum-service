package com.luoanforum.user.dao.impl;

import com.luoanforum.user.domain.entity.UserAuth;
import com.luoanforum.user.mapper.UserAuthMapper;
import com.luoanforum.user.dao.IUserAuthDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户身份认证表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-07-24
 */
@Service
public class UserAuthDaoImpl extends ServiceImpl<UserAuthMapper, UserAuth> implements IUserAuthDao {

}
