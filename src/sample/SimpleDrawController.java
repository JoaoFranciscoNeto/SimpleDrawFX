package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by João on 04/04/2016.
 */
public class SimpleDrawController implements Initializable {

    // FXML Vars
    @FXML private Canvas MainCanvas, EffectCanvas;
    @FXML private ColorPicker ColorPick;

    GraphicsContext gcM, gcE;

    private enum Tool {
        RECT,
        CIRC,
        LINE
    }

    private Tool toolSelected = Tool.RECT;

    double startX, startY, lastX, lastY, oldX, oldY;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gcM = MainCanvas.getGraphicsContext2D();
        gcE = EffectCanvas.getGraphicsContext2D();
    }

    // Button Actions
    @FXML
    private void setRectTool(ActionEvent e) {
        toolSelected = Tool.RECT;
    }

    @FXML
    private void setCircTool(ActionEvent e) {
        toolSelected = Tool.CIRC;
    }

    @FXML
    private void setLineTool(ActionEvent e) {
        toolSelected = Tool.LINE;
    }

    // Canvas Actions
    @FXML
    private void onMousePressedListener(MouseEvent e) {
        this.startX = e.getX();
        this.startY = e.getY();
        this.oldX = e.getX();
        this.oldY = e.getY();
    }

    @FXML
    private void onMouseDraggedListener(MouseEvent e) {
        this.lastX = e.getX();
        this.lastY = e.getY();
        switch (toolSelected) {
            case RECT:
                drawRectEffect();
        }
    }


    // Drawing Effects

    private void drawRectEffect() {
        double wh = lastX - startX;
        double hg = lastY - startY;

        gcE.clearRect(0, 0, EffectCanvas.getWidth(), EffectCanvas.getHeight());
        gcE.setStroke(ColorPick.getValue());
        gcE.strokeRect(startX, startY, wh, hg );
    }

}
