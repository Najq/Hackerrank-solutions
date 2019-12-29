import java.io.*; 
import java.util.*; 
  
  
class TOH{

	static void towerOfHanoi(int noOfDisks,char sourceRod,char dest, char aux_rod){

		if(noOfDisks == 1){
			System.out.println("Moving  "+noOfDisks +" from "+sourceRod+" to "+dest );
			return;
		}
		towerOfHanoi(noOfDisks-1,sourceRod,aux_rod,dest);
		System.out.println("Moving  "+noOfDisks+" from "+sourceRod+" to "+dest);
		towerOfHanoi(noOfDisks-1,aux_rod,dest,sourceRod);
	}
    
    
    public static void main(String args[]){
    	int n =4;
    	towerOfHanoi(n,'A','C','B');
    }
    
}