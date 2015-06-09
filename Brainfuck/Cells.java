package brainFuck;

public class Cells {
	
	private int[] cells = new int[30000];
	private int pointer = 0;
	
	public void incrementPointer(){
		pointer++;
	}
	
	public Boolean decrementPointer(){
		if (pointer==0){
			System.out.println("Error - cannot decrement Cell pointer below 0");
			return false;
		
		} else {
			pointer--;
			return true;
		}
		
	}
	
	public void incrementCell(){
		cells[pointer]++;
	}
	
	public void decrementCell(){
		cells[pointer]--;
	}
	
	public int getCurrentCell(){
		return cells[pointer];
	}
	
	public void writeCurrentCell(int x){
		cells[pointer] = x;
	}
}
