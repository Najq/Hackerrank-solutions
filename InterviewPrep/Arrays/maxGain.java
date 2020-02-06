// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static int maxGain(int[] a) {
    
    if(a.length < 1 || a.length == 1){
        return 0;
    }
    int max = 0;
    int min = a[0];
    for(int i=1;i<a.length;i++){
        if(a[i] > min && (a[i]-min > max)){
            max = a[i]-min;
        }
        if(a[1] < min){
            min = a[1];
        }
    }
    return max;
}