import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public double rainfall(LinkedList<Double> list) {
        LinkedList<Double> croppedList = new LinkedList<Double>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != -999) {
                croppedList.add(list.get(i));
            } else if (list.get(i) == -999) {
                break;
            }
        }

        LinkedList<Double> posList = croppedList.stream().filter(num -> num > 0).collect(Collectors.toCollection(LinkedList::new));

        double sum = 0;
        double avg = 0;
        int count = 0;
        for (int i = 0; i < posList.size(); i++) {
            if (i == (posList.size() - 1)) {
                avg = sum / (i + 1);
            }
        }
        return avg;
    }
}
