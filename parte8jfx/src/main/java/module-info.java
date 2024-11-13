module parte8jfx {
	exports br.ifrs.parte8jfx;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	
	opens br.ifrs.parte8jfx.controllers to javafx.fxml;
	opens br.ifrs.parte8jfx.models to javafx.base;
}