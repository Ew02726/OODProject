
public class TAG_Handicap implements ParkingSpotTag{
	TagType tagType = TagType.CONSTRAINT;
	String description = "Handicap Spot";

	public String getDescription() {
		return description;
	}
}
