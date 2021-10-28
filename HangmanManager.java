import java.util.*;

public class HangmanManager
{
	
	int guesses;
	
	
	int wordLength;
	
	Set<String> dict = new HashSet<String>();
	Set<Character> prevGuesses = new HashSet<Character>();
	Set<String> words = new HashSet<String>();
	
	List<Set<String>> dicts;
	
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
		List<String> a = new ArrayList<>(dict);
		
		Set<String> none = new HashSet<String>();
		int z = 0;
		int max = 0;
		
		prevGuesses.add(guess);
		for(int i = 0; i<guesses;i++)
		{
			for(int x = 0; x<dict.size();x++)
			{
				String current = a.get(x);
					for(int y = 0;y<wordLength;y++)
						if(!current.substring(y,y+1).equals(guess))
						{
							none.add(current);
							z++;
							if(z > max)
								max = z;
						}

			}
		}
		
		return guess;
	}
}