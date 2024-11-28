package com.devkn8.questionario.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devkn8.questionario.dao.repository.GrupoItemRepository;
import com.devkn8.questionario.dao.repository.GrupoSubitemRepository;
import com.devkn8.questionario.dao.repository.HistoricoSituacaoQuestionarioRepository;
import com.devkn8.questionario.dao.repository.ItemRepository;
import com.devkn8.questionario.dao.repository.QuestionarioRepository;
import com.devkn8.questionario.dao.repository.SubitemRepository;
import com.devkn8.questionario.entity.GrupoItem;
import com.devkn8.questionario.entity.GrupoSubitem;
import com.devkn8.questionario.entity.HistoricoSituacaoQuestionario;
import com.devkn8.questionario.entity.Item;
import com.devkn8.questionario.entity.Questionario;
import com.devkn8.questionario.entity.Subitem;

@Repository
public class QuestionarioDAO {

	@Autowired
	private QuestionarioRepository					questionarioRepo;

	@Autowired
	private GrupoItemRepository						grupoItemRepo;
	
	@Autowired
	private ItemRepository							itemRepo;
	
	@Autowired
	private GrupoSubitemRepository					grupoSubitemRepo;
	
	@Autowired
	private SubitemRepository						subitemRepo;

	@Autowired
	private HistoricoSituacaoQuestionarioRepository	historicoSituacaoQuestionarioRepository;

	/**
	 * @return
	 */
	public List<Questionario> listarQuestionarios() {
		return questionarioRepo.findAll();
	}

	/**
	 * @param codigo
	 * @return
	 */
	public Questionario buscarQuestionario(Integer codigo) {
		return questionarioRepo.findById(codigo).orElse(null);
	}

	/**
	 * @param questionario
	 * @return
	 */
	public Questionario salvarQuestionario(Questionario questionario) {
		return questionarioRepo.save(questionario);
	}

	/**
	 * @param codigo
	 */
	public void deletarQuestionario(Integer codigo) {
		questionarioRepo.deleteById(codigo);
	};

	/**
	 * @param hst
	 * @return
	 */
	public HistoricoSituacaoQuestionario salvarSituacaoQuestionarioRepository(HistoricoSituacaoQuestionario hst) {
		return historicoSituacaoQuestionarioRepository.save(hst);
	}

	/**
	 * @param grupoItem
	 * @return
	 */
	public GrupoItem salvarGrupoItem(GrupoItem grupoItem) {
		return grupoItemRepo.save(grupoItem);
	}

	/**
	 * @param item
	 * @return
	 */
	public Item salvarItem(Item item) {
		return itemRepo.save(item);
	}

	/**
	 * @param grupoSubitem
	 * @return
	 */
	public GrupoSubitem salvarGrupoSubitem(GrupoSubitem grupoSubitem) {
		return grupoSubitemRepo.save(grupoSubitem);
	}

	/**
	 * @param subitem
	 * @return
	 */
	public Subitem salvarSubitem(Subitem subitem) {
		return subitemRepo.save(subitem);
	}

	/**
	 * @param codigo
	 * @return
	 */
	public GrupoItem buscarGrupoItem(Integer codigo) {
		return grupoItemRepo.findById(codigo).orElse(null);
	}
	
	/**
	 * @param codigo
	 * @return
	 */
	public Item buscarItem(Integer codigo) {
		return itemRepo.findById(codigo).orElse(null);
	}

	/**
	 * @param codigo
	 * @return
	 */
	public GrupoSubitem buscarGrupoSubitem(Integer codigo) {
		return grupoSubitemRepo.findById(codigo).orElse(null);
	}
	
	/**
	 * @param codigo
	 * @return
	 */
	public Subitem buscarSubitem(Integer codigo) {
		return subitemRepo.findById(codigo).orElse(null);
	}
}
