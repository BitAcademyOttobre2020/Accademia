package it.bit.accademia.model;

public class Area {
	
	private int id;
	private String nome;
	private String descrizione;
	
	public Area(int id, String nome, String descrizione) {
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + "]";
	}
	
	

}
