module parte9jfx {
	exports br.ifrs.parte9jfx;
	exports br.ifrs.parte9jfx.controllers;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	
	opens br.ifrs.parte9jfx.controllers to javafx.fxml;
	opens br.ifrs.parte9jfx.models to javafx.base;
}