public class Node {
    public char encodedCharacter;
    public Node dotNext;
    public Node lineNext;

    public Node (char encodedCharacter, Node dotNextNode, Node lineNextNode){
        this.encodedCharacter = encodedCharacter;
        this.dotNext = dotNextNode;
        this.lineNext = lineNextNode;
    }
}
