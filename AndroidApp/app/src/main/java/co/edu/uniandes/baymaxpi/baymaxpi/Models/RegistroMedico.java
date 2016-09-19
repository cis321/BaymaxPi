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
    private String presion;


    protected RegistroMedico(Parcel in) {
    }

    public static final Creator<RegistroMedico> CREATOR = new Creator<RegistroMedico>() {
        @Override
        public RegistroMedico createFromParcel(Parcel in) {
            return new RegistroMedico(in);
        }

        @Override
        public RegistroMedico[] newArray(int size) {
            return new RegistroMedico[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
