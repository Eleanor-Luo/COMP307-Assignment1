import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

public class Wine {

    private Map<Attributes, Double> attributes;
    private int wineClass = -1;

    public Wine(String[] input, boolean training) {
        double[] attributes = Arrays.stream(input).mapToDouble(Double::parseDouble).toArray();

        this.attributes = new EnumMap<>(Attributes.class);

        // TODO: Clean up using enum iteration
        this.attributes.put(Attributes.Alcohol, attributes[0]);
        this.attributes.put(Attributes.MalicAcid, attributes[1]);
        this.attributes.put(Attributes.Ash, attributes[2]);
        this.attributes.put(Attributes.AlcalinityOfAsh, attributes[3]);
        this.attributes.put(Attributes.Magnesium, attributes[4]);
        this.attributes.put(Attributes.TotalPhenols, attributes[5]);
        this.attributes.put(Attributes.Flavanoids, attributes[6]);
        this.attributes.put(Attributes.NonFlavanoidPhenols, attributes[7]);
        this.attributes.put(Attributes.Proancyanins, attributes[8]);
        this.attributes.put(Attributes.ColorIntensity, attributes[9]);
        this.attributes.put(Attributes.Hue, attributes[10]);
        this.attributes.put(Attributes.OD280_OD315_OfDilutedWines, attributes[11]);
        this.attributes.put(Attributes.Proline, attributes[12]);

        if (training)
            wineClass = Integer.parseInt(input[13]);
    }

    public int getWineClass() {
        return wineClass;
    }

    public double getAttribute(Attributes attribute) {
        if (attribute == Attributes.Class)
            return getWineClass();
        else
            return attributes.get(attribute);
    }

    public Double[] getAttributes() {
        return attributes.values().toArray(new Double[13]);
    }

    @Override
    public String toString() {
        // TODO: Clean up using enum iteration
        return "[" + " alcohol='" + getAttribute(Attributes.Alcohol) + "'" + ", malicAcid='"
                + getAttribute(Attributes.MalicAcid) + "'" + ", ash='" + getAttribute(Attributes.Ash) + "'"
                + ", alcalinityOfAsh='" + getAttribute(Attributes.AlcalinityOfAsh) + "'" + ", magnesium='"
                + getAttribute(Attributes.Magnesium) + "'" + ", totalPhenols='" + getAttribute(Attributes.TotalPhenols)
                + "'" + ", flavanoids='" + getAttribute(Attributes.Flavanoids) + "'" + ", nonFlavanoidPhenols='"
                + getAttribute(Attributes.NonFlavanoidPhenols) + "'" + ", proanthocyanins='"
                + getAttribute(Attributes.Proancyanins) + "'" + ", colorIntensity='"
                + getAttribute(Attributes.ColorIntensity) + "'" + ", hue='" + getAttribute(Attributes.Hue) + "'"
                + ", OD280_OD315_ofDilutedWines='" + getAttribute(Attributes.OD280_OD315_OfDilutedWines) + "'"
                + ", proline='" + getAttribute(Attributes.Proline) + "'" + ", class='" + getWineClass() + "'" + "]";
    }
}
