public class AVLTree {
  Node root;

  public AVLTree() {
    root = null;
  }

  public int max(int lhs, int rhs) {
    return lhs > rhs ? lhs : rhs;
  }

  public int height(Node node) {
    return node == null ? -1 : node.height;
  }

  public Node insert(int data, Node troot ) {
    if (troot == null) {
        troot= new Node(data);
    }
    else if (data < troot.data) {
      troot.left = insert(data,troot.left);
      if(height(troot.left)- height(troot.right)== 2)
      {
          if(data<troot.left.data)
          {
            troot = RightRightRotation(troot);
          }
          else
          {
            troot= doublerotationwithleftchild(troot);
          }
      }

    }
    else if (data > troot.data) {
      troot.right= insert(data, troot.right);
      if(height(troot.right)- height(troot.left)== 2)
      {
        if(data>troot.right.data)
        {
          troot = LeftLeftRoattion(troot);
        }
        else
        {
          troot= doubleroationwithrightchild(troot);
        }
      }
    }
    troot.height= max(height(troot.left), height(troot.right))+1;
    return troot;
  }
  private Node doubleroationwithrightchild(Node current_disabled_node) {
    current_disabled_node.right = RightRightRotation((current_disabled_node.right));
    return LeftLeftRoattion(current_disabled_node);
  }
  public Node doublerotationwithleftchild(Node current_disabled_node)
  {
    current_disabled_node.left = LeftLeftRoattion((current_disabled_node.left));
    return RightRightRotation(current_disabled_node);
  }
  public Node RightRightRotation(Node current_disabled_node)
  {
    Node newroot = current_disabled_node.left;
    current_disabled_node.left = newroot.right;
    newroot.right= current_disabled_node;
    current_disabled_node.height= max(height(current_disabled_node.left),height(current_disabled_node.right))+1;
    newroot.height= max(height(newroot.left),current_disabled_node.height)+1;
    return newroot;
  }

  public Node LeftLeftRoattion(Node current_disabled_node) {
  Node newroot = current_disabled_node.right;
  current_disabled_node.right = newroot.left;
  newroot.left= current_disabled_node;
  current_disabled_node.height= max(height(current_disabled_node.left),height(current_disabled_node.right))+1;
  newroot.height= max(height(newroot.left),current_disabled_node.height)+1;
  return newroot;
  }

  public void inordertraversal(Node troot)
  {
    if(troot != null)
    {
      inordertraversal(troot.left);
      System.out.println(troot.data);
      inordertraversal(troot.right);
    }
  }
}
