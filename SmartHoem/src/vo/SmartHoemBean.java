package vo;

import java.sql.Date;

public class SmartHoemBean {
	private int no;  //1
	private String name;
	private String id;
	private String pass;
	private int Temperature;
	private int Humidity;
	private int Illuminance;
	
	
	@Override
	public String toString() {
		return "SmartHoemBean [no=" + no + ",name=" + name + ", id=" + id+ ", pass=" + pass + 
				",Temperature =" + Temperature + ", Humidity=" + Humidity
				+ ", Illuminance=" + Illuminance + "]";
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getTemperature() {
		return Temperature;
	}
	public void setTemperature(int temperature) {
		Temperature = temperature;
	}
	public int getHumidity() {
		return Humidity;
	}
	public void setHumidity(int humidity) {
		Humidity = humidity;
	}
	public int getIlluminance() {
		return Illuminance;
	}
	public void setIlluminance(int illuminance) {
		Illuminance = illuminance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	private Date date; //11
	
}
	