import java.util.*;

public class HangmanManager
{
	
	int guesses;
	
	int wordLength;
	
	Set<String> dict = new HashSet<String>();
	Set<Character> prevGuesses = new HashSet<Character>();
	Set<String> words = new HashSet<String>();
	
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		for(int i = 0; i < dictionary.size(); i++) {
			dict.add(dictionary.get(i));
		}
		
		guesses = max;
		
		wordLength = length;
		
		for(String x : dict) {
			if(x.length() == wordLength) {
				words.add(x);
			}
		}
	}
	
	public Set<String> words()
	{
		return words;
	}	
	
	public int guessesLeft()
	{
		guesses = guesses - 1;
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
