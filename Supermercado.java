import java.util.Scanner;

public class Supermercado {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        registroCompra();
    }
    public static void registroCompra() {
        int cantidad, opcion, c1 = 0, c2 = 0, c3 = 0,registros;
        double totalPago = 0;
        Producto refrescoC = new Producto(8, 235, "Mi refresco", "Cocacola");
        Producto refrescoB = new Producto(12, 500, "Mi refresco", "Big cola");
        Producto refrescoP = new Producto(13, 600, "Mi refresco", "Pepsi");
        Producto catalogo[] = new Producto[6];
        catalogo[0] = refrescoC;
        catalogo[1] = refrescoB;
        catalogo[2] = refrescoP;
        System.out.println("Bienvenido al supermercado el vigor");
        System.out.println("Caja Registradora");
        System.out.println("Cuantos productos va registrar.");
        do{
        registros = entrada.nextInt();
         if(registros>=1 || registros<6){
            System.out.println("cantidad de registros valida.");
         }
         else{
            System.out.println("Se exede la cantidad de productos vuelva ingresar la cantidad.");
         }
        }while(registros<=0 || registros>5);
         for (int i = 1; i <= registros; i++) {
            System.out.println("Registro del" + " " + "producto no."+ " "+ i);
        System.out.println("¿Cuales fueron los productos que se adquirieron?");
        System.out.println("1. Cocacola de 235ml.......................$8.00\n2. Big cola de 500ml(c/u)................$12.00\n3. Pepsi de 600ml(c/u)....$13.00");
        do {
            opcion = entrada.nextInt();
            if(opcion>=1 && opcion<4){
                System.out.println("Opcion valida");
            }
            else{
                System.out.println("Opcion no valida vuelva a ingresar la opcion");
            }
        } while(opcion>3 || opcion<=0);
        System.out.println("Ingrese la cantidad que adquirio:");
        do {
            cantidad = entrada.nextInt();
            if(cantidad>=1){
                System.out.println("Cantidad valida");
            }
            else{
                System.out.println("Cantidad maxima superada o ingresoun numero negativo vuelva ingresar la cantidad");
            }
        } while (cantidad<=0);
        switch (opcion){
            case 1:
                System.out.println("Adquirio producto con descuento");
                System.out.println("Sele aplicara un des cuento del 15%:");
                catalogo[0].setPrecio(6.8);
                totalPago = totalPago + cantidad * catalogo[0].getPrecio();
                c1 = c1 + cantidad;
                break;
            case 2:
                totalPago = totalPago + cantidad * catalogo[1].getPrecio();
                c2 = c2 + cantidad;
                System.out.println("El producto que adquirio no tiene descuento:");
                if (cantidad == 2 || cantidad == 4 || cantidad == 6 || cantidad == 8 || cantidad == 10) {
                    System.out.println("Adquirio producto con oferta");
                    System.out.println("se le regala un refresco de 235ML");
                    c1 = c1 + 1;
                }
                break;
            case 3:
                System.out.println("Adquirio producto con descuento");
                System.out.println("Sele aplicara un des cuento del 15%:");
                catalogo[2].setPrecio(11.05);
                totalPago = totalPago + cantidad * catalogo[2].getPrecio();
                c3 = c3 + cantidad;
                break;
        }
         }
        Pago pago = new Pago(totalPago);
        System.out.println("Pago total de la venta es:" + " " + pago.getTotalPago());
        pagoCompra(pago,catalogo,c1,c2,c3);
    }

    public static void pagoCompra(Pago pago,Producto catalogo[],int c1,int c2, int c3) {
        int tipo_Pago;
        System.out.println("Como se realizara el pago? 1-Efectivo  2- Tarjeta  ");
        do {
            tipo_Pago = entrada.nextInt();
            if (tipo_Pago == 1 || tipo_Pago == 2) {
                System.out.println("Decision valida.");
            } else {
                System.out.println("Numero no valido vuelva ingresar el numero.");
            }
        } while (tipo_Pago>3 || tipo_Pago<=0);
        if (tipo_Pago== 1) {
            System.out.println("El cobro se realizara en efectivo:" + " " + "Se le cobrara" + " " + "$" + pago.getTotalPago()+" "+ "Pesos");
            System.out.println("El cobro se a realizado con exito.");
        } else {
            Pago tarjeta = new Pago(tipo_Pago);
            tarjeta.pagoTarjeta();
            System.out.println("El cobro se a realizado con exito.");
        }
        menuCajero(pago,catalogo,c1,c2,c3);
    }
        public static void menuCajero(Pago pago,Producto catalogo[],int c1,int c2,int c3){
            int opcion;
        System.out.println("------------------------");
        System.out.println("Bienvenido al menu del cajero que desea hacer");
        System.out.println("1. Mostrar venta\n2. Realizar otra venta\n3. Salir");
        do {
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    mostrarVenta(pago,catalogo,c1,c2,c3);
                    break;
                case 2:
                    volverRegistro();
                    break;
                case 3:
                    break;
                    default:
                    System.out.println("Opcion no valida vuelva a ingresar la opcion.");
            }
        } while (opcion>3 || opcion <= 0);
    }
    public static void mostrarVenta(Pago pago,Producto catalogo[],int c1,int c2,int c3) {
        int opcion;
        System.out.println("Mostrando Productos registrados\n------------------------");
         System.out.println("------------------------");
         System.out.println("Productos:" + " "+catalogo[0].getNombre()+ " "+"De la marca"+" "+catalogo[0].getMarca()+ " "+ "Con la cantidad de"+ " "+c1);
         System.out.println("Productos:" + " "+catalogo[1].getNombre()+ " "+"De la marca"+" "+catalogo[1].getMarca()+" "+ "Con la cantidad de"+ " "+c2);
         System.out.println("Productos:" + " "+catalogo[2].getNombre()+ " "+"De lamarca"+" "+catalogo[2].getMarca()+" "+ "Con la cantidad de"+ " "+c3 );
         System.out.println("Pago total de la venta es:" + " " + pago.getTotalPago());
         System.out.println("------------------------");
         System.out.println("Volver al menu 1-Si 2-No");
         do{
         opcion=entrada.nextInt();
         switch(opcion){
         case 1:
         menuCajero(pago, catalogo, c1, c2, c3);
         break;
         case 2:
         break;
         default:
         System.out.println("Opcion no valida vuelve a ingresar la opcion.");
         }
        }while(opcion>2 || opcion<=0);
    }
    public static void volverRegistro() {
        registroCompra();
        System.out.println("Nueva compra:");
    }
}
