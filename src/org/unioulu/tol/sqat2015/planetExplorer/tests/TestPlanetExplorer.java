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
		assertEquals("1,2,E", planetExplorer.executeCommand("ffrf"));
	}
	@Test
	public void testIsOutputCorrectIfGoingOverEdgeObstacle() 
	{
		PlanetExplorer planetExplorer = new PlanetExplorer(3,3,"0,2");
		//int[][] tempArray = planetExplorer.getPlanetSurfaceArray();
		assertEquals("0,2,E", planetExplorer.executeCommand("ffrfff"));
	}
	@Test
	public void testCollision() 
	{
		PlanetExplorer planetExplorer = new PlanetExplorer(3,3,"0,1");
		//int[][] tempArray = planetExplorer.getPlanetSurfaceArray();
		assertEquals("1,0,E", planetExplorer.executeCommand("fffffrf"));
	}
	@Test
	public void testOverEdge() 
	{
		PlanetExplorer planetExplorer = new PlanetExplorer(3,3,"0,1");
		//int[][] tempArray = planetExplorer.getPlanetSurfaceArray();
		assertEquals("2,0,W", planetExplorer.executeCommand("lf"));
	}
}
