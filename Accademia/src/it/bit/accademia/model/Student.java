package it.bit.accademia.model;

public class Student {
	
	private int id; 
	private String nome; 
	private String cognome; 
	private String dataDiNascita; 
	private String CF;
	private String email;
	private String telefono;
	private String citta;
	private String via;
	private String cap;
	private int idRegione;
	private String titoloStudio;
	
	public Student(int id, String nome, String cognome, String dataDiNascita, String cF, String email, String telefono,
			String citta, String via, String cap, int idRegione, String titoloStudio) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		CF = cF;
		this.email = email;
		this.telefono = telefono;
		this.citta = citta;
		this.via = via;
		this.cap = cap;
		this.idRegione = idRegione;
		this.titoloStudio = titoloStudio;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public String getCF() {
		return CF;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCitta() {
		return citta;
	}

	public String getVia() {
		return via;
	}

	public String getCap() {
		return cap;
	}

	public int getIdRegione() {
		return idRegione;
	}

	public String getTitoloStudio() {
		return titoloStudio;
	}

	@Override
	public String toString() {
		
		return "\nStudent [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", CF=" + CF + ", email=" + email + ", telefono=" + telefono + ", citta =" + citta + ", via=" + via
				+ ", cap=" + cap + ", idRegione=" + idRegione + ", titoloStudio=" + titoloStudio + "]";
	}
	
	
	
	

}
