import java.util.ArrayList;
import java.util.List;

public class Node {

    protected String attribute;
    private Node left;
    private Node right;

    public Node build(List<Instance> instances, List<String> attributes) {

        if (instances.isEmpty()) {
            return new LeafNode(0, -1); // TODO: Calculate probability of the most probable class across the whole
                                        // dataset(i.e., the ‘‘baseline’’ predictor)
        } else if (calcImpurity(instances) == 0) {
            return new LeafNode(instances.get(0).getCategory(), 1);
        } else if (attributes.isEmpty()) {
            return new LeafNode(findMajorityClass(instances), 10);
        } else {
            Node node = new Node();
            node.findBestAttributeForNode(instances, attributes);
            return node;
        }
    }

    private void findBestAttributeForNode(List<Instance> instances, List<String> attributes) {
        double bestPurity = Double.MAX_VALUE;
        String bestAttribute = "";
        List<Instance> bestInstancesTrue = new ArrayList<Instance>();
        List<Instance> bestInstancesFalse = new ArrayList<Instance>();

        for (String attribute : attributes) {
            List<Instance> trueInstances = new ArrayList<Instance>();
            List<Instance> falseInstances = new ArrayList<Instance>();

            for (Instance instance : instances) {
                if (instance.getAtt(attribute))
                    trueInstances.add(instance);
                else
                    falseInstances.add(instance);
            }

            double impurity = calcAverageWeightedImpurity(trueInstances, falseInstances);
            if (impurity < bestPurity) {
                bestPurity = impurity;
                bestAttribute = attribute;
                bestInstancesTrue = trueInstances;
                bestInstancesFalse = falseInstances;
            }
        }

        attributes.remove(bestAttribute);
        attribute = bestAttribute;

        if (bestAttribute == "") {

            for (String attribute : attributes) {
                List<Instance> trueInstances = new ArrayList<Instance>();
                List<Instance> falseInstances = new ArrayList<Instance>();

                for (Instance instance : instances) {
                    if (instance.getAtt(attribute))
                        trueInstances.add(instance);
                    else
                        falseInstances.add(instance);
                }

                double impurity = calcAverageWeightedImpurity(trueInstances, falseInstances);
                if (impurity < bestPurity) {
                    bestPurity = impurity;
                    bestAttribute = attribute;
                    bestInstancesTrue = trueInstances;
                    bestInstancesFalse = falseInstances;
                }
            }
        }

        left = build(bestInstancesTrue, attributes);
        right = build(bestInstancesFalse, attributes);
    }

    private int findMajorityClass(List<Instance> instances) {
        int[] classCount = new int[2];

        for (Instance instance : instances) {
            classCount[instance.getCategory()] += 1;
        }

        if (classCount[0] > classCount[1])
            return 0;
        else
            return 1;
    }

    private double calcAverageWeightedImpurity(List<Instance> a, List<Instance> b) {
        int numInstances = a.size() + b.size();
        double aImpurity = a.size() > 0 ? calcImpurity(a) : 0;
        double bImpurity = b.size() > 0 ? calcImpurity(b) : 0;

        if (Double.isNaN(aImpurity))
            System.out.println(aImpurity + " is NaN");
        return (((double) a.size() / numInstances) * aImpurity) + (((double) b.size() / numInstances) * bImpurity);
    }

    private double calcImpurity(List<Instance> instances) {
        int[] classCount = new int[2];

        for (Instance instance : instances) {
            classCount[instance.getCategory()] += 1;
        }

        double impurity = (((double) classCount[0] / instances.size())) * (((double) classCount[1] / instances.size()));
        return impurity;
    }

    public int classify(Instance instance) {
        boolean att = instance.getAtt(attribute);

        if (att)
            return left.classify(instance);
        else
            return right.classify(instance);
    }

    public void print(String indent, boolean root) {
        System.out.println(indent + (root ? "╔ " : "╠ ") + attribute + " = True:");
        left.print(indent + "║  ", false);
        System.out.println(indent + "╚ " + attribute + " = False:");
        right.print(indent + "    ", false);
    }
}