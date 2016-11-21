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

	public static void decode(){
		Node tete = head;
		for(char carac = Pep8.chari();carac != '\n';carac = Pep8.chari()){
			if(carac == '.'){
				tete = tete.dotNext;
			}else if(carac == '-'){
				tete = tete.lineNext;
			}
		}
		
		if(tete != null){
			Pep8.charo(tete.encodedCharacter);
		}else{
			Pep8.stro("nop");
		}
	}

    public  static void translate(){}

    public static void addRule(){}

    public static void list(){}

    public static void catalog() {}

}