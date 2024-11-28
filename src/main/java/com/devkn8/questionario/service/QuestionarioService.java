package com.devkn8.questionario.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkn8.questionario.dao.QuestionarioDAO;
import com.devkn8.questionario.entity.GrupoItem;
import com.devkn8.questionario.entity.GrupoSubitem;
import com.devkn8.questionario.entity.HistoricoSituacaoQuestionario;
import com.devkn8.questionario.entity.Item;
import com.devkn8.questionario.entity.Questionario;
import com.devkn8.questionario.entity.Subitem;
import com.devkn8.questionario.entity.dto.GrupoItemDTO;
import com.devkn8.questionario.entity.dto.GrupoSubitemDTO;
import com.devkn8.questionario.entity.dto.ItemDTO;
import com.devkn8.questionario.entity.dto.QuestionarioDTO;
import com.devkn8.questionario.entity.dto.SubitemDTO;
import com.devkn8.questionario.enums.SituacaoQuestionarioEnum;
import com.devkn8.questionario.enums.TipoQuestionarioEnum;
import com.devkn8.questionario.utils.Envelope;
import com.devkn8.questionario.utils.QuestionarioUtils;

import jakarta.transaction.Transactional;

@Service
public class QuestionarioService {

	@Autowired
	private QuestionarioDAO		dao;

	@Autowired
	private QuestionarioUtils	utils;

	/**
	 * @return
	 */
	public Envelope<List<QuestionarioDTO>> listarQuestionarios() {
		List<Questionario> lista = dao.listarQuestionarios();

		if (lista == null || lista.isEmpty()) {
			return new Envelope<>(null, "Nenhum questionário encontrado", false);
		}

		List<QuestionarioDTO> DTOs = lista.stream()
				.map(q -> utils.buildQuestionarioDTO(q, true, true, true, true))
				.toList();

		return new Envelope<>(DTOs);
	}

	/**
	 * @param qr
	 * @return
	 */
	@Transactional
	public Envelope<Integer> incluirQuestionario(QuestionarioDTO qr) {
		Questionario q = utils.buildQuestionario(qr);
		q.setSituacao(SituacaoQuestionarioEnum.EDICAO);
		q.setTipo(TipoQuestionarioEnum.PADRAO);

		q = dao.salvarQuestionario(q);
		incluirHistoricoSituacaoQuestionario(q.getCodigoQuestionario(), SituacaoQuestionarioEnum.EDICAO);

		return new Envelope<Integer>(q.getCodigoQuestionario());
	}


	/**
	 * @param codigo
	 * @return
	 */
	public Envelope<QuestionarioDTO> buscarQuestionarioDTO(Integer codigo) {
		Questionario q = buscarQuestionarioEntity(codigo);

		if (q == null) {
			return new Envelope<>(null, "Questionário não encontrado com o código " + codigo, false);
		}

		return new Envelope<>(utils.buildQuestionarioDTO(q,
				true,
				true,
				true,
				true));
	}

	/**
	 * @param gir
	 * @return
	 */
	@Transactional
	public Envelope<Integer> incluirGrupoItem(GrupoItemDTO gir) {
		GrupoItem grupoItem = utils.buildGrupoItem(gir);
		grupoItem = dao.salvarGrupoItem(grupoItem);

		return new Envelope<>(grupoItem.getCodigoGrupo());
	}
	
	/**
	 * @param codigo
	 * @return
	 */
	public Envelope<GrupoItemDTO> buscarGrupoItemDTO(Integer codigo) {
        GrupoItem grupoItem = dao.buscarGrupoItem(codigo);
        
        if (grupoItem == null) {
            return new Envelope<>(null, "Grupo de item não encontrado com o código " + codigo, false);
        }
        
        return new Envelope<>(utils.buildGrupoItemDTO(grupoItem, true, true));
	}
	
	/**
	 * @param ir
	 * @return
	 */
	@Transactional 
	public Envelope<Integer> incluirItem(ItemDTO ir) {
		Item item = utils.buildItem(ir);
		item = dao.salvarItem(item);
		
		return new Envelope<>(item.getCodigoItem());
	}
	
	/**
	 * @param codigo
	 * @return
	 */
	public Envelope<ItemDTO> buscarItemDTO(Integer codigo) {
		Item item = dao.buscarItem(codigo);

		if (item == null) {
			return new Envelope<>(null, "Item não encontrado com o código " + codigo, false);
		}

		return new Envelope<>(utils.buildItemDTO(item, true));
	}

	/**
	 * @param gsir
	 * @return
	 */
	@Transactional
	public Envelope<Integer> incluirGrupoSutitem(GrupoSubitemDTO gsir) {
		GrupoSubitem grupoSubitem = utils.buildGrupoSubitem(gsir);
		grupoSubitem =  dao.salvarGrupoSubitem(grupoSubitem);

		return new Envelope<>(grupoSubitem.getCodigoGrupoSubitem());
	}
	

	/**
	 * @param sir
	 * @return
	 */
	@Transactional
	public Envelope<Integer> incluirSubItem(SubitemDTO sir) {
		Subitem subitem = utils.buildSubitem(sir);
		subitem = dao.salvarSubitem(subitem);
		
		return new Envelope<>(subitem.getCodigoSubitem());
	}
	

	/**
	 * @param codigoQuestionario
	 * @param situacao
	 */
	@Transactional
	public void incluirHistoricoSituacaoQuestionario(Integer codigoQuestionario,
			SituacaoQuestionarioEnum situacao) {
		HistoricoSituacaoQuestionario hst = new HistoricoSituacaoQuestionario();
		hst.setCodigoQuestionario(codigoQuestionario);
		hst.setCodigoSituacao(situacao != null ? situacao.codigo : SituacaoQuestionarioEnum.INDEFINIDO.codigo);
		hst.setInicio(LocalDateTime.now());
		hst.setCodigoUsuario(6666);
		dao.salvarSituacaoQuestionarioRepository(hst);
	}

	/**
	 * @param codigo
	 * @return
	 */
	public Questionario buscarQuestionarioEntity(Integer codigo) {
		return dao.buscarQuestionario(codigo);
	}
}
