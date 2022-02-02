module Sombiev3 {
	requires javafx.controls;
	requires json.simple;
	requires org.apache.commons.io;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	opens application to javafx.graphics, javafx.fxml;
}
