package it.bit.accademia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aula")
public class Aula {
	@Id
	private int id;
	private String nome;
	private String capienza;
	private String virtuale;
	@Column(name="id_software")
	private Integer idSoftware;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCapienza() {
		return capienza;
	}
	public void setCapienza(String capienza) {
		this.capienza = capienza;
	}
	public String getVirtuale() {
		return virtuale;
	}
	public void setVirtuale(String virtuale) {
		this.virtuale = virtuale;
	}
	public Integer getIdSoftware() {
		return idSoftware;
	}
	public void setIdSoftware(Integer idSoftware) {
		this.idSoftware = idSoftware;
	}
	
}
