package co.edu.uniandes.baymaxpi.baymaxpi.httpzoid;

/**
 * (c) Artur Sharipov
 */
public class NetworkAuthenticationException extends HttpzoidException {
    public NetworkAuthenticationException() {
        super("Network authentication required", NetworkError.AuthenticationRequired);
    }
}
