
public class ParkingSpot implements Command{
	boolean isOpen = true;
	String type;
	
	 ParkingSpot(String type) {
		this.type = type;
	}
	//implement on function from Command interface to show parking spot is open.
	public void on() {
		this.isOpen = true;
	}
	
	//implement off function from Command interface to show parking spot is closed.
	public void off() {
		this.isOpen = false;
	}
	
	
}
