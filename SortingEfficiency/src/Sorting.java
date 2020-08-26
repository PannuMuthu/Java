import java.util.ArrayList;

public class Sorting {
	private Sorting() {}
	
	public static <E extends Comparable<E>> void  insertionSort(ArrayList<E> list) {
		for (int i = 1; i < list.size(); i++) {
			E current = list.get(i);
			int j = i;
			while((j > 0) && current.compareTo(list.get(j-1)) == -1) {
				list.set(j, list.get(j-1));
				j--;
			}
			list.set(j, current);
		}
	}
	
	public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {
		boolean changed = true;
	    do {
	    	changed = false;
	    	for (int i = 0; i < list.size() - 1; i++) {
	    		if (list.get(i).compareTo(list.get(i+1))==1) {
	    			E temp = list.get(i);
	    			list.set(i, list.get(i+1));
	    			list.set(i+1, temp);
	    			changed = true;
	    		}
	    	}
	    } while (changed);
	}
	
	public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++) {
	        E min = list.get(i);
	        int minIndex = i;
	        for (int j = i+1; j < list.size(); j++) {
	            if (list.get(j).compareTo(min)==-1) {
	                min = list.get(j);
	                minIndex = j;
	            }
	        }
	        E temp = list.get(i);
	        list.set(i, min);
	        list.set(minIndex, temp);
	    }
	}
	
	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
	    ArrayList<E> left = new ArrayList<E>();
	    ArrayList<E> right = new ArrayList<E>();
	 
	    if (list.size() > 1) {    
	        int center = (list.size()-1)/2;
	        for (int i=0; i<=center; i++) {
	                left.add(list.get(i));
	        }
	        mergeSort(left);

	        for (int j=center+1; j<list.size(); j++) {
	                right.add(list.get(j));
	        }
	        mergeSort(right);
	 
	        merge(left, right, list);
	    }
	}

	private static <E extends Comparable<E>> void merge(ArrayList<E> left, ArrayList<E> right, ArrayList<E> list) {
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < left.size() && j < right.size()) {
			if (left.get(i).compareTo(right.get(j))==-1) {
				list.set(k,left.get(i));
				i++;
			} else {
				list.set(k,right.get(j));
				j++;
			}
			k++;
		}
		
		while(i < left.size()) {
			list.set(k, left.get(i));
			i++;
			k++;
		}
		
		while (j < right.size()) {
			list.set(k, right.get(j));
			j++;
			k++;
		}
		
	}
	
	public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
		int low = 0;
		int high = list.size() - 1;
		quickSortHelper(list,low,high);
	}
	
	private static <E extends Comparable<E>> void quickSortHelper(ArrayList<E> list, int low, int high) {
		

		int middle = low + (high - low) / 2;
		E pivot = list.get(middle);
 
		int i = low;
		int j = high;
		
		while (i <= j) {
			while (list.get(i).compareTo(pivot) == -1) {
				i++;
			}
 
			while (list.get(j).compareTo(pivot) == 1) {
				j--;
			}
 
			if (i <= j) {
				E temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
				i++;
				j--;
			}
		}
 
		if (low < j) {
			quickSortHelper(list, low, j);
		}
			
		if (high > i) {
			quickSortHelper(list, i, high);
		}
			
	}
	
	
	public static void countingSort(ArrayList<Integer> list) {
		Integer max = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}
		
        int[] result = new int[list.size()]; 
  
        int[] count = new int[max+1]; 
  
        for (int i = 0; i < list.size(); ++i) 
            ++count[list.get(i)]; 
  
       
        for (int i = 1; i <= max; ++i) 
            count[i] += count[i - 1]; 
   
        for (int i = 0; i < list.size(); ++i) { 
            result[count[list.get(i)] - 1] =  list.get(i);
            --count[list.get(i)]; 
        } 
        
        for (int i = 0; i < list.size(); i++) {
        	list.set(i, result[i]);
        }
		
	}
	
	public static void radixSort(ArrayList<Integer> list) {
		  final int BASE = 10;
		  ArrayList<Integer>[] buckets = new ArrayList[BASE];
          for (int i = 0; i < buckets.length; i++) {
              buckets[i] = new ArrayList<Integer>();
          }
         
          boolean maxSize = false;
          int current = -1;
          int currentMagnitude = 1;
          while (!maxSize) {
              maxSize = true;

           for (int i = 0; i < list.size(); i++) {
              current = list.get(i) / currentMagnitude;
              buckets[current % BASE].add(list.get(i));
              if (maxSize && current > 0) {
                  maxSize = false;
              }
            }
            
            int j = 0;
            for (int k = 0; k < BASE; k++) {
              for (int l = 0; l < buckets[k].size(); l++) {
                list.set(j++, buckets[k].get(l));
              }
              buckets[k].clear();
            }

            currentMagnitude = currentMagnitude * BASE;
          }
     }

}
	







