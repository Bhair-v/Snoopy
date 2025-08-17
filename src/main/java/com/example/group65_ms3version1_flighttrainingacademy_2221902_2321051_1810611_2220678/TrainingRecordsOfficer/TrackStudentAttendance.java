package com.example.cse213_finalproject_group65_flighttrainingacademy.TrainingRecordsOfficer;

import com.example.cse213_finalproject_group65_flighttrainingacademy.FinanceAndEnrollmentOfficer.Model.Reminder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class TrackStudentAttendance {

    @FXML private TableView<Reminder> table;
    @FXML private TableColumn<Reminder, Integer> colId;
    @FXML private TableColumn<Reminder, String>  colName;
    @FXML private TableColumn<Reminder, String>  colEmail;
    @FXML private TableColumn<Reminder, Double>  colAmount;
    @FXML private TableColumn<Reminder, Double>  colPaid;
    @FXML private TableColumn<Reminder, Double>  colDue;
    @FXML private Label statusLabel;

    private final ObservableList<Reminder> data = FXCollections.observableArrayList();
    private final DecimalFormat money = new DecimalFormat("#,##0.00");

    // ---------- Dummy data (no file I/O) ----------
    private static final List<Student> STUDENTS = List.of(
            new Student(1001, "Ayesha Karim",  "ayesha@example.com"),
            new Student(1002, "Tanvir Ahmed",  "tanvir@example.com"),
            new Student(1003, "Shafin Rahman", "shafin@example.com"),
            new Student(1004, "Mithila Noor",  "mithila@example.com"),
            new Student(1005, "Arif Hasan",    "arif@example.com")
    );

    private static final List<Invoice> INVOICES = new ArrayList<>(List.of(
            new Invoice(2001, 1001, 15000.00,  5000.00), // due 10,000
            new Invoice(2002, 1002,  8000.00,     0.00), // due 8,000
            new Invoice(2003, 1003, 12000.00, 12000.00), // paid
            new Invoice(2004, 1004,  9000.00,  1000.00), // due 8,000
            new Invoice(2005, 1005,  7000.00,  7000.00)  // paid
    ));

    @FXML
    public void initialize() {
        // Table column bindings -> Reminder getters
        colId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colPaid.setCellValueFactory(new PropertyValueFactory<>("paid"));
        colDue.setCellValueFactory(new PropertyValueFactory<>("due"));

        table.setItems(data);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        statusLabel.setText("Ready");
    }

    @FXML
    private void onLoadOverdue() {
        Map<Integer, Student> byId = STUDENTS.stream()
                .collect(Collectors.toMap(s -> s.id, s -> s));

        data.clear();
        for (Invoice inv : INVOICES) {
            double due = inv.amount - inv.paid;
            if (due > 0.000001) {
                Student s = byId.get(inv.studentId);
                if (s != null) {
                    data.add(new Reminder(s.id, s.name, s.email, inv.amount, inv.paid, due));
                }
            }
        }

        double totalDue = data.stream().mapToDouble(Reminder::getDue).sum();
        statusLabel.setText("Overdue: " + data.size() + " student(s), total due " + money.format(totalDue));
    }

    @FXML
    private void onSendReminders() {
        List<Reminder> targets = table.getSelectionModel().getSelectedItems();
        if (targets == null || targets.isEmpty()) {
            targets = new ArrayList<>(data); // if none selected, send to all displayed
        }

        if (targets.isEmpty()) {
            info("Reminders", "No overdue students to remind.");
            statusLabel.setText("No recipients.");
            return;
        }

        String lines = targets.stream()
                .map(Reminder::toLine)
                .collect(Collectors.joining("\n"));

        info("Reminders sent",
                "Reminders sent to " + targets.size() + " recipient(s):\n\n" + lines);

        statusLabel.setText("Reminders sent to " + targets.size());
    }

    private void info(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        a.showAndWait();
    }

    // ---------- Local dummy DTOs (kept inside controller) ----------
    private static class Student {
        final int id; final String name; final String email;
        Student(int id, String name, String email) { this.id = id; this.name = name; this.email = email; }
    }

    private static class Invoice {
        final long id; final int studentId; final double amount; final double paid;
        Invoice(long id, int studentId, double amount, double paid) {
            this.id = id; this.studentId = studentId; this.amount = amount; this.paid = paid;
        }
    }
}
