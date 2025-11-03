package br.edu.ifpr.agenda.controller;

import br.edu.ifpr.agenda.model.Contato;
import br.edu.ifpr.agenda.model.dao.ContatoDAO;

public class ContatoController {
    private ContatoDAO dao;

    public ContatoController() {
        this.dao = new ContatoDAO();
    }

    public void cadastrarContato(Contato contato) {
        if(contato.getNome() == null || contato.getNome().isEmpty()) {
            System.out.println("Não pode ser vazio!");
            return;
        }
        dao.salvar(contato);
    }

    public void cadastrarContatoSemEndereco(Contato contato) {
        if(contato.getNome() == null || contato.getNome().isEmpty()) {
            System.out.println("Não pode ser vazio!");
            return;
        }
        dao.salvarSemEndereco(contato);
    }
}
