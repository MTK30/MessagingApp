package repositories;

import models.Contacts;

import java.util.List;

public class ContactsRepository extends EbeanRepository<Contacts,Long>{
    public ContactsRepository() {
        super(Contacts.class);
    }

    public List<Contacts> getContacts(Long userId) {
        return getMessageDbReadCtx().find(Contacts.class)
                .where()
                .eq("userId",userId)
                .findList();
    }

    public Contacts getContact(Long userId,Long contactId) {
        return getMessageDbReadCtx().find(Contacts.class)
                .where()
                .eq("userId",userId)
                .eq("contactId",contactId)
                .findOne();
    }

}
