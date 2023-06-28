package com.example.luoanforumservice.module.chat.dao.lmpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.luoanforumservice.module.chat.dao.UserMainMsgDao;
import com.example.luoanforumservice.module.chat.domain.entity.UserMainMsg;
import com.example.luoanforumservice.module.chat.mapper.UserMainMsgMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 主消息表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 11:00:26
 */
@Service
public class UserMainMsgDaoImpl extends ServiceImpl<UserMainMsgMapper, UserMainMsg> implements UserMainMsgDao {
}
