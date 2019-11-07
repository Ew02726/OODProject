
//Use this adapter in cases where a motorcycle is too big for a motorcycle spot and thus needs the space of a car spot.

public class MotorcycleAdapter implements CarInterface {
	Motorcycle motorcycle;
	public MotorcycleAdapter(Motorcycle m) {
		this.motorcycle = m;
	}
	
	public String getType() {
		return "Car";
	}
}
