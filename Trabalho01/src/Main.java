import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

public class Main {
	
	static ArrayList<String> aAlfabeto = new ArrayList();
	static ArrayList<String> aEstados = new ArrayList();
	static ArrayList<String> aEstadosFinais = new ArrayList<>();
	static String aTabela[][] = new String[aEstados.size()][aAlfabeto.size()];
	static String[] aFita;
	
	
	/*Monta uma matriz representando a tabela de transição*/
	public static String[][] montaTabela(){	
	 String m[][] = new String[aEstados.size()][aAlfabeto.size()];	
	 int linha, coluna;
	 String valor;
		Scanner scanner = new Scanner(System.in);
		for (linha = 0; linha < aEstados.size(); linha++) {
            for (coluna = 0; coluna < aAlfabeto.size(); coluna++) {
            	System.out.println("Entre com o valor matriz ["+ aEstados.get(linha) +"]["+ aAlfabeto.get(coluna) +"]: ");
            	valor = scanner.next();

                m[linha][coluna] = valor;
            }
		}
		return m;
	}
	
	/*Método auxiliar para montar os arrays utilizados ao longo do programa*/
	public static ArrayList<String> separaValores(String valor){
		 ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(valor.split(",")));
		 return arrayList;
	}

	
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String _alfabeto = "";
		String _estados = "";
		String _estadoFinal = "";
		String _estadoInicial = "";
		String _fita= "";
		int opcao;
		int testarPalavra;
		
		System.out.println("\n\n### Trabalho 01 de Linguagens Formais e Autômatos ###");
		
		do{
			
			System.out.println("\n   ==========MENU==========");
			System.out.println("  |     1 - Gerar Autômato |");
			System.out.println("  |     0 - Sair           |");
			System.out.println("   ========================\n");

			System.out.print("Escolha uma opção: ");
			
			opcao = scanner.nextInt();
			System.out.print("\n");
			switch (opcao) {
			case 1:
				System.out.println("--> ATENÇÃO: Separar os valores por virgulas, ex: 'a,b,c'. <--");
				System.out.println("");
				System.out.println("Insira o alfabeto: ");
				_alfabeto = scanner.next();
				System.out.println("Insira os estados:");
				_estados = scanner.next();
				System.out.println("Insira o estado Final:");
				_estadoFinal = scanner.next();
				System.out.println("Insira o estado Inicial:");
				_estadoInicial = scanner.next();
				
				
				aAlfabeto = separaValores(_alfabeto);
				aEstados = separaValores(_estados);
				aEstadosFinais = separaValores(_estadoFinal);
				System.out.println("\n ATENÇÃO: Para o preenchimento da tabela, coloque 'x' nos casos em que não há transição! \n");
				aTabela = montaTabela();
				

				
				/*cria o automato e faz os processamentos*/
				Automato automato = new Automato(aAlfabeto, aEstados, aEstadosFinais, _estadoInicial, aTabela);
				
				/*Inserir as palavras: */
				do{
				System.out.println("Insira a palavra a ser processada:");
				_fita = scanner.next();
				aFita = _fita.split(",");
				
				boolean palavraAceita = automato.validarPalavra(aFita);
		
				if(palavraAceita){
					System.out.println("Palavra Aceita! \n");
				}else{
					System.out.println("Palavra Rejeitada! \n");
				}
				
				System.out.println("Deseja testar outra palavra? 0 - não / 1 - Sim");
				testarPalavra = scanner.nextInt();
				
				}while(testarPalavra != 0);
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}	
		}while (opcao != 0);

	}

}
