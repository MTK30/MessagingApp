package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name="contacts")
public class Contacts {

    @Id
    @Setter
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(name = "userId")
    private Long userId;

    @Setter
    @Column(name = "contactId")
    private Long contactId;
}
