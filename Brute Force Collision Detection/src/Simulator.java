import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Simulator {
	
	
	public static void main(String[] args) {
	
	 	int w1 = Integer.parseInt(args[0]);
		int w2 = Integer.parseInt(args[1]);
		int w3 = Integer.parseInt(args[2]);
		int w4 = Integer.parseInt(args[3]);
		int icell = Integer.parseInt(args[4]);
		double dcell = Double.parseDouble(args[4]);
		int itest = Integer.parseInt(args[5]);
		double dtest = Double.parseDouble(args[5]); 
		double results = 0;

		

		if (icell <= 0) {
			System.out.println("Cells must be greater than 0");
			return;
		}
		
		else if (itest <= 0) {
			System.out.println("Tests must be greater than 0");
			return;
		}
		
		
		for (int i = 0; i < itest; i++) {
			int[] intArray1 = shuffle(fill(w1, new Integer[icell]));
			int[] intArray2 = shuffle(fill(w2, new Integer[icell]));
			int[] intArray3 = shuffle(fill(w3, new Integer[icell]));
			int[] intArray4 = shuffle(fill(w4, new Integer[icell]));
			
			double collisions = 0;
			HashSet <String> s = new HashSet<>();
			
			for (int j = 0; j<icell; j++) {
				
				String c1 = Integer.toString(intArray1[j]);
				String c2 = Integer.toString(intArray2[j]);
				String c3 = Integer.toString(intArray3[j]);
				String c4 = Integer.toString(intArray4[j]);

				
				String concat = c1 + "," + c2 + "," + c3 + "," + c4;
//				System.out.println("Test " +  Integer.toString(i) + " Code " + Integer.toString(j) + ": " + concat);
				if (!s.add(concat)) {
//					System.out.println("Test " +  Integer.toString(i) + " Code " + Integer.toString(j) + " Collided");
					collisions++;
				}
			}
//			System.out.println(collisions);
			results += collisions/dcell;
		}
		double rate = 100 * results/dtest;
		
		System.out.println("Rate of collision: " + Double.toString(rate) + "%");
	}
	
	public static int[] shuffle (Integer[] intArray) {
		List<Integer> intList = Arrays.asList(intArray);
		Collections.shuffle(intList);
		int[] shuffled = new int[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			shuffled[i] = intArray[i].intValue();		
		}
		return shuffled;
	}
	
	public static Integer[] fill (int max, Integer[] array) {
		if (max <= 0) {
			for (int i = 0; i < array.length; i++) {
				array[i] = new Integer(0);
			}
		}
		else {
			for (int i = 0; i < array.length; i++) {
				array[i] = new Integer(i%max);
			}
		}
		return array;
	}
	
}
