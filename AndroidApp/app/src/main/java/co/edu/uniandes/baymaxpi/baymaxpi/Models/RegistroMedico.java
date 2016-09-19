package co.edu.uniandes.baymaxpi.baymaxpi.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ASUS on 18/09/2016.
 */
public class RegistroMedico implements Parcelable
{
    private String fechaMedicion;
    private String pulso;
    private String saturacion;
    private String temperatura;
    private String piel;
    private String presionSistolica;
    private String presionDiastolica;

    public String getPresionSistolica() {
        return presionSistolica;
    }

    public void setPresionSistolica(String presionSistolica) {
        this.presionSistolica = presionSistolica;
    }

    public String getPresionDiastolica() {
        return presionDiastolica;
    }

    public void setPresionDiastolica(String presionDiastolica) {
        this.presionDiastolica = presionDiastolica;
    }

    private boolean alerta = false;

    public String getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(String fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getSaturacion() {
        return saturacion;
    }

    public void setSaturacion(String saturacion) {
        this.saturacion = saturacion;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPiel() {
        return piel;
    }

    public void setPiel(String piel) {
        this.piel = piel;
    }

    public boolean verificarAlerta()
    {
        Double temp = Double.parseDouble(temperatura);
        Double pulse = Double.parseDouble(pulso);
        Double sat = Double.parseDouble(saturacion);
        Double skin = Double.parseDouble(piel);
        Double presSis = Double.parseDouble(presionSistolica);
        Double presDias = Double.parseDouble(presionDiastolica);

        if(temp < 36.2 || temp > 37.4)
        {
            alerta = true;
        }
        else if(sat < 94.9)
        {
            alerta = true;
        }
        else if(pulse < 60 || pulse > 82)
        {
            alerta = true;
        }
        else if(skin < 2 || pulse > 15)
        {
            alerta = true;
        }
        else if(presSis < 120 && presDias < 80)
        {
            alerta = true;
        }
        else if(presSis > 140 && presDias > 90)
        {
            alerta = true;
        }


        return alerta;
    }

    protected RegistroMedico(Parcel in)
    {

    }

    public static final Creator<RegistroMedico> CREATOR = new Creator<RegistroMedico>() {
        @Override
        public RegistroMedico createFromParcel(Parcel in) {
            return new RegistroMedico(in);
        }

        @Override
        public RegistroMedico[] newArray(int size) {
            return new RegistroMedico[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fechaMedicion);
        dest.writeString(pulso);
        dest.writeString(saturacion);
        dest.writeString(presionDiastolica);
        dest.writeString(presionSistolica);
        dest.writeString(temperatura);
        dest.writeString(piel);
        dest.writeString(alerta+"");
    }
}
