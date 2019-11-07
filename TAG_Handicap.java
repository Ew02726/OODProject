
public class TAG_Handicap implements ParkingSpotTag{
	TagType tagType = TagType.CONSTRAINT;
	String description = "Handicap Spot";

	public String getDescription() {
		return description;
	}
	
	public void Describe() {
		System.out.println("The tag for handicap was added to parking spots.");
	}
}
