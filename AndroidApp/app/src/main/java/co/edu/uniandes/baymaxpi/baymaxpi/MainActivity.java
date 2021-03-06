package co.edu.uniandes.baymaxpi.baymaxpi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;

import butterknife.ButterKnife;
import co.edu.uniandes.baymaxpi.baymaxpi.Models.Paciente;

public class MainActivity extends AppCompatActivity {

    private Paciente paciente = new Paciente();
    public final static String PACIENTE = "Paciente";

    private String telefonoDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        try{

            String path = Environment.getExternalStorageDirectory().
                    getAbsolutePath() + "/Registros";
            BufferedReader br = new BufferedReader(new FileReader(path));

            String line = br.readLine();

            String[] data = line.split(",");

            telefonoDoctor = data[6];


        } catch (Exception e){

            suggestLogin();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar c = Calendar.getInstance();

                final File file = new File(Environment.getExternalStorageDirectory().
                        getAbsolutePath() + "/" + "DatosMedicos");
                if(!file.exists())
                {
                    file.mkdirs();
                }
                if (file.exists()){
                    String path = Environment.getExternalStorageDirectory().
                            getAbsolutePath() + "/DatosMedicos/" + paciente.getCedula() + ".txt";
                    Log.d("MedicionPaciente", path);
                    File newFile = new File(path);
                    file.renameTo(newFile);
                    try {

                        FileWriter writer = new FileWriter(file);
                        writer.append("Fecha: "+ c.getTime());
                        Double temperatura = Math.random()*40 + 35;
                        if(temperatura > 35 && temperatura < 40) {
                            String temp = temperatura + "";
                            writer.append("Temperatura: "+ temp);
                        }
                        Double saturacion = Math.random()*100 + 89;
                        if(saturacion > 89 && saturacion < 100) {
                            String sat = saturacion + "";
                            writer.append("Saturacion: "+ sat);
                        }
                        Double pulso = Math.random()*110 + 60;
                        if(pulso > 60 && pulso < 110) {
                            String pulse = pulso + "";
                            writer.append("Pulso: "+ pulse);
                        }
                        Double piel = Math.random()*25;
                        if(piel > 0 && piel < 25) {
                            String skin = piel + "";
                            writer.append("Piel: "+ skin);
                        }
                        Double presionSistolica = Math.random()*150 + 110;
                        if(presionSistolica > 110 && pulso < 150) {
                            String preSis = presionSistolica + "";
                            writer.append("Presion Sistolica: "+ preSis);
                        }
                        Double presionDiastolica = Math.random()*90 + 70;
                        if(presionDiastolica > 70 && pulso < 90) {
                            String preDias = presionDiastolica + "";
                            writer.append("Presion Diastolica: "+ preDias);
                        }
                        writer.flush();
                        writer.close();

                    } catch (Exception e1) {
                        Log.d("DatosMedicos", e1.getMessage());
                    }
                }

                Snackbar.make(view, "Se ha creado el archivo de datos en " + file.getAbsolutePath()+"/"+paciente.getCedula()+".txt", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void suggestLogin() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setPositiveButton("No se encuentra registrado, se sugiere completar su registro", null);
        AlertDialog ad = alertDialogBuilder.create();
        ad.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_registro) {
            Intent registroIntent = new Intent(MainActivity.this, RegistroActivity.class);
            MainActivity.this.startActivity(registroIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBtnProfileClicked(View view){
        Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
        MainActivity.this.startActivity(profileIntent);
    }

    public void onBtnEstadisticasClicked(View view){
        Intent estadisticasIntent = new Intent(MainActivity.this, EstadisticasActivity.class);
        MainActivity.this.startActivity(estadisticasIntent);
    }
}
