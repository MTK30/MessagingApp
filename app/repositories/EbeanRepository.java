package repositories;

import io.ebean.EbeanServer;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author MTK
 * @data 13/01/2020
 */
public class EbeanRepository<T ,ID extends Serializable> {
    private final EbeanServer messageDbReadCtx;
    private final EbeanServer messageDbWriteCtx;
    private final Class<T> persistenClass;

    @Inject
    public EbeanRepository(Class<T> persistenClass) {
        this.messageDbReadCtx = io.ebean.Ebean.getServer("message_db_read");
        this.messageDbWriteCtx = io.ebean.Ebean.getServer("message_db_write");
        this.persistenClass = persistenClass;
    }

    public EbeanServer getMessageDbReadCtx() {
        return messageDbReadCtx;
    }

    public EbeanServer getMessageDbWriteCtx() {
        return messageDbWriteCtx;
    }

    public <S extends T> void save(S entity) {
        messageDbWriteCtx.save(entity);
    }

    public <S extends T> void saveAll(Collection<S> entities) {
        messageDbWriteCtx.saveAll(entities);
    }

}
