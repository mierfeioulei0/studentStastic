import cn.von.vo.Score;
import cn.von.vo.Student;
import lombok.Data;

import java.util.ArrayList;

/**
 * 成绩统计
 *
 * @author mierfeioulei0
 * @version 1.0
 * @since 2018/10/5
 */

public class ScoreStatics {
    /**
     * 求平均成绩
     *
     * @param students
     * @param courseName
     * @return
     */

    public double averageScore(ArrayList<Student> students, String courseName) {
        double sum = 0;
        double average;
        for (int i = 0; i < students.size(); i++) {
            ArrayList<Score> scoreList = students.get(i).getScoreList();
            for (int j = 0; j < scoreList.size(); j++) {
                if (courseName.equals(scoreList.get(j).getCourseName())) {
                    sum += scoreList.get(j).getCourseScore();
                } else continue;
            }
        }
        average = sum / students.size();
        return average;
    }

    /**
     * 求最大成绩
     *
     * @param students
     * @param courseName
     * @return
     */
    public double maxScore(ArrayList<Student> students, String courseName) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < students.size(); i++) {
            ArrayList<Score> scoreList = students.get(i).getScoreList();
            for (int j = 0; j < scoreList.size(); j++) {
                if (courseName.equals(scoreList.get(j).getCourseName())) {
                    if (max <= scoreList.get(j).getCourseScore()) {
                        max = scoreList.get(j).getCourseScore();
                    }
                } else continue;
            }
        }
        return max;
    }

    /**
     * 求最小成绩
     *
     * @param students
     * @param courseName
     * @return
     */
    public double minScore(ArrayList<Student> students, String courseName) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < students.size(); i++) {
            ArrayList<Score> scoreList = students.get(i).getScoreList();
            for (int j = 0; j < scoreList.size(); j++) {
                if (courseName.equals(scoreList.get(j).getCourseName())) {
                    if (min >= scoreList.get(j).getCourseScore()) {
                        min = scoreList.get(j).getCourseScore();
                    }
                } else continue;
            }
        }
        return min;
    }
    public void printScore(ArrayList<Student> students) {
        String courseName;
        int courseNumber;

        courseNumber=students.get(0).getScoreList().size();

        for(int i=0;i<courseNumber;i++){
            courseName=students.get(0).getScoreList().get(i).getCourseName();
            System.out.println(courseName+"平均分："+averageScore(students,courseName));
            System.out.println(courseName+"最高分："+maxScore(students,courseName));
            System.out.println(courseName+"最低分："+minScore(students,courseName));

        }

    }

}
