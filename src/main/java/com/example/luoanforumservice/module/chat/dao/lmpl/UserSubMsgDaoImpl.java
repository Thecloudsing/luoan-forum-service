package com.example.luoanforumservice.module.chat.dao.lmpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.luoanforumservice.module.chat.dao.UserSubMsgDao;
import com.example.luoanforumservice.module.chat.domain.entity.UserSubMsg;
import com.example.luoanforumservice.module.chat.mapper.UserSubMsgMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 从消息表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 11:00:26
 */
@Service
public class UserSubMsgDaoImpl extends ServiceImpl<UserSubMsgMapper, UserSubMsg> implements UserSubMsgDao {
}
