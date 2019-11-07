
public class Car implements Vehicle, CarInterface {
	final String type = "Car";
	String Make;
	String Model;
	String plateNum;
	
	public Car(String Make, String Model, String plateNum) {
		this.Make = Make;
		this.Model = Model;
		this.plateNum = plateNum;
	}
	
	public String getType() {
		return this.type;
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
