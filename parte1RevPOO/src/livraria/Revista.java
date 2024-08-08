package livraria;

import java.time.LocalDate;

public class Revista extends Publicacao{
	private final String editora;
	private final int edicao;
	public Revista(String titulo, LocalDate dt, String editora, int num) {
		super(titulo, dt);
		this.editora = editora;
		this.edicao = num;
	}
	public String getEditora() {
		return this.editora;
	}
	public int getEdicao() {
		return this.edicao;
	}
	@Override
	public String toString() {
		return  super.toString()
				//this.getClass().getSimpleName()+": "+this.getTitulo()
				+" ("+this.getData().getMonthValue()
				+"/"+this.getData().getYear()+") - editora "+
				this.getEditora()+" - edicao n:"+ this.getEdicao();
	}
	@Override
	public boolean equals(Object o) {
		if(o==null) return false;
		if(! (o instanceof Revista)) return false;
		//se a referência é a mesma então igual (é reflexivo)
		if(this==o) return true;
		
		//cast do object para Revista
		Revista par = (Revista)o;
		if(this.getData().equals(par.getData()) &&
		   this.editora.equals(par.editora) &&
		   this.edicao == par.edicao &&
		   this.getTitulo().equals(par.getTitulo())) {
			return true;
		} else return false;
	}
}
