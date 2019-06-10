#include <stdio.h>


struct pair{
    int start;
    int end;
};


int main() {
	//code
	int d,t,n,i,j,p;
	int activities= 0;
	scanf("%d",&t);
	int result[t];
	struct pair temp;
	for(p=0;p<t;p++){
    	scanf("%d",&n);
    	activities = 0;
    	struct pair arr[n+1];
    	for(i=0;i<n;i++){
    	    scanf("%d",&arr[i].start);
    	}
    	for(i=0;i<n;i++){
    	    scanf("%d",&arr[i].end);
    	}
    	//check pairs and find perfect order for count
    	//sort min finish time
    	//choose next start time greater than finish time
    	for(i=1;i<n;i++){
    	    for(j=0;j<n-i;j++){
    	        if(arr[j].end > arr[j+1].end){
    	            temp = arr[j];
    	            arr[j] = arr[j+1];
    	            arr[j+1] = temp;
    	        }
    	    }
    	}
    	activities=1;
    	int startTime = arr[0].end;
    	for(i=1;i<n;i++){
    	    if(arr[i].start >= startTime){
    	        activities++;
    	        startTime = arr[i].end;
    	    }
    	}
    	result[p]=activities;
	}
	
	for(i=0;i<t;i++){
	    printf("%d \n",result[i]);
	}

	return 0;
}