package p3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

import static javafx.application.Application.launch;

/**
 * Created by Eric on 2/17/2017.
 */
public class Demo extends Application {
    private StudentBag studentBag;
    private TextField[] textFields;

    public static void main(String[] args){
            launch(args);

        }


        @Override
        public void start(Stage primaryStage) throws Exception {
            Button newButton = new Button("Size of bag");
            Button addStudent = new Button("Add one new student");
            Button addAllStudents = new Button("Add all students");
            Button findButton = new Button("Find Student");
            Button deleteButton = new Button("Delete Student");
            Button sortButton = new Button("Sort by name");
            VBox vBox = new VBox(25);
            vBox.getChildren().addAll(addStudent,newButton);
            vBox.setAlignment(Pos.CENTER);
            Scene scene = new Scene(vBox,500,500);
            primaryStage.setScene(scene);
            newButton.setOnAction(e ->{
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Bag Size");
                dialog.setContentText("Enter : ");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent() && result.get().matches("-?\\d+(\\.\\d+)?")){
                    studentBag = new StudentBag(Integer.valueOf(result.get()));
                    textFields = new TextField[Integer.valueOf(result.get())];
                    vBox.getChildren().remove(0,2);
                    for (int i = 0; i < Integer.valueOf(result.get()); i++){
                        TextField textField = new TextField();
                        textField.setMaxWidth(150);
                        textFields[i] = textField;
                        vBox.getChildren().add(textField);
                    }
                    vBox.getChildren().add(addAllStudents);

                }


            });
            addStudent.setOnAction(f ->{
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Bag Size");
                dialog.setContentText("Enter : ");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    studentBag.add(new Student(result.get()));


                }
            });
            addAllStudents.setOnAction(e->{
                TextArea textArea = new TextArea("\t\t\t\t\t\t-----------People Bag-----------");
                for (int i = 0; i < textFields.length; i++){
                    studentBag.add(new Student(textFields[i].getText()));
                    textArea.appendText("\n\t\t\t\t\t\t\t" + studentBag.findById(String.valueOf(i)).toString());
                }
                vBox.getChildren().clear();
                vBox.getChildren().add(textArea);
                vBox.getChildren().add(findButton);
                vBox.getChildren().add(deleteButton);
                vBox.getChildren().add(sortButton);


            });
            sortButton.setOnAction(e->{
                studentBag.selectionSort();
                TextArea textArea = new TextArea("\t\t\t\t\t\t-----------People Bag-----------");
                for (int i = 0; i < studentBag.getnElems(); i++){
                    textArea.appendText("\n\t\t\t\t\t\t\t" + studentBag.getStudents()[i].toString());
                }
                studentBag.display();
                vBox.getChildren().remove(0);
                vBox.getChildren().add(0,textArea);
            });
            findButton.setOnAction(e->{
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Student ID");
                dialog.setContentText("Enter : ");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent() && result.get().matches("-?\\d+(\\.\\d+)?")){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText(studentBag.findById(result.get()).getName());
                    alert.showAndWait();
                    }
                });
            deleteButton.setOnAction(e->{
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Student ID");
                dialog.setContentText("Enter : ");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent() && result.get().matches("-?\\d+(\\.\\d+)?")){
                    studentBag.removeById(result.get());
                    TextArea textArea = new TextArea("\t\t\t\t\t\t-----------People Bag-----------");
                    for (int i = 0; i < studentBag.getnElems(); i++){
                        textArea.appendText("\n\t\t\t\t\t\t\t" + studentBag.getStudents()[i].toString());
                    }
                    vBox.getChildren().remove(0);
                    vBox.getChildren().add(0,textArea);
                    }

            });

            primaryStage.show();


    }

}
