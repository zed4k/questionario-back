package com.devkn8.questionario.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devkn8.questionario.entity.Questionario;

public interface QuestionarioRepository extends JpaRepository<Questionario, Integer> {

}
