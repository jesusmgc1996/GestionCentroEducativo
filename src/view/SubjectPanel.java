package view;

import javax.swing.JPanel;

import controller.CourseController;
import controller.SubjectController;
import model.Course;
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

public class SubjectPanel extends JPanel {

	private static JComboBox<Course> jcbCourse;
	private JTextField jtfId;
	private JTextField jtfName;
	private JTextField jtfAcronym;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
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
	public SubjectPanel() {

		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		lblNewLabel_2 = new JLabel("Gestión de materias");
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
		
		lblNewLabel_3 = new JLabel("Acrónimo:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfAcronym = new JTextField();
		GridBagConstraints gbc_jtfAcronym = new GridBagConstraints();
		gbc_jtfAcronym.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAcronym.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAcronym.gridx = 1;
		gbc_jtfAcronym.gridy = 3;
		add(jtfAcronym, gbc_jtfAcronym);
		jtfAcronym.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Curso:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbCourse = new JComboBox<Course>();
		GridBagConstraints gbc_jcbCourse = new GridBagConstraints();
		gbc_jcbCourse.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCourse.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCourse.gridx = 1;
		gbc_jcbCourse.gridy = 4;
		add(jcbCourse, gbc_jcbCourse);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 5;
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnFirst = new JButton("<<");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(SubjectController.getFirst());
			}
		});
		panel.add(btnFirst);
		
		btnPrevious = new JButton("<");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(SubjectController.getPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnPrevious);
		
		btnNext = new JButton(">");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(SubjectController.getNext(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnNext);
		
		btnLast = new JButton(">>");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(SubjectController.getLast());
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
		
		getCourses();
		loadRecord(SubjectController.getFirst());
	}
	
	/**
	 * Método para cargar un registro
	 */
	private void loadRecord(Subject s) {
		if (s != null) {
			jtfId.setText("" + s.getId());
			jtfName.setText(s.getName());
			jtfAcronym.setText(s.getAcronym());
			for (int i = 0; i < jcbCourse.getItemCount(); i++) {
				Course c = jcbCourse.getItemAt(i);
				if (s.getCourseId() == c.getId()) {
					jcbCourse.setSelectedIndex(i);
				}
			}
		}
		if (SubjectController.getPrevious(Integer.parseInt(jtfId.getText())) == null) {
			btnFirst.setEnabled(false);
			btnPrevious.setEnabled(false);
		}
		else {
			btnFirst.setEnabled(true);
			btnPrevious.setEnabled(true);
		}
		if (SubjectController.getNext(Integer.parseInt(jtfId.getText())) == null) {
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
		Subject s = new Subject();
		s.setId(Integer.parseInt(jtfId.getText()));
		s.setName(jtfName.getText());
		s.setAcronym(jtfAcronym.getText());
		s.setCourseId(((Course) jcbCourse.getSelectedItem()).getId());
		String error = "No se ha podido guardar";
		if (s.getId() == 0) {
			int id = SubjectController.insert(s);
			if (id < 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			else {
				jtfId.setText("" + id);
				SubjectAssessmentPanel.getSubjects();
			}
		}
		else {
			if (SubjectController.update(s) != 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			else {
				SubjectAssessmentPanel.getSubjects();
			}
		}
	}
	
	/**
	 * Método para limpiar los datos
	 */
	private void clearData() {
		jtfId.setText("0");
		jtfName.setText("");
		jtfAcronym.setText("");
		if (jcbCourse.getItemCount() > 0) {
			jcbCourse.setSelectedIndex(0);
		}
	}
	
	/**
	 * Método para eliminar un registro
	 */
	private void deleteRecord() {
		if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?") == JOptionPane.YES_OPTION) {
			int id = Integer.parseInt(jtfId.getText());
			if (SubjectController.delete(id) != 1) {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar");
			}
			else {
				Subject s = SubjectController.getPrevious(id);
				if (s != null) {
					loadRecord(s);
				}
				else {
					s = SubjectController.getNext(id);
					if (s != null) {
						loadRecord(s);
					}
					else {
						clearData();
					}
				}
				SubjectAssessmentPanel.getSubjects();
			}
		}
	}
	
	/**
	 * Método para obtener los cursos
	 */
	public static void getCourses() {
		jcbCourse.removeAllItems();
		List<Course> courses = CourseController.getAll();
		for (Course c : courses) {
			jcbCourse.addItem(c);
		}
	}
	
}
