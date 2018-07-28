package idANDkey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.annotation.XmlAccessOrder;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;


public class TestGet {
	//https://servicios.emtmadrid.es:8443/geo/servicegeo.asmx/getArriveStop?idClient=WEB.SERV.xjose93@hotmail.com&passKey=2205D428-D183-468B-B03B-47F544F0000B&idStop=879&statistics=null&cultureInfo=null%20HTTP/1.1
	
	private final String SERVER = "https://servicios.emtmadrid.es:8443/geo/servicegeo.asmx/";//PARA PETICION GET
	private final String OPERATION = "getArriveStop"; //PARA PETICION GET
	private final String ID_CLIENT = "idClient=WEB.SERV.xjose93@hotmail.com";
	private final String PASS_KEY = "passKey=2205D428-D183-468B-B03B-47F544F0000B";
	private String id_stop;
	
	/**
	 * @param date Formato DD/MM/AAAA
	 * @param lines Lineas de las cuales se quieren obtener los resultados separadas por |
	 */
	public String getSoapXML(String id_stop) {
		this.id_stop = id_stop;
		final String URL = SERVER + OPERATION + "?" + ID_CLIENT + "&" + PASS_KEY + "&idStop="+id_stop+"&statistics=null&cultureInfo=null";
		String aux="<vacío>";
		try {
			URL url = new URL(URL);
			HttpsURLConnection https = (HttpsURLConnection) url.openConnection();
			https.connect();
			
			InputStream in = https.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String line;
			aux="";
			while((line = br.readLine()) != null){
				aux = aux + line+"\n";
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}

	public static void main(String[] args) {
		
		TestGet tg = new TestGet();
		//879 alto de extremadura
		String result = tg.getSoapXML("879");
		System.out.println(result);
		
		
	}
	
	

}
