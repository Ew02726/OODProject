
public class HandicapSpotDecorator extends ParkingSpotDecorator{

	public HandicapSpotDecorator(ParkingSpotInterface decoratedSpot) {
		super(decoratedSpot);
		isHandicapSpot(false);
	}
	
	@Override
	public String type() {
		return decoratedSpot.type();
	}

	@Override
	public void isHandicapSpot(boolean isHandicap) {
		decoratedSpot.isHandicapSpot(isHandicap);
	}
	
}
