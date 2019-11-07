public class FacadeParking {

	private ParkingLot lot;
	
	
	public FacadeParking() {
		lot = new lot();
		
	}
	
	public void LotParkingOn() {
		lot.on();
		
	}
	
	public void LotParkingOff() {
		lot.off();
		
	}
}
