package view;

import javax.swing.JPanel;

import controller.ProfessorController;
import model.Professor;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfessorPanel extends JPanel {

	private JLabel lblNewLabel;
	private JPanel panel;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnSave;
	private JButton btnNew;
	private JButton btnDelete;
	private PersonalInformationPanel personalInformation;

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
		
		lblNewLabel = new JLabel("Gestión de profesores");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(15, 15, 15, 15);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		personalInformation = new PersonalInformationPanel();
		GridBagConstraints gbc_personalInformation = new GridBagConstraints();
		gbc_personalInformation.fill = GridBagConstraints.HORIZONTAL;
		gbc_personalInformation.weightx = 1.0;
		gbc_personalInformation.gridwidth = 2;
		gbc_personalInformation.insets = new Insets(0, 0, 5, 0);
		gbc_personalInformation.gridx = 0;
		gbc_personalInformation.gridy = 1;
		add(personalInformation, gbc_personalInformation);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
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
				loadRecord(ProfessorController.getPrevious(personalInformation.getId()));
			}
		});
		panel.add(btnPrevious);
		
		btnNext = new JButton(">");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(ProfessorController.getNext(personalInformation.getId()));
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
			personalInformation.setId(p.getId());
			personalInformation.setName(p.getName());
			personalInformation.setFirstSurname(p.getFirstSurname());
			personalInformation.setSecondSurname(p.getSecondSurname());
			personalInformation.setDni(p.getDni());
			personalInformation.setAddress(p.getAddress());
			personalInformation.setEmail(p.getEmail());
			personalInformation.setPhone(p.getPhone());
		}
		if (ProfessorController.getPrevious(personalInformation.getId()) == null) {
			btnFirst.setEnabled(false);
			btnPrevious.setEnabled(false);
		}
		else {
			btnFirst.setEnabled(true);
			btnPrevious.setEnabled(true);
		}
		if (ProfessorController.getNext(personalInformation.getId()) == null) {
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
		p.setId(personalInformation.getId());
		p.setName(personalInformation.getName());
		p.setFirstSurname(personalInformation.getFirstSurname());
		p.setSecondSurname(personalInformation.getSecondSurname());
		p.setDni(personalInformation.getDni());
		p.setAddress(personalInformation.getAddress());
		p.setEmail(personalInformation.getEmail());
		p.setPhone(personalInformation.getPhone());
		String error = "No se ha podido guardar";
		if (p.getId() == 0) {
			int id = ProfessorController.insert(p);
			if (id < 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			else {
				personalInformation.setId(id);
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
		personalInformation.setId(0);
		personalInformation.setName("");
		personalInformation.setFirstSurname("");
		personalInformation.setSecondSurname("");
		personalInformation.setDni("");
		personalInformation.setAddress("");
		personalInformation.setEmail("");
		personalInformation.setPhone("");
	}
	
	/**
	 * Método para eliminar un registro
	 */
	private void deleteRecord() {
		if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?") == JOptionPane.YES_OPTION) {
			int id = personalInformation.getId();
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
