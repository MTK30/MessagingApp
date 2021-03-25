package services;

import models.Contacts;
import models.User;
import repositories.ContactsRepository;
import repositories.UserRepository;
import skeletons.request.ActiveInactiveRequest;
import skeletons.request.CreateUserRequest;
import skeletons.response.ExceptionResponse;
import skeletons.response.Response;
import skeletons.response.SuccessResponse;
import skeletons.response.UserResponse;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private UserRepository userRepository;
    private ContactsRepository contactsRepository;

    @Inject
    public UserService(UserRepository userRepository,ContactsRepository contactsRepository) {
        this.userRepository = userRepository;
        this.contactsRepository = contactsRepository;
    }


    //@TODO
    // returning the object itself after creation as a response


    /**
     *
     * @param createUserRequest
     * @return
     */

    public Response addUser(CreateUserRequest createUserRequest) {
        User user = new User();
        SuccessResponse successResponse = new SuccessResponse(true);
        User alreadyPresent = userRepository.findUser(createUserRequest.getName(), createUserRequest.getMobileNo());
        if (alreadyPresent != null) {
            ExceptionResponse exceptionResponse = new ExceptionResponse("User Already Present");
            return exceptionResponse;
        }
        user.setName(createUserRequest.getName());
        user.setMobileNo(createUserRequest.getMobileNo());
        user.setIsOnline(Boolean.TRUE);
        try {
            userRepository.save(user);
        } catch (Exception exception) {
            System.out.println("Exception Occurred "+exception.getMessage());
            ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage());
            return exceptionResponse;
        }
        return successResponse;
    }


    public Response getUser() {
        SuccessResponse successResponse;
        List<User> users;
        try {
            users = userRepository.getUsers();
        } catch (Exception exception) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage());
            return exceptionResponse;
        }
        List<UserResponse> userResponseList = new ArrayList<>();
        users.forEach(
                user -> {
                    UserResponse userResponse = new UserResponse();
                    userResponse.setId(user.getId());
                    userResponse.setName(user.getName());
                    userResponse.setMobileNo(user.getMobileNo());
                    userResponse.setIsOnline(user.getIsOnline());
                    userResponseList.add(userResponse);
                }
        );
        successResponse = new SuccessResponse(userResponseList);
        return  successResponse;
    }


    public Boolean isValidUser(Long userId) {
        if ( userRepository.findUserById(userId) == null) {
            return false;
        }
        return true;
    }


    public Response addContacts(String contacts,Long userId) {
        //@TODO
        /**
         * Same user cannot add themselves to contact
         */
        String[] contactList = contacts.split(",");
        List<Contacts> contactsList = new ArrayList<>();
        for(String contactId: contactList) {
            System.out.println("ContactId: "+contactId);
            Contacts contact = new Contacts();
            contact.setContactId(Long.parseLong(contactId));
            contact.setUserId(userId);
            contactsList.add(contact);
        }
        try {
            contactsRepository.saveAll(contactsList);
        } catch (Exception ex) {
            System.out.println("Exception[UserService][addContacts] "+ex.getMessage());
            ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
            return exceptionResponse;
        }
        SuccessResponse successResponse = new SuccessResponse(Boolean.TRUE);
        return successResponse;
    }


    public Response usersOnline(Long userId) {
        List<Contacts> contactsList;
        try {
            contactsList = contactsRepository.getContacts(userId);
        } catch (Exception ex) {
            System.out.println("Exception Occured: "+ex.getMessage());
            ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
            return exceptionResponse;
        }
        List<UserResponse> userResponseList = new ArrayList<>();
        List<Long> activeUserIds = contactsList.stream().map(Contacts::getContactId).collect(Collectors.toList());
        System.out.println("activeUserIds : "+activeUserIds.get(0));
        List<User> userList;
        try {
            userList = userRepository.getUserOnline(activeUserIds);
        } catch (Exception ex) {
            System.out.println("Exception Occured: "+ex.getMessage());
            ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
            return exceptionResponse;
        }
        System.out.println("UsersList : "+userList.size());
        userList.forEach(
                user -> {
                    UserResponse userResponse = new UserResponse();
                    userResponse.setIsOnline(user.getIsOnline());
                    userResponse.setName(user.getName());
                    userResponse.setId(user.getId());
                    userResponse.setMobileNo(user.getMobileNo());
                    userResponseList.add(userResponse);
                }
        );
        SuccessResponse successResponse = new SuccessResponse(userResponseList);
        return successResponse;
    }

    public Response setActiveInactive(ActiveInactiveRequest activeInactiveRequest) {
        User user = userRepository.findUserById(activeInactiveRequest.getUserId());
        if (user == null) {
            ExceptionResponse exceptionResponse = new ExceptionResponse("No UserFound");
            return exceptionResponse;
        }
        user.setIsOnline(!user.getIsOnline());
        userRepository.save(user);
        SuccessResponse successResponse = new SuccessResponse(Boolean.TRUE);
        return successResponse;
    }



}
