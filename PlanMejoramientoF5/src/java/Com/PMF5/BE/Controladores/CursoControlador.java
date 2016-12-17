/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.PMF5.BE.Controladores;

import Com.PMF5.BE.Entidades.Curso;
import Com.PMF5.BE.Fachadas.CursoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author Sergio
 */
@Named(value = "cursoControlador")
@RequestScoped
public class CursoControlador implements Serializable {

    private Curso cursos;
    @EJB
    private CursoFacade cursosFacade;

    public CursoControlador() {
    }

    public List<Curso> listarCursos() {
        return cursosFacade.findAll();
    }

    public Curso getCurso(java.lang.Integer id) {
        return cursosFacade.find(id);
    }

    @FacesConverter(forClass = Curso.class)
    public static class CursoControllerConvertidor implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CursoControlador controlador = (CursoControlador) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cursoControlador");
            return controlador.getCurso(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Curso) {
                Curso o = (Curso) object;
                return getStringKey(o.getIdCurso());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Curso.class.getName());
            }
        }
    }
}
