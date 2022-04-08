import java.lang.Math;

interface IBinTree {
    // determines whether element is in the tree
    boolean hasElt(int e);

    // returns number of nodes in the tree; counts duplicate elements as separate items
    int size();

    // returns depth of longest branch in the tree
    int height();

    // returns root of tree
    int getRoot();

    // returns left branch of tree
    IBinTree getLeft();

    // returns right branch of tree
    IBinTree getRight();

    // checks if left branch is greater than root
    boolean leftGreater();

    // checks if left branch is greater than root
    boolean rightGreater();

    // checks if all left branches have greater values than their roots
    boolean allLeftGreater();

    // checks if all right branches have greater values than their roots
    boolean allRightGreater();

    // recursive function that checks if the tree is a heap
    boolean heapCheck();
}

class MtBT implements IBinTree {
    MtBT() {
    }

    // returns false since empty tree has no elements
    public boolean hasElt(int e) {
        return false;
    }

    // returns 0 since enpty tree has no elements
    public int size() {
        return 0;
    }

    // returns 0 since empty tree has no branches
    public int height() {
        return 0;
    }

    public int getRoot() {
        return 0;
    }

    public IBinTree getLeft() {
        return null;
    }

    public IBinTree getRight() {
        return null;
    }

    public boolean leftGreater() {
        return false;
    }

    public boolean rightGreater() {
        return false;
    }

    public boolean allLeftGreater() {
        return false;
    }

    public boolean allRightGreater() {
        return false;
    }

    public boolean heapCheck() {
        return false;
    }
}

class DataBT implements IBinTree {
    int data;
    IBinTree left;
    IBinTree right;

    DataBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subtrees are empty
    DataBT(int data) {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }

    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e) {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e);
    }

    // adds 1 to the number of nodes in the left and right subtrees
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    // adds 1 to the height of the taller subtree
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }

    /**
     * Returns the left branch of the current tree.
     *
     * @return The left binary tree from the current.
     */
    public IBinTree getLeft() {
        return this.left;
    }

    /**
     * Returns the right branch of the current tree.
     *
     * @return The right binary tree from the current.
     */
    public IBinTree getRight() {
        return this.right;
    }

    /**
     * Gets the root data value of the tree.
     *
     * @return The root data value of the tree.
     */
    public int getRoot() {
        return this.data;
    }

    /**
     * Checks if the left branch is greater than the root.
     *
     * @return True if the left branch value is greater than the current data value.
     */
    public boolean leftGreater() {
        return (this.getRoot() < this.getLeft().getRoot());
    }

    /**
     * Checks if the right branch is greater than the root.
     *
     * @return True if the right branch value is greater than the current data value.
     */
    public boolean rightGreater() {
        return (this.getRoot() < this.getRight().getRoot());
    }

    /**
     * Part of the recursive system for heapCheck; Compares the data of all roots and left branches.
     *
     * @return True if all left branches in a binary tree are greater than their root.
     */
    public boolean allLeftGreater() {
        if (this.getLeft().size() == 0) {

        } else if (this.leftGreater()) {
            return this.getLeft().heapCheck();
        } else return false;
        return true;
    }

    /**
     * Part of the recursive system for heapCheck; Compares the data of all roots and right branches.
     *
     * @return True if all right branches in a binary tree are greater than their root.
     */
    public boolean allRightGreater() {
        if (this.getRight().size() == 0) {

        } else if (this.rightGreater()) {
            return this.getRight().heapCheck();
        } else return false;
        return true;
    }

    /**
     * Checks of the structure of the binary tree is the same as a heap.
     *
     * @return True if the structure matches that of a heap.
     */
    public boolean heapCheck() {
        return (this.allLeftGreater() && this.allRightGreater());
    }
}