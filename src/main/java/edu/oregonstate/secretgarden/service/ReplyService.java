package edu.oregonstate.secretgarden.service;

import edu.oregonstate.secretgarden.model.Reply;
import edu.oregonstate.secretgarden.model.ReplyKey;

import java.util.List;

public interface ReplyService extends BaseService<Reply, ReplyKey> {

    List<Reply> getPostReplys(int postId);
}
