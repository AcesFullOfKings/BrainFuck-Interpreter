package brainFuck;

import java.io.*;
import stringutils;


import sheffield.*;

public class Main {
	
	static boolean outputAsChars = false; //set to true for output to be as characters; false outputs numbers
	
	public static void main(String[] args) {
		boolean exit = false;
		String command = "";
		EasyReader reader = new EasyReader();

		System.out.print("Welcome to BrainFuck. ");
		
		while (exit==false){
			System.out.println("Please enter a command. Type 'help' for a list of commands.");
		
			command = reader.readString();
			
        	if (command.toUpperCase().equals("HELP")){
        		System.out.println("Commands:");
        		System.out.println();
        		System.out.println("+ - increment current cell");
        		System.out.println("- - decrement curent cell");
        		System.out.println("> - advance to next cell");
        		System.out.println("< - step back to previous cell");
        		System.out.println(", - read an integer into current cell");
        		System.out.println(". - write value of current cell");
        		System.out.println("[ - if current value is 0, skip to next ], otherwise move to next instruction");
        		System.out.println("] - if current value is 0, move to next instruction, otherwise go back to previous ]");
        		System.out.println("Exit - exit the program.");
        		System.out.println();
        	} else if (command.toUpperCase().equals("EXIT")){
        		exit = true;
        	} else {
        		checkString(command);
        	}
		}
        
	}
	
	public static void checkString(String command){
			if (command.matches("[+-\\[\\]<>,. ]*") == false) {
				System.out.println("Error - illegal character(s) detected when parsing input as BrainFuck command. Please use only legal characters. Type 'help' for a list of commands");
				return;
			}
			
			if
			
			command = command.replace(" ","");
			executeString(command);
			
	}
	
	public static void executeString(String command){
		boolean exit = false;
		Command input = new Command();
		Cells cells = new Cells();
		char currentCommand;
		
		input.setCommand(command);
		
		EasyReader reader = new EasyReader();
		String temp;
		
		while (exit==false){
			currentCommand = input.getCurrentCommand();
			//System.out.println();
			//System.out.println(currentCommand);
			//System.out.println(cells.getCurrentCell());
			if (currentCommand == '>'){
				cells.incrementPointer();
				if (!(input.incrementPointer())){
					exit = true;
				}
			} else if (currentCommand == '<'){
				if (cells.decrementPointer() == false){
					exit = true;
				}
				if (!(input.incrementPointer())){
					exit = true;
				}
			} else if (currentCommand == '+'){
				cells.incrementCell();
				if (!(input.incrementPointer())){
					exit = true;
				}
			} else if (currentCommand == '-'){
				cells.decrementCell();
				if (!(input.incrementPointer())){
					exit = true;
				}
			} else if (currentCommand == '.'){
				if (outputAsChars){
					System.out.println((char)cells.getCurrentCell());
				} else {
				System.out.println(cells.getCurrentCell());
				}
				if (!(input.incrementPointer())){
					exit = true;
				}
			} else if (currentCommand == ','){
				System.out.println("Please enter a number:");
				 temp = reader.readString();
				 
				cells.writeCurrentCell(Integer.parseInt(temp));
				
				if (!(input.incrementPointer())){
					exit = true;
				}
			} else if (currentCommand=='['){
				if (cells.getCurrentCell() == 0){
					if (input.incrementPointerFromOpenBracketToCloseBracket() == false){
						exit = true;
					}
				} else {
					if (input.incrementPointer() == false){
						exit = true;
					}
				}
			} else if (currentCommand==']'){
				if (cells.getCurrentCell() == 0){
					if (input.incrementPointer() == false){
						exit = true;
					}
				} else {
					if (input.decrementPointerFromCloseBracketToOpenBracket() == false){
						exit = true;
					}
				}
			}
		}
	}

}
