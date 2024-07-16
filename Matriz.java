import java.util.Random;

public class Matriz {
    private int[][] mat;
	private int tamLinha;
	private int tamColuna;

    Matriz(int numLinhas, int numColunas){
		int[][] matTemp = new int[numLinhas][numColunas];
		this.setMat(matTemp);
		this.setTamanhoLinha(numLinhas);	
		this.setTamanhoColuna(numColunas);
	}

	public void copia(MatrizQuadrada mat){
		this.setMat(mat.getMat());
	}
	
	public int[][] getMat(){
		return this.mat;
	}
	public void setMat(int[][] mat){
		this.mat = mat;
	}

	public int getValor(int indiceLinha, int indiceColuna){
		return mat[indiceLinha][indiceColuna];
	}	
	public void setValor(int indiceLinha,int indiceColuna, int novoValor){
		mat[indiceLinha][indiceColuna] = novoValor;
	}

	public int getTamanhoLinha(){
		return tamLinha;
	}	
	private void setTamanhoLinha(int novoValor){
		tamLinha = novoValor;
	}

	public int getTamanhoColuna(){
		return tamColuna;
	}
	private void setTamanhoColuna(int novoValor){
		tamColuna = novoValor;
	}

    public void imprime(){	
		for(int contLinhas = 0; contLinhas < this.getTamanhoLinha(); contLinhas++){
			System.out.println();
			for(int contColunas = 0; contColunas < this.getTamanhoColuna(); contColunas++){
				System.out.print(this.getValor(contLinhas, contColunas) + " ");
			}
		}
		System.out.println();	
	}

	public void inicializaRandomico(){
		int ordem = this.getTamanhoLinha();
		Random gerador = new Random();
		for(int contLinhas = 0; contLinhas < this.getTamanhoLinha(); contLinhas++){
			for(int contColunas = 0; contColunas < this.getTamanhoColuna(); contColunas++){
				int novoValor = gerador.nextInt(ordem * ordem);
				this.setValor(contLinhas, contColunas, novoValor);
			}
		}
	}
}