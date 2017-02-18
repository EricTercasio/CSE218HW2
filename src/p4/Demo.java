package p4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;


/**
 * Created by Eric on 2/18/2017.
 */
public class Demo extends Application{
    StudentBag studentBag = new StudentBag();
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea textArea = new TextArea("\t\t\t------------ Student Bag Contents -------------");
        Button addStudent = new Button("Add Student");
        Button deleteStudent = new Button("Delete Student");
        Button findByName = new Button("Find by name");
        Button selectionButton = new Button("Selection sort");
        VBox pane = new VBox();
        pane.getChildren().addAll(textArea,addStudent,deleteStudent,findByName,selectionButton);
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(20);
        Scene scene = new Scene(pane, 400,400);
        primaryStage.setScene(scene);

        addStudent.setOnAction(e->{
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Add new student");
            dialog.setTitle("Add new student");
            dialog.setContentText("Enter Students name : ");
            Optional<String> result = dialog.showAndWait();
            studentBag.add(new Student(result.get()));
            refreshTextArea(textArea);
        });
        deleteStudent.setOnAction(e->{
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Delete student");
            dialog.setTitle("Delete student");
            dialog.setContentText("Enter Students ID : ");
            Optional<String> result = dialog.showAndWait();
            studentBag.removeById(result.get());
            refreshTextArea(textArea);
        });
        findByName.setOnAction(e->{
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Find student");
            dialog.setTitle("Find student");
            dialog.setContentText("Enter Students ID : ");
            Optional<String> result = dialog.showAndWait();
            Alert dialog1 = new Alert(Alert.AlertType.INFORMATION);
            dialog1.setHeaderText("Student Information");
            dialog1.setTitle("Student Information");
            dialog1.setContentText("Student found : " + studentBag.findByName(result.get().toString()));
            dialog1.showAndWait();
        });
        selectionButton.setOnAction(e->{
            studentBag.selectionSort();
            refreshTextArea(textArea);
        });
        primaryStage.show();
    }
    public void refreshTextArea(TextArea textArea){
        textArea.setText("\t\t\t------------ Student Bag Contents -------------");
        for(int i = 0; i < studentBag.getnElems(); i++){
            textArea.appendText("\n\t\t\t\t    " +studentBag.getStudents()[i].toString());
        }
    }
}
