import java.util.*;

public class HangmanManager
{
	private Set<Character> guesses;
	private Set<String> words;
	private int guessesleft;
	private String pattern;
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		guessesleft = max;
		guesses = new TreeSet<Character>();
		words = new TreeSet<String>();
		for(String s : dictionary) {
			if(s.length() == length) {
				words.add(s);
			}
		}
		
	}
	
	public Set<String> words()
	{
		return words ;
	}	
	
	public int guessesLeft()
	{
		return guessesleft;
	}
		
	public Set<Character> guesses()
	{
		return guesses;
	}
	
	public String pattern()
	{
		return pattern;
	}
	
	public int record( char guess )
	{
		Map<String,Set<String>> families = new TreeMap<String,Set<String>>();
		String newPattern = "";
		guesses.add(guess);
		newPattern = "";
		for(String s : words) {
			for(int i = 0; i < s.length(); i++) {
				if(s.substring(i,i+1).equals("" + guess)) {
					newPattern += guess;
					
				}
				else if(pattern.substring(i,i+1).equals(s.substring(i,i+1))) {
					newPattern += pattern.substring(i,i+1);
				}
				else {
					newPattern += "-";
				}
			}
			if(families.containsKey(newPattern)) {
				families.get(newPattern).add(s);
			}
			else {
				families.put(newPattern, new TreeSet<String>());
				families.get(newPattern).add(s);
			}
		}
		words = families.get(newPattern);
		for(String s : families.keySet()) {
			if(families.get(s).size() > words.size()) {
				words = families.get(s);
				pattern = s;
			}
		}
		int count = 0;
		for(int i = 0; i < pattern.length(); i++) {
			if(pattern.substring(i, i+1).equals("" + guess)) {
				count++;
			}
		}
		return count;
	}
}