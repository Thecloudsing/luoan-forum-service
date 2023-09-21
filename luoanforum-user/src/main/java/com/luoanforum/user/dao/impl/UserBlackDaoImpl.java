package com.luoanforum.user.dao.impl;

import com.luoanforum.user.domain.entity.UserBlack;
import com.luoanforum.user.mapper.UserBlackMapper;
import com.luoanforum.user.dao.IUserBlackDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户黑名单表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-07-24
 */
@Service
public class UserBlackDaoImpl extends ServiceImpl<UserBlackMapper, UserBlack> implements IUserBlackDao {

}
