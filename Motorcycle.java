
public class Motorcycle implements Command,MotorcycleInterface{
	boolean isShown = false;
	String type  = "Motorcycle";
	boolean handicap = true;
	
	//implement on function from Command interface.
	public void on() {
		this.isShown = true;	
	}
	
	//implement off function from Command interface.
	public void off() {
		this.isShown = false;
	}

	@Override
	public String type() {
		return this.type;
	}

	public boolean isHandicap() {
		return handicap;
	}

	public void setHandicap(boolean handicap) {
		this.handicap = handicap;
	}
	
}
