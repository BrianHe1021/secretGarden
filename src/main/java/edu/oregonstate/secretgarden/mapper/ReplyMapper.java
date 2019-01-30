package edu.oregonstate.secretgarden.mapper;

import edu.oregonstate.secretgarden.model.Reply;
import edu.oregonstate.secretgarden.model.ReplyKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper {
    int deleteByPrimaryKey(ReplyKey key);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(ReplyKey key);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}