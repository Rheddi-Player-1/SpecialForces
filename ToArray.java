/**Class: ToArray
 * 
 * @author Danielle's Group
 * Receives a 10 letter word and a message and adds them to a large array
 */
public class ToArray 
{
	
	private String message;
	private String tenLetterWord;
	
	public ToArray(String tenLetterWord, String message)
	{
		this.message = message.toUpperCase();
		this.tenLetterWord = tenLetterWord;
	}
	
	/**Method: bigArray()
	 * 
	 * @return bigArray
	 * Adds Strings to a two dimensional array
	 */
	public String[][] bigArray() 
	{
		NoBlanksOrPeriod fixItJesus = new NoBlanksOrPeriod(message);
		String newMessage = fixItJesus.noSpaces();
		int rows = 1 + (newMessage.length() / 10);
		String[][] bigArray = new String[rows][10];
		char[] tenWord = tenLetterWord.toCharArray();
		
		int count = 0;
		
		//Adds the 10 letter word first
		for(int i = 0; i < tenWord.length; i++)
		{
			bigArray[0][i] = Character.toString(tenWord[i]).toUpperCase();
		}
		
		//Adds the message
		for(int i = 1; i < rows; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				bigArray[i][j] = Character.toString(newMessage.charAt(count));
				count++;
			}
		}
		
		return bigArray;
	}
	
	//Testing 
	public static void main(String[] args)
	{
		ToArray aFriggenMessage = new ToArray("Abductions", "CASH MONEY RECORDS TAKING OVER FOR THE NINE NINE AND THE TWO THOUSANDS!");
		
		String[][] array = aFriggenMessage.bigArray();
		
		for (int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				System.out.print(array[i][j] + " ");
			}
			System.out.println();;
		}
		
	}
}
