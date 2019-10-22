
public class MotorcycleAdapter implements CarInterface {
	private MotorcycleInterface mi;
	
	public MotorcycleAdapter(MotorcycleInterface mi) {
		this.mi = mi;
	}
	@Override
	public String type() {
		mi.type();
		return null;
	}

}
