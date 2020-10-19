import java.util.*;

public class WordFrequencyGame {

    public static final String WHITE_SPACES = "\\s+";

    public String getResult(String sentence){


        if (sentence.split(WHITE_SPACES).length==1) {
            return sentence + " 1";
        } else {

            try {
                List<WordInfo> wordInfos = calculateWordFrequency(sentence);

                wordInfos.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

                StringJoiner joiner = getStringJoiner(wordInfos);
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }

    private StringJoiner getStringJoiner(List<WordInfo> wordInfos) {
        StringJoiner joiner = new StringJoiner("\n");
        for (WordInfo wordInfo : wordInfos) {
            String wordInfoLine = String.format("%s %d", wordInfo.getValue(), wordInfo.getWordCount());
            joiner.add(wordInfoLine);
        }
        return joiner;
    }

    private List<WordInfo> calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACES));
        List<WordInfo> wordInfos = new ArrayList<>();
        for (String word: new HashSet<>(words)) {
            int count = Collections.frequency(words, word);
            wordInfos.add(new WordInfo(word, count));
        }
        return wordInfos;
    }


}
