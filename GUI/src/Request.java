import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class Request{
	
	 	public HttpURLConnection conn;
	 	public final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36";
	public Request() throws Exception {
  				CookieHandler.setDefault(new CookieManager());
	}

  		//////////////////////////////////////////////LA METHODE GETPAGECONTENT RECUPERE LA PAGE WEB EN HTML//////////////////////////////////////////////


  	public String GetPageContent(String url, ArrayList<String> cookies, String spdc, String lemondgfip) throws Exception {

		URL obj = new URL(url);
		conn = (HttpURLConnection) obj.openConnection();

		conn.setRequestMethod("GET"); // DEFINITION DE LA METHODE (GET)
		
		conn.setUseCaches(false);

		// PARAMETRAGE DE LA REQUETE (TOUT CE QUE LE NAVIGATEUR UTILISE POUR EXECUTER LA REQUETE)
		conn.setRequestProperty("Host", "spdc.dgfip.finances.gouv.fr");
		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		conn.setRequestProperty("Accept-Language", "fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		for (String s : cookies) {
			conn.addRequestProperty("Cookie", s);
		}
		conn.addRequestProperty("Cookie", "spdc="+spdc);
		conn.addRequestProperty("Cookie", "lemondgfip="+lemondgfip);
		conn.setRequestProperty("Connection", "keep-alive");
		conn.setRequestProperty("Referer", "http://spdc.dgfip.finances.gouv.fr/cdc_listepar.asp");
		conn.setRequestProperty("Content-Type", "text/html");
		int responseCode = conn.getResponseCode();
		// AFFICHAGE DE LA REQUETE ET DE SON CODE REPONSE
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in =
	            new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine + "\n");
		}
		in.close();
		return response.toString();
  	}
}
