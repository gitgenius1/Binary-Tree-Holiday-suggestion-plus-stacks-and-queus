import java.util.*;
import java.io.*;

// method 

public class Main {
    public static boolean askYesNo(String question, Scanner input) {
        System.out.print(question + " [y/n] ");
        String ans = input.nextLine();
        
        if(ans.equals("y")){ 
            return true;  
        }
        return false;
    }

// method 
    public static void printPreorder(TreeNode node) {
        if (node == null) return;

        System.out.println(node.getValue());
        printPreorder(node.getLeft());
        printPreorder(node.getRight());
    }

    private static void writeTreeToFile(TreeNode tree, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            tree.writeInPreorder(writer);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());   
        }
    }

    private static TreeNode loadTreeFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return fromPreorder(reader);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());   
        }

        return null;
    }

    private static TreeNode fromPreorder(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line.endsWith("?")) {
            return new TreeNode(
                line,
                fromPreorder(reader),
                fromPreorder(reader)
            );
        } else {
            return new TreeNode(line);
        }
    }

    public static void main(String arg[]) {
         TreeNode tree = new TreeNode(
             "Do you like cold weather?",
             new TreeNode(
                 "Are you a keen hiker?",
                 new TreeNode("the Scottish Highlands"),
                 new TreeNode("Moscow")
         ),
            new TreeNode("Goa")
         );

        TreeNode tree = loadTreeFromFile("suggestions.txt");
        if (tree == null) {
            return;
        }

        Scanner input = new Scanner(System.in);

        do {
            // One round of the game
            TreeNode currentNode = tree;
        
            do {
                boolean response = askYesNo(currentNode.getValue(), input);
                if (response) {
                    currentNode = currentNode.getLeft();
                } else {
                    currentNode = currentNode.getRight();
                }
            }
            while (!currentNode.isLeaf());

            System.out.println("You should visit " + currentNode.getValue());
            System.out.println();
            boolean wasSatisfactory = askYesNo("Is this destination satisfactory?", input);
            if (!wasSatisfactory) {
                System.out.print("What destination would you have preferred? ");
                String preferredDestination = input.nextLine();
                System.out.print("What question should be asked for this destination? ");
                String question = input.nextLine();

                // offeredDestination     = currentNode
                // preferredDestination
                // question

                // Replace the offeredDestination with the question
                // Add the preferredDestination as the left child of the question
                // Add the offeredDestination as the right child of the question
                String offeredDestination = currentNode.getValue();
                currentNode.setValue(question);
                currentNode.setRight(new TreeNode(offeredDestination));
                currentNode.setLeft(new TreeNode(preferredDestination));
            }
        }
        while (askYesNo("Would you like to play again?", input));

        boolean shouldSave = askYesNo("Would you like to save the current tree?", input);
        if (shouldSave) {
            writeTreeToFile(tree, "suggestions.txt");
        }
    }
}

// The indentation level of every line should be equal the number of {'s above it, minus the number of }'s above it. If this line is a }, minus one.