package co.uniandes.serverBaymaxPi.infrasctructure.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    
    private final String username;
    
    private final String cedula;
    
    private final int edad;
    
    private final String email;
    
    private final String eps;
    
    private final String celular;
    
    private final String contrasena;
    
    private final String tipoUsuario;
    
    private final String tarjeta;
    
    @JsonCreator
    public UserDTO(@JsonProperty("username")String username, @JsonProperty("cedula")String cedula, @JsonProperty("edad")int edad, 
            @JsonProperty("email")String email, @JsonProperty("eps")String eps, @JsonProperty("celular")String celular, @JsonProperty("contrasena")String contrasena,
            @JsonProperty("tipoUsuario")String tipoUsuario, @JsonProperty("tarjeta")String tarjeta){
        
        this.username = username;
        this.cedula = cedula;
        this.edad = edad;
        this.email = email;
        this.eps = eps;
        this.celular = celular;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
        this.tarjeta = tarjeta;
    }

    public String getUsername() {
        return username;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public String getEps() {
        return eps;
    }

    public String getCelular() {
        return celular;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    
    public String getTarjeta() {
        return tarjeta;
    }
}
