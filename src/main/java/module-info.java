module ec.edu.espoch.queuesimplefx {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espoch.queuesimplefx to javafx.fxml;
    opens ec.edu.espoch.queuesimplefx.controller to javafx.fxml;
    exports ec.edu.espoch.queuesimplefx;
    exports ec.edu.espoch.queuesimplefx.controller;
    exports ec.edu.espoch.queuesimplefx.modelo;
    exports ec.edu.espoch.queuesimplefx.vistas;
}
