
public class Car implements Command,CarInterface {
	boolean isShown = false;
	String type = "car";
	
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
}
