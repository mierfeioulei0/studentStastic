
import cn.von.vo.Score;
import cn.von.vo.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by mierfeioulei0 on 2018/10/6.
 */
public class InsertViewController implements ControlledStage, Initializable {
    public TableColumn id;
    public TableColumn name;
    public TableColumn courseOne;
    public TableColumn courseTwo;
    public TableColumn courseThree;
    public TableView tableViewScore;
    public TableView tableViewStudent;
    public TableView Score3;
    public TableView Score2;
    StageController myController;

    public void setStageController(StageController stageController) {
        this.myController = stageController;
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

    public void insertSample() throws Exception {
       // courseOne.setCellFactory(TextFieldTableCell.forTableColumn());
        Stage fileStage = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel Files", "*.xls"));
        fileChooser.setTitle("选择Excel文件");
        File selectedFile = fileChooser.showOpenDialog(fileStage);
        ExcelProcessor excelProcessor = new ExcelProcessor();
        myController.setStudents(excelProcessor.excelToArray(selectedFile));
        ObservableList<Student> list = FXCollections.observableArrayList();
        ObservableList<Score> list1 = FXCollections.observableArrayList();
        ObservableList<Score> list2 = FXCollections.observableArrayList();
        ObservableList<Score> list3 = FXCollections.observableArrayList();
        /**
         * 映射
         */

        id.setCellValueFactory(new PropertyValueFactory("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        courseOne.setCellValueFactory(new PropertyValueFactory("courseScore"));
        courseTwo.setCellValueFactory(new PropertyValueFactory("courseScore"));
        courseThree.setCellValueFactory(new PropertyValueFactory("courseScore"));
        /**
         * list添加值对象
         */

        courseOne.setText(myController.getStudents().get(0).getScoreList().get(0).getCourseName());
        courseTwo.setText(myController.getStudents().get(0).getScoreList().get(1).getCourseName());
        courseThree.setText(myController.getStudents().get(0).getScoreList().get(2).getCourseName());
        for (int i = 0; i < myController.getStudents().size(); i++) {
            list.add(myController.getStudents().get(i));
            list1.add(myController.getStudents().get(i).getScoreList().get(0));
            list2.add(myController.getStudents().get(i).getScoreList().get(1));
            list3.add(myController.getStudents().get(i).getScoreList().get(2));
        }

        /**
         * tableview添加list
         */

        tableViewStudent.setItems(list);
        tableViewScore.setItems(list1);
        Score2.setItems(list2);
        Score3.setItems(list3);
    }

    public void goToMain() {
        myController.setStage(Main.mainViewID, Main.InsertViewID);
    }
}
