package enigma;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ecran extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableReflector;
	private JTable tableAlphabet;
	private JTable tableRotor1A;
	private JTable tableRotor1B;
	private JTable tableRotor2A;
	private JTable tableRotor2B;
	private JTable tableRotor3B;
	private JTable tableRotor3A;
	private JTextField textCl1;
	private JTextField textCl2;
	private JTextField textCl3;
	static int res;
	static int j = 0;
	static int k = 0;
	//Les Rotors
	Object[]columnsRtr3A;
	Object[]columnsRtr3B;
	Object[]columnsRtr2A;
	Object[]columnsRtr2B;
	Object[]columnsRtr1A;
	Object[]columnsRtr1B;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ecran frame = new Ecran();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public Ecran() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1144, 765);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 1147, 743);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		//TEXT-----------------------------------------------------------------------------------------------------------------------
		JPanel panelTxtClair = new JPanel();
		panelTxtClair.setForeground(Color.BLACK);
		panelTxtClair.setBackground(Color.DARK_GRAY);
		panelTxtClair.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 0), new Color(160, 160, 160)), "Texte en clair", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panelTxtClair.setBounds(4, 468, 1120, 100);
		panel.add(panelTxtClair);
		panelTxtClair.setLayout(null);
		
		JEditorPane txtClair = new JEditorPane();
		txtClair.setBounds(6, 16, 1108, 78);
		panelTxtClair.add(txtClair);
		txtClair.setToolTipText("");
		txtClair.setBackground(Color.WHITE);
		
		JPanel panelTxtCrypte = new JPanel();
		panelTxtCrypte.setBackground(Color.DARK_GRAY);
		panelTxtCrypte.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 0), new Color(160, 160, 160)), "Texte crypt\u00E9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelTxtCrypte.setBounds(4, 622, 1120, 100);
		panel.add(panelTxtCrypte);
		panelTxtCrypte.setLayout(null);
		
		JEditorPane txtCrypte = new JEditorPane();
		txtCrypte.setBounds(6, 16, 1108, 78);
		panelTxtCrypte.add(txtCrypte);
		txtCrypte.setForeground(Color.BLACK);
		txtCrypte.setBackground(Color.WHITE);
		
		textCl1 = new JTextField();
		textCl1.setBounds(385, 394, 86, 20);
		panel.add(textCl1);
		textCl1.setColumns(10);
		


		
		textCl2 = new JTextField();
		textCl2.setBounds(481, 394, 86, 20);
		panel.add(textCl2);
		textCl2.setColumns(10);
		

		
		textCl3 = new JTextField();
		textCl3.setBounds(577, 394, 86, 20);
		panel.add(textCl3);
		textCl3.setColumns(10);
		//END-TEXT-----------------------------------------------------------------------------------------------------------------------

		
		JSeparator separator = new JSeparator();
		separator.setBounds(4, 345, 1120, 12);
		panel.add(separator);
		
		//REFLECTEUR-----------------------------------------------------------------------------------------------------------------------
		JScrollPane scrollPaneReflector = new JScrollPane();
		scrollPaneReflector.setBounds(4, 32, 1011, 23);
		panel.add(scrollPaneReflector);

		tableReflector = new JTable();
		Object[] columnsRft = Rotor.reflector; 
			//{25, 23, 21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1, -1, -3, -5, -7, -9, -11, -13, -15, -17, -19, -21, -23, -25};
		DefaultTableModel modelRft = new DefaultTableModel();
		modelRft.setColumnIdentifiers(columnsRft);
		tableReflector.setModel(modelRft);
		

		scrollPaneReflector.setViewportView(tableReflector);
		//END-REFLECTEUR-----------------------------------------------------------------------------------------------------------------------
		
		
		//ROTOR3-----------------------------------------------------------------------------------------------------------------------
		JScrollPane scrollPaneRotor3a = new JScrollPane();
		scrollPaneRotor3a.setBounds(4, 84, 1011, 23);
		panel.add(scrollPaneRotor3a);
		
		tableRotor3A = new JTable();
		columnsRtr3A = Rotor.rotor3a;
			//{12, -1, 23, 10, 2, 14, 5, -5, 9, -2, -13, 10, -2, -8, 10, -6, 6, -16, 2, -1, -17, -5, -14, -9, -20, -10};  
		DefaultTableModel modelRtr3A = new DefaultTableModel();
		
		modelRtr3A.setColumnIdentifiers(columnsRtr3A);
		tableRotor3A.setModel(modelRtr3A);
		

		scrollPaneRotor3a.setViewportView(tableRotor3A);
		
		JScrollPane scrollPaneRotor3b = new JScrollPane();
		scrollPaneRotor3b.setBounds(4, 107, 1011, 23);
		panel.add(scrollPaneRotor3b);
		
		tableRotor3B = new JTable();
		columnsRtr3B = Rotor.rotor3b;
			//{1, 16, 5, 17, 20, 8, -2, 2, 14, 6, 2, -5, -12, -10, 9, 10, 5, -9, 1, -14, -2, -10, -6, 13, -10, -23};  
		DefaultTableModel modelRtr3B = new DefaultTableModel();
		modelRtr3B.setColumnIdentifiers(columnsRtr3B);
		tableRotor3B.setModel(modelRtr3B);
		scrollPaneRotor3b.setViewportView(tableRotor3B);
		//END-ROTOR3-----------------------------------------------------------------------------------------------------------------------
		
		
		//ROTOR2-----------------------------------------------------------------------------------------------------------------------
		JScrollPane scrollPaneRotor2a = new JScrollPane();
		scrollPaneRotor2a.setBounds(4, 159, 1011, 23);
		panel.add(scrollPaneRotor2a);
		
		tableRotor2A = new JTable();
		columnsRtr2A = Rotor.rotor2a;
			//{25, 7, 17, -3, 13, 19, 12, 3, -1, 11, 5, -5, -7, 10, -2, 1, -2, 4, -17, -8, -16, -18, -9, -1, -22, -16};  
		DefaultTableModel modelRtr2A = new DefaultTableModel();
		modelRtr2A.setColumnIdentifiers(columnsRtr2A);
		tableRotor2A.setModel(modelRtr2A);
		scrollPaneRotor2a.setViewportView(tableRotor2A);
		
		JScrollPane scrollPaneRotor2b = new JScrollPane();
		scrollPaneRotor2b.setBounds(4, 182, 1011, 23);
		panel.add(scrollPaneRotor2b);
		
		tableRotor2B = new JTable();
		columnsRtr2B = Rotor.rotor2b;
			//{3, 17, 22, 18, 16, 7, 5, 1, -7, 16, -3, 8, 2, 9, 2, -5, -1, -13, -12, -17, -11, -4, 1, -10, -19, -25};  
		DefaultTableModel modelRtr2B = new DefaultTableModel();
		modelRtr2B.setColumnIdentifiers(columnsRtr2B);
		tableRotor2B.setModel(modelRtr2B);
		scrollPaneRotor2b.setViewportView(tableRotor2B);
		//END-ROTOR2-----------------------------------------------------------------------------------------------------------------------
		
		
		
		//ROTOR1-----------------------------------------------------------------------------------------------------------------------
		JScrollPane scrollPaneRotor1a = new JScrollPane();
		scrollPaneRotor1a.setBounds(4, 236, 1011, 23);
		panel.add(scrollPaneRotor1a);
		
		tableRotor1A = new JTable();
		columnsRtr1A = Rotor.rotor1a;
			//{17, 4, 19, 21, 7, 11, 3, -5, 7, 9, -10, 9, 17, 6, -6, -2, -4, -7, -12, -5, 3, 4, -21, -16, -2, -21};  
		DefaultTableModel modelRtr1A = new DefaultTableModel();
		modelRtr1A.setColumnIdentifiers(columnsRtr1A);
		tableRotor1A.setModel(modelRtr1A);
		scrollPaneRotor1a.setViewportView(tableRotor1A);
		
		JScrollPane scrollPaneRotor1b = new JScrollPane();
		scrollPaneRotor1b.setBounds(4, 259, 1011, 23);
		panel.add(scrollPaneRotor1b);
		
		tableRotor1B = new JTable();
		columnsRtr1B = Rotor.rotor1b;
			//{10, 21, 5, -17, 21, -4, 12, 16, 6, -3, 7, -7, 4, 2, 5, -7, -11, -17, -9, -6, -9, -19, 2, -3, -21, -4};
		DefaultTableModel modelRtr1B = new DefaultTableModel();
		modelRtr1B.setColumnIdentifiers(columnsRtr1B);
		tableRotor1B.setModel(modelRtr1B);
		scrollPaneRotor1b.setViewportView(tableRotor1B);
		//END-ROTOR1-----------------------------------------------------------------------------------------------------------------------
		
		
		
		//ALPHABET-----------------------------------------------------------------------------------------------------------------------
		JScrollPane scrollPaneAphabet = new JScrollPane();
		scrollPaneAphabet.setBounds(4, 311, 1011, 23);
		panel.add(scrollPaneAphabet);
		
		tableAlphabet = new JTable();
		Object[] columnsApb = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		DefaultTableModel modelApb = new DefaultTableModel();
		tableAlphabet.setModel(modelApb);
		modelApb.setColumnIdentifiers(columnsApb);
		scrollPaneAphabet.setViewportView(tableAlphabet);
		//END-ALPHABET-----------------------------------------------------------------------------------------------------------------------
		

		
		//LABEL-----------------------------------------------------------------------------------------------------------------------
		JLabel lblReflector = new JLabel("Reflector");
		lblReflector.setForeground(Color.WHITE);
		lblReflector.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblReflector.setBounds(1026, 32, 92, 23);
		panel.add(lblReflector);
		
		JLabel lblRotor1 = new JLabel("Rotor1");
		lblRotor1.setForeground(Color.WHITE);
		lblRotor1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblRotor1.setBounds(1025, 236, 92, 46);
		panel.add(lblRotor1);
		
		JLabel lblRotor2 = new JLabel("Rotor2");
		lblRotor2.setForeground(Color.WHITE);
		lblRotor2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblRotor2.setBounds(1025, 160, 92, 46);
		panel.add(lblRotor2);
		
		JLabel lblRotor3 = new JLabel("Rotor3");
		lblRotor3.setForeground(Color.WHITE);
		lblRotor3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblRotor3.setBounds(1025, 85, 92, 46);
		panel.add(lblRotor3);
		
		JLabel lblCle = new JLabel("Cl\u00E9 :");
		lblCle.setForeground(Color.WHITE);
		lblCle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblCle.setBounds(349, 392, 32, 23);
		panel.add(lblCle);
		//END-LABEL-----------------------------------------------------------------------------------------------------------------------
		
		
		//BOUTON-----------------------------------------------------------------------------------------------------------------------
				//Bouton permettant la configuration des rotors
		JButton btnConfRotor = new JButton("Configurer Rotor");
		btnConfRotor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textCl1.getText().length()>0&&textCl2.getText().length()>0&&textCl3.getText().length()>0) {
				String str1[] = textCl1.getText().split(",");
				String str2[] = textCl2.getText().split(",");
				String str3[] = textCl3.getText().split(",");
				try {
				Rotor.configurationRotor(str1);
				}catch(ArrayIndexOutOfBoundsException e1) {
					Object frame = null;
					JOptionPane.showMessageDialog((Component) frame, "La cle 1 doit etre au format R#,G/D,# "
							+ "et les lettres en majuscule"
							+ "\nEx: R3,G,1");
				}
				try {
				Rotor.configurationRotor(str2);
				}catch(ArrayIndexOutOfBoundsException e1) {
					Object frame = null;
					JOptionPane.showMessageDialog((Component) frame, "La cle 2 doit etre au format R#,G/D,# "
							+ "et les lettres en majuscule"
							+ "\nEx: R3,G,1");
				}
				try {
				Rotor.configurationRotor(str3);
				}catch(ArrayIndexOutOfBoundsException e1) {
					Object frame = null;
					JOptionPane.showMessageDialog((Component) frame, "La cle 3 doit etre au format R#,G/D,# "
							+ "et les lettres en majuscule"
							+ "\nEx: R3,G,1");
				}
				

				
				modelRtr3A.setColumnIdentifiers(columnsRtr3A);
				modelRtr3B.setColumnIdentifiers(columnsRtr3B);
				modelRtr2A.setColumnIdentifiers(columnsRtr2A);
				modelRtr2B.setColumnIdentifiers(columnsRtr2B);
				modelRtr1A.setColumnIdentifiers(columnsRtr1A);
				modelRtr1B.setColumnIdentifiers(columnsRtr1B);
				
			}
			}
		});
		
		
		btnConfRotor.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnConfRotor.setBackground(Color.WHITE);
		btnConfRotor.setBounds(14, 588, 136, 23);
		panel.add(btnConfRotor);
		
		//Bouton pour encrypter un message 
		

		JButton btnEncrypter = new JButton("Encrypter");
		btnEncrypter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelRft.setColumnIdentifiers(columnsRft);
				modelRtr3A.setColumnIdentifiers(columnsRtr3A);
				modelRtr3B.setColumnIdentifiers(columnsRtr3B);
				modelRtr2A.setColumnIdentifiers(columnsRtr2A);
				modelRtr2B.setColumnIdentifiers(columnsRtr2B);
				modelRtr1A.setColumnIdentifiers(columnsRtr1A);
				modelRtr1B.setColumnIdentifiers(columnsRtr1B);
				modelApb.setColumnIdentifiers(columnsApb);
				k = 0;
				String[] str = txtClair.getText().split("");
				if(txtCrypte.getText().length()<str.length) {
				if(txtClair.getText() != "") {
					if (str[j].equals(" ")) {
						txtCrypte.setText(txtCrypte.getText()+" ");
						j++;
					}
					int index =  Arrays.binarySearch(Rotor.alphabet, str[j].toUpperCase());

					j++;

						   Rotor.encrypt_decrypt(index);
						   
					   
					   String res2 = (String) Rotor.alphabet[res];
					     txtCrypte.setText(txtCrypte.getText()+res2);
					     
					     
							tableAlphabet.getColumnModel().getColumn(Rotor.rot0).setHeaderRenderer(new TableCustom());
							tableReflector.getColumnModel().getColumn(Rotor.rot3).setHeaderRenderer(new TableCustom());
							tableRotor3B.getColumnModel().getColumn(Rotor.rot2).setHeaderRenderer(new TableCustom());
							tableRotor2B.getColumnModel().getColumn(Rotor.rot1).setHeaderRenderer(new TableCustom());
							tableRotor1B.getColumnModel().getColumn(Rotor.rot0).setHeaderRenderer(new TableCustom());
							tableReflector.getColumnModel().getColumn(Rotor.ref).setHeaderRenderer(new TableCustom1());
							tableRotor3A.getColumnModel().getColumn(Rotor.ref).setHeaderRenderer(new TableCustom1());
							tableRotor2A.getColumnModel().getColumn(Rotor.rot3a).setHeaderRenderer(new TableCustom1());
							tableRotor1A.getColumnModel().getColumn(Rotor.rot2a).setHeaderRenderer(new TableCustom1());
							tableAlphabet.getColumnModel().getColumn(Rotor.rot1a).setHeaderRenderer(new TableCustom1());


						
							scrollPaneReflector.setViewportView(tableReflector);
							scrollPaneRotor3b.setViewportView(tableRotor3B);
							scrollPaneRotor2b.setViewportView(tableRotor2B);
							scrollPaneRotor1b.setViewportView(tableRotor1B);
							scrollPaneRotor3a.setViewportView(tableRotor3A);
							scrollPaneRotor2a.setViewportView(tableRotor2A);
							scrollPaneRotor1a.setViewportView(tableRotor1A);
							scrollPaneAphabet.setViewportView(tableAlphabet);
				}  
				}

				
			}		  
		});
		btnEncrypter.setBackground(Color.GREEN);
		btnEncrypter.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnEncrypter.setBounds(328, 588, 136, 23);
		panel.add(btnEncrypter);
		
		//Bouton pour les rotation d'un cran apres chaque cryptage
		JButton btnEtpSuivante = new JButton("Etape suivante");
		btnEtpSuivante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(textCl1.getText().length()>0&&textCl2.getText().length()>0&&textCl3.getText().length()>0) {
				String str1[] = textCl1.getText().split(",");
				String str2[] = textCl2.getText().split(",");
				String str3[] = textCl3.getText().split(",");
				
				if(Rotor.c1<=26) {
					Rotor.nextStep(str1);
					if(Rotor.c1 != 26) {
						Rotor.c1++;
					}
				}
				if(Rotor.c1>=26 && Rotor.c1<=52) {
					Rotor.nextStep(str2);
					if(Rotor.c1 != 52) {
						Rotor.c1++;
					}
				}
				if(Rotor.c1>=52 && Rotor.c1<=78) {
					Rotor.nextStep(str3);
					if(Rotor.c1 != 78) {
						Rotor.c1++;
					}
					
					if(Rotor.c1 == 78) {
						Rotor.nextStep(str1);
						Rotor.c1 = 1;
					}
				}

			}
				modelRft.setColumnIdentifiers(columnsRft);
				modelRtr3A.setColumnIdentifiers(columnsRtr3A);
				modelRtr3B.setColumnIdentifiers(columnsRtr3B);
				modelRtr2A.setColumnIdentifiers(columnsRtr2A);
				modelRtr2B.setColumnIdentifiers(columnsRtr2B);
				modelRtr1A.setColumnIdentifiers(columnsRtr1A);
				modelRtr1B.setColumnIdentifiers(columnsRtr1B);
				modelApb.setColumnIdentifiers(columnsApb);
			}
		});
		btnEtpSuivante.setBackground(Color.WHITE);
		btnEtpSuivante.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnEtpSuivante.setBounds(658, 588, 136, 23);
		panel.add(btnEtpSuivante);
		
		//Bouton pour decrypter un message
		JButton btnDecrypter = new JButton("D\u00E9crypter");
		btnDecrypter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelRft.setColumnIdentifiers(columnsRft);
				modelRtr3A.setColumnIdentifiers(columnsRtr3A);
				modelRtr3B.setColumnIdentifiers(columnsRtr3B);
				modelRtr2A.setColumnIdentifiers(columnsRtr2A);
				modelRtr2B.setColumnIdentifiers(columnsRtr2B);
				modelRtr1A.setColumnIdentifiers(columnsRtr1A);
				modelRtr1B.setColumnIdentifiers(columnsRtr1B);
				modelApb.setColumnIdentifiers(columnsApb);
				j = 0;
				String[] str = txtCrypte.getText().split("");
				if(txtClair.getText().length()<str.length) {
				if(txtCrypte.getText() != "") {
					if (str[k].equals(" ")) {
						txtClair.setText(txtClair.getText()+" ");
						k++;
					}
					int index =  Arrays.binarySearch(Rotor.alphabet, str[k].toUpperCase());
					k++;
					   Rotor.encrypt_decrypt(index);
				   
				   String res2 = (String) Rotor.alphabet[res];
				   txtClair.setText(txtClair.getText()+res2);
				   
				   
					tableAlphabet.getColumnModel().getColumn(Rotor.rot0).setHeaderRenderer(new TableCustom());
					tableReflector.getColumnModel().getColumn(Rotor.rot3).setHeaderRenderer(new TableCustom());
					tableRotor3B.getColumnModel().getColumn(Rotor.rot2).setHeaderRenderer(new TableCustom());
					tableRotor2B.getColumnModel().getColumn(Rotor.rot1).setHeaderRenderer(new TableCustom());
					tableRotor1B.getColumnModel().getColumn(Rotor.rot0).setHeaderRenderer(new TableCustom());
					tableReflector.getColumnModel().getColumn(Rotor.ref).setHeaderRenderer(new TableCustom1());
					tableRotor3A.getColumnModel().getColumn(Rotor.ref).setHeaderRenderer(new TableCustom1());
					tableRotor2A.getColumnModel().getColumn(Rotor.rot3a).setHeaderRenderer(new TableCustom1());
					tableRotor1A.getColumnModel().getColumn(Rotor.rot2a).setHeaderRenderer(new TableCustom1());
					tableAlphabet.getColumnModel().getColumn(Rotor.rot1a).setHeaderRenderer(new TableCustom1());


				
					scrollPaneReflector.setViewportView(tableReflector);
					scrollPaneRotor3b.setViewportView(tableRotor3B);
					scrollPaneRotor2b.setViewportView(tableRotor2B);
					scrollPaneRotor1b.setViewportView(tableRotor1B);
					scrollPaneRotor3a.setViewportView(tableRotor3A);
					scrollPaneRotor2a.setViewportView(tableRotor2A);
					scrollPaneRotor1a.setViewportView(tableRotor1A);
					scrollPaneAphabet.setViewportView(tableAlphabet);
				   
				}
				}

			}
		});
		btnDecrypter.setBackground(Color.YELLOW);
		btnDecrypter.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnDecrypter.setBounds(982, 588, 136, 23);
		panel.add(btnDecrypter);		

		//Bouton pour les informations d'utilisation.
		JButton btnHelp = new JButton("?");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object frame = null;
				JOptionPane.showMessageDialog((Component) frame, "Vous devriez entrer la cl� dans le format suivant: R#,G/D,# \n"
						+ "R# = Numero du rotor choisie \n"
						+ "G/D = orientation Gauche ou Droite \n"
						+ "# = Valeur d'orientation \n"
						+ "\nPas d'espace entre les virgules\n"
						+ "Tout en Majuscule\n\n"
						+ "Ex:  R3,D,7   R1,G,-4  R2,G,2");
			}
		});
		btnHelp.setForeground(Color.RED);
		btnHelp.setBackground(Color.LIGHT_GRAY);
		btnHelp.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		btnHelp.setBounds(686, 387, 43, 33);
		panel.add(btnHelp);
		
		//Bouton pour remettre l'interface au parametre initiaux
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rotor.resetTab();
				txtClair.setText("");
				txtCrypte.setText("");
				j = 0;
				k = 0;
				
			//	DefaultTableModel modelRft = new DefaultTableModel();
			//	modelRft.setColumnIdentifiers(columnsRft);
			//	tableReflector.setModel(modelRft);
				

			//	scrollPaneReflector.setViewportView(tableReflector);
				modelRft.setColumnIdentifiers(columnsRft);
				modelRtr3A.setColumnIdentifiers(columnsRtr3A);
				modelRtr3B.setColumnIdentifiers(columnsRtr3B);
				modelRtr2A.setColumnIdentifiers(columnsRtr2A);
				modelRtr2B.setColumnIdentifiers(columnsRtr2B);
				modelRtr1A.setColumnIdentifiers(columnsRtr1A);
				modelRtr1B.setColumnIdentifiers(columnsRtr1B);
				modelApb.setColumnIdentifiers(columnsApb);
			}
		});
		btnReset.setBackground(Color.GRAY);
		btnReset.setForeground(Color.RED);
		btnReset.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		btnReset.setBounds(1029, 353, 89, 23);
		panel.add(btnReset);
		//END-BOUTON-----------------------------------------------------------------------------------------------------------------------
		
	}
	
}
