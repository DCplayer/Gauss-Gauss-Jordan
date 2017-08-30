/*PseudoCodigo tomado de Jackson Arias de  https://sites.google.com/site/webnumerico20122/metodos-numericos/metodos-para-la-solucion-numerica-de-ecuaciones/eliminacion-gaussiana*/
import java.util.ArrayList;

/**
 * Created by Diego Castaneda on 29/08/2017.
 */


public class Gauss {
    private int numeroFilas;
    private int numeroColumnas;
    private ArrayList<ArrayList<Double>> matriz = new ArrayList<>();
    private ArrayList<Double> incognitas = new ArrayList<>();

    public Gauss(ArrayList<ArrayList<Double>> laMatrix){
        this.matriz = laMatrix;
    }

    public void calcularIncognitas(){
        //Donde n representa el numero de filas de la matriz
        int n = matriz.size();

        // Aqui estamos revisando para cada una de las filas de la matriz.
        // No se toma en cuenta la primera fila porque, segun el metodo de Gauss,
        // no se le realiza ninguna modificacion a la primera fila.
        for(int k = 0; k < n-1; k++ ){
            for(int i = k+1; i < n; i++){
                double M = matriz.get(i).get(k) / matriz.get(k).get(k);
                for(int j = k; j < n+1; j++){
                    double numero = matriz.get(i).get(j) - M*matriz.get(k).get(j);
                    matriz.get(i).set(j,numero);
                }
            }

        }
        for(int i = n; i < n; i++){
            double suma = 0;
            for(int j = i+1; j<n; j++){
                suma = suma + matriz.get(i).get(j)*incognitas.get(j);
            }
            double numerazo = (matriz.get(i).get(n) - suma  )/ matriz.get(i).get(i);
            incognitas.set(i, numerazo);
        }
    }

    public ArrayList<Double> getIncognitas() {
        return incognitas;
    }
}
