package br.com.consignum.colaboradores.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public abstract class Controller implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean modoVisualizacao;

	private boolean modoInclusao;

	private boolean modoAlteracao;

	private boolean modoExclusao;
	
	public abstract Serializable getId();

	public void setModoVisualizacao() {
		this.modoVisualizacao = true;
		this.modoInclusao = false;
		this.modoAlteracao = false;
		this.modoExclusao = false;
	}

	public boolean isModoVisualizacao() {
		return modoVisualizacao;
	}

	public void setModoAlteracao() {
		this.modoVisualizacao = false;
		this.modoInclusao = false;
		this.modoAlteracao = true;
		this.modoExclusao = false;
	}

	public boolean isModoAlteracao() {
		return modoAlteracao;
	}

	public void setModoExclusao() {
		this.modoVisualizacao = true;
		this.modoInclusao = false;
		this.modoAlteracao = false;
		this.modoExclusao = true;
	}

	public boolean isModoExclusao() {
		return modoExclusao;
	}

	public void setModoInclusao() {
		this.modoVisualizacao = false;
		this.modoInclusao = true;
		this.modoAlteracao = false;
		this.modoExclusao = false;
	}

	public boolean isModoInclusao() {
		return modoInclusao;
	}
	
	public String getModoDesc() {
		return getId()==null ? "Incluir " : isModoExclusao() ? "Excluir " : isModoVisualizacao() ? "Visualizar " : "Alterar ";
	}
	public String getModoIcon() {
		return getId()==null ? "fa fa-plus " : isModoExclusao() ? "fa fa-trash " : isModoVisualizacao() ? "fa fa-file-text " : "fa fa-edit";
	}

	public void addInfoMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, "PrimeFaces Rocks."));

	}

	public void addErrorMessage(String message) {
		RequestContext.getCurrentInstance().addCallbackParam("validationFailed", true);
		RequestContext.getCurrentInstance().execute("scrollPopupUp();");
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, message, "PrimeFaces Rocks."));

	}
}
