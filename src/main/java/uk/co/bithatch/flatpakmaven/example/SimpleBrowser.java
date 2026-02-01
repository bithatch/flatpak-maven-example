package uk.co.bithatch.flatpakmaven.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class SimpleBrowser extends Application {

    @SuppressWarnings("unused")
	@Override
    public void start(Stage stage) {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        TextField addressBar = new TextField("https://www.google.com");
        Button backBtn = new Button("<");
        Button forwardBtn = new Button(">");
        Button goBtn = new Button("Go");

        // Logic for buttons
        backBtn.setOnAction(e -> { if (engine.getHistory().getCurrentIndex() > 0) engine.getHistory().go(-1); });
        forwardBtn.setOnAction(e -> { if (engine.getHistory().getCurrentIndex() < engine.getHistory().getEntries().size() - 1) engine.getHistory().go(1); });
        goBtn.setOnAction(e -> engine.load(addressBar.getText()));
        addressBar.setOnAction(e -> engine.load(addressBar.getText()));

        // Layout
        HBox toolBar = new HBox(5, backBtn, forwardBtn, addressBar, goBtn);
        HBox.setHgrow(addressBar, Priority.ALWAYS);
        
        VBox root = new VBox(toolBar, webView);
        VBox.setVgrow(webView, Priority.ALWAYS);

        engine.load(addressBar.getText());

        stage.setTitle("Flatpak JavaFX Browser");
        stage.setScene(new Scene(root, 1024, 768));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}