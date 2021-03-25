package repositories;

import models.UserGroupMapping;

import java.util.List;

public class UserGrpMappingRepository extends EbeanRepository<UserGroupMapping,Long>{

    public UserGrpMappingRepository() {
        super(UserGroupMapping.class);
    }


    public UserGroupMapping getUserGrpMapForAdmin(Long userId,Long groupId) {
        return getMessageDbReadCtx().find(UserGroupMapping.class)
                .where()
                .eq("userId",userId)
                .eq("groupId",groupId)
                .eq("isAdmin",Boolean.TRUE)
                .findOne();
    }



    public UserGroupMapping isValidUser(Long userId,Long groupId) {
        return getMessageDbReadCtx().find(UserGroupMapping.class)
                .where()
                .eq("userId",userId)
                .eq("groupId",groupId)
                .findOne();
    }

    public List<UserGroupMapping> getUserGrpMapping(Long groupId) {
        return getMessageDbReadCtx().find(UserGroupMapping.class)
                .where()
                .eq("groupId",groupId)
                .findList();
    }

}
