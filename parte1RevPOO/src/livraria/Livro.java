package livraria;

import java.time.LocalDate;

public class Livro extends Publicacao{
	private final int paginas;
	private final String[] autores;
	
	public Livro(String titulo, LocalDate d, int paginas,String...autores) {
		super(titulo,d);
		if(paginas<1) throw new LivrariaException("paginas do livro deve ser positivo");
		this.paginas=paginas;
		this.autores = autores;
	}
	public int getPaginas() {
		return this.paginas;
	}
	public String[] getAutores() {
		return this.autores;
	}
	@Override
	public String toString() {
		String authors = "Autores: ";
		for (String autor:this.autores) authors+=autor+", ";
		authors = authors.substring(0, authors.length()-2);
		return  super.toString()
				//this.getClass().getSimpleName()+": "+this.getTitulo()
				+" ("+this.getData().getYear()+") - "+
				this.getPaginas()+" paginas - "+	authors;
	}
	@Override
	public boolean equals(Object o) {
		if(o==null) return false;
		if(! (o instanceof Livro)) return false;
		//se a referência é a mesma então igual (é reflexivo)
		if(this==o) return true;
		
		//cast do object para Livro
		Livro par = (Livro)o;
		if(this.autores.length != par.autores.length) return false;
		for(int i=0;i<this.autores.length;i++) {
			if(!this.autores[i].equals(par.autores[i])) return false;
		}
		
		if(this.getData().equals(par.getData()) &&
		   this.paginas == par.paginas &&
		   this.getTitulo().equals(par.getTitulo())) {
			return true;
		} else return false;
	}
}
