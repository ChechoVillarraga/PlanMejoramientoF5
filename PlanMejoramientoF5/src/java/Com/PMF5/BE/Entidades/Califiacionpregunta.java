/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.PMF5.BE.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "califiacionpreguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Califiacionpregunta.findAll", query = "SELECT c FROM Califiacionpregunta c"),
    @NamedQuery(name = "Califiacionpregunta.findByIdCalifiacionP", query = "SELECT c FROM Califiacionpregunta c WHERE c.idCalifiacionP = :idCalifiacionP"),
    @NamedQuery(name = "Califiacionpregunta.findByNotaPregunta", query = "SELECT c FROM Califiacionpregunta c WHERE c.notaPregunta = :notaPregunta")})
public class Califiacionpregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCalifiacionP")
    private Integer idCalifiacionP;
    @Column(name = "notaPregunta")
    private Integer notaPregunta;
    @JoinColumn(name = "CalificacionIdCalificacionEvaluacion", referencedColumnName = "idCalificacion")
    @ManyToOne(optional = false)
    private Calificacionevaluacion calificacionIdCalificacionEvaluacion;
    @JoinColumn(name = "IndicadoresIdIndicador", referencedColumnName = "idIndicador")
    @ManyToOne(optional = false)
    private Indicador indicadoresIdIndicador;
    @JoinColumn(name = "PreguntasIdPregunta", referencedColumnName = "idPregunta")
    @ManyToOne(optional = false)
    private Pregunta preguntasIdPregunta;

    public Califiacionpregunta() {
    }

    public Califiacionpregunta(Integer idCalifiacionP) {
        this.idCalifiacionP = idCalifiacionP;
    }

    public Integer getIdCalifiacionP() {
        return idCalifiacionP;
    }

    public void setIdCalifiacionP(Integer idCalifiacionP) {
        this.idCalifiacionP = idCalifiacionP;
    }

    public Integer getNotaPregunta() {
        return notaPregunta;
    }

    public void setNotaPregunta(Integer notaPregunta) {
        this.notaPregunta = notaPregunta;
    }

    public Calificacionevaluacion getCalificacionIdCalificacionEvaluacion() {
        return calificacionIdCalificacionEvaluacion;
    }

    public void setCalificacionIdCalificacionEvaluacion(Calificacionevaluacion calificacionIdCalificacionEvaluacion) {
        this.calificacionIdCalificacionEvaluacion = calificacionIdCalificacionEvaluacion;
    }

    public Indicador getIndicadoresIdIndicador() {
        return indicadoresIdIndicador;
    }

    public void setIndicadoresIdIndicador(Indicador indicadoresIdIndicador) {
        this.indicadoresIdIndicador = indicadoresIdIndicador;
    }

    public Pregunta getPreguntasIdPregunta() {
        return preguntasIdPregunta;
    }

    public void setPreguntasIdPregunta(Pregunta preguntasIdPregunta) {
        this.preguntasIdPregunta = preguntasIdPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalifiacionP != null ? idCalifiacionP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Califiacionpregunta)) {
            return false;
        }
        Califiacionpregunta other = (Califiacionpregunta) object;
        if ((this.idCalifiacionP == null && other.idCalifiacionP != null) || (this.idCalifiacionP != null && !this.idCalifiacionP.equals(other.idCalifiacionP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.PMF5.BE.Entidades.Califiacionpregunta[ idCalifiacionP=" + idCalifiacionP + " ]";
    }
    
}
