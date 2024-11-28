package com.devkn8.questionario.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.devkn8.questionario.entity.GrupoItem;
import com.devkn8.questionario.entity.GrupoSubitem;
import com.devkn8.questionario.entity.Item;
import com.devkn8.questionario.entity.Questionario;
import com.devkn8.questionario.entity.Subitem;
import com.devkn8.questionario.entity.dto.GrupoItemDTO;
import com.devkn8.questionario.entity.dto.GrupoSubitemDTO;
import com.devkn8.questionario.entity.dto.HistoricoSituacaoQuestionarioDTO;
import com.devkn8.questionario.entity.dto.ItemDTO;
import com.devkn8.questionario.entity.dto.QuestionarioDTO;
import com.devkn8.questionario.entity.dto.SubitemDTO;

@Component
public class QuestionarioUtils {

	/**
	 * @param qr
	 * @return
	 */
	public Questionario buildQuestionario(QuestionarioDTO qr) {
		Questionario q = new Questionario();
		q.setCodigoQuestionario(qr.getCodigoQuestionario());
		q.setNomeQuestionario(qr.getNomeQuestionario());
		q.setCodigoTipoQuestionario(qr.getCodigoTipoQuestionario());
		q.setCodigoSituacao(qr.getCodigoSituacao());
		q.setInicioValidade(qr.getInicioValidade() != null ? qr.getInicioValidade() : LocalDateTime.now());
		q.setFimValidade(qr.getFimValidade());
		q.setObjetivo(qr.getObjetivo());
		q.setAjuda(qr.getAjuda());
		q.setDataRegistro(qr.getDataRegistro());
		return q;
	}

	/**
	 * @param q
	 * @return
	 */
	public QuestionarioDTO buildQuestionarioDTO(Questionario q,
			boolean buildHistorico,
			boolean buildGrupos,
			boolean buildItens,
			boolean buildGrupoSubitens) {
		String nomeTipo = q.getTipo() != null ? q.getTipo().getNome() : null;
		String nomeSituacao = q.getSituacao() != null ? q.getSituacao().getNome() : null;

		List<HistoricoSituacaoQuestionarioDTO> situacoes = null;
		List<GrupoItemDTO> grupos = null;

		if (buildHistorico) {
			situacoes = q.getSituacoes().stream()
					.map(h -> new HistoricoSituacaoQuestionarioDTO(h.getCodigoQuestionario(),
							h.getCodigoSituacao(),
							h.getInicio(),
							h.getFim(),
							h.getCodigoUsuario(),
							h.getSituacao().getNome()))
					.collect(Collectors.toList());
		}

		if (buildGrupos) {
			grupos = buildGruposItemDTO(q, buildItens, buildGrupoSubitens);
		}

		return new QuestionarioDTO(q.getCodigoQuestionario(),
				q.getNomeQuestionario(),
				q.getCodigoTipoQuestionario(),
				q.getCodigoSituacao(),
				q.getInicioValidade(),
				q.getFimValidade(),
				q.getObjetivo(),
				q.getAjuda(),
				q.getDataRegistro(),
				nomeTipo,
				nomeSituacao,
				situacoes,
				grupos);
	}

	/**
	 * @param q
	 * @return
	 */
	public List<GrupoItemDTO> buildGruposItemDTO(Questionario q,
			boolean buildItens,
			boolean buildGrupoSubitens) {

		if (q == null || q.getGruposItem() == null || q.getGruposItem().isEmpty()) {
			return null;
		}

		List<GrupoItemDTO> lista = new ArrayList<>();

		for (GrupoItem g : q.getGruposItem()) {
			lista.add(buildGrupoItemDTO(g, buildItens, buildGrupoSubitens));
		}

		return lista;
	}

	/**
	 * @param g
	 * @param buildItens
	 * @param buildGrupoSubitens
	 * @return
	 */
	public GrupoItemDTO buildGrupoItemDTO(GrupoItem g, boolean buildItens, boolean buildGrupoSubitens) {
		if (g == null) {
			return null;
		}

		List<ItemDTO> listaItens = null;

		if (buildItens) {
			listaItens = buildItensDTO(g, buildGrupoSubitens);
		}

		GrupoItemDTO gir = new GrupoItemDTO(g.getCodigoGrupo(),
				g.getCodigoQuestionario(),
				g.getOrdem(),
				g.getNomeGrupo(),
				g.getAjuda(),
				g.isEmUso(),
				listaItens);

		return gir;
	}

