
package Modelo;

public class citamedica {
    private int id;
    private String nombre;
    String fecha;
    String hora;
    private String servicio;
    private String consultorio;
    private String doctor;
    private String Analisis;


    public citamedica() {
}

    public citamedica(int id,String nombre, String fecha, String hora, String servicio, String consultorio, String doctor, String Analisis) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
        this.consultorio = consultorio;
        this.doctor = doctor;
        this.Analisis = Analisis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void setAnalisis(String Analisis) {
        this.Analisis = Analisis;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getServicio() {
        return servicio;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getAnalisis() {
        return Analisis;
    }
    
}