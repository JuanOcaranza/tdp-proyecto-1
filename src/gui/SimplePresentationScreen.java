package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel image;
	private JTextField txtLu;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtMail;
	private JTextField txtGithubURL;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2022 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel lblLu = new JLabel("LU");
		
		txtLu = new JTextField();
		txtLu.setEditable(false);
		txtLu.setColumns(10);
		txtLu.setText(String.valueOf(studentData.getId()));
		
		txtLastName = new JTextField();
		txtLastName.setEditable(false);
		txtLastName.setColumns(10);
		txtLastName.setText(studentData.getLastName());
		
		txtFirstName = new JTextField();
		txtFirstName.setEditable(false);
		txtFirstName.setColumns(10);
		txtFirstName.setText(studentData.getFirstName());
		
		txtMail = new JTextField();
		txtMail.setEditable(false);
		txtMail.setColumns(10);
		txtMail.setText(studentData.getMail());
		
		txtGithubURL = new JTextField();
		txtGithubURL.setEditable(false);
		txtGithubURL.setColumns(10);
		txtGithubURL.setText(studentData.getGithubURL());
		
		JLabel lblLastName = new JLabel("Apellido");
		
		JLabel lblFirstName = new JLabel("Nombre");
		
		JLabel lblMail = new JLabel("E-mail");
		
		JLabel lblGithubURL = new JLabel("Github URL");
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLu)
						.addComponent(lblLastName)
						.addComponent(lblFirstName)
						.addComponent(lblMail)
						.addComponent(lblGithubURL))
					.addGap(9)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addGap(10)
							.addComponent(txtGithubURL, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
								.addComponent(txtLu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
								.addComponent(txtLastName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
								.addComponent(txtFirstName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
								.addComponent(txtMail, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLu)
						.addComponent(txtLu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFirstName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGithubURL)
						.addComponent(txtGithubURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		image = new JLabel("");
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto())));
		contentPane.add(image, BorderLayout.CENTER);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las': HH:mm:ss");
		
		JLabel lblHora = new JLabel("Esta ventana fue generada el " + formatter.format(LocalDateTime.now()));
		contentPane.add(lblHora, BorderLayout.SOUTH);
	}
}
