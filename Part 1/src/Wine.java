import java.util.Objects;

public class Wine {

    // Wine Features
    private final double alcohol;
    private final double malicAcid;
    private final double ash;
    private final double alcalinityOfAsh;
    private final double magnesium;
    private final double totalPhenols;
    private final double flavanoids;
    private final double nonFlavanoidPhenols;
    private final double proanthocyanins;
    private final double colorIntensity;
    private final double hue;
    private final double OD280_OD315_ofDilutedWines;
    private final double proline;

    public Wine(String[] attributes) {
        this.alcohol = Double.parseDouble(attributes[0]);
        this.malicAcid = Double.parseDouble(attributes[1]);
        this.ash = Double.parseDouble(attributes[2]);
        this.alcalinityOfAsh = Double.parseDouble(attributes[3]);
        this.magnesium = Double.parseDouble(attributes[4]);
        this.totalPhenols = Double.parseDouble(attributes[5]);
        this.flavanoids = Double.parseDouble(attributes[6]);
        this.nonFlavanoidPhenols = Double.parseDouble(attributes[7]);
        this.proanthocyanins = Double.parseDouble(attributes[8]);
        this.colorIntensity = Double.parseDouble(attributes[9]);
        this.hue = Double.parseDouble(attributes[10]);
        this.OD280_OD315_ofDilutedWines = Double.parseDouble(attributes[11]);
        this.proline = Double.parseDouble(attributes[12]);
    }

    public double getAlcohol() {
        return this.alcohol;
    }

    public double getMalicAcid() {
        return this.malicAcid;
    }

    public double getAsh() {
        return this.ash;
    }

    public double getAlcalinityOfAsh() {
        return this.alcalinityOfAsh;
    }

    public double getMagnesium() {
        return this.magnesium;
    }

    public double getTotalPhenols() {
        return this.totalPhenols;
    }

    public double getFlavanoids() {
        return this.flavanoids;
    }

    public double getNonFlavanoidPhenols() {
        return this.nonFlavanoidPhenols;
    }

    public double getProanthocyanins() {
        return this.proanthocyanins;
    }

    public double getColorIntensity() {
        return this.colorIntensity;
    }

    public double getHue() {
        return this.hue;
    }

    public double getOD280_OD315_ofDilutedWines() {
        return this.OD280_OD315_ofDilutedWines;
    }

    public double getProline() {
        return this.proline;
    }

    @Override
    public String toString() {
        return "[" + " alcohol='" + getAlcohol() + "'" + ", malicAcid='" + getMalicAcid() + "'" + ", ash='" + getAsh()
                + "'" + ", alcalinityOfAsh='" + getAlcalinityOfAsh() + "'" + ", magnesium='" + getMagnesium() + "'"
                + ", totalPhenols='" + getTotalPhenols() + "'" + ", flavanoids='" + getFlavanoids() + "'"
                + ", nonFlavanoidPhenols='" + getNonFlavanoidPhenols() + "'" + ", proanthocyanins='"
                + getProanthocyanins() + "'" + ", colorIntensity='" + getColorIntensity() + "'" + ", hue='" + getHue()
                + "'" + ", OD280_OD315_ofDilutedWines='" + getOD280_OD315_ofDilutedWines() + "'" + ", proline='"
                + getProline() + "'" + "]";
    }
}