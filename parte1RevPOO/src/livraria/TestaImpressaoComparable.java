package livraria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class TestaImpressaoComparable {

	public static void main(String[] args) {
		Revista r1 = new Revista("Superinteressante", LocalDate.of(2021, 3, 1), "Abril", 425);
		Livro l1 = new Livro("O Senhor dos anéis - A Sociedade do Anel", LocalDate.of(1954, 5, 24), 468,
				"J. R. R. Tolkien");
		ArrayList<Impressao> lista = new ArrayList<>();
		lista.add(new Impressao(r1));
		lista.add(new Impressao(l1));
		lista.add(new Impressao(r1));
		lista.add(new Impressao(l1));
		lista.add(new Impressao(r1));
		lista.add(new Impressao(l1));
		System.out.println("desordenado");
		System.out.println(lista);
		
		System.out.println("ordenando...");
		Collections.sort(lista);
		
		System.out.println(lista);

	}

}
