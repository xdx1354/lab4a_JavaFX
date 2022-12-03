module lab4a.lab4a_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens lab4a.lab4a_javafx to javafx.fxml;
    exports lab4a.lab4a_javafx;
}