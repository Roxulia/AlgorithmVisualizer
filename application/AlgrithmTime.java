package application;

public class AlgrithmTime {
	int[] generateArray(int size)
	{
		int[] a=new int[size];
		for(int i=0;i<size;i++)
		{
			a[i]=(int)(Math.random()*100);
			
		}
		return a;
	}
	
	long binarysearch(int s,int a[])
	{
		//int[] a=generateArray(s);
		
		int i, j, temp;
        int n = s;
        for (i = 1; i <= n; i++) {
            temp = a[i];
            j = i - 1;

            while (j >= 0 && temp <= a[j]) /* Move the elements greater than temp to one position ahead from their current position*/ {
                a[j + 1] = a[j];
                j = j - 1;
                //time1++;
            }
            a[j + 1] = temp;
        }
        long time1=0;
        int begin = 0, end = s,toSearch=(int)Math.random()*100;
        while (begin <= end) {
            int middle = (begin + end) / 2;
            int mid = a[middle];
            time1++;
            if (mid == toSearch) {
                break;
            }
            if (mid < toSearch) {
                begin = middle + 1;
            }
            if (mid > toSearch) {
                end = middle - 1;
            }
        }
        return time1;
	}
	
	long sequentialSearch(int s,int []a)
	{
		//
		
		//int[] a=generateArray(s);
		//long time1=System.nanoTime();
		long time1=0;
		int tosearch=(int)(Math.random()*100);
		//System.out.println(tosearch);
		for(int i=0;i<=s;i++)
		{
			time1++;
			if(a[i]==tosearch)break;
			
		}
		return time1;
	}
	
	long selectionSort(int s,int a[])
	{
		//int a[]=generateArray(s);
		//long time1=System.nanoTime();
		long time1=0;
		for(int i=0;i<=s-1;i++)
		{
			int min=i;
			for(int j=i+1;j<=s;j++)
			{
				if(a[j]<a[min])min=j;
				time1++;
				
				//System.out.println(j);
			}
			time1++;
			int temp=a[i];
			a[i]=a[min];
			a[min]=temp;
		}
		
		return time1;
		//return System.nanoTime()-time1;
	}
	
	long insertionSort(int s,int a[])
	{
		//int a[]=generateArray(s);
		//long time1=System.nanoTime();
		long time=0;
		int i, j, temp;
        int n = s;
        for (i = 1; i <= s; i++) {
            temp = a[i];
            j = i - 1;

            while (j >= 0 && temp <= a[j]) /* Move the elements greater than temp to one position ahead from their current position*/ {
                a[j + 1] = a[j];
                j = j - 1;
                time++;
            }
            time++;
            a[j + 1] = temp;
        }
        return time;
		//return System.nanoTime()-time1;
		
	}
	
	long bubbleSort(int s,int a[])
	{
		//int a[]=generateArray(s);
		long time1=0;
		int n = s;  
        int temp = 0;  
         for(int i=0; i <= n; i++){  
            for(int j=1; j <= (n-i); j++){  
               time1++;
            	if(a[j-1] > a[j]){  
                   //swap elements  
                   temp = a[j-1];  
                   a[j-1] = a[j];  
                   a[j] = temp;  
               }  
            	time1++;
            }          
         }  
		return time1;
	}

}
