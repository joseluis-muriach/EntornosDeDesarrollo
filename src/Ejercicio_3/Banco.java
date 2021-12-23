package Ejercicio_3;

public class Banco {

    private String codigo;
    private String sucursal;
    private String numCuenta;
    private String clavePersonal;
    private String talonario;
    private String movimientos;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setClavePersonal(String clavePersonal) {
        this.clavePersonal = clavePersonal;
    }

    public String getClavePersonal() {
        return clavePersonal;
    }

    public void setTalonario(String talonario) {
        this.talonario = talonario;
    }

    public String getTalonario() {
        return talonario;
    }

    public void setMovimientos(String movimientos) {
        this.movimientos = movimientos;
    }

    public String getMovimientos() {
        return movimientos;
    }
}
