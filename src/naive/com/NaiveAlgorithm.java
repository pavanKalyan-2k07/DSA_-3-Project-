package naive.com;

import java.util.Scanner;

public class NaiveAlgorithm 
{
	public static void naivesearch(String text , String pattern)
	{
		int n = text.length();
		int m = pattern.length();
		boolean found = false;
		
		
		for(int i = 0; i < n-m ; i++)
		{
			int j;
			for( j = 0;j < m ; j++)
			{
				if(text.charAt(i+j) != pattern.charAt(j))
				{
				break;
			}
	    }
			if(j == m)
			{
				System.out.println("The Pattern found at index:"+i);
				found = true;
			}
			
			if(!found)
			{
				System.out.println("Pattern not found !!!!!");
				
			}
			
			
		}
	}

	public static void main(String[] args) 
	{
	  Scanner sc = new Scanner(System.in);
	  
	 System.out.println(" Enter Text :");
	 String Text = sc.nextLine();
	 
	 System.out.println("Enter Pattern :");
	 String Pattern = sc.nextLine();
	 
	 
	 naivesearch(Text,Pattern);
	 
	 sc.close();

	}

}
