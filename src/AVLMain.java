public class AVLMain {
  public static void main(String[] args) {
    AVLTree obj = new AVLTree();
    obj.root = obj.insert(15, obj.root);
    obj.root = obj.insert(20,obj.root);
    obj.root = obj.insert(11,obj.root);
    obj.root = obj.insert(5, obj.root);
    obj.root = obj.insert(50,obj.root);
    obj.root = obj.insert(4,obj.root);
    obj.root = obj.insert(13, obj.root);
    obj.root = obj.insert(12,obj.root);
    obj.inordertraversal(obj.root);
  }
}
