package repositories;

import models.Groups;

public class GroupsRepository extends EbeanRepository<Groups,Long> {

    public GroupsRepository() {
        super(Groups.class);
    }


}
