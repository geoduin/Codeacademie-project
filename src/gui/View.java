package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

//  Class to standardize every view that will sit inside the center of the base
//  layout in the GUI class
abstract class View {
    protected GUI gui;

    // associating the gui so that its methods can be used to set the center of the
    // base layout
    View(GUI gui) {
        this.gui = gui;
    }

    // Standard view-layout initiation method, because the same properties are often
    // used.
    protected GridPane generateGrid() {
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);

        grid.setHgap(40);
        grid.setVgap(10);

        return grid;
    }

    // Method responsible for the layout setup of the add and edit module view
    protected GridPane generateFormGrid() {
        GridPane grid = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();
        col1.setPercentWidth(17);
        col2.setPercentWidth(50);
        col3.setPercentWidth(18);

        grid.getColumnConstraints().addAll(col1, col2, col3);

        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25));
        grid.setVgap(20);
        grid.setHgap(30);

        return grid;

    }

    // Method to help checking if input is empty
    protected boolean hasNoInput(TextField field) {
        boolean hasNoInput = false;
        if (field.getText().trim().equals("")) {
            hasNoInput = true;
        }
        return hasNoInput;

    }

    // every view needs to create a parent type that can sit in the center of the
    // base layout
    protected abstract void createView();

    // method to add any type of view to the center of the main base layout + giving
    // the window a new title
    protected void activate(Parent view, String windowTitle) {
        this.gui.goToNext(view, windowTitle);
    }

}
