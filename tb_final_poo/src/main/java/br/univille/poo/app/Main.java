package br.univille.poo.app;

import java.util.Scanner;

import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.persistencia.CriarTabelas;
import br.univille.poo.app.servico.ConcluirTarefa;
import br.univille.poo.app.view.CadastroTarefa;
import br.univille.poo.app.view.TaskView;

public class Main {

  public static void main(String[] args) {

    CriarTabelas.criarTabelas();
    new CadastroTarefa();
  }
}
