package com.luoanforum.user.dao.impl;

import com.luoanforum.user.domain.entity.Black;
import com.luoanforum.user.mapper.BlackMapper;
import com.luoanforum.user.dao.IBlackDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 黑名单表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-07-24
 */
@Service
public class BlackDaoImpl extends ServiceImpl<BlackMapper, Black> implements IBlackDao {

}
