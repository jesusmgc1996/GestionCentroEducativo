package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainWindow extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Crea el frame
	 */
	public MainWindow() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("Cursos", new CoursePanel());
		tabbedPane.add("Profesores", new ProfessorPanel());
		tabbedPane.add("Estudiantes", new StudentPanel());
		tabbedPane.add("Materias", new SubjectPanel());
		tabbedPane.add("Valoraciones", new SubjectAssessmentPanel());
		setContentPane(tabbedPane);
	}

}
