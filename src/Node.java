public class Node {

    private Node node = null;
    private CD cd;

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void setNodeNull(){
        node = null;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }

    public Node(CD cd){
        this.cd = cd;
    }
}
