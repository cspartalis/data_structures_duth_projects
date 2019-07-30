import java.lang.*;

public class SimpleIntegerBinarySearch{

	public static int simpleIntegerBinarySearch(int[] values, int valueToFind) {
	    int low = 0;
    	int high = values.length -1;
    	int mid;
    	
    	for (int i=1; i<values.length; i++) {
    		for (int j=values.length-1; j>=i; j--) {
        		if (values[j-1] > values[j]) {
            		int temp = values[j-1];
            		values[j-1] = values[j];
            		values[j] = temp;
            	}
            }
		}
           
		while (low<=high) {
        	mid = (low+high) /2;
        	if (values[mid] > valueToFind) high = mid -1;
        	else if (values[mid] < valueToFind) low = mid +1;
        	else return mid;
    	}
    	return -1;
	}
	
	public static void main(String[] args){
		int[] A = {2,1};
		System.out.println(simpleIntegerBinarySearch(A,1));
	}
}