package view;

import javax.swing.JPanel;

import controller.CourseController;
import model.Course;

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

public class CoursePanel extends JPanel {

	private JTextField jtfId;
	private JTextField jtfDescription;
	private JLabel lblNewLabel_2;
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
	public CoursePanel() {

		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		lblNewLabel_2 = new JLabel("Gestión de cursos");
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
		
		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfDescription = new JTextField();
		GridBagConstraints gbc_jtfDescription = new GridBagConstraints();
		gbc_jtfDescription.weightx = 1.0;
		gbc_jtfDescription.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescription.gridx = 1;
		gbc_jtfDescription.gridy = 2;
		add(jtfDescription, gbc_jtfDescription);
		jtfDescription.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnFirst = new JButton("<<");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(CourseController.getFirst());
			}
		});
		panel.add(btnFirst);
		
		btnPrevious = new JButton("<");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(CourseController.getPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnPrevious);
		
		btnNext = new JButton(">");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(CourseController.getNext(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnNext);
		
		btnLast = new JButton(">>");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRecord(CourseController.getLast());
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
		
		loadRecord(CourseController.getFirst());
	}
	
	/**
	 * Método para cargar un registro
	 */
	private void loadRecord(Course c) {
		if (c != null) {
			jtfId.setText("" + c.getId());
			jtfDescription.setText(c.getDescription());
		}
		if (CourseController.getPrevious(Integer.parseInt(jtfId.getText())) == null) {
			btnFirst.setEnabled(false);
			btnPrevious.setEnabled(false);
		}
		else {
			btnFirst.setEnabled(true);
			btnPrevious.setEnabled(true);
		}
		if (CourseController.getNext(Integer.parseInt(jtfId.getText())) == null) {
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
		Course c = new Course();
		c.setId(Integer.parseInt(jtfId.getText()));
		c.setDescription(jtfDescription.getText());
		String error = "No se ha podido guardar";
		if (c.getId() == 0) {
			int id = CourseController.insert(c);
			if (id < 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			else {
				jtfId.setText("" + id);
				SubjectPanel.getCourses();
			}
		}
		else {
			if (CourseController.update(c) != 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			else {
				SubjectPanel.getCourses();
			}
		}
	}
	
	/**
	 * Método para limpiar los datos
	 */
	private void clearData() {
		jtfId.setText("0");
		jtfDescription.setText("");
	}
	
	/**
	 * Método para eliminar un registro
	 */
	private void deleteRecord() {
		if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?") == JOptionPane.YES_OPTION) {
			int id = Integer.parseInt(jtfId.getText());
			if (CourseController.delete(id) != 1) {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar");
			}
			else {
				Course c = CourseController.getPrevious(id);
				if (c != null) {
					loadRecord(c);
				}
				else {
					c = CourseController.getNext(id);
					if (c != null) {
						loadRecord(c);
					}
					else {
						clearData();
					}
				}
				SubjectPanel.getCourses();
			}
		}
	}
	
}
