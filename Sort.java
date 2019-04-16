
public class Sort 
{
	private String[][] bigArray;
	
	public Sort(String[][] bigArray)
	{
		this.bigArray = bigArray;
	}
	
	//Takes the contents of the original index and swaps them to the destination index
	//Currently doesnt work
	public void swap(int orginIndex, int destinationIndex)
	{
		String[] tempArray = new String[bigArray[0].length];
		
		for(int i = 0; i < tempArray.length; i++)
		{
			tempArray[i] = bigArray[i][destinationIndex];
		}
		
		for(int j = 0; j < tempArray.length; j++)
		{
			bigArray[j][orginIndex] = bigArray[j][destinationIndex];
		}
		
		for(int k = 0; k < tempArray.length; k++)
		{
			bigArray[k][orginIndex] = tempArray[k];
		}
		
	}
	
	public String[][] sortByLetter()
	{
		
		boolean isSorted = false;
		int count = 0;
		do
		{
			for(int i = 0; i < 8; i++)
			{
				if(bigArray[0][i].compareTo(bigArray[0][i+1]) < 0)
				{
					swap(i, i+1);					
				}
				else if(bigArray[0][i].compareTo(bigArray[0][i+1]) > 0) 
				{
					swap(i+1, i);
				}
				else if(bigArray[0][i].compareTo(bigArray[0][i+1]) == 0)
				{
					count++;
				}
				
				if(i + 2 == 10 || count == 9)
					isSorted = true;
			}
		}
		while(!isSorted);
		
		return bigArray;
	}

	
}
