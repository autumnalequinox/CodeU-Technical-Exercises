package Set2;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class RotatedList {

    public static boolean isRotation(List<Integer> list1, List<Integer> list2) {
        
        // STUDENT: PROVIDE IMPLEMENTATION
    	if(list1.size() != list2.size() || list1.size() == 0)
    		return false;
    	
    	for(int i = 0; i < list2.size(); i++){
    		int j = 0;
    		int k = i;
    		while(list1.get(j) == list2.get(k)){
    			k++;
    			j++;
    			if(k == list2.size()){
    				k = 0;
    			}
    			
    			if(j == list1.size())
    			{
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }

    public static class Test_IsRotation {
        // Test framework for isRotation()
        // Instead of calling isRotation directly, call expectFailure or expectSuccess
        // with the desired input arguments.  Call init() to start collecting results
        // data for a series of tests, and call report() to print a short report on the
        // outcomes so far.
        private static int failCount;
        private static int successCount;

        public static void init() {
            failCount = 0;
            successCount = 0;
        }

        public static void expectFailure(List<Integer> a, List<Integer> b) {
            // STUDENT: PROVIDE IMPLEMENTATION
        	boolean failure = isRotation(a,b);
        	if(failure)
        		failCount++;
        	else
        		successCount++;
        }

        public static void expectSuccess(List<Integer> a, List<Integer> b) {
            // STUDENT: PROVIDE IMPLEMENTATION
        	boolean success = isRotation(a,b);
        	if(success)
        		successCount++;
        	else
        		failCount++;
        }

        private static void report(List<Integer> a, List<Integer> b, boolean got) {
            // Helper routine that may be used by expectFailure and expectSuccess.
            // It should be called only if the unexpected occurs. In other words,
            // if all tests work as expected, then the program will be silent.

            // STUDENT: PROVIDE IMPLEMENTATION
        }

        public static void reportSummary() {
            if (successCount == 0) {
                System.out.println("Summary: all " + failCount +
                                   " tests FAILED!");
            } else if (failCount == 0) {
                System.out.println("Summary: all " + successCount +
                                   " tests SUCCEEDED!");
            } else {
                System.out.println("Summary: " + successCount +
                                   " tests succeeded, " + failCount +
                                   " tests failed.");
            }
        }
    }
    
    public static void main(String[] args) {

        Test_IsRotation.init();

        List<Integer> list1, list2;
        list1 = new LinkedList<Integer>(Arrays.asList(1,2,3,4));
        list2 = new LinkedList<Integer>(Arrays.asList(3,4,1,2));
        Test_IsRotation.expectSuccess(list1,list2);
        list1 = new LinkedList<Integer>(Arrays.asList(1,2,3,4));
        list2 = new LinkedList<Integer>(Arrays.asList(3,4,2,1));
        Test_IsRotation.expectFailure(list1,list2);

        // STUDENT: ADD TEST CASES HERE

        // Check performance                                                                              
        int N = 10000;
        Integer[] a1 = new Integer[N];
        Integer[] a2 = new Integer[N];
        for (int i = 0; i < N; ++i) {
            a1[i] = 0;
            a2[i] = 0;
        }
        // (STUDENT: WHY THIS CASE?)
        a1[0] = 1;
        a2[N/2] = 1;
        list1 = new LinkedList<Integer>(Arrays.asList(a1));
        list2 = new LinkedList<Integer>(Arrays.asList(a2));
        long start_time, end_time;
        start_time = System.nanoTime();
        Test_IsRotation.expectSuccess(list1, list2);
        end_time = System.nanoTime();
        System.out.println("10000 elements: " +
                           (end_time - start_time) + " nsec");

        // STUDENT: DESIGN SOME BETTER TESTS FOR EVALUATING PERFORMANCE
        list1 = new LinkedList<Integer>();
        list2 = new LinkedList<Integer>(); 
        Test_IsRotation.expectFailure(list1, list2); //Empty lists, return as failure
        
        list1.add(1);
        list2.add(1);
        Test_IsRotation.expectSuccess(list1, list2); //list of one, same element
        
        list1.set(0, 2);
        Test_IsRotation.expectFailure(list1, list2); //list of one, different element
        
        list1.set(0, 1);
        list1.add(1);
        Test_IsRotation.expectFailure(list1, list2); //different size lists
        
        Integer a[] = {1,0,1,1};
        Integer b[] = {1,1,0,1};
        list1 = new LinkedList<Integer>(Arrays.asList(a));
        list2 = new LinkedList<Integer>(Arrays.asList(b));
        Test_IsRotation.expectSuccess(list1, list2); //rotated list, same starting element
        
        Test_IsRotation.reportSummary();
    }
}
