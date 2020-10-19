import java.util.*;

public class WordFrequencyGame {

    public static final String WHITE_SPACES = "\\s+";

    public String getResult(String inputStr){


        if (inputStr.split(WHITE_SPACES).length==1) {
            return inputStr + " 1";
        } else {

            try {

                String[] words = inputStr.split(WHITE_SPACES);

                List<WorldInfo> worldInfoList = new ArrayList<>();
                for (String word : words) {
                    WorldInfo worldInfo = new WorldInfo(word, 1);
                    worldInfoList.add(worldInfo);
                }

                Map<String, List<WorldInfo>> wordInfoMap =getListMap(worldInfoList);

                List<WorldInfo> distinctWordInfos = new ArrayList<>();
                for (Map.Entry<String, List<WorldInfo>> entry : wordInfoMap.entrySet()){
                    WorldInfo worldInfo = new WorldInfo(entry.getKey(), entry.getValue().size());
                    distinctWordInfos.add(worldInfo);
                }
                worldInfoList = distinctWordInfos;

                worldInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (WorldInfo wordInfo : worldInfoList) {
                    String wordInfoLine = String.format("%s %d", wordInfo.getValue(), wordInfo.getWordCount());
                    joiner.add(wordInfoLine);
                }
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }


    private Map<String,List<WorldInfo>> getListMap(List<WorldInfo> worldInfoList) {
        Map<String, List<WorldInfo>> map = new HashMap<>();
        for (WorldInfo worldInfo : worldInfoList){
            if (!map.containsKey(worldInfo.getValue())){
                ArrayList arr = new ArrayList<>();
                arr.add(worldInfo);
                map.put(worldInfo.getValue(), arr);
            }

            else {
                map.get(worldInfo.getValue()).add(worldInfo);
            }
        }


        return map;
    }


}
