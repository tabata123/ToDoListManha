package br.senai.sp.modelo;

import java.util.List;


public class Tarefa {
	private Long id;
	private String titulo;
	private List<SubTarefa> subTarefas;
	
	// Percorrer as tarefas para verificar se está realizada ou não !!
	
	public boolean isRealizada() {
		for(SubTarefa subTarefa : subTarefas) {
			if(!subTarefa.isFeita()) {
				return false;
			}
		}
		return true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<SubTarefa> getSubTarefas() {
		return subTarefas;
	}
	public void setSubTarefas(List<SubTarefa> subTarefas) {
		this.subTarefas = subTarefas;
	}
	
	

}
