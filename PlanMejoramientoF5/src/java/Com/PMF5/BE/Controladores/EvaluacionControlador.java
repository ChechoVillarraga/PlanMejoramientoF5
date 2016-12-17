package Com.PMF5.BE.Controladores;

import Com.PMF5.BE.Entidades.Curso;
import Com.PMF5.BE.Entidades.Estadosevaluacion;
import Com.PMF5.BE.Fachadas.EvaluacionFacade;
import Com.PMF5.BE.Entidades.Evaluacion;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "evaluacionControlador")
@RequestScoped
public class EvaluacionControlador implements Serializable {

    private Evaluacion evaluaciones;
    private Curso cursos;
    @EJB
    private EvaluacionFacade evaluacionesFacade;

    public EvaluacionControlador() {
        evaluaciones = new Evaluacion();
    }

    public Evaluacion getEvaluacion() {
        return evaluaciones;
    }

    public Curso getCurso() {
        return cursos;
    }

    public void setCurso(Curso cursos) {
        this.cursos = cursos;
    }

    public void setEvaluacion(Evaluacion evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public void registrarEvaluacion() throws IOException {
        String url = "";
        try {
            Estadosevaluacion estadosevaluacion = new Estadosevaluacion();
            estadosevaluacion.setIdEstado(1);
            evaluaciones.setCursosidCurso(cursos);
            evaluaciones.setEstadosEvaluacionidEstado(estadosevaluacion);
            evaluacionesFacade.create(evaluaciones);
            System.out.println("Registrado");
        } catch (Exception e) {

            System.out.println("No registrado " + e.getMessage());
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("AnadirPreguntas.xhtml");

    }
    
    public Integer ultimaEvalId(){
        return evaluacionesFacade.ultimaEvalId();
    }
    
    public Evaluacion utimaEvaluacion(){
        Integer id = ultimaEvalId();
        return evaluacionesFacade.ultimaEvaluacion(id);
    }

}
