import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Driver{
	public static void main(String[] args) throws FileNotFoundException{
		
		System.setIn(new FileInputStream("SolvedCube.txt"));
		
		Cube cube = new Cube();
		cube.setFaces();
		
		cube.rotateFaceClockwise(1);
		cube.rotateFaceClockwise(0);
//		cube.rotateFaceCounterClockwise(1);
//		cube.rotateFaceCounterClockwise(0);
		System.out.println(cube);
		
		CubeDrawer draw = new CubeDrawer(cube);
		draw.drawCube();
	}
}