/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.queuesimplefx.controller;

import ec.edu.espoch.queuesimplefx.modelo.QueueSimple;
import ec.edu.espoch.queuesimplefx.vistas.QueueCanvas;
import java.util.NoSuchElementException;
import java.util.Queue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Admin
 */
public class QueueController {

    @FXML
    private TextField txtValues;

    @FXML
    private StackPane canvasHolder;

    private QueueCanvas canvas;
    private final QueueSimple queue = new QueueSimple();

    @FXML
    private void initialize() {
        canvas = new QueueCanvas();
        canvasHolder.getChildren().add(canvas);

        canvas.clearHighlight();
        refreshView();
    }

    @FXML
    private void enqueue() {
        Integer v = readInt();
        if (v == null) {
            return;
        }

        queue.enqueue(v);
        canvas.clearHighlight();
        canvas.render();

        txtValues.selectAll();
        txtValues.requestFocus();
        refreshView();
    }

    @FXML
    private void dequeue() {
        try {
            int removed = queue.dequeue();
            refreshView();
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void peek() {
        try {
            int frontValue = queue.peek();
            System.out.println("Peek → " + frontValue);
            canvas.clearHighlight();
            refreshView();
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void isEmptyQueue() {
        boolean empty = queue.isEmpty();

        if (empty) {
            System.out.println("La cola está vacía");
        } else {
            System.out.println("La cola no está vacía");
        }
    }

    private Integer readInt() {
        try {
            String s = (txtValues.getText() == null)
                    ? ""
                    : txtValues.getText().trim();

            if (s.isEmpty()) {
                return null;
            }
            return Integer.valueOf(s);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private void refreshView() {
        canvas.setValues(queue.toList());
        canvas.render();
    }

}
