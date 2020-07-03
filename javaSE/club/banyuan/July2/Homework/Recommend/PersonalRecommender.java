package club.banyuan.July2.Homework.Recommend;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PersonalRecommender implements Recommender {

    private final Map<String, List<String>> likes = new HashMap<>();

    @Override
    public void addLikes(String personName, String projectName) {
        List<String> templist;
        if (likes.containsKey(personName)) {
            templist = likes.get(personName);
        } else {
            templist = new LinkedList<>();
        }
        templist.add(projectName);
        likes.put(personName, templist);
    }

    @Override
    public boolean likesBoth(String personName, String projectName1, String projectName2) {
        if (!likes.containsKey(personName)) {
            throw new UnknownPersonException("没有此人");
        } else {
            return likes.get(personName).contains(projectName1) && likes.get(personName).contains(projectName2);
        }
    }

    @Override
    public List<String> recommendByPerson(String personName) {
        return likes.get(personName);
    }

    @Override
    public List<String> recommendByProject(String projectName) {
        List<String> recommendList = new LinkedList<>();
        for (List<String> one : likes.values()) {
            if (one.contains(projectName)) {
                recommendList.addAll(one);
                recommendList.remove(projectName);
            }
        }
        return recommendList;
    }
}

