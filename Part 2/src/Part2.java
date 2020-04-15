import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

    public static List<String> categoryNames;
    public static List<String> attributeNames;

    List<Instance> trainingData;
    List<Instance> testData;

    DecisionTree tree;

    public Part2() {
    }

    public void Run(File trainingFile, File testFile) {
        trainingData = readData(trainingFile);
        testData = readData(testFile);

        tree = new DecisionTree(trainingData, new ArrayList<String>(attributeNames));
        // tree.print();

        int correctCount = 0;
        int wrongCount = 0;

        for (Instance instance : testData) {
            int result = tree.classify(instance);

            if (result == instance.getCategory())
                correctCount++;
            else
                wrongCount++;
        }

        System.out.format("\u001b[32mAccuracy for %s: %4.1f%% (%d/%d) \u001b[0m \n", testFile.getName(),
                ((double) correctCount / (double) (correctCount + wrongCount)) * 100, correctCount,
                correctCount + wrongCount);
    }

    private List<Instance> readData(File file) {
        // System.out.println("Reading data from file " + file.getName());
        try {
            Scanner din = new Scanner(file);

            categoryNames = new ArrayList<String>();
            for (Scanner s = new Scanner(din.nextLine()); s.hasNext();)
                categoryNames.add(s.next());
            // System.out.println(categoryNames.size() + " categories");

            attributeNames = new ArrayList<String>();
            for (Scanner s = new Scanner(din.nextLine()); s.hasNext();)
                attributeNames.add(s.next());
            // System.out.println(attributeNames.size() + " attributes");

            List<Instance> instances = readInstances(din);
            din.close();

            return instances;
        } catch (IOException e) {
            throw new RuntimeException("Data File caused IO exception");
        }
    }

    private List<Instance> readInstances(Scanner din) {
        List<Instance> instances = new ArrayList<Instance>();
        while (din.hasNext()) {
            Scanner line = new Scanner(din.nextLine());
            instances.add(new Instance(categoryNames.indexOf(line.next()), line));
        }
        // System.out.println("Read " + instances.size() + " instances");
        return instances;
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

        Part2 app = new Part2();

        if (args.length == 3 && Boolean.parseBoolean(args[2])) {
            for (int i = 0; i < 10; i++) {
                app.Run(new File(args[0] + "-run-" + i), new File(args[1] + "-run-" + i));
            }
        } else {
            app.Run(trainingFile, testFile);
        }
    }
}