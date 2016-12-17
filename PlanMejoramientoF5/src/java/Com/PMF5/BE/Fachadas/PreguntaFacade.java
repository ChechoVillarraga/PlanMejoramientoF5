/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.PMF5.BE.Fachadas;

import Com.PMF5.BE.Entidades.Pregunta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sergio
 */
@Stateless
public class PreguntaFacade extends AbstractFacade<Pregunta> {

    @PersistenceContext(unitName = "PlanMejoramientoF5PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntaFacade() {
        super(Pregunta.class);
    }
    
    public List<Pregunta> queryByExamenId(int id) {
        List<Pregunta> p = null;
        try {
            p = em.createQuery("SELECT p FROM Pregunta p WHERE p.evaluacionesIdEvaluacion = :a", Pregunta.class)
                    .setParameter("a", id)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error en envio de datos");
            e.printStackTrace();
        } finally {
        }
        return p;
    }
    
}
