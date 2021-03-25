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
@Table(name = "messages")
public class Message {

    @Id
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(name = "fromUserId")
    private Long fromUserId;

    @Setter
    @Column(name = "receiversId")
    private Long receiversId;

    @Setter
    @Column(name = "message")
    private String message;

    @Setter
    @Column(name = "createdAt")
    private Date createdAt;

    @Setter
    @Column(name = "updatedAt")
    private Date updatedAt;

    @Setter
    @Column(name = "isGroupId")
    private Boolean isGroupId;

}
