package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class TelaController {

    @FXML
    private Button btnOk;

    @FXML
    private Label lblMensagem;

    @FXML
    private TextField txtNome;

    @FXML
    void handleOk(ActionEvent event) {
    	String nome = this.txtNome.getText();
    	this.lblMensagem.setText("olá "+nome);
    }

}
