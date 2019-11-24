import java.util.ArrayList;

import javax.swing.text.TabableView;

//Classe responsável por criar o objeto para um novo Autômato.

public class Automato {
	private ArrayList<String> alfabeto = new ArrayList();
	private ArrayList<String> estados = new ArrayList();
	private ArrayList<String> estadosFinais = new ArrayList<>();
	private String estadoInicial;
	private String tabela[][] = new String[estados.size()][alfabeto.size()];

	

	public Automato(ArrayList<String> _alfabeto, ArrayList<String> _estados,  ArrayList<String> _estadoFinal, String _estadoInicial, String _tabela[][]){
		this.alfabeto = _alfabeto;
		this.estados = _estados;
		this.estadoInicial = _estadoInicial;
		this.estadosFinais = _estadoFinal;
		this.tabela = _tabela;
	}
	
	//Método que fará a validação das palavras inseridas
	public boolean validarPalavra(String[] fita){
		String estadoAtual = this.getEstadoInicial();
		String transicao = "";
		for(int i = 0; i < fita.length; i++){
			transicao = existeTransicao( estadoAtual, fita[i]);
			if(transicao != "x"){
				estadoAtual = transicao;
			}else{
				return false;
			}
		}
		
		if(estadosFinais.contains(estadoAtual)){  
			return true;
		}else{
			return false;
		}
		
	}
	
	//Verifica se existe a transição na tabela
	public String existeTransicao( String estadoAtual, String simboloFita){
		String transicao = "x";
		for(int linha = 0; linha <= estados.size(); linha++ ){
			for(int coluna = 0; coluna <= alfabeto.size(); coluna++){
				if(estados.get(linha).equals(estadoAtual) && alfabeto.get(coluna).equals(simboloFita)){
					if(tabela[linha][coluna] != "x"){
						transicao = tabela[linha][coluna];
						return transicao;
					}
				}
			}
		}
		
		
		return transicao;
	}
	
	public ArrayList<String> getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(ArrayList<String> alfabeto) {
		this.alfabeto = alfabeto;
	}

	public ArrayList<String> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<String> estados) {
		this.estados = estados;
	}

	public String getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(String estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public String[][] getTabela() {
		return tabela;
	}

	public void setTabela(String[][] tabela) {
		this.tabela = tabela;
	}


	public ArrayList<String> getEstadosFinais() {
		return estadosFinais;
	}


	public void setEstadosFinais(ArrayList<String> estadosFinais) {
		this.estadosFinais = estadosFinais;
	}
	
	

}
