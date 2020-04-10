import java.io.File;

public class Main {

    private KNNClassifier classifier;
    private DataSet trainingSet;
    private DataSet testSet;

    public Main(File trainingFile, File testFile, int... kValues) {
        testSet = new DataSet();
        testSet.loadSetFromFile(testFile);

        trainingSet = new DataSet();
        trainingSet.loadSetFromFile(trainingFile);

        classifier = new KNNClassifier();
        classifier.setTrainingSet(trainingSet);

        for (int k : kValues) {
            KNN(k);
        }
    }

    private void KNN(int kValue) {
        classifier.setKValue(kValue);

        int correctCount = 0;
        int wrongCount = 0;

        for (Wine input : testSet.getInstances()) {
            int wineClass = classifier.classify(input);

            if (wineClass == input.getWineClass())
                correctCount++;
            else
                wrongCount++;
        }

        Log.complete("Accuracy for K=" + kValue + ": " + (double) correctCount / (double) (correctCount + wrongCount));
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

        new Main(trainingFile, testFile, 1, 3, 6);
    }
}