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
 * @author Sergio
 */
@Entity
@Table(name = "calificacionevaluaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacionevaluacion.findAll", query = "SELECT c FROM Calificacionevaluacion c"),
    @NamedQuery(name = "Calificacionevaluacion.findByIdCalificacion", query = "SELECT c FROM Calificacionevaluacion c WHERE c.idCalificacion = :idCalificacion"),
    @NamedQuery(name = "Calificacionevaluacion.findByNota", query = "SELECT c FROM Calificacionevaluacion c WHERE c.nota = :nota")})
public class Calificacionevaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCalificacion")
    private Integer idCalificacion;
    @Column(name = "nota")
    private Integer nota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calificacionIdCalificacionEvaluacion")
    private List<Califiacionpregunta> califiacionpreguntaList;
    @JoinColumn(name = "evaluacionesIdEvaluacion", referencedColumnName = "idEvaluacion")
    @ManyToOne(optional = false)
    private Evaluacion evaluacionesIdEvaluacion;
    @JoinColumn(name = "personasIdPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona personasIdPersona;

    public Calificacionevaluacion() {
    }

    public Calificacionevaluacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @XmlTransient
    public List<Califiacionpregunta> getCalifiacionpreguntaList() {
        return califiacionpreguntaList;
    }

    public void setCalifiacionpreguntaList(List<Califiacionpregunta> califiacionpreguntaList) {
        this.califiacionpreguntaList = califiacionpreguntaList;
    }

    public Evaluacion getEvaluacionesIdEvaluacion() {
        return evaluacionesIdEvaluacion;
    }

    public void setEvaluacionesIdEvaluacion(Evaluacion evaluacionesIdEvaluacion) {
        this.evaluacionesIdEvaluacion = evaluacionesIdEvaluacion;
    }

    public Persona getPersonasIdPersona() {
        return personasIdPersona;
    }

    public void setPersonasIdPersona(Persona personasIdPersona) {
        this.personasIdPersona = personasIdPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificacion != null ? idCalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacionevaluacion)) {
            return false;
        }
        Calificacionevaluacion other = (Calificacionevaluacion) object;
        if ((this.idCalificacion == null && other.idCalificacion != null) || (this.idCalificacion != null && !this.idCalificacion.equals(other.idCalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.PMF5.BE.Entidades.Calificacionevaluacion[ idCalificacion=" + idCalificacion + " ]";
    }
    
}
