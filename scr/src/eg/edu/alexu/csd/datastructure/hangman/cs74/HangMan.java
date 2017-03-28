package eg.edu.alexu.csd.datastructure.hangman.cs74;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

import java.lang.String;

/**
 * @author HP
 *
 */
public class HangMan implements IHangman {

	private String[] dic_Words = null;
	private String secretword = null;
	private String shownword = null;
	public int maxNumofWrongGueses = 0;

	public void setDictionary(String[] words) {

		dic_Words = words;

	}

	public String selectRandomSecretWord() {
		if (dic_Words == null || dic_Words.length == 0) {
			return null;
		} else {
			int x = (int) (Math.random() * (dic_Words.length));
			this.secretword = this.dic_Words[x];
			this.shownword = this.dic_Words[x];

			char[] word;
			word = new char[this.shownword.length()];
			word = this.shownword.toCharArray();
			for (int i = 0; i < word.length; i++) {
				// word.setCharAt(i, '-');
				word[i] = '-';
			}
			this.shownword = String.valueOf(word);

			return secretword;

		}
	}

	public String guess(Character c) {
		if (secretword == null)
		{
			return null;

		}

		else if (c == null) {
			return shownword;

		} else {

			char[] word = new char[shownword.length()];
			word = shownword.toCharArray();

			int flag = 0;
			c = Character.toLowerCase(c.charValue());

			for (int i = 0; i < word.length; i++) {
				if (c == Character.toLowerCase(secretword.charAt(i))) {

					flag = 1;
					word[i] = secretword.charAt(i);
				}
			}
			if (flag == 0)
				maxNumofWrongGueses--;
			if ((maxNumofWrongGueses <= 0))
				return null;

			shownword = String.valueOf(word);
			return shownword;
		}
	}

	public void setMaxWrongGuesses(Integer max) {
		this.maxNumofWrongGueses = max;
	}

}
