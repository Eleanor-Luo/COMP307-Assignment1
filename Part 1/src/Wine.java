import java.util.EnumMap;
import java.util.Map;

/**
 * The wine class represents a wine instance from the given data sets
 * 
 * @author Braden Roberts-Letiu
 */
public class Wine {

    private Map<Attributes, Double> attributes;
    private int wineClass = -1;

    /**
     * Costructor
     * 
     * @param input Array of instance attributes
     */
    public Wine(String[] input) {
        attributes = new EnumMap<>(Attributes.class);

        for (int i = 0; i < input.length - 1; i++)
            attributes.put(Attributes.values()[i], Double.parseDouble(input[i]));

        wineClass = Integer.parseInt(input[13]);
    }

    /**
     * Returns the classifcation of this wine instance
     * 
     * @return
     */
    public int getWineClass() {
        return wineClass;
    }

    /**
     * Returns the value of the given attribute
     * 
     * @param attribute attribute to find
     * @return value of attribute
     */
    public double getAttribute(Attributes attribute) {
        return attributes.get(attribute);
    }

    @Override
    public String toString() {
        String string = "[";

        for (Attributes attribute : Attributes.values()) {
            string.concat(attribute.toString() + ": " + getAttribute(attribute) + ", ");
        }

        string.concat("class: " + getWineClass() + "]");

        return string;
    }
}
