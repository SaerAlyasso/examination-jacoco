package se.nackademin.examination.examination_jacoco;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class GameTest {

	@Test
	public void testRun(){
		//DataAnalysis data = new DataAnalysis();
		Game game = new Game();
		ArrayList<String> values = new ArrayList<String>();
		values.addAll(Arrays.asList("Betting","Kajsa","Larsson","F","20","Stockholm"));
		
		PrintStream originalOut = System.out;
		
		OutputStream out = new ByteArrayOutputStream();
		PrintStream print = new PrintStream(out);
		System.setOut(print);
		
		game.run(values);
		System.setOut(originalOut);
		assertTrue(out.toString().contains("Kajsa"));
	
	}
	
	
	@Test
	public void testCalculateBasedOnNames() {
		Game game = new Game();
		int i = game.calculateOutPutBasedOnNames("Rafael", "Silva");
		assertEquals("The result should be 1", i, 1);
		
		i = game.calculateOutPutBasedOnNames("Rafa","Silva");
		assertEquals("The result should be 0",i,0);
		
		i = game.calculateOutPutBasedOnNames("Rafa","Silv");
		assertEquals("The result should be 2",i,2);
	}
	
	@Test
	public void testCalculateBasedOnGender(){
		
		Game game = new Game();
		
		assertEquals("The result should be 0",game.calculateOutPutBasedOnGender('M'),0);
		assertEquals("The result should be 1",game.calculateOutPutBasedOnGender('F'),1);	
		assertEquals("The result should be 2",game.calculateOutPutBasedOnGender('T'),2);
	}

	@Test
	public void testCalculateBasedOnAge(){
		
		Game game = new Game();
		assertEquals("The result should be 0",game.calculateOutPutBasedOnAge(20),0);
		assertEquals("The result should be 1",game.calculateOutPutBasedOnAge(30),1);
		
		
	}
	
	@Test
	public void testCalculateBasedOnCity(){
		
		Game game = new Game();
		assertEquals("The result should be 0",game.calculateOutPutBasedOnHomeCity("Amsterdam"),0);
		assertEquals("The result should be 1",game.calculateOutPutBasedOnHomeCity("Basra"),1);
		assertEquals("The result should be 2",game.calculateOutPutBasedOnHomeCity("Caracas"),2);
		assertEquals("The result should be 3",game.calculateOutPutBasedOnHomeCity("Dublin"),3);
		assertEquals("The result should be 4",game.calculateOutPutBasedOnHomeCity("Edson"),4);
		assertEquals("The result should be 5",game.calculateOutPutBasedOnHomeCity("Flen"),5);
		assertEquals("The result should be 6",game.calculateOutPutBasedOnHomeCity("Glasgow"),6);
		assertEquals("The result should be 7",game.calculateOutPutBasedOnHomeCity("Hamburg"),7);
		assertEquals("The result should be 8",game.calculateOutPutBasedOnHomeCity("Izmir"),8);
		assertEquals("The result should be 9",game.calculateOutPutBasedOnHomeCity("Jakarta"),9);
		assertEquals("The result should be 10",game.calculateOutPutBasedOnHomeCity("Stockholm"),10);
	}
	
	@Test
	public void testFinalString(){
		
		Game game = new Game();
		
		PrintStream originalOut = System.out;
		
		OutputStream out = new ByteArrayOutputStream();
		PrintStream print = new PrintStream(out);
		System.setOut(print);
		
		game.buildFinalString("Anders", "Borg",new ResultFromInputs(), new Conversor());
		assertTrue(out.toString().contains("Anders"));
		assertTrue(out.toString().contains("it seems that you are a dedicated student and will be a great Software Tester Engineer!"));
		
		System.setOut(originalOut);
	}
	
	@Test
	public void testRunGame(){
		
		Game game = new Game();
				
		PrintStream originalOut = System.out;
		
		OutputStream out = new ByteArrayOutputStream();
		PrintStream print = new PrintStream(out);
		System.setOut(print);
		
		game.runGame("BlackJack", "Rafael", "Silva", 'M', 30, "Natal");
		String s = out.toString();
		assertTrue(out.toString().contains("#####################"));
		assertTrue(s.contains("Rafael Silva, your are a great man!"));
		System.setOut(originalOut);
		
	}
}
