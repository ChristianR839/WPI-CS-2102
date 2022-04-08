import java.util.LinkedList;

/**
 * Holds a method for organizing shows.
 */
class ShowManager1 {

    ShowManager1() {
    }

    /*
    Subtasks for the organizeShows method:
        - Clean data (remove specials)
        - Sort shows into three lists (daytime, primetime, latenight)
        - Create new ShowSummary with the new lists
     */

    /**
     * Organizes shows into a show summary.
     *
     * @param shows The list of shows to organize.
     * @return A ShowSummary containing the shows from the list that aren't specials.
     */
    public ShowSummary organizeShows(LinkedList<Show> shows) {

        LinkedList<Show> cleanedShows = new LinkedList<Show>();

        LinkedList<Show> daytime = new LinkedList<Show>();
        LinkedList<Show> primetime = new LinkedList<Show>();
        LinkedList<Show> latenight = new LinkedList<Show>();

        for (Show thisShow : shows) {
            if (!thisShow.isSpecial) {
                cleanedShows.add(thisShow);
            }
        }

        for (int i = 0; i < cleanedShows.size(); i++) {

            // daytime
            if (600 <= cleanedShows.get(i).broadcastTime && cleanedShows.get(i).broadcastTime < 1700) {
                daytime.add(cleanedShows.get(i));
            }

            // primetime
            if (1700 <= cleanedShows.get(i).broadcastTime && cleanedShows.get(i).broadcastTime < 2200) {
                primetime.add(cleanedShows.get(i));
            }

            // latenight
            if ((2200 <= cleanedShows.get(i).broadcastTime && cleanedShows.get(i).broadcastTime <= 2359) ||
                    (0 <= cleanedShows.get(i).broadcastTime && cleanedShows.get(i).broadcastTime < 100)) {
                latenight.add(cleanedShows.get(i));
            }
        }

        ShowSummary report = new ShowSummary(daytime, primetime, latenight);

        return report;
    }

}
