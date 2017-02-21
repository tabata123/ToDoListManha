package br.senai.sp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.sp.modelo.SubTarefa;
import br.senai.sp.modelo.Tarefa;

@Repository
public class SubtarefaDao {
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void criarSubTarefa(Long idTarefa, SubTarefa subtarefa) {
		subtarefa.setTarefa(manager.find(Tarefa.class, idTarefa));
		manager.persist(subtarefa);
	}
	
	public SubTarefa buscarSubtarefa(Long id) {	
		return manager.find(SubTarefa.class, id);
	}
	
	@Transactional
	public void marcarFeita(Long idSubtarefa, boolean valor){
		/*Merge e Persist atualiza dados no banco
		 *Merge -> atualiza o objeto offline(a qualquer momento) 
		 *Persist -> atualiza somente online com o hibernate*/
		SubTarefa subtarefa = buscarSubtarefa(idSubtarefa);
		subtarefa.setFeita(valor);
		manager.merge(subtarefa);
	}
	
	
	@Transactional
	public void excluir(Long idSubtarefa) {
		SubTarefa subtarefa = buscarSubtarefa(idSubtarefa);
		Tarefa tarefa = subtarefa.getTarefa();
		tarefa.getSubTarefas().remove(subtarefa);
		manager.merge(tarefa);
	}

}
