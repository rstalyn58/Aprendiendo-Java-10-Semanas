package semana-02-gestor-tareas.util;

package util;

public class Validador {

    public static boolean textoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

         public static boolean numeroPositivo(int num) {
                 return num > 0;
    }

             public static boolean numeroNoNegativo(int num) {
                return num >= 0;
    }
}