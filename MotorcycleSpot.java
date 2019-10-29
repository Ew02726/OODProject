
public class MotorcycleSpot implements Command, ParkingSpotInterface{
	boolean isOpen = true;
	public boolean handicap = true;
	String type;
	
	public MotorcycleSpot(String type) {
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
	
	@Override
	public String type() {
		return this.type;
	}

	@Override
	public void isHandicapSpot(boolean isHandicap) {
		handicap = isHandicap;
	}
	
}
