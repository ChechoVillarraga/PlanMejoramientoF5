/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.PMF5.BE.Fachadas;

import Com.PMF5.BE.Entidades.Califiacionpregunta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sergio
 */
@Stateless
public class CalifiacionpreguntaFacade extends AbstractFacade<Califiacionpregunta> {

    @PersistenceContext(unitName = "PlanMejoramientoF5PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalifiacionpreguntaFacade() {
        super(Califiacionpregunta.class);
    }
    
}
