package co.edu.uniandes.baymaxpi.baymaxpi.httpzoid;

import android.content.Context;
import android.net.ConnectivityManager;
import co.edu.uniandes.baymaxpi.baymaxpi.httpzoid.serializers.JsonHttpSerializer;

/**
 * (c) Artur Sharipov
 */
public class HttpFactory {
    public static Http create(Context context) {
        return new HttpUrlConnection(new JsonHttpSerializer(),
                new NetworkImpl((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE)));
    }
}
