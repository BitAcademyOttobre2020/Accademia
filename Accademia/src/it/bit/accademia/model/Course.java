package it.bit.accademia.model;

public class Course {
	
	private int id;
	private String nomeCorso;
	private int idAulaPref;
	private int capienza;
	private int iscrizioneMin;
	private boolean finanziato;
	private int idAzienda;
	
	public Course(int id, String nomeCorso, int idAulaPref, int capienza, int iscrizioneMin, boolean finanziato,
			int idAzienda) {
		super();
		this.id = id;
		this.nomeCorso = nomeCorso;
		this.idAulaPref = idAulaPref;
		this.capienza = capienza;
		this.iscrizioneMin = iscrizioneMin;
		this.finanziato = finanziato;
		this.idAzienda = idAzienda;
	}
	
	public Course() {}

	public int getId() {
		return id;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public int getIdAulaPref() {
		return idAulaPref;
	}

	public int getCapienza() {
		return capienza;
	}

	public int getIscrizioneMin() {
		return iscrizioneMin;
	}

	public boolean isFinanziato() {
		return finanziato;
	}

	public int getIdAzienda() {
		return idAzienda;
	}
	
	
	
	
}
