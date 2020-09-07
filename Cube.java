import java.util.*;

public class Cube{
	private char faces[][][];
	
	public Cube(){}
	
	public void setFaces(){
		Scanner input = new Scanner(System.in);
		faces = new char[6][3][3];
		for(int i = 0; i < 6; i++){
				setFace(i, input);
		}
	}
	
	private void setFace(int face, Scanner input) {
		//System.out.println("Face: " + (face+1));
		String faceChars = null;
		try {
			faceChars = input.nextLine();
		}catch(Exception e) {
			System.out.println("Too few faces were given.");
			System.exit(0);
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				faces[face][i][j] = faceChars.charAt(i*3 + j);
			}
		}
	}
	
	public char[][][] getFaces(){
		return faces;
	}
	
	public void rotateFaceClockwise(int face) {
		rotateMainFaceClockwise(face);
		rotateFaceExtremitiesClockwise(face);
	}
	
	private void rotateMainFaceClockwise(int face) {
		char temp = faces[face][0][0];
		faces[face][0][0] = faces[face][2][0];
		faces[face][2][0] = faces[face][2][2];
		faces[face][2][2] = faces[face][0][2];
		faces[face][0][2] = temp;
		temp = faces[face][0][1];
		faces[face][0][1] = faces[face][1][0];
		faces[face][1][0] = faces[face][2][1];
		faces[face][2][1] = faces[face][1][2];
		faces[face][1][2] = temp;
	}
	
	private void rotateFaceExtremitiesClockwise(int face) {
		char temp[] = new char[3];
		switch(face) {
			case 0 :
				temp[0] = faces[1][0][0];
				temp[1] = faces[1][1][0];
				temp[2] = faces[1][2][0];
				
				faces[1][0][0] = faces[4][0][0];
				faces[1][1][0] = faces[4][1][0];
				faces[1][2][0] = faces[4][2][0];
				
				faces[4][0][0] = faces[3][0][0];
				faces[4][1][0] = faces[3][1][0];
				faces[4][2][0] = faces[3][2][0];
				
				faces[3][0][0] = faces[2][0][0];
				faces[3][1][0] = faces[2][1][0];
				faces[3][2][0] = faces[2][2][0];
				
				faces[2][0][0] = temp[0];
				faces[2][1][0] = temp[1];
				faces[2][2][0] = temp[2];
				break;
			
			case 1 :
				temp[0] = faces[5][2][0];
				temp[1] = faces[5][2][1];
				temp[2] = faces[5][2][2];
				
				faces[5][2][0] = faces[4][2][0];
				faces[5][2][1] = faces[4][2][1];
				faces[5][2][2] = faces[4][2][2];
				
				faces[4][2][0] = faces[0][2][2];
				faces[4][2][1] = faces[0][1][2];
				faces[4][2][2] = faces[0][0][2];
				
				faces[0][0][2] = faces[2][0][0];
				faces[0][1][2] = faces[2][0][1];
				faces[0][2][2] = faces[2][0][2];
				
				faces[2][0][2] = temp[0];
				faces[2][0][1] = temp[1];
				faces[2][0][0] = temp[2];
				break;
				
			case 2 :
				temp[0] = faces[5][0][2];
				temp[1] = faces[5][1][2];
				temp[2] = faces[5][2][2];
				
				faces[5][0][2] = faces[1][2][0];
				faces[5][1][2] = faces[1][2][1];
				faces[5][2][2] = faces[1][2][2];
				
				faces[1][2][0] = faces[0][2][0];
				faces[1][2][1] = faces[0][2][1];
				faces[1][2][2] = faces[0][2][2];
				
				faces[0][2][0] = faces[3][0][0];
				faces[0][2][1] = faces[3][0][1];
				faces[0][2][2] = faces[3][0][2];
				
				faces[3][0][0] = temp[0];
				faces[3][0][1] = temp[1];
				faces[3][0][2] = temp[2];
				break;
			
			case 3 :
				temp[0] = faces[5][0][0];
				temp[1] = faces[5][0][1];
				temp[2] = faces[5][0][2];
				
				faces[5][0][0] = faces[2][2][0];
				faces[5][0][1] = faces[2][2][1];
				faces[5][0][2] = faces[2][2][2];
				
				faces[2][2][0] = faces[0][0][0];
				faces[2][2][1] = faces[0][1][0];
				faces[2][2][2] = faces[0][2][0];
				
				faces[0][0][0] = faces[4][0][0];
				faces[0][1][0] = faces[4][0][1];
				faces[0][2][0] = faces[4][0][2];
				
				faces[4][0][0] = temp[0];
				faces[4][0][1] = temp[1];
				faces[4][0][2] = temp[2];
				break;
				
			case 4 :
				temp[0] = faces[5][0][0];
				temp[1] = faces[5][1][0];
				temp[2] = faces[5][2][0];
				
				faces[5][0][0] = faces[3][2][0];
				faces[5][1][0] = faces[3][2][1];
				faces[5][2][0] = faces[3][2][2];
				
				faces[3][2][0] = faces[0][0][0];
				faces[3][2][1] = faces[0][0][1];
				faces[3][2][2] = faces[0][0][2];
				
				faces[0][0][0] = faces[1][0][0];
				faces[0][0][1] = faces[1][0][1];
				faces[0][0][2] = faces[1][0][2];
				
				faces[1][0][0] = temp[0];
				faces[1][0][1] = temp[1];
				faces[1][0][2] = temp[2];
				break;
			
			case 5 :
				temp[0] = faces[1][0][2];
				temp[1] = faces[1][1][2];
				temp[2] = faces[1][2][2];
				
				faces[1][0][2] = faces[2][0][2];
				faces[1][1][2] = faces[2][1][2];
				faces[1][2][2] = faces[2][2][2];
				
				faces[2][0][2] = faces[3][0][2];
				faces[2][1][2] = faces[3][1][2];
				faces[2][2][2] = faces[3][2][2];
				
				faces[3][0][2] = faces[4][0][2];
				faces[3][1][2] = faces[4][1][2];
				faces[3][2][2] = faces[4][2][2];
				
				faces[4][0][2] = temp[0];
				faces[4][1][2] = temp[1];
				faces[4][2][2] = temp[2];
				break;
		}
	}
	
	public void rotateFaceCounterClockwise(int face) {
		rotateFaceClockwise(face);
		rotateFaceClockwise(face);
		rotateFaceClockwise(face);
	}
	
	public String toString() {
		String output = "";
		for(int face = 0; face < 6; face++) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					output += (faces[face][i][j]);
				}
				output += "\n";
			}
			output += "\n";
		}
		return output;
	}
}