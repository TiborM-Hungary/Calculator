module calculator {
    requires javafx.fxml;
    requires javafx.controls;

    opens controller;
    opens gui;
    opens session;

    //look up the module-info --> reason why it errors out
}