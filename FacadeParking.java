package oodFinal;

public class FacadeParking {

	private ParkingLot carParking;
	private ParkingLot motercycleParking;
	
	public FacadeParking() {
		carParking = new CarParking();
		motercycleParking = new MotercycleOpen();
	}
	
	public void LotParkingOn() {
		System.out.println("Lot parking open");
		carParking.on();
		motercycleParking.on();
	}
	
	public void LotParkingOff() {
		System.out.println("Lot parking closed");
		carParking.off();
		motercycleParking.off();
	}
}
