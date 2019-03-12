package edu.oregonstate.secretgarden.service.impl;

import edu.oregonstate.secretgarden.mapper.ReplyMapper;
import edu.oregonstate.secretgarden.model.Reply;
import edu.oregonstate.secretgarden.model.ReplyKey;
import edu.oregonstate.secretgarden.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Chendi Zhang
 * @date: 2019-01-30
 * @description:
 **/

@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;

    @Autowired
    public ReplyServiceImpl(ReplyMapper replyMapper) {
        this.replyMapper = replyMapper;
    }

    @Override
    public int insert(Reply record) {
        return replyMapper.insert(record);
    }

    @Override
    public Reply selectByPrimaryKey(ReplyKey replyKey) {
        return replyMapper.selectByPrimaryKey(replyKey);
    }

    @Override
    public int updateByPrimaryKey(Reply object) {
        return replyMapper.updateByPrimaryKey(object);
    }

    @Override
    public int deleteByPrimaryKey(ReplyKey replyKey) {
        return replyMapper.deleteByPrimaryKey(replyKey);
    }

    @Override
    public List<Reply> getPostReplys(int postId) {
        return replyMapper.getPostReplys(postId);
    }
}
