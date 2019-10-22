package myPack;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;

public class Controller {

    @FXML
    TextField beg = new TextField();
    @FXML
    TextField end = new TextField();
    @FXML
    TextField ext = new TextField();
    private List<File> mySubs;

    public void addFiles() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Subtitles files (*.srt)", "*.srt"), new FileChooser.ExtensionFilter("Subtitles files (*.ass)", "*.ass"));
        mySubs = fileChooser.showOpenMultipleDialog(new Stage());
    }

    public void start() {
        if (JOptionPane.showConfirmDialog(null, "you sure you wanna proceed", "Renaming process", JOptionPane.YES_NO_OPTION) == 0) {
            try {
                for (int i = 0; i < mySubs.size(); i++) {
                    File tmp = mySubs.get(i);
                    tmp.renameTo(new File(tmp.getParent() + "/" + beg.getText() + new DecimalFormat("00").format((i + 1)) + end.getText() + "." + ext.getText()));
                    JOptionPane.showMessageDialog(null, "Done", "Succeded", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NullPointerException ignored) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }
}
