package models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="id")
    private Long id;

    @Setter
    @Column(name="name")
    private String name;

    @Setter
    @Column(name="isOnline")
    private Boolean isOnline;


    @Setter
    @Column(name="mobileNo")
    private Long mobileNo;


}
