import java.util.*;

public class WordFrequencyGame {

    public static final String WHITE_SPACES = "\\s+";

    public String getResult(String sentence){


        if (sentence.split(WHITE_SPACES).length==1) {
            return sentence + " 1";
        } else {

            try {
                List<WorldInfo> worldInfos = calculateWordFrequency(sentence);

                worldInfos.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

                StringJoiner joiner = getStringJoiner(worldInfos);
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }

    private StringJoiner getStringJoiner(List<WorldInfo> worldInfos) {
        StringJoiner joiner = new StringJoiner("\n");
        for (WorldInfo wordInfo : worldInfos) {
            String wordInfoLine = String.format("%s %d", wordInfo.getValue(), wordInfo.getWordCount());
            joiner.add(wordInfoLine);
        }
        return joiner;
    }

    private List<WorldInfo> calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACES));
        List<WorldInfo> worldInfos = new ArrayList<>();
        for (String word: new HashSet<>(words)) {
            int count = Collections.frequency(words, word);
            worldInfos.add(new WorldInfo(word, count));
        }
        return worldInfos;
    }


}
