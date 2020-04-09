
public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            Log.error(
                    "Incorrect number of arguments! \nCorrect Usage: java main <path to training set> <path to test set>");
        }
    }
}