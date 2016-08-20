package io.developerinator.app.domain;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> extends Persistable {

    @Transient
    protected T unmodifiedState;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date dateCreated;

    /**
     * The user doing the update/delete action.
     */
    @CreatedBy
    protected String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date dateModified;

    @LastModifiedBy
    protected String modifiedBy;

    /* Initialize unmodifiedState here */
    @SuppressWarnings("unchecked")
    @PostLoad
    public void onLoad() throws InstantiationException, IllegalAccessException {
        this.unmodifiedState = (T) this.getClass().newInstance();
        BeanUtils.copyProperties(this, unmodifiedState);
    }

    ;

    /**
     * Should be used for audit trail purposes
     *
     * @return a String displaying object state before and after creation/modification
     */
    @Transient
    public String getDataChange() {
        StringBuilder s = new StringBuilder();
        if (Objects.nonNull(unmodifiedState)) {
            s.append("BEFORE: ").append(unmodifiedState).append(" | ");
            s.append("AFTER: ").append(toString());
        } else {
            s.append(toString());
        }
        return s.toString();
    }

}
