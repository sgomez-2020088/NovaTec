
package modelo;

public class DetalleCarrito {
  private int codigoDetalleCarrito;
  private int codigoCarrito;
  private String codigoProducto;
  private int cantidad;
  private double Total;

    public DetalleCarrito() {
    }

    public DetalleCarrito(int codigoDetalleCarrito, int codigoCarrito, String codigoProducto, int cantidad, double Total) {
        this.codigoDetalleCarrito = codigoDetalleCarrito;
        this.codigoCarrito = codigoCarrito;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.Total = Total;
    }

    public int getCodigoDetalleCarrito() {
        return codigoDetalleCarrito;
    }

    public void setCodigoDetalleCarrito(int codigoDetalleCarrito) {
        this.codigoDetalleCarrito = codigoDetalleCarrito;
    }

    public int getCodigoCarrito() {
        return codigoCarrito;
    }

    public void setCodigoCarrito(int codigoCarrito) {
        this.codigoCarrito = codigoCarrito;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
  
    
}
