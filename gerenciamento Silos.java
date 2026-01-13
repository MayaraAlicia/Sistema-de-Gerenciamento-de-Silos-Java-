import java.util.ArrayList;
import java.util.Scanner;

class Silo {
    public String grao;
    public int id;
    public float quantidadeAtualKg;
    public float quantidadeMaxKg;
    public float porcentagem;
}

public class Main
{
	public static void main(String[] args) {
	    
	    int proximoId = 1;
	    Scanner scanner = new Scanner (System.in);
	    boolean continuar = true;
		ArrayList<Silo> graosCadastrados = new ArrayList<>();
		Silo s1 = new Silo();
		s1.id = proximoId;
		s1.grao = "milho";
		s1.quantidadeAtualKg = 0;
		s1.quantidadeMaxKg = 100;
		graosCadastrados.add(s1);
		
		proximoId ++;
		
		Silo s2 = new Silo ();
		s2.id = proximoId;
		s2.grao = "soja";
		s2.quantidadeAtualKg = 10;
		s2.quantidadeMaxKg = 150;
		graosCadastrados.add(s2);
		proximoId++;
		
		while (continuar) {
		    System.out.println("--- Meus Silos ---");
		    System.out.println("1. Visualizar silos");
		    System.out.println("2. Adicionar novo silo");
		    System.out.println("3. Modificar silo existente");
		    System.out.println("4. Sair");
		    
		    String escolha = scanner.nextLine();
		    
		    if (escolha.equals("4")) {
		        System.out.println("Saindo do sistema...");
		        continuar = false;
		    }
		    
		    else if (escolha.equals("1")){
		        System.out.println("Silos registrados: ");
		        for (Silo s : graosCadastrados) {
		            s.porcentagem = (s.quantidadeAtualKg/s.quantidadeMaxKg) * 100;
		            System.out.println("Grão: " + s.grao + " | Quantidade: " + s.quantidadeAtualKg + "| Lotação: " + s.porcentagem + "%");
		            if (s.porcentagem > 90) {
		                System.out.println("Silo próximo a lotação maxima");
		            }
		            else if (s.porcentagem < 10) {
		                System.out.println("Silo necessitando de reposição");
		            }
		            
		        }
		    }
		  else if (escolha.equals("2")) {
		      Silo novo = new Silo();
		      
		      novo.id = proximoId;
		      proximoId ++;
		      
		      System.out.println("Digite o nome do grão: ");
		      novo.grao = scanner.nextLine();
		      System.out.println("Quantidade maxima em kg suportado pelo silo: ");
		      novo.quantidadeMaxKg = Float.parseFloat(scanner.nextLine());
		      
		      novo.quantidadeAtualKg = 0;
		      
		      graosCadastrados.add(novo);
		      System.out.println("Silo [" + novo.id + "] cadastrado com sucesso!");
		      
		  }
		  else if (escolha.equals("3")) {
		      
		      for (Silo s : graosCadastrados){
		          System.out.println("[" + s.id + "] - " + s.grao);
		      }
		      System.out.println("Digite o ID do silo que deseja alterar: ");
		      int idBusca = Integer.parseInt(scanner.nextLine());
		      
		      Silo siloEncontrado = null;
		      
		      for (Silo s : graosCadastrados){
		          if (s.id == idBusca){
		              siloEncontrado = s;
		              break;
		          }
		      }
		      
		      if (siloEncontrado != null){
		          System.out.println("Silo selecionado: " + siloEncontrado.grao);
		          System.out.println("1. Adicionar | 2. Retirar");
		          String acao = scanner.nextLine();
		          
		          if (acao.equals("1")){
		              System.out.println("Quantos quilos deseja adicionar? ");
		              float kgAdicionar = Float.parseFloat(scanner.nextLine());
		              
		              if (kgAdicionar + siloEncontrado.quantidadeAtualKg > siloEncontrado.quantidadeMaxKg){
		                  System.out.println("Essa quantidade é acima do limite permitido, o silo não suporta esse volume!");
		              }
		              
		              else{
		              
    		              siloEncontrado.quantidadeAtualKg = siloEncontrado.quantidadeAtualKg + kgAdicionar;
    		              System.out.println("Sucesso! o silo agora possui " + siloEncontrado.quantidadeAtualKg + "Kg.");
    		              }
		          }
		          
		          else if (acao.equals("2")) {
		              System.out.println ("Quantos quilos deseja subtrair? ");
		              float kgSubtrair = Float.parseFloat(scanner.nextLine());
		              
		              if (siloEncontrado.quantidadeAtualKg - kgSubtrair < 0){
		                  System.out.println("Erro! Essa quantidade faria o silo ficar com quantidade negativa de grãos.");
		              }
		              
		              else{
    		              siloEncontrado.quantidadeAtualKg = siloEncontrado.quantidadeAtualKg - kgSubtrair;
    		              System.out.println("Sucesso! o silo agora possui " + siloEncontrado.quantidadeAtualKg + "Kg.");
		              }
		          }
		          
		          else{
		          
		          System.out.println("Operação não listada!");
		      }
		      }
		      
		      else{
		          System.out.println ("Silo não encontrado!");
		      }
		      
		      

		  }
		  
		  else{
		      System.out.println("Valor incorreto! Nenhuma operação encontrada.");
		  }
		  
		    }
		}
	}

