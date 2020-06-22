package SpaceMissionControl.Controllers;

import SpaceMissionControl.Mission;
import SpaceMissionControl.Program;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class MissionEkranController {

    private Program program;
    private Mission mission;

    @FXML
    private Button endButton;

    @FXML
    private javafx.scene.control.Label missionName;
    @FXML
    private javafx.scene.control.Label missionStatus;
    @FXML
    private javafx.scene.control.Label startDate;
    @FXML
    private javafx.scene.control.Label report;
    @FXML
    private javafx.scene.control.Label labelEnd;
    @FXML
    private javafx.scene.control.Label labelAbort;



    public MissionEkranController(){

    }

    @FXML
    private void onActionEndButton() throws IOException {
        if(mission != null) {
            FXMLLoader EkranZakonczeniaLoader = new FXMLLoader();

            EkranZakonczeniaLoader.setLocation(this.getClass().getResource("../fxml/EkranZakonczenia.fxml"));
            AnchorPane anchorPane = EkranZakonczeniaLoader.load();
            EkranZakonczeniaController ekranZakonczeniaController = EkranZakonczeniaLoader.getController();


            Scene scene = new Scene(anchorPane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            //missionEkranController.setProgram(program);
            ekranZakonczeniaController.setMission(mission);
        }
    }

    //public void setProgram(Program program){
    //    this.program = program;
    //}

    public void setMission(Mission mission){
        this.mission = mission;
        missionName.setText(mission.getMissionCode());
        missionStatus.setText(mission.getMissionStatus());
        startDate.setText(mission.getMissionDate().toString());
        report.setText(mission.toString());
    }

    @FXML
    void initialize(){

    }

    public void onMouseEnteredButtonEnd(){
        labelEnd.setOpacity(1);
    }

    public void onMouseExitedButtonEnd(){
        labelEnd.setOpacity(0);
    }

    public void onMouseEnteredButtonAbort(){
        labelAbort.setOpacity(1);
    }

    public void onMouseExitedButtonAbort(){
        labelAbort.setOpacity(0);
    }

}
