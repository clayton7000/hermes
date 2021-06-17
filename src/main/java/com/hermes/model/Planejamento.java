package com.hermes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Planejamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
    @JoinColumn(name = "tipoGasto_id")
	private TipoGasto tipo;
	@Column(nullable = false)
	private double valor;
	@Column(nullable = false)
	private Date mes;
	@ManyToOne
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoGasto getTipo() {
		return tipo;
	}
	public void setTipo(TipoGasto tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getMes() {
		return mes;
	}
	public void setMes(Date mes) {
		this.mes = mes;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
