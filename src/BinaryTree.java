import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Stack;

/**
* Simple binary trees.
*/
public class BinaryTree<T> implements Iterable<T> {
  
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  
  /**
  * The root of the tree
  */
  BinaryTreeNode<T> root;
  
  /**
  * The number of values in the tree.
  */
  int size;
  
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+
  
  /**
  * Create a new, empty, tree.
  */
  public BinaryTree() {
    this.size = 0;
    this.root = null;
  } // BinaryTree
  
  /**
  * Create a new, somewhat balanced, tree.
  */
  public BinaryTree(T[] values) {
    this.size = values.length;
    this.root = makeTree(values, 0, values.length);
  } // BinaryTree(T[])
  
  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  
  /**
  * Dump the tree to some output location.
  */
  public void dump(PrintWriter pen) {
    dump(pen, root, "");
  } // dump(PrintWriter)
  
  /**
  * Get an iterator for the tree.
  */
  public Iterator<T> iterator() {
    Stack<Object> rem = new Stack<Object>();
    rem.push(BinaryTree.this.root);

    return new Iterator<T>() {
      Stack<Object> remaining = rem;

      public boolean hasNext() {
        return (!remaining.empty()) || (BinaryTree.this.size != 0);
      } // hasNext()
      
      public T next() {
        // STUB
        return null;
      } // next()
    }; // new Iterator()
  } // iterator()
  
  public void elements01(PrintWriter pen) {
    elements01Helper(pen, root);
    pen.println();
  }
  
  public void elements02(PrintWriter pen) {
    elements02Helper(pen, root);
    pen.println();
  }
  
  /**
  * Print all of the elements in some order or other.
  * 
  * Note: We are trying to avoid recursion.
  */
  public void print(PrintWriter pen) {
    // A collection of the remaining things to print
    Stack<Object> remaining = new Stack<Object>();
    remaining.push(this.root);
    // Invariants: 
    //   remaining only contains Strings or Nodes
    //   All values in the tree are either
    //     (a) already printed,
    //     (b) in remaining, or
    //     (c) in or below a node in remaining
    while (!remaining.isEmpty()) {
      Object next = remaining.pop();
      if (next instanceof BinaryTreeNode<?>) {
        @SuppressWarnings("unchecked")
        BinaryTreeNode<T> node = (BinaryTreeNode<T>) next;
        if (node.right != null) {
          remaining.push(node.right);
        } // if (node.right != null)
        if (node.left != null) {
          remaining.push(node.left);
        } // if (node.left != null)
        remaining.push(node.value);
      } else {
        pen.print(next);
        pen.print(" ");
      } // if/else
    } // while
    pen.println();
  } // print(PrintWriter)

  /**
  * print method traverse the tree using a depth-first, left-to-right, in-order strategy
  * 
  * Note: We are trying to avoid recursion.
  */
  public void print2(PrintWriter pen) {
    // A collection of the remaining things to print
    Stack<Object> remaining = new Stack<Object>();
    remaining.push(this.root);
    // Invariants: 
    //   remaining only contains Strings or Nodes
    //   All values in the tree are either
    //     (a) already printed,
    //     (b) in remaining, or
    //     (c) in or below a node in remaining
    while (!remaining.isEmpty()) {
      Object next = remaining.pop();
      if (next instanceof BinaryTreeNode<?>) {
        @SuppressWarnings("unchecked")
        BinaryTreeNode<T> node = (BinaryTreeNode<T>) next;
        if (node.right != null) {
          remaining.push(node.right);
        } // if (node.right != null)
        remaining.push(node.value);
        if (node.left != null) {
          remaining.push(node.left);
        } // if (node.left != null)
      } else {
        pen.print(next);
        pen.print(" ");
      } // if/else
    } // while
    pen.println();
  } // print2(PrintWriter)

  /**
  * print method traverse the tree using a depth-first, left-to-right, postorder strategy
  * 
  * Note: We are trying to avoid recursion.
  */
  public void print3(PrintWriter pen) {
    // A collection of the remaining things to print
    Stack<Object> remaining = new Stack<Object>();
    remaining.push(this.root);
    // Invariants: 
    //   remaining only contains Strings or Nodes
    //   All values in the tree are either
    //     (a) already printed,
    //     (b) in remaining, or
    //     (c) in or below a node in remaining
    while (!remaining.isEmpty()) {
      Object next = remaining.pop();
      if (next instanceof BinaryTreeNode<?>) {
        @SuppressWarnings("unchecked")
        BinaryTreeNode<T> node = (BinaryTreeNode<T>) next;
        remaining.push(node.value);
        if (node.right != null) {
          remaining.push(node.right);
        } // if (node.right != null)
        if (node.left != null) {
          remaining.push(node.left);
        } // if (node.left != null)
      } else {
        pen.print(next);
        pen.print(" ");
      } // if/else
    } // while
    pen.println();
  } // print3(PrintWriter)

  /**
  * print method traverse the tree using a depth-first, right-to-left, inorder strategy  * 
  * Note: We are trying to avoid recursion.
  */
  public void print4(PrintWriter pen) {
    // A collection of the remaining things to print
    Stack<Object> remaining = new Stack<Object>();
    remaining.push(this.root);
    // Invariants: 
    //   remaining only contains Strings or Nodes
    //   All values in the tree are either
    //     (a) already printed,
    //     (b) in remaining, or
    //     (c) in or below a node in remaining
    while (!remaining.isEmpty()) {
      Object next = remaining.pop();
      if (next instanceof BinaryTreeNode<?>) {
        @SuppressWarnings("unchecked")
        BinaryTreeNode<T> node = (BinaryTreeNode<T>) next;
        if (node.left != null) {
          remaining.push(node.left);
        } // if (node.left != null)
        remaining.push(node.value);
        if (node.right != null) {
          remaining.push(node.right);
        } // if (node.right != null)
        
      } else {
        pen.print(next);
        pen.print(" ");
      } // if/else
    } // while
    pen.println();
  } // print4(PrintWriter)
  
  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+
  
  /**
  * Dump a portion of the tree to some output location.
  */
  void dump(PrintWriter pen, BinaryTreeNode<T> node, String indent) {
    if (node == null) {
      pen.println(indent + "<>");
    } else {
      pen.println(indent + node.value);
      if ((node.left != null) || (node.right != null)) {
        dump(pen, node.left, indent + "  ");
        dump(pen, node.right, indent + "  ");
      } // if has children
    } // else
  } // dump
  
  /**
  * Build a tree from a subarray from lb (inclusive) to ub (exclusive).
  */
  BinaryTreeNode<T> makeTree(T[] values, int lb, int ub) {
    if (ub <= lb) {
      return null;
    } else if (ub - lb == 1) {
      return new BinaryTreeNode<T>(values[lb]);
    } else {
      int mid = lb + (ub - lb) / 2;
      return new BinaryTreeNode<T>(values[mid], makeTree(values, lb, mid),
      makeTree(values, mid + 1, ub));
    } // if/else
  } // makeTree(T[], int, int)
  
  void elements01Helper(PrintWriter pen, BinaryTreeNode<T> node) {
    if (node == null) {
      return;
    } else {
      pen.print(node.value + " ");
      elements01Helper(pen, node.left);
      elements01Helper(pen, node.right);
    }
  }
  
  void elements02Helper(PrintWriter pen, BinaryTreeNode<T> node) {
    if (node == null) {
      return;
    } else {
      elements02Helper(pen, node.left);
      pen.print(node.value + " ");
      elements02Helper(pen, node.right);
    }
  }
  
} // class BinaryTree
