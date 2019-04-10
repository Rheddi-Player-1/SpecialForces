/**Class: NoBlanksOrPeriod
 * 
 * @author Danielle's Group
 * Removes blanks and punctuation from a message.
 */
public class NoBlanksOrPeriod
{
	private String message;
	
	public NoBlanksOrPeriod(String message)
	{
		this.message = message;
	}
	
	/**Method noSpaces()
	 * 
	 * @return newMessgae
	 * 
	 * Removes the spaces from the message, replaces ending punctuation with two X's, and adds X's to fill up message
	 */
	public String noSpaces()
	{
		String newMessage = "";
		
		//Goes through the string and removes spaces and replaces ending punctuation with two X's
		for(int i = 0; i < message.length(); i++)
		{
			if(message.charAt(i) == '.' || message.charAt(i) == '?' || message.charAt(i) == '!')
			{
				newMessage += "XX";
			}
			else if (Character.isLetterOrDigit(message.charAt(i)))
			{
				newMessage += Character.toString(message.charAt(i));
			}
			
		}
		
		//Adds X's to end of message
		if(newMessage.length() % 10 > 0)
		{
			int count = 10 -(newMessage.length() % 10);
			while (count > 0)
			{
				newMessage += "x";
				count--;
			}
		}
		return newMessage.toUpperCase();
	}
	
	//Testing it
	public static void main(String[] args)
	{
		NoBlanksOrPeriod superSecretMessage = new NoBlanksOrPeriod("CASH MONEY RECORDS TAKING OVER FOR THE NINE NINE AND THE TWO THOUSANDS!");
		System.out.println(superSecretMessage.noSpaces());
	}
}
