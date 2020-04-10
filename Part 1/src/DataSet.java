import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class DataSet {

    private List<Wine> instances;
    private Map<Attributes, Double> attributeRanges;

    public DataSet() {
        instances = new ArrayList<Wine>();
    }

    public void loadSetFromFile(File file) {
        String[] dataSet = readFile(file);

        for (int i = 1; i < dataSet.length; i++) {
            String[] attributes = dataSet[i].split("\\s");
            Wine instance = new Wine(attributes);

            instances.add(instance);
        }

        Log.complete("Loaded Data Set " + file.getName());
        calculateAttributeRanges();
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

    private void calculateAttributeRanges() {
        attributeRanges = new EnumMap<>(Attributes.class);

        for (Attributes attribute : Attributes.values()) {
            calculateAttributeRange(attribute);
        }
    }

    private void calculateAttributeRange(Attributes attribute) {
        double max = 0, min = Double.MAX_VALUE;

        for (Wine wine : instances) {
            double value = wine.getAttribute(attribute);

            if (value > max)
                max = value;
            else if (value < min)
                min = value;
        }

        attributeRanges.put(attribute, max - min);
    }

    public List<Wine> getInstances() {
        return this.instances;
    }

    public double getAttributeRange(Attributes attribute) {
        return attributeRanges.get(attribute);
    }
}