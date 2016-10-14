package se.nackademin.examination.examination_jacoco;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class DataAnalysisTest {

	@Test
	public void test1() {
		DataAnalysis dataAnalysis = new DataAnalysis();
		ArrayList<String> values = new ArrayList<String>();
		values.addAll(Arrays.asList("Game", "Rafael", "Silva", "M", "30", "Fortaleza"));
		String result = dataAnalysis.buildFinalString(values);
		assertTrue("The result should contain 'The name of the homecity is big and the participant is 30 or older' ",
				result.contains("The name of the homecity is big and the participant is 30 or older"));

	}
	
	@Test
	public void testAgeAndNameStrings(){
		
		DataAnalysis data = new DataAnalysis();
		ArrayList<String> values = new ArrayList<String>();
		ArrayList<String> values2 = new ArrayList<String>();

		values.addAll(Arrays.asList("Game","Andre","sil","M","40","Stockholm"));
		String result = data.getResultStringNamesAndAge(values);
		assertTrue("The result should contain 'The first name is greater or equals in size to the last name and the participant older than 30' ",
		result.contains("The first name is greater or equals in size to the last name and the participant older than 30"));
		

		values2.addAll(Arrays.asList("Game","Ani","silla","M","20","Stockholm"));
		String result2=data.getResultStringNamesAndAge(values2);	
		assertTrue("The result should contain 'The first name is smaller or equals in size to the last name and the participant is 30 or younger' ",
		result2.contains("The first name is smaller or equals in size to the last name and the participant is 30 or younger"));
		

		ArrayList<String> values3 = new ArrayList<String>();
		values3.addAll(Arrays.asList("Game","Ani","silla","M","40","Stockholm"));
		String result3=data.getResultStringNamesAndAge(values3);
		assertTrue("The result should contain 'No analysis was performed'",result3.contains("No analysis was performed"));

		ArrayList<String> values4 = new ArrayList<String>();
		values4.addAll(Arrays.asList("Game","Aniddd","silla","M","20","Stockholm"));
		String result4=data.getResultStringNamesAndAge(values4);
		assertTrue("The result should contain 'No analysis was performed'",result4.contains("No analysis was performed"));
		
		
		
	}
	
	@Test
	public void testCityAndAge(){
		
		DataAnalysis data = new DataAnalysis();
		
		ArrayList<String> values = new ArrayList<String>();
		values.addAll(Arrays.asList("Game","Aniddd","silla","M","30","Colo"));
		String result=data.getResulStringHomecityAndAge(values);
		assertTrue("The result should contain 'No analysis was performed'",result.contains("The name of the homecity is small and the participant is 30 or older"));
		
		ArrayList<String> values1 = new ArrayList<String>();
		values1.addAll(Arrays.asList("Game","Aniddd","silla","M","20","Colo"));
		String result1=data.getResulStringHomecityAndAge(values1);
		assertTrue("The result should contain 'No analysis was performed'",result1.contains("The name of the homecity is small and the participant is younger than 30"));

		ArrayList<String> values2 = new ArrayList<String>();
		values2.addAll(Arrays.asList("Game","Aniddd","silla","M","30","Stockholm"));
		String result2=data.getResulStringHomecityAndAge(values2);
		assertTrue("The result should contain 'No analysis was performed'",result2.contains("The name of the homecity is big and the participant is 30 or older"));

		ArrayList<String> values3 = new ArrayList<String>();
		values3.addAll(Arrays.asList("Game","Aniddd","silla","M","20","Stockholm"));
		String result3=data.getResulStringHomecityAndAge(values3);
		assertTrue("The result should contain 'No analysis was performed'",result3.contains("The name of the homecity is big and the participant is younger than 30"));

	}

}
