package co.uniandes.serverBaymaxPi.infrasctructure.DTOs;

public class UserDTO {
    
    private final String username;
    
    private final String cedula;
    
    private final int edad;
    
    private final String email;
    
    private final String eps;
    
    private final String celular;
    
    private final String contrasena;
    
    public UserDTO(String username, String cedula, int edad, String email, String eps, String celular, String contrasena){
        
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
}
