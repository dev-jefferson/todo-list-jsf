package br.com.jhsgdev.VO;

import java.io.Serializable;
import java.util.Date;

public class TodoVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nome;
	private Date createdAt;
	private Date updatedAt;
	private Boolean concluido;
	
	
	public TodoVO() {
		super();
	}
	public TodoVO(Integer id, String nome, Date createdAt, Date updatedAt, Boolean concluido) {
		super();
		this.id = id;
		this.nome = nome;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.concluido = concluido;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Boolean getConcluido() {
		return concluido;
	}
	public void setConcluido(Boolean concluido) {
		this.concluido = concluido;		
	}
	
}

