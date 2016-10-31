package co.uniandes.serverBaymaxPi.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    
    private final String _id;
    
    private final String username;
    
    private final String cedula;
    
    private final String edad;
    
    private final String email;
    
    private final String eps;
    
    private final String celular;
    
    private final String contrasena;
    
    @JsonCreator
    public User(@JsonProperty("_id") String _id, @JsonProperty("username")String username, @JsonProperty("cedula")String cedula, @JsonProperty("edad")String edad, 
            @JsonProperty("email")String email, @JsonProperty("eps")String eps, @JsonProperty("celular")String celular, @JsonProperty("contrasena")String contrasena){
        
        this._id = _id;
        this.username = username;
        this.cedula = cedula;
        this.edad = edad;
        this.email = email;
        this.eps = eps;
        this.celular = celular;
        this.contrasena = contrasena;
    }

    public String getUsername() {
        return username;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEdad() {
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

    public String get_id() {
        return _id;
    }
}
