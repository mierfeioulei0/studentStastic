package cn.von.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生类
 *
 * @author mierfeioulei0
 * @version 1.0
 * @since 2018/10/05
 */
@Data
public class Student {
    private String id;//学号
    private String name;//姓名
    private ArrayList<Score> scoreList;//成绩列表

       public Student() {

    }

    public Student(String id, String name, List<Score> scoreList) {
        this.id = id;
        this.name = name;
        //深拷贝
        this.scoreList = new ArrayList<Score>();
        this.scoreList.addAll(scoreList);//
        //scoreList.forEach(s->this.scoreList.add(s));//
    }

    /**
     * 成绩列表深拷贝
     *
     * @param scoreList 成绩单
     * @author mierfeioulei0
     */
    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = new ArrayList<Score>();
        this.scoreList.addAll(scoreList);
    }
}
