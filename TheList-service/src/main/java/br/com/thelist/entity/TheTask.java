package br.com.thelist.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="task")
public class TheTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="task", nullable = false, length=255)
	@NotBlank
	private String task;
	
	@Column(name="startdate",nullable = false, length=15)
	@NotBlank
	private String startDate;
	
	@Column(name="deadline",nullable = true, length=15)
	@NotBlank
	private String deadline;
	
	@ManyToOne
	@JoinColumn(name="id_list", referencedColumnName = "id")
	private TheList theList;
	

	public TheTask(Long id, String task, String startDate, String deadline, TheList theList) {
		this.id = id;
		this.task = task;
		this.startDate = startDate;
		this.deadline = deadline;
		this.theList = theList;
	}

	public TheTask() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public TheList getTheList() {
		return theList;
	}

	public void setTheList(TheList theList) {
		this.theList = theList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(deadline, id, startDate, task, theList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheTask other = (TheTask) obj;
		return Objects.equals(deadline, other.deadline) && Objects.equals(id, other.id)
				&& Objects.equals(startDate, other.startDate) && Objects.equals(task, other.task)
				&& Objects.equals(theList, other.theList);
	}
	
}
