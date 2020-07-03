package club.banyuan.July2.Homework.Recommend;

/**
 * @author zhangbenchao
 * @date 2020/7/2 10:04 下午
 * 文件描述：
 */

import java.util.List;

public interface Recommender {
    void addLikes(String personName, String projectName);

    boolean likesBoth(String personName, String projectName1, String projectName2);

    List<String> recommendByPerson(String name);

    List<String> recommendByProject(String projectName);

}

