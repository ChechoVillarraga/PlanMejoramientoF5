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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "preguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findByIdPregunta", query = "SELECT p FROM Pregunta p WHERE p.idPregunta = :idPregunta"),
    @NamedQuery(name = "Pregunta.findByEnunciado", query = "SELECT p FROM Pregunta p WHERE p.enunciado = :enunciado"),
    @NamedQuery(name = "Pregunta.findByValorPregunta", query = "SELECT p FROM Pregunta p WHERE p.valorPregunta = :valorPregunta"),
    @NamedQuery(name = "Pregunta.findByPreguntaModificada", query = "SELECT p FROM Pregunta p WHERE p.preguntaModificada = :preguntaModificada")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPregunta")
    private Integer idPregunta;
    @Size(max = 450)
    @Column(name = "enunciado")
    private String enunciado;
    @Column(name = "valorPregunta")
    private Integer valorPregunta;
    @Column(name = "preguntaModificada")
    private Boolean preguntaModificada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preguntasidPregunta")
    private List<Preguntamodificada> preguntamodificadaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preguntasIdPregunta")
    private List<Califiacionpregunta> califiacionpreguntaList;
    @JoinColumn(name = "EvaluacionesIdEvaluacion", referencedColumnName = "idEvaluacion")
    @ManyToOne(optional = false)
    private Evaluacion evaluacionesIdEvaluacion;

    public Pregunta() {
    }

    public Pregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Integer getValorPregunta() {
        return valorPregunta;
    }

    public void setValorPregunta(Integer valorPregunta) {
        this.valorPregunta = valorPregunta;
    }

    public Boolean getPreguntaModificada() {
        return preguntaModificada;
    }

    public void setPreguntaModificada(Boolean preguntaModificada) {
        this.preguntaModificada = preguntaModificada;
    }

    @XmlTransient
    public List<Preguntamodificada> getPreguntamodificadaList() {
        return preguntamodificadaList;
    }

    public void setPreguntamodificadaList(List<Preguntamodificada> preguntamodificadaList) {
        this.preguntamodificadaList = preguntamodificadaList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.PMF5.BE.Entidades.Pregunta[ idPregunta=" + idPregunta + " ]";
    }
    
}
