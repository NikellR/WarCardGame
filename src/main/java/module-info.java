module com.example.warcardgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.warcardgame to javafx.fxml;
    exports com.example.warcardgame;
}