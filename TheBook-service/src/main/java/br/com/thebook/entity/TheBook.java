package br.com.thebook.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class TheBook implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="justamessage", nullable=false,length=255)
	private String justAMessage;

	public TheBook(Long id, String justAMessage) {
		this.id = id;
		this.justAMessage = justAMessage;
	}

	public TheBook() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJustAMessage() {
		return justAMessage;
	}

	public void setJustAMessage(String justAMessage) {
		this.justAMessage = justAMessage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, justAMessage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheBook other = (TheBook) obj;
		return Objects.equals(id, other.id) && Objects.equals(justAMessage, other.justAMessage);
	}
	
}