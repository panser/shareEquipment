package ua.org.gostroy.model.persistance;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.persistence.*;

/**
 * Created by Sergey on 3/29/2015.
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Version
    protected Long version;

    protected transient final Logger LOG = LogManager.getLogger(getClass());

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean isNew() {
        return (this.id == null);
    }

}
