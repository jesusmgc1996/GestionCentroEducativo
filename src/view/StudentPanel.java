package view;

import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.SexTypologyController;
import controller.StudentController;
import model.Student;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentPanel extends JPanel {
	
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
	public StudentPanel() {

		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		lblNewLabel = new JLabel("Gestión de estudiantes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(15, 15, 15, 15);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		personalInformation = new PersonalInformationPanel();
		GridBagConstraints gbc_personalInformation = new GridBagConstraints();
		gbc_personalInformation.weightx = 1.0;
		gbc_personalInformation.fill = GridBagConstraints.HORIZONTAL;
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
				loadRecord(StudentController.getFirst());
			}
		});
		panel.add(btnFirst);
		
		btnPrevious = new JButton("<");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(StudentController.getPrevious(personalInformation.getId()));
			}
		});
		panel.add(btnPrevious);
		
		btnNext = new JButton(">");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(StudentController.getNext(personalInformation.getId()));
			}
		});
		panel.add(btnNext);
		
		btnLast = new JButton(">>");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(StudentController.getLast());
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

		loadRecord(StudentController.getFirst());
	}
	
	/**
	 * Método para cargar un registro
	 */
	private void loadRecord(Student s) {
		if (s != null) {
			personalInformation.setId(s.getId());
			personalInformation.setName(s.getName());
			personalInformation.setFirstSurname(s.getFirstSurname());
			personalInformation.setSecondSurname(s.getSecondSurname());
			personalInformation.setSexTypology(SexTypologyController.getSexTypology(s.getSexTypologyId()));
			personalInformation.setDni(s.getDni());
			personalInformation.setAddress(s.getAddress());
			personalInformation.setEmail(s.getEmail());
			personalInformation.setPhone(s.getPhone());
			personalInformation.setColor(s.getColor());
			personalInformation.setImage(s.getImage());
		}
		if (StudentController.getPrevious(personalInformation.getId()) == null) {
			btnFirst.setEnabled(false);
			btnPrevious.setEnabled(false);
		}
		else {
			btnFirst.setEnabled(true);
			btnPrevious.setEnabled(true);
		}
		if (StudentController.getNext(personalInformation.getId()) == null) {
			btnLast.setEnabled(false);
			btnNext.setEnabled(false);
		}
		else {
			btnLast.setEnabled(true);
			btnNext.setEnabled(true);
		}
		if (!personalInformation.getColor().isBlank()) {
			personalInformation.setBackground(Color.decode(personalInformation.getColor()));
		}
		else {
			personalInformation.setBackground(UIManager.getColor("Panel.background"));
		}
	}
	
	/**
	 * Método para guardar un registro
	 */
	private void saveRecord() {
		Student s = new Student();
		s.setId(personalInformation.getId());
		s.setName(personalInformation.getName());
		s.setFirstSurname(personalInformation.getFirstSurname());
		s.setSecondSurname(personalInformation.getSecondSurname());
		s.setSexTypologyId(personalInformation.getSexTypology());
		s.setDni(personalInformation.getDni());
		s.setAddress(personalInformation.getAddress());
		s.setEmail(personalInformation.getEmail());
		s.setPhone(personalInformation.getPhone());
		s.setColor(personalInformation.getColor());
		s.setImage(personalInformation.getImage());
		String error = "No se ha podido guardar";
		if (s.getId() == 0) {
			int id = StudentController.insert(s);
			if (id < 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			else {
				personalInformation.setId(id);
				SubjectAssessmentPanel.getStudents();
			}
		}
		else {
			if (StudentController.update(s) != 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			else {
				SubjectAssessmentPanel.getStudents();
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
		personalInformation.setSexTypology(null);
		personalInformation.setDni("");
		personalInformation.setAddress("");
		personalInformation.setEmail("");
		personalInformation.setPhone("");
		personalInformation.setColor("");
		personalInformation.setImage(null);
		personalInformation.setBackground(UIManager.getColor("Panel.background"));
	}
	
	/**
	 * Método para eliminar un registro
	 */
	private void deleteRecord() {
		if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?") == JOptionPane.YES_OPTION) {
			int id = personalInformation.getId();
			if (StudentController.delete(id) != 1) {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar");
			}
			else {
				Student s = StudentController.getPrevious(id);
				if (s != null) {
					loadRecord(s);
				}
				else {
					s = StudentController.getNext(id);
					if (s != null) {
						loadRecord(s);
					}
					else {
						clearData();
					}
				}
				SubjectAssessmentPanel.getStudents();
			}
		}
	}
	
}
