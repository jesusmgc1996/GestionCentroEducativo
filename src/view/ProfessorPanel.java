package view;

import javax.swing.JPanel;

import controller.ProfessorController;
import model.Professor;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfessorPanel extends JPanel {

	private JTextField jtfId;
	private JTextField jtfName;
	private JTextField jtfFirstSurname;
	private JTextField jtfSecondSurname;
	private JTextField jtfDni;
	private JTextField jtfAddress;
	private JTextField jtfEmail;
	private JTextField jtfPhone;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JPanel panel;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnSave;
	private JButton btnNew;
	private JButton btnDelete;

	/**
	 * Crea el panel
	 */
	public ProfessorPanel() {

		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		lblNewLabel_2 = new JLabel("Gestión de profesores");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(15, 15, 15, 15);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("ID:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.weightx = 1.0;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		jtfId.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfName = new JTextField();
		GridBagConstraints gbc_jtfDescription = new GridBagConstraints();
		gbc_jtfDescription.weightx = 1.0;
		gbc_jtfDescription.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescription.gridx = 1;
		gbc_jtfDescription.gridy = 2;
		add(jtfName, gbc_jtfDescription);
		jtfName.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Primer apellido:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfFirstSurname = new JTextField();
		GridBagConstraints gbc_jtfFirstSurname = new GridBagConstraints();
		gbc_jtfFirstSurname.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFirstSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFirstSurname.gridx = 1;
		gbc_jtfFirstSurname.gridy = 3;
		add(jtfFirstSurname, gbc_jtfFirstSurname);
		jtfFirstSurname.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Segundo apellido:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfSecondSurname = new JTextField();
		GridBagConstraints gbc_jtfSecondSurname = new GridBagConstraints();
		gbc_jtfSecondSurname.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSecondSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSecondSurname.gridx = 1;
		gbc_jtfSecondSurname.gridy = 4;
		add(jtfSecondSurname, gbc_jtfSecondSurname);
		jtfSecondSurname.setColumns(10);
		
		lblNewLabel_5 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfAddress = new JTextField();
		GridBagConstraints gbc_jtfAddress = new GridBagConstraints();
		gbc_jtfAddress.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAddress.gridx = 1;
		gbc_jtfAddress.gridy = 6;
		add(jtfAddress, gbc_jtfAddress);
		jtfAddress.setColumns(10);
		
		lblNewLabel_7 = new JLabel("E-mail:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Teléfono");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfPhone = new JTextField();
		GridBagConstraints gbc_jtfPhone = new GridBagConstraints();
		gbc_jtfPhone.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPhone.gridx = 1;
		gbc_jtfPhone.gridy = 8;
		add(jtfPhone, gbc_jtfPhone);
		jtfPhone.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 9;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnFirst = new JButton("<<");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(ProfessorController.getFirst());
			}
		});
		panel.add(btnFirst);
		
		btnPrevious = new JButton("<");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(ProfessorController.getPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnPrevious);
		
		btnNext = new JButton(">");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(ProfessorController.getNext(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnNext);
		
		btnLast = new JButton(">>");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(ProfessorController.getLast());
			}
		});
		panel.add(btnLast);
		
		btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveRecord();
			}
		});
		panel.add(btnSave);
		
		btnNew = new JButton("Nuevo");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearData();
			}
		});
		panel.add(btnNew);
		
		btnDelete = new JButton("Eliminar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRecord();
			}
		});
		panel.add(btnDelete);

		loadRecord(ProfessorController.getFirst());
	}
	
	/**
	 * Método para cargar un registro
	 */
	private void loadRecord(Professor p) {
		if (p != null) {
			jtfId.setText("" + p.getId());
			jtfName.setText(p.getName());
			jtfFirstSurname.setText(p.getFirstSurname());
			jtfSecondSurname.setText(p.getSecondSurname());
			jtfDni.setText(p.getDni());
			jtfAddress.setText(p.getAddress());
			jtfEmail.setText(p.getEmail());
			jtfPhone.setText(p.getPhone());
		}
		if (ProfessorController.getPrevious(Integer.parseInt(jtfId.getText())) == null) {
			btnFirst.setEnabled(false);
			btnPrevious.setEnabled(false);
		}
		else {
			btnFirst.setEnabled(true);
			btnPrevious.setEnabled(true);
		}
		if (ProfessorController.getNext(Integer.parseInt(jtfId.getText())) == null) {
			btnLast.setEnabled(false);
			btnNext.setEnabled(false);
		}
		else {
			btnLast.setEnabled(true);
			btnNext.setEnabled(true);
		}
	}
	
	/**
	 * Método para guardar un registro
	 */
	private void saveRecord() {
		Professor p = new Professor();
		p.setId(Integer.parseInt(jtfId.getText()));
		p.setName(jtfName.getText());
		p.setFirstSurname(jtfFirstSurname.getText());
		p.setSecondSurname(jtfSecondSurname.getText());
		p.setDni(jtfDni.getText());
		p.setAddress(jtfAddress.getText());
		p.setEmail(jtfEmail.getText());
		p.setPhone(jtfPhone.getText());
		String error = "No se ha podido guardar";
		if (p.getId() == 0) {
			int id = ProfessorController.insert(p);
			if (id < 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			else {
				jtfId.setText("" + id);
				SubjectAssessmentPanel.getProfessors();
			}
		}
		else {
			if (ProfessorController.update(p) != 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			else {
				SubjectAssessmentPanel.getProfessors();
			}
		}
	}
	
	/**
	 * Método para limpiar los datos
	 */
	private void clearData() {
		jtfId.setText("0");
		jtfName.setText("");
		jtfFirstSurname.setText("");
		jtfSecondSurname.setText("");
		jtfDni.setText("");
		jtfAddress.setText("");
		jtfEmail.setText("");
		jtfPhone.setText("");
	}
	
	/**
	 * Método para eliminar un registro
	 */
	private void deleteRecord() {
		if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?") == JOptionPane.YES_OPTION) {
			int id = Integer.parseInt(jtfId.getText());
			if (ProfessorController.delete(id) != 1) {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar");
			}
			else {
				Professor p = ProfessorController.getPrevious(id);
				if (p != null) {
					loadRecord(p);
				}
				else {
					p = ProfessorController.getNext(id);
					if (p != null) {
						loadRecord(p);
					}
					else {
						clearData();
					}
				}
				SubjectAssessmentPanel.getProfessors();
			}
		}
	}
	
}
