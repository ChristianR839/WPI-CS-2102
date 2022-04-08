
public class Match {

	IContestant team1;
	IContestant team2;

	IResult results;

	public Match(IContestant team1, IContestant team2, IResult results) {
		this.team1 = team1;
		this.team2 = team2;
		this.results = results;
	}

	public IContestant winner() {
		if (this.results.isValid()) {
			return this.results.getWinner();
		} else {
			return null;
		}
	}
}
