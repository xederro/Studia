package pl.edu.pwr.student.djablonski.GUI;

import pl.edu.pwr.student.djablonski.backend.Context.Context;
import pl.edu.pwr.student.djablonski.backend.Printer.GUIPrinter;
import pl.edu.pwr.student.djablonski.backend.Printer.GUIPrinterExecutioner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements GUIPrinterExecutioner {
    private GUIPrinter printer;
    private JPanel mainPanel;
    private JTextArea output;
    private JSlider COUNT_OF_PAINTERS;
    private JSlider COUNT_OF_SEGMENTS;
    private JSlider COUNT_OF_PLANKS_IN_SEGMENT;
    private JSlider COUNT_OF_PLANKS_PER_BUCKET;
    private JSlider DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS;
    private JSlider COUNT_OF_BUCKETS_IN_TANK;
    private JButton STARTButton;
    private JButton STOPButton;
    private JSlider DURATION_OF_WORKER_OPERATION;
    private JSlider DURATION_OF_FILLING_PAINT_CONTAINER;
    private JSlider DURATION_OF_FILLING_BUCKET;
    private JLabel COUNT_OF_PAINTERS_count;
    private JLabel COUNT_OF_SEGMENTS_count;
    private JLabel COUNT_OF_PLANKS_IN_SEGMENT_count;
    private JLabel COUNT_OF_BUCKETS_IN_TANK_count;
    private JLabel COUNT_OF_PLANKS_PER_BUCKET_count;
    private JLabel DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS_count;
    private JLabel DURATION_OF_WORKER_OPERATION_count;
    private JLabel DURATION_OF_FILLING_PAINT_CONTAINER_count;
    private JLabel DURATION_OF_FILLING_BUCKET_count;

    public Main() {
        STARTButton.addActionListener(e -> {
            Context.TimeBetweenPrints(10);
            printer = new GUIPrinter(Main.this);
            printer.start();
        });
        STOPButton.addActionListener(e -> printer.end());
        COUNT_OF_PAINTERS.addChangeListener(e -> {
            Context.CountOfPainters(((JSlider) e.getSource()).getValue());
            COUNT_OF_PAINTERS_count.setText(String.valueOf(((JSlider) e.getSource()).getValue()));
        });
        COUNT_OF_SEGMENTS.addChangeListener(e -> {
            Context.CountOfSegments(((JSlider) e.getSource()).getValue());
            COUNT_OF_SEGMENTS_count.setText(String.valueOf(((JSlider) e.getSource()).getValue()));
        });
        COUNT_OF_PLANKS_IN_SEGMENT.addChangeListener(e -> {
            Context.CountOfPlanksInSegment(((JSlider) e.getSource()).getValue());
            COUNT_OF_PLANKS_IN_SEGMENT_count.setText(String.valueOf(((JSlider) e.getSource()).getValue()));
        });
        COUNT_OF_PLANKS_PER_BUCKET.addChangeListener(e -> {
            Context.CountOfPlanksPerBucket(((JSlider) e.getSource()).getValue());
            COUNT_OF_PLANKS_PER_BUCKET_count.setText(String.valueOf(((JSlider) e.getSource()).getValue()));
        });
        COUNT_OF_BUCKETS_IN_TANK.addChangeListener(e -> {
            Context.CountOfBucketsInTank(((JSlider) e.getSource()).getValue());
            COUNT_OF_BUCKETS_IN_TANK_count.setText(String.valueOf(((JSlider) e.getSource()).getValue()));
        });
        DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS.addChangeListener(e -> {
            Context.DistanceBetweenPaintproducerAndPainters(((JSlider) e.getSource()).getValue());
            DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS_count.setText(((JSlider) e.getSource()).getValue() + "km");
        });
        DURATION_OF_WORKER_OPERATION.addChangeListener(e -> {
            Context.DurationOfWorkerOperation(((JSlider) e.getSource()).getValue());
            DURATION_OF_WORKER_OPERATION_count.setText(((JSlider) e.getSource()).getValue() + "ms");
        });
        DURATION_OF_FILLING_PAINT_CONTAINER.addChangeListener(e -> {
            Context.DurationOfFillingPaintContainer(((JSlider) e.getSource()).getValue());
            DURATION_OF_FILLING_PAINT_CONTAINER_count.setText(((JSlider) e.getSource()).getValue() + "ms");
        });
        DURATION_OF_FILLING_BUCKET.addChangeListener(e -> {
            Context.DurationOfFillingBucket(((JSlider) e.getSource()).getValue());
            DURATION_OF_FILLING_BUCKET_count.setText(((JSlider) e.getSource()).getValue() + "ms");
        });
    }

    @Override
    public void onStart() {
        setEnable(false);
    }

    @Override
    public void onEnd() {
        setEnable(true);
        System.gc();
    }

    @Override
    public void onPrint(String s) {
        output.setText(s);
    }

    public void setEnable(boolean state) {
        COUNT_OF_PAINTERS.setEnabled(state);
        COUNT_OF_SEGMENTS.setEnabled(state);
        COUNT_OF_PLANKS_IN_SEGMENT.setEnabled(state);
        COUNT_OF_PLANKS_PER_BUCKET.setEnabled(state);
        DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS.setEnabled(state);
        COUNT_OF_BUCKETS_IN_TANK.setEnabled(state);
        DURATION_OF_WORKER_OPERATION.setEnabled(state);
        DURATION_OF_FILLING_PAINT_CONTAINER.setEnabled(state);
        DURATION_OF_FILLING_BUCKET.setEnabled(state);
        STARTButton.setEnabled(state);
        STOPButton.setEnabled(!state);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simulation");
        frame.setContentPane(new Main().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(9, 3, new Insets(10, 10, 5, 10), -1, -1));
        mainPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Number of paintable Planks per Bucker");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        COUNT_OF_PLANKS_PER_BUCKET = new JSlider();
        COUNT_OF_PLANKS_PER_BUCKET.setMajorTickSpacing(1);
        COUNT_OF_PLANKS_PER_BUCKET.setMinimum(1);
        COUNT_OF_PLANKS_PER_BUCKET.setMinorTickSpacing(1);
        COUNT_OF_PLANKS_PER_BUCKET.setValue(4);
        panel1.add(COUNT_OF_PLANKS_PER_BUCKET, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        COUNT_OF_BUCKETS_IN_TANK = new JSlider();
        COUNT_OF_BUCKETS_IN_TANK.setMajorTickSpacing(1);
        COUNT_OF_BUCKETS_IN_TANK.setMinimum(1);
        COUNT_OF_BUCKETS_IN_TANK.setMinorTickSpacing(1);
        COUNT_OF_BUCKETS_IN_TANK.setValue(4);
        panel1.add(COUNT_OF_BUCKETS_IN_TANK, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Number of fillable Buckets in Container");
        panel1.add(label2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Number of Painters");
        panel1.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        COUNT_OF_PAINTERS = new JSlider();
        COUNT_OF_PAINTERS.setMajorTickSpacing(1);
        COUNT_OF_PAINTERS.setMaximum(25);
        COUNT_OF_PAINTERS.setMinimum(1);
        COUNT_OF_PAINTERS.setMinorTickSpacing(1);
        COUNT_OF_PAINTERS.setValue(5);
        panel1.add(COUNT_OF_PAINTERS, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Distance from Paint Producer");
        panel1.add(label4, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS = new JSlider();
        DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS.setMajorTickSpacing(1);
        DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS.setMinimum(1);
        DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS.setMinorTickSpacing(1);
        DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS.setValue(4);
        panel1.add(DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Number of Segments in Fance");
        panel1.add(label5, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        COUNT_OF_SEGMENTS = new JSlider();
        COUNT_OF_SEGMENTS.setMajorTickSpacing(1);
        COUNT_OF_SEGMENTS.setMinimum(1);
        COUNT_OF_SEGMENTS.setMinorTickSpacing(1);
        COUNT_OF_SEGMENTS.setValue(5);
        panel1.add(COUNT_OF_SEGMENTS, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Number of Planks in Segment");
        panel1.add(label6, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        COUNT_OF_PLANKS_IN_SEGMENT = new JSlider();
        COUNT_OF_PLANKS_IN_SEGMENT.setMajorTickSpacing(1);
        COUNT_OF_PLANKS_IN_SEGMENT.setMinimum(1);
        COUNT_OF_PLANKS_IN_SEGMENT.setMinorTickSpacing(1);
        COUNT_OF_PLANKS_IN_SEGMENT.setValue(6);
        panel1.add(COUNT_OF_PLANKS_IN_SEGMENT, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Time between Worker operation");
        panel1.add(label7, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DURATION_OF_WORKER_OPERATION = new JSlider();
        DURATION_OF_WORKER_OPERATION.setMajorTickSpacing(1);
        DURATION_OF_WORKER_OPERATION.setMaximum(5000);
        DURATION_OF_WORKER_OPERATION.setMinimum(500);
        DURATION_OF_WORKER_OPERATION.setMinorTickSpacing(1);
        DURATION_OF_WORKER_OPERATION.setValue(1000);
        panel1.add(DURATION_OF_WORKER_OPERATION, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Duration of filling Paint Container");
        panel1.add(label8, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DURATION_OF_FILLING_PAINT_CONTAINER = new JSlider();
        DURATION_OF_FILLING_PAINT_CONTAINER.setMajorTickSpacing(1);
        DURATION_OF_FILLING_PAINT_CONTAINER.setMaximum(20000);
        DURATION_OF_FILLING_PAINT_CONTAINER.setMinimum(500);
        DURATION_OF_FILLING_PAINT_CONTAINER.setMinorTickSpacing(1);
        DURATION_OF_FILLING_PAINT_CONTAINER.setValue(8000);
        panel1.add(DURATION_OF_FILLING_PAINT_CONTAINER, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Duration of filling Bucket");
        panel1.add(label9, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(151, 21), null, 0, false));
        DURATION_OF_FILLING_BUCKET = new JSlider();
        DURATION_OF_FILLING_BUCKET.setMajorTickSpacing(1);
        DURATION_OF_FILLING_BUCKET.setMaximum(10000);
        DURATION_OF_FILLING_BUCKET.setMinimum(500);
        DURATION_OF_FILLING_BUCKET.setMinorTickSpacing(1);
        DURATION_OF_FILLING_BUCKET.setValue(4000);
        panel1.add(DURATION_OF_FILLING_BUCKET, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 21), null, 0, false));
        DURATION_OF_FILLING_BUCKET_count = new JLabel();
        DURATION_OF_FILLING_BUCKET_count.setText("4000ms");
        panel1.add(DURATION_OF_FILLING_BUCKET_count, new com.intellij.uiDesigner.core.GridConstraints(8, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(51, 21), null, 0, false));
        DURATION_OF_FILLING_PAINT_CONTAINER_count = new JLabel();
        DURATION_OF_FILLING_PAINT_CONTAINER_count.setText("8000ms");
        panel1.add(DURATION_OF_FILLING_PAINT_CONTAINER_count, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DURATION_OF_WORKER_OPERATION_count = new JLabel();
        DURATION_OF_WORKER_OPERATION_count.setText("1000ms");
        panel1.add(DURATION_OF_WORKER_OPERATION_count, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS_count = new JLabel();
        DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS_count.setText("4km");
        panel1.add(DISTANCE_BETWEEN_PAINTPRODUCER_AND_PAINTERS_count, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        COUNT_OF_PLANKS_PER_BUCKET_count = new JLabel();
        COUNT_OF_PLANKS_PER_BUCKET_count.setText("4");
        panel1.add(COUNT_OF_PLANKS_PER_BUCKET_count, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        COUNT_OF_BUCKETS_IN_TANK_count = new JLabel();
        COUNT_OF_BUCKETS_IN_TANK_count.setText("4");
        panel1.add(COUNT_OF_BUCKETS_IN_TANK_count, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        COUNT_OF_PLANKS_IN_SEGMENT_count = new JLabel();
        COUNT_OF_PLANKS_IN_SEGMENT_count.setText("6");
        panel1.add(COUNT_OF_PLANKS_IN_SEGMENT_count, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        COUNT_OF_SEGMENTS_count = new JLabel();
        COUNT_OF_SEGMENTS_count.setText("5");
        panel1.add(COUNT_OF_SEGMENTS_count, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        COUNT_OF_PAINTERS_count = new JLabel();
        COUNT_OF_PAINTERS_count.setText("5");
        panel1.add(COUNT_OF_PAINTERS_count, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(5, 10, 10, 10), -1, -1));
        mainPanel.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        STARTButton = new JButton();
        STARTButton.setText("START");
        panel2.add(STARTButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        STOPButton = new JButton();
        STOPButton.setEnabled(false);
        STOPButton.setText("STOP");
        panel2.add(STOPButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(5, 10, 5, 10), -1, -1));
        mainPanel.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(350, 150), new Dimension(350, 150), null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel3.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(350, 150), new Dimension(350, 150), null, 0, false));
        output = new JTextArea();
        output.setEditable(false);
        output.setLineWrap(true);
        output.setText("");
        scrollPane1.setViewportView(output);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
