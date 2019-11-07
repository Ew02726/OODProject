import java.util.ArrayList;
import java.util.Observable;

public class ParkingSpot extends Observable{
	boolean isOpen = true;
	ArrayList<ParkingSpotTag> ParkingSpotTags = new ArrayList<ParkingSpotTag>();
	String type;
	Vehicle containedVehicle;
	int spotNum;
	
	public ParkingSpot(String type, int x) {
		this.type = type;
		this.spotNum = x;
	}

	public void clearSpot() {
		this.isOpen = true;
		this.containedVehicle = null;
	}
	
	public void off() {
		this.isOpen = false;
	}
	
	public String getType() {
		return this.type;
	}
	
	public ArrayList<ParkingSpotTag> getTags() {
		return ParkingSpotTags;
	}
	
	public void addTag(ParkingSpotTag newTag) {
		this.ParkingSpotTags.add(newTag);
	}
	
	public void removeTag(ParkingSpotTag remTag) {
		this.ParkingSpotTags.remove(remTag);
	}
	
	//code for observer/observable
	public void clearChanged() {
		super.clearChanged();
	}
	
	public void setChanged() {
		super.setChanged();
	}
}
