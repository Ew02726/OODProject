
public class TAG_NearLandrum implements ParkingSpotTag{
	TagType tagType = TagType.PROXIMITY;
	String description = "Near Main Dining Commons";

	public String getDescription() {
		return description;
	}
	
	public void Describe() {
		System.out.println("The tag for near Landrum was added to parking spots.");
	}
}
