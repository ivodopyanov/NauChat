/**
 * 
 */
package ru.naumen.nauchat.server.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
@Entity
@Table(name = "tbl_player")
public class Player implements Serializable
{
    private static final long serialVersionUID = -6444153258637414904L;

    @Id
    private Long id;

    @Column(name = "login")
    private String login;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<SourceCode> sources;

    public Long getId()
    {
        return id;
    }

    public String getLogin()
    {
        return login;
    }

    public Set<SourceCode> getSources()
    {
        return sources;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public void setSources(Set<SourceCode> sources)
    {
        this.sources = sources;
    }
}