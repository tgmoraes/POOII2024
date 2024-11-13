package br.ifrs.parte9jfx;
	
import java.util.HashMap;

import br.ifrs.parte9jfx.models.Ideia;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage stage;
		
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		HashMap<String, Object> dados = new HashMap<>();
        stage.setUserData(dados);
        
		loadView("TelaInicial");
	}

	
	public static void main(String[] args) {
		launch(args);
	}

	
	//abre view passando dados a salvar
	public static <V> void loadView(String view) {
		String tela = "/views/"+view+".fxml";
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(Main.class.getResource(tela));
			Scene scene = new Scene(root,600,400);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static <V> void addData(String key, V value) {
		if(value!=null && key!=null) {
			@SuppressWarnings("unchecked")
			var data = (HashMap<String,Object>)stage.getUserData();
			data.put(key, value);
		}
	}
	@SuppressWarnings("unchecked")
	public static <V> V getData(String key) {
		var data = (HashMap<String,Object>)stage.getUserData();
		return (V) data.get(key);
	}
	public static <V> V getAndRemoveData(String key) {
		var data = (HashMap<String,Object>)stage.getUserData();
		return (V) data.remove(key);
	}

}
