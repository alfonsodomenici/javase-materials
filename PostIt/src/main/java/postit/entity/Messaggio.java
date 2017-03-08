/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postit.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author alfonso
 */
@NamedQueries({
    @NamedQuery(name = Messaggio.FIND_ALL,
            query = "select e from Messaggio e order by e.dataCreazione DESC")
    ,
    @NamedQuery(name = Messaggio.FIND_BY_USER,
            query = "select e from Messaggio e where e.utente= :usr order by e.dataCreazione DESC")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Messaggio implements Serializable {

    public static final String FIND_ALL = "Messaggio.findAll";
    public static final String FIND_BY_USER = "Messaggio.findByUser";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titolo;
    
    private String contenuto;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CREAZIONE")
    private Date dataCreazione = new Date();
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Utente utente;

    public Messaggio() {
    }

    public Messaggio(String titolo, String contenuto, Utente utente) {
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.utente = utente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Messaggio other = (Messaggio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Postit{" + "id=" + id + ", titolo=" + titolo + ", contenuto=" + contenuto + ", dataCreazione=" + dataCreazione + ", utente=" + utente + '}';
    }

}
