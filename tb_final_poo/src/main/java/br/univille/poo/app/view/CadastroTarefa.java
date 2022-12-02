package br.univille.poo.app.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.servico.CriarTarefa;

public class CadastroTarefa extends JFrame {

    private JLabel lblDescricao;
    private JLabel lblPrioridade;
    private JLabel lblFinalizado;
    private JTextField txtDescricao;
    private JComboBox comboPrioridade;
    private JCheckBox chkFinalizado;
    private JButton btnSalvar;
    private JButton btnCancelar;

    public CadastroTarefa() {
        setLayout(new FlowLayout());

        lblDescricao = new JLabel("Descrição da Tarefa: ");
        add(lblDescricao);

        txtDescricao = new JTextField(20);
        add(txtDescricao);

        lblPrioridade = new JLabel("Prioridade: ");
        add(lblPrioridade);

        comboPrioridade = new JComboBox();
        comboPrioridade.addItem("Alta");
        comboPrioridade.addItem("Média");
        comboPrioridade.addItem("Baixa");
        add(comboPrioridade);

        lblFinalizado = new JLabel("Finalizado: ");
        add(lblFinalizado);

        chkFinalizado = new JCheckBox();
        add(chkFinalizado);

        btnSalvar = new JButton("Salvar");
        add(btnSalvar);

        btnCancelar = new JButton("Cancelar");
        add(btnCancelar);

        setSize(300, 200);
        setVisible(true);



        btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                Tarefa task = new Tarefa();
                task.setDescricao(txtDescricao.getText());
                task.setPrioridade(comboPrioridade.getSelectedItem().toString());
                task.setConcluido(chkFinalizado.isSelected());
                CriarTarefa CT = new CriarTarefa();
                try {
                    CT.criar(task);
                    new CadastroTarefa(); 
                }catch (Exception ex) {
                    ex.printStackTrace();
                }

				new TaskView();
				setVisible(false);
			}
		});

        btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TaskView();
				setVisible(false);
			}
		});

    }

    public static void main(String[] args) {
        CadastroTarefa cadastroTarefa = new CadastroTarefa();
    }
}