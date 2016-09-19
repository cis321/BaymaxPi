package co.edu.uniandes.baymaxpi.baymaxpi.Models;

import android.app.Application;
import com.parse.Parse;

/**
 * Created by ASUS on 18/09/2016.
 */
public class BaymaxPiApplication extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "lgp2XLsu0Vg7OZMioNR93CDESb3Jm41ZHQ4dsffm", "pJGieBCE1S37Kwwo87o5RXDaBxOaNaPlRLk6G33g");
    }
}
