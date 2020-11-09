package dto;

public class Respuesta {

    private String uid;
    private double respuesta;

    public Respuesta(String uid, double respuesta) {
        this.uid = uid;
        this.respuesta = respuesta;
    }

    public Respuesta() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public double getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(double respuesta) {
        this.respuesta = respuesta;
    }
}
