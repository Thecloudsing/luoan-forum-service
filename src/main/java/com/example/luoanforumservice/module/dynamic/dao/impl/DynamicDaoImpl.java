package com.example.luoanforumservice.module.dynamic.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.luoanforumservice.module.dynamic.dao.DynamicDao;
import com.example.luoanforumservice.module.dynamic.domain.entity.Dynamic;
import com.example.luoanforumservice.module.dynamic.mapper.DynamicMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 动态表 数据实现类
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:55
 */
@Service
public class DynamicDaoImpl extends ServiceImpl<DynamicMapper, Dynamic> implements DynamicDao {

}
