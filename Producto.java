public class Producto {
    private double precio;
    private int presentacion;
    private String marca;
    private String nombre;
    public Producto(){ 
    }
    public Producto(double precio,int presentacion,String marca,String nombre){
      this.precio=precio;
      this.presentacion=presentacion;
      this.marca=marca;
      this.nombre=nombre;
     
    }
    public double getPrecio() {
        return precio;
    }
    public int getPresentacion() {
        return presentacion;
    }
    public String getMarca() {
        return marca;
    }
    public String getNombre() {
        return nombre;
    }
    public void setPrecio(double precio) {
        this.precio=precio;
    }
}
