import java.io.File;

public class Main {

    private final int kValue = 1;

    private KNNClassifier classifier;

    private DataSet trainingSet;
    private DataSet testSet;

    private DataSet outputSet;

    public Main(File trainingFile, File testFile) {
        testSet = new DataSet();
        testSet.loadSetFromFile(testFile, false);
        trainingSet = new DataSet();
        trainingSet.loadSetFromFile(trainingFile, true);

        classifier = new KNNClassifier(trainingSet);
        classifier.setKValue(kValue);

    }

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            Log.error(
                    "Incorrect number of arguments! \nCorrect Usage: java -jar Part1.jar <path to training set> <path to test set>");
            return;
        }

        File trainingFile = new File(args[0]);
        File testFile = new File(args[1]);

        // Check the data sets exist
        if (!trainingFile.exists()) {
            Log.error("The file " + trainingFile.getAbsolutePath() + " does not exist!");
            return;
        }

        if (!testFile.exists()) {
            Log.error("The file " + trainingFile.getAbsolutePath() + " does not exist!");
            return;
        }

        new Main(trainingFile, testFile);
    }
}