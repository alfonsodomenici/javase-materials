/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postit.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alfonso
 */


@NamedQueries({
  @NamedQuery(name = Utente.FIND_ALL,
      query = "select e from Utente e order by e.usr")
  ,
    @NamedQuery(name = Utente.FIND_BY_USER_PWD,
      query = "select e from Utente e where e.usr= :usr and e.pwd= :pwd")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Utente implements Serializable {

  public static final String FIND_ALL = "Utente.findAll";
  public static final String FIND_BY_USER_PWD = "Utente.findByUserPwd";

  public Utente() {
  }

  public Utente(String usr, String pwd) {
    this.usr = usr;
    this.pwd = pwd;
  }

  public Utente(String usr, String pwd, String email) {
    this.usr = usr;
    this.pwd = pwd;
    this.email = email;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String usr;

  @Column(nullable = false)
  private String pwd;

  private String email;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsr() {
    return usr;
  }

  public void setUsr(String usr) {
    this.usr = usr;
  }

  
  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 73 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Utente other = (Utente) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Utente{" + "id=" + id + ", usr=" + usr + ", pwd=" + pwd + ", email=" + email + '}';
  }

}
