package pruebas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;

public class GetEMT {
	
	public ArrayList<String> getLines(int lineBus) {
		
		String url = "http://www.emtmadrid.es/Bloques-EMT/EMT-BUS/Mi-linea-(1).aspx?linea="+lineBus+"&lang=es-ES";
		String str = "Sin resultados";
		ArrayList<String> list = new ArrayList<>();
		
		try {
			Document doc = Jsoup.connect(url).get();
			Elements s = doc.select("tr");
			str = s.text();
			String line="";
			
			byte[] bytes = str.substring(74).getBytes();
			
			for (int i = 0; i < bytes.length; i++) {
				line = line + new String(new byte[] {bytes[i]},"ASCII");
				if((bytes[i] >= '0' && bytes[i] <='9') && bytes[i+1] == ' ') {
					list.add(line);
					line ="";
				}
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\n\n----FIN-----");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		GetEMT e = new GetEMT();
		
		ArrayList<String> a = e.getLines(151);
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}

}
