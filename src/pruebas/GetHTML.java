package pruebas;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetHTML {

	public static void main(String[] args) {
		int busLine = 36;
		try {
		URL u = new URL("http://www.emtmadrid.es/Bloques-EMT/EMT-BUS/Mi-linea-(1).aspx?linea="+busLine+"&lang=es-ES");
		HttpURLConnection http = (HttpURLConnection) u.openConnection();
		http.connect();
		InputStream isr = http.getInputStream();
		InputStreamReader in = new InputStreamReader(isr);
		
		BufferedReader br = new BufferedReader(in);
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
