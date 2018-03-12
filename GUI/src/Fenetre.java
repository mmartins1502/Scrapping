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
	private JOptionPane jop = new JOptionPane();
	private JOptionPane jop2 = new JOptionPane();
	private JOptionPane jop3 = new JOptionPane();
	private JFileChooser fc = new JFileChooser();
	

		public Fenetre(){
	        this.setTitle("Scrap");
	        this.setSize(440, 400);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        container.setBackground(Color.white);
	        container.setLayout(new BorderLayout());
	        
	        JButton b = new JButton ("Demarrer");

	        ImagePanel img = new ImagePanel(new ImageIcon("tuto.png").getImage());
	        img.add(b);
	        b.addActionListener(this);
	        this.setContentPane(img);
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
	        try
	        {
	        		BufferedReader reader = new BufferedReader(new FileReader(file));
	        		String line;
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
	        	 	BufferedWriter result = new BufferedWriter(new FileWriter(new File("resultats.csv")));
	        		while ((line = reader.readLine()) != null)
	        		{
	        			int Error = 0;
	        			String[] code = line.split(";");
	        			Request re = new Request();
	    	          	String url = "http://spdc.dgfip.finances.gouv.fr/cdc_titulaires.asp?txtOffice=OKZCD1NP5U&txtCcodep=0"+code[0]+"&txtCcocom="+code[1]+"&txtSession="+spdc+"&txtUtilisateur=A00QWCCXVJ&txtCcoprf=&txtCcosec="+code[2]+"&txtDnupla=00"+code[3]+"&txtTypeTrait=10";
		      		String page = re.GetPageContent(url, cookies, spdc, lemondgfip);
      				System.out.println(page);
		      		List<String> lines = new ArrayList<String>();
		      		lines.addAll(Arrays.asList(page.split("\\r?\\n")));
		      		for (int i = 0; i < 50; i++) {
		      			if (lines.size() == 0) {
		      				System.out.printf("Liste vide ! %n");
		      				Error += 1;
		      				break;
		      			}
		      			else
		      				lines.remove(0);
		      		}
		      		for (int i = 31; i > 8; i--) {
		      			if (lines.size() == 0) {
//		      				System.out.printf("Liste vide ! %n");
		      				break;
		      			}
		      			else
		      				lines.remove(i);		      		}

		      		StringBuilder sb = new StringBuilder();
		      		for (String s : lines)
		      		{
		      		    sb.append(s);
		      		    sb.append("\n");
		      		}
		      		String str = sb.toString();
	      		    str = str.replace("\t\t\t\t<td width=\"20%\"><font face=\"Times New Roman\" size=\"2\">", "");
	      		    str = str.replace("\t\t\t\t<td width=\"3%\"><font face=\"Times New Roman\" size=\"2\">", "");
	      		    str = str.replace("\t\t\t\t<td width=\"10%\"><font face=\"Times New Roman\" size=\"2\">", "");
	      		    str = str.replace("\t\t\t\t<td width=\"15%\"><font face=\"Times New Roman\" size=\"2\">", "");
	      		    str = str.replace("\t\t\t\t<td width=\"29%\"><font face=\"Times New Roman\" size=\"2\">", "");
	      		    str = str.replace("\t\t\t\t<td width=\"29%\" align=\"left\"><font face=\"Times New Roman\" size=\"2\">", "");
	      		    str = str.replace("</FONT></td>", "");
	      		    str = str.replace("</FONT>", "");
	      		    str = str.replace("<br/>", "");
	      		    str = str.replace("\t", "");
	      		    str = str.replace("\n", ", ");
	      		    str = str.replace(", , ", ", ");
	      		    str = str.replace("  ", ", ");
	      		    str += "\n";
	      		    System.out.println(str);
	      		    try {
	      		    		if (Error == 0) {
	      		    			result.write(str);
	      		    		} else {
	      		    			result.write("Pas de Titulaires !\n");
	      		    		}
	      		    }
	      		    catch (IOException e)
	      		    {
	      			   e.printStackTrace();
	      		    }
	      		    TimeUnit.SECONDS.sleep(time);
	        		}
	        		reader.close();
	        		result.close();
	        		JOptionPane finish;
	        		finish = new JOptionPane();
	        		finish.showMessageDialog(null, "Un fichier resultats.csv vient d'etre cree sur votre bureau.", "Operation terminee", JOptionPane.INFORMATION_MESSAGE);


	         }
	         catch (Exception e)
	         {
	        	 	System.err.format("Exception occurred trying to read :"+ file + "%n");
	        	 	e.printStackTrace();
	         }
		}
}