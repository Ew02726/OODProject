
public class Motorcycle implements Vehicle{
	final String type = "Motorcycle";
	String Make;
	String Model;
	String plateNum;
	
	public Motorcycle(String Make, String Model, String plateNum) {
		this.Make = Make;
		this.Model = Model;
		this.plateNum = plateNum;
	}
	
	public void setMake(String make) {
		this.Make = make;
	}
	
	public void setModel(String model) {
		this.Model = model;
	}
	
	public void setPlateNum(String platenum) {
		this.plateNum = platenum;
	}
	
	public String getType() {
		return type;
	}
	
	public String getMake() {
		return Make;
	}
	
	public String getModel() {
		return Model;
	}
	
	public String getPlateNum() {
		return plateNum;
	}
	
}
