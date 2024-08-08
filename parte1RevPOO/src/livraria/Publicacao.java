package livraria;

import java.time.LocalDate;

public abstract class Publicacao {
	private final String titulo;
	private final LocalDate data;
	
	public Publicacao (String titulo,LocalDate data) {
		if(data==null) throw new NullPointerException("data nao deve ser nula");
		this.data = data;
		this.titulo = titulo;
	}
	public String getTitulo() {
		return titulo;
	}
	public LocalDate getData() {
		return data;
	}
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+": "+this.getTitulo();
	}
}
