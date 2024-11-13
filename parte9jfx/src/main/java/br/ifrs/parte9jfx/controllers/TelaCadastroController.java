package br.ifrs.parte9jfx.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.ifrs.parte9jfx.Main;
import br.ifrs.parte9jfx.daos.IdeiaDAO;
import br.ifrs.parte9jfx.models.Ideia;
import br.ifrs.parte9jfx.models.Urgencia;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TelaCadastroController implements Initializable{

	@FXML
	private ComboBox<String> selUrgencia;

	@FXML
	private TextArea txtDescricao;

	@FXML
	private TextField txtTitulo;

	private Ideia ideia;

	@FXML
	void handleSalvar(ActionEvent event) {
		IdeiaDAO idao = new IdeiaDAO();
		
		if(this.isAlterar()) {
			//lógica alterar
			this.ideia.setDescricao(this.txtDescricao.getText());
    		this.ideia.setTitulo(this.txtTitulo.getText());
    		this.ideia.setUrgencia(Urgencia.fromString(this.selUrgencia.getValue()));
    		idao.alterar(this.ideia);
    	}else {
    		//lógica inserir
    		Ideia i = new Ideia(this.txtDescricao.getText(),
    							this.txtTitulo.getText(),
    							Urgencia.fromString(this.selUrgencia.getValue()));
    		idao.inserir(i);
    	}

		Main.loadView("TelaInicial");
	}

	@FXML
	void handleVoltar(ActionEvent event) {
		Main.loadView("TelaInicial");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		var lista = Stream.of(Urgencia.values())
				.map(urg -> urg.toString())
				.collect(Collectors.toList());
		
		this.selUrgencia.getItems().addAll(lista);
		Platform.runLater(()->verificaTelaEdicao());
		
	}
	
	private void verificaTelaEdicao() {
		this.ideia = Main.getAndRemoveData("ideiaSelecionada");
		if(this.isAlterar()) {
			this.txtTitulo.setText(this.ideia.getTitulo());
			this.txtDescricao.setText(this.ideia.getDescricao());
			this.selUrgencia.setValue(this.ideia.getUrgencia().toString());
		}
	}
	private boolean isAlterar() {
		return this.ideia!=null;
	}

}
