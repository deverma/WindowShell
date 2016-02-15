package com.deepak.shell.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.deepak.shell.commands.CommandIf;
import com.deepak.shell.exceptions.CommandNotFoundException;
import com.deepak.shell.factory.CommandFactory;

public class TailCommandTest {

	String smallFile = "test\\com\\deepak\\shell\\test\\log1.txt";
	String largeFile = "test\\com\\deepak\\shell\\test\\log.txt";
	
	@Test
	public void testTailWithNoArgumentSmallFile() {
		try {
			System.out.println("Starting testTailWithNoArgumentSmallFile");
			CommandIf tailCmd = CommandFactory.getCommand("tail");
			String[] args = {"tail", smallFile};
			tailCmd.execute(args);
		} catch (Exception e) {
			fail();
		}
		System.out.println("Completed testTailWithNoArgumentSmallFile");
		
	}
	
	@Test
	public void testTailWithNoArgumentLargeFile() {
		try {
			System.out.println("Starting testTailWithNoArgumentSmallFile");
			CommandIf tailCmd = CommandFactory.getCommand("tail");
			String[] args = {"tail", largeFile};
			tailCmd.execute(args);
		} catch (Exception e) {
			fail();
		}
		System.out.println("Completed testTailWithNoArgumentLargeFile");
	}
	@Test
	public void testTailWithLineArgsSmallFile() {
		try {
			System.out.println("Starting testTailWithNoArgumentSmallFile");
			CommandIf tailCmd = CommandFactory.getCommand("tail");
			String[] args = {"tail", "-l", "12", smallFile};
			tailCmd.execute(args);
		} catch (Exception e) {
			fail();
		}
		System.out.println("Completed testTailWithLineArgsSmallFile");
	}
	@Test
	public void testTailWithLineArgsLargeFile() {
		try {
			System.out.println("Starting testTailWithNoArgumentSmallFile");
			CommandIf tailCmd = CommandFactory.getCommand("tail");
			String[] args = {"tail", "-l", "12",largeFile};
			tailCmd.execute(args);
		} catch (Exception e) {
			fail();
		}
		System.out.println("Completed testTailWithLineArgsLargeFile");
	}
}
