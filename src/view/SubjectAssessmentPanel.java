package view;

import javax.swing.JPanel;

import controller.SubjectAssessmentController;
import controller.SubjectController;
import controller.ProfessorController;
import controller.StudentController;
import model.SubjectAssessment;
import model.Professor;
import model.Student;
import model.Subject;

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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class SubjectAssessmentPanel extends JPanel {

	private static JComboBox<Professor> jcbProfessor;
	private static JComboBox<Student> jcbStudent;
	private static JComboBox<Subject> jcbSubject;
	private JTextField jtfId;
	private JTextField jtfAssessment;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
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
	public SubjectAssessmentPanel() {

		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		lblNewLabel_2 = new JLabel("Gestión de valoraciones");
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
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfessor = new JComboBox<Professor>();
		GridBagConstraints gbc_jcbProfessor = new GridBagConstraints();
		gbc_jcbProfessor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfessor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfessor.gridx = 1;
		gbc_jcbProfessor.gridy = 2;
		add(jcbProfessor, gbc_jcbProfessor);
		
		lblNewLabel_3 = new JLabel("Estudiante:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcbStudent = new JComboBox<Student>();
		GridBagConstraints gbc_jcbStudent = new GridBagConstraints();
		gbc_jcbStudent.insets = new Insets(0, 0, 5, 0);
		gbc_jcbStudent.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbStudent.gridx = 1;
		gbc_jcbStudent.gridy = 3;
		add(jcbStudent, gbc_jcbStudent);
		
		lblNewLabel_4 = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbSubject = new JComboBox<Subject>();
		GridBagConstraints gbc_jcbSubject = new GridBagConstraints();
		gbc_jcbSubject.insets = new Insets(0, 0, 5, 0);
		gbc_jcbSubject.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSubject.gridx = 1;
		gbc_jcbSubject.gridy = 4;
		add(jcbSubject, gbc_jcbSubject);
		
		lblNewLabel_5 = new JLabel("Valoración:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfAssessment = new JTextField();
		GridBagConstraints gbc_jtfAssessment = new GridBagConstraints();
		gbc_jtfAssessment.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAssessment.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAssessment.gridx = 1;
		gbc_jtfAssessment.gridy = 5;
		add(jtfAssessment, gbc_jtfAssessment);
		jtfAssessment.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 6;
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnFirst = new JButton("<<");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(SubjectAssessmentController.getFirst());
			}
		});
		panel.add(btnFirst);
		
		btnPrevious = new JButton("<");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(SubjectAssessmentController.getPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnPrevious);
		
		btnNext = new JButton(">");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(SubjectAssessmentController.getNext(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnNext);
		
		btnLast = new JButton(">>");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(SubjectAssessmentController.getLast());
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
		
		getProfessors();
		getStudents();
		getSubjects();
		loadRecord(SubjectAssessmentController.getFirst());
	}
	
	/**
	 * Método para cargar un registro
	 */
	private void loadRecord(SubjectAssessment sa) {
		if (sa != null) {
			jtfId.setText("" + sa.getId());
			for (int i = 0; i < jcbProfessor.getItemCount(); i++) {
				Professor p = jcbProfessor.getItemAt(i);
				if (sa.getProfessorId() == p.getId()) {
					jcbProfessor.setSelectedIndex(i);
				}
			}
			for (int i = 0; i < jcbStudent.getItemCount(); i++) {
				Student s = jcbStudent.getItemAt(i);
				if (sa.getStudentId() == s.getId()) {
					jcbStudent.setSelectedIndex(i);
				}
			}
			for (int i = 0; i < jcbSubject.getItemCount(); i++) {
				Subject s = jcbSubject.getItemAt(i);
				if (sa.getSubjectId() == s.getId()) {
					jcbSubject.setSelectedIndex(i);
				}
			}
			jtfAssessment.setText("" + sa.getAssessment());
		}
		if (SubjectAssessmentController.getPrevious(Integer.parseInt(jtfId.getText())) == null) {
			btnFirst.setEnabled(false);
			btnPrevious.setEnabled(false);
		}
		else {
			btnFirst.setEnabled(true);
			btnPrevious.setEnabled(true);
		}
		if (SubjectAssessmentController.getNext(Integer.parseInt(jtfId.getText())) == null) {
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
		SubjectAssessment s = new SubjectAssessment();
		s.setId(Integer.parseInt(jtfId.getText()));
		s.setProfessorId(((Professor) jcbProfessor.getSelectedItem()).getId());
		s.setStudentId(((Student) jcbStudent.getSelectedItem()).getId());
		s.setSubjectId(((Subject) jcbSubject.getSelectedItem()).getId());
		s.setAssessment(Float.parseFloat(jtfAssessment.getText()));
		String error = "No se ha podido guardar";
		if (s.getId() == 0) {
			int id = SubjectAssessmentController.insert(s);
			if (id < 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			else {
				jtfId.setText("" + id);
			}
		}
		else {
			if (SubjectAssessmentController.update(s) != 1) {
				JOptionPane.showMessageDialog(null, error);
			}
		}
	}
	
	/**
	 * Método para limpiar los datos
	 */
	private void clearData() {
		jtfId.setText("0");
		if (jcbProfessor.getItemCount() > 0) {
			jcbProfessor.setSelectedIndex(0);
		}
		if (jcbStudent.getItemCount() > 0) {
			jcbStudent.setSelectedIndex(0);
		}
		if (jcbSubject.getItemCount() > 0) {
			jcbSubject.setSelectedIndex(0);
		}
		jtfAssessment.setText("0");
	}
	
	/**
	 * Método para eliminar un registro
	 */
	private void deleteRecord() {
		if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?") == JOptionPane.YES_OPTION) {
			int id = Integer.parseInt(jtfId.getText());
			if (SubjectAssessmentController.delete(id) != 1) {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar");
			}
			else {
				SubjectAssessment s = SubjectAssessmentController.getPrevious(id);
				if (s != null) {
					loadRecord(s);
				}
				else {
					s = SubjectAssessmentController.getNext(id);
					if (s != null) {
						loadRecord(s);
					}
					else {
						clearData();
					}
				}
			}
		}
	}
	
	/**
	 * Método para obtener los profesores
	 */
	public static void getProfessors() {
		jcbProfessor.removeAllItems();
		List<Professor> professors = ProfessorController.getAll();
		for (Professor p : professors) {
			jcbProfessor.addItem(p);
		}
	}
	
	/**
	 * Método para obtener los estudiantes y materias
	 */
	public static void getStudents() {
		jcbStudent.removeAllItems();
		List<Student> students = StudentController.getAll();
		for (Student s : students) {
			jcbStudent.addItem(s);
		}
	}
	
	/**
	 * Método para obtener las materias
	 */
	public static void getSubjects() {
		jcbSubject.removeAllItems();
		List<Subject> subjects = SubjectController.getAll();
		for (Subject s : subjects) {
			jcbSubject.addItem(s);
		}
	}
	
}
