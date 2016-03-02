package ArvoreDeBusca;

public class ArvoreBusca {
	private No raiz;
	
	public void inserir(No novo){
		if(this.raiz == null){
			this.raiz = novo;
		}else{
			inserir(this.raiz, novo);
		}
	}
	private void inserir(No compara, No novo){
		if(novo.getValor() < compara.getValor()){
			if(compara.getNoEsquerda() != null){
				inserir(compara.getNoEsquerda(),novo);
			}else{
				 compara.setNoEsquerda(novo);
				 novo.setPai(compara);
				 verificaBalanceamento(this.raiz);
			}
		}if(novo.getValor() >= compara.getValor()){
			if(compara.getNoDireita() != null){
				inserir(compara.getNoDireita(), novo);
			}else{
				compara.setNoDireita(novo);
				novo.setPai(compara);
				verificaBalanceamento(this.raiz);
			}
		}
	}
	
	
		
		
	
	
	
	public void imprime(){
		imprime(this.raiz);
	}
	private void imprime(No no){
		if(no != null){
			imprime(no.getNoEsquerda());
			System.out.print(no.getValor());
			System.out.print(" HE: "+ no.alturaEsquerda()+ " ");
			System.out.print("HD: "+ no.alturaDireita() + " ");
			System.out.println("FB: "+ no.fatorBalanceamento());
			imprime(no.getNoDireita());
		}
	}
	
	public void verificaBalanceamento(No no){
		if(no.getNoEsquerda() != null){
			if((no.fatorBalanceamento() > 1) || (no.fatorBalanceamento() < -1) ){
				no = balancear(no);
			}else{
				verificaBalanceamento(no.getNoEsquerda());
				
			}
		} if(no.getNoDireita() != null){
			if((no.fatorBalanceamento() > 1) || (no.fatorBalanceamento() < -1) ){
				balancear(no);
			}else{
				verificaBalanceamento(no.getNoDireita());
				
			}
		}
		
	}
	public No balancear(No no){
		
		if(no.fatorBalanceamento() == -2){
			if((no.getNoDireita().fatorBalanceamento() == 2) || (no.getNoDireita().fatorBalanceamento() == -2) ){
				balancear(no.getNoDireita());
			}else if(no.getNoDireita().fatorBalanceamento() > 0){
				
			}else{
				rotacaoEsquerda(no);
				
			}
		}
		if(no.fatorBalanceamento() == 2){
			if((no.getNoDireita().fatorBalanceamento() == 2) || (no.getNoDireita().fatorBalanceamento() == -2) ){
				balancear(no.getNoDireita());
			}
			if(no.getNoEsquerda().fatorBalanceamento() > 0){
				
			}else{
				rotacaoEsquerda(no);
				
			}
		}
		return no;
	}
	
	public No rotacaoEsquerda(No no){
		No direita = no.getNoDireita();
		direita.setPai(no.getPai());
		no.setNoDireita(direita.getNoEsquerda());
		
		if(no.getNoDireita() != null){
			no.getNoDireita().setPai(no);
			
		}
		
		 direita.setNoEsquerda(no);
		 no.setPai(direita);
		 
		 if(direita.getPai() != null){
			 if(direita.getPai().getNoDireita() == no){
				 direita.getPai().setNoDireita(direita);
			 }else if(direita.getPai().getNoEsquerda()== no){
				 direita.getPai().setNoEsquerda(direita);
			 }
			 
		 }
		 no.fatorBalanceamento();
		 direita.fatorBalanceamento();
		 
		 if(no == this.raiz){
			  this.raiz = direita;
		 }
		 
		 return direita;
	}
	
	public No rotacaoDireita(No no){
		No esquerda = no.getNoEsquerda();
		esquerda.setPai(no.getPai());
		no.setNoEsquerda(esquerda.getNoDireita());
		
		if(no.getNoEsquerda() != null){
			no.getNoEsquerda().setPai(no);
			
		}
		
		 esquerda.setNoDireita(no);
		 no.setPai(esquerda);
		 
		 if(esquerda.getPai() != null){
			 if(esquerda.getPai().getNoDireita() == no){
				 esquerda.getPai().setNoDireita(esquerda);
			 }else if(esquerda.getPai().getNoEsquerda()== no){
				 esquerda.getPai().setNoEsquerda(esquerda);
			 }
			 
		 }
		 no.fatorBalanceamento();
		 esquerda.fatorBalanceamento();
		 
		 if(no == this.raiz){
			  this.raiz = esquerda;
		 }
		 
		 return esquerda;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	
	

}
