package brainFuck;

public class Command {
	
	private String command = null;
	private int pointer = 0;
	
	public void setCommand(String x){
		command = x;
	}
	
	public boolean canIncrementPointer(){
		return (pointer<(command.length()-1));
	}
	
	public int getPointer(){
		return pointer;
	}
	
	public boolean incrementPointer(){
		if (pointer==command.length()-1){
			return false;
		} else {
		pointer++;
		return true;
		}
	}
	
	public Boolean decrementPointer(){
		if (pointer==0){
		System.out.println("Error - cannot decrement command pointer below 0");
		return false;
		} else {
			pointer--;
			return true;
		}
	}
	
	public boolean setPointer(int x){
		if ((0 >= x) && (x < command.length())){
			pointer = x;
			return true;
		} else {
			return false;
			
		}
	}
	
	public char getCurrentCommand(){
		return command.charAt(pointer);
	}
	
	public boolean incrementPointerFromOpenBracketToCloseBracket(){
		/*boolean exit = false;
		
		while (exit==false){
			if (incrementPointer() ==false){
				return false;
			}
		
			if (getCurrentCommand()==']'){
				exit = true;
			}	
		}
		
		return true;
		
		*/int numOpens = 0;
		
		if (incrementPointer() == false){
			return false;
		}
		
		char currentCommand = getCurrentCommand();
		
		while (!(numOpens==0 && currentCommand==']')){
			
			if (currentCommand == ']'){
				numOpens--;
			}
			
			if (incrementPointer() == false){
				return false;
			}
			
			currentCommand = getCurrentCommand();
			if (currentCommand=='['){
				numOpens++;
			}
		}
		return true;
	}
	public boolean decrementPointerFromCloseBracketToOpenBracket(){
		/*boolean exit = false;
		
		
		while (exit==false){
			if (decrementPointer()==false){
				return false;
			}
		
			if (getCurrentCommand()=='['){
				exit = true;
			}	
		}
		
		return true;
		*/int numCloses = 0;
		
		if (decrementPointer() == false){
			return false;
		}
	
		char currentCommand = getCurrentCommand();	
		
		while (!(numCloses==0 && currentCommand=='[')){
			
			if (currentCommand == '['){
				numCloses--;
			}
			
			if (decrementPointer() == false){
				return false;
			}
			
			currentCommand = getCurrentCommand();
			if (currentCommand==']'){
				numCloses++;
			}
		}
		return true;
	}
	
}
