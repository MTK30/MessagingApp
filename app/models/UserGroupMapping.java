package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Entity
@Table(name = "user_grp_mapping")
public class UserGroupMapping {

    @Id
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(name = "groupId")
    private Long groupId;

    @Setter
    @Column(name = "userId")
    private Long userId;

    @Setter
    @Column(name = "isAdmin")
    private Boolean isAdmin;


    @Setter
    @Column(name = "createdAt")
    private Date createdAt;

    @Setter
    @Column(name = "updatedAt")
    private Date updatedAt;


}
