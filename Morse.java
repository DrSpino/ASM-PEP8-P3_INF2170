/*Classe Morse
 * */
public class Morse {
	/*Classe Node
	 * */
	public static class Node {
	    public char encodedCharacter;
	    public Node dotNext;
	    public Node lineNext;

	    public Node (char encodedCharacter, Node dotNextNode, Node lineNextNode){
	        this.encodedCharacter = encodedCharacter;
	        this.dotNext = dotNextNode;
	        this.lineNext = lineNextNode;
	    }
	}
	
	/*Declaration et
	 * creation du Noeud de depart
	 * */
    public static Node head = new Node('0',
    		new Node('E',
    				new Node('0',
    						new Node('S',null,null),null),null),
            new Node('T',null,
            		new Node('0',null,
            				new Node('O',null,null))));
    /*taille du noeud
     * */
    public static int total;
    
    /*Main
     * */
	public static void main(String [] args) {
		
		
		char command = Pep8.chari();
		while(command != 'q'){
			switch (command){
                case 'd':
                    decode();
                    break;
                case  't':
                    translate();
                    break;
                case 'a':
                    addRule();
                    break;
                case 'l':
                	total = 0;
                    list(head);
                    Pep8.stro("total="+total+'\n');
                    break;
			}
			command = Pep8.chari();
        }
	}
	
	/*Sert à afficher le caractere 
	 * codé ou si il n'existe pas un 
	 * String entrée en param.
	 * @params
	 * 		Node tete
	 * 		String nop
	 * */
	public static void affiche(Node tete,String nop){
		if(tete != null && tete.encodedCharacter != '0'){
			Pep8.charo(tete.encodedCharacter);
		}else{
			Pep8.stro(nop);
		}
	}
	
	/*Sert à faire avancer le head dans le
	 * noeud par rapport au caractere
	 * qui correspond.
	 * @params
	 * 		Node tete
	 * 		Node carac
	 * */
	public static Node next(Node tete,char signe){
		if(signe == '.'){
				tete = tete.dotNext;
		}else if(signe == '-'){
				tete = tete.lineNext;
		}
		return tete;
	}
	
	/*Méthode decode
	 * */
	public static void decode(){
		Node tete = head;
		for(char signe = Pep8.chari();signe != '\n';signe = Pep8.chari()){
			tete = next(tete,signe);
		}
		affiche(tete,"nop");
		Pep8.charo('\n');
	}
	
	/*Méthode translate
	 * */
    public static void translate(){
    	Node tete = head;
    	for(char signe = Pep8.chari();signe != '\n';signe = Pep8.chari()){
    		if(signe != ' '){
    			if(tete != null){
    				tete = next(tete,signe);
    			}
    		}else{
    			affiche(tete,"?");
    			tete = head;
    		}
    	}
    	
    	affiche(tete,"?");
    	Pep8.charo('\n');
    }
    
    /*Méthode addRule
     * sert à ajouter ou modifier
     * un Noeud avec le caractere
     * qui correspond.
     * */
    public static void addRule(){
    	Node tete = head;
    	char carac = Pep8.chari();
    	for(char signe = Pep8.chari();signe != '\n';signe = Pep8.chari()){
    		
    		if(next(tete,signe) == null){
    			if(signe == '.'){
    				tete.dotNext = new Node('0',null,null);
    			}else if(signe == '-'){
    				tete.lineNext = new Node('0',null,null);
    			}
    		}
    		
    		tete = next(tete,signe);
    	}
    	tete.encodedCharacter = carac;
    }
    /*Méthode list
     * Permet de facon recursive
     * d'afficher tout les caracteres
     * du Noeud.
     * */
    public static void list(Node tete){
    	if(tete.encodedCharacter != '0'){
    		affiche(tete,null);
    		Pep8.charo('\n');
    		total += 1;
    	}
    	
    	if(tete.dotNext != null){
    		list(tete.dotNext);
    	}
    	if(tete.lineNext != null){
    		list(tete.lineNext);
    	}
    }
}