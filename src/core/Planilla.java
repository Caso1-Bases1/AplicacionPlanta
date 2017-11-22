package core;

public class Planilla {
    private int idContenido;
    private int codigoEmpleado;
    private int periodoPago;
    private float salarioBruto;
    private float salarioNeto;
    private int idPlanilla;
    private int idPlanta;

    public Planilla(int idContenido, int codigoEmpleado, int periodoPago, float salarioBruto, float salarioNeto, int idPlanilla, int idPlanta) {
        this.idContenido = idContenido;
        this.codigoEmpleado = codigoEmpleado;
        this.periodoPago = periodoPago;
        this.salarioBruto = salarioBruto;
        this.salarioNeto = salarioNeto;
        this.idPlanilla = idPlanilla;
        this.idPlanta = idPlanta;
    }

    public Planilla() {
        
    }

    public int getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(int idContenido) {
        this.idContenido = idContenido;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public int getPeriodoPago() {
        return periodoPago;
    }

    public void setPeriodoPago(int periodoPago) {
        this.periodoPago = periodoPago;
    }

    public float getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public float getSalarioNeto() {
        return salarioNeto;
    }

    public void setSalarioNeto(float salarioNeto) {
        this.salarioNeto = salarioNeto;
    }

    public int getIdPlanilla() {
        return idPlanilla;
    }

    public void setIdPlanilla(int idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    public int getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(int idPlanta) {
        this.idPlanta = idPlanta;
    }        
}
