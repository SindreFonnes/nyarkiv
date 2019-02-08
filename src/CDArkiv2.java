public class CDArkiv2 implements CDarkivADT {

    private Node nodeChain;
    private int numberOffNodes = 0;

    private Node getLastNode(){
        Node aNode = nodeChain.getNode();;
        while (aNode.getNode()!=null){
            aNode = aNode.getNode();
        }
        return aNode;
    }

    private void addNode(Node aNode){
        Node lastNode = getLastNode();
        lastNode.setNode(aNode);
    }

    private void createNode(CD aCd){
        numberOffNodes++;
        Node aNode = new Node(aCd);
        if(nodeChain!=null){
            addNode(aNode);
        } else {
            nodeChain = aNode;
        }
    }

    private void dropNode(Node previousNode, Node fallingNode){
        if(fallingNode.getNode()!= null){
            Node aNode = fallingNode.getNode();
            previousNode.setNode(aNode);
        } else {
            previousNode.setNodeNull();
        }
        numberOffNodes--;
    }

    private Node[] fetchNodes(){
        Node[] theNodes = new Node[numberOffNodes];
        theNodes[0] = nodeChain;
        if(numberOffNodes>1){
            int counter = 0;
            while (theNodes[counter].getNode()!=null){
                counter++;
                theNodes[counter]=theNodes[counter-1].getNode();
            }
        }
        return theNodes;
    }

    private CD[] fetchCDs(){
        Node[] nodes = fetchNodes();
        CD[] cds = new CD[nodes.length];
        for(int i = 0; i < nodes.length; i++){
            cds[i] = nodes[i].getCd();
        }
        return cds;
    }

    @Override
    public CD[] hentCdTabell() {
        return fetchCDs();
    }

    @Override
    public void leggTilCd(CD nyCd) {
        createNode(nyCd);
    }

    @Override
    public boolean slettCd(int cdNr) {
        CD[] cds = fetchCDs();
        for(int i = 0; i< cds.length; i++){
            if(cds[i].getCdNr()==cdNr){
                Node previousNode = null;
                Node aNode = nodeChain;
                for(int j = 0; j<i; j++){
                    previousNode = aNode;
                    aNode = aNode.getNode();
                }
                dropNode(previousNode, aNode);
                return true;
            }
        }
        return false;
    }

    @Override
    public CD[] sokTittel(String delstreng) {
        CD[] cds = fetchCDs();
        int counter = 0;
        for(int i = 0; i<cds.length; i++){
            if(cds[i].getNavn().contains(delstreng)){
                counter++;
            }
        }
        if(counter>0){
            CD[] relevantCDs = new CD[counter];
            counter = 0;
            for(int i = 0; i<cds.length; i++){
                if(cds[i].getNavn().contains(delstreng)){
                    relevantCDs[counter]= cds[i];
                    counter++;
                }
            }
            return relevantCDs;
        }
        return null;
    }

    @Override
    public CD[] sokArtist(String delstreng) {
        CD[] cds = fetchCDs();
        int counter = 0;
        for(int i = 0; i<cds.length; i++){
            if(cds[i].getArtist().contains(delstreng)){
                counter++;
            }
        }
        if(counter>0){
            CD[] relevantCDs = new CD[counter];
            counter = 0;
            for(int i = 0; i<cds.length; i++){
                if(cds[i].getArtist().contains(delstreng)){
                    relevantCDs[counter]= cds[i];
                    counter++;
                }
            }
            return relevantCDs;
        }
        return null;
    }

    @Override
    public int antallSjanger(Sjanger sjanger) {
        CD[] cds = fetchCDs();
        int counter = 0;
        for(int i = 0; i<cds.length; i++){
            if(cds[i].getSjanger().getSjangerNavn()==sjanger.getSjangerNavn()){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public int antall() {
        return numberOffNodes;
    }
}
