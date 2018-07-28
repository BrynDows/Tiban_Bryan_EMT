package connection;

import java.util.ArrayList;

import org.json.*;

/**
 * Esta clase permite obtener valores de una linea de autobus EMT
 * 
 * @author Bryan Ti
 *
 */
public class BusSchenduleJSON {

	/**
	 * Este método realiza una lectura de un fichero JSON, de manera que obtiene del
	 * mismo los valores deseados por formar un objeto {@link Schendule}
	 * 
	 * @param JSON
	 *            El texto JSON de la página http://opendata.emtmadrid.es/, en
	 *            concreto el texto generado por el método GetTimeTableLines.
	 * @return {@link ArrayList} de objetos {@link Schendule}
	 */
	public ArrayList<Schendule> getSchendule(String JSON) {

		ArrayList<Schendule> list = new ArrayList<>();
		JSONObject obj;
		JSONArray arr = null;
		// {} objectos
		// [] matrices
		// \"name\" nodos

		try {
			obj = new JSONObject(JSON);
			arr = obj.getJSONArray("resultValues");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int i = 0; i < arr.length(); i++) {

			JSONObject jso = null;

			try {
				jso = arr.getJSONObject(i);
			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}
			int cc;
			try {
				cc = jso.getInt("CC");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				cc = -1;
			}

			String date;
			try {
				date = jso.getString("Date");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				date = "Sin valor";
			}

			String typeDay;
			try {
				typeDay = jso.getString("typeDate");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				typeDay = "Sin valor";
			}

			String line;
			try {
				line = jso.getString("line");
			} catch (JSONException e1) {
				line = "Sin valor";
			}

			int direction;
			try {
				direction = jso.getInt("direction");
			} catch (JSONException e1) {
				direction = -1;
			}

			String trip;
			try {
				trip = jso.getString("trip");
			} catch (JSONException e1) {
				trip = "Sin valor";
			}

			String timeFirst;
			try {
				timeFirst = jso.getString("timeFirst");
			} catch (JSONException e) {
				timeFirst = "Sin valor";
			}
			String timeEnd;
			try {
				timeEnd = jso.getString("timeEnd");
			} catch (JSONException e) {
				timeEnd = "Sin valor";
			}

			list.add(new Schendule(cc, date, typeDay, line, direction, trip, timeFirst, timeEnd));
		}
		return list;
	}

}
