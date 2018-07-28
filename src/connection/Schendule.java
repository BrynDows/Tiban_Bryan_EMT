package connection;


/**
 * Clase que representa la estructura de datos de un fichero JSON
 * obtenido desde la página http://opendata.emtmadrid.es/. en concreto el texto obtenido
 * con el método GetTimeTableLines
 * @author Bryan Ti
 *
 */
public class Schendule {
	private int cc;
	private String date; //formato dd/mm/yy
	private String typeDay;
	private String line;
	private int direction;
	private String trip;
	private String timeFirst;
	private String timeEnd;
	
	public Schendule() {};
	
	public Schendule(int cc, String date, String typeDay, String line, int direction, String trip, String timeFirst,
			String timeEnd) {
		super();
		this.cc = cc;
		this.date = date;
		this.typeDay = typeDay;
		this.line = line;
		this.direction = direction;
		this.trip = trip;
		this.timeFirst = timeFirst;
		this.timeEnd = timeEnd;
	}

	public Schendule(String timeFirst, String timeEnd) {
		super();
		this.timeFirst = timeFirst;
		this.timeEnd = timeEnd;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public String getDirection() {
		if(direction == 1) {
			return "ida";
		}else {
			return "vuelta";
		}
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTypeDay() {
		return typeDay;
	}

	public void setTypeDay(String typeDay) {
		this.typeDay = typeDay;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

	public String getTimeFirst() {
		return timeFirst;
	}

	public void setTimeFirst(String timeFirst) {
		this.timeFirst = timeFirst;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Override
	public String toString() {
		return "Schendule [cc=" + cc + ", date=" + date + ", typeDay=" + typeDay + ", line=" + line + ", direction="
				+ direction + ", trip=" + trip + ", timeFirst=" + timeFirst + ", timeEnd=" + timeEnd + "]";
	}
	
	
	
		

}
