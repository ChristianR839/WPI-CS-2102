
public class SoccerResult implements IResult {

	SoccerTeam team1;
	SoccerTeam team2;
	double team1points;
	double team2points;

	public SoccerResult(SoccerTeam team1, SoccerTeam team2, double team1points, double team2points) {
		this.team1 = team1;
		this.team2 = team2;
		this.team1points = team1points;
		this.team2points = team2points;
	}

	public boolean isValid() {
		return (this.team1points < 150 && this.team2points < 150);
	}

	public IContestant getWinner() {
		if (this.team1points > this.team2points) {
			return team1;
		} else if (this.team1points < this.team2points) {
			return team2;
		} else {
			return null;
		}
	}
}
