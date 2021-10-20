import java.util.*;

public class HangmanManager
{
	
	int guesses;
	int guessMax;
	
	int wordLength;
	
	Set<String> words = new HashSet<String>();
	Set<Character> prevGuesses = new HashSet<Character>();
	
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		words = (Set<String>) dictionary;
		
		guesses = 0;
		guessMax = max;
		
		wordLength = length;
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
