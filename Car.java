
public class Car implements Command,CarInterface {
	boolean isShown = false;
	String type = "car";
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
