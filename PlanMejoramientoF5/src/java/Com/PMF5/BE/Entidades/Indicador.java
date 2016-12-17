/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.PMF5.BE.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "indicadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicador.findAll", query = "SELECT i FROM Indicador i"),
    @NamedQuery(name = "Indicador.findByIdIndicador", query = "SELECT i FROM Indicador i WHERE i.idIndicador = :idIndicador"),
    @NamedQuery(name = "Indicador.findByIndicador", query = "SELECT i FROM Indicador i WHERE i.indicador = :indicador"),
    @NamedQuery(name = "Indicador.findByValorIndicador", query = "SELECT i FROM Indicador i WHERE i.valorIndicador = :valorIndicador")})
public class Indicador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIndicador")
    private Integer idIndicador;
    @Size(max = 45)
    @Column(name = "indicador")
    private String indicador;
    @Column(name = "valorIndicador")
    private Integer valorIndicador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "indicadoresIdIndicador")
    private List<Califiacionpregunta> califiacionpreguntaList;

    public Indicador() {
    }

    public Indicador(Integer idIndicador) {
        this.idIndicador = idIndicador;
    }

    public Integer getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Integer idIndicador) {
        this.idIndicador = idIndicador;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public Integer getValorIndicador() {
        return valorIndicador;
    }

    public void setValorIndicador(Integer valorIndicador) {
        this.valorIndicador = valorIndicador;
    }

    @XmlTransient
    public List<Califiacionpregunta> getCalifiacionpreguntaList() {
        return califiacionpreguntaList;
    }

    public void setCalifiacionpreguntaList(List<Califiacionpregunta> califiacionpreguntaList) {
        this.califiacionpreguntaList = califiacionpreguntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIndicador != null ? idIndicador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicador)) {
            return false;
        }
        Indicador other = (Indicador) object;
        if ((this.idIndicador == null && other.idIndicador != null) || (this.idIndicador != null && !this.idIndicador.equals(other.idIndicador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.PMF5.BE.Entidades.Indicador[ idIndicador=" + idIndicador + " ]";
    }
    
}
