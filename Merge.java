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
    */
   int[] a = {2,5,3,6,1,5,22,4};
   System.out.println("Old Array:");
   for (int i = 0; i < a.length; i++){
     System.out.print(a[i]);
   }
   System.out.println();
   mergesort(a);
   System.out.println("Sorted Array:");
   for (int i = 0; i < a.length; i++){
     System.out.print(a[i]);
   }
     System.out.println();
  }

    public static int[] merge(int[] data1, int[] data2){
      int[] output = new int[data1.length + data2.length];
      int i = 0, j = 0;
      //goes through both arrays and compares the values
      for (int k = 0; k < output.length; k++) {
          if (i >= data1.length) output[k] = data2[j++];
          else if (j >= data2.length) output[k] = data1[i++];
          else if (data1[i] <= data2[j])  output[k] = data1[i++];
          else output[k] = data2[j++];
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
        temp = merge(left,right);
        for (int i = 0; i < temp.length; i++){
          data[i] = temp[i];
        }
      }

}
