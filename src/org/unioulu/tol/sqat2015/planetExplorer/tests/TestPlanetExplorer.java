package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	@Test
	public void testIsGridCreatedCorrectly() 
	{
		PlanetExplorer planetExplorer = new PlanetExplorer(3,3,"0,2/2,2");
		int[][] tempArray = planetExplorer.getPlanetSurfaceArray();
		assertEquals(1, tempArray[0][2]);
	}
	
	@Test
	public void testIsOutputCorrectIfNoObstacle() 
	{
		PlanetExplorer planetExplorer = new PlanetExplorer(3,3,"2,2");
		//int[][] tempArray = planetExplorer.getPlanetSurfaceArray();
		assertEquals("0,2,E", planetExplorer.executeCommand("f"));
	}
}
