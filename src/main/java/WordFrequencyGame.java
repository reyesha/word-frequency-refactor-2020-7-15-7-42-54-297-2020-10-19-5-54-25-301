import java.util.*;

public class WordFrequencyGame {

    public static final String WHITE_SPACES = "\\s+";

    public String getResult(String sentence){
        List<WordInfo> wordInfos = calculateWordFrequency(sentence);
        sortList(wordInfos);
        StringJoiner joiner = getStringJoiner(wordInfos);
        return joiner.toString();
    }

    private void sortList(List<WordInfo> wordInfos) {
        wordInfos.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
    }

    private StringJoiner getStringJoiner(List<WordInfo> wordInfos) {
        StringJoiner joiner = new StringJoiner("\n");
        wordInfos.stream().map(wordInfo -> String.format("%s %d", wordInfo.getWord(), wordInfo.getWordCount())).forEach(joiner::add);
        return joiner;
    }

    private List<WordInfo> calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(WHITE_SPACES));
        List<WordInfo> wordInfos = new ArrayList<>();
        new HashSet<>(words).stream().map(word -> new WordInfo(word,Collections.frequency(words,word))).forEachOrdered(wordInfos::add);
        return wordInfos;
    }
}
