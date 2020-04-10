import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class DataSet {

    private List<Wine> instances;

    public DataSet() {
        instances = new ArrayList<Wine>();
    }

    public void loadSetFromFile(File file) {
        String[] dataSet = readFile(file);

        for (int i = 1; i < dataSet.length; i++) {
            String[] attributes = dataSet[i].split("\s");
            Wine instance = new Wine(attributes);

            instances.add(instance);
        }
    }

    public String[] readFile(File file) {
        StringBuilder sb = new StringBuilder();

        // Read the stop file
        try (BufferedReader br = Files.newBufferedReader(file.toPath())) {
            String line;
            while ((line = br.readLine()) != null) {
                // Append lines to string builder ending with a new line character ('\n')
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        // Return an array of lines (in string format) from the file
        return sb.toString().split("\n");
    }

    public List<Wine> getInstances() {
        return this.instances;
    }
}