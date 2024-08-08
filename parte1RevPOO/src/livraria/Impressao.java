package livraria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Impressao implements Comparable<Impressao> {

	private final Publicacao publicacao;
	private final String cod;
	private static int qtdeimpressoes = 0;
	private final LocalDate data;

	public Impressao(Publicacao pub) {
		if (pub == null)
			throw new LivrariaException("Impressao nao pode ser de uma publicacao nula");
		this.publicacao = pub;
		data = LocalDate.now();
		this.cod = String.format("%c%d", pub.getClass().getSimpleName().charAt(0), Impressao.qtdeimpressoes);
		Impressao.qtdeimpressoes++;
	}

	public Publicacao getPublicacao() {
		return this.publicacao;
	}

	public String getCodigo() {
		return this.cod;
	}

	public LocalDate getData() {
		return this.data;
	}

	@Override
	public String toString() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "exemplar: " + this.cod + "| Data impressao: " + this.getData().format(f) + "\n"
				+ this.publicacao.toString();

	}

	@Override
	public int compareTo(Impressao o) {
		return this.cod.compareTo(o.cod);
	}
}
