/**
 * Created by IPREMGI on 29/03/2017.
 */
public class Acronym {

    private String phrase;

    public Acronym(String phrase){
        this.phrase = phrase;
    }

    /**
     * The method that will return the Acronym
     * 1) Break up Phrase into words
     * 2) Loop through words and get Acronym
     * 3) Build the Acronym based on each word Acronym
     * @return - the acronym
     */
    public String get(){
        StringBuilder sb = new StringBuilder();
        String[] words = phrase.split("\\s");

        //looping through the words
        for(String word: words){
            sb.append(getAcronym(word));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * Get Acronym for each word
     * 1) If only first letter is Upper case or whole word is upper case then return first letter
     * 2) Break word into chars and check if there are more than 1 acronym in the word e.g. HyperText or metal-oxide
     * @param word - create acronym for
     * @return - the acronym for the word
     */
    private String getAcronym(String word){
        StringBuilder sb;
        char[] letters;

        if(isSingleAcronym(word)){
            return word.substring(0,1);
        } else {
            sb = new StringBuilder();
            letters = word.toCharArray();
            sb.append(letters[0]); // first letter will always be an acronym

            // looping through each letter in word
            // starting from the second letter in the word
            for (int i = 1; i<letters.length -1; i++){
                if(isNextAcronym(letters[i],letters[i+1])){
                    sb.append(letters[i+1]);
                }
            }
        }
        return sb.toString();
    }

    /**
     * Check if the word only has a single Acronym
     * Ruby --> true
     * HyperText --> false
     * @param word - check if it has a single acronym
     * @return - true if single acronym
     */
    private boolean isSingleAcronym(String word){
        return (word.substring(1, word.length()).matches("[a-z]*") || word.matches("[A-Z]*"));
    }

    /**
     * To check if the next char is an Acronym based on the current char
     * Example
     *  H y --> no acronym
     *  r T --> acronym
     *  - o --> acronym
     * @param c - current char
     * @param nc - next char
     * @return - true if next char is an acronym
     */
    private boolean isNextAcronym(char c, char nc){
        return ((Character.isLowerCase(c) && Character.isUpperCase(nc)) || (!Character.isLetter(c) && Character.isLetter(nc)));
    }
}
