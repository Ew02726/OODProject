
public class TAG_NearRAC implements ParkingSpotTag{
	TagType tagType = TagType.PROXIMITY;
	String description = "Near IT Building";

	public String getDescription() {
		return description;
	}
	
	public void Describe() {
		System.out.println("The tag for near RAC was added to parking spots.");
	}
}
