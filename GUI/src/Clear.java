import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clear {

	public Clear(String page, BufferedWriter result, String[] code) {
		String raison = "Raison sociale";
		String sexe = "Sexe";
		
  		//////////////////////////////////////////////COPROPRIETE//////////////////////////////////////////////

		if (page.contains(raison) == true)
		{
			// System.out.printf("Raison Sociale\n\n");
			
			int Error = 0;
			List<String> lines = new ArrayList<String>();
      		lines.addAll(Arrays.asList(page.split("\\r?\\n")));
      		
      		
      		

      		///////////////////// SUPPRESSION DU HTML DE DEBUT DE PAGE
  
      		
      		
      		for (int i = 0; i < 40; i++) {
      			if (lines.size() == 0) {
      				System.out.printf("Liste vide ! %n");
      				Error += 1;
      				break;
      			}
      			else
      				lines.remove(0);
      		}
      			
          	
      		///////////////////// SUPPRESSION DU HTML DE FIN DE PAGE
      		
      		int decount = lines.size();
      		for (int i = decount - 1; i > (decount - 22); i--) {
      			if (lines.size() == 0)
      				break;
      			else {
      				lines.remove(i);
      			}
  			}
      		
      		
      		///////////////////// SUPPRESSION DU HTML PARMIS LES INFOS
      		

      		
      		StringBuilder sb = new StringBuilder();
      		for (String s : lines)
      		{
      		    sb.append(s);
      		    sb.append("\n");
      		}
      		String str = sb.toString();
      		str = str.replace("				    <td width=\"35%\"><font face=\"Times New Roman\" size=\"2\">", "");
  		    str = str.replace("					<td width=\"15%\"><font face=\"Times New Roman\" size=\"2\">", "");
  		    str = str.replace("					<TD width=\"10%\"><FONT color=\"White\">", "");
  		    str = str.replace("					<td width=\"5%\"><font face=\"Times New Roman\" size=\"2\">", "");
  		    str = str.replace("					<td width=\"35%\" align=\"left\"><font face=\"Times New Roman\" size=\"2\">\n" + 
  		    		"					", "");
  		    str = str.replace("</FONT></td>", "");
  		    str = str.replace("</FONT></TD>", "");
  		    str = str.replace("</FONT>", "");
  		    str = str.replace(" <br/>", "");
  		    
  		    str = str.replace("\n", ", ");
  		    str = str.replace(", , ", ", ");
  		    str = str.replace("  ", ", ");
  		    str = str.replace(", , , , ", "\n");
  		    str += "\n";
  		    
   
  		    
      		///////////////////// ECRITURE DES INFOS DANS UN FICHIER

    
  		    
  		    // System.out.println(str);
  		    try {
  					result.write("Parcelle : "+code[0]+" "+code[1]+" "+code[2]+" "+code[3]+"\n");
  					result.write("Raison Sociale, Numero SIREN, Sigle, Droit, Adresse des titulaires de droit\n");
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
      	
		}
		
  		//////////////////////////////////////////////MONOPROPRIETE//////////////////////////////////////////////

		else if (page.contains(sexe) == true)
		{
			// System.out.printf("Monopropriete\n\n");
			
			int Error = 0;
			List<String> lines = new ArrayList<String>();
      		lines.addAll(Arrays.asList(page.split("\\r?\\n")));
      		
      		
      		

      		///////////////////// SUPPRESSION DU HTML DE DEBUT DE PAGE
  
      		
      		
      		for (int i = 0; i < 50; i++) {
      			if (lines.size() == 0) {
      				System.out.printf("Liste vide ! %n");
      				Error += 1;
      				break;
      			}
      			else
      				lines.remove(0);
      		}
      		
      		
      	
      		///////////////////// SUPPRESSION DU HTML DE FIN DE PAGE
      		
      		int decount = lines.size();
      		for (int i = decount - 1; i > (decount - 24); i--) {
      			if (lines.size() == 0)
      				break;
      			else {
      				lines.remove(i);
      			}
  			}

      		
      		///////////////////// SUPPRESSION DU HTML PARMIS LES INFOS
      		

      		
      		StringBuilder sb = new StringBuilder();
      		for (String s : lines)
      		{
      		    sb.append(s);
      		    sb.append("\n");
      		}
      		String str = sb.toString();
      		str = str.replace("				  <TD width=\"20%\"><FONT color=White>", "");
  		    str = str.replace("\t\t\t\t<td width=\"20%\"><font face=\"Times New Roman\" size=\"2\">", "");
  		    str = str.replace("\t\t\t\t<td width=\"3%\"><font face=\"Times New Roman\" size=\"2\">", "");
  		    str = str.replace("\t\t\t\t<td width=\"10%\"><font face=\"Times New Roman\" size=\"2\">", "");
  		    str = str.replace("\t\t\t\t<td width=\"15%\"><font face=\"Times New Roman\" size=\"2\">", "");
  		    str = str.replace("\t\t\t\t<td width=\"29%\"><font face=\"Times New Roman\" size=\"2\">", "");
  		    str = str.replace("\t\t\t\t<td width=\"29%\" align=\"left\"><font face=\"Times New Roman\" size=\"2\">", "");
  		    str = str.replace("</FONT></td>", "");
  		    str = str.replace("</FONT></TD>", "");
  		    str = str.replace("</FONT>", "");
  		    str = str.replace("					</td>", "");
  		    str = str.replace("				</tr>", "");
  		    str = str.replace("			 <tr align=\"middle\">", "\n");
  		    str = str.replace("<br/>", "");
  		    str = str.replace("\t", "");
  		    str = str.replace("\n", ", ");
  		    str = str.replace(", , ", ", ");
  		    str = str.replace("  ", ", ");
  		    str = str.replace(", , , , ", "\n");
  		    str += "\n";
  		    
  		    
      		///////////////////// ECRITURE DES INFOS DANS UN FICHIER

  		    
  		    
  		    
  		    // System.out.println(str);
  		    try {
  					result.write("Parcelle : "+code[0]+" "+code[1]+" "+code[2]+" "+code[3]+"\n");
  					result.write("Nom / Prénom, Sexe, Date de naissance, Lieu de naissance, Nom et prénom du conjoint, Droit, Adresse des titulaires de droit\n");
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
		}
	}

}
