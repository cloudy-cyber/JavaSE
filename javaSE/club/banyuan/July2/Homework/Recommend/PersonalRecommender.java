package club.banyuan.July2.Homework.Recommend;

import java.util.*;

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
        List<String> list = likes.get(personName);
        Set<String> result = new HashSet<>();
        for (List<String> one : likes.values()) {
            List<String> list1 = new ArrayList<>(one);
            list1.retainAll(list);//保留两个list中有交集的部分
            if (list1.size() > 0) {
                result.addAll(one);
            }
        }
        result.addAll(list);
        return new LinkedList<>(result);
    }

    @Override
    public List<String> recommendByProject(String projectName) {
      Set<String>setProject=new HashSet<>();
      List<String>result=new LinkedList<>(setProject);
        for (List<String> value : likes.values()) {
            if(value.contains(projectName)){
              setProject.addAll(value);
            }
        }
        return result;
    }
}


