package bms.projectcrud.com.dto;

public class Mensaje {
    private String Mensaje;

    public Mensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }
}
