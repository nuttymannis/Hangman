import java.util.*;

public class HangmanManager
{
	
	int guesses = 0;
	
	Set<String> words = new HashSet<String>();
	Set<Character> prevGuesses = new HashSet<Character>();
	
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		
	}
	
	public Set<String> words()
	{
		return words;
	}	
	
	public int guessesLeft()
	{
		return guesses;
	}
		
	public Set<Character> guesses()
	{
		return prevGuesses;
	}
	
	public String pattern()
	{
		return "";
	}
	
	public int record( char guess )
	{
		prevGuesses.add(guess);
		return guess;
	}
}
