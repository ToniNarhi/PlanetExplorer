package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	@Test
	public void testIsGridCreatedCorrectly() 
	{
		PlanetExplorer planetExplorer = new PlanetExplorer(3,3,"0,2/2,2");
		assertEquals(1,planetExplorer.getPlanetSurfaceArray());
	
	}
}
