package ArvoreDeBusca;

public class No {
	
	private Integer valor;
	private No noEsquerda;
	private No noDireita;
	private No pai;
	
	public No(Integer valor) {
		super();
		this.valor = valor;
		
		   
	}
	public No getNoEsquerda() {
		return noEsquerda;
	}
	public void setNoEsquerda(No noEsquerda) {
		this.noEsquerda = noEsquerda;
	}
	public No getNoDireita() {
		return noDireita;
	}
	public void setNoDireita(No noDireita) {
		this.noDireita = noDireita;
	}
	public No getPai() {
		return pai;
	}
	public void setPai(No pai) {
		this.pai = pai;
	}
	
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	
	
	public Integer alturaDireita(){
		Integer hD = 0;
		  if(getNoDireita() != null){
			   hD = 1 + getNoDireita().altura();
		  }
			  
			  return hD;
		}
		
		public Integer alturaEsquerda(){
			Integer hE = 0;
			if(getNoEsquerda() != null){
				 hE = 1 + getNoEsquerda().altura();	
			}
			
			
		    return hE ;  
		} 
		public Integer altura(){
			return Math.max(alturaEsquerda(), alturaDireita());
		}
		public Integer fatorBalanceamento(){
			return alturaEsquerda() - alturaDireita();
		}
		
		

}
