import java.io.*;

class TreeNode {
    private String value;
    private TreeNode left;
    private TreeNode right;
    

    public TreeNode(String value){
        this.value = value;
    }
    
    public TreeNode(String value, TreeNode left, TreeNode right){
        this.value = value; 
        this.left = left;
        this.right = right;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getLeft(){
        return this.left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getRight(){
        return this.right;
    }
    // left = something, right = something  /// <
    // left = nothing,   right = something  /// <
    // left = something, right = nothing    /// <
    // left = nothing,   right = nothing
    public boolean isLeaf(){
      // leaf has no children thus returns false.
        return !(left != null && right != null);

        // if(left != null && right != null) { 
        //     return false;
        // }
        // return true;
    }

    public void writeInPreorder(BufferedWriter writer) throws IOException {
        writer.write(value);
        writer.newLine();

        if (left != null) {
            left.writeInPreorder(writer);
        }

        if (right != null) {
            right.writeInPreorder(writer);
        }
    }
}