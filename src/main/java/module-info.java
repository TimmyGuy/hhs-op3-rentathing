module com.example.hhsop3rentathing {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;
    requires javafx.base;

    opens com.example.hhsop3rentathing to javafx.fxml;
    opens com.example.hhsop3rentathing.products to javafx.base;
    exports com.example.hhsop3rentathing;
    exports com.example.hhsop3rentathing.products;
}