import java.util.*;

public class HangmanManager
{
	
	int guesses;
	
	int wordLength;
	
	Set<String> dict = new HashSet<String>();
	Set<Character> prevGuesses = new HashSet<Character>();
	Set<String> words = new HashSet<String>();
	
	String word;
	
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
		
		word = words.iterator().next();
		System.out.println(word);
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
		String a = "";
		for(int i = 0; i < word.length(); i++) {
			if(prevGuesses.size() != 0) {
				for(char x : prevGuesses) {
					if(x == word.charAt(i)) {
						System.out.println("adding: " + word.charAt(i));
						a += word.charAt(i);
					}
					else if(x == 0){
						System.out.println("Not adding");
						a += "-";
					}
				}
			} else {
				a += "-";
			}
		}
		
		return a;
		
	}
	
	public int record( char guess )
	{
		prevGuesses.add(guess);
		return guess;
	}
}