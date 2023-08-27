module com.example.equations {

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    //requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires junit;
    requires java.sql;
    requires java.scripting;
    requires MathParser.org.mXparser;

    opens com.example.equations to javafx.fxml;
    exports com.example.equations;
}