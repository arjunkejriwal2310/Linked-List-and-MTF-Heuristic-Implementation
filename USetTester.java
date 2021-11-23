import java.util.Arrays;
import java.util.Random;

public class USetTester {

    private static int MAX = 20;
    private static Random rand = new Random(0);
    
    public static void main(String[] args) {
	
	// replace with your SimpleUSet implementation
	SimpleUSet<Integer> set = new MTFSimpleUSet<Integer>();
	
	System.out.println("Constructing array of elements...");

	boolean[] inSet = getInSet();
	int[] elts = getElementArray(inSet);

	System.out.println("    Elements = " + Arrays.toString(elts));

	System.out.println("Testing add method...");
	if (testAdd(set, inSet)) {
	    System.out.println("   ...test passed");
	} else {
	    System.out.println("   ...test failed");
	}

	System.out.println("Testing remove method...");
	if (testRemove(set, inSet)) {
	    System.out.println("   ...test passed");
	} else {
	    System.out.println("   ...test failed");
	}
	
	System.out.println("Testing find method...");
	if (testFind(set, inSet)) {
	    System.out.println("   ...test passed");
	} else {
	    System.out.println("   ...test failed");
	}
	
	
    }

    private static boolean[] getInSet () {
	boolean[] inSet = new boolean[MAX];
	for (int i = 0; i < inSet.length; ++i) {
	    inSet[i] = (rand.nextInt(2) == 0);
	}

	return inSet;
    }

    private static int[] getElementArray (boolean[] inSet) {
	int size = 0;
	for (int i = 0; i < inSet.length; ++i) {
	    if (inSet[i]) {
		++size;
	    }
	}

	int[] elts = new int[size];

	int curIndex = 0;

	for (int i = 0; i < inSet.length; ++i) {
	    if (inSet[i]) {
		elts[curIndex] = i;
		++curIndex;
	    }
	}

	return elts;
    }

    private static boolean testAdd (SimpleUSet<Integer> set, boolean[] inSet) {
	int size = 0;

	// try adding elements to the set
	for (int i = 0; i < inSet.length; ++i) {
	    if (inSet[i]) {
		if (!set.add(i)) {
		    System.out.println("   add(" + i + ") failed.");
		    return false;
		}
		
		++size;
	    }
	}

	if (set.size() != size) {
	    System.out.println("   size() method returned incorrect value");
	    return false;
	}

	for (int i = 0; i < inSet.length; ++i) {
	    boolean added = set.add(i);
	    if (added && inSet[i]) {
		System.out.println("   added " + i + " which was already in set");
		return false;
	    }

	    if (!added && !inSet[i]) {
		System.out.println("   failed to add " + i + " (not previously in set)");
		return false;
	    }
	}
	
	return true;
    }

    private static boolean testRemove (SimpleUSet<Integer> set, boolean[] inSet) {
	int size = inSet.length;
	
	for (int i = 0; i < inSet.length; ++i) {
	    if (!inSet[i]) {
		if (set.remove(i) == null) {
		    System.out.println("   failed to remove " + i);
		    return false;
		}
		--size;
	    }
	}

	if (size != set.size()) {
	    System.out.println("   size() method fails after removal");
	    return false;
	}
	
	return true;
    }

    private static boolean testFind (SimpleUSet<Integer> set, boolean[] inSet) {
	for (int i = 0; i < inSet.length; ++i) {
	    Integer elt = set.find(i);

	    if (inSet[i] && (elt == null)) {
		System.out.println("   failed to find " + i);
		return false;
	    }

	    if (!inSet[i] && (elt != null)) {
		System.out.println("   found " + i + " but should not have");
		return false;
	    }
	}
	
	return true;
    }


    
}
