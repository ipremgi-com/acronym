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

        for(String word: words){
            sb.append(word.substring(0,1));
        }
        return sb.toString();
    }

}
