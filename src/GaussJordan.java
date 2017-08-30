import java.util.ArrayList;

/**
 * Created by Diego Castaneda on 29/08/2017.
 */
public class GaussJordan {
    private ArrayList<ArrayList<Double>> matriz = new ArrayList<>();
    private ArrayList<Double> incognitas = new ArrayList<>();

    public GaussJordan(ArrayList<ArrayList<Double>> matriz){
        this.matriz = matriz;
    }

    public void calcularIncognitas(){
        //Donde n representa el numero de filas de la matriz
        int n = matriz.size();

        // Aqui estamos revisando para cada una de las filas de la matriz.
        // No se toma en cuenta la primera fila porque, segun el metodo de Gauss,
        // no se le realiza ninguna modificacion a la primera fila.
        for(int k = 0; k < n; k++ ){
            for(int i = 0; i < n-1; i++){
                if(i != k){
                    double M = matriz.get(i).get(k) / matriz.get(k).get(k);
                    for(int j = k; j < n+1; j++){
                        double numero = matriz.get(i).get(j) - M*matriz.get(k).get(j);
                        matriz.get(i).set(j,numero);
                    }
                }
            }

        }
        int index = 0;
        while(index < matriz.size()){
            ArrayList<Double> fila = matriz.get(index);
            int indexResultado = fila.size() -1;
            double numero =  fila.get(indexResultado) / fila.get(index);
            incognitas.add(numero);


            index = index + 1;
        }
    }

    public ArrayList<Double> getIncognitas() {
        return incognitas;
    }
}
