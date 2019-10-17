
public class Motorcycle implements Command{
	boolean isShown = false;
	
	//implement on function from Command interface.
	public void on() {
		this.isShown = true;	
	}
	
	//implement off function from Command interface.
	public void off() {
		this.isShown = false;
	}
}
