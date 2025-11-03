package br.edu.ifpr.agenda.view;

import br.edu.ifpr.agenda.controller.ContatoController;
import br.edu.ifpr.agenda.model.Contato;
import br.edu.ifpr.agenda.model.Endereco;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testando...");
        Contato contato = new Contato();
        Endereco endereco = new Endereco();
        ContatoController contatoController = new ContatoController();
        
        endereco.setRua("Rua Guaíba");
        endereco.setNumero("340");
        endereco.setCidade("Cascavel");
        endereco.setEstado("Paraná");

        contato.setNome("Enedir");
        contato.setCelular("(45)99912-3130");
        contato.setEmail("enedir@gmail.com");
        contato.setEndereco(endereco);
        contatoController.cadastrarContato(contato);
    }
}