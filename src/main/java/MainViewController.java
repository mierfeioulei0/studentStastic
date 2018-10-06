import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by mierfeioulei0 on 2018/10/6.
 */
public class MainViewController implements ControlledStage, Initializable {
    public Label errLabel;

    StageController myController;

    public void setStageController(StageController stageController) {
        this.myController = stageController;
    }

    public void initialize(URL location, ResourceBundle resources) {
    }
    public void goToStaView(){
        myController.setStage(Main.StaViewID, Main.mainViewID);
    }
    public void goToMain() {
        myController.setStage(Main.mainViewID);
    }

    public void insertFromExcel() throws Exception {

        Stage fileStage = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel Files", "*.xls"));
        fileChooser.setTitle("选择Excel文件");
        File selectedFile = fileChooser.showOpenDialog(fileStage);


        ExcelProcessor excelProcessor = new ExcelProcessor();
        myController.setStudents(excelProcessor.excelToArray(selectedFile));
        //ScoreStatics scoreStatics=new ScoreStatics();
        // scoreStatics.printScore(studentArrayList);

       goToStaView();


    }

    public void error() {
        errLabel.setText("该功能暂未开放");

    }

    public void insertFromUI() {

    }

}
