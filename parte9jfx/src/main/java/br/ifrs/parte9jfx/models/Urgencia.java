package br.ifrs.parte9jfx.models;

public enum Urgencia {
	MUITO_BAIXA(1), BAIXA(2), MEDIA(3), ALTA(4), MUITO_ALTA(5);

	public int value;

	private Urgencia(int i) {
		this.value = i;
	}

	public static Urgencia getType(int codigo) {
		for (Urgencia type : Urgencia.values()) {
			if (type.value == codigo) {
				return type;
			}
		}

		throw new IllegalArgumentException("valor deve ser entre 1 e 5");
	}
	
	@Override
	public String toString() {
		switch (this.value) {
		case 1:  return "Muito Baixa";
		case 2:  return "Baixa";
		case 3:  return "Média";
		case 4:  return "Alta";
		case 5:  return "Muito Alta";
		default: return "sem prioridade";
		}
	}
	public static Urgencia fromString(String value) {
		switch (value) {
		case "Muito Baixa": return Urgencia.MUITO_BAIXA;
		case "Baixa": return Urgencia.BAIXA;
		case "Média": return Urgencia.MEDIA;
		case "Alta": return Urgencia.ALTA;
		case "Muito Alta": return Urgencia.MUITO_ALTA;
		default: return null;
		}
	}
}
