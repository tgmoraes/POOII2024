package livraria;

import java.util.ArrayList;

public class Livraria {
	private final String nome;
	private final ArrayList<Impressao> estoque;
	
	public Livraria(String nome) {
		this.nome=nome;
		estoque = new ArrayList<>();
	}
	public String getNome() {
		return this.nome;
	}
	public void addEstoque(Publicacao pub, int qtde) {
		if(qtde<1) throw new LivrariaException("qtde adicionada deve ser positivo");
		while(qtde>0) {
			this.addEstoque(pub);
			qtde--;
		}
	}
	public void addEstoque(Publicacao pub) {
		if(pub == null) throw new LivrariaException("publicacao nao pode ser nula");
		estoque.add(new Impressao(pub));
	}
	public Impressao vende(Publicacao pub) {
		if(pub == null) throw new LivrariaException("publicacao nao pode ser nula");
		Impressao ret = null;
		for(int i=0; i< estoque.size();i++) {
			Impressao item= estoque.get(i);
			
			if(item.getPublicacao().equals(pub)) {
				ret = estoque.remove(i);
				break;
			}
		}
		return ret;
	}
	public int getExemplares(Publicacao pub) {
		int cont=0;
		for(Impressao item: this.estoque) {
			if(item.getPublicacao().equals(pub)) cont++;
		}
		return cont;
	}
}
