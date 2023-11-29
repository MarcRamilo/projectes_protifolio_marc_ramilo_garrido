module com.mycompany.snabbite {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    
    opens com.mycompany.snabbite to javafx.fxml;
    exports com.mycompany.snabbite;
}
