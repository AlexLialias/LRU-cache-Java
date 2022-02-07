/**
 * EmptyListException is a simple class that extends RuntimeException. It 
 * is thrown by {@link List} when get methods are called on an empty list. 
 */
public class EmptyListException extends RuntimeException
{
	/**
	 * Default constructor, calls constructor with parameter name set to "List"
	 */
	public EmptyListException()
	{
		this( "List" ); // call other EmptyListException constructor
	} // end EmptyListException no-argument constructor

	/**
	 * Constructor with list's name, calls RuntimeException(String)
	 * @param name the list name
	 */
	public EmptyListException( String name )
	{
		super( name + " is empty" ); // call superclass constructor
	} 
} 

