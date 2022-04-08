// Basic Binary Search Trees (without remove element)

//-------------------------------------------------------------------------

interface IBST extends IGuests{
  // returns BST containing all existing elements and the given element
  IBST addElt (String elt);
  
  // returns the number of distinct elements in the BST
  int size ();

  // determines whether given element is in the BST
  boolean hasElt (String elt);
}
  
//-------------------------------------------------------------------------

class EmptyBST implements IBST  {
  EmptyBST() {}
  
  // returns the number of distinct elements in the BST
  public int size () { return 0; }
  
  // returns BST containing all existing elements and the given element
  public IBST addElt (String elt) {
    return new DataBST(elt, new EmptyBST(), new EmptyBST());
  }

  // determines whether the given element is in the BST
  public boolean hasElt (String elt) { return false; }
}

//-------------------------------------------------------------------------

class DataBST implements IBST {
  String data;
  IBST left;
  IBST right;
  
  DataBST(String data, IBST left, IBST right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
  
  // returns the number of distinct elements in the BST
  public int size() {
    return 1 + this.left.size() + this.right.size();
  }
  
  // returns BST containing all existing elements and the given element
  public IBST addElt (String elt) {
    if (elt.equals(this.data))
      return this; // not storing duplicate values
    else if (elt.compareTo(this.data) < 0)
      return new DataBST (this.data,
                          this.left.addElt(elt),
                          this.right);
    else // elt > this.data
      return new DataBST (this.data,
                          this.left,
                          this.right.addElt(elt));
  }
  
  // determines whether the given element is in the BST
  public boolean hasElt (String elt) {
    if (elt.equals(this.data)) 
      return true; 
    else if (elt.compareTo(this.data) < 0)
      return this.left.hasElt(elt);
    else // elt > this.data
      return this.right.hasElt(elt);
  }
}

