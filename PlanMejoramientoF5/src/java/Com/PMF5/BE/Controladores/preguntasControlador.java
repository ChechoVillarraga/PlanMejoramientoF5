/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.PMF5.BE.Controladores;

import Com.PMF5.BE.Entidades.Evaluacion;
import Com.PMF5.BE.Entidades.Pregunta;
import Com.PMF5.BE.Fachadas.EvaluacionFacade;
import Com.PMF5.BE.Fachadas.PreguntaFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.filter.ExactFilterConstraint;

/**
 *
 * @author Sergio
 */
@Named(value = "preguntasControlador")
@ViewScoped
public class preguntasControlador implements Serializable {

    private Evaluacion evaluaciones;
    private Pregunta pregunta;
    private List<Pregunta> preguntaLista;
    private EvaluacionControlador evaluacionControlador;

    @EJB
    private PreguntaFacade preguntaFacade;
    @EJB
    private EvaluacionFacade evaluacionFacade;

    /**
     * Creates a new instance of preguntasControlador
     */
    public preguntasControlador() {
        pregunta = new Pregunta();
    }

    public Evaluacion getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(Evaluacion evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public List<Pregunta> getPreguntaLista() {
        return preguntaLista;
    }

    public void setPreguntaLista(List<Pregunta> preguntaLista) {
        this.preguntaLista = preguntaLista;
    }

    public List<Pregunta> preguntasById() {
        int idEval = evaluacionControlador.ultimaEvalId();
        preguntaLista = preguntaFacade.queryByExamenId(idEval);
        return preguntaLista;
    }

    public void registrarPregunta() throws IOException {
        try {
            evaluaciones = evaluacionFacade.ultimaEvaluacion(evaluacionFacade.ultimaEvalId());
            pregunta.setEvaluacionesIdEvaluacion(evaluaciones);
            preguntaFacade.create(pregunta);
            System.out.println("Pregunta Registrada");
        } catch (Exception e) {

            System.out.println("Pregunta No registrado " + e.getMessage());
        }

    }

    public void finalizarCreacionn() {

    }

}
