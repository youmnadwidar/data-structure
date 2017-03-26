package eg.edu.alexu.csd.datastructure.hangman;

public interface IHangman {

	void setDictionary(String[] words);

	String selectRandomSecretWord();

	String guess(Character c);

	void setMaxWrongGuesses(Integer max);
	// void readFromFile(String filename,String[] data);

}
