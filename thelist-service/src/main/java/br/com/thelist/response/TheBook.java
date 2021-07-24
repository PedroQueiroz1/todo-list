package br.com.thelist.response;

import java.io.Serializable;
import java.util.Objects;

public class TheBook implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String justAMessage;
	
	
	public TheBook() {
	}
	public TheBook(Long id, String justAMessage) {
		this.id = id;
		this.justAMessage = justAMessage;
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
