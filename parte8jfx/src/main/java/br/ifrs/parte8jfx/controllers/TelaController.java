package br.ifrs.parte8jfx.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.ifrs.parte8jfx.Main;
import br.ifrs.parte8jfx.daos.IdeiaDAO;
import br.ifrs.parte8jfx.models.Ideia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaController implements Initializable {

	private ObservableList<Ideia> ideias;
	@FXML
	private TableColumn<Ideia, Integer> clmId;

	@FXML
	private TableColumn<Ideia, String> clmTitulo;

	@FXML
	private TableView<Ideia> tblLista;

	private void carregaTable() {
		IdeiaDAO idao = new IdeiaDAO();
		this.ideias = FXCollections.observableArrayList(idao.listar(100, 0));
		this.tblLista.setItems(ideias);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.carregaTable();
		clmId.setCellValueFactory(new PropertyValueFactory<>("id"));
		clmTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
	}

	@FXML
	void handleAlterar(ActionEvent event) {
		Ideia selecionada = this.tblLista.getSelectionModel().getSelectedItem();
		if (selecionada != null) {
			IdeiaDAO idao = new IdeiaDAO();
			//logica alterar
			
		}else {
			avisoLinhaNaoSelecionada();
		}
	}

	@FXML
	void handleExcluir(ActionEvent event) {
		Ideia selecionada = this.tblLista.getSelectionModel().getSelectedItem();
		if (selecionada != null) {
			var alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setTitle("Excluir ideia");
			alerta.setHeaderText("Realmente deseja apagar a ideia");
			var res = alerta.showAndWait();
			
			if(res.get()==ButtonType.OK) {
				IdeiaDAO idao = new IdeiaDAO();
				idao.deletar(selecionada.getId());
				Main.loadView("TelaInicial");
			}
		
		}else {
			avisoLinhaNaoSelecionada();
		}
	}

	private void avisoLinhaNaoSelecionada() {
		var alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informação");
		alert.setHeaderText("Ideia não selecionada");
		alert.setContentText("Você deve selecionar uma ideia para completar a ação");;
		alert.show();
	}

	@FXML
	void handleNova(ActionEvent event) {
		System.out.println("inserir");
		Main.loadView("TelaCadastro");
	}
}
