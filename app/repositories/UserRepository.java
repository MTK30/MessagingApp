package repositories;

import models.User;

import java.util.List;

public class UserRepository extends EbeanRepository<User,Long>{
    public UserRepository() {
        super(User.class);
    }

    public List<User> getUsers() {
        return getMessageDbReadCtx().find(User.class)
                .findList();
    }

    public User findUser(String name,Long mobileNo) {
        return getMessageDbReadCtx().find(User.class)
                .where()
                .eq("name",name)
                .eq("mobileNo",mobileNo)
                .findOne();
    }

    public User findUserById(Long userId){
        return getMessageDbReadCtx().find(User.class)
                .where()
                .eq("id",userId)
                .findOne();
    }

    public List<User> getUserFromIds(List<Long> userIds) {
        return getMessageDbReadCtx().find(User.class)
                .where()
                .in("id",userIds)
                .findList();
    }

    public List<User> getUserOnline(List<Long> userIds) {
        return getMessageDbReadCtx().find(User.class)
                .where()
                .in("id",userIds)
                .eq("isOnline",true)
                .findList();
    }
}
