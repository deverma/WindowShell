package com.deepak.shell.commands;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.input.ReversedLinesFileReader;

import com.deepak.shell.exceptions.InvalidArgumentsException;

public class TailCommand implements CommandIf {
 
	private final int MIN_ARG_LENGTH = 2;
	private final int MAX_ARG_LENGTH = 4;
	private final int DEFAULT_NUMBER_OF_LINES = 10;
	
	@Override
	public void execute(String[] args) throws Exception {
		int argLength = args.length;
		if (!(argLength == MIN_ARG_LENGTH || argLength == MAX_ARG_LENGTH)) {
			throw new InvalidArgumentsException("Provide proper arguments for command["+args[0]+"]");
		}
		String filepath = args[argLength-1];
		long numberOfLines = argLength == MIN_ARG_LENGTH ? DEFAULT_NUMBER_OF_LINES :handleTailWithArguments(args);
	    
	    File file = new File(filepath);
	     
	    String line;
	    ReversedLinesFileReader reader = new ReversedLinesFileReader(file);
	    
	    List<String> content = new ArrayList<>();
	    int i = 0;
        while ((line = reader.readLine()) != null && i++ < numberOfLines) {
            content.add(line);
        }
        Collections.reverse(content);
        for(String str : content) System.out.println(str);	    
	}
	private Long handleTailWithArguments(String[] args) throws InvalidArgumentsException {
		if(args[1].equals("-l")) {
			return Long.valueOf(args[2]).longValue();
		}
		throw new InvalidArgumentsException("Arrgument["+args[1]+"] not supported for command["+  args[0] +"]");
	}
	
}
