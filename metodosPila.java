import java.util.Stack;
import javax.swing.JOptionPane;

/*Daviv Rueda y Francisco Taborda */

public class metodosPila {

    public void LlenarPila() {

        Stack<Usuario> pila = new Stack<>();
        boolean continuar = true;
        String agregar = "";
        while (continuar) {

            Usuario o = new Usuario();

            o.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del usuario: "));
            o.setTipoCred(ValidarTipoCred());
            o.setMontoCred(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto del credito: ")));
            pila.push(o);

            agregar = JOptionPane.showInputDialog("Desea agregar mas Registros Si/No");

            if (agregar.equalsIgnoreCase("No")) {

                continuar = false;

            }

        }

        MostrarPila(pila);

        int opt = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1: consultar // 2: eliminar // 3 modificar // 4: vender creditos // 5: salir del programa"));
        
        if (opt != 5) {

            do {
            
                pila = AccionesRegistro(pila, opt);

                opt = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1: consultar // 2: eliminar // 3: modificar // 4: vender creditos // 5: salir del programa"));
    
            }

            while(opt != 5);

        }

        System.out.println("Programa finalizado");
        MostrarPila(pila);
        
    }

    public void MostrarPila(Stack<Usuario> pila) {

        for (Usuario o : pila) {

            System.out.println("Nombre del usuario: " + o.getNombre());
            System.out.println("Tipo del credito: " + o.getTipoCred());
            System.out.println("Monto del credito: " + o.getMontoCred());
            System.out.println();

        }

    }

    public Stack<Usuario> AccionesRegistro(Stack<Usuario> pila, int opt) {

        String dato = "";
        int existe = 0;

        if (opt == 1) {

            dato = JOptionPane.showInputDialog("Ingrese el usuario del credito a consultar: ");

        }
        
        else if (opt == 2) {

            dato = JOptionPane.showInputDialog("Ingrese el usuario del credito que desea eliminar:");

        }
        
        else if (opt == 3) {

            dato = JOptionPane.showInputDialog("Ingrese el usuario del credito que desea Modificar: ");

        }

        else {

            dato = JOptionPane.showInputDialog("Ingrese el usuario del credito que desea vender: "); 

        }


        for (Usuario Usuario : pila) {

            if (Usuario.getNombre().equalsIgnoreCase(dato)) {

                existe = 1;

                if (opt == 1) {

                    System.out.println("El registro se encuentras y es: \nUsuario: " + Usuario.getNombre() + "\nTipo del credito: " + Usuario.getTipoCred() + "\nMonto del credito: " + Usuario.getMontoCred());

                }
                
                else if (opt == 2) {

                    pila.remove(Usuario);

                    MostrarPila(pila);

                }

                else if (opt == 3) {

                    Usuario.setTipoCred(ValidarTipoCred());

                    MostrarPila(pila);

                }

                else {

                    Double cantidadV = 0.0, nuevaK = 0.0;
                    String respuesta = "";
                    boolean validar = false;

                    do {

                        System.out.println("Usuario: " + Usuario.getNombre() + "\nTipo del credito: " + Usuario.getTipoCred() + "\nMonto del credito: " + Usuario.getMontoCred());

                        validar = Validador(Usuario.getTipoCred());

                        if (validar) {

                            cantidadV = Double.parseDouble(JOptionPane.showInputDialog("\nIngrese la cantidad de creditos a vender: "));

                            nuevaK = Usuario.getMontoCred() + cantidadV;

                            respuesta = JOptionPane.showInputDialog("Recibo de venta\nUsuario: " + Usuario.getNombre() + "\nTipo del credito: " + Usuario.getTipoCred() + "\nNuevo monto del credito: " + nuevaK + "\n¿Desea proseguir?(Si-No): ");

                            if (respuesta.equalsIgnoreCase("si")) {
                                
                                Usuario.setMontoCred(nuevaK);

                                System.out.println("Se ha vendido con exito " + cantidadV + " de creditos del usuario " + Usuario.getNombre() + "\nEl usuario ahora debe un total de: " + Usuario.getMontoCred());

                            }

                        }
                    
                    }

                    while (respuesta.equalsIgnoreCase("no"));
                        
                }

            }

        }

        if (existe == 0){

            Usuario o = new Usuario();

            System.out.println("Usuario no encontrado, prosiga con un nuevo registro");
            o.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del usuario: "));
            o.setTipoCred(ValidarTipoCred());
            o.setMontoCred(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto del credito: ")));
            pila.push(o);

            MostrarPila(pila);

            int opt2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1: consultar // 2: eliminar // 3 modificar // 4 salir del programa"));
            
            if (opt2 != 5) {

                do {
                
                    pila = AccionesRegistro(pila, opt2);
                    MostrarPila(pila);

                    opt2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1: consultar // 2: eliminar // 3 modificar // 4 salir del programa"));
        
                }

                while(opt2 != 5);

            }
        
        }

        return pila;

    }

    private static String ValidarTipoCred() {
            
        int Tipo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de credito(1:Consumo // 2: Comercial // 3: Hipotecario): "));
    
        if (Tipo == 1) {

            return "Consumo";

        }

        else if (Tipo == 2) {

            return "Comercial";

        }
                
        else if (Tipo == 3) {
            
            return "hipotecario";
        
        }
        
        else {

            System.out.println("Tipo de credito no valido(1:Consumo // 2: Comercial // 3: Hipotecario");

            return ValidarTipoCred();

        }

    }

    private static boolean Validador(String TipoCredito){

        String Tipo = ValidarTipoCred();

        if (TipoCredito.equalsIgnoreCase(Tipo)) {

            return true;

        }

        else{

            System.out.println("El tipo de credito no es igual");

            return Validador(TipoCredito);

        }

    }
}