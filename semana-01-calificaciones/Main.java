import java.util.Scanner;
import java.util.InputMismatchException;

public class Main{

    static final int ESTUDIANTES = 5;
    static final int NOTAS = 3;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[ESTUDIANTES];
        int[][] notas = new int[ESTUDIANTES][NOTAS];
        double[] promedios = new double[ESTUDIANTES];

        for (int i = 0; i < ESTUDIANTES; i++) {
            System.out.print("Nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();

            for (int j = 0; j < NOTAS; j++) {
                notas[i][j] = leerNota(sc, "Nota " + (j + 1) + ": ");
            }

            promedios[i] = calcularPromedio(notas[i]);
            System.out.println();
        }

        double promedioCurso = calcularPromedioGeneral(promedios);
        int notaMax = encontrarMaximo(notas);
        int notaMin = encontrarMinimo(notas);
        int aprobados = contarAprobados(promedios);

        mostrarResultados(nombres, promedios, promedioCurso,
                notaMax, notaMin, aprobados);
    }

    public static double calcularPromedio(int[] notas) {
        int suma = 0;
        for (int n : notas) {
            suma += n;
        }
        return (double) suma / notas.length;
    }

    public static String determinarEstado(double promedio) {
        return promedio >= 51 ? "APROBADO" : "REPROBADO";
    }

    public static int encontrarMaximo(int[][] notas) {
        int max = notas[0][0];
        for (int[] fila : notas) {
            for (int n : fila) {
                if (n > max) {
                    max = n;
                }
            }
        }
        return max;
    }

    public static int encontrarMinimo(int[][] notas) {
        int min = notas[0][0];
        for (int[] fila : notas) {
            for (int n : fila) {
                if (n < min) {
                    min = n;
                }
            }
        }
        return min;
    }

    public static int contarAprobados(double[] promedios) {
        int contador = 0;
        for (double p : promedios) {
            if (p >= 51) {
                contador++;
            }
        }
        return contador;
    }

    public static double calcularPromedioGeneral(double[] promedios) {
        double suma = 0;
        for (double p : promedios) {
            suma += p;
        }
        return suma / promedios.length;
    }

    public static void mostrarResultados(String[] nombres, double[] promedios,
                                         double promedioCurso, int max, int min,
                                         int aprobados) {

        System.out.println("===== RESULTADOS =====");
        System.out.printf("%-15s %-10s %-10s%n", "NOMBRE", "PROMEDIO", "ESTADO");

        for (int i = 0; i < nombres.length; i++) {
            System.out.printf("%-15s %-10.2f %-10s%n",
                    nombres[i],
                    promedios[i],
                    determinarEstado(promedios[i]));
        }

        System.out.println("\nPromedio general del curso: " + String.format("%.2f", promedioCurso));
        System.out.println("Nota mas alta del curso: " + max);
        System.out.println("Nota mas baja del curso: " + min);
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Reprobados: " + (nombres.length - aprobados));
    }


    public static int leerNota(Scanner sc, String mensaje) {
        int nota;
        while (true) {
            try {
                System.out.print(mensaje);
                nota = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                if (nota < 0 || nota > 100) {
                    System.out.println("La nota debe estar entre 0 y 100.");
                } else {
                    return nota;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ingrese un numero valido.");
                sc.nextLine();
            }
        }
    }
}
