import servicio.AgendaContactos;
import modelo.Contacto;
import excepcion.ContactoExistenteException;
import excepcion.ContactoNoEncontradoException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AgendaContactos gestor = new AgendaContactos();

        int opcion;

        do {
            System.out.println("\nAGENDA DE CONTACTOS");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (opcion) {

                    case 1:
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Telefono: ");
                        String telefono = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        gestor.agregarContacto(new Contacto(nombre, telefono, email));
                        System.out.println("Contacto agregado");
                        break;

                    case 2:
                        for (Contacto c : gestor.listarContactos()) {
                            System.out.println(c);
                        }
                        break;

                    case 3:
                        System.out.print("Nombre a buscar: ");
                        String buscar = scanner.nextLine();

                        System.out.println(gestor.buscarContacto(buscar));
                        break;

                    case 4:
                        System.out.print("Nombre a eliminar: ");
                        String eliminar = scanner.nextLine();

                        gestor.eliminarContacto(eliminar);
                        System.out.println("Contacto eliminado");
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }

            } catch (ContactoExistenteException | ContactoNoEncontradoException e) {
                System.out.println(e.getMessage());
            }

        } while (opcion != 0);

        scanner.close();
    }
}