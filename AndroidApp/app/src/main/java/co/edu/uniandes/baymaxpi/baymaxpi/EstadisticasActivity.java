package co.edu.uniandes.baymaxpi.baymaxpi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by ASUS on 19/09/2016.
 */
public class EstadisticasActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        ButterKnife.inject(this);

    }
}
