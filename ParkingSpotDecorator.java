
public abstract class ParkingSpotDecorator implements ParkingSpotInterface {

	protected ParkingSpotInterface decoratedSpot;
	
	
	public ParkingSpotDecorator(ParkingSpotInterface decoratedSpot) {
		this.decoratedSpot = decoratedSpot;
	}
	
	@Override
	public String type() {
		return decoratedSpot.type();
	}

}
