public class Main {
    public static void main(String[] args){
        Vetor ordems = new Vetor(5);
        for(int x = 1; x <= 5; x++){
            ordems.setElemento(x - 1, (2 * x + 1));
        }
        for(int x = 0; x < 5; x++){
            MatrizQuadrada matOriginal = new MatrizQuadrada(ordems.getElemento(x));
            MatrizQuadrada mat = new MatrizQuadrada(ordems.getElemento(x));
            matOriginal.inicializaRandomico();
            mat.copia(matOriginal);
            mat.imprime();                  // vizualizacao da matriz estudada
            int determinante;
            long inicio, fim, tempo;

            //                              //
            //            inicio            //
            //      Run sem otimizacao      //
            //                              //
            inicio = System.nanoTime();
            determinante = mat.determinante();
            fim = System.nanoTime();
            //                              //
            //            fim               //
            //      Run sem otimizacao      //
            //                              //
            tempo = fim - inicio;
            System.out.println("Valor calculado: " + determinante);
            System.out.println("Tempo em nanosegundos (sem otimizacao): " + tempo);
            

            //                              //
            //            inicio            //
            //      Run com otimizacao      //
            //                              //
            inicio = System.nanoTime();
            determinante = mat.determinanteOtmi();
            fim = System.nanoTime();
            //                              //
            //            fim               //
            //      Run com otimizacao      //
            //                              //
            tempo = fim - inicio;
            System.out.println("Tempo em nanosegundos (com otimizacao): " + tempo);
            
        }
    }
}
