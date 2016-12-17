/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.PMF5.BE.Fachadas;

import Com.PMF5.BE.Entidades.Evaluacion;
import Com.PMF5.BE.Entidades.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sergio
 */
@Stateless
public class EvaluacionFacade extends AbstractFacade<Evaluacion> {

    @PersistenceContext(unitName = "PlanMejoramientoF5PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluacionFacade() {
        super(Evaluacion.class);
    }

    public Integer ultimaEvalId() {
        Integer p = 0;
        try {
            p =  em.createQuery("SELECT MAX(e.idEvaluacion) FROM Evaluacion e", Integer.class)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en envio de datos"+ e.getMessage());
        } finally {
        }
        return p;
    }
    
    public Evaluacion ultimaEvaluacion(Integer id) {
        Evaluacion p = null;
        try {
            TypedQuery<Evaluacion> query = em.createNamedQuery("Evaluacion.findByIdEvaluacion", Evaluacion.class);
            query.setParameter("idEvaluacion", id);
            p = query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en envio de datos"+ e.getMessage());
        } finally {
        }
        return p;
    }

}
