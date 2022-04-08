
public class LegoRobotTeam implements IContestant {

	String school;
	String feature;
	int prevScore;

	public LegoRobotTeam(String school, String feature, int prevScore) {
		this.school = school;
		this.feature = feature;
		this.prevScore = prevScore;
	}

	public boolean expectToBeat(LegoRobotTeam oTeam) {
		if (this.prevScore > oTeam.prevScore) {
			return true;
		} else if (this.prevScore < oTeam.prevScore) {
			return false;
		} else {
			return false;
		}
	}
}
