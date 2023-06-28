package com.example.luoanforumservice.module.user.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.luoanforumservice.module.user.dao.BlackDao;
import com.example.luoanforumservice.module.user.domain.entity.Black;
import com.example.luoanforumservice.module.user.mapper.BlackMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 黑名单 数据实现类
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:25
 */
@Service
public class BlackDaoImpl extends ServiceImpl<BlackMapper, Black> implements BlackDao {

}
