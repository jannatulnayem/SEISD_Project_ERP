package com.example.seisd_pro;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.json.simple.JSONObject;

public class Course_Offer_View_Page_4_1_Controller {

    static Connection c1;
    static Statement s;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Code_Name_Credit_table> Course_table;

    @FXML
    private ChoiceBox<String> batch;

    @FXML
    private Button btn_show;

    @FXML
    private TableColumn<?, ?> col_courseCode;

    @FXML
    private TableColumn<?, ?> col_courseName;

    @FXML
    private TableColumn<?, ?> col_credit;

    @FXML
    private ChoiceBox<String> semester;

    @FXML
    void sBatch(MouseEvent event) {

    }

    @FXML
    void sSemester(MouseEvent event) {

    }

    @FXML
    void showTable(MouseEvent event) {

    }
    String offeredCourseJsonText;
    JSONObject CourseOFBatches_JsonObj;
    List<String> batches;
    @FXML
    void initialize() throws SQLException {
        this.c1 = jdbc.c1;
        this.s = jdbc.s;

        // Get info about the semester
        offeredCourseJsonText = utilities.getJsonText("SELECT * FROM `information` WHERE attribute ='courseOffer'");
        CourseOFBatches_JsonObj = utilities.getJsonObj(offeredCourseJsonText); //all course name of that batch
        batches = new ArrayList<String>(CourseOFBatches_JsonObj.keySet());
        for (int i =0; i<batches.size();i++){
            batch.getItems().add(batches.get(i));
        }


        col_courseCode.setCellValueFactory(new PropertyValueFactory<>("CourseCode"));
        col_courseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        col_credit.setCellValueFactory(new PropertyValueFactory<>("CourseCredit"));
        semester.getItems().add("All Time");
        semester.getItems().add("Current Semester");

    }

}
