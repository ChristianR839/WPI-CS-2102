
public class SoccerTeam implements IContestant {

	String country;
	String jColor;
	boolean hasRitual;
	int wins;
	int losses;

	public SoccerTeam(String country, String jColor, boolean hasRitual, int wins, int losses) {
		this.country = country;
		this.jColor = jColor;
		this.hasRitual = hasRitual;
		this.wins = wins;
		this.losses = losses;
	}

	public boolean expectToBeat(SoccerTeam oTeam) {
		if (this.hasRitual && !oTeam.hasRitual) {
			return true;
		} else if (!this.hasRitual && oTeam.hasRitual) {
			return false;
		} else if ((this.wins - this.losses) > (oTeam.wins - oTeam.losses)) {
			return true;
		} else if ((this.wins - this.losses) < (oTeam.wins - oTeam.losses)) {
			return false;
		} else {
			return false;
		}
	}
}
