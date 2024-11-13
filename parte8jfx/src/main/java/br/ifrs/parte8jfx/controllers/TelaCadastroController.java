package br.ifrs.parte8jfx.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.ifrs.parte8jfx.Main;
import br.ifrs.parte8jfx.daos.IdeiaDAO;
import br.ifrs.parte8jfx.models.Ideia;
import br.ifrs.parte8jfx.models.Urgencia;
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

	@FXML
	void handleSalvar(ActionEvent event) {
		IdeiaDAO idao = new IdeiaDAO();
		String desc = txtDescricao.getText();
		String titulo = txtTitulo.getText();
		String urg = selUrgencia.getValue();
		Ideia ideia = new Ideia(desc, titulo, Urgencia.valueOf(urg));
		
		idao.inserir(ideia);
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
		
	}

}
