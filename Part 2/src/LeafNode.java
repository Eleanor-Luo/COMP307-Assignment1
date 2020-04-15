
public class LeafNode extends Node {
    private int category;

    public LeafNode(int classification, double probability) {
        this.category = classification;
    }

    @Override
    public int classify(Instance data) {
        return category;
    }

    @Override
    public void print(String indent, boolean root) {
        System.out.format("%s╚ Class: %s\n", indent, Part2.categoryNames.get(category));
    }
}