package br.univille.poo.app.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskView extends JFrame {
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel descriptionLabel;
	private JTextArea descriptionTextArea;
	private JButton createTaskButton;
	private JButton updateTaskButton;
	private JButton deleteTaskButton;
	private JButton doneTaskButton;

	public TaskView() {
        this.setLayout(new FlowLayout());
		this.setSize(400, 300);
		this.setTitle("Task Manager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		nameLabel = new JLabel("Name");
		this.add(nameLabel);

		nameTextField = new JTextField(20);
		this.add(nameTextField);

		createTaskButton = new JButton("Create Task");
		this.add(createTaskButton);

		updateTaskButton = new JButton("Update Task");
		this.add(updateTaskButton);

		deleteTaskButton = new JButton("Delete Task");
		this.add(deleteTaskButton);

		doneTaskButton = new JButton("Done Task");
		this.add(doneTaskButton);

		this.setVisible(true);



	}

	public void addCreateTaskListener(ActionListener createTaskListener) {
		createTaskButton.addActionListener(createTaskListener);
	}

	public void addUpdateTaskListener(ActionListener updateTaskListener) {
		updateTaskButton.addActionListener(updateTaskListener);
	}

	public void addDeleteTaskListener(ActionListener deleteTaskListener) {
		deleteTaskButton.addActionListener(deleteTaskListener);
	}

	public void addDoneTaskListener(ActionListener doneTaskListener) {
		doneTaskButton.addActionListener(doneTaskListener);
	}

	public String getName() {
		return nameTextField.getText();
	}

	public String getDescription() {
		return descriptionTextArea.getText();
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}