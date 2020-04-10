import java.util.ArrayList;
import java.util.List;

public class KNNClassifier {
    private int kValue;
    private DataSet trainingSet;

    public KNNClassifier(DataSet trainingSet) {
        this.trainingSet = trainingSet;
    }

    public Wine classify(Wine input) {

        List<Neighbour> neighbours = new ArrayList<Neighbour>();

        for (Wine instance : trainingSet.getInstances()) {
            neighbours.add(new Neighbour(instance, distance(input, instance)));
        }

        neighbours.sort((n1, n2) -> {
            // -1 = Less than, 1 = Larger than, 0 = equal to
            return (n1.distance < n2.distance) ? -1 : (n1.distance > n2.distance) ? 1 : 0;
        });

        for (Neighbour neighbour : neighbours) {
            Log.log(neighbour.distance.toString());
        }

        return null;
    }

    // TODO: Implement distance function
    public double distance(Wine wineA, Wine wineB) {
        double sumOfDifferenceInAttributes = 0;
        Double[] aAttributes = wineA.getAttributes();
        Double[] bAttributes = wineB.getAttributes();

        for (int i = 0; i < aAttributes.length; i++) {
            double val = aAttributes[1] - aAttributes[2];
            val = Math.sqrt(val);
        }

        return 1;
    }

    public void setKValue(int kValue) {
        this.kValue = kValue;
    }

    private class Neighbour {
        public Wine instance;
        public Double distance;

        public Neighbour(Wine instance, Double distance) {
            this.instance = instance;
            this.distance = distance;
        }
    }
}