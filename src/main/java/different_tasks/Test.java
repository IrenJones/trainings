package different_tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Test s = new Test();
        List<String> words=new ArrayList<String>();

        words.add("Rat");
        words.add("Car");
        words.add("Below");
        words.add("Tast");
        words.add("Cried");
        words.add("Study");
        words.add("Thing");
        words.add("Chin");
        words.add("Grab");
        words.add("Act");
        words.add("Robed");
        words.add("Vase");
        words.add("Glean");
        words.add("Desserts");
        words.add("Tar");
        words.add("Arc");
        words.add("Elbow");
        words.add("State");
        words.add("Cider");
        words.add("Dusty");
        words.add("Night");
        words.add("Inch");
        words.add("Brag");
        words.add("Cat");
        words.add("Bored");
        words.add("Save");
        words.add("Angel");
        words.add("Streseed");
        List<List<String>> result = s.combine(words);

        for(List<String> list: result){
            System.out.println(list);
        }
    }

    public List<List<String>> combine(List<String> words){
        Map<String, List<String>> map = new HashMap<>();

        if(words.size() == 0){
            return new ArrayList<>();
        }

        for(String word: words){
            int[] chars = new int[26];
            String wordLC = new String(word).toLowerCase();
            for(char c: wordLC.toCharArray()){
                chars[c - 'a']++;
            }

            List<String> list;
            String convertedArray = convert(chars);
            if(map.containsKey(convertedArray)){
                 list = map.get(convertedArray);
            } else{
                list = new ArrayList<>();
            }
            list.add(word);
            map.put(convertedArray, list);
        }

        return map.entrySet()
            .stream()
            .map(e -> e.getValue())
            .collect(Collectors.toList());
    }

    private String convert(int[] chars) {
        StringBuilder sb = new StringBuilder();
        for(int v: chars){
            sb.append(v).append("_");
        }
        return sb.toString();
    }
}
