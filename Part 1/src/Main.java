import java.io.File;

public class Main {

    public DataSet trainingSet;
    public DataSet testSet;

    public Main(File trainingFile, File testFile) {
        testSet = new DataSet();
        testSet.loadSetFromFile(testFile);

        testSet.getInstances().forEach((instance) -> Log.log(instance.toString()));
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