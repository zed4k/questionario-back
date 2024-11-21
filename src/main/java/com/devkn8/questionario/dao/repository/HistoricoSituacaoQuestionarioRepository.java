package com.devkn8.questionario.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devkn8.questionario.entity.HistoricoSituacaoQuestionario;
import com.devkn8.questionario.entity.HistoricoSituacaoQuestionarioID;

public interface HistoricoSituacaoQuestionarioRepository
		extends JpaRepository<HistoricoSituacaoQuestionario, HistoricoSituacaoQuestionarioID> {

}
