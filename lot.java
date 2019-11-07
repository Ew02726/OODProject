
public class lot implements ParkingLot{

	@Override
	public void on() {
		System.out.println("Lot Open");
		
	}

	@Override
	public void off() {
		System.out.println("Lot Closed");
		
	}
	

}
