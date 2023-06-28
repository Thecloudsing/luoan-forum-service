package com.example.luoanforumservice.module.chat.dao.lmpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.luoanforumservice.module.chat.dao.GroupSubMsgDao;
import com.example.luoanforumservice.module.chat.domain.entity.GroupSubMsg;
import com.example.luoanforumservice.module.chat.mapper.GroupSubMsgMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 群聊从消息表 服务实现类
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 11:00:26
 */
@Service
public class GroupSubMsgDaoImpl extends ServiceImpl<GroupSubMsgMapper, GroupSubMsg> implements GroupSubMsgDao {

}
