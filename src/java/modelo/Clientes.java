package modelo;

public class Clientes {
    private int codigoClientes;
    private String NITCliente; 
    private String nombresCliente;
    private String apellidosCliente;
    private String direccionCliente; 
    private String telefonoCliente; 
    private String emailCliente;
    private String username; 
    private String contrasena; 

    public Clientes() {
    }

    public Clientes(int codigoClientes, String NITCliente, String nombresCliente, String apellidosCliente, String direccionCliente, String telefonoCliente, String emailCliente, String username, String contrasena) {
        this.codigoClientes = codigoClientes;
        this.NITCliente = NITCliente;
        this.nombresCliente = nombresCliente;
        this.apellidosCliente = apellidosCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.username = username;
        this.contrasena = contrasena;
    }

    public int getCodigoClientes() {
        return codigoClientes;
    }

    public void setCodigoClientes(int codigoClientes) {
        this.codigoClientes = codigoClientes;
    }

    public String getNITCliente() {
        return NITCliente;
    }

    public void setNITCliente(String NITCliente) {
        this.NITCliente = NITCliente;
    }

    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
