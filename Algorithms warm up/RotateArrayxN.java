
class hackerank{
	
	
	void leftRotateArray(int arr[], int d,int n	) {	
		for(int i=0;i< gcd(d,arr.length);i++) {
			int temp = arr[i];
			int k=0;
			int j=i;
			while(true) {	
				k=j+d;
				if(k>=n) {
					k=k-n;
				}
				if(k==i)
					break;
				arr[j]=arr[k];
				j=k;
			}
			arr[j]=temp;	
		}
	}
	
	void printArray(int arr[], int size) {
		
		int i; 
        for (i = 0; i < size; i++) 
            System.out.print(arr[i] + " "); 
		
	} 
	
	int gcd(int a, int b) {
		
		if(b == 0) {
			return a;
		}
		return gcd(b,a%b);
		
	}
	
	public static void main(String[] args) {
		
		hackerank rotate = new hackerank();
		//take input or hardcoded for now
		int arr[]= {1, 2, 3, 4, 5, 6, 7,8,9};
		rotate.leftRotateArray(arr, 3,arr.length);
		rotate.printArray(arr, arr.length);
		
	}
}