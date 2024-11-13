package br.ifrs.parte8jfx;
	
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
		loadView("TelaInicial");
	}

	public static void loadView(String view) {
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
