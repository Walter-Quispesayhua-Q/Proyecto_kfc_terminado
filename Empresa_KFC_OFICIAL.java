import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Empresa_KFC_OFICIAL {
    public static List<Double> precios_complementos_seleccionados = new ArrayList<>();
    public static List<Double> precios_menu_selecionados = new ArrayList<>();
    public static List<String> menu_seleccionados = new ArrayList<>();
    public static List<String> complementos_seleccionados = new ArrayList<>();
    public static List<Integer> cantidades_menu_seleccionados = new ArrayList<>();
    public static List<String> promociones_selecionadas =new ArrayList<>();
    public static List<Double> precios_promociones_selecionadas = new ArrayList<>();
    public static List<Integer> cantidades_promociones_seleccionados = new ArrayList<>();
    public static List<String> registro_de_usuarios = new ArrayList<>();
    public static List<String> registro_de_contraseñas = new ArrayList<>();
    public static String direccion_selecioanda="";
    public static String[] menuprincipal = {"1.- MEGA REGULARES", "2.- PARA 2", "3.- BIG BOX", "4.- COMBOS", "5.- SANDWICHES & TOSTADOS","6.- VER CARRITO", "7.- VOLVER A LA PAGINA PRINCIPAL"};
    public static String[] dirreciones_de_entrega = {"1.- Salida a Lampa", "2.- Salida a Cusco", "3.- Salida a Puno", "4.- Salida a Tacna", "5.- Salida a Arequipa", "6.- Salida al Aeropuerto de Juliaca"
    };
    public static double igv = 0.18;
    public static String direccion_de_kfc= "Jr. San Martin, Juliaca 21103";
    public static boolean registrarse = false;
    public static  boolean inicio_sesion = false;
    public static boolean metodo_entrega;
    public static String metodo_de_pago_seleccioando = "";

    public static void menu_principal() {
        Scanner wali = new Scanner(System.in);
        for (String MENU : menuprincipal) {
            System.out.println(MENU);
        }
        System.out.println("Ingrese la opción deseada");
        String opcion = wali.nextLine();
        switch (opcion) {
            case "1":
                menu_mega_regulares(wali);
                break;
            case "2":
                menu_para_2(wali);
                break;
            case "3":
                menu_big_box(wali);
                break;
            case "4":
                menu_combos(wali);
                break;
            case "5":
                menu_sandwiches_tostados(wali);
                break;
            case "6":
                carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,
                        menu_seleccionados, complementos_seleccionados, promociones_selecionadas,
                        precios_promociones_selecionadas, cantidades_promociones_seleccionados);
                break;
            case "7":
                pagina_principal();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    static String[][] menu_sandwich = {
            {"1 .COMBO TWISTER TRADICIONAL (S/ 24.90)", "2 .COMBO TWISTER AMERICANO (S/ 25.90)"},
            {"3 .TOASTED TWISTER TRADICIONAL (S/ 18.90)", "4 .TOASTED TWISTER AMERICANO (S/ 19.90)"},
            {"5 .COMBO KENTUCKY CHICKEN SANDWICH (S/ 25.90)", "6 .KENTUCKY CHICKEN SANDWICH (S/ 19.90)"}
    };
    static double[] precio_sandwich = {24.90, 25.90, 18.90, 19.90, 25.90, 19.90};

    static String[][] menu_complementos = {
            {"1 .PAQUETE 6 NUGGETS (S/ 15.90)", "2 .POPCORN CHICKEN (S/ 15.90)", "3 .PAQUETE 6 HOT WINGS (S/ 16.90)"},
            {"4 .PAPA PERSONAL (S/ 5.90)", "5 .PAPA FAMILIAR (S/ 11.90)", "6 .PURÉ REGULAR (S/ 5.90)"},
            {"7 .PURÉ FAMILIAR (S/ 11.00)", "8 .ENSALADA REGULAR (S/ 5.90)", "9 .ENSALADA FAMILIAR (S/ 11.00)"},
            {"10 .OCOPA FAMILIAR (S/ 4.90)", "11 .AJÍ CRIOLLO FAMILIAR (S/ 4.90)", "12 .INCA KOLA SIN AZÚCAR 500 ML (S/ 4.90)"},
            {"13 .COCA-COLA SIN AZÚCAR 500 ML (S/ 4.90)", "14 .FANTA 500 ML (S/ 4.90)", "15 .INCA KOLA SIN AZÚCAR 1.5L (S/ 10.00)"},
            {"16 .COCA-COLA SIN AZÚCAR 1.5L (S/ 10.00)", "17 .FANTA 2.25L (S/ 13.00)", "18 .ROCOTO FAMILIAR (S/ 4.90)"}
    };
    static double[] precios_complementos = {
            15.90, 15.90, 16.90,
            5.90, 11.90, 5.90,
            11.00, 5.90, 11.00,
            4.90, 4.90, 4.90,
            4.90, 4.90, 10.00,
            10.00, 13.00, 4.90
    };

    static String[][] menu_mregalares = {
            {"1 .MEGA MIX - 8 PIEZAS (S/ 69.90)", "2 .SUPER MEGA - 10 PIEZAS (S/ 79.90)"},
            {"3 .MEGA FULL - 12 PIEZAS (S/ 89.90)", "4 .MEGA GIGANTE - 14 PIEZAS (S/ 99.90)"},
    };
    static double[] precio_de_regulares = {69.90, 79.90, 89.90, 99.90};

    static String[][] menu_para_dos = {
            {"1 .COMBO CHICKN SHARE CLÁSICO (S/ 40.90)", "2 .CHICKN SHARE 18 NUGGETS + 2 PAPAS (S/ 38.00)"},
            {"3 .CHICK'N SHARE MIX 3 PIEZAS (S/ 38.00)", "4 .CHICK'N SHARE NUGGETS Y HOT WINGS (S/ 42.90)"}
    };
    static double[] precio_para_dos = {40.90, 38.00, 38.00, 42.90};

    static String[][] menu_big_box = {
            {"1 .BIG BOX KRUNCHY (S/ 26.90)", "2 .BIG BOX KENTUCKY CHICKEN SANDWICH DELUXE (S/ 32.90)"},
            {"3 .BIG BOX POPCORN (S/ 33.90)", "4 .BIG BOX WOW (S/ 28.90)"},
            {"5 .BIG BOX CLASSIC (S/ 27.90)", "6 .BIG BOX FULL (S/ 34.90)"}
    };
    static double[] precio_big_box = {26.90, 32.90, 33.90, 28.90, 27.90, 34.90};

    static String[][] menu_combos = {
            {"1 .COMBO CLÁSICO (S/ 20.90)", "2 .COMBO SNACKS (S/ 24.90)"},
            {"3 .COMBO 8 HOT WINGS (S/ 24.90)", "4 .COMBO 8 NUGGETS (S/ 24.90)"}
    };
    static double[] precio_combos = {20.90, 24.90, 24.90, 24.90};
    static String[][] menu_promociones = {
            {"1.- KFC Mega Delivery - 6 Piezas (S/ 39)","2.- KFC Mega Promo - 8 Piezas (S/ 49)"},
            {"3.- KFC Mega Promo - 10 Piezas (S/ 59)","4.- KFC PopCorn Chicken Para 4 (S/ 29)"},
            {"5.- KFC Krunchy Box (S/ 34)","6.- KFC Krunchy Combo (S/ 40)"},
            {"7.- KFC Krunchy Para 2 (S/ 18)","8.-KFC Krunchy Para 4 (S/ 55)"},
            {"9.-KFC Big Box Bucketeo (S/ 72)","10.- KFC Big Box Full Salsa (S/ 79)"}
    };
    static double[] precios_promociones = {39.99, 49.99, 59.99, 29.99, 34.99, 40.99, 18.99, 55.99, 72.99, 79.99};

    static void menu_mega_regulares(Scanner wali) {
        System.out.println("Menú MEGA REGULARES seleccionado");
        seleccionacion_mega_regulares(wali);
    }

    public static void menu_para_2(Scanner wali) {
        System.out.println("Menú PARA 2 seleccionado");
        seleccionacion_menu_para_2(wali);
    }

    public static void menu_big_box(Scanner wali) {
        System.out.println("Menú BIG BOX seleccionado");
        seleccionacion_menu_big_box(wali);
    }

    public static void menu_combos(Scanner wali) {
        System.out.println("Menú COMBOS seleccionado");
        seleccionacion_menu_combos(wali);
    }

    public static void menu_sandwiches_tostados(Scanner wali) {
        System.out.println("Menú SANDWICHES & TOSTADAS seleccionado");
        seleccionacion_menu_sandwiches_tostados(wali);
    }

    public static void seleccionacion_mega_regulares(Scanner wali) {
        List<Double> precios_complementos_seleccionados_temp = new ArrayList<>();
        List<Double> precios_menu_selecionados_temp = new ArrayList<>();
        List<String> menu_seleccionados_temp = new ArrayList<>();
        List<String> complementos_seleccionados_temp = new ArrayList<>();
        List<Integer> cantidades_menu_seleccionados_temp = new ArrayList<>();
        double precio_seleccionado = 0.0;
        int cantidad_producto = 0;

        for (String[] fila : menu_mregalares) {
            System.out.printf("%-50s%-50s%n", fila[0], fila[1]);
        }
        System.out.println("Seleccione una opción");
        String opcion = wali.nextLine();
        int opcion_entero = Integer.parseInt(opcion);
        if (opcion_entero >= 1 && opcion_entero <= precio_de_regulares.length) {
            System.out.println("Seleccionó " + menu_mregalares[(opcion_entero - 1) / 2][(opcion_entero - 1) % 2]);
            precio_seleccionado = precio_de_regulares[opcion_entero - 1];
            menu_seleccionados_temp.add(menu_mregalares[(opcion_entero - 1) / 2][(opcion_entero - 1) % 2]);
            precios_menu_selecionados_temp.add(precio_seleccionado);
            cantidades_menu_seleccionados_temp.add(cantidad_producto);
            menu_seleccionados.addAll(menu_seleccionados_temp);
            precios_menu_selecionados.addAll(precios_menu_selecionados_temp);

        } else {
            System.out.println("opción no válida.");
        }
        System.out.println("¿Cuántas unidades desea comprar?");
        cantidad_producto = wali.nextInt();
        cantidades_menu_seleccionados_temp.add(cantidad_producto);
        cantidades_menu_seleccionados.add(cantidad_producto);
        wali.nextLine();
        System.out.println("¿Desea añadir algún complemento?");
        for (int i = 0; i < menu_complementos.length; i++) {
            String[] fila = menu_complementos[i];
            System.out.printf("%-50s%-50s%-50s%n", fila[0], fila[1], fila[2]);
        }
        int opcion_complementos;
        while ((opcion_complementos = wali.nextInt()) != 0) {
            if (opcion_complementos > 0 && opcion_complementos <= precios_complementos.length) {
                complementos_seleccionados_temp.add(menu_complementos[(opcion_complementos - 1) / 3][(opcion_complementos - 1) % 3]);
                precios_complementos_seleccionados_temp.add(precios_complementos[opcion_complementos - 1]);
                complementos_seleccionados.addAll(complementos_seleccionados_temp);
                precios_complementos_seleccionados.addAll(precios_complementos_seleccionados_temp);
            } else {
                System.out.println("Opción no válida.");
            }
            System.out.println("Ingrese el número del complemento que desea agregar ( 0 para terminar):");
        }
        wali.nextLine();
        double totalPedido = pedido(cantidad_producto, precio_seleccionado, precios_complementos_seleccionados,precios_promociones_selecionadas);
        informacion_pedido(totalPedido, menu_seleccionados_temp, cantidad_producto, complementos_seleccionados_temp, precios_menu_selecionados_temp,precios_complementos_seleccionados_temp);
        System.out.println("desea añadirlo a su carrito? (SI/NO)");
        opcion = wali.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            System.out.println("desea:");
            System.out.println("1.- seguir comprando(volver al menu)");
            System.out.println("2.- ralizar el pago su pedido");
            System.out.println("3.- ver su carrito");
            System.out.println("4.- volver a la pagina principal");
            opcion = wali.nextLine();
            switch (opcion) {
                case "1":
                    menu_principal();
                    break;
                case "2":
                    System.out.println(" ");
                    carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
                    break;
                case "3":
                    carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);

                    break;
                case "4":
                    pagina_principal();
                    break;
            }

        }else {
            System.out.println("desea realizar el pago de su pedido? (SI/NO)");
            opcion= wali.nextLine();
            if (opcion.equalsIgnoreCase("si")){
                carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
            }else {
                System.out.println("su pedido se a cancelado");
                System.out.println("No, nos dejes, deseaa..");
                System.out.println("1.- volver al menu principal");
                System.out.println("2.- volver a la pagina principal");
                System.out.println("3.- salir");
                opcion= wali.nextLine();
                switch (opcion){
                    case "1":
                        menu_principal();
                        break;
                    case "3":
                        System.out.println("gracias por visitar la pagina de KFC");
                        System.out.println("esperamos, que vuelva pronto");
                        break;
                }
            }
        }
    }
    public static void seleccionacion_menu_para_2(Scanner wali) {
        List<Double> precios_complementos_seleccionados_temp = new ArrayList<>();
        List<Double> precios_menu_selecionados_temp = new ArrayList<>();
        List<String> menu_seleccionados_temp = new ArrayList<>();
        List<String> complementos_seleccionados_temp = new ArrayList<>();
        List<Integer> cantidades_menu_seleccionados_temp = new ArrayList<>();
        double precio_seleccionado = 0.0;
        int cantidad_producto = 0;

        for (String[] fila : menu_para_dos) {
            System.out.printf("%-50s%-50s%n", fila[0], fila[1]);
        }
        System.out.println("Seleccione una opción");
        String opcion = wali.nextLine();
        int opcion_entero = Integer.parseInt(opcion);
        if (opcion_entero >= 1 && opcion_entero <= precio_para_dos.length) {
            System.out.println("Seleccionó " + menu_para_dos[(opcion_entero - 1) / 2][(opcion_entero - 1) % 2]);
            precio_seleccionado = precio_para_dos[opcion_entero - 1];
            menu_seleccionados_temp.add(menu_para_dos[(opcion_entero - 1) / 2][(opcion_entero - 1) % 2]);
            precios_menu_selecionados_temp.add(precio_seleccionado);
            cantidades_menu_seleccionados_temp.add(cantidad_producto);
            menu_seleccionados.addAll(menu_seleccionados_temp);
            precios_menu_selecionados.addAll(precios_menu_selecionados_temp);

        } else {
            System.out.println("opción no válida.");
        }
        System.out.println("¿Cuántas unidades desea comprar?");
        cantidad_producto = wali.nextInt();
        cantidades_menu_seleccionados_temp.add(cantidad_producto);
        cantidades_menu_seleccionados.add(cantidad_producto);
        wali.nextLine();
        System.out.println("¿Desea añadir algún complemento?");
        for (int i = 0; i < menu_complementos.length; i++) {
            String[] fila = menu_complementos[i];
            System.out.printf("%-50s%-50s%-50s%n", fila[0], fila[1], fila[2]);
        }
        int opcion_complementos;
        while ((opcion_complementos = wali.nextInt()) != 0) {
            if (opcion_complementos > 0 && opcion_complementos <= precios_complementos.length) {
                complementos_seleccionados_temp.add(menu_complementos[(opcion_complementos - 1) / 3][(opcion_complementos - 1) % 3]);
                precios_complementos_seleccionados_temp.add(precios_complementos[opcion_complementos - 1]);
                complementos_seleccionados.addAll(complementos_seleccionados_temp);
                precios_complementos_seleccionados.addAll(precios_complementos_seleccionados_temp);
            } else {
                System.out.println("Opción no válida.");
            }
            System.out.println("Ingrese el número del complemento que desea agregar ( 0 para terminar):");
        }
        wali.nextLine();
        double totalPedido = pedido(cantidad_producto, precio_seleccionado, precios_complementos_seleccionados,precios_promociones_selecionadas);
        informacion_pedido(totalPedido, menu_seleccionados_temp, cantidad_producto, complementos_seleccionados_temp, precios_menu_selecionados_temp,precios_complementos_seleccionados_temp);
        System.out.println("desea añadirlo a su carrito? (SI/NO)");
        opcion = wali.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            System.out.println("desea:");
            System.out.println("1.- seguir comprando(volver al menu)");
            System.out.println("2.- realizar el pago su pedido");
            System.out.println("3.- ver su carrito");
            System.out.println("4.- volver a la pagina principal");
            opcion = wali.nextLine();
            switch (opcion) {
                case "1":
                    menu_principal();
                    break;
                case "2":
                    System.out.println(" ");
                    carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
                    break;
                case "3":
                    carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
                    break;
                case "4":
                    pagina_principal();
                    break;
            }

        }else {
            System.out.println("desea realizar el pago de su pedido? (SI/NO)");
            opcion= wali.nextLine();
            if (opcion.equalsIgnoreCase("si")){
                carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
            }else {
                System.out.println("su pedido se a cancelado");
                System.out.println("No, nos dejes, deseaa..");
                System.out.println("1.- volver al menu principal");
                System.out.println("2.- volver a la pagina principal");
                System.out.println("3.- salir");
                opcion= wali.nextLine();
                switch (opcion){
                    case "1":
                        menu_principal();
                        break;
                    case "3":
                        System.out.println("gracias por visitar la pagina de KFC");
                        System.out.println("esperamos, que vuelva pronto");
                        break;
                }
            }
        }
    }
    public static void seleccionacion_menu_big_box(Scanner wali) {
        List<Double> precios_complementos_seleccionados_temp = new ArrayList<>();
        List<Double> precios_menu_selecionados_temp = new ArrayList<>();
        List<String> menu_seleccionados_temp = new ArrayList<>();
        List<String> complementos_seleccionados_temp = new ArrayList<>();
        List<Integer> cantidades_menu_seleccionados_temp = new ArrayList<>();
        double precio_seleccionado = 0.0;
        int cantidad_producto = 0;

        for (String[] fila : menu_big_box) {
            System.out.printf("%-50s%-50s%n", fila[0], fila[1]);
        }
        System.out.println("Seleccione una opción");
        String opcion = wali.nextLine();
        int opcion_entero = Integer.parseInt(opcion);
        if (opcion_entero >= 1 && opcion_entero <= precio_big_box.length) {
            System.out.println("Seleccionó " + menu_big_box[(opcion_entero - 1) / 2][(opcion_entero - 1) % 2]);
            precio_seleccionado = precio_big_box[opcion_entero - 1];
            menu_seleccionados_temp.add(menu_big_box[(opcion_entero - 1) / 2][(opcion_entero - 1) % 2]);
            precios_menu_selecionados_temp.add(precio_seleccionado);
            cantidades_menu_seleccionados_temp.add(cantidad_producto);
            menu_seleccionados.addAll(menu_seleccionados_temp);
            precios_menu_selecionados.addAll(precios_menu_selecionados_temp);

        } else {
            System.out.println("opción no válida.");
        }
        System.out.println("¿Cuántas unidades desea comprar?");
        cantidad_producto = wali.nextInt();
        cantidades_menu_seleccionados_temp.add(cantidad_producto);
        cantidades_menu_seleccionados.add(cantidad_producto);
        wali.nextLine();
        System.out.println("¿Desea añadir algún complemento?");
        for (int i = 0; i < menu_complementos.length; i++) {
            String[] fila = menu_complementos[i];
            System.out.printf("%-50s%-50s%-50s%n", fila[0], fila[1], fila[2]);
        }
        int opcion_complementos;
        while ((opcion_complementos = wali.nextInt()) != 0) {
            if (opcion_complementos > 0 && opcion_complementos <= precios_complementos.length) {
                complementos_seleccionados_temp.add(menu_complementos[(opcion_complementos - 1) / 3][(opcion_complementos - 1) % 3]);
                precios_complementos_seleccionados_temp.add(precios_complementos[opcion_complementos - 1]);
                complementos_seleccionados.addAll(complementos_seleccionados_temp);
                precios_complementos_seleccionados.addAll(precios_complementos_seleccionados_temp);
            } else {
                System.out.println("Opción no válida.");
            }
            System.out.println("Ingrese el número del complemento que desea agregar ( 0 para terminar):");
        }
        wali.nextLine();
        double totalPedido = pedido(cantidad_producto, precio_seleccionado, precios_complementos_seleccionados,precios_promociones_selecionadas);
        informacion_pedido(totalPedido, menu_seleccionados_temp, cantidad_producto, complementos_seleccionados_temp, precios_menu_selecionados_temp,precios_complementos_seleccionados_temp);
        System.out.println("desea añadirlo a su carrito? (SI/NO)");
        opcion = wali.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            System.out.println("desea:");
            System.out.println("1.- seguir comprando(volver al menu)");
            System.out.println("2.- realizar el pago su pedido");
            System.out.println("3.- ver su carrito");
            System.out.println("4.- volver a la pagina principal");
            opcion = wali.nextLine();
            switch (opcion) {
                case "1":
                    menu_principal();
                    break;
                case "2":
                    System.out.println(" ");
                    carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
                    break;
                case "3":
                    carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
                    break;
                case "4":
                    pagina_principal();
                    break;
            }

        }else {
            System.out.println("desea realizar el pago de su pedido? (SI/NO)");
            opcion= wali.nextLine();
            if (opcion.equalsIgnoreCase("si")){
                carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
            }else {
                System.out.println("su pedido se a cancelado");
                System.out.println("No, nos dejes, deseaa..");
                System.out.println("1.- volver al menu principal");
                System.out.println("2.- volver a la pagina principal");
                System.out.println("3.- salir");
                opcion= wali.nextLine();
                switch (opcion){
                    case "1":
                        menu_principal();
                        break;
                    case "3":
                        System.out.println("gracias por visitar la pagina de KFC");
                        System.out.println("esperamos, que vuelva pronto");
                        break;
                }
            }
        }
    }

    public static void seleccionacion_menu_combos(Scanner wali) {
        List<Double> precios_complementos_seleccionados_temp = new ArrayList<>();
        List<Double> precios_menu_selecionados_temp = new ArrayList<>();
        List<String> menu_seleccionados_temp = new ArrayList<>();
        List<String> complementos_seleccionados_temp = new ArrayList<>();
        List<Integer> cantidades_menu_seleccionados_temp = new ArrayList<>();
        double precio_seleccionado = 0.0;
        int cantidad_producto = 0;

        for (String[] fila : menu_combos) {
            System.out.printf("%-50s%-50s%n", fila[0], fila[1]);
        }
        System.out.println("Seleccione una opción");
        String opcion = wali.nextLine();
        int opcion_entero = Integer.parseInt(opcion);
        if (opcion_entero >= 1 && opcion_entero <= precio_combos.length) {
            System.out.println("Seleccionó " + menu_combos[(opcion_entero - 1) / 2][(opcion_entero - 1) % 2]);
            precio_seleccionado = precio_combos[opcion_entero - 1];
            menu_seleccionados_temp.add(menu_combos[(opcion_entero - 1) / 2][(opcion_entero - 1) % 2]);
            precios_menu_selecionados_temp.add(precio_seleccionado);
            cantidades_menu_seleccionados_temp.add(cantidad_producto);
            menu_seleccionados.addAll(menu_seleccionados_temp);
            precios_menu_selecionados.addAll(precios_menu_selecionados_temp);

        } else {
            System.out.println("opción no válida.");
        }
        System.out.println("¿Cuántas unidades desea comprar?");
        cantidad_producto = wali.nextInt();
        cantidades_menu_seleccionados_temp.add(cantidad_producto);
        cantidades_menu_seleccionados.add(cantidad_producto);
        wali.nextLine();
        System.out.println("¿Desea añadir algún complemento?");
        for (int i = 0; i < menu_complementos.length; i++) {
            String[] fila = menu_complementos[i];
            System.out.printf("%-50s%-50s%-50s%n", fila[0], fila[1], fila[2]);
        }
        int opcion_complementos;
        while ((opcion_complementos = wali.nextInt()) != 0) {
            if (opcion_complementos > 0 && opcion_complementos <= precios_complementos.length) {
                complementos_seleccionados_temp.add(menu_complementos[(opcion_complementos - 1) / 3][(opcion_complementos - 1) % 3]);
                precios_complementos_seleccionados_temp.add(precios_complementos[opcion_complementos - 1]);
                complementos_seleccionados.addAll(complementos_seleccionados_temp);
                precios_complementos_seleccionados.addAll(precios_complementos_seleccionados_temp);
            } else {
                System.out.println("Opción no válida.");
            }
            System.out.println("Ingrese el número del complemento que desea agregar ( 0 para terminar):");
        }
        wali.nextLine();
        double totalPedido = pedido(cantidad_producto, precio_seleccionado, precios_complementos_seleccionados,precios_promociones_selecionadas);
        informacion_pedido(totalPedido, menu_seleccionados_temp, cantidad_producto, complementos_seleccionados_temp, precios_menu_selecionados_temp,precios_complementos_seleccionados_temp);
        System.out.println("desea añadirlo a su carrito? (SI/NO)");
        opcion = wali.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            System.out.println("desea:");
            System.out.println("1.- seguir comprando(volver al menu)");
            System.out.println("2.- realizar el pago su pedido");
            System.out.println("3.- ver su carrito");
            System.out.println("4.- volver a la pagina principal");
            opcion = wali.nextLine();
            switch (opcion) {
                case "1":
                    menu_principal();
                    break;
                case "2":
                    System.out.println(" ");
                    carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
                    break;
                case "3":
                    carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
                    break;
                case "4":
                    pagina_principal();
                    break;
            }

        }else {
            System.out.println("desea realizar el pago de su pedido? (SI/NO)");
            opcion= wali.nextLine();
            if (opcion.equalsIgnoreCase("si")){
                carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
            }else {
                System.out.println("su pedido se a cancelado");
                System.out.println("No, nos dejes, deseaa..");
                System.out.println("1.- volver al menu principal");
                System.out.println("2.- volver a la pagina principal");
                System.out.println("3.- salir");
                opcion= wali.nextLine();
                switch (opcion){
                    case "1":
                        menu_principal();
                        break;
                    case "3":
                        System.out.println("gracias por visitar la pagina de KFC");
                        System.out.println("esperamos, que vuelva pronto");
                        break;
                }
            }
        }
    }

    public static void seleccionacion_menu_sandwiches_tostados(Scanner wali) {
        List<Double> precios_complementos_seleccionados_temp = new ArrayList<>();
        List<Double> precios_menu_selecionados_temp = new ArrayList<>();
        List<String> menu_seleccionados_temp = new ArrayList<>();
        List<String> complementos_seleccionados_temp = new ArrayList<>();
        List<Integer> cantidades_menu_seleccionados_temp = new ArrayList<>();
        double precio_seleccionado = 0.0;
        int cantidad_producto = 0;

        for (String[] fila : menu_sandwich) {
            System.out.printf("%-50s%-50s%n", fila[0], fila[1]);
        }
        System.out.println("Seleccione una opción");
        String opcion = wali.nextLine();
        int opcion_entero = Integer.parseInt(opcion);
        if (opcion_entero >= 1 && opcion_entero <= precio_sandwich.length) {
            System.out.println("Seleccionó " + menu_sandwich[(opcion_entero - 1) / 2][(opcion_entero - 1) % 2]);
            precio_seleccionado = precio_sandwich[opcion_entero - 1];
            menu_seleccionados_temp.add(menu_sandwich[(opcion_entero - 1) / 2][(opcion_entero - 1) % 2]);
            precios_menu_selecionados_temp.add(precio_seleccionado);
            cantidades_menu_seleccionados_temp.add(cantidad_producto);
            menu_seleccionados.addAll(menu_seleccionados_temp);
            precios_menu_selecionados.addAll(precios_menu_selecionados_temp);

        } else {
            System.out.println("opción no válida.");
        }
        System.out.println("¿Cuántas unidades desea comprar?");
        cantidad_producto = wali.nextInt();
        cantidades_menu_seleccionados_temp.add(cantidad_producto);
        cantidades_menu_seleccionados.add(cantidad_producto);
        wali.nextLine();
        System.out.println("¿Desea añadir algún complemento?");
        for (int i = 0; i < menu_complementos.length; i++) {
            String[] fila = menu_complementos[i];
            System.out.printf("%-50s%-50s%-50s%n", fila[0], fila[1], fila[2]);
        }
        int opcion_complementos;
        while ((opcion_complementos = wali.nextInt()) != 0) {
            if (opcion_complementos > 0 && opcion_complementos <= precios_complementos.length) {
                complementos_seleccionados_temp.add(menu_complementos[(opcion_complementos - 1) / 3][(opcion_complementos - 1) % 3]);
                precios_complementos_seleccionados_temp.add(precios_complementos[opcion_complementos - 1]);
                complementos_seleccionados.addAll(complementos_seleccionados_temp);
                precios_complementos_seleccionados.addAll(precios_complementos_seleccionados_temp);
            } else {
                System.out.println("Opción no válida.");
            }
            System.out.println("Ingrese el número del complemento que desea agregar ( 0 para terminar):");
        }
        wali.nextLine();
        double totalPedido = pedido(cantidad_producto, precio_seleccionado, precios_complementos_seleccionados,precios_promociones_selecionadas);
        informacion_pedido(totalPedido, menu_seleccionados_temp, cantidad_producto, complementos_seleccionados_temp, precios_menu_selecionados_temp,precios_complementos_seleccionados_temp);
        System.out.println("desea añadirlo a su carrito? (SI/NO)");
        opcion = wali.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            System.out.println("desea:");
            System.out.println("1.- seguir comprando(volver al menu)");
            System.out.println("2.- realizar el pago su pedido");
            System.out.println("3.- ver su carrito");
            System.out.println("4.- volver a la pagina principal");
            opcion = wali.nextLine();
            switch (opcion) {
                case "1":
                    menu_principal();
                    break;
                case "2":
                    System.out.println(" ");
                    carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
                    break;
                case "3":
                    carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
                    break;
                case "4":
                    pagina_principal();
                    break;
            }

        }else {
            System.out.println("desea realizar el pago de su pedido? (SI/NO)");
            opcion= wali.nextLine();
            if (opcion.equalsIgnoreCase("si")){
                carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
            }else {
                System.out.println("su pedido se a cancelado");
                System.out.println("No, nos dejes, deseaa..");
                System.out.println("1.- volver al menu principal");
                System.out.println("2.- volver a la pagina principal");
                System.out.println("3.- salir");
                opcion= wali.nextLine();
                switch (opcion){
                    case "1":
                        menu_principal();
                        break;
                    case "3":
                        System.out.println("gracias por visitar la pagina de KFC");
                        System.out.println("esperamos, que vuelva pronto");
                        break;
                }
            }
        }
    }
    public static void menu_promociones (Scanner wali,String [][] menu_promociones, double [] precios_promociones) {
        List<String> promociones_selecionadas_temp = new ArrayList<>();
        List<Double> precios_promociones_selecionadas_temp = new ArrayList<>();
        List<Integer> cantidades_promociones_seleccionados_temp = new ArrayList<>();
        List<String> complementos_seleccionados_temp =new ArrayList<>();
        List<Double> precios_complementos_seleccionados_temp = new ArrayList<>();
        double precio_seleccionado = 0.0;
        int cantidad_producto=0;
        for (String[] fila : menu_promociones) {
            System.out.printf("%-50s%-50s%n", fila[0], fila[1]);
        }
        System.out.println("seleccione una opcion:");
        String opcion = wali.nextLine();
        int opcion_entero = Integer.parseInt(opcion);
        if (opcion_entero >= 1 && opcion_entero <= precios_promociones.length) {
            System.out.println("Seleccionó " + menu_promociones[(opcion_entero - 1) / 2][(opcion_entero - 1) % 2]);
            precio_seleccionado = precios_promociones[opcion_entero - 1];
            promociones_selecionadas_temp.add(menu_promociones[(opcion_entero - 1) / 2][(opcion_entero - 1) % 2]);
            precios_promociones_selecionadas_temp.add(precio_seleccionado);
            promociones_selecionadas.addAll(promociones_selecionadas_temp);
            precios_promociones_selecionadas.addAll(precios_promociones_selecionadas_temp);
        }else {
            System.out.println("opcion no valida");
        }
        System.out.println("¿Cuántas unidades desea comprar?");
        cantidad_producto = wali.nextInt();
        cantidades_promociones_seleccionados_temp.add(cantidad_producto);
        cantidades_promociones_seleccionados.add(cantidad_producto);
        wali.nextLine();
        System.out.println("¿Desea añadir algún complemento?");
        for (int i = 0; i < menu_complementos.length; i++) {
            String[] fila = menu_complementos[i];
            System.out.printf("%-50s%-50s%-50s%n", fila[0], fila[1], fila[2]);
        }
        int opcion_complementos;
        while ((opcion_complementos = wali.nextInt()) != 0) {
            if (opcion_complementos > 0 && opcion_complementos <= precios_complementos.length) {
                complementos_seleccionados_temp.add(menu_complementos[(opcion_complementos - 1) / 3][(opcion_complementos - 1) % 3]);
                precios_complementos_seleccionados_temp.add(precios_complementos[opcion_complementos - 1]);
                complementos_seleccionados.addAll(complementos_seleccionados_temp);
                precios_complementos_seleccionados.addAll(precios_complementos_seleccionados_temp);
            } else {
                System.out.println("Opción no válida.");
            }
            System.out.println("Ingrese el número del complemento que desea agregar ( 0 para terminar):");
        }
        wali.nextLine();
        double totalPedido = pedido(cantidad_producto, precio_seleccionado, precios_complementos_seleccionados,precios_promociones_selecionadas);
        informacion_pedido_promociones(totalPedido, cantidad_producto, complementos_seleccionados_temp, precios_complementos_seleccionados_temp, promociones_selecionadas_temp, precios_promociones_selecionadas_temp);
        System.out.println("desea añadirlo a su carrito? (SI/NO)");
        opcion = wali.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            System.out.println("desea:");
            System.out.println("1.- seguir comprando(volver al menu)");
            System.out.println("2.- ralizar el pago su pedido");
            System.out.println("3.- ver su carrito");
            opcion = wali.nextLine();
            switch (opcion) {
                case "1":
                    menu_principal();
                    break;
                case "2":
                    System.out.println(" ");
                    carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
                    break;
                case "3":
                    carrito(cantidades_menu_seleccionados, precios_complementos_seleccionados, precios_menu_selecionados,  menu_seleccionados, complementos_seleccionados, promociones_selecionadas,  precios_promociones_selecionadas, cantidades_promociones_seleccionados);
                    break;
            }

        }else {
            System.out.println("desea realizar el pago de su pedido? (SI/NO)");
            opcion= wali.nextLine();
            if (opcion.equalsIgnoreCase("si")){
                metodo_de_pago();
            }else {
                System.out.println("su pedido se a cancelado");
                System.out.println("No, nos dejes, deseaa..");
                System.out.println("1.- volver al menu principal");
                System.out.println("2.- salir");
                opcion= wali.nextLine();
                switch (opcion){
                    case "1":
                        menu_principal();
                        break;
                    case "2":
                        System.out.println("gracias por visitar la pagina de KFC");
                        System.out.println("esperamos, que vuelva pronto");
                        break;
                }
            }
        }
    }

    public static double pedido(int cantidad_de_producto, double precio_seleccionado, List<Double> precios_complementos_seleccionados_temp,List<Double> precios_promociones_selecionadas_temp) {
        double preciocomplementario = 0;
        for (double precio : precios_complementos_seleccionados_temp) {
            preciocomplementario += precio;
        }
        for (double precio_promociones : precios_promociones_selecionadas_temp) {
            preciocomplementario += precio_promociones;
        }
        double pre_total = (precio_seleccionado * cantidad_de_producto);
        return pre_total;
    }

    public static void informacion_pedido(double pre_total, List<String> menu_seleccionados_temp, int cantidad_de_producto, List<String> menu_complementos_temp, List<Double> precios_menu_selecionados_temp, List<Double> precios_complementos_seleccionados_temp) {
        for (int i = 0; i < menu_seleccionados_temp.size(); i++) {
            System.out.println("Menu: " + menu_seleccionados_temp.get(i));
        }

        System.out.println("Cantidad de producto: " + cantidad_de_producto);
        System.out.println("precio total de menu: S/" + pre_total);
        double total_complementos = 0;
        for (int i = 0; i < menu_complementos_temp.size(); i++) {
            String complemento = menu_complementos_temp.get(i).split("\\.")[1];
            System.out.println("Complemento/Extras: " + complemento);
            total_complementos += precios_complementos_seleccionados_temp.get(i);
        }
        System.out.println("Total de complementos: S/ " + total_complementos);
        System.out.println("Total de su pedido más complementos: S/ " + (pre_total + total_complementos));
        menu_seleccionados_temp.clear();
        precios_menu_selecionados_temp.clear();
        menu_complementos_temp.clear();
        precios_complementos_seleccionados_temp.clear();
    }
    public static void informacion_pedido_promociones (double pre_total, int cantidad_de_producto, List<String> menu_complementos_temp, List<Double> precios_complementos_seleccionados_temp, List<String> promociones_selecionadas_temp, List<Double> precios_promociones_selecionadas_temp) {
        for (int i = 0; i < promociones_selecionadas_temp.size(); i++) {
            System.out.println("MENU (PROMOCIONES): " + promociones_selecionadas_temp.get(i));
        }
        System.out.println("Cantidad de producto: " + cantidad_de_producto);
        System.out.println("precio total de menu: S/" + pre_total);
        double total_complementos = 0;
        for (int i = 0; i < menu_complementos_temp.size(); i++) {
            String complemento = menu_complementos_temp.get(i).split("\\.")[1];
            System.out.println("Complemento/Extras: " + complemento);
            total_complementos += precios_complementos_seleccionados_temp.get(i);
        }
        System.out.println("Total de complementos: S/ " + total_complementos);
        System.out.println("Total de su pedido más complementos: S/ " + (pre_total + total_complementos));
        menu_complementos_temp.clear();
        precios_complementos_seleccionados_temp.clear();
        precios_promociones_selecionadas_temp.clear();
        promociones_selecionadas_temp.clear();
    }
    public static void carrito(List<Integer> cantidades_menu_seleccionados, List<Double> precios_complementos_seleccionados, List<Double> precios_menu_selecionados, List<String> menu_seleccionados, List<String> complementos_seleccionados, List<String> promociones_selecionadas, List<Double> precios_promociones_selecionadas, List<Integer> cantidades_promociones_seleccionados) {
        Scanner wali = new Scanner(System.in);
        double total_precio = 0.0;
        double total_menu = 0.0;
        double precio_promociones = 0.0;
        double total_promociones = 0.0;
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("                      Detalles del carrito:");
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        System.out.println("  Número de menús seleccionados: " + menu_seleccionados.size());
        System.out.println("──────────────────────────────────────────────────────────────");
        for (int i = 0; i < menu_seleccionados.size(); i++) {
            String menus = menu_seleccionados.get(i).split("\\.")[1];
            System.out.println("──────────────────────────────────────────────────────────────");
            System.out.println("  MENU: " +menus);
            System.out.println("--------------------------------------------------------------");
            System.out.println("  Cantidad de menú seleccionado: " + cantidades_menu_seleccionados.get(i));
            System.out.println("--------------------------------------------------------------");
            total_precio += precios_menu_selecionados.get(i) * cantidades_menu_seleccionados.get(i);
            total_menu = precios_menu_selecionados.get(i) * cantidades_menu_seleccionados.get(i);
            System.out.println("  total de menu. S/. "+total_menu);
            System.out.println("──────────────────────────────────────────────────────────────");
        }
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        System.out.println("  Número de menús (promociones) seleccionados: " + promociones_selecionadas.size());
        System.out.println("──────────────────────────────────────────────────────────────");
        for (int i = 0; i < promociones_selecionadas.size(); i++) {
            String menuss = promociones_selecionadas.get(i).split("\\.")[1];
            System.out.println("──────────────────────────────────────────────────────────────");
            System.out.println("  MENU (promociones): " +menuss);
            System.out.println("--------------------------------------------------------------");
            System.out.println("  Cantidad de menú seleccionado: " + cantidades_promociones_seleccionados.get(i));
            System.out.println("--------------------------------------------------------------");
            precio_promociones += precios_promociones_selecionadas.get(i) * cantidades_promociones_seleccionados.get(i);
            total_promociones = precios_promociones_selecionadas.get(i) * cantidades_promociones_seleccionados.get(i);
            System.out.println("  total de menu (promociones). S/. "+total_promociones);
            total_precio+= precio_promociones;
            System.out.println("──────────────────────────────────────────────────────────────");
        }
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        System.out.println("  Complementos seleccionados:");
        System.out.println("──────────────────────────────────────────────────────────────");
        for (int i = 0; i < complementos_seleccionados.size(); i++) {
            String complemento = complementos_seleccionados.get(i).split("\\.")[1];
            System.out.println("--------------------------------------------------------------");
            System.out.println("  Complemento/Extras: " + complemento);
            System.out.println("--------------------------------------------------------------");
            total_precio += precios_complementos_seleccionados.get(i);
        }
        System.out.println("──────────────────────────────────────────────────────────────");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println("  Total de compra(menu): S/ " + total_precio);
        System.out.println("──────────────────────────────────────────────────────────────");
        double ivg_total = total_precio*igv;
        System.out.println("IGV : S/ "+ivg_total);
        System.out.println("──────────────────────────────────────────────────────────────");
        System.out.println("SU TOTAL DE COMPRA(PEDIDO) ES: "+(ivg_total+total_precio));
        System.out.println("════════════════════════════════════════════════════════════════");
        System.out.println("PRECIONE ENTER PARA CONTINUAR; ");
        wali.nextLine();
        String opcion;
        System.out.println("1.- realizar el pago de su carrito");
        System.out.println("2.- volver al menu principal");
        System.out.println("3.- volver a la pagina principal");
        opcion= wali.nextLine();
        switch (opcion){
            case "1":
                System.out.println("elija un metodo de entrega ");
                System.out.println("metodo de entrega disponibles; ");
                System.out.println("1.- delivery mas (S/ 10)");
                System.out.println("2.- recojo en tienda (S/ 0)");
                opcion = wali.nextLine();
                switch (opcion){
                    case "1":
                        System.out.println("╔══════════════════════════════════════════════════════════════╗");
                        System.out.println("                 DETALLES DE CARRITO ACTUALIZADO:");
                        System.out.println("├──────────────────────────────────────────────────────────────┤");
                        System.out.println("  Número de menús seleccionados: " + menu_seleccionados.size());
                        System.out.println("──────────────────────────────────────────────────────────────");
                        for (int i = 0; i < menu_seleccionados.size(); i++) {
                            String menus = menu_seleccionados.get(i).split("\\.")[1];
                            System.out.println("──────────────────────────────────────────────────────────────");
                            System.out.println("  MENU: " +menus);
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("  Cantidad de menú seleccionado: " + cantidades_menu_seleccionados.get(i));
                            System.out.println("--------------------------------------------------------------");
                            total_precio += precios_menu_selecionados.get(i) * cantidades_menu_seleccionados.get(i);
                            total_menu = precios_menu_selecionados.get(i) * cantidades_menu_seleccionados.get(i);
                            System.out.println("  total de menu. S/. "+total_menu);
                            System.out.println("──────────────────────────────────────────────────────────────");
                        }
                        System.out.println("├──────────────────────────────────────────────────────────────┤");
                        System.out.println("  Número de menús (promociones) seleccionados: " + promociones_selecionadas.size());
                        System.out.println("──────────────────────────────────────────────────────────────");
                        for (int i = 0; i < promociones_selecionadas.size(); i++) {
                            String menuss = promociones_selecionadas.get(i).split("\\.")[1];
                            System.out.println("──────────────────────────────────────────────────────────────");
                            System.out.println("  MENU (promociones): " +menuss);
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("  Cantidad de menú seleccionado: " + cantidades_promociones_seleccionados.get(i));
                            System.out.println("--------------------------------------------------------------");
                            precio_promociones += precios_promociones_selecionadas.get(i) * cantidades_promociones_seleccionados.get(i);
                            total_promociones = precios_promociones_selecionadas.get(i) * cantidades_promociones_seleccionados.get(i);
                            System.out.println("  total de menu (promociones). S/. "+total_promociones);
                            total_precio+= precio_promociones;
                            System.out.println("──────────────────────────────────────────────────────────────");
                        }
                        System.out.println("├──────────────────────────────────────────────────────────────┤");
                        System.out.println("  Complementos seleccionados:");
                        System.out.println("──────────────────────────────────────────────────────────────");
                        for (int i = 0; i < complementos_seleccionados.size(); i++) {
                            String complemento = complementos_seleccionados.get(i).split("\\.")[1];
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("  Complemento/Extras: " + complemento);
                            System.out.println("--------------------------------------------------------------");
                            total_precio += precios_complementos_seleccionados.get(i);
                        }
                        System.out.println("──────────────────────────────────────────────────────────────");
                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                        System.out.println("  Total de compra(menu): S/ " + total_precio);
                        System.out.println("──────────────────────────────────────────────────────────────");
                        ivg_total = total_precio*igv;
                        System.out.println("IGV : S/ "+ivg_total);
                        int delivery = 10;
                        System.out.println("──────────────────────────────────────────────────────────────");
                        System.out.println("DELIVERY (S/ 10): S/ "+delivery);
                        System.out.println("──────────────────────────────────────────────────────────────");
                        System.out.println("SU TOTAL DE COMPRA(PEDIDO) ES: "+(ivg_total+total_precio+delivery));
                        System.out.println("════════════════════════════════════════════════════════════════");
                        System.out.println("PRECIONE ENTER PARA CONTINUAR:");
                        wali.nextLine();
                        System.out.println("SU DIRRECION ACTUAL ES: "+direccion_selecioanda);
                        System.out.println("EN CUAL DE NUESTRAS DIRRECIONS SE UBICA");
                        System.out.println("ELIJA UNA DE NUESTRAS DIRRECIONES DE ENTREGA: ");
                        for (int i = 0; i < dirreciones_de_entrega.length; i++) {
                            System.out.println((i + 1) + ".- " + dirreciones_de_entrega[i]);
                        }
                        opcion = wali.nextLine();
                        int opcion_entera = Integer.parseInt(opcion);
                        switch (opcion_entera){
                            case 1:
                                System.out.println("dirrecion selecionado: "+dirreciones_de_entrega[opcion_entera - 1]);;
                                System.out.println("Su pedido llegara antes que se enfrie ");
                                System.out.println("  __");
                                System.out.println(" /|||\\`.__");
                                System.out.println("(   _    _ _\\");
                                System.out.println("=`-()--()-'");
                                System.out.println("     o  o");
                                System.out.println("--------------------");
                                metodo_entrega = true;
                                System.out.println("precione enter para realizar el pago:");
                                wali.nextLine();
                                metodo_de_pago();
                                System.out.println("PRECIONE ENTER PARA VER SU FACTURA:");
                                wali.nextLine();
                                factura(menu_seleccionados, cantidades_menu_seleccionados, precios_menu_selecionados, promociones_selecionadas, cantidades_promociones_seleccionados, precios_promociones_selecionadas,metodo_entrega,metodo_de_pago_seleccioando);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "2":
                        System.out.println("╔══════════════════════════════════════════════════════════════╗");
                        System.out.println("                  DETALLES DE CARRITO ACTUALIZADO:");
                        System.out.println("├──────────────────────────────────────────────────────────────┤");
                        System.out.println("  Número de menús seleccionados: " + menu_seleccionados.size());
                        System.out.println("──────────────────────────────────────────────────────────────");
                        for (int i = 0; i < menu_seleccionados.size(); i++) {
                            String menus = menu_seleccionados.get(i).split("\\.")[1];
                            System.out.println("──────────────────────────────────────────────────────────────");
                            System.out.println("  MENU: " +menus);
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("  Cantidad de menú seleccionado: " + cantidades_menu_seleccionados.get(i));
                            System.out.println("--------------------------------------------------------------");
                            total_precio += precios_menu_selecionados.get(i) * cantidades_menu_seleccionados.get(i);
                            total_menu = precios_menu_selecionados.get(i) * cantidades_menu_seleccionados.get(i);
                            System.out.println("  total de menu. S/. "+total_menu);
                            System.out.println("──────────────────────────────────────────────────────────────");
                        }
                        System.out.println("├──────────────────────────────────────────────────────────────┤");
                        System.out.println("  Número de menús (promociones) seleccionados: " + promociones_selecionadas.size());
                        System.out.println("──────────────────────────────────────────────────────────────");
                        for (int i = 0; i < promociones_selecionadas.size(); i++) {
                            String menuss = promociones_selecionadas.get(i).split("\\.")[1];
                            System.out.println("──────────────────────────────────────────────────────────────");
                            System.out.println("  MENU (promociones): " +menuss);
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("  Cantidad de menú seleccionado: " + cantidades_promociones_seleccionados.get(i));
                            System.out.println("--------------------------------------------------------------");
                            precio_promociones += precios_promociones_selecionadas.get(i) * cantidades_promociones_seleccionados.get(i);
                            total_promociones = precios_promociones_selecionadas.get(i) * cantidades_promociones_seleccionados.get(i);
                            System.out.println("  total de menu (promociones). S/. "+total_promociones);
                            total_precio+= precio_promociones;
                            System.out.println("──────────────────────────────────────────────────────────────");
                        }
                        System.out.println("├──────────────────────────────────────────────────────────────┤");
                        System.out.println("  Complementos seleccionados:");
                        System.out.println("──────────────────────────────────────────────────────────────");
                        for (int i = 0; i < complementos_seleccionados.size(); i++) {
                            String complemento = complementos_seleccionados.get(i).split("\\.")[1];
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("  Complemento/Extras: " + complemento);
                            System.out.println("--------------------------------------------------------------");
                            total_precio += precios_complementos_seleccionados.get(i);
                        }
                        System.out.println("──────────────────────────────────────────────────────────────");
                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                        System.out.println("  Total de compra(menu): S/ " + total_precio);
                        System.out.println("──────────────────────────────────────────────────────────────");
                        ivg_total = total_precio*igv;
                        System.out.println("IGV : S/ "+ivg_total);
                        System.out.println("──────────────────────────────────────────────────────────────");
                        System.out.println("SU TOTAL DE COMPRA(PEDIDO) ES: "+(ivg_total+total_precio));
                        System.out.println("════════════════════════════════════════════════════════════════");
                        metodo_entrega = false;
                        System.out.println("precione enter para realizar el pago:");
                        wali.nextLine();
                        metodo_de_pago();
                        System.out.println("PRECIONE ENTER PARA VER SU FACTURA:");
                        wali.nextLine();
                        factura(menu_seleccionados, cantidades_menu_seleccionados, precios_menu_selecionados, promociones_selecionadas, cantidades_promociones_seleccionados, precios_promociones_selecionadas,metodo_entrega,metodo_de_pago_seleccioando);
                        break;
                }
                break;
            case "2":
                menu_principal();
                break;
            case "3":
                pagina_principal();
                break;
        }
    }
    public static void iniciar_sesion() {
        Scanner wali = new Scanner(System.in);
        String direccion, op;
        String correo_valido, contraseña_valida;
        String registro, contraeña, respuesta;
        respuesta= wali.nextLine();
        System.out.println("PARA COMONEZAR A REALIZAR PEDIDOS DEBE: (registrese/inicie sesion)");
        System.out.println("1.- REGISTRARSE");
        System.out.println("2.- INICIAR SESION");
        op= wali.nextLine();
        switch (op) {
            case "1":
                if (!registrarse) {
                    System.out.println("REGISTRO:");
                    System.out.println("registre su correo electronico:");
                    registro = wali.nextLine();
                    while (!registro.contains("@gmail.com")) {
                        System.out.println("Correo electrónico inválido, por favor vuelva a intentar :).");
                        registro = wali.nextLine();
                    }
                    registro_de_usuarios.add(registro);
                    System.out.println("cree su contraeña:");
                    contraeña = wali.nextLine();
                    registro_de_contraseñas.add(contraeña);
                    String[] usuarios = registro_de_usuarios.toArray(new String[0]);
                    String[] contraseñas = registro_de_contraseñas.toArray(new String[0]);
                    System.out.println("INICIAR SESIÓN:");
                    do {
                        System.out.println("Ingrese su correo electrónico");
                        correo_valido = wali.nextLine();
                        System.out.println("Ingrese su contraseña: ");
                        contraseña_valida = wali.nextLine();
                        for (int i = 0; i < registro_de_usuarios.size(); i++) {
                            if (correo_valido.equals(registro_de_usuarios.get(i)) && contraseña_valida.equals(registro_de_contraseñas.get(i))) {
                                System.out.println("Inicio de sesión, ¡EXITOSO!");
                                registrarse = true;
                                inicio_sesion = true;
                                break;
                            }
                        }
                        if (!inicio_sesion) {
                            System.out.println("Inicio de sesión, ¡FALLIDO!");
                            System.out.println("Correo o contraseña incorrecta.");
                        }
                    } while (!registrarse);
                    System.out.println("INGRESE SU DIRRECCION:");
                    direccion = wali.nextLine().trim();
                    while (direccion.length() <= 8) {
                        System.out.println("por favor, ingrese valida");
                        direccion = wali.nextLine().trim();
                    }
                    System.out.println("DIRECCION GUARDADA CON ¡EXITO!: " + direccion);
                    direccion_selecioanda = direccion;
                    menu_principal();
                }
                break;
            case "2":
                String[] usuarios = registro_de_usuarios.toArray(new String[0]);
                String[] contraseñas = registro_de_contraseñas.toArray(new String[0]);
                System.out.println("INICIAR SESIÓN:");
                System.out.println("ingrese su correo:");
                correo_valido = wali.nextLine();
                System.out.println("ingrese su contraseña:");
                contraseña_valida = wali.nextLine();
                for (int i = 0; i < usuarios.length; i++) {
                    if (correo_valido.equals(usuarios[i]) && contraseña_valida.equals(contraseñas[i])) {
                        System.out.println("Inicio de sesión, ¡EXITOSO!");
                        registrarse = true;
                    }
                }
                menu_principal();
                break;

        }

    }
    static void metodo_de_pago(){
        Scanner opcion=new Scanner(System.in);
        int op;
        System.out.println("SELECIONE POR CUAL METODO DE PAGO, VA A RELIZAR SU PAGO");
        System.out.println("1:   TERJETA VISA/MASTERCARD");
        System.out.println("2:   YAPE (SOLO NUMERO)");
        System.out.println("3:   CONTRA ENTREGA (EFECTIVO)");
        op=opcion.nextInt();
        switch (op){
            case 1:
                metodopago_tarjeta();
                break;
            case 2:
                metodopago_yape();
                break;
            case 3:
                metodopago_contraentrega();
                break;
        }
    }
    public static  boolean tipo_de_tarjeta;
    static void metodopago_tarjeta() {
        String metodo, fecha, cvv,nombre,confirmar,volver,volverr,menu;
        boolean valida;
        Scanner wali = new Scanner(System.in);
        do {
            System.out.println("INGRESE EL NOMBRE Y APELLIDO DEL TITULAR DE LA TARJETA");
            nombre= wali.nextLine();
            System.out.println("INGRESE SU NUMERO DE TARJETA:  (1234 1234 1234 1234)");
            metodo = wali.nextLine().trim();
            if (metodo.length() != 19 || !metodo.matches("[4-5]\\d{3} \\d{4} \\d{4} \\d{4}")) {
                System.out.println("Por favor, INGRESE SU NUMERO DE TARJETA TAL COMO SE MUESTRA EN SU TARJETA.");
            } else {
                if (metodo.startsWith("4")) {
                    System.out.println("Tarjeta tipo: Visa");
                    tipo_de_tarjeta=true;
                } else if (metodo.startsWith("5")) {
                    System.out.println("Tarjeta tipo: MasterCard");
                    tipo_de_tarjeta=false;
                }
                metodo_de_pago_seleccioando += (tipo_de_tarjeta ? " VISA" : " MASTERCARD");
            }
        } while (metodo.length() != 19 || !metodo.matches("[4-5]\\d{3} \\d{4} \\d{4} \\d{4}"));
        do {
            System.out.println("INGRESE LA FECHA DE VENCIMIENTO DE SU TARJETA (MM/AAAA):");
            fecha = wali.nextLine().trim();
            valida = fecha.matches("\\d{2}/\\d{4}");
            if (valida) {
                String[] partes = fecha.split("/");
                int mes = Integer.parseInt(partes[0]);
                int año = Integer.parseInt(partes[1]);
                valida = (año >= 2024 && mes >= 6) && (año <= 2035 && mes <= 12);
            }
            if (!valida) {
                System.out.println("Por favor, SU TARJETA VENCIÓ, VUELVE A INTENTAR O CAMBIE EL METODO DE PAGO.");
            }
        } while (!valida);
        do {
            System.out.println("INGRESE SU CODIGO (CVV)");
            cvv = wali.nextLine().trim();
            if (cvv.length() != 3 || !cvv.matches("\\d{3}")) {
                System.out.println("Por favor, CODIGO (CVV) INCORRECTO O NO COENCIDE CON LA TERJETA, VUELVE A INTENTAR.");
            }
        }while (cvv.length() != 3 || !cvv.matches("\\d{3}"));
        System.out.println("DESEA CONFIRMAR SU METODO DE PAGO:  (SI/NO)");
        confirmar = wali.nextLine();
        if (confirmar.equals("si")||confirmar.equals("SI")){
            metodo_de_pago_seleccioando = "TARJETA(CREDITO/DEBITO) ";
            System.out.println("PAGO FUE REALIZADO CON EXITO");
            System.out.println("LA TRANSACCION FUE REALIZADA POR EL TITULAR: " + nombre);
            System.out.println("MONTO DESCONTADO A LA TARJETA: " + metodo + " -- " + fecha + " -- XXX");
            System.out.println("GRACIAS POR SU COMPRA");
            System.out.println("DESEA VOLVER AL MENU PRINCIPAL?? (SI/NO)");
            volver = wali.nextLine();
            if (volver.equals("si")||volver.equals("SI")) {
                System.out.println("MENU");
            }
        } else if (confirmar.equals("no")||confirmar.equals("NO")) {
            System.out.println("SU PAGO SE HA CANCELADO");
            System.out.println("¿DESEA CAMBIAR DE MÉTODO DE PAGO? (SI/NO)");
            volverr = wali.nextLine();
            if (volverr.equals("si") || volverr.equals("SI")) {
                metodo_de_pago();
            } else {
                System.out.println("SU PEDIDO SE HA CANCELADO");
                System.out.println("DESEA VOLVER AL MENU PRINCIPAL?? (SI/NO)");
                menu= wali.nextLine();
                if (menu.equals("si")||menu.equals("SI")) {
                    System.out.println("MENU");
                }else {
                    System.out.println("GRACIAS POR VISITAR LA PAGINA DE KFC");
                }
            }
        }
    }
    static void metodopago_yape(){
        String yape,confirmar,volver,volverr,menu;
        Scanner yapee =new Scanner(System.in);
        do {
            System.out.println("Ingrese su número de teléfono asociado a Yape para efectuar su pedido");
            yape = yapee.nextLine().trim();
            if (yape.length() !=9 || !yape.matches("[9]\\d{8}")){
                System.out.println("Número de Yape inválido. Por favor, ingrese un número de 9 dígitos que comience con 9");
            }
        } while (yape.length() !=9 || !yape.matches("[9]\\d{8}"));
        System.out.println("DESEA CONFIRMAR SU METODO DE PAGO:  (SI/NO)");
        confirmar = yapee.nextLine();
        if (confirmar.equals("si")||confirmar.equals("SI")){
            metodo_de_pago_seleccioando = "YAPE";
            System.out.println("PAGO FUE REALIZADO CON EXITO");
            System.out.println("Pago realizado con éxito a través de Yape, con el numero de:" +yape);
            System.out.println("GRACIAS POR SU COMPRA");
            System.out.println("DESEA VOLVER AL MENU PRINCIPAL?? (SI/NO)");
            volver = yapee.nextLine();
            if (volver.equals("si")||volver.equals("SI")) {
                System.out.println("MENU");
            }
        } else if (confirmar.equals("no")||confirmar.equals("NO")) {
            System.out.println("SU PAGO SE HA CANCELADO");
            System.out.println("¿DESEA CAMBIAR DE MÉTODO DE PAGO? (SI/NO)");
            volverr = yapee.nextLine();
            if (volverr.equals("si") || volverr.equals("SI")) {
                metodo_de_pago();
            } else {
                System.out.println("SU PEDIDO SE HA CANCELADO");
                System.out.println("DESEA VOLVER AL MENU PRINCIPAL?? (SI/NO)");
                menu= yapee.nextLine();
                if (menu.equals("si")||menu.equals("SI")) {
                    System.out.println("MENU");
                }else {
                    System.out.println("GRACIAS POR VISITAR LA PAGINA DE KFC");
                }
            }
        }
    }
    static void metodopago_contraentrega (){
        String contra,respuesta,menu, menus;
        Scanner entrega = new Scanner(System.in);
        System.out.println("SE REALIZA EL COBRO AL MOMENTO DE RECIBIR SU PEDIDD :) ");
        while (true){
            System.out.println("¿Está de acuerdo con el pago contra entrega? (SI/NO)");
            contra = entrega.nextLine();
            if (contra.equals("si")||contra.equals("SI")) {
                metodo_de_pago_seleccioando = "Contra entrega";
                System.out.println("Gracias por confirmar. Su pedido se procesará con pago contra entrega.");
                System.out.println("Su pedido llegara antes que se enfrie ");
                System.out.println("  __");
                System.out.println(" /|||\\`.__");
                System.out.println("(   _    _ _\\");
                System.out.println("=`-()--()-'");
                System.out.println("     o  o");
                System.out.println("--------------------");
                System.out.println("DESEA VOLVER AL MENU PRINCIPAL?? (SI/NO)");
                menus=entrega.nextLine();
                if (menus.equals("si")||menus.equals("SI")){
                    System.out.println("menu");
                }else {
                    System.out.println("GRACIAS POR SU COMPRA, ESPARAMOS QUE LO DISFRUTE");
                    System.out.println("GRACIAS POR VISITAR LA PAGINA DE KFC");
                }
                break;
            } else if (contra.equals("no")||contra.equals("NO")) {
                System.out.println("Ha cancelado la opción de pago contra entrega.");
                System.out.println("¿DESEA CAMBIAR DE MÉTODO DE PAGO? (SI/NO)");
                respuesta = entrega.nextLine();
                if (respuesta.equals("si")||respuesta.equals("SI")) {
                    metodo_de_pago();
                } else if (respuesta.equals("no")||respuesta.equals("NO")) {
                    System.out.println("SU PEDIDO SE A CANCELADO");
                    System.out.println("DESEA VOLVER AL MENU PRINCIPAL?? (SI/NO)");
                    menu=entrega.nextLine();
                    if (menu.equals("si")||menu.equals("SI")) {
                        System.out.println("MENU");
                    }else {
                        System.out.println("GRACIAS POR VISITAR LA PAGINA DE KFC");
                    }
                }
            }
        }
    }
    public static String[] usuarios = registro_de_usuarios.toArray(new String[0]);
    public static void pagina_principal() {
        Scanner wali = new Scanner(System.in);
        String direccion, op;
        String correo_valido, contraseña_valida;
        String registro, contraeña, respuesta;
        System.out.println(
                "⣿⣿⣿⣿⣿⣿⣿⡿⢟⣋⣭⣥⣭⣭⣍⡉⠉⠙⠛⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⣿⣿⡏⠁⠠⠶⠛⠻⠿⣿⣿⣿⣿⣷⡄⠄⠄⠄⠄⠉⠻⢿⣿⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⣿⠟⠄⢀⡴⢊⣴⣶⣶⣾⣿⣿⣿⣿⢿⡄⠄⠄⠄⠄⠄⠄⠙⢿⣿⣿⣿\n" +
                        "⣿⣿⡿⠁⠄⠙⡟⠁⣾⣿⣿⣿⣿⣿⣿⣿⣿⣎⠃⠄⠄⠄⠄⠄⠄⠄⠈⢻⣿⣿\n" +
                        "⣿⡟⠄⠄⠄⠄⡇⠰⠟⠛⠛⠿⠿⠟⢋⢉⠍⢩⣠⡀⠄⠄⠄⠄⠄⠄⠄⠄⢹⣿\n" +
                        "⣿⠁⠄⠄⠄⠄⠰⠁⣑⣬⣤⡀⣾⣦⣶⣾⣖⣼⣿⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⢿\n" +
                        "⡏⠄⠄⠄⠄⠄⠄⠄⠨⣿⠟⠰⠻⠿⣣⡙⠿⣿⠋⠄⢀⡀⣀⠄⣀⣀⢀⣀⣀⢸\n" +
                        "⡇⠄⠄⠄⠄⠄⠄⠄⠄⣠⠄⠚⠛⠉⠭⣉⢁⣿⠄⢀⡿⢾⣅⢸⡗⠂⢿⣀⡀⢸\n" +
                        "⡇⠄⠄⠄⠄⠄⠄⠄⠄⠘⢧⣄⠄⣻⣿⣿⣾⠟⣀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸\n" +
                        "⣿⠄⠄⠄⠄⠄⠄⠄⠄⢠⡀⠄⠄⣿⣿⠟⢁⣴⣿⢸⡄⠄⢦⣤⣤⣤⣤⣄⡀⣼\n" +
                        "⣿⣧⠄⠄⠄⠄⠄⠄⢠⡸⣿⠒⠄⠈⠛⠄⠁⢹⡟⣾⡇⠄⠈⢿⣿⣿⣿⣿⣿⣿\n" +
                        "⣿⣿⣧⣠⣴⣦⠄⠄⢸⣷⡹⣧⣖⡔⠄⠱⣮⣻⣷⣿⣿⠄⠄⠘⣿⣿⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⣿⣿⡇⠄⠄⠸⠿⠿⠚⠛⠁⠂⠄⠉⠉⡅⢰⡆⢰⡄⠄⠘ ⣿⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⣿⣿⣷⣤⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣿⠄⣷⠘⣧⣠⣾⣿⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣤⣄⣀⣀⡀⠄⣀⣀⣹⣦⣽⣾⣿⣿⣿⣿⣿⣿⣿⣿\n");

        String opcion;
        if (!registrarse) {
            System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│ 1.- MENU                │ 2.- PROMOS                │ 3.- ENCUENTRA TU KFC                │ 4.- EMPIECE A ORDENAR (REGISTRARSE/INICIE SESION)                │");
            System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
            opcion = wali.nextLine();
            switch (opcion){
                case "1":
                    System.out.println("MENUS: ");
                    for (String MENU : menuprincipal) {
                        System.out.println(MENU);
                    }
                    iniciar_sesion();
                    break;
                case "2":
                    System.out.println("MENU PROMOCIONES: ");
                    for (String[] fila : menu_promociones) {
                        System.out.printf("%-50s%-50s%n", fila[0], fila[1]);
                    }
                    iniciar_sesion();
                    break;
                case "3":
                    System.out.println("INGRESE SU DIRRECCION:");
                    direccion = wali.nextLine().trim();
                    while (direccion.length() <= 8) {
                        System.out.println("por favor, ingrese valida");
                        direccion = wali.nextLine().trim();
                    }
                    System.out.println("DIRECCION GUARDADA CON ¡EXITO!: " + direccion);
                    direccion_selecioanda = direccion;
                    System.out.println("SU KFC MAS SERCANO ESTA UBICADO EN; " + direccion_de_kfc);
                    System.out.println("HORACRIO DE ATENCION;");
                    System.out.println("LUNES A SABADO DE; 8:00 AM - 9:00 PM");
                    System.out.println("LOS DOMINGOS; 9:00 AM - 11:00 PM");
                    System.out.println("────────────────────────────────");
                    System.out.println("QUIERE EMPEZAR A ORDENAR?:");
                    System.out.println("────────────────────────────────");
                    op = wali.nextLine();
                    if (op.equalsIgnoreCase("si")) {
                        pagina_principal();
                    } else {
                        System.out.println("TAMBIEN PUEDE ORDENAR DE MANERA PRESENCIAL EN NUESTRO LOCAL");
                        System.out.println("¡LE ESPERAMOS!");
                    }
                    break;
            }
        } else {
            String[] usuarios = registro_de_usuarios.toArray(new String[0]);
            System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│ 1.- MENU                │ 2.- PROMOS                │ 3.- ENCUENTRA TU KFC                │ 4.- CUENTA:" + "(" + usuarios[0] + ")" + "     │");
            System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
            opcion = wali.nextLine();
            switch (opcion) {
                case "3":
                    System.out.println("INGRESE SU DIRRECCION:");
                    direccion = wali.nextLine().trim();
                    while (direccion.length() <= 8) {
                        System.out.println("por favor, ingrese valida");
                        direccion = wali.nextLine().trim();
                    }
                    System.out.println("DIRECCION GUARDADA CON ¡EXITO!: " + direccion);
                    direccion_selecioanda = direccion;
                    System.out.println("SU KFC MAS SERCANO ESTA UBICADO EN; " + direccion_de_kfc);
                    System.out.println("HORACRIO DE ATENCION;");
                    System.out.println("LUNES A SABADO DE; 8:00 AM - 9:00 PM");
                    System.out.println("LOS DOMINGOS; 9:00 AM - 11:00 PM");
                    System.out.println("────────────────────────────────");
                    System.out.println("QUIERE EMPEZAR A ORDENAR?:");
                    System.out.println("────────────────────────────────");
                    op = wali.nextLine();
                    if (op.equalsIgnoreCase("si")) {
                        pagina_principal();
                    } else {
                        System.out.println("TAMBIEN PUEDE ORDENAR DE MANERA PRESENCIAL EN NUESTRO LOCAL");
                        System.out.println("¡LE ESPERAMOS!");
                    }
                    break;
                case "4":
                    if (registrarse) {
                        String[] contraseñas = registro_de_contraseñas.toArray(new String[0]);
                        System.out.println("INFORMACIÓN DE LA CUENTA:");
                        System.out.println("Correo electrónico: " + usuarios[0]);
                        System.out.println("Dirección: " + direccion_selecioanda);
                        System.out.println("1.- volver a la pagina principal");
                        System.out.println("2.-¿Desea cerrar sesión? (si/no)");
                        op = wali.nextLine();
                        switch (op) {
                            case "1":
                                pagina_principal();
                                break;
                            case "2":
                                System.out.println("su sesion se ha cerrado!");
                                System.out.println("para poder seguir ordenando, vuleva la menu principal");
                                System.out.println("deseaa: ...");
                                System.out.println("1.- volver al menu principal");
                                System.out.println("2.- salir de la pagina");
                                registrarse = false;
                                op = wali.nextLine();
                                switch (op) {
                                    case "1":
                                        pagina_principal();
                                        break;
                                    case "2":
                                        System.out.println("GRACIAS POR VISITAR LA PAGINA DE KFC");
                                        System.out.println("VUELVA PRONTO");
                                        break;
                                }
                                break;
                        }
                        break;
                    }

            }
        }
        opcion = wali.nextLine();
        switch (opcion) {
            case "3":
                System.out.println("INGRESE SU DIRRECCION:");
                direccion = wali.nextLine().trim();
                while (direccion.length() <= 8) {
                    System.out.println("por favor, ingrese valida");
                    direccion = wali.nextLine().trim();
                }
                System.out.println("DIRECCION GUARDADA CON ¡EXITO!: " + direccion);
                direccion_selecioanda = direccion;
                System.out.println("SU KFC MAS SERCANO ESTA UBICADO EN; " + direccion_de_kfc);
                System.out.println("HORACRIO DE ATENCION;");
                System.out.println("LUNES A SABADO DE; 8:00 AM - 9:00 PM");
                System.out.println("LOS DOMINGOS; 9:00 AM - 11:00 PM");
                System.out.println("────────────────────────────────");
                System.out.println("QUIERE EMPEZAR A ORDENAR?: (si/no)");
                System.out.println("────────────────────────────────");
                op = wali.nextLine();
                if (op.equalsIgnoreCase("si")) {
                    pagina_principal();
                } else {
                    System.out.println("TAMBIEN PUEDE ORDENAR DE MANERA PRESENCIAL EN NUESTRO LOCAL");
                    System.out.println("¡LE ESPERAMOS!");
                }
                break;
            case "4":
                System.out.println("1.- REGISTRARSE");
                System.out.println("2.- INICIAR SESION");
                op = wali.nextLine();
                switch (op) {
                    case "1":
                        if (!registrarse) {
                            System.out.println("REGISTRO:");
                            System.out.println("registre su correo electronico:");
                            registro = wali.nextLine();
                            while (!registro.contains("@gmail.com")) {
                                System.out.println("Correo electrónico inválido, por favor vuelva a intentar :).");
                                registro = wali.nextLine();
                            }
                            registro_de_usuarios.add(registro);
                            System.out.println("cree su contraeña:");
                            contraeña = wali.nextLine();
                            registro_de_contraseñas.add(contraeña);
                            String[] usuarios = registro_de_usuarios.toArray(new String[0]);
                            String[] contraseñas = registro_de_contraseñas.toArray(new String[0]);
                            System.out.println("INICIAR SESIÓN:");
                            do {
                                System.out.println("Ingrese su correo electrónico");
                                correo_valido = wali.nextLine();
                                System.out.println("Ingrese su contraseña: ");
                                contraseña_valida = wali.nextLine();
                                for (int i = 0; i < registro_de_usuarios.size(); i++) {
                                    if (correo_valido.equals(registro_de_usuarios.get(i)) && contraseña_valida.equals(registro_de_contraseñas.get(i))) {
                                        System.out.println("Inicio de sesión, ¡EXITOSO!");
                                        registrarse = true;
                                        inicio_sesion = true;
                                        break;
                                    }
                                }
                                if (!inicio_sesion) {
                                    System.out.println("Inicio de sesión, ¡FALLIDO!");
                                    System.out.println("Correo o contraseña incorrecta.");
                                }
                            } while (!registrarse);
                            System.out.println("INGRESE SU DIRRECCION:");
                            direccion = wali.nextLine().trim();
                            while (direccion.length() <= 8) {
                                System.out.println("por favor, ingrese valida");
                                direccion = wali.nextLine().trim();
                            }
                            System.out.println("DIRECCION GUARDADA CON ¡EXITO!: " + direccion);
                            direccion_selecioanda = direccion;
                            menu_principal();
                            break;
                        }
                    case "2":
                        String[] usuarios = registro_de_usuarios.toArray(new String[0]);
                        String[] contraseñas = registro_de_contraseñas.toArray(new String[0]);
                        System.out.println("INICIAR SESIÓN:");
                        System.out.println("ingrese su correo:");
                        correo_valido = wali.nextLine();
                        System.out.println("ingrese su contraseña:");
                        contraseña_valida = wali.nextLine();
                        for (int i = 0; i < usuarios.length; i++) {
                            if (correo_valido.equals(usuarios[i]) && contraseña_valida.equals(contraseñas[i])) {
                                System.out.println("Inicio de sesión, ¡EXITOSO!");
                                registrarse = true;
                            }
                        }
                        menu_principal();
                        break;
                }
                break;
        }
    }
    public static void factura (List<String> menu_seleccionados, List<Integer> cantidades_menu_seleccionados, List<Double> precios_menu_selecionados, List<String> promociones_selecionadas, List<Integer> cantidades_promociones_seleccionados, List<Double> precios_promociones_selecionadas, boolean metodo_entrega, String metodo_de_pago_seleccioando) {
        Scanner wali = new Scanner(System.in);
        String volver;
        double subtotal = 0.0;
        for (int i = 0; i < menu_seleccionados.size(); i++) {
            subtotal += precios_menu_selecionados.get(i) * cantidades_menu_seleccionados.get(i);
        }
        for (int i = 0; i < promociones_selecionadas.size(); i++) {
            subtotal += precios_promociones_selecionadas.get(i) * cantidades_promociones_seleccionados.get(i);
        }
        for (int i = 0; i < complementos_seleccionados.size(); i++) {
            subtotal += precios_complementos_seleccionados.get(i);
        }
        double igv = subtotal * 0.18;
        double delivery = metodo_entrega ? 10 : 0;
        double total_factura = subtotal + igv + delivery;
        System.out.println("╔══════════════════════════════════════════════════════════════════════════╗");
        System.out.println(
                "           "+ "⣿⣿⣿⣿⣿⣿⣿⡿⢟⣋⣭⣥⣭⣭⣍⡉⠉⠙⠛⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                        "            "+ "⣿⣿⣿⣿⣿⡏⠁⠠⠶⠛⠻⠿⣿⣿⣿⣿⣷⡄⠄⠄⠄⠄⠉⠻⢿⣿⣿⣿⣿⣿\n" +
                        "            "+ "⣿⣿⣿⣿⠟⠄⢀⡴⢊⣴⣶⣶⣾⣿⣿⣿⣿⢿⡄⠄⠄⠄⠄⠄⠄⠙⢿⣿⣿⣿\n" +
                        "            "+ "⣿⣿⡿⠁⠄⠙⡟⠁⣾⣿⣿⣿⣿⣿⣿⣿⣿⣎⠃⠄⠄⠄⠄⠄⠄⠄⠈⢻⣿⣿\n" +
                        "            "+ "⣿⡟⠄⠄⠄⠄⡇⠰⠟⠛⠛⠿⠿⠟⢋⢉⠍⢩⣠⡀⠄⠄⠄⠄⠄⠄⠄⠄⢹⣿\n" +
                        "            "+ "⣿⠁⠄⠄⠄⠄⠰⠁⣑⣬⣤⡀⣾⣦⣶⣾⣖⣼⣿⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⢿\n" +
                        "            "+ "⡏⠄⠄⠄⠄⠄⠄⠄⠨⣿⠟⠰⠻⠿⣣⡙⠿⣿⠋⠄⢀⡀⣀⠄⣀⣀⢀⣀⣀⢸\n" +
                        "            "+ "⡇⠄⠄⠄⠄⠄⠄⠄⠄⣠⠄⠚⠛⠉⠭⣉⢁⣿⠄⢀⡿⢾⣅⢸⡗⠂⢿⣀⡀⢸\n" +
                        "            "+ "⡇⠄⠄⠄⠄⠄⠄⠄⠄⠘⢧⣄⠄⣻⣿⣿⣾⠟⣀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸\n" +
                        "            "+ "⣿⠄⠄⠄⠄⠄⠄⠄⠄⢠⡀⠄⠄⣿⣿⠟⢁⣴⣿⢸⡄⠄⢦⣤⣤⣤⣤⣄⡀⣼\n" +
                        "            "+ "⣿⣧⠄⠄⠄⠄⠄⠄⢠⡸⣿⠒⠄⠈⠛⠄⠁⢹⡟⣾⡇⠄⠈⢿⣿⣿⣿⣿⣿⣿\n" +
                        "            "+ "⣿⣿⣧⣠⣴⣦⠄⠄⢸⣷⡹⣧⣖⡔⠄⠱⣮⣻⣷⣿⣿⠄⠄⠘⣿⣿⣿⣿⣿⣿\n" +
                        "            "+ "⣿⣿⣿⣿⣿⡇⠄⠄⠸⠿⠿⠚⠛⠁⠂⠄⠉⠉⡅⢰⡆⢰⡄⠄⠘ ⣿⣿⣿⣿\n" +
                        "            "+ "⣿⣿⣿⣿⣿⣷⣤⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣿⠄⣷⠘⣧⣠⣾⣿⣿⣿⣿⣿\n" +
                        "            "+ "⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣤⣄⣀⣀⡀⠄⣀⣀⣹⣦⣽⣾⣿⣿⣿⣿⣿⣿⣿⣿");
        System.out.println("║                                                              ");
        System.out.println("║                      KFC JR. San Martin, Juliaca 21103       ");
        System.out.println("║                                                              ");
        System.out.println("║                          PEDIDO  :666                        ");
        System.out.println("║                                                              ");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════");
        System.out.println("║                                                              ");
        System.out.println("║   Recepción: SAIT                                 10/07/2024 ");
        System.out.println("║   PEDIDO: 666                                                 ");
        System.out.println("║                                                              ");
        System.out.println("║──────────────────────────────────────────────────────────────────────────");
        System.out.println("║   Método de entrega: " + (metodo_entrega ? "Delivery" : "Recojo en tienda"));
        System.out.println("║──────────────────────────────────────────────────────────────────────────");
        System.out.println("║                                                              ");
        System.out.println("║   Comunicado                                                  ");
        System.out.println("║   Recuerda guardar la factura para la entrega/recoger su pedido :)");
        System.out.println("║                                                              ");
        System.out.println("║──────────────────────────────────────────────────────────────────────────");
        for (int i = 0; i < menu_seleccionados.size(); i++) {
            System.out.println("║   Menu: " + menu_seleccionados.get(i));
            System.out.println("║   Cantidad de producto: " + cantidades_menu_seleccionados.get(i));
            System.out.println("║   Precio total de menu: S/" + (precios_menu_selecionados.get(i) * cantidades_menu_seleccionados.get(i)));
            System.out.println("║──────────────────────────────────────────────────────────────────────────");
        }
        for (int i = 0; i < promociones_selecionadas.size(); i++) {
            System.out.println("║   Promoción: " + promociones_selecionadas.get(i));
            System.out.println("║   Cantidad de producto: " + cantidades_promociones_seleccionados.get(i));
            System.out.println("║   Precio total de promoción: S/" + (precios_promociones_selecionadas.get(i) * cantidades_promociones_seleccionados.get(i)));
            System.out.println("║──────────────────────────────────────────────────────────────────────────");
        }
        for (int i = 0; i < complementos_seleccionados.size(); i++) {
            System.out.println("║   Complemento: " + complementos_seleccionados.get(i));
            System.out.println("║   Precio del complemento: S/" + precios_complementos_seleccionados.get(i));
            System.out.println("║──────────────────────────────────────────────────────────────────────────");
        }
        System.out.println("║                                                              ");
        System.out.println("║   Sub-total:                                     " + subtotal + " soles");
        System.out.println("║   IGV (18%):                                     " + igv + " soles");
        System.out.println("║   Delivery:                                      " + delivery + " soles");
        System.out.println("║                                                              ");
        System.out.println("║   Total:                                         " + total_factura + " soles");
        System.out.println("║--------------------------------------------------------------");
        System.out.println("║   Medio de pago:                                 " + metodo_de_pago_seleccioando+(tipo_de_tarjeta? "VISA":"MASTERCARD"));
        System.out.println("║--------------------------------------------------------------");
        System.out.println("║                                                              ");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════╝");
        System.out.println("desea  exportar su factura?");
        String exportar = wali.nextLine();
        if (exportar.equalsIgnoreCase("si"))
            exportar_factura(menu_seleccionados, cantidades_menu_seleccionados, precios_menu_selecionados, promociones_selecionadas, cantidades_promociones_seleccionados, precios_promociones_selecionadas, metodo_entrega, metodo_de_pago_seleccioando);
        System.out.println("DESEA VOLVER AL MENU PRINCIPAL?? (SI/NO)");
        volver = wali.nextLine();
        if (volver.equals("si") || volver.equals("SI")) {
            pagina_principal();
        } else {
            System.out.println("Gracias por ser cliente de KFC");
            System.out.println("Esperamos que disfrute su compra :) ");
        }
    }
    public static String exportar_factura(List<String> menu_seleccionados, List<Integer> cantidades_menu_seleccionados, List<Double> precios_menu_selecionados, List<String> promociones_selecionadas, List<Integer> cantidades_promociones_seleccionados, List<Double> precios_promociones_selecionadas, boolean metodo_entrega, String metodo_de_pago_seleccioando){
        double subtotal = 0.0;
        for (int i = 0; i < menu_seleccionados.size(); i++) {
            subtotal += precios_menu_selecionados.get(i) * cantidades_menu_seleccionados.get(i);
        }
        for (int i = 0; i < promociones_selecionadas.size(); i++) {
            subtotal += precios_promociones_selecionadas.get(i) * cantidades_promociones_seleccionados.get(i);
        }
        for (int i = 0; i < complementos_seleccionados.size(); i++) {
            subtotal += precios_complementos_seleccionados.get(i);
        }
        double igv = subtotal * 0.18;
        double delivery = metodo_entrega ? 10 : 0;
        double total_factura = subtotal + igv + delivery;
        try{
            File archivo = new File("F:\\\\Facturas\\\\factura.txt");
            FileWriter escritor=new FileWriter(archivo);
            escritor.write(
                    "           "+ "⣿⣿⣿⣿⣿⣿⣿⡿⢟⣋⣭⣥⣭⣭⣍⡉⠉⠙⠛⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                            "            "+ "⣿⣿⣿⣿⣿⡏⠁⠠⠶⠛⠻⠿⣿⣿⣿⣿⣷⡄⠄⠄⠄⠄⠉⠻⢿⣿⣿⣿⣿⣿\n" +
                            "            "+ "⣿⣿⣿⣿⠟⠄⢀⡴⢊⣴⣶⣶⣾⣿⣿⣿⣿⢿⡄⠄⠄⠄⠄⠄⠄⠙⢿⣿⣿⣿\n" +
                            "            "+ "⣿⣿⡿⠁⠄⠙⡟⠁⣾⣿⣿⣿⣿⣿⣿⣿⣿⣎⠃⠄⠄⠄⠄⠄⠄⠄⠈⢻⣿⣿\n" +
                            "            "+ "⣿⡟⠄⠄⠄⠄⡇⠰⠟⠛⠛⠿⠿⠟⢋⢉⠍⢩⣠⡀⠄⠄⠄⠄⠄⠄⠄⠄⢹⣿\n" +
                            "            "+ "⣿⠁⠄⠄⠄⠄⠰⠁⣑⣬⣤⡀⣾⣦⣶⣾⣖⣼⣿⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⢿\n" +
                            "            "+ "⡏⠄⠄⠄⠄⠄⠄⠄⠨⣿⠟⠰⠻⠿⣣⡙⠿⣿⠋⠄⢀⡀⣀⠄⣀⣀⢀⣀⣀⢸\n" +
                            "            "+ "⡇⠄⠄⠄⠄⠄⠄⠄⠄⣠⠄⠚⠛⠉⠭⣉⢁⣿⠄⢀⡿⢾⣅⢸⡗⠂⢿⣀⡀⢸\n" +
                            "            "+ "⡇⠄⠄⠄⠄⠄⠄⠄⠄⠘⢧⣄⠄⣻⣿⣿⣾⠟⣀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸\n" +
                            "            "+ "⣿⠄⠄⠄⠄⠄⠄⠄⠄⢠⡀⠄⠄⣿⣿⠟⢁⣴⣿⢸⡄⠄⢦⣤⣤⣤⣤⣄⡀⣼\n" +
                            "            "+ "⣿⣧⠄⠄⠄⠄⠄⠄⢠⡸⣿⠒⠄⠈⠛⠄⠁⢹⡟⣾⡇⠄⠈⢿⣿⣿⣿⣿⣿⣿\n" +
                            "            "+ "⣿⣿⣧⣠⣴⣦⠄⠄⢸⣷⡹⣧⣖⡔⠄⠱⣮⣻⣷⣿⣿⠄⠄⠘⣿⣿⣿⣿⣿⣿\n" +
                            "            "+ "⣿⣿⣿⣿⣿⡇⠄⠄⠸⠿⠿⠚⠛⠁⠂⠄⠉⠉⡅⢰⡆⢰⡄⠄⠘ ⣿⣿⣿⣿\n" +
                            "            "+ "⣿⣿⣿⣿⣿⣷⣤⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣿⠄⣷⠘⣧⣠⣾⣿⣿⣿⣿⣿\n" +
                            "            "+ "⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣤⣄⣀⣀⡀⠄⣀⣀⣹⣦⣽⣾⣿⣿⣿⣿⣿⣿⣿⣿\n");
            escritor.write("╔══════════════════════════════════════════════════════════════════════════╗\n");
            escritor.write("║                                                              \n");
            escritor.write("║                      KFC JR. San Martin, Juliaca 21103       \n");
            escritor.write("║                                                              \n");
            escritor.write("║                          PEDIDO  :666                        \n");
            escritor.write("║                                                              \n");
            escritor.write("╠═══════════════════════════════════════════════════════════════════════════\n");
            escritor.write("║                                                              \n");
            escritor.write("║   Recepción: SAIT"+"                                    "+"10/07/2024 \n");
            escritor.write("║   PEDIDO: 666                                                 \n");
            escritor.write("║                                                              \n");
            escritor.write("║──────────────────────────────────────────────────────────────────────────\n");
            escritor.write("║   Método de entrega:"+"                                 "+ (metodo_entrega ? "Delivery" : "Recojo en tienda") + "\n");
            escritor.write("║──────────────────────────────────────────────────────────────────────────\n");
            escritor.write("║                                                              \n");
            escritor.write("║   Comunicado                                                  \n");
            escritor.write("║   Recuerda guardar la factura para la entrega/recoger su pedido :)\n");
            escritor.write("║                                                              \n");
            escritor.write("║──────────────────────────────────────────────────────────────────────────\n");
            for (int i = 0; i < menu_seleccionados.size(); i++) {
                String selecionnn = menu_seleccionados.get(i).split("\\.")[1];
                escritor.write("║   Menu: " + selecionnn + "\n");
                escritor.write("║------------------------------------------------------------------------\n");
                escritor.write("║   Cantidad de producto: " + cantidades_menu_seleccionados.get(i) + "\n");
                escritor.write("║   Precio total de menu: S/" + (precios_menu_selecionados.get(i) * cantidades_menu_seleccionados.get(i)) + "\n");
                escritor.write("║──────────────────────────────────────────────────────────────────────────\n");
            }
            for (int i = 0; i < promociones_selecionadas.size(); i++) {
                String selecionn = promociones_selecionadas.get(i).split("\\.")[1];
                escritor.write("║   Promoción: " + selecionn+ "\n");
                escritor.write("║------------------------------------------------------------------------\n");
                escritor.write("║   Cantidad de producto: " + cantidades_promociones_seleccionados.get(i) + "\n");
                escritor.write("║   Precio total de promoción: S/" + (precios_promociones_selecionadas.get(i) * cantidades_promociones_seleccionados.get(i)) + "\n");
                escritor.write("║──────────────────────────────────────────────────────────────────────────\n");
            }
            for (int i = 0; i < complementos_seleccionados.size(); i++) {
                String selecion = complementos_seleccionados.get(i).split("\\.")[1];
                escritor.write("║   Complemento: " + selecion + "\n");
                escritor.write("║   Precio del complemento: S/" + precios_complementos_seleccionados.get(i) + "\n");
                escritor.write("║──────────────────────────────────────────────────────────────────────────\n");
            }
            escritor.write("║                                                              \n");
            escritor.write("║   Sub-total:    "+"                                     "+ subtotal + " soles\n");
            escritor.write("║   IGV (18%):    "+"                                     "+ igv + " soles\n");
            escritor.write("║   Delivery:     "+"                                     "+ delivery + " soles\n");
            escritor.write("║                                                              \n");
            escritor.write("║   Total:        "+"                                     "+ total_factura + " soles\n");
            escritor.write("║------------------------------------------------------------------------\n");
            escritor.write("║   Medio de pago:"+"                                     "+ metodo_de_pago_seleccioando+ "\n");
            escritor.write("║------------------------------------------------------------------------\n");
            escritor.write("║                                                              \n");
            escritor.write("╚══════════════════════════════════════════════════════════════════════════╝\n");
            escritor.close();
            System.out.println("La factura ha sido exportada exitosamente!");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al exportar la factura.");
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Empresa_KFC_OFICIAL WALI = new Empresa_KFC_OFICIAL();
        pagina_principal();
    }
}