package pw2.gestionacademica.pw2_2025_proyectofinal.view;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import pw2.gestionacademica.pw2_2025_proyectofinal.controller.EstudiantesInteractor;
import pw2.gestionacademica.pw2_2025_proyectofinal.controller.EstudiantesInteractorImpl;
import pw2.gestionacademica.pw2_2025_proyectofinal.controller.ProfesoresInteractor;
import pw2.gestionacademica.pw2_2025_proyectofinal.controller.ProfesoresInteractorImpl;

import java.io.IOException;
import java.io.Serializable;


@Named("LoginBean")
@SessionScoped
public class LoginBean implements Serializable{

    private String usuario;
    private String contra;
    private int cuenta;
    private boolean autenticadoPortalCatedraticos = false;
    private boolean autenticadoPortalPadres = false;
    private EstudiantesInteractor controllerEstudiantes;
    private ProfesoresInteractor controllerProfesores;


    public LoginBean() {
        controllerEstudiantes = new EstudiantesInteractorImpl();
        controllerProfesores = new ProfesoresInteractorImpl();
    }

    public void evitarCache() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().setResponseHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        ctx.getExternalContext().setResponseHeader("Pragma", "no-cache");
        ctx.getExternalContext().setResponseHeader("Expires", "0");
    }

    public void verificarSesionPortalCatedraticos() throws IOException {
        evitarCache();

        if (!autenticadoPortalCatedraticos) {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("login.xhtml");
        }
    }

    public void verificarSesionPortalPadres() throws IOException {
        evitarCache();

        if (!autenticadoPortalPadres) {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("login.xhtml");
        }
    }

    public String loginPortalCatedraticos() {
        if (buscarProfesorPorUsuarioContra()) {
            evitarCache();
            autenticadoPortalCatedraticos = true;
            return "profesores.xhtml?faces-redirect=true";
        } else {
            showError("Error de autenticación");
            return "";
        }
    }

    public String loginPortalPadres() {
        if (buscarEstudiantePorNumeroCuenta()) {
            evitarCache();
            autenticadoPortalPadres = true;
            return "portal-padres.xhtml?faces-redirect=true";
        } else {
            showError("Error de autenticación");
            return "";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContra() {
        return contra;
    }
    public void setContra(String contra) {
        this.contra = contra;
    }
    public int getCuenta() {
        return cuenta;
    }
    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public boolean buscarEstudiantePorNumeroCuenta() {
        return controllerEstudiantes.consultarEstudiantePorNumero_cuenta(cuenta);
    }

    public boolean buscarProfesorPorUsuarioContra() {
        return controllerProfesores.consultarProfesorPorUsuarioContra(usuario, contra);
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showError(String contenido) {
        addMessage(FacesMessage.SEVERITY_ERROR, "Error", contenido);
    }
}
