package com.hermes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 30,nullable = false)
	private String nome;
	@ManyToOne
    @JoinColumn(name = "tipoGasto_id")
	private TipoGasto tipo;
	@Column(nullable = false)
	private double valor;
	@Column(length = 100)
	private String descricao;
	@Column(nullable = false)
	private Date dia;
	public TipoGasto getTipo() {
		return tipo;
	}
	public void setTipo(TipoGasto tipo) {
		this.tipo = tipo;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@ManyToOne
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;
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
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	
	
}
