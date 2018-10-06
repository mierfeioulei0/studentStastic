import javafx.application.Application;

import javafx.stage.Stage;


public class Main extends Application {

    public static String mainViewID = "MainView";
    public static String mainViewRes = "MainView.fxml";
    public static String StaViewID = "StaView";
    public static String StaViewRes = "StaView.fxml";
    private StageController stageController;


    @Override
    public void start(Stage primaryStage) throws Exception {
        //新建一个StageController控制器
        stageController = new StageController();
//将主舞台交给控制器处理
        stageController.setPrimaryStage("primaryStage", primaryStage);
//加载两个舞台，每个界面一个舞台
        stageController.loadStage(StaViewID, StaViewRes);
        stageController.loadStage(mainViewID, mainViewRes);
//显示MainView舞台
        stageController.setStage(mainViewID);
//        Parent root= FXMLLoader.load(getClass().getResource("MainView.fxml"));
//
//        Scene scene=new Scene(root);
//        primaryStage.setResizable(false);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
