public class Morse {

    public static Node head = new Node('0',new Node('E',new Node('0',new Node('S',null,null),null),null),
            new Node('T',null,new Node('0',null,new Node('O',null,null))));

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
                    list();
                    break;
                case 'c':
                    catalog();
                    break;
			}
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
	public static Node next(Node tete,char carac){
		if(carac == '.'){
				tete = tete.dotNext;
		}else if(carac == '-'){
				tete = tete.lineNext;
		}
		return tete;
	}
	
	public static void decode(){
		Node tete = head;
		for(char carac = Pep8.chari();carac != '\n';carac = Pep8.chari()){
			tete = next(tete,carac);
		}
		
		affiche(tete,"nop");
		Pep8.charo('\n');
	}

    public  static void translate(){
    	Node tete = head;
    	for(char carac = Pep8.chari();carac != '\n';carac = Pep8.chari()){
    		if(carac != ' '){
    			if(tete != null){
    				tete = next(tete,carac);
    			}
    		}else{
    			affiche(tete,"?");
    			tete = head;
    		}
    	}
    	
    	affiche(tete,"?");
    	Pep8.charo('\n');
    }

    public static void addRule(){}

    public static void list(){}

    public static void catalog() {}

}