package co.edu.uniandes.baymaxpi.baymaxpi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.util.ArrayList;

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

    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        arrayList = new ArrayList<String>();
        list = (ListView) findViewById(R.id.listView2);
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        list.setAdapter(adapter);

        ButterKnife.inject(this);
    }

    public void onClickGetData (View view){

        Http http = HttpFactory.create(getApplicationContext());
        http.get(URL_TODO)
                .handler(new ResponseHandler<String>() {

                    @Override
                    public void success(String data, HttpResponse response) {

                        JsonParser parser = new JsonParser();
                        JsonObject dataJson = parser.parse(data).getAsJsonObject();

                        JsonArray JOContentInstances = dataJson.getAsJsonObject("contentInstances").getAsJsonObject("contentInstanceCollection").getAsJsonArray("contentInstance");

                        for (int i = 0 ; JOContentInstances.size()>i ; i ++ ){

                            JsonElement je = JOContentInstances.get(i);
                            JsonObject jo = je.getAsJsonObject();
                            JsonObject jo2 = jo.get("content").getAsJsonObject();
                            String binarycontent = jo2.get("binaryContent").getAsString();
                            byte[] binarycontentBytes = Base64.decode(binarycontent, Base64.DEFAULT);
                            String text = new String(binarycontentBytes);
                            JsonObject healthData = parser.parse(text).getAsJsonObject();

                            adapter.add("Temperature: " + healthData.get("temperature").getAsString() + ", Presion: "+ healthData.get("presion").getAsString());
                        }
                        adapter.notifyDataSetChanged();
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


                    }
                }).send();
    }
}
