/**
 * This class handles when our "optional" is empty. Shows what went wrong and ends the execution
 * @author km1473
 */
public class EmptyValueException extends Exception
{
	String message;
	public EmptyValueException(String message)
	{
		this.message = message;
		System.out.println(message);
	}
}
