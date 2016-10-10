package co.edu.uniandes.baymaxpi.baymaxpi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import co.edu.uniandes.baymaxpi.baymaxpi.httpzoid.Http;
import co.edu.uniandes.baymaxpi.baymaxpi.httpzoid.HttpFactory;
import co.edu.uniandes.baymaxpi.baymaxpi.httpzoid.HttpResponse;
import co.edu.uniandes.baymaxpi.baymaxpi.httpzoid.NetworkError;
import co.edu.uniandes.baymaxpi.baymaxpi.httpzoid.ResponseHandler;

/**
 * Created by augustorodriguez on 8/10/16.
 */
public class EstadisticasActivity extends AppCompatActivity {

    private static final String URL_TODO = "http://172.20.10.14:4000/m2m/applications/TempSensor1/containers/tempContainer/contentInstances/";
    //private static final String URL_TODO = "http://10.0.2.2:9055/customer-settings/api/stylesheets/logo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        ButterKnife.inject(this);
    }

    public void onClickGetData (View view){

        Http http = HttpFactory.create(getApplicationContext());
        http.get(URL_TODO)
                //.header("Authentication", "adasdasd")
                .handler(new ResponseHandler<String>() {

                    @Override
                    public void success(String data, HttpResponse response) {
                        Log.v("jeje","success: " + data);
                    }

                    @Override
                    public void error(String message,
                                      HttpResponse response) {
                        Log.v("jeje","error");
                    }

                    @Override
                    public void failure(NetworkError error) {
                        Log.v("jeje","failure");
                    }

                    @Override
                    public void complete() {
                        Log.v("jeje","complete");
                    }
                }).send();
    }
}
