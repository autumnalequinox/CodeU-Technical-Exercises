package Set1;

public class Zip {
	  // Fill in the method "join". It returns a boolean array. The ith
	  // value is that array (i.e., array[i]) should be true if the ith
	  // value in the first argument to join is divisible by the ith value
	  // in the second argument to join. The returned boolean array should
	  // be exactly as long as the shorter of the two arguments.
	  //
	  // Reminders: 
	  //
	  // 1. An integer p is said to be "divisible by" an integer q when there
	  // is some integer k such that q*k = p. This is the same as saying
	  // "the remainder of p when divided by q is 0". The remainder
	  // operator is Java is written with a percent sign: "a % b" is the
	  // remainder of a when divided by b.
	  //
	  // 2. The length of an array bar is stored in bar.length. 
	  //
	  // 3. New arrays are declared with the syntax:
	  //        float[] foo = new float[8];
	  //
	  static boolean[] join(int[] y, int[] z) {
	    // STUDENTS: WRITE YOUR CODE HERE!
		  boolean divisible[];
		  if(y.length <= z.length){
			  divisible = new boolean[y.length];
		  }
		  else
			  divisible = new boolean[z.length];
		  
		  for(int i = 0; i < divisible.length; i++){
			  
			  if(z[i] != 0 && y[i]%z[i] == 0)
				  divisible[i] = true;
		  }
		  
		  return divisible;
	  }

	  public static void main(String[] args) {
	    //
	    // Expected output:
	    //  false
	    //  false
	    //  false
	    //  false
	    //  true
	    //  false
	    //  true
	    //
	    // STUDENTS, ADD ADDITIONAL TEST CASES BELOW
	    //
	    int euler[] = {2, 7, 18, 28, 18, 28, 45, 90, 45};
	    int jenny[] = {8, 6, 7, 5, 3, 0, 9};
	    boolean divisibles[] = join(euler, jenny);
	    for (int i = 0; i < divisibles.length; ++i) {
	      System.out.println(divisibles[i]);
	    }
	  }
}

