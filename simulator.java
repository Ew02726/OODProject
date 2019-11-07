import java.util.ArrayList;

import javax.swing.JFrame;

//tester class
public class simulator {
	//test variables for observer
	public static ArrayList<ParkingSpot> ParkingSpotsList = new ArrayList<ParkingSpot>();
	public static int carSpotCount = 100;
	public static int motorcycleSpotCount = 20;
	public static ParkingLotGUI mainParkingLotGUI;
	
	public static void main(String[] args) {
		//facade Pattern
		FacadeParking fp = new FacadeParking();
		fp.LotParkingOn();
		fp.LotParkingOff();
		
		//test for observer
		mainParkingLotGUI = new ParkingLotGUI();
		
		for (int x = 0; x < carSpotCount; x++) {
			ParkingSpotsList.add(new ParkingSpot("Car", x));
			ParkingSpotsList.get(x).addObserver(mainParkingLotGUI);
		}
		
		for (int x = carSpotCount; x < (carSpotCount + motorcycleSpotCount); x++) {
			ParkingSpotsList.add(new ParkingSpot("Motorcycle", x));
			ParkingSpotsList.get(x).addObserver(mainParkingLotGUI);
		}
		
		//run parking lot controller
		ParkingLotController frame = new ParkingLotController();
		frame.setVisible(true);
		
		ParkingLotGUI secondFrame = new ParkingLotGUI();
		secondFrame.setVisible(true);
		
		TagAdder thirdFrame = new TagAdder();
		thirdFrame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thirdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}