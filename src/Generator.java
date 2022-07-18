

public class Generator {
	boolean IncludeUpper=false;
	boolean IncludeLower=false;
	boolean IncludeNum=false;
	boolean IncludeSym=false;
	Alphabet alphabet;
	
	public Generator(){

	}

	public Generator(boolean IncludeUpper,boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
		alphabet=new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);

	}
	
	public String GeneratePassword(int length) {
		final StringBuilder pass = new StringBuilder("");

		final int alphabetLength = alphabet.getAlphabet().length();
		
		int max = alphabetLength - 1; 
        int min = 0; 
        int range = max - min + 1; 
        
		
		
		for(int i=0;i<length;i++) {
			
			int index=(int)(Math.random() * range) + min; 
			
			pass.append(alphabet.getAlphabet().charAt(index));

















		}
		
		return pass.toString();
		
	}
	


	

	public String checkPassword(String password) {

		final Password p = new Password(password);
		return p.calculateScore();

	}

}
