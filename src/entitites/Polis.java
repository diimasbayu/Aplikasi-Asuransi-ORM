/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dbayu
 */
@Entity
@Table(name = "POLIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Polis.findAll", query = "SELECT p FROM Polis p")
    , @NamedQuery(name = "Polis.findByNoPolis", query = "SELECT p FROM Polis p WHERE p.noPolis = :noPolis")})
public class Polis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NO_POLIS")
    private String noPolis;
    @OneToMany(mappedBy = "noPolis", fetch = FetchType.LAZY)
    private List<Pembayaran> pembayaranList;
    @JoinColumn(name = "NIK", referencedColumnName = "NIK")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nasabah nik;

    public Polis() {
    }

    public Polis(String noPolis) {
        this.noPolis = noPolis;
    }

    public String getNoPolis() {
        return noPolis;
    }

    public void setNoPolis(String noPolis) {
        this.noPolis = noPolis;
    }

    @XmlTransient
    public List<Pembayaran> getPembayaranList() {
        return pembayaranList;
    }

    public void setPembayaranList(List<Pembayaran> pembayaranList) {
        this.pembayaranList = pembayaranList;
    }

    public Nasabah getNik() {
        return nik;
    }

    public void setNik(Nasabah nik) {
        this.nik = nik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noPolis != null ? noPolis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polis)) {
            return false;
        }
        Polis other = (Polis) object;
        if ((this.noPolis == null && other.noPolis != null) || (this.noPolis != null && !this.noPolis.equals(other.noPolis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitites.Polis[ noPolis=" + noPolis + " ]";
    }
    
}
