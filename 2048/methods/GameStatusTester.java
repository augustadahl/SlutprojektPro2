package methods;

import controll.Tile;

public class GameStatusTester {

	//anv�nder comparer f�r att kolla om spelet har hamnat i ett d�dl�ge
	
	public static boolean TestMoveable(Tile[][] grid) {
	
	Tile[][] testerOrigin = Copy.copy(grid);

	Tile[][] testerMoving = Copy.copy(grid);

	MoveMethods.left(testerMoving);
	if (!Comparer.compare(testerMoving, testerOrigin)) {
		MoveMethods.right(testerMoving);
		if (!Comparer.compare(testerMoving, testerOrigin)) {
			MoveMethods.up(testerMoving);
			if (!Comparer.compare(testerMoving, testerOrigin)) {
				MoveMethods.down(testerMoving);
				if (!Comparer.compare(testerMoving, testerOrigin)) {

					return false;
					
				}
			}
		}
	}
	
	return true;
	
	}
	
	
	
	

	
	
	
	
	
}
