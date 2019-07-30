import java.lang.*;

public class FindMaxValue {

	public static int findMaxValue(int[][] values) {
		int max= -2147483648;
		for (int i=0; i<values.length; i++){
			for (int j=0; j<values[i].length; j++){
				if (max < values[i][j]) max= values[i][j];
			}
		}			
		return max;
	}
	
		public static void main(String[] args) {
		int[][] A = { {1,-2}, {3,4,5,125}, {} };
		System.out.println(findMaxValue(A));
	}
}