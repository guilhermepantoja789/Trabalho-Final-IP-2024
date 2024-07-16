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
            //                              //
            //            inicio            //
            //      Run sem otimizacao      //
            //                              //
            int determinante;
            double inicio = System.nanoTime();
            determinante = mat.determinante();
            double fim = System.nanoTime();
            double tempo_ms = (fim - inicio) / 1000000.0d;
            System.out.println("Valor calculado: " + determinante);
            System.out.println("Tempo em ms (sem otimizacao): " + tempo_ms);
            //                              //
            //            fim               //
            //      Run sem otimizacao      //
            //                              //

            //                              //
            //            inicio            //
            //      Run com otimizacao      //
            //                              //
            inicio = System.nanoTime();
            determinante = mat.determinanteOtmi();
            fim = System.nanoTime();
            tempo_ms = (fim - inicio) / 1000000.0d;
            System.out.println("Valor calculado: " + determinante);
            System.out.println("Tempo em ms (com otimizacao): " + tempo_ms);
            //                              //
            //            fim               //
            //      Run com otimizacao      //
            //                              //
        }
    }
}
