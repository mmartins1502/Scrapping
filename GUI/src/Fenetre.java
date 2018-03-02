import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
//import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class Fenetre extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private JLabel text = new JLabel("Veuillez suivre les instructions suivantes :");
	private JButton b = new JButton ("Demarrer");
	private JOptionPane jop = new JOptionPane();
	private JOptionPane jop2 = new JOptionPane();
	private JOptionPane jop3 = new JOptionPane();
	private JFileChooser fc = new JFileChooser();
	

		public Fenetre(){
	        this.setTitle("Scrap");
	        this.setSize(300, 300);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        container.setBackground(Color.white);
	        container.setLayout(new BorderLayout());
	        
	        JPanel top = new JPanel();
	        b.addActionListener(this);

	        top.add(text);
	        top.add(b);
	        
	        this.setContentPane(top);
	        this.setVisible(true);
	    }
		  //Méthode qui sera appelée lors d'un clic sur le bouton
		public void actionPerformed(ActionEvent arg0) {
	        String spdc = jop.showInputDialog(null, "Copiez votre cookie spdc ici !", "SPDC", JOptionPane.QUESTION_MESSAGE);
	        String lemondgfip = jop2.showInputDialog(null, "Copiez votre cookie lemondgfip ici !", "lEMONDGFIP", JOptionPane.QUESTION_MESSAGE);
	        String nb = jop3.showInputDialog(null, "Combien de secondes entre chaque requetes ?", "SECONDES", JOptionPane.QUESTION_MESSAGE);
            int time = Integer.parseInt(nb);
	        fc.showOpenDialog(null);
	        File file = fc.getSelectedFile();
//	        ConvertCSV.file = new ConvertCSV(filexls);
	        
	        try
	        {
	        		BufferedReader reader = new BufferedReader(new FileReader(file));
	        		String line;
//	        	 	String cookies = "jamyMailAdr=sebastien%2Edurand%40notaires%2Efr; jamyDNStructure=uid%3DOKZCD1NP5U%2Cou%3DPRO65650%2Cou%3Dabonnes%2Ddgi%2Cou%3Dmefi%2Co%3Dgouv%2Cc%3Dfr; perstrace=S+DURAND; jamyDroits=T; Annuaire=O; jamyDNUser=uid%3DA00QWCCXVJ%2Cuid%3DOKZCD1NP5U%2Cou%3DPRO65650%2Cou%3Dabonnes%2Ddgi%2Cou%3Dmefi%2Co%3Dgouv%2Cc%3Dfr; ckProfilcat=Consult; ASPSESSIONIDCQRRRCCD=PMCHPFAABFIPLEDKNCBODCKN; M1EnCours=0; ASPSESSIONIDSSTRRDCD=ADJCBIAABMOGHDIGCLLKFOIO; ASPSESSIONIDAQSTQCCC=ACIHMOHACFDKNIPLEFHFKPDO; ASPSESSIONIDQQSQRDDD=BPEGNGJAIOJCFENJFMBIAHHL; ASPSESSIONIDQQRSRDCB=CHGBEJHAMKOAMPOIKGHMOKKC; CcodepM1=000; CcocomM1=+++; TypeStruct=O; Office=OKZCD1NP5U; Utilisateur=A00QWCCXVJ;";
	        	 	ArrayList<String> cookies = new ArrayList<String>();
	        	 	cookies.add("jamyMailAdr=sebastien%2Edurand%40notaires%2Efr");
	        	 	cookies.add("jamyDNStructure=uid%3DOKZCD1NP5U%2Cou%3DPRO65650%2Cou%3Dabonnes%2Ddgi%2Cou%3Dmefi%2Co%3Dgouv%2Cc%3Dfr");
	        	 	cookies.add("perstrace=S+DURAND");
	        	 	cookies.add("jamyDroits=T");
	        	 	cookies.add("Annuaire=O");
	        	 	cookies.add("jamyDNUser=uid%3DA00QWCCXVJ%2Cuid%3DOKZCD1NP5U%2Cou%3DPRO65650%2Cou%3Dabonnes%2Ddgi%2Cou%3Dmefi%2Co%3Dgouv%2Cc%3Dfr");
	        	 	cookies.add("ckProfilcat=Consult");
	        	 	cookies.add("ASPSESSIONIDCQRRRCCD=PMCHPFAABFIPLEDKNCBODCKN");
	        	 	cookies.add("ASPSESSIONIDSSTRRDCD=ADJCBIAABMOGHDIGCLLKFOIO");
	        	 	cookies.add("ASPSESSIONIDAQSTQCCC=ACIHMOHACFDKNIPLEFHFKPDO");
	        	 	cookies.add("ASPSESSIONIDQQSQRDDD=BPEGNGJAIOJCFENJFMBIAHHL");
	        	 	cookies.add("ASPSESSIONIDQQRSRDCB=CHGBEJHAMKOAMPOIKGHMOKKC");
	        	 	cookies.add("CcodepM1=000");
	        	 	cookies.add("CcocomM1=+++");
	        	 	cookies.add("M1EnCours=0");
	        	 	cookies.add("ASPSESSIONIDSSTRQDDD=AKMBLHLALOKJCCLHCKPHMDGD");
	        	 	cookies.add("TypeStruct=O");
	        	 	cookies.add("spdc="+spdc);
	        	 	cookies.add("Office=OKZCD1NP5U");
	        	 	cookies.add("Utilisateur=A00QWCCXVJ");
	        	 	cookies.add("lemondgfip="+lemondgfip);
	        		while ((line = reader.readLine()) != null)
	        		{
	        			String[] code = line.split(";");
	        			Request re = new Request();
	    	          	String url = "http://spdc.dgfip.finances.gouv.fr/cdc_titulaires.asp?txtOffice=OKZCD1NP5U&txtCcodep=0"+code[0]+"&txtCcocom="+code[1]+"&txtSession="+spdc+"&txtUtilisateur=A00QWCCXVJ&txtCcoprf=&txtCcosec="+code[2]+"&txtDnupla=00"+code[3]+"&txtTypeTrait=10";
		      		String page = re.GetPageContent(url, cookies, spdc, lemondgfip);
		      		System.out.printf("Page : %s\n", page);
	        			TimeUnit.SECONDS.sleep(time);
	        		}
	        		reader.close();
	         }
	         catch (Exception e)
	         {
	        	 	System.err.format("Exception occurred trying to read :"+ file + "%n");
	        	 	e.printStackTrace();
	         }
		}
}