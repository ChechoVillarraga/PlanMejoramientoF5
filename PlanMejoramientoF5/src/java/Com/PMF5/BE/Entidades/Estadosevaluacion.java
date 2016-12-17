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
@Table(name = "estadosevaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadosevaluacion.findAll", query = "SELECT e FROM Estadosevaluacion e"),
    @NamedQuery(name = "Estadosevaluacion.findByIdEstado", query = "SELECT e FROM Estadosevaluacion e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "Estadosevaluacion.findByEstadoEvaluacion", query = "SELECT e FROM Estadosevaluacion e WHERE e.estadoEvaluacion = :estadoEvaluacion"),
    @NamedQuery(name = "Estadosevaluacion.findByDescripcionEstado", query = "SELECT e FROM Estadosevaluacion e WHERE e.descripcionEstado = :descripcionEstado")})
public class Estadosevaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstado")
    private Integer idEstado;
    @Size(max = 45)
    @Column(name = "estadoEvaluacion")
    private String estadoEvaluacion;
    @Size(max = 200)
    @Column(name = "descripcionEstado")
    private String descripcionEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadosEvaluacionidEstado")
    private List<Evaluacion> evaluacionList;

    public Estadosevaluacion() {
    }

    public Estadosevaluacion(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstadoEvaluacion() {
        return estadoEvaluacion;
    }

    public void setEstadoEvaluacion(String estadoEvaluacion) {
        this.estadoEvaluacion = estadoEvaluacion;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadosevaluacion)) {
            return false;
        }
        Estadosevaluacion other = (Estadosevaluacion) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.PMF5.BE.Entidades.Estadosevaluacion[ idEstado=" + idEstado + " ]";
    }
    
}
