package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table(name= "group_tbl")
public class Groups {

    @Id
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(name ="grpName")
    private String grpName;

    @Setter
    @Column(name = "description")
    private String description;


    @Setter
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIME)
    private Date createdAt;


    @Setter
    @Column(name="updatedAt")
    @Temporal(TemporalType.TIME)
    private Date updatedAt;

}
