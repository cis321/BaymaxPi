package co.edu.uniandes.baymaxpi.baymaxpi.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ASUS on 18/09/2016.
 */
public class Paciente implements Parcelable{

    private String mId;

    private String mCedula;

    private String mEmail;
    private String mName;
    private String mGenero;
    private String mDireccion;
    private String mEps;
    private String fechaNacimiento;
    private String[] mActividadFisica;
    private String[] mMedicamentos;
    private String[] mAlimentosYBebidas;
    public Paciente() {
    }

    public String getCedula() {
        return mCedula;
    }

    public void setCedula(String cedula) {
        mCedula = cedula;
    }

    public String getNombre() {
        return mName;
    }

    public void setNombre(String username) {
        mName = username;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getGenero() {
        return mGenero;
    }

    public void setGenero(String genero) {
        mGenero = genero;
    }

    public String getDireccion() {
        return mDireccion;
    }

    public void setDireccion(String direccion) {
        mDireccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String FN) {
        fechaNacimiento = FN;
    }

    public String getEps() {
        return mEps;
    }

    public void setEps(String eps) {
        mEps = eps;
    }

    public String[] getMedicamentos() {
        return mMedicamentos;
    }

    public void setMedicamentos(String[] medicamentos) {
        mMedicamentos = medicamentos;
    }

    public String[] getActividadFisica() {
        return mActividadFisica;
    }

    public void setActividadFisica(String[] actividadFisica) {
        mActividadFisica = actividadFisica;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String[] getAlimentosYBebidas() {
        return mAlimentosYBebidas;
    }

    public void setAlimentosYBebidas(String[] alimentosYBebidas) {
        mAlimentosYBebidas = alimentosYBebidas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(mId);
        dest.writeString(mName);
        dest.writeString(mCedula);
        dest.writeString(mEmail);
        dest.writeString(mEps);
        dest.writeString(mDireccion);
        dest.writeString(fechaNacimiento);
        dest.writeStringArray(mActividadFisica);
        dest.writeStringArray(mAlimentosYBebidas);
        dest.writeStringArray(mMedicamentos);
        dest.writeString(mGenero);
    }

    public Paciente(String mCedula, String mEmail, String mName, String mGenero, String mDireccion, String mEps, String fechaNacimiento, String[] mActividadFisica, String[] mMedicamentos, String[] mAlimentosYBebidas) {
        this.mCedula = mCedula;
        this.mEmail = mEmail;
        this.mName = mName;
        this.mGenero = mGenero;
        this.mDireccion = mDireccion;
        this.mEps = mEps;
        this.fechaNacimiento = fechaNacimiento;
        this.mActividadFisica = mActividadFisica;
        this.mMedicamentos = mMedicamentos;
        this.mAlimentosYBebidas = mAlimentosYBebidas;
    }

    private Paciente(Parcel in){
        mId = in.readString();
        mName = in.readString();
        mCedula = in.readString();
        mEmail = in.readString();
        mEps = in.readString();
        mDireccion = in.readString();
        fechaNacimiento = in.readString();
        mActividadFisica = in.createStringArray();
        mAlimentosYBebidas = in.createStringArray();
        mMedicamentos = in.createStringArray();
        mGenero = in.readString();
    }

    public static final Creator<Paciente> CREATOR = new Creator<Paciente>() {
        @Override
        public Paciente createFromParcel(Parcel source) {
            return new Paciente(source);
        }

        @Override
        public Paciente[] newArray(int size) {
            return new Paciente[0];
        }
    };

}
