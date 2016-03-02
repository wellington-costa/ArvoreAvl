package ArvoreDeBusca;

public class Main {
	public static void main(String args[]){
		No n1 = new No(50);
		No n2 = new No(10);
		No n3 = new No(60);
		No n4 = new No(70);
		No n7 = new No(80);
		No n6 = new No(95);
		No n8 = new No(100);
		No n9 = new No(105);
		No n10 = new No(109);
		ArvoreBusca av1 = new ArvoreBusca();
		
		av1.inserir(n1);
		av1.inserir(n2);
		av1.inserir(n3);
		av1.inserir(n4);
		av1.inserir(n7);
		av1.inserir(n6);
		av1.inserir(n8);
		av1.inserir(n9);
		av1.inserir(n10);
		
		av1.imprime();
		
		
		
		
		
	}
	

}
