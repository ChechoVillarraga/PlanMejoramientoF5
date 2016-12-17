/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.PMF5.BE.Controladores;

import Com.PMF5.BE.Fachadas.PersonaFacade;
import Com.PMF5.BE.Entidades.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String mensaje;
    private String correo;
    private String clave;
    private String url;
    private Persona personas;
    private List<Persona> listaPersonas;
    private HttpSession objSesion;
    @EJB
    private PersonaFacade personasFacade;

    
    
    public String ingresar() {
        
        personas = personasFacade.validarLogin(correo, clave);
        if (personas != null) {
            
            url = "ingreso/index?faces-redirect=true";
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogeado", personas);
        } else {
            url = "index?faces-redirect=true";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correo o Contraseña incorrectos. Por favor verifique"));
        }
        return url;
    }
    
    public Persona getUsuarioLogin(){
        return (Persona)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogeado");
    }
    
    private void asignar(){
        
    }

    public LoginController() {
        
    }

    @PostConstruct
    public void init() {
        personas = new Persona();
    }

    public Persona getPersonas() {
        return personas;
    }

    public void setPersonas(Persona personas) {
        this.personas = personas;
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    
    
}
