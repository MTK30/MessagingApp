package services;

import models.Contacts;
import models.Message;
import models.User;
import models.UserGroupMapping;
import repositories.*;
import skeletons.request.MessageRequest;
import skeletons.response.ExceptionResponse;
import skeletons.response.MessageResponse;
import skeletons.response.Response;
import skeletons.response.SuccessResponse;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MessageService {

    private MessageRepository messageRepository;
    private UserGrpMappingRepository userGrpMappingRepository;
    private UserRepository userRepository;
    private UserService userService;
    private ContactsRepository contactsRepository;

    @Inject
    public MessageService(MessageRepository messageRepository,UserGrpMappingRepository userGrpMappingRepository,
                          UserService userService,UserRepository userRepository,ContactsRepository contactsRepository) {
        this.messageRepository = messageRepository;
        this.userGrpMappingRepository = userGrpMappingRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.contactsRepository = contactsRepository;
    }




    public Response sendMessage(MessageRequest messageRequest) {
        if (!userService.isValidUser(messageRequest.getFromUserId())) {
            ExceptionResponse exceptionResponse = new ExceptionResponse("User Doesnt Exist");
            return exceptionResponse;
        }
        if (messageRequest.getIsGroupId()) {
            UserGroupMapping userGroupMapping = userGrpMappingRepository.isValidUser(messageRequest.getFromUserId(),messageRequest.getReceiversId());
            if (userGroupMapping == null) {
                ExceptionResponse exceptionResponse = new ExceptionResponse("User Doesnt belong to the concerned grp");
                return exceptionResponse;
            }
        }else {
            Contacts contact  = contactsRepository.getContact(messageRequest.getFromUserId(),messageRequest.getReceiversId());
            if (contact== null) {
                List<Message> messages = messageRepository.getMessageFromUser(messageRequest.getReceiversId(),messageRequest.getFromUserId(),Boolean.FALSE);
                if (messages.size() == 0) {
                    ExceptionResponse exceptionResponse = new ExceptionResponse("Can't Message Someone Not in contact");
                        return exceptionResponse;
                }
            }
        }
        Message message = new Message();
        message.setMessage(messageRequest.getMessage());
        message.setCreatedAt(new Date());
        message.setIsGroupId(messageRequest.getIsGroupId());
        message.setUpdatedAt(new Date());
        message.setFromUserId(messageRequest.getFromUserId());
        message.setReceiversId(messageRequest.getReceiversId());
        try {
            messageRepository.save(message);
        } catch (Exception ex) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
            return exceptionResponse;
        }
        List<MessageResponse> messageResponses= getMessages(messageRequest.getFromUserId(),messageRequest.getReceiversId(),messageRequest.getIsGroupId());
        SuccessResponse successResponse = new SuccessResponse(messageResponses);
        return successResponse;
    }

    public Response getMessageScreen(Long fromUserId,Long receiverId,Boolean isGroup) {
        List<MessageResponse> messageResponse = getMessages(fromUserId,receiverId,isGroup);
        SuccessResponse successResponse = new SuccessResponse(messageResponse);
        return successResponse;
    }

    private List<MessageResponse> getMessages(Long fromUserId,Long receiverId,Boolean isGroup) {
        List<Message> messageFromUser = messageRepository.getMessageFromUser(fromUserId,receiverId,isGroup);
        List<Message> messageToUser;
        if(isGroup) {
            messageToUser = messageRepository.getMessageOfGrpExcludingUser(fromUserId,receiverId);
        }else{
            messageToUser = messageRepository.getMessageFromUser(receiverId,fromUserId,isGroup);
        }
        List<Message> completeMessage = Stream.concat(messageFromUser.stream(), messageToUser.stream()).collect(Collectors.toList());
        List<MessageResponse> messageResponses = new ArrayList<>();
        Map<Long,User> messageMap = new HashMap<>();
        completeMessage.sort(Comparator.comparing(o -> o.getCreatedAt()));
        completeMessage.forEach(
                message -> {
                    MessageResponse messageResponse = new MessageResponse();
                    messageResponse.setMessage(message.getMessage());
                    User user = messageMap.get(message.getFromUserId());
                    if (messageMap.get(message.getFromUserId()) != null) {
                        user = messageMap.get(message.getFromUserId());
                    }else{
                        user = userRepository.findUserById(message.getFromUserId());
                        messageMap.put(message.getFromUserId(),user);
                    }
                    if (message.getFromUserId() == fromUserId) {
                        messageResponse.setIsLeft(Boolean.FALSE);
                    } else {
                        messageResponse.setIsLeft(Boolean.TRUE);
                    }
                    messageResponse.setFromUserName(user.getName());
                    messageResponse.setCreatedDate(message.getCreatedAt());
                    messageResponses.add(messageResponse);
                }
        );
        return messageResponses;
    }

}
