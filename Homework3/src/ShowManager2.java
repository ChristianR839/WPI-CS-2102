import java.util.LinkedList;

/**
 * Holds a method for organizing shows.
 */
class ShowManager2 {

    ShowManager2() {
    }

    /*
    Subtasks for the organizeShows method:
        - If a show is not a special and is daytime -> put in daytime
        - If a show is not a special and is primetime -> put in primetime
        - If a show is not a special and is latenight -> put in latenight
        - Create new ShowSummary with these lists
     */

    /**
     * Organizes shows into a show summary.
     *
     * @param shows The list of shows to organize.
     * @return A ShowSummary containing the shows from the list that aren't specials.
     */
    public ShowSummary organizeShows(LinkedList<Show> shows) {

        LinkedList<Show> daytime = new LinkedList<Show>();
        LinkedList<Show> primetime = new LinkedList<Show>();
        LinkedList<Show> latenight = new LinkedList<Show>();

        for (Show thisShow : shows) {
            if (!thisShow.isSpecial && 600 <= thisShow.broadcastTime && thisShow.broadcastTime < 1700) {
                daytime.add(thisShow);
            }
            if (!thisShow.isSpecial && 1700 <= thisShow.broadcastTime && thisShow.broadcastTime < 2200) {
                primetime.add(thisShow);
            }
            if (!thisShow.isSpecial && ((2200 <= thisShow.broadcastTime && thisShow.broadcastTime <= 2359) ||
                    (0 <= thisShow.broadcastTime && thisShow.broadcastTime < 100))) {
                latenight.add(thisShow);
            }
        }

        ShowSummary report = new ShowSummary(daytime, primetime, latenight);

        return report;
    }

}
