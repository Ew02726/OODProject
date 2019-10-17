
public class ParkingSpot implements Command{
	boolean isOpen = true;
	String type;
	
	//implement on function from Command interface to show parking spot is open.
	public void on() {
		this.isOpen = true;
	}
	
	//implement off function from Command interface to show parking spot is closed.
	public void off() {
		this.isOpen = false;
	}
	
	public void setType(String type) {
		//set the type = Car.
		if(type.equals("Car")) {
			this.type = type;
		}
		
		//set the type = Motorcycle.
		else if(type.equals("Motorcycle")) {
			this.type = type;
		}
	}
}
