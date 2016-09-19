package co.edu.uniandes.baymaxpi.baymaxpi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.edu.uniandes.baymaxpi.baymaxpi.Models.Paciente;

public class ProfileActivity extends AppCompatActivity {

    @InjectView(R.id.userName) TextView mNombreUsuario;
    @InjectView(R.id.textEPS) TextView mEps;
    @InjectView(R.id.textCC) TextView mCedula;
    @InjectView(R.id.textEmail) TextView mCorreo;
    @InjectView(R.id.textNacimiento)TextView mNacimiento;
    @InjectView(R.id.textDireccion) TextView mDireccion;;
    @InjectView(R.id.textHealthStatus)TextView mHealth;
    @InjectView(R.id.imageStatus)ImageView mStatus;

    private Paciente paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.inject(this);

        Intent intent = getIntent();

        paciente = intent.getParcelableExtra(MainActivity.PACIENTE);
        if(paciente!= null) {
            mNombreUsuario.setText(paciente.getNombre());
            mEps.setText(paciente.getEps());
            mCedula.setText(paciente.getCedula());
            mCorreo.setText(paciente.getEmail());
            mNacimiento.setText(paciente.getFechaNacimiento());
            mDireccion.setText(paciente.getDireccion());
        }
    }

}
