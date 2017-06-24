import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LowestCommonAncestor {


    public static void main(String[] args) {
        //hardest of hard coded trees
        final  Node root = new Node(30);

        root.left = new Node(8);
        root.right = new Node(52);

        root.left.left = new Node(3);
        root.left.right = new Node(20);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(29);

        StringBuilder sb = new StringBuilder();
        String line;
        Path file = Paths.get(args[0]);

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){

            while ((line = br.readLine()) != null){

                String[] temp = line.split(" ");
                int node1 = Integer.parseInt(temp[0]);
                int node2 = Integer.parseInt(temp[1]);

                sb.append(findAncestor(root, node1, node2).getValue()).append('\n');

            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        System.out.print(sb.toString());

    }

    public static Node findAncestor(Node node, int left, int right) {

        if (node.getValue() > right && node.getValue() > left) {
            return findAncestor(node.left, left, right);

        } else if (node.getValue() < right && node.getValue() < left) {

            return findAncestor(node.right, left, right);
        } else {
            return node;
        }
    }

}

class Node{

    Node left;
    Node right;
    int value;

    public Node(int value){
        left = null;
        right = null;
        this.value = value;
    }
    public int getValue(){return this.value;}
}
