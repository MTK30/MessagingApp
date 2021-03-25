package services;

import models.Groups;
import models.User;
import models.UserGroupMapping;
import repositories.GroupsRepository;
import repositories.UserGrpMappingRepository;
import repositories.UserRepository;
import skeletons.request.AddUserToGroupRequest;
import skeletons.request.CreateGroupRequest;
import skeletons.response.ExceptionResponse;
import skeletons.response.Response;
import skeletons.response.SuccessResponse;
import skeletons.response.UserResponse;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GroupsService {

    private GroupsRepository groupsRepository;
    private UserGrpMappingRepository userGrpMappingRepository;
    private UserService userService;
    private UserRepository userRepository;

    @Inject
    public GroupsService(GroupsRepository groupsRepository,UserGrpMappingRepository userGrpMappingRepository,
                        UserService userService,UserRepository userRepository){
        this.groupsRepository = groupsRepository;
        this.userGrpMappingRepository = userGrpMappingRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    /**
     * Group Creation Method
     * @param createGroupRequest
     * @return
     */
    public Response createGroup(CreateGroupRequest createGroupRequest) {
        if(!userService.isValidUser(createGroupRequest.getUserId())) {
            ExceptionResponse exceptionResponse = new ExceptionResponse("User Doesn't Exist");
            return exceptionResponse;
        }
        Groups group = new Groups();
        Date now = new java.util.Date();
        group.setGrpName(createGroupRequest.getGrpName());
        group.setDescription(createGroupRequest.getDescription());
        group.setCreatedAt(now);
        group.setUpdatedAt(now);
        try {
            groupsRepository.save(group);
        } catch (Exception ex) {
            System.out.println("Error[GroupService][createGroup]1: "+ex.getMessage());
            ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
            return exceptionResponse;
        }
        UserGroupMapping userGroupMapping = new UserGroupMapping();
        userGroupMapping.setGroupId(group.getId());
        userGroupMapping.setIsAdmin(Boolean.TRUE);
        userGroupMapping.setUserId(createGroupRequest.getUserId());
        userGroupMapping.setCreatedAt(now);
        userGroupMapping.setUpdatedAt(now);
        try {
            userGrpMappingRepository.save(userGroupMapping);
        } catch (Exception ex) {
            System.out.println("Error[GroupService][createGroup]2:"+ex.getMessage());
            ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
            return exceptionResponse;
        }
        SuccessResponse successResponse = new SuccessResponse(Boolean.TRUE);
        return successResponse;
    }

    /**
     * Add User to Group
     * @param addUserToGroupRequest
     * @return
     */
    public Response addToGroup(AddUserToGroupRequest addUserToGroupRequest) {
        UserGroupMapping isAdminUser = userGrpMappingRepository.
                getUserGrpMapForAdmin(addUserToGroupRequest.getUserId(),addUserToGroupRequest.getGroupId());
        if (isAdminUser == null) {
            ExceptionResponse exceptionResponse = new ExceptionResponse("Current User is not the Admin");
            return exceptionResponse;
        }
        String candidatesUserIds = addUserToGroupRequest.getCandidateIds();
        if (candidatesUserIds.contains(",")) {
            String[] candidateIdList = candidatesUserIds.split(",");
            for(String candidateId:candidateIdList) {
                Boolean isSaved = userGroupAddition(addUserToGroupRequest,Long.parseLong(candidateId));
                if (!isSaved) {
                    ExceptionResponse exceptionResponse = new ExceptionResponse("Internal Error while Saving userGroupMapping to DB");
                    return exceptionResponse;
                }
            }
        } else {
            Boolean isSaved = userGroupAddition(addUserToGroupRequest,Long.parseLong(addUserToGroupRequest.getCandidateIds()));
            if (!isSaved) {
                ExceptionResponse exceptionResponse = new ExceptionResponse("Internal Error while Saving userGroupMapping to DB");
                return exceptionResponse;
            }
        }
        SuccessResponse successResponse = new SuccessResponse(Boolean.TRUE);
        return successResponse;
    }


    /**
     * Fetching all the members of the group
     * @param groupId
     * @param userId
     * @return
     */
    public Response getGroupMembers(Long groupId, Long userId) {
        ExceptionResponse exceptionResponse;
        UserGroupMapping userGroupMapping = userGrpMappingRepository.isValidUser(userId,groupId);
        if (userGroupMapping == null) {
            exceptionResponse = new ExceptionResponse("Current User is not of the same grp");
            return exceptionResponse;
        }
        List<UserGroupMapping> userGroupMappingList = userGrpMappingRepository.getUserGrpMapping(groupId);
        List<Long> userIds = userGroupMappingList.stream().map(UserGroupMapping::getUserId).collect(Collectors.toList());
        List<User> userList = null;
        try {
            userList = userRepository.getUserFromIds(userIds);
        } catch (Exception ex) {
            System.out.println("Exception[GroupService][getGroupMembers] "+ex.getMessage());
            exceptionResponse = new ExceptionResponse(ex.getMessage());
            return exceptionResponse;
        }
        List<UserResponse> userResponseList = new ArrayList<>();
        userList.forEach(
                user -> {
                    UserResponse userResponse = new UserResponse();
                    userResponse.setName(user.getName());
                    userResponse.setIsOnline(user.getIsOnline());
                    userResponse.setId(user.getId());
                    userResponse.setMobileNo(user.getMobileNo());
                    userResponseList.add(userResponse);
                }
        );
        SuccessResponse successResponse = new SuccessResponse(userResponseList);
        return successResponse;

    }

    /**
     * User Mapping Creation helper
     * @param addUserToGroupRequest
     * @param userId
     * @return
     */
    private Boolean userGroupAddition(AddUserToGroupRequest addUserToGroupRequest,Long userId) {
        Date todayDate = new Date();
        UserGroupMapping userGroupMapping = new UserGroupMapping();
        userGroupMapping.setGroupId(addUserToGroupRequest.getGroupId());
        userGroupMapping.setUserId(userId);
        userGroupMapping.setCreatedAt(todayDate);
        userGroupMapping.setUpdatedAt(todayDate);
        userGroupMapping.setIsAdmin(Boolean.FALSE);
        try {
            userGrpMappingRepository.save(userGroupMapping);
        } catch (Exception ex) {
            System.out.println("Exception [GroupService][addToGroup]2 "+ex.getMessage());
            ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
            return Boolean.FALSE;
        }
        return  Boolean.TRUE;
    }
    //@TODO
    // add admin , delete (or) Remove Admin


}
