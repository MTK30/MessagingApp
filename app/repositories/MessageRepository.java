package repositories;

import models.Message;

import java.util.List;

public class MessageRepository extends EbeanRepository<Message,Long>{

    public MessageRepository() {
        super(Message.class);
    }

    public List<Message> getMessageFromUser(Long fromUserId,Long receiversId,Boolean isGroup) {
        return getMessageDbReadCtx().find(Message.class)
                .where()
                .eq("fromUserId",fromUserId)
                .eq("receiversId",receiversId)
                .eq("isGroupId",isGroup)
                .findList();
    }

    public List<Message> getMessageOfGrpExcludingUser(Long userId,Long groupId) {
        return getMessageDbReadCtx().find(Message.class)
                .where()
                .ne("fromUserId",userId)
                .eq("receiversId",groupId)
                .findList();
    }

}
