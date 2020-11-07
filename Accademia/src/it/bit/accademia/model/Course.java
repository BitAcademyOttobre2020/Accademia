package it.bit.accademia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="corsi")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nome_corso")
	private String nomeCorso;
	
	@Column(name="capienza")
	private int capienza;
	
	@Column(name="iscrizioni_min")
	private int iscrizioniMin;
	
	@Column(name="finanziato")
	private boolean finanziato;
	
	@ManyToOne
	@JoinColumn(name="id_azienda")
	private Azienda azienda;
	
	@OneToMany(mappedBy="corso",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Iscrizione> iscrizioni;
	
	@ManyToOne
	@JoinColumn(name="id_aula_pref")
	private Aula aulaPreferita;
	
	public Course(int id, String nomeCorso, int capienza, int iscrizioneMin, boolean finanziato) {
		super();
		this.id = id;
		this.nomeCorso = nomeCorso;
		this.capienza = capienza;
		this.iscrizioniMin = iscrizioneMin;
		this.finanziato = finanziato;
	}
	
	public Course() {}

	public int getId() {
		return id;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}


	public int getCapienza() {
		return capienza;
	}

	public int getIscrizioneMin() {
		return iscrizioniMin;
	}

	public boolean isFinanziato() {
		return finanziato;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	public Aula getAulaPreferita() {
		return aulaPreferita;
	}

	public void setAulaPreferita(Aula aulaPreferita) {
		this.aulaPreferita = aulaPreferita;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public void setIscrizioniMin(int iscrizioniMin) {
		this.iscrizioniMin = iscrizioniMin;
	}

	public void setFinanziato(boolean finanziato) {
		this.finanziato = finanziato;
	}

	public void setIscrizioni(List<Iscrizione> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}

	public int getIscrizioniMin() {
		return iscrizioniMin;
	}

	public List<Iscrizione> getIscrizioni() {
		return iscrizioni;
	}
	
	
	
	
}
