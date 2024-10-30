package br.ifrs.parte7jfxmvn.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.ifrs.parte7jfxmvn.daos.IdeiaDAO;
import br.ifrs.parte7jfxmvn.models.Ideia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaController implements Initializable{
	
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

}
