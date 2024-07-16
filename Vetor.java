public class Vetor{
    private int[] arr;
    private int tamanho;

    Vetor(int tamanho){
        this.setTamanho(tamanho);
        arr = new int[this.getTamanho()];
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setElemento(int index, int elemento){
        this.arr[index] = elemento;
    }

    public int getElemento(int index){
        return arr[index];
    }
}