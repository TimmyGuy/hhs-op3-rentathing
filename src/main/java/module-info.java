module com.example.hhsop3rentathing {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.hhsop3rentathing to javafx.fxml;
    opens com.example.hhsop3rentathing.products to javafx.base;
    exports com.example.hhsop3rentathing;
}