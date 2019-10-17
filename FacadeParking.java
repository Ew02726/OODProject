public class FacadeParking {

	private ParkingLot carParking;
	private ParkingLot motorcycleParking;
	
	public FacadeParking() {
		carParking = new CarParking();
		motorcycleParking = new MotercycleOpen();
	}
	
	public void LotParkingOn() {
		System.out.println("Lot parking open");
		carParking.on();
		motorcycleParking.on();
	}
	
	public void LotParkingOff() {
		System.out.println("Lot parking closed");
		carParking.off();
		motorcycleParking.off();
	}
}
