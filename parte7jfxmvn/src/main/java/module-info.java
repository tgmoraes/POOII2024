module br.ifrs.edu.parte7jfxmvn {
	exports br.ifrs.parte7jfxmvn;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	
	opens br.ifrs.parte7jfxmvn.controllers to javafx.fxml;
	opens br.ifrs.parte7jfxmvn.models to javafx.base;
}