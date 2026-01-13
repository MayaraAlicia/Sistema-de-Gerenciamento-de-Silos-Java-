import java.util.ArrayList;
import java.util.Scanner;

class Silo {
    private int id;
    private String grao;
    private float quantidadeAtualKg;
    private float quantidadeMaxKg;
    
    public Silo (int id, String grao, float quantidadeMaxKg){
        this.id = id;
        this.grao = grao;
        this.quantidadeMaxKg = quantidadeMaxKg;
        this.quantidadeAtualKg = 0;
    }
    
    public int getId() {return id;}
    public String getGrao() {return grao;}
    public float getQuantidadeAtualKg() {return quantidadeAtualKg;}
    public float getQuantidadeMaxKg() {return quantidadeMaxKg;}
    private float porcentagem;
    
    public boolean adicionar (float quantidade){
        if (this.quantidadeAtualKg + quantidade > quantidadeMaxKg){
            return false;
        }
        this.quantidadeAtualKg += quantidade;
        return true;
    }
    
    public boolean remover (float quantidade){
        if (this.quantidadeAtualKg - quantidade < 0){
            return false;
    }
    this.quantidadeAtualKg -= quantidade;
    return true;}
    
    public float calcularPorcentagem(){
        if (quantidadeMaxKg == 0)return 0;
        return (quantidadeAtualKg/quantidadeMaxKg) * 100;
    }
}



public class Main
{
	public static void main(String[] args) {
	    
	    int proximoId = 1;
	    Scanner scanner = new Scanner (System.in);
	    boolean continuar = true;
		ArrayList<Silo> graosCadastrados = new ArrayList<>();
		
		graosCadastrados.add(new Silo(proximoId++, "Milho", 100));
		Silo s2 = new Silo (proximoId++, "Soja", 150);
		s2.adicionar(10);
		graosCadastrados.add(s2);
		
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
		            System.out.printf("ID: %d | %s | %.1f Kg (%.1f%%)\n",
		                s.getId(), s.getGrao(), s.getQuantidadeAtualKg(), s.calcularPorcentagem());
		    }
		    }
		    
		    
		    else if (escolha.equals("2")) {
		      System.out.println("Digite o nome do grão: ");
		      String nome = scanner.nextLine();
		      System.out.println("Quantidade maxima em kg suportado pelo silo: ");
		      float max = Float.parseFloat(scanner.nextLine());
		      
		      graosCadastrados.add(new Silo (proximoId++, nome, max));
		      System.out.println("Silo cadastrado com sucesso!");
		      
		  }
		  else if (escolha.equals("3")) {
		      
		      System.out.println("Digite o ID do silo que deseja alterar: ");
		      int idBusca = Integer.parseInt(scanner.nextLine());
		      
		      Silo encontrado = null;
		      
		      for (Silo s : graosCadastrados){
		          if (s.getId() == idBusca){
		              encontrado = s;
		              break;
		          }
		      }
		      
		      if (encontrado != null){
		          System.out.println("Silo selecionado: " + encontrado.getGrao());
		          System.out.println("1. Adicionar | 2. Retirar");
		          String acao = scanner.nextLine();
		          System.out.println("Quantidade: ");
		          float qtd = Float.parseFloat(scanner.nextLine());
		          
		          if (acao.equals("1")){
		              if (encontrado.adicionar(qtd)){
		                  System.out.println("Adicionado com sucesso!");
		              }
		              else{
		                  System.out.println("Erro: O silo vai transbordar!");
    		              }
		          }
		          
		          else if (acao.equals("2")) {
		              if (encontrado.remover(qtd)){
		                  System.out.println("Removido com sucesso!");
		              }
		              else{
		                  System.out.println("Erro: Não há grãos suficientes.");
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
		    scanner.close();
		}
	}

