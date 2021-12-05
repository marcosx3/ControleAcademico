package com.br.Academia.controllers;

import com.br.Academia.dao.AlunosDAO;
import com.br.Academia.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlunoController {
        @Autowired
    private AlunosDAO alunosrepositorio;

    @GetMapping("/inserirAlunos")
    public ModelAndView InsertAlunos(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/formAluno");
        mv.addObject("aluno",new Aluno());
        return mv;
    }
    @PostMapping("CadastrarAluno")
    public ModelAndView CadastroAluno(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/lista-alunos");
        alunosrepositorio.save(aluno);
        return mv;
    }

    @GetMapping("/lista-alunos")
    public ModelAndView listaAlunos(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/listAlunos");
        mv.addObject("alunosLista",alunosrepositorio.findAll());
        return mv;
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/alterar");
        Aluno aluno = alunosrepositorio.getOne(id);
        mv.addObject("aluno",aluno);
        return  mv;
    }
    @PostMapping("alterar")
    public ModelAndView alterar(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        alunosrepositorio.save(aluno);
        mv.setViewName("redirect:/lista-alunos");
        return mv;
    }
    @GetMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable("id") Integer id){
        alunosrepositorio.deleteById(id);
        return "redirect:/lista-alunos";
    }





}
