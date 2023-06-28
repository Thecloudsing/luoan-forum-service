package com.example.luoanforumservice.module.dynamic.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.luoanforumservice.module.dynamic.dao.DynamicCommentDao;
import com.example.luoanforumservice.module.dynamic.domain.entity.DynamicComment;
import com.example.luoanforumservice.module.dynamic.mapper.DynamicCommentMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 动态评论表 数据实现类
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:55
 */
@Service
public class DynamicCommentDaoImpl extends ServiceImpl<DynamicCommentMapper, DynamicComment> implements DynamicCommentDao {

}