	/**
	 * @param g
	 * @param buildGrupoSubitens
	 * @return
	 */
	public List<ItemDTO> buildItensDTO(GrupoItem g, boolean buildGrupoSubitens) {
		if (g == null || g.getItens() == null || g.getItens().isEmpty()) {
			return null;
		}

		List<ItemDTO> lista = new ArrayList<>();

		for (Item i : g.getItens()) {
			lista.add(buildItemDTO(i, buildGrupoSubitens));
		}

		return lista;
	}

	/**
	 * @param i
	 * @param buildGrupoSubitens
	 * @return
	 */
	public ItemDTO buildItemDTO(Item i, boolean buildGrupoSubitens) {
		List<GrupoSubitemDTO> listaGrupoSubitens = null;

		if (buildGrupoSubitens) {
			listaGrupoSubitens = buildGrupoSubitemDTO(i);
		}

		ItemDTO ir = new ItemDTO(i.getCodigoItem(),
				i.getCodigoGrupo(),
				i.getOrdem(),
				i.getDescricaoItem(),
				i.getAjuda(),
				i.isEmUso(),
				listaGrupoSubitens);

		return ir;
	}

	/**
	 * @param i
	 * @return
	 */
	public List<GrupoSubitemDTO> buildGrupoSubitemDTO(Item i) {

		if (i == null || i.getGruposSubitem() == null || i.getGruposSubitem().isEmpty()) {
			return null;
		}

		List<GrupoSubitemDTO> lista = new ArrayList<>();

		for (GrupoSubitem gs : i.getGruposSubitem()) {

			List<SubitemDTO> listaSubitens = null;

			if (gs.getSubitens() != null && !gs.getSubitens().isEmpty()) {
				listaSubitens = gs.getSubitens().stream()
						.map(s -> new SubitemDTO(s.getCodigoSubitem(),
								s.getCodigoGrupoSubitem(),
								s.getOrdem(),
								s.getTextoSubitem(),
								s.getPontos()))
						.collect(Collectors.toList());
			}

			GrupoSubitemDTO gsr = new GrupoSubitemDTO(gs.getCodigoGrupoSubitem(),
					gs.getCodigoItem(),
					gs.getCodigoTipoGrupoSubitem(),
					gs.getOrdem(),
					gs.isEmUso(),
					gs.getTextoGrupoSubitem(),
					listaSubitens);

			lista.add(gsr);
		}

		return lista;
	}

	/**
	 * @param gir
	 * @return
	 */
	public GrupoItem buildGrupoItem(GrupoItemDTO gir) {
		GrupoItem gi = new GrupoItem();
		gi.setCodigoQuestionario(gir.getCodigoQuestionario());
		gi.setOrdem(gir.getOrdem());
		gi.setNomeGrupo(gir.getNomeGrupo());
		gi.setAjuda(gir.getAjuda());
		gi.setEmUso(gir.isEmUso());

		return gi;
	}

	/**
	 * @param ir
	 * @return
	 */
	public Item buildItem(ItemDTO ir) {
		Item i = new Item();
		i.setCodigoGrupo(ir.getCodigoGrupo());
		i.setOrdem(ir.getOrdem());
		i.setDescricaoItem(ir.getDescricaoItem());
		i.setAjuda(ir.getAjuda());
		i.setEmUso(ir.isEmUso());

		return i;
	}

	/**
	 * @param gsir
	 * @return
	 */
	public GrupoSubitem buildGrupoSubitem(GrupoSubitemDTO gsir) {
		GrupoSubitem gsi = new GrupoSubitem();
		gsi.setCodigoItem(gsir.getCodigoItem());
		gsi.setCodigoTipoGrupoSubitem(gsir.getCodigoTipoGrupoSubitem());
		gsi.setOrdem(gsir.getOrdem());
		gsi.setEmUso(gsir.isEmUso());
		gsi.setTextoGrupoSubitem(gsir.getTextoGrupoSubitem());

		return gsi;
	}

	/**
	 * @param sir
	 */
	public Subitem buildSubitem(SubitemDTO sir) {
		Subitem s = new Subitem();
		s.setCodigoGrupoSubitem(sir.getCodigoGrupoSubitem());
		s.setOrdem(sir.getOrdem());
		s.setTextoSubitem(sir.getTextoSubitem());
		s.setPontos(sir.getPontos());
		return s;
	}
}
