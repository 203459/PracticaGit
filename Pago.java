import java.util.Scanner;
public class Pago {
    private int tipo_Pago;
    private double totalPago;
    static Scanner entrada=new Scanner(System.in);
    public Pago(double totalPago){
       this.totalPago=totalPago;
    }
    public Pago(int tipo_Pago){
        this.tipo_Pago=tipo_Pago;
     }
    public void pagoTarjeta(){
        long tarjeta;
        int clvt,veces=0;
        do{
        System.out.println("Proporcione su numero de tarjeta (16 Digitos).");
         tarjeta=entrada.nextLong();
         System.out.println("Ingrese su nip para autorizar su compra:(4 Digitos).");
         clvt=entrada.nextInt();
         if(tarjeta>999999999999999L && tarjeta<10000000000000000L && clvt>999 && clvt<10000){
            System.out.println("Compra autorizada");
            veces=3;
         }
         else{
            System.out.println("El numero de tarjeta o la clave son incorrectos");
           veces=veces+1;
           if(veces==2){
            System.out.println("Numero de intentos superado");
            pagoEfectivo();
           }
         }
        }while(veces<2);
    }
    public void pagoEfectivo() {
        int decision;
        System.out.println("Desea realizar el pago en 1-efectivo 2-Cancelar compra");
        decision = entrada.nextInt();
        switch (decision) {
            case 1:
                System.out.println("Pago en efectivo:");
                System.out.println("El cobro se realizara en efectivo:" + " "+ "Se le cobrara"+" " +"$"+totalPago);
                break;
            case 2:
                System.out.println("Compra cancelada");
                Supermercado volverR=new Supermercado();
                volverR.volverRegistro();
                break;
        }
    }
    public int getTipo_Pago(){
        return tipo_Pago;
    }
    public double getTotalPago(){
        return totalPago;
    }
}
