package it.bit.accademia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Studenti")
public class Student {
	
	@Id
	@Column(name="id")
	private int id; 
	
	@Column(name="nome")
	private String nome; 
	
	@Column(name="cognome")
	private String cognome; 
	
	@Column(name="data_di_nascita")
	private String dataDiNascita; 
	
	@Column(name="CF")
	private String CF;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="citta")
	private String citta;
	
	@Column(name="via")
	private String via;
	
	@Column(name="cap")
	private String cap;
	
	@Column(name="id_regione")
	private int idRegione;
	
	@Column(name="titolo_studio")
	private String titoloStudio;
	
	@OneToMany(mappedBy="studente",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Iscrizione> iscrizioni = new ArrayList<Iscrizione>();	
	
	public Student() {}
	
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

	public boolean fullEquals(Student other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (CF == null) {
			if (other.CF != null)
				return false;
		} else if (!CF.equals(other.CF))
			return false;
		if (cap == null) {
			if (other.cap != null)
				return false;
		} else if (!cap.equals(other.cap))
			return false;
		if (citta == null) {
			if (other.citta != null)
				return false;
		} else if (!citta.equals(other.citta))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataDiNascita == null) {
			if (other.dataDiNascita != null)
				return false;
		} else if (!dataDiNascita.equals(other.dataDiNascita))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (idRegione != other.idRegione)
			return false;
		if (iscrizioni == null) {
			if (other.iscrizioni != null)
				return false;
		} else if (!iscrizioni.equals(other.iscrizioni))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (titoloStudio == null) {
			if (other.titoloStudio != null)
				return false;
		} else if (!titoloStudio.equals(other.titoloStudio))
			return false;
		if (via == null) {
			if (other.via != null)
				return false;
		} else if (!via.equals(other.via))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nStudent [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", CF=" + CF + ", email=" + email + ", telefono=" + telefono + ", citta =" + citta + ", via=" + via
				+ ", cap=" + cap + ", idRegione=" + idRegione + ", titoloStudio=" + titoloStudio + "]";
	}

	public List<Iscrizione> getIscrizioni() {
		return iscrizioni;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public void setCF(String cF) {
		CF = cF;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public void setIdRegione(int idRegione) {
		this.idRegione = idRegione;
	}

	public void setTitoloStudio(String titoloStudio) {
		this.titoloStudio = titoloStudio;
	}

	public void setIscrizioni(List<Iscrizione> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}
	
}
