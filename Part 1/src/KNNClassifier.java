import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The KNNClassifier class is an implementation of the k Nearest Neigbor method.
 * 
 * @author Braden Roberts-Letiu
 */
public class KNNClassifier {
    private int kValue;
    private DataSet trainingSet;

    /**
     * Classify the given data against the training set
     * 
     * @param data data set to classify
     */
    public void classifyData(DataSet data) {

        int correctCount = 0;
        int wrongCount = 0;

        for (Wine input : data.getInstances()) {
            int wineClass = classifyInstance(input);

            if (wineClass == input.getWineClass())
                correctCount++;
            else
                wrongCount++;
        }

        Part1.print("Accuracy for K=", kValue, ":", (double) correctCount / (double) (correctCount + wrongCount));
    }

    /**
     * Classify the given Wine instance against the training set
     * 
     * @param instance instance to classify
     * @return the class result
     */
    private int classifyInstance(Wine instance) {

        List<Neighbour> neighbours = new ArrayList<Neighbour>();

        for (Wine trainingInstance : trainingSet.getInstances()) {
            neighbours.add(new Neighbour(trainingInstance, distance(instance, trainingInstance)));
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

    /**
     * Calculates the distance between two instances
     * 
     * @param wineA
     * @param wineB
     * @return the distance between wineA and wineB
     */
    private double distance(Wine wineA, Wine wineB) {
        double sumOfDifferenceInAttributes = 0;

        for (Attributes attribute : Attributes.values()) {
            double range = trainingSet.getAttributeRange(attribute);
            double val = wineA.getAttribute(attribute) - wineB.getAttribute(attribute);
            val *= val;
            val /= (range * range);

            sumOfDifferenceInAttributes += val;
        }

        return Math.sqrt(sumOfDifferenceInAttributes);
    }

    /**
     * Finds the mode class from the given array of classes
     * 
     * @param input array of classes
     * @return the mode class from the array
     */
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

    /**
     * Sets the k Value for the classifier
     * 
     * @param kValue
     */
    public void setKValue(int kValue) {
        this.kValue = kValue;
    }

    /**
     * Sets the training data forthe classifier
     * 
     * @param trainingSet
     */
    public void setTrainingSet(DataSet trainingSet) {
        this.trainingSet = trainingSet;
    }

    /**
     * The Neighbour class is used to store information about an instance when
     * calculating nearby neighbours for a test instance
     */
    private class Neighbour {
        public Wine instance;
        public Double distance;

        public Neighbour(Wine instance, Double distance) {
            this.instance = instance;
            this.distance = distance;
        }
    }
}