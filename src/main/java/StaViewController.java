import cn.von.vo.Student;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by mierfeioulei0 on 2018/10/6.
 */
public class StaViewController  implements ControlledStage, Initializable {
    public Label printScore;
    public TextField insert;
    StageController myController;

    public void setStageController(StageController stageController) {
        this.myController = stageController;
    }
    public void printSco()
    {
        String courseName;
        int courseNumber;

        courseNumber=myController.getStudents().get(0).getScoreList().size();
        String text="";
        ScoreStatics scoreStatics=new ScoreStatics();
        for(int i=0;i<courseNumber;i++){
            courseName=myController.getStudents().get(0).getScoreList().get(i).getCourseName();
           text+=(courseName+"平均分:"+scoreStatics.averageScore(myController.getStudents(),courseName)
                   +"\n"+courseName+"最低分:"+scoreStatics.minScore(myController.getStudents(),courseName)+"\n"
                   +courseName+"最高分:"+scoreStatics.maxScore(myController.getStudents(),courseName)+"\n");

        }


        printScore.setText(text);
        //scoreStatics.printScore(myController.getStudents());
    }
    public void printStu()
    {
        String name=insert.getText();
        String  courseName;
        double courseScore;
        String text="";
        FindStudent findStudent=new FindStudent();
        Student student=findStudent.fromName(myController.getStudents(),name);
        int courseNumber=student.getScoreList().size();
        for(int i=0;i<courseNumber;i++){
            courseName=student.getScoreList().get(i).getCourseName();
            courseScore=student.getScoreList().get(i).getCourseScore();
            text+=(courseName+"分数:"+courseScore+"\n");
        }
        printScore.setText(text);

    }

    public void initialize(URL location, ResourceBundle resources) {
    }

    public void goToMain() {
        myController.setStage(Main.mainViewID,Main.StaViewID);
    }
}
