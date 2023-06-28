package com.example.luoanforumservice.module.chat.dao.lmpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.luoanforumservice.module.chat.dao.GroupMainMsgDao;
import com.example.luoanforumservice.module.chat.domain.entity.GroupMainMsg;
import com.example.luoanforumservice.module.chat.mapper.GroupMainMsgMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 群聊主消息表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 11:00:26
 */
@Service
public class GroupMainMsgDaoImpl extends ServiceImpl<GroupMainMsgMapper, GroupMainMsg> implements GroupMainMsgDao {
}
