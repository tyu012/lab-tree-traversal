import java.io.PrintWriter;

/**
 * A place to experiment with binary trees.
 */
public class BinaryTreeExperiment {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    String[] strings = {"aardvark", "billygoat", "chinchilla", "dingo", "emu",
        "frog", "gnu", "hippo", "iguana", "jackalope", "koala", "llama"};
    BinaryTree<String> tree = new BinaryTree<String>(strings);

    pen.println("===== dump: =====");
    tree.dump(pen);

    pen.println("===== elements01 =====");
    tree.elements01(pen);

    pen.println("===== elements02 =====");
    tree.elements02(pen);

    pen.println("===== print =====");
    tree.print(pen);

    pen.println("===== print2 =====");
    tree.print2(pen);

    pen.println("===== print3 =====");
    tree.print3(pen);

    pen.println("===== print4 =====");
    tree.print4(pen);
  } // main
} // class BinaryTreeExperiment
