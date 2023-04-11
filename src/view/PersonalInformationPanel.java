package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import controller.SexTypologyController;
import model.SexTypology;

import java.awt.Insets;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonalInformationPanel extends JPanel {
	
	private JTextField jtfId;
	private JTextField jtfName;
	private JTextField jtfFirstSurname;
	private JTextField jtfSecondSurname;
	private JTextField jtfDni;
	private JTextField jtfAddress;
	private JTextField jtfEmail;
	private JTextField jtfPhone;
	private JTextField jtfColor;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JComboBox<SexTypology> jcbSexTypology;
	private JButton btnImage;
	private JButton btnColor;
	private JScrollPane scrollPane;
	private byte[] image;

	/**
	 * Crea el panel
	 */
	public PersonalInformationPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
//		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
//		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("ID:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.weightx = 1.0;
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		add(scrollPane, gbc_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfName = new JTextField();
		GridBagConstraints gbc_jtfName = new GridBagConstraints();
		gbc_jtfName.insets = new Insets(0, 0, 5, 5);
		gbc_jtfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfName.gridx = 1;
		gbc_jtfName.gridy = 1;
		add(jtfName, gbc_jtfName);
		jtfName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Primer apellido:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfFirstSurname = new JTextField();
		GridBagConstraints gbc_jtfFirstSurname = new GridBagConstraints();
		gbc_jtfFirstSurname.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFirstSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFirstSurname.gridx = 1;
		gbc_jtfFirstSurname.gridy = 2;
		add(jtfFirstSurname, gbc_jtfFirstSurname);
		jtfFirstSurname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Segundo apellido:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfSecondSurname = new JTextField();
		GridBagConstraints gbc_jtfSecondSurname = new GridBagConstraints();
		gbc_jtfSecondSurname.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSecondSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSecondSurname.gridx = 1;
		gbc_jtfSecondSurname.gridy = 3;
		add(jtfSecondSurname, gbc_jtfSecondSurname);
		jtfSecondSurname.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 4;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jcbSexTypology = new JComboBox<SexTypology>();
		GridBagConstraints gbc_jcbSexTypology = new GridBagConstraints();
		gbc_jcbSexTypology.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexTypology.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexTypology.gridx = 1;
		gbc_jcbSexTypology.gridy = 4;
		add(jcbSexTypology, gbc_jcbSexTypology);
		
		JLabel lblNewLabel_4 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfAddress = new JTextField();
		GridBagConstraints gbc_jtfAddress = new GridBagConstraints();
		gbc_jtfAddress.insets = new Insets(0, 0, 5, 5);
		gbc_jtfAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAddress.gridx = 1;
		gbc_jtfAddress.gridy = 6;
		add(jtfAddress, gbc_jtfAddress);
		jtfAddress.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfPhone = new JTextField();
		GridBagConstraints gbc_jtfPhone = new GridBagConstraints();
		gbc_jtfPhone.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPhone.gridx = 1;
		gbc_jtfPhone.gridy = 8;
		add(jtfPhone, gbc_jtfPhone);
		jtfPhone.setColumns(10);
		
		btnImage = new JButton("Cambiar imagen");
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectImage();
			}
		});
		GridBagConstraints gbc_btnImage = new GridBagConstraints();
		gbc_btnImage.insets = new Insets(0, 0, 5, 0);
		gbc_btnImage.gridx = 2;
		gbc_btnImage.gridy = 4;
		add(btnImage, gbc_btnImage);
		
		lblNewLabel_9 = new JLabel("Color preferido:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 9;
		add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		jtfColor = new JTextField();
		jtfColor.setEnabled(false);
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 0, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 9;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);
		
		btnColor = new JButton("Cambiar color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectColor();
			}
		});
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.gridx = 2;
		gbc_btnColor.gridy = 9;
		add(btnColor, gbc_btnColor);
		
		getSexTypologys();
		showImage();
	}
	
	/**
	 * Método para obtener las tipologías de sexo
	 */
	private void getSexTypologys() {
		jcbSexTypology.removeAllItems();
		List<SexTypology> sexTypologys = SexTypologyController.getAll();
		for (SexTypology s : sexTypologys) {
			jcbSexTypology.addItem(s);
		}
	}

	/**
	 * Método para seleccionar una imagen
	 */
	private void selectImage() {
		JFileChooser jfileChooser = new JFileChooser();
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		jfileChooser.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() &&
						(f.getAbsolutePath().toLowerCase().endsWith(".jpg") || 
								f.getAbsolutePath().toLowerCase().endsWith(".jpeg")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".png")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".gif")))) 
					return true;
				return false;
			}
		});
		int choice = jfileChooser.showOpenDialog(null);
		if (choice == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();
			if (fichero.isFile()) {
				try {
					image = Files.readAllBytes(fichero.toPath());
					showImage();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Método para mostrar la imagen
	 */
	private void showImage() {
		if (image != null && image.length > 0) {
			ImageIcon icon = new ImageIcon(image);
			JLabel lblIcon = new JLabel(icon);
			scrollPane.setViewportView(lblIcon);
		}
		else {
			JLabel lblIcon = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcon);
		}
	}
	
	/**
	 * Método para seleccionar un color
	 */
	private void selectColor() {
		Color color = JColorChooser.showDialog(null, "Seleccione un color", Color.gray);
		if (color != null) {
			jtfColor.setText("#" + Integer.toHexString(color.getRGB()).substring(2));
			setBackground(color);
		}
	}
	
	/**
	 * Getter ID
	 * @return
	 */
	public int getId() {
		return Integer.parseInt(jtfId.getText());
	}
	
	/**
	 * Setter ID
	 * @param id
	 */
	public void setId(int id) {
		jtfId.setText("" + id);
	}
	
	/**
	 * Getter nombre
	 * @return
	 */
	public String getName() {
		return jtfName.getText();
	}
	
	/**
	 * Setter nombre
	 * @param name
	 */
	public void setName(String name) {
		jtfName.setText(name);
	}
	
	/**
	 * Getter primer apellido
	 * @return
	 */
	public String getFirstSurname() {
		return jtfFirstSurname.getText();
	}
	
	/**
	 * Setter primer apellido
	 * @param firstSurname
	 */
	public void setFirstSurname(String firstSurname) {
		jtfFirstSurname.setText(firstSurname);
	}
	
	/**
	 * Getter segundo apellido
	 * @return
	 */
	public String getSecondSurname() {
		return jtfSecondSurname.getText();
	}
	
	/**
	 * Setter segundo apellido
	 * @param secondSurname
	 */
	public void setSecondSurname(String secondSurname) {
		jtfSecondSurname.setText(secondSurname);
	}
	
	/**
	 * Getter tipología de sexo
	 * @return
	 */
	public int getSexTypology() {
		return ((SexTypology) jcbSexTypology.getSelectedItem()).getId();
	}
	
	/**
	 * Setter tipología de sexo
	 * @param sexTypology
	 */
	public void setSexTypology(SexTypology sexTypology) {
		jcbSexTypology.setSelectedItem(sexTypology);
	}
	
	/**
	 * Getter DNI
	 * @return
	 */
	public String getDni() {
		return jtfDni.getText();
	}
	
	/**
	 * Setter DNI
	 * @param dni
	 */
	public void setDni(String dni) {
		jtfDni.setText(dni);
	}
	
	/**
	 * Getter dirección
	 * @return
	 */
	public String getAddress() {
		return jtfAddress.getText();
	}
	
	/**
	 * Setter dirección
	 * @param address
	 */
	public void setAddress(String address) {
		jtfAddress.setText(address);
	}
	
	/**
	 * Getter email
	 * @return
	 */
	public String getEmail() {
		return jtfEmail.getText();
	}
	
	/**
	 * Setter email
	 * @param email
	 */
	public void setEmail(String email) {
		jtfEmail.setText(email);
	}
	
	/**
	 * Getter teléfono
	 * @return
	 */
	public String getPhone() {
		return jtfPhone.getText();
	}
	
	/**
	 * Setter teléfono
	 * @param phone
	 */
	public void setPhone(String phone) {
		jtfPhone.setText(phone);
	}
	
	/**
	 * Getter color
	 * @return
	 */
	public String getColor() {
		return jtfColor.getText();
	}
	
	/**
	 * Setter color
	 * @param color
	 */
	public void setColor(String color) {
		jtfColor.setText(color);
	}
	
	/**
	 * Getter imagen
	 * @return
	 */
	public byte[] getImage() {
		return image;
	}
	
	/**
	 * Setter imagen
	 * @param image
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

}
