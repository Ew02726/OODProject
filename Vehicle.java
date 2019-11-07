//Interface that both Car and Motorcycle class implements
public interface Vehicle {
	public String getType();
	public String getMake();
	public String getModel();
	public String getPlateNum();
	public void setMake(String make);
	public void setModel(String model);
	public void setPlateNum(String platenum);
}
