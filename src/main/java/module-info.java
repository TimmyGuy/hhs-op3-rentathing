module com.example.hhsop3rentathing {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.hhsop3rentathing to javafx.fxml;
    exports com.example.hhsop3rentathing;
}