package se.nackademin.examination.examination_jacoco;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResultsFromInputsTest {

	@Test
	public void testAgeGettersAndSettersMethods() {
		ResultFromInputs resultsFromInputs = new ResultFromInputs();
		resultsFromInputs.setResultForNameLenght(10);
		assertEquals("The result should be 10", resultsFromInputs.getResultForNameLenght(), 10);
	}
	
	@Test
	public void testGetResultForGender(){
		ResultFromInputs result = new ResultFromInputs();
		result.setResultForGender(5);
		assertEquals("The result should be 5",result.getResultForGender(),5);
	}
	
	@Test
	public void testGetResultForAge(){
		ResultFromInputs result = new ResultFromInputs();
		result.setResultForAge(20);
		assertEquals("The result should be 20",result.getResultForAge(),20);
	}
	
	@Test
	public void testGetResultForHomeCity(){
		ResultFromInputs result = new ResultFromInputs();
		result.setResultForHomeCity(7);
		assertEquals("The result should be 7",result.getResultForHomeCity(),7);
	}

}
