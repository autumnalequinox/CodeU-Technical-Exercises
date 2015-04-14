package Set1;

public class SparseMatrix {
	
	public static void getNonZero(int matrix[][]){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] != 0){
					System.out.println("["+i+","+j+"]: " + matrix[i][j]);
				}
			}
		}
	}
	
	public static int[][] createMatrix(){
		int rows = (int) (10*Math.random() + 1);
		int cols = (int) (10*Math.random() + 1);
		int matrix[][] = new int[rows][cols];
		 
		int numNonZero = (int) (.5*(rows*cols)*Math.random());
		
		for(int i = 0; i < numNonZero; i++){
			int row = (int) (rows*Math.random());
			int col = (int) (cols*Math.random());
			int val = (int) (100*Math.random());
			
			matrix[row][col] = val;
		}
		
		return matrix;
	}
	
	public static void printOutMatrix(int matrix[][]){
		for(int i = 0; i<matrix.length; i++){
			System.out.print("|");
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("|");
		}
	}
	
	public static void main(String args[]){
		int matrix[][];
		for(int i = 0; i < 5; i++){ // 5 test matrices
			matrix = createMatrix();
			printOutMatrix(matrix);
			getNonZero(matrix);
			System.out.println();
		}
	}
	
}
