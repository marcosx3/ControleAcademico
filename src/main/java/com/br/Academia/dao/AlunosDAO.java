package com.br.Academia.dao;

import com.br.Academia.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AlunosDAO extends JpaRepository<Aluno,Integer> {


}
