/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo002;

/**
 *
 * @author reroes
 */
public class Principal1 {

    public static void main(String[] args) {

        String[] nombres = {"Jason", "Jonathan", "Kristen", "Robin", "Michelle", "Emily", "Noah", "Daniel"};
        String[] apellidos = {"Lynch", "George", "Lang", "Cochran", "Young", "Fletcher", "Adkins", "Harris"};
        int[][] notas = {{10, 80, 80, 95}, {40, 80, 80, 45}, {80, 10, 20, 55}, {70, 30, 20, 65},
        {60, 50, 70, 75}, {50, 70, 30, 85}, {40, 80, 40, 45}, {30, 90, 50, 95}};

        double promedio_paralelo = obtenerPromedioParalelo(notas);
        String nombre;
        String apellido;
        String tipoNotas;
        int notaBaja;
        int notaAlta;
        double promedioEstudiante;
        int numeroNotasArribaPromedio;
        int[] filaNotas;
        String mensajeFinal = "";
        for (int i = 0; i < nombres.length; i++) {
            nombre = nombres[i];
            apellido = apellidos[i];
            filaNotas = notas[i];
            promedioEstudiante = funcion01(filaNotas);
            numeroNotasArribaPromedio = funcion02(filaNotas, promedio_paralelo);
            tipoNotas = funcion03(filaNotas);

            notaBaja = promedioBajo(filaNotas);
            notaAlta = promedio(filaNotas);

            mensajeFinal = String.format("%s%s\n", mensajeFinal,
                    presentarReporte(nombre, apellido, tipoNotas, promedioEstudiante,
                            numeroNotasArribaPromedio, notaBaja, notaAlta));
        }
        CrearArchivoTexto.agregarRegistros(mensajeFinal);
    }

    public static String presentarReporte(String nom, String ap, String notas, double prom, int numeroNotas, int notaBaja, int notaAlta) {
        return String.format("Nombres: %s\n"
                + "Apellidos: %s\n"
                + "Con notas: \n"
                + "%s\n"
                + "Promedio - %.2f\n"
                + "Número de notas arriba del promedio: %d\n"
                + "Nota baja: %d\n"
                + "Nota alta: %d\n\n",
                nom, ap, notas, prom, numeroNotas, notaBaja, notaAlta);
    }

    public static int promedioBajo(int[] notas) {
        int notaBaja = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < notaBaja) {
                notaBaja = notas[i];
            }
        }
        return notaBaja;
    }

    public static int promedio(int[] notas) {
        int notaAlta = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > notaAlta) {
                notaAlta = notas[i];
            }
        }
        return notaAlta;
    }

    public static double obtenerPromedioParalelo(int[][] n) {
        int suma = 0;
        double promedio;
        int contador = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                suma = suma + n[i][j];
                contador = contador + 1;
            }
        }

        promedio = (double) suma / contador;
        return promedio;
    }

    public static double funcion01(int[] notas) {
        int suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        return (double) suma / notas.length;
    }

    public static int funcion02(int[] notas, double promedio) {
        int contador = 0;
        for (int nota : notas) {
            if (nota > promedio) {
                contador++;
            }
        }
        return contador;
    }

    public static String funcion03(int[] notas) {
        StringBuilder cadena = new StringBuilder();
        for (int nota : notas) {
            if (nota >= 0 && nota <= 20) {
                cadena.append(nota).append("-M\n");
            } else if (nota > 20 && nota <= 50) {
                cadena.append(nota).append("-MB\n");
            } else {
                cadena.append(nota).append("-S\n");
            }
        }
        return cadena.toString();
    }
}
