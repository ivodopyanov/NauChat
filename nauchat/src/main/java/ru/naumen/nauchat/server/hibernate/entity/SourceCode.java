/**
 * 
 */
package ru.naumen.nauchat.server.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
@Entity
@Table(name = "tbl_source")
public class SourceCode implements Serializable
{
    private static final long serialVersionUID = 5608369663019986314L;

    @Id
    private Long id;

    @Column
    private String source;

    public Long getId()
    {
        return id;
    }

    public String getSource()
    {
        return source;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setSource(String source)
    {
        this.source = source;
    }
}