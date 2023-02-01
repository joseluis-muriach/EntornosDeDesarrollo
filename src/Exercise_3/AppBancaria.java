package Exercise_3;

import java.util.Scanner;

public class AppBancaria {

    private static final Banco banco = new Banco();
    private static final Scanner inputValue = new Scanner(System.in);

    public static void main(String[] args) {

        introducirCodigoBanco();

        introducirCodigoSucursal();

        introducirNumeroCuenta();

        introducirClavePersonal();

        introducirOrden();
    }

    private static void introducirCodigoBanco() {

        String codBanc = "";
        System.out.println("Bienvenido a su app de confianza");

        boolean codigoValido = false;
        do {
            System.out.println("Por favor, introduzca el código de su banco");
            System.out.print("--> ");
            try {
                codBanc = inputValue.nextLine();
                codigoValido = validarCodigoBanco(codBanc);
            } catch (NumberFormatException e) {
            }

            if (codigoValido) {
                banco.setCodigo(codBanc);
            } else {
                System.out.println("El codigo que ha introducido no es valido");
            }
        } while (!codigoValido);
    }

    private static void introducirCodigoSucursal() {
        String codSucursal = "";
        boolean codValidoSucursal = false;
        do {
            System.out.println("Por favor, introduzca el código de la sucursal");
            System.out.print("--> ");
            try {
                codSucursal = inputValue.nextLine();
                codValidoSucursal = validarCodigoSucursal(codSucursal);
            } catch (NumberFormatException e) {
                System.out.println("El valor que ha introducido no es valido");
            }

            if (codValidoSucursal) {
                banco.setSucursal(codSucursal);
            } else {
                System.out.println("El codigo que ha introducido no es correcto!");
            }
        } while (!codValidoSucursal);
    }

    private static void introducirNumeroCuenta() {
        String numeroCuenta = "";
        boolean numeroCuentaValido = false;
        do {
            System.out.println("Por favor, introduzca el número de su cuenta");
            System.out.print("--> ");
            try {
                numeroCuenta = inputValue.nextLine();
                numeroCuentaValido = validarNumeroCuenta(numeroCuenta);
            } catch (NumberFormatException e) {
            }

            if (numeroCuentaValido) {
                banco.setNumCuenta(numeroCuenta);
            } else {
                System.out.println("El número que ha introducido no es correcto!");
            }

        } while (!numeroCuentaValido);
    }

    private static void introducirClavePersonal() {
        String clavePersonal = "";
        boolean clavePersonalValida = false;
        do {
            System.out.println("Por favor, introduzca su clave personal");
            System.out.print("--> ");
            clavePersonal = inputValue.nextLine();
            clavePersonalValida = validarClavePersonal(clavePersonal);

            if (clavePersonalValida) {
                banco.setClavePersonal(clavePersonal);
            } else {
                System.out.println("La clave que ha introducido no es correcto!");
            }

        } while (!clavePersonalValida);
    }

    private static void introducirOrden() {
        String orden = "";
        boolean ordenValida = false;
        do {
            System.out.println("¿Que orden desea realizar? 'Talonario' o 'Movimientos'");
            System.out.print("--> ");
            orden = inputValue.nextLine();
            ordenValida = validarOrden(orden);

            if (ordenValida) {
                switch (orden.toLowerCase()) {
                    case "talonario":
                        System.out.println("Se está imprimiendo un talonario de cheques");
                        banco.getTalonario();
                        break;

                    case "movimientos":
                        System.out.println("Se están imprimiendo sus movimientos");
                        banco.getMovimientos();
                        break;

                    default:
                        System.out.println("Se está imprimiendo el talonario y sus movimientos");
                        banco.getTalonario();
                        banco.getMovimientos();
                }

            } else {
                System.out.println("La opción que has introdudo no es correcta, por favor intentelo de nuevo");
            }

        } while (!ordenValida);
    }

    private static boolean validarCodigoBanco(String codBanc) {
        validarExit(codBanc);
        if (codBanc.equals(" ") || codBanc.isEmpty()) {
            return true;
        }
        return codBanc.length() == 3 && Integer.parseInt(codBanc.split("")[0]) > 1;
    }

    private static boolean validarCodigoSucursal(String codSucursal) {
        validarExit(codSucursal);
        return codSucursal.length() == 4 && Integer.parseInt(codSucursal.split("")[0]) > 0;
    }

    private static boolean validarNumeroCuenta(String numeroCuenta) {
        validarExit(numeroCuenta);
        return String.valueOf(numeroCuenta).length() == 5;
    }

    private static boolean validarClavePersonal(String clavePersonal) {
        validarExit(clavePersonal);
        return clavePersonal.length() == 5;
    }

    private static boolean validarOrden(String orden) {
        validarExit(orden);
        return orden.equals(" ") || orden.isEmpty() || orden.equalsIgnoreCase("Talonario")
                || orden.equalsIgnoreCase("Movimientos");
    }

    private static void validarExit(String instruccion) {
        if (instruccion.equalsIgnoreCase("exit")) {
            System.out.println("El programa se está cerrando");
            System.exit(0);
        }
    }
}
