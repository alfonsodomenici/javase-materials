/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bilancino.business.flussi.entity;

import it.tss.bilancino.business.security.entity.Utente;
import it.tss.bilancino.business.validation.ValidEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tss
 */
@NamedQueries({
  @NamedQuery(name = Flusso.FIND_ALL,
      query = "select e from Flusso e order by e.data ")
  ,
  @NamedQuery(name = Flusso.FIND_BY_UTENTE,
      query = "select e from Flusso e where e.utente= :u order by e.data ")
  ,
  @NamedQuery(name = Flusso.FIND_BY_TIPO,
      query = "select e from Flusso e where e.tipo = :tipo order by e.data ")
  ,
  @NamedQuery(name = Flusso.FIND_NON_RICORRENTI,
      query = "select e from Flusso e where TYPE(e) <> FlussoPeriodico order by e.data ")
  ,
 @NamedQuery(name = Flusso.FIND_NON_RICORRENTI_BY_UTENTE,
      query = "select e from Flusso e where TYPE(e) <> FlussoPeriodico and e.utente= :u order by e.data "),})

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EntityListeners(FlussoAudit.class)
public class Flusso implements Serializable, ValidEntity {

  public final static String FIND_ALL = "Flusso.findAll";
  public final static String FIND_BY_UTENTE = "Flusso.findByUtente";
  public final static String FIND_BY_TIPO = "Flusso.findByTipo";
  public final static String FIND_NON_RICORRENTI = "Flusso.findNonRicorrenti";
  public final static String FIND_NON_RICORRENTI_BY_UTENTE = "Flusso.findNonRicorrentiByUtente";

  public static enum Tipo {
    ENTRATA, USCITA
  }

  public Flusso() {
    importo = BigDecimal.ZERO;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(scale = 2, nullable = false)
  private BigDecimal importo;

  @Temporal(TemporalType.TIMESTAMP)
  private Date data = new Date();

  @ElementCollection
  private List<String> tags;

  @Enumerated(EnumType.STRING)
  private Tipo tipo = Tipo.USCITA;

  @ManyToOne
  private Utente utente;

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 29 * hash + Objects.hashCode(this.id);
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
    final Flusso other = (Flusso) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Flusso{" + "id=" + id + ", importo=" + importo + ", data=" + data + ", tags=" + tags + '}';
  }

  /*
  get e set
   */
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getImporto() {
    return importo;
  }

  public void setImporto(BigDecimal importo) {
    this.importo = importo;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public Utente getUtente() {
    return utente;
  }

  public void setUtente(Utente utente) {
    this.utente = utente;
  }

}
