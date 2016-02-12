package com.deepak.shell.commands;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

import com.deepak.shell.exceptions.InvalidArgumentsException;

public class TailCommand implements CommandIf {
 
	private final int MIN_ARG_LENGTH = 2;
	private final int MAX_ARG_LENGTH = 4;
	private final int DEFAULT_NUMBER_OF_LINES = 10;
	@Override
	public void execute(String[] args) throws Exception {
		int argLength = args.length;
		if (!(argLength == MIN_ARG_LENGTH || argLength == MAX_ARG_LENGTH)) {
			throw new InvalidArgumentsException(args[0]);
		}
		String filepath = args[argLength-1];
		 /*
         * Receive file name and no of lines to tail as command line
         * argument
         */
		Map<Long, String> strmap = new HashMap<Long, String>();
	    long numberOfLines = argLength == MIN_ARG_LENGTH ? DEFAULT_NUMBER_OF_LINES :Long.valueOf(args[2]).longValue();
	    try {
	    	RandomAccessFile randomFile = new RandomAccessFile(filepath, "r");
	    	long filelength = randomFile.length();
	        long filepos = filelength - 1;
	        long linescovered = 1;
	        System.out.println(filepos);
	        for (linescovered = 1; linescovered <= numberOfLines; filepos--) {
	            randomFile.seek(filepos);
	            if (randomFile.readByte() == 0xA)
	                if (filepos == filelength - 1)
	                    continue;
	                else {
	                         strmap.put(linescovered,randomFile.readLine());
	                    linescovered++;
	                }

	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    long startPosition = numberOfLines;
	    while (startPosition != 0) {
	        if (strmap.containsKey(startPosition)) {
	            // System.out.println("HashMap contains "+ startPosition
	            // +" as key");
	            String outstr = (String) strmap.get(startPosition);
	            System.out.println(outstr);
	            startPosition--;

	        }
	    }
	}

	

}
