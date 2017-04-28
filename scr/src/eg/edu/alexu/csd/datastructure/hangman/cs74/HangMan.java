package eg.edu.alexu.csd.datastructure.hangman.cs74;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

import java.lang.String;

/**
 * @author HP
 *
 */
public class HangMan implements IHangman {
  /**
   * array of words.
   */
  private String[] dic_Words = null;
  /**
   * the secret word chosen from the dic.
   */
  private String secretword = null;
  /**
   * the dashed word.
   */
  private String shownword = null;
  /**
   * the number of the max wrong guesses.
   */
  public int maxNumofWrongGueses = 0;

  /**
   * set the dic array.
   * @param wordsthe dic array
   */
  public final void setDictionary(final String[] words) {

    dic_Words = words;

  }

  /**
   * randomly select the secret word from the array.
   * 
   * @return the secret word
   */
  public final String selectRandomSecretWord() {
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

  /**
   * guess the character.
   *
   * @param c string
   * @return the shown word after guessing
   */
  public final String guess(final Character c) {
    if (secretword == null) {
      return null;
    } else if (c == null) {
      return shownword;

    } else {

      char[] word = new char[shownword.length()];
      word = shownword.toCharArray();

      int flag = 0;

      for (int i = 0; i < word.length; i++) {
        if (Character.toLowerCase(c.charValue())
            == Character.toLowerCase(secretword.charAt(i))) {

          flag = 1;
          word[i] = secretword.charAt(i);
        }
      }
      if (flag == 0) {
        maxNumofWrongGueses--;
      }
      if ((maxNumofWrongGueses <= 0)) {
        return null;
      }

      shownword = String.valueOf(word);
      return shownword;
    }
  }

  /**
   * set the max number .
   *
   * @param max integer
   */
  public final void setMaxWrongGuesses(final Integer max) {
    this.maxNumofWrongGueses = max;
  }

}
