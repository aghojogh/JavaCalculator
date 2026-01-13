import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class RetailPriceCalculator extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        // create label and text field for wholesale:
        Label wholesaleLabel = new Label("Enter wholesale cost:");
        TextField wholesaleTextField = new TextField();

        // create label and text field for markup:
        Label markupLabel = new Label("Enter markup percentage:");
        TextField markupTextField = new TextField();
        
        // button:
        Button calculateButton = new Button("Calculate retail price");

        // label for result of calculation (retail price):
        Label resultLabel = new Label();

        // event handling for the button:
        calculateButton.setOnAction(e -> {
            try{
                // read the entered numbers:
                double wholesaleCost = Double.parseDouble(wholesaleTextField.getText());
                double markupPercentage = Double.parseDouble(markupTextField.getText());

                // calculate the retail price:
                double retailPrice = wholesaleCost * (1 + (markupPercentage / 100));
                resultLabel.setText(String.format("Retail Price: $%.2f", retailPrice));
            }
            catch(NumberFormatException ex){
                resultLabel.setText("Please enter valid numbers.");
            }
        });

        // layout of the wholesale:
        VBox box = new VBox(5, wholesaleLabel, wholesaleTextField, markupLabel, markupTextField, calculateButton, resultLabel);
        
        // padding (gap) around the box:
        box.setStyle("-fx-padding: 15px;");

        // add extra space above the button:
        VBox.setMargin(calculateButton, new Insets(20, 0, 0, 0));

        // scene (and size of window):
        Scene scene = new Scene(box, 300, 200);

        // title of window:
        stage.setTitle("Retail Price Calculator");

        // icon of window:
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));

        // set scene for the stage:
        stage.setScene(scene);

        // show the stage:
        stage.show();
    }
}
