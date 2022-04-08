import java.util.LinkedList;

public class Planning {

    public Planning() {

    }

    public double rainfall(LinkedList<Double> rainList) {
        double holder = 0.0;
        int positives = 0;
        for (int i = 0; i < rainList.size(); i++) {
            if (rainList.get(i) == -999.0) {
                if (holder == 0.0) {
                    return 0;
                }
                return (holder / positives);
            } else if (rainList.get(i) < 0.0) {

            } else if (rainList.get(i) >= 0.0){
                holder = holder + rainList.get(i);
                positives++;
            }
            if (i == (rainList.size() - 1.0)) {
                if (holder == 0.0) {
                    return 0;
                }
                return (holder / positives);
            }
        }
        return -1;
    }
}
