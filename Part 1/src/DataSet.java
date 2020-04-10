import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * The DataSet class represents a set of Wine instances
 *
 * @author Braden Roberts-Letiu
 */
public class DataSet {

    private List<Wine> instances;
    private Map<Attributes, Double> attributeRanges;

    public DataSet() {
        instances = new ArrayList<Wine>();
    }

    /**
     * Populates the instances list with data from the specified file
     * 
     * @param file file with data
     */
    public void loadSetFromFile(File file) {
        String[] dataSet = readFile(file);

        for (int i = 1; i < dataSet.length; i++) {
            String[] attributes = dataSet[i].split("\\s");
            Wine instance = new Wine(attributes);

            instances.add(instance);
        }

        Part1.print("Loaded Data Set", file.getName());
        calculateAttributeRanges();
    }

    /**
     * Parses a text file into an array of strings that represent each line in the
     * file
     * 
     * @param file file to parse/read
     * @return an array of lines
     */
    public String[] readFile(File file) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(file.toPath())) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return sb.toString().split("\n");
    }

    /**
     * Calculates the range for each instance attribute in the data
     */
    private void calculateAttributeRanges() {
        attributeRanges = new EnumMap<>(Attributes.class);

        for (Attributes attribute : Attributes.values()) {
            calculateAttributeRange(attribute);
        }
    }

    /**
     * Calculates the range for the specified instance attribute in the data
     * 
     * @param attribute attribute to find the range for
     */
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

    /**
     * Returns the instances in this data set
     * 
     * @return list of instances
     */
    public List<Wine> getInstances() {
        return this.instances;
    }

    /**
     * Returns the range of an attribute in this data set
     * 
     * @param attribute
     * @return range of specified attribute
     */
    public double getAttributeRange(Attributes attribute) {
        return attributeRanges.get(attribute);
    }
}