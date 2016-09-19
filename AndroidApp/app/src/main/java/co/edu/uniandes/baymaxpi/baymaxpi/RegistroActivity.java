package co.edu.uniandes.baymaxpi.baymaxpi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ProgressCallback;
import com.parse.SaveCallback;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.edu.uniandes.baymaxpi.baymaxpi.Models.Paciente;

/**
 * Created by ASUS on 18/09/2016.
 */
public class RegistroActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener
{

    @InjectView(R.id.nombreText) MaterialEditText mNombreText;
    @InjectView(R.id.cedulaText) MaterialEditText mCedulaText;
    @InjectView(R.id.epsText) MaterialEditText mEpsText;
    @InjectView(R.id.direccionText) MaterialEditText mDireccionText;
    @InjectView(R.id.generoLabel)TextView mGeneroText;
    @InjectView(R.id.correoText) MaterialEditText mCorreoText;
    @InjectView(R.id.generoSpinner)Spinner mGeneroSpinner;
    @InjectView(R.id.fechaButton)Button mFechaButton;
    @InjectView(R.id.fechaLabel)TextView mFechaText;
    @InjectView(R.id.medicamentosText) MaterialEditText mMedicamentosText;
    @InjectView(R.id.actFisicaText) MaterialEditText mActFisicaText;
    @InjectView(R.id.alimentosYBebidasText) MaterialEditText mAlimentosYBebidasText;
    @InjectView(R.id.registrarButton)Button mRegistrarButton;
    @InjectView(R.id.saveProgressBar)ProgressBar mSaveProgressBar;
    @InjectView(R.id.uploadProgressBar)ProgressBar mUploadProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ButterKnife.inject(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.generoSpinnerOptions, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGeneroSpinner.setAdapter(adapter);

        mFechaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        RegistroActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );

                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });


        Locale spanish = new Locale("es", "ES");
        Calendar cal = Calendar.getInstance();
        String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, spanish);
        monthName = monthName.substring(0,1).toUpperCase() + monthName.substring(1);

        mFechaText.setText(cal.get(Calendar.MONTH) + " " + cal.get(Calendar.DAY_OF_MONTH) + ", " + cal.get(Calendar.YEAR));

        mRegistrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarPaciente();
            }
        });

    }

    private void registrarPaciente()
    {
        mSaveProgressBar.setVisibility(View.VISIBLE);

        final File file = new File(Environment.getExternalStorageDirectory().
                getAbsolutePath() + "/" + "Registros");

        if(!file.exists())
        {
            file.mkdirs();
        }

        String nombre = mNombreText.getText().toString();
        String cedula = mCedulaText.getText().toString();
        String eps = mEpsText.getText().toString();
        String correo = mCorreoText.getText().toString();
        String direccion = mDireccionText.getText().toString();
        String genero = mGeneroSpinner.getSelectedItem().toString();
        final String fecha = mFechaText.getText().toString();

        boolean dataCompleteFlag = true;

        if (nombre.isEmpty() ) {
            mNombreText.setError(getString(R.string.cannot_be_empty));
            mNombreText.setErrorColor(getResources().getColor(R.color.input_error_solid));
            dataCompleteFlag = false;
        }

        if (cedula.isEmpty()) {
            mCedulaText.setError(getString(R.string.cannot_be_empty));
            mCedulaText.setErrorColor(getResources().getColor(R.color.input_error_solid));
            dataCompleteFlag = false;
        }
        if (direccion.isEmpty() ) {
            mDireccionText.setError(getString(R.string.cannot_be_empty));
            mDireccionText.setErrorColor(getResources().getColor(R.color.input_error_solid));
            dataCompleteFlag = false;
        }

        if (correo.isEmpty()) {
            mCorreoText.setError(getString(R.string.cannot_be_empty));
            mCorreoText.setErrorColor(getResources().getColor(R.color.input_error_solid));
            dataCompleteFlag = false;
        }
        if (eps.isEmpty() ) {
            mEpsText.setError(getString(R.string.cannot_be_empty));
            mEpsText.setErrorColor(getResources().getColor(R.color.input_error_solid));
            dataCompleteFlag = false;
        }

        String[] medicamentos = mMedicamentosText.getText().toString().trim().split(",");
        String[] actividadFisica = mActFisicaText.getText().toString().trim().split(",");
        String[] alimentosYBebidas = mAlimentosYBebidasText.getText().toString().split(",");

        final String fNombre = nombre;
        final String fCorreo = correo;
        final String fEps = eps;
        final String fDireccion = direccion;
        final String fCedula = cedula;
        final String fFecha = fecha;
        final String fGenero = genero;
        final String[] fMedicamentos = medicamentos;
        final String[] fAlimentos = alimentosYBebidas;
        final String[] fActividades = actividadFisica;

        if (dataCompleteFlag) {

            final ParseObject paciente = new ParseObject("Paciente");

            paciente.add("actividadFisica", Arrays.asList(actividadFisica));
            paciente.put("nombre", nombre);
            paciente.put("fecha", fecha);
            paciente.put("direccion", direccion);
            paciente.add("medicamentos", Arrays.asList(medicamentos));
            paciente.put("correo", correo);
            paciente.put("genero", genero);
            paciente.put("cedula", cedula);
            paciente.put("eps", eps);
            paciente.add("alimentos", Arrays.asList(alimentosYBebidas));

            paciente.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                    ParseFile parseFile = null;

                    if (file.exists()){

                        String path = Environment.getExternalStorageDirectory().
                                getAbsolutePath() + "/registro.txt";
                        Log.d("RegistroPaciente", path);
                        File newFile = new File(path);
                        file.renameTo(newFile);

                        try {

                            FileWriter writer = new FileWriter(file);

                            writer.append(fNombre + "," + fEps + "," + fCedula + "," + fCorreo + "," + fFecha + "," + fDireccion);
                            writer.flush();
                            writer.close();

                        } catch (Exception e1) {
                            Log.d("RegistroPaciente", e1.getMessage());
                        }
                    }
                    mSaveProgressBar.setVisibility(View.INVISIBLE);
                    navigateToProfile();
                }
            });
        }

    }

    private void navigateToProfile()
    {
        Intent intent = new Intent(RegistroActivity.this, ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    private void navigateToMain() {
        Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Locale spanish = new Locale("es", "ES");
        Calendar cal = Calendar.getInstance();
        String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, spanish);
        monthName = monthName.substring(0,1).toUpperCase() + monthName.substring(1);

        String date = monthName + " " + dayOfMonth + ", " + year;
        mFechaText.setText(date);

    }
}
