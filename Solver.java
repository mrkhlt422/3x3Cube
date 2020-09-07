public class Solver{
	public static void solveCorners(Cube cube) {
		while(!verifyCorners(cube)) {
			if(checkTempCorner(cube)) {
				swapTempCornerWithRand(cube);
			}
			else {
				
			}
		}
	}
	
	private static boolean verifyCorners(Cube cube) {
		return true;
	}
	
	private static boolean checkTempCorner(Cube cube) {
		return true;
	}
	
	private static void swapTempCornerWithRand(Cube cube) {
		
	}
}