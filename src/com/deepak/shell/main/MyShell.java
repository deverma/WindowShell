package com.deepak.shell.main;

import com.deepak.shell.commands.CommandIf;
import com.deepak.shell.exceptions.CommandNotFoundException;
import com.deepak.shell.exceptions.InvalidArgumentsException;
import com.deepak.shell.factory.CommandFactory;

public class MyShell {

	public static void main(String[] args){
		try {
			CommandIf cmd = CommandFactory.getCommand(args[0]);
			cmd.execute(args);
		} catch (CommandNotFoundException e){
			 System.out.println(e.getMessage());
		} catch (InvalidArgumentsException e){
			 System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
