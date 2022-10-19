module me.divkix.assignment7 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens me.divkix.assignment7 to javafx.fxml;
    exports me.divkix.assignment7;
}