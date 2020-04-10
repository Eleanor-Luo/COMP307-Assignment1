import java.io.File;

/**
 * Main class for Part 1 of COMP307 Assignment 1
 * 
 * @author Braden Roberts-Letiu
 */
public class Part1 {

    private KNNClassifier classifier;
    private DataSet trainingSet;
    private DataSet testSet;

    /**
     * Constructor
     * 
     * @param trainingFile File of training data set
     * @param testFile     File of test data set
     * @param kValues      k values to classify KNN at
     */
    public Part1(File trainingFile, File testFile, int... kValues) {
        // Load data sets
        testSet = new DataSet();
        testSet.loadSetFromFile(testFile);
        trainingSet = new DataSet();
        trainingSet.loadSetFromFile(trainingFile);

        // Instantiate KNNClassfiier
        classifier = new KNNClassifier();
        classifier.setTrainingSet(trainingSet);

        // Classify test set at specified kValues
        for (int k : kValues) {
            classifier.setKValue(k);
            classifier.classifyData(testSet);
        }

    }

    /**
     * Prints out the given arguments to the console
     * 
     * @param args
     */
    public static void print(Object... args) {
        for (Object msg : args) {
            System.out.print(msg.toString() + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            throw new IllegalArgumentException(
                    "Incorrect number of arguments! \nCorrect Usage: java -jar Part1.jar <path to training set> <path to test set>");
        }

        File trainingFile = new File(args[0]);
        File testFile = new File(args[1]);

        if (!trainingFile.exists()) {
            throw new IllegalArgumentException("The file " + trainingFile.getAbsolutePath() + " does not exist!");
        }

        if (!testFile.exists()) {
            throw new IllegalArgumentException("The file " + testFile.getAbsolutePath() + " does not exist!");
        }

        new Part1(trainingFile, testFile, 1, 3, 5);
    }
}