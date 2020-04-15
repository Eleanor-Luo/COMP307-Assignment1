import java.util.List;

public class DecisionTree {

    private Node root;

    public DecisionTree(List<Instance> trainingData, List<String> attributes) {
        root = new Node().build(trainingData, attributes);
    }

    public int classify(Instance instance) {
        return root.classify(instance);
    }

    public void print() {
        root.print("", true);
    }

}