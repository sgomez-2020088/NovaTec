
package modelo;


public class Carrito {
    
    private int codigoCarrtio;
    private int codigoCliente;

    public Carrito() {
    }

    public Carrito(int codigoCarrtio, int codigoCliente) {
        this.codigoCarrtio = codigoCarrtio;
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoCarrtio() {
        return codigoCarrtio;
    }

    public void setCodigoCarrtio(int codigoCarrtio) {
        this.codigoCarrtio = codigoCarrtio;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    
    
    
}
