public class Usuario {

    private String Nombre;
    private String TipoCred;
    private Double MontoCred;

    /*Consumo, comercial, hipotecario */

    public Usuario() {

    }

    public Usuario(String nombre, String tipoCred, Double montoCred) {

        Nombre = nombre;
        TipoCred = tipoCred;
        MontoCred = montoCred;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipoCred() {
        return TipoCred;
    }

    public void setTipoCred(String tipoCred) {
        TipoCred = tipoCred;
    }

    public Double getMontoCred() {
        return MontoCred;
    }

    public void setMontoCred(Double montoCred) {
        MontoCred = montoCred;
    }

}