/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.PMF5.BE.Entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "preguntamodificadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntamodificada.findAll", query = "SELECT p FROM Preguntamodificada p"),
    @NamedQuery(name = "Preguntamodificada.findByIdPreguntaModificadas", query = "SELECT p FROM Preguntamodificada p WHERE p.idPreguntaModificadas = :idPreguntaModificadas"),
    @NamedQuery(name = "Preguntamodificada.findByPreguntaOriginal", query = "SELECT p FROM Preguntamodificada p WHERE p.preguntaOriginal = :preguntaOriginal"),
    @NamedQuery(name = "Preguntamodificada.findByValorPreguntaOrignial", query = "SELECT p FROM Preguntamodificada p WHERE p.valorPreguntaOrignial = :valorPreguntaOrignial"),
    @NamedQuery(name = "Preguntamodificada.findByFechaModificacion", query = "SELECT p FROM Preguntamodificada p WHERE p.fechaModificacion = :fechaModificacion")})
public class Preguntamodificada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPreguntaModificadas")
    private Integer idPreguntaModificadas;
    @Size(max = 400)
    @Column(name = "preguntaOriginal")
    private String preguntaOriginal;
    @Column(name = "valorPreguntaOrignial")
    private Integer valorPreguntaOrignial;
    @Column(name = "fechaModificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @JoinColumn(name = "Preguntas_idPregunta", referencedColumnName = "idPregunta")
    @ManyToOne(optional = false)
    private Pregunta preguntasidPregunta;

    public Preguntamodificada() {
    }

    public Preguntamodificada(Integer idPreguntaModificadas) {
        this.idPreguntaModificadas = idPreguntaModificadas;
    }

    public Integer getIdPreguntaModificadas() {
        return idPreguntaModificadas;
    }

    public void setIdPreguntaModificadas(Integer idPreguntaModificadas) {
        this.idPreguntaModificadas = idPreguntaModificadas;
    }

    public String getPreguntaOriginal() {
        return preguntaOriginal;
    }

    public void setPreguntaOriginal(String preguntaOriginal) {
        this.preguntaOriginal = preguntaOriginal;
    }

    public Integer getValorPreguntaOrignial() {
        return valorPreguntaOrignial;
    }

    public void setValorPreguntaOrignial(Integer valorPreguntaOrignial) {
        this.valorPreguntaOrignial = valorPreguntaOrignial;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Pregunta getPreguntasidPregunta() {
        return preguntasidPregunta;
    }

    public void setPreguntasidPregunta(Pregunta preguntasidPregunta) {
        this.preguntasidPregunta = preguntasidPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreguntaModificadas != null ? idPreguntaModificadas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preguntamodificada)) {
            return false;
        }
        Preguntamodificada other = (Preguntamodificada) object;
        if ((this.idPreguntaModificadas == null && other.idPreguntaModificadas != null) || (this.idPreguntaModificadas != null && !this.idPreguntaModificadas.equals(other.idPreguntaModificadas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.PMF5.BE.Entidades.Preguntamodificada[ idPreguntaModificadas=" + idPreguntaModificadas + " ]";
    }
    
}
