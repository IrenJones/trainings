package leetcode.leetcode_by_topics.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FindDuplicateFileInSystem {

    public static void main(String[] args) {
        FindDuplicateFileInSystem s = new FindDuplicateFileInSystem();
            s.findDuplicateAgain(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)"});
    }

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        Pattern pattern = Pattern.compile("([a-zA-Z0-9\\.]+)\\(([a-zA-Z0-9]+)\\)");

        for(String path: paths){
            String[] components = path.split(" ");
            for(int i = 1; i < components.length; i++){
                Matcher matcher = pattern.matcher(components[i]);
                while (matcher.find()) {
                    String fileName = matcher.group(1);
                    String fileContent = matcher.group(2);
                    List<String> files = map.getOrDefault(fileContent, new ArrayList<>());
                    files.add(components[0] + "/" + fileName);
                    map.put(fileContent, files);
                }
            }
        }

        return map.values().stream()
            .filter(list -> list.size() > 1)
            .collect(Collectors.toList());
    }

    public List<List<String>> findDuplicateAgain(String[] paths) {
        Map<String, List<String>> dup = new HashMap<>();

        Pattern pattern = Pattern.compile("([a-zA-Z0-9\\.]+)\\(([a-zA-Z0-9]+)\\)");

        for(String path: paths){
            String[] parts = path.split(" ");
            String dir = parts[0];
            for(int i = 1; i < parts.length; i++){
                Matcher matcher = pattern.matcher(parts[i]);
                while(matcher.find()){
                    String file = matcher.group(1);
                    String content = matcher.group(2);
                    List<String> list = dup.getOrDefault(content, new ArrayList<>());
                    list.add(dir + "/" + file);
                    dup.put(content, list);
                }
            }
        }

        return dup.entrySet().stream()
            .map(Map.Entry::getValue)
            .filter(l -> l.size() > 1)
            .collect(Collectors.toList());
    }
}
