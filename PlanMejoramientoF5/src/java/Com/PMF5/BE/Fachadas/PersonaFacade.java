/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.PMF5.BE.Fachadas;

import Com.PMF5.BE.Entidades.Persona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sergio
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "PlanMejoramientoF5PU")
    private EntityManager em;
    
        private Persona persona;

    public Persona validarLogin(String user, String password) {
        Persona p = null;
        try {
            TypedQuery<Persona> query = em.createNamedQuery("Persona.findByLogin", Persona.class);
            query.setParameter("ce", user);
            query.setParameter("cv", password);
            p = query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en envio de datos");
            e.printStackTrace();
        } finally {
        }
        return p;

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
}
