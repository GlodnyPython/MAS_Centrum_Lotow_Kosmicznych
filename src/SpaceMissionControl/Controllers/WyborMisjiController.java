package SpaceMissionControl.Controllers;

import SpaceMissionControl.Mission;
import SpaceMissionControl.Program;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.PrimitiveIterator;

public class WyborMisjiController {

    public Program program;

    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private ComboBox comboBox;


    private ObservableList<Mission> missions = FXCollections.observableArrayList();

    public Mission pickedMission;



    public WyborMisjiController(){

    }

    public void setProgram(Program program){
        this.program = program;

        for (Mission m : program.missionMap.values() ){
            missions.addAll(m);
        }
    }

    @FXML
    void initialize(){
        this.comboBox.setItems(missions);

    }

    @FXML
    public void onActionButton() throws Exception {
        if(pickedMission != null) {
            FXMLLoader missionEkranLoader = new FXMLLoader();

            missionEkranLoader.setLocation(this.getClass().getResource("../fxml/MissionEkran.fxml"));
            StackPane stackPaneNew = missionEkranLoader.load();
            MissionEkranController missionEkranController = missionEkranLoader.getController();


            Scene scene = new Scene(stackPaneNew);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            //missionEkranController.setProgram(program);
            missionEkranController.setMission(pickedMission);
        }
    }

    public void onMouseEnteredButton(){
        label.setOpacity(1);
    }

    public void onMouseExitedButton(){
        label.setOpacity(0);
    }

    public void onActionComboBox(){
        pickedMission = missions.get(this.comboBox.getSelectionModel().getSelectedIndex());

    }

    public void missionWindow(Program program, Mission mission) throws Exception {






    }

}
