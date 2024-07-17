class MatrizQuadrada extends Matriz{

	MatrizQuadrada(int ordem){
		super(ordem, ordem);
	}

	public int getOrdem(){
		return this.getTamanhoLinha();
	}
	
	private int detOrdem1(MatrizQuadrada mat){
		return mat.getValor(0,0);
	}
	
	private int detOrdem2(MatrizQuadrada mat){
		int diagonalPrincipal = mat.getValor(0,0) * mat.getValor(1,1);		
		int diagonalSecundaria = mat.getValor(1,0) * mat.getValor(0,1);		
		return (diagonalPrincipal - diagonalSecundaria);
	}

	private int calculaSinalCofator(int indiceLinha, int indiceColuna){
		int sinal = -1;
		if((indiceLinha + indiceColuna) % 2 == 0 ){
			sinal = 1;
		}
		return sinal;		
	}

	public void copiaMatrizMaiorParaMenor(MatrizQuadrada maior, MatrizQuadrada menor, int linhaExcluida, int colunaExcluida){   
		int numLinhasMenor = menor.getTamanhoLinha(), 
			numColunasMenor = menor.getTamanhoColuna(), 
			contLinhasMaior = 0;
		for(int contLinhasMenor = 0; contLinhasMenor < numLinhasMenor; contLinhasMenor++){
			if(contLinhasMaior == linhaExcluida){
				contLinhasMaior++; //pula a linha excluida
			}
			int contColunasMaior = 0;
			for(int contColunasMenor = 0; contColunasMenor < numColunasMenor; contColunasMenor++){
				if(contColunasMaior == colunaExcluida){
					contColunasMaior++; //pula a coluna excluida
				}
				int temp = maior.getValor(contLinhasMaior, contColunasMaior);
				menor.setValor(contLinhasMenor, contColunasMenor, temp);
				contColunasMaior++;
			}
			contLinhasMaior++;
		}
	}

	private Vetor melhorFila(MatrizQuadrada mat){
		int indexLinha = 0,
			indexColuna = 0,
			auxLinhas = 0,
			auxColunas = 0,
			numLinhas = mat.getTamanhoLinha(),
			numColunas = mat.getTamanhoColuna();
		Vetor resposta = new Vetor(2);
		for(int contLinhas = 0; contLinhas < numLinhas; contLinhas++){
			int numZerosLinha = 0,
				numZerosColuna = 0;
			for(int contColunas = 0; contColunas < numColunas; contColunas++){
				int elementoLinha = mat.getValor(contLinhas, contColunas),
					elementoColuna = mat.getValor(contColunas, contLinhas);
				if(elementoLinha == 0){
					numZerosLinha++;
				}
				if(elementoColuna == 0){
					numZerosColuna++;
				}
			}
			if(numZerosLinha > auxLinhas){
				auxLinhas = numZerosLinha;
				indexLinha = contLinhas;
			}
			if(numZerosColuna > auxColunas){
				auxColunas = numZerosColuna;
				indexColuna = contLinhas;
			}
		}
		if(auxLinhas > auxColunas){
			resposta.setElemento(0, indexLinha);
			resposta.setElemento(1, 0);
		}
		else{
			resposta.setElemento(0, indexColuna);
			resposta.setElemento(1, 1);
		}
		return resposta;
	}


	private int detOrdemNotmi(MatrizQuadrada mat){
		Vetor otimizacao = this.melhorFila(mat);
		int resposta = 0,
			ordem = mat.getOrdem(),
			fila = otimizacao.getElemento(0),
			linhaOuColuna = otimizacao.getElemento(1);
		if(linhaOuColuna == 0){
			for(int contColunas = 0; contColunas < mat.getTamanhoColuna(); contColunas++){
				int cofator = mat.getValor(fila, contColunas);
				if(cofator != 0){
					int sinal = this.calculaSinalCofator(fila, contColunas);
					MatrizQuadrada matmenor = new MatrizQuadrada(ordem-1);
					this.copiaMatrizMaiorParaMenor(mat, matmenor, fila, contColunas);
					int detTemp = matmenor.determinante();
					resposta += (cofator * sinal * detTemp);
				}
				else{
					resposta += 0;
				}
			}
		}
		else{
			for(int contLinhas = 0; contLinhas < mat.getTamanhoLinha(); contLinhas++){
				int cofator = mat.getValor(contLinhas, fila);
				if(cofator != 0){
					int sinal = this.calculaSinalCofator(contLinhas, fila);
					MatrizQuadrada matmenor = new MatrizQuadrada(ordem-1);
					this.copiaMatrizMaiorParaMenor(mat, matmenor, contLinhas, fila);
					int detTemp = matmenor.determinante();
					resposta += (cofator * sinal * detTemp);
				}
				else{
					resposta += 0;
				}
			}
		}
		return (resposta);
	}
	


	private int detOrdemN(MatrizQuadrada mat){
		int sinal,cofator,detTemp,resposta,contC,numL;
		MatrizQuadrada matmenor;
		numL = this.getTamanhoLinha();
		resposta = 0;
		for(contC = 0; contC < mat.getTamanhoColuna(); contC++){
			cofator = mat.getValor(0,contC);
			sinal = this.calculaSinalCofator(0,contC);
			matmenor = new MatrizQuadrada(numL-1);
			this.copiaMatrizMaiorParaMenor(mat,matmenor,0,contC);
			detTemp = matmenor.determinante();
			resposta = resposta + (cofator * sinal * detTemp);
		}
		return (resposta);
	}

	public int determinanteOtmi(){
		int det = 0,
			ordem = this.getOrdem();
		if(ordem > 0){
			switch (ordem) {
			    case 1:  det = this.detOrdem1(this);
				     break;
			    case 2:  det = this.detOrdem2(this);;
				     break;
			    default: det = this.detOrdemNotmi(this);;
				     break;
			}
		}
		else{
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}
		return det;
	}

	public int determinante(){
		int det = 0,
			ordem = this.getOrdem();
		if(ordem > 0){
			switch (ordem) {
			    case 1:  det = this.detOrdem1(this);
				     break;
			    case 2:  det = this.detOrdem2(this);;
				     break;
			    default: det = this.detOrdemN(this);;
				     break;
			}
		}
		else{
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}
		return det;
	}

}
