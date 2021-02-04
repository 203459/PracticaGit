public class Dados {
	private String nombre;
    private String color;
    private int puntos=0;
public Dados(String nombre, String color,int puntos){
    this.color=color;
    this.nombre=nombre;
    this.puntos=puntos;
}
public String getNombre(){
    return nombre;
}
public String getColor(){
    return color;
}
public int getPuntos(){
    return puntos;
}
}
