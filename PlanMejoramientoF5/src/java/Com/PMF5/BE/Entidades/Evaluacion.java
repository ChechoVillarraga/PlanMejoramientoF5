/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.PMF5.BE.Entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "evaluaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByIdEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "Evaluacion.findByTituloEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.tituloEvaluacion = :tituloEvaluacion"),
    @NamedQuery(name = "Evaluacion.findByFechaAplicacion", query = "SELECT e FROM Evaluacion e WHERE e.fechaAplicacion = :fechaAplicacion")})
public class Evaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEvaluacion")
    private Integer idEvaluacion;
    @Size(max = 90)
    @Column(name = "tituloEvaluacion")
    private String tituloEvaluacion;
    @Column(name = "fechaAplicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAplicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacionesIdEvaluacion")
    private List<Calificacionevaluacion> calificacionevaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacionesIdEvaluacion")
    private List<Pregunta> preguntaList;
    @JoinColumn(name = "Cursos_idCurso", referencedColumnName = "idCurso")
    @ManyToOne(optional = false)
    private Curso cursosidCurso;
    @JoinColumn(name = "EstadosEvaluacion_idEstado", referencedColumnName = "idEstado")
    @ManyToOne(optional = false)
    private Estadosevaluacion estadosEvaluacionidEstado;

    public Evaluacion() {
    }

    public Evaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Integer getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getTituloEvaluacion() {
        return tituloEvaluacion;
    }

    public void setTituloEvaluacion(String tituloEvaluacion) {
        this.tituloEvaluacion = tituloEvaluacion;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    @XmlTransient
    public List<Calificacionevaluacion> getCalificacionevaluacionList() {
        return calificacionevaluacionList;
    }

    public void setCalificacionevaluacionList(List<Calificacionevaluacion> calificacionevaluacionList) {
        this.calificacionevaluacionList = calificacionevaluacionList;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    public Curso getCursosidCurso() {
        return cursosidCurso;
    }

    public void setCursosidCurso(Curso cursosidCurso) {
        this.cursosidCurso = cursosidCurso;
    }

    public Estadosevaluacion getEstadosEvaluacionidEstado() {
        return estadosEvaluacionidEstado;
    }

    public void setEstadosEvaluacionidEstado(Estadosevaluacion estadosEvaluacionidEstado) {
        this.estadosEvaluacionidEstado = estadosEvaluacionidEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluacion != null ? idEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.idEvaluacion == null && other.idEvaluacion != null) || (this.idEvaluacion != null && !this.idEvaluacion.equals(other.idEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.PMF5.BE.Entidades.Evaluacion[ idEvaluacion=" + idEvaluacion + " ]";
    }
    
}
