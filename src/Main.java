import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Diego Castaneda on 21/08/2017.
 */
public class Main {

    public static void main(String args[]){

        ArrayList<ArrayList<Double>> matriz = new ArrayList<>();
        ArrayList<Double> resultadosFilas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el numero de incognitas de su sistema: ");
        int numeroDeFilas = scanner.nextInt();

        for (int indexFila = 0; indexFila < numeroDeFilas; indexFila++){
            ArrayList<Double> fila = new ArrayList<>();
            for(int variable = 0; variable < numeroDeFilas; variable++){
                System.out.println("Porfavor ingrese el coeficiente de la variable " + (variable + 1) + " de la fila "
                        + (indexFila + 1));
                double coeficiente = Double.parseDouble(scanner.next());
                fila.add(coeficiente);


            }
            System.out.println("Ingrese el resutlado de esta fila: ");
            double resultado = Double.parseDouble(scanner.next());
            fila.add(resultado);
            resultadosFilas.add(resultado);
            matriz.add(fila);
        }

        Gauss gauss = new Gauss(matriz);
        GaussJordan gaussJ = new GaussJordan(matriz);


        gauss.calcularIncognitas();
        gaussJ.calcularIncognitas();
        ArrayList<Double> respuestasG = gauss.getIncognitas();
        ArrayList<Double> respuestasGJ = gaussJ.getIncognitas();

        System.out.println("Su respuesta con Eliminacion gaussiana es: ");
        System.out.println(respuestasG);
        System.out.println("Su respuesta con Gauss-Jordan es: ");
        System.out.println(respuestasGJ);



    }
}
