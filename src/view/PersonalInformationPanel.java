package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class PersonalInformationPanel extends JPanel {
	
	private JTextField jtfId;
	private JTextField jtfName;
	private JTextField jtfFirstSurname;
	private JTextField jtfSecondSurname;
	private JTextField jtfDni;
	private JTextField jtfAddress;
	private JTextField jtfEmail;
	private JTextField jtfPhone;

	/**
	 * Crea el panel
	 */
	public PersonalInformationPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
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
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.weightx = 1.0;
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfName = new JTextField();
		GridBagConstraints gbc_jtfName = new GridBagConstraints();
		gbc_jtfName.insets = new Insets(0, 0, 5, 0);
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
		gbc_jtfFirstSurname.insets = new Insets(0, 0, 5, 0);
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
		gbc_jtfSecondSurname.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSecondSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSecondSurname.gridx = 1;
		gbc_jtfSecondSurname.gridy = 3;
		add(jtfSecondSurname, gbc_jtfSecondSurname);
		jtfSecondSurname.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 4;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfAddress = new JTextField();
		GridBagConstraints gbc_jtfAddress = new GridBagConstraints();
		gbc_jtfAddress.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAddress.gridx = 1;
		gbc_jtfAddress.gridy = 5;
		add(jtfAddress, gbc_jtfAddress);
		jtfAddress.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfPhone = new JTextField();
		GridBagConstraints gbc_jtfPhone = new GridBagConstraints();
		gbc_jtfPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPhone.gridx = 1;
		gbc_jtfPhone.gridy = 7;
		add(jtfPhone, gbc_jtfPhone);
		jtfPhone.setColumns(10);
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

}
