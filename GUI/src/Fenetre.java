import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class Fenetre extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	// private JOptionPane jop = new JOptionPane();
	// private JOptionPane jop2 = new JOptionPane();
	// private JOptionPane jop3 = new JOptionPane();
	// private JOptionPane jop4 = new JOptionPane();
	private JFileChooser fc = new JFileChooser();
	

		public Fenetre(){

////////////////////////////////////////CREATION DE LA FENETRE////////////////////////////////////////////

	        this.setTitle("Scrap");
	        this.setSize(440, 400);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        container.setBackground(Color.white);
	        container.setLayout(new BorderLayout());
	        
	        JButton b = new JButton ("Demarrer");

////////////////////////////////////////AJOUT DE L'IMAGE DE FOND////////////////////////////////////////////

	        ImagePanel img = new ImagePanel(new ImageIcon("tuto.png").getImage());
	        img.add(b);
	        b.addActionListener(this);
	        this.setContentPane(img);
	        this.setVisible(true);
	    }
		  //Méthode qui sera appelée lors d'un clic sur le bouton
		public void actionPerformed(ActionEvent arg0) {

////////////////////////////////////////AJOUT DES BOITES DE DIALOGUE////////////////////////////////////////////

			String[] id = {"A00QWCCXVJ", "OARHV6SOGW"};
			int type = JOptionPane.QUESTION_MESSAGE;
			String utilisateur = (String)JOptionPane.showInputDialog(null, "Veuillez indiquer votre identifiant !", "Utilisateur", type, null, id, id[1]);
			String spdc = JOptionPane.showInputDialog(null, "Copiez votre cookie spdc ici !", "SPDC", JOptionPane.QUESTION_MESSAGE);
	        String lemondgfip = JOptionPane.showInputDialog(null, "Copiez votre cookie lemondgfip ici !", "lEMONDGFIP", JOptionPane.QUESTION_MESSAGE);
	        String nb = JOptionPane.showInputDialog(null, "Combien de secondes entre chaque requetes ?", "SECONDES", JOptionPane.QUESTION_MESSAGE);
            int time = Integer.parseInt(nb);
	        fc.showOpenDialog(null);
	        File file = fc.getSelectedFile();	// RECUPERATION DU FICHIER D'ENTREES        
	        try
	        {	        	
	        		BufferedReader reader = new BufferedReader(new FileReader(file));
	        		String line;
	        	 	ArrayList<String> cookies = new ArrayList<String>();
					 String office ="";
					 
					 ////////////////////////////////////////PARAMETRAGE DES COOKIES EN FONCTION DE L'ID UTILISÉ////////////////////////////////////////////

	        	 	if (utilisateur != null && utilisateur == "A00QWCCXVJ") {
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
		        	 	cookies.add("Utilisateur="+utilisateur);
		        	 	cookies.add("lemondgfip="+lemondgfip);
		        	 	office = "OKZCD1NP5U";
	        	 	}
	        	 	else if (utilisateur == "OARHV6SOGW") {
		        	 	cookies.add("jamyMailAdr=");
		        	 	cookies.add("jamyDNStructure=uid%3D33O8K76WJG%2Cou%3DPRO65650%2Cou%3Dabonnes%2Ddgi%2Cou%3Dmefi%2Co%3Dgouv%2Cc%3Dfr");
		        	 	cookies.add("perstrace=MAJAC+Pierre");
		        	 	cookies.add("jamyDroits=T");
		        	 	cookies.add("Annuaire=O");
		        	 	cookies.add("jamyDNUser=uid%3DOARHV6SOGW%2Cuid%3D33O8K76WJG%2Cou%3DPRO65650%2Cou%3Dabonnes%2Ddgi%2Cou%3Dmefi%2Co%3Dgouv%2Cc%3Dfr");
		        	 	cookies.add("ckProfilcat=Consult");
		        	 	cookies.add("ASPSESSIONIDCQSTRBCB=JLALOPDCNEOKELGEDCJLEIMP");
		        	 	cookies.add("ASPSESSIONIDAQRRQCAC=MEDAKFECMHJDFCPBIILIBLJH");
		        	 	cookies.add("ASPSESSIONIDQCSRRDAC=GCDCIFECDJOJFHBJHOJALPOI");
		        	 	cookies.add("ASPSESSIONIDSCTSTBAD=FBAIJFFCMDLIPMIIPOPGCJKM");
		        	 	cookies.add("ASPSESSIONIDCQQRQADA=KOJBNKFCNBNAOABILFPFOMHF");
		        	 	cookies.add("CcodepM1=000");
		        	 	cookies.add("CcocomM1=+++");
		        	 	cookies.add("M1EnCours=0");
		        	 	cookies.add("TypeStruct=O");
		        	 	cookies.add("spdc="+spdc);
		        	 	cookies.add("Office=33O8K76WJG");
		        	 	cookies.add("Utilisateur="+utilisateur);
		        	 	cookies.add("lemondgfip="+lemondgfip);
		        	 	office = "33O8K76WJG";		        	 	
	        	 	}
					 BufferedWriter result = new BufferedWriter(new FileWriter(new File("resultats.csv")));  // CREATION DU FICHIER DE RESULTATS
					 
	        		while ((line = reader.readLine()) != null)
	        		{
	        			int Error = 0;
	        			String[] code = line.split(", ");
						Request re = new Request();
						String url = "http://spdc.dgfip.finances.gouv.fr/cdc_titulaires.asp?txtOffice="+office+"&txtCcodep=0"+code[0]+"&txtCcocom="+code[1]+"&txtSession="+spdc+"&txtUtilisateur="+utilisateur+"&txtCcoprf=&txtCcosec="+code[2]+"&txtDnupla=00"+code[3]+"&txtTypeTrait=10";
						
						String page = re.GetPageContent(url, cookies, spdc, lemondgfip); // RECUPERATION DE LA PAGE HTML CORRESPONDANT A LA REQUETE
						// System.out.printf("/////////////////////////");
						// System.out.println(page);
						// System.out.printf("/////////////////////////\n");
						Clear render = new Clear(page, result, code);  // SUPPRESSION DES BALISES HTML
						TimeUnit.SECONDS.sleep(time);
	        		}
	        		reader.close();
	        		result.close();
	        		new JOptionPane();
	        		JOptionPane.showMessageDialog(null, "Un fichier resultats.csv vient d'etre cree sur votre bureau.", "Operation terminee", JOptionPane.INFORMATION_MESSAGE);
	         }
	         catch (Exception e)
	         {
	        	 	System.err.format("Exception occurred trying to read :"+ file + "%n");
	        	 	e.printStackTrace();
	         }
		}
}