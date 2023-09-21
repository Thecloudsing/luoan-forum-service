package com.luoanforum.user.dao.impl;

import com.luoanforum.user.domain.entity.UserBaseData;
import com.luoanforum.user.mapper.UserBaseDataMapper;
import com.luoanforum.user.dao.IUserBaseDataDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-07-24
 */
@Service
public class UserBaseDataDaoImpl extends ServiceImpl<UserBaseDataMapper, UserBaseData> implements IUserBaseDataDao {

}
