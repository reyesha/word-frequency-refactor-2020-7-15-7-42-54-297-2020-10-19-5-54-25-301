import java.util.*;

public class WordFrequencyGame {
    public String getResult(String inputStr){


        if (inputStr.split("\\s+").length==1) {
            return inputStr + " 1";
        } else {

            try {

                //split the input string with 1 to n pieces of spaces
                String[] words = inputStr.split("\\s+");

                List<WorldInfo> worldInfoList = new ArrayList<>();
                for (String word : words) {
                    WorldInfo worldInfo = new WorldInfo(word, 1);
                    worldInfoList.add(worldInfo);
                }

                //get the map for the next step of sizing the same word
                Map<String, List<WorldInfo>> map =getListMap(worldInfoList);

                List<WorldInfo> list = new ArrayList<>();
                for (Map.Entry<String, List<WorldInfo>> entry : map.entrySet()){
                    WorldInfo worldInfo = new WorldInfo(entry.getKey(), entry.getValue().size());
                    list.add(worldInfo);
                }
                worldInfoList = list;

                worldInfoList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (WorldInfo w : worldInfoList) {
                    String s = w.getValue() + " " +w.getWordCount();
                    joiner.add(s);
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
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
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
