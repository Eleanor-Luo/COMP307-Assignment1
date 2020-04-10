import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KNNClassifier {
    private int kValue;
    private DataSet trainingSet;

    public int classify(Wine input) {

        List<Neighbour> neighbours = new ArrayList<Neighbour>();

        for (Wine instance : trainingSet.getInstances()) {
            neighbours.add(new Neighbour(instance, distance(input, instance)));
        }

        neighbours.sort((n1, n2) -> {
            // -1 = Less than, 1 = Larger than, 0 = equal to
            return (n1.distance < n2.distance) ? -1 : (n1.distance > n2.distance) ? 1 : 0;
        });

        int closestNeighboursClasses[] = new int[kValue];

        for (int i = 0; i < kValue; i++) {
            closestNeighboursClasses[i] = neighbours.get(i).instance.getWineClass();
        }

        return mode(closestNeighboursClasses);
    }

    private double distance(Wine wineA, Wine wineB) {
        double sumOfDifferenceInAttributes = 0;

        for (Attributes attribute : Attributes.values()) {
            double val = wineA.getAttribute(attribute) - wineB.getAttribute(attribute);
            val *= val;
            val /= trainingSet.getAttributeRange(attribute);

            sumOfDifferenceInAttributes += val;
        }

        return Math.sqrt(sumOfDifferenceInAttributes);
    }

    private int mode(int[] input) {
        HashMap<Integer, Integer> classes = new HashMap<Integer, Integer>();
        int max = 1;
        int mode = 0;

        for (int i = 0; i < input.length; i++) {
            if (classes.get(input[i]) != null) {
                int count = classes.get(input[i]);
                count++;
                classes.put(input[i], count);

                if (count > max) {
                    max = count;
                    mode = input[i];
                }
            } else {
                classes.put(input[i], 1);

                if (i == 0)
                    mode = input[i];
            }
        }

        return mode;
    }

    public void setKValue(int kValue) {
        this.kValue = kValue;
    }

    public void setTrainingSet(DataSet trainingSet) {
        this.trainingSet = trainingSet;
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