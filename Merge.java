import java.util.*;

public class Merge{

  public static void main(String[] args) {
    //testing merge
    /*int[] data1 = {1,2,3,4};
    int[] data2 = {5,6,7,8};
    System.out.println("Array 1:");
    for (int i = 0; i < data1.length; i++){
      System.out.print(data1[i]);
    }
    System.out.println();
    System.out.println("Array 2:");
    for (int i = 0; i < data2.length; i++){
      System.out.print(data2[i]);
    }
    int[] total = merge(data1,data2);
    System.out.println();
    System.out.println("Combined Arrays:");
    for (int i = 0; i < total.length; i++){
      System.out.print(total[i]);
    }
    System.out.println();

   //{2,5,3,6,1,5,22,4}
   int[] a = {3,1,2,5,1,4,22};
   System.out.println("Old Array:");
   for (int i = 0; i < a.length; i++){
     System.out.print(a[i]);
   }
   System.out.println();
   mergesort(a);
   System.out.println("Sorted Array:");
   for (int i = 0; i < a.length; i++){
     System.out.print(a[i] + ", ");
   }
     System.out.println();
     */
     System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
     int[]MAX_LIST = {1000000000,500,10};
     for(int MAX : MAX_LIST){
       for(int size = 31250; size < 2000001; size*=2){
         long qtime=0;
         long btime=0;
         //average of 5 sorts.
         for(int trial = 0 ; trial <=5; trial++){
           int []data1 = new int[size];
           int []data2 = new int[size];
           for(int i = 0; i < data1.length; i++){
             data1[i] = (int)(Math.random()*MAX);
             data2[i] = data1[i];
           }
           long t1,t2;
           t1 = System.currentTimeMillis();
           Merge.mergesort(data2);
           t2 = System.currentTimeMillis();
           qtime += t2 - t1;
           t1 = System.currentTimeMillis();
           Arrays.sort(data1);
           t2 = System.currentTimeMillis();
           btime+= t2 - t1;
           if(!Arrays.equals(data1,data2)){
             System.out.println("FAIL TO SORT!");
             System.exit(0);
           }
         }
         System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
       }
       System.out.println();
     }
  }

    public static int[] merge(int[] data1, int[] data2){
      int[] output = new int[data1.length + data2.length];
      int i = 0, j = 0;
      //goes through both arrays and compares the values of the array and adjusts as needed
      for (int k = 0; k < output.length; k++) {
          if (i >= data1.length) {
            output[k] = data2[j];
            j++;
          }
          else if (j >= data2.length){
            output[k] = data1[i];
            i++;
          }
          else if (data1[i] <= data2[j]){
            output[k] = data1[i];
            i++;
          }
          else {
            output[k] = data2[j];
            j++;
          }
      }
      return output;
    }

    public static void mergesort(int[]data){
      if (data.length > 0) mergesort(data,0,data.length - 1);
    }

    public static void mergesort(int[] data, int lo, int hi){
        if (lo >= hi) return;
        //finds lengths of both arrays and creates them
        int len = data.length;
        int len1 = len / 2;
        int len2 = len - len1;
        int[] left = new int[len1];
        int[] right = new int[len2];
        //fills both arrays
        for (int i = 0; i < left.length; i++) {
            left[i] = data[i];
        }
        for (int i = 0; i < right.length; i++) {
             right[i] = data[i + len1];
         }
         //sort both sides
        mergesort(left,0,left.length - 1);
        mergesort(right,0,right.length -1);
        //merges them
        int[] temp = new int[len];
        //copies array over
        temp = merge(left,right);
        for (int i = 0; i < temp.length; i++){
          data[i] = temp[i];
        }
      }

}
