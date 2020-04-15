import java.util.HashMap;
import java.util.Scanner;

public class Instance {
    private int category;
    private HashMap<String, Boolean> attributes;

    public Instance(int category, Scanner scanner) {
        this.category = category;

        attributes = new HashMap<String, Boolean>();
        int index = 0;
        while (scanner.hasNextBoolean()) {
            attributes.put(Part2.attributeNames.get(index++), scanner.nextBoolean());
        }
    }

    public boolean getAtt(String att) {
        // System.out.println(att);
        if (!attributes.containsKey(att)) {
            // System.out.println("STOP");
        }
        return attributes.get(att);
    }

    public int getCategory() {
        return category;
    }

    public String toString() {
        StringBuilder ans = new StringBuilder(Part2.categoryNames.get(category));
        ans.append(" ");
        for (Boolean att : attributes.values())
            ans.append(att ? "true  " : "false ");

        return ans.toString();
    }
}