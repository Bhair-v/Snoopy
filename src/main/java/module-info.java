module com.example.group65_ms3version1_flighttrainingacademy_2221902_2321051_1810611_2220678 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.group65_ms3version1_flighttrainingacademy_2221902_2321051_1810611_2220678 to javafx.fxml;
    opens com.example.group65_ms3version1_flighttrainingacademy_2221902_2321051_1810611_2220678.FinanceAndEnrollmentOfficer to javafx.fxml;
    opens com.example.group65_ms3version1_flighttrainingacademy_2221902_2321051_1810611_2220678.TrainingRecordsOfficer to javafx.fxml;
    exports com.example.group65_ms3version1_flighttrainingacademy_2221902_2321051_1810611_2220678;
    exports com.example.group65_ms3version1_flighttrainingacademy_2221902_2321051_1810611_2220678.FinanceAndEnrollmentOfficer;
    exports com.example.group65_ms3version1_flighttrainingacademy_2221902_2321051_1810611_2220678.TrainingRecordsOfficer;
}