package br.univille.poo.app.persistencia;

import br.univille.poo.app.entidade.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO extends BaseDAO{

    public void inserir(Tarefa tarefa) {
        String sql = "insert into tarefa(descricao, concluido) values(? ,?)";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setString(1,tarefa.getDescricao());
            p.setBoolean(2,tarefa.isConcluido());
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao inserir tarefa ");
            e.printStackTrace();
        }
    }

    public void atualizar(Integer idTarefa) {
        String sql = "update tarefa set concluido = true where id = ?";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setInt(1,idTarefa);
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao inserir tarefa ");
            e.printStackTrace();
        }
    }

    public void priorizar(Integer idTarefa, String nvlPriori) {
        String sql = "update tarefa set prioridade = ? where id = ?";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setString(1,nvlPriori);
            p.setInt(2,idTarefa);
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao inserir tarefa ");
            e.printStackTrace();
        }
    }

    public List<Tarefa> obterTodos() {
        List<Tarefa> lista = new ArrayList<>();
        String sql = "select id, descricao, concluido, prioridade from tarefa";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){

            ResultSet resultSet = p.executeQuery();
            while(resultSet.next()){
                Tarefa tarefa = new Tarefa();
                tarefa.setId(resultSet.getInt("id"));
                tarefa.setConcluido(resultSet.getBoolean("concluido"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setPrioridade(resultSet.getString("prioridade"));

                lista.add(tarefa);
            }
        }catch (SQLException e){
            System.out.println("Erro ao obter todas as tarefas ");
            e.printStackTrace();
        }
        return lista;
    }

}
