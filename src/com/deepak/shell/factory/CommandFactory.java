package com.deepak.shell.factory;

import com.deepak.shell.commands.CommandIf;
import com.deepak.shell.commands.TailCommand;
import com.deepak.shell.exceptions.CommandNotFoundException;

public class CommandFactory {

	public static CommandIf getCommand(String commandName) throws CommandNotFoundException{
		
		if(commandName.equals("tail")) {
			return new TailCommand();
		}
		throw new CommandNotFoundException("commandName");
	}

}
