package pl.edu.pwr.student.djablonski.kierownik.GUI;

import pl.edu.pwr.student.djablonski.database.data.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.edu.pwr.student.djablonski.database.context.Context;

public class Zlecenia extends JPanel {
    private JTable zleceniaTable;
    private JTable kontrolerTable;
    private JButton sendButton;
    private JPanel main;
    private JButton decisionButton;
    private JTable opiniaTable;
    private JButton szczegolyKontrolaButton;
    private JButton szczegolyDecyzjaButton;
    private JButton usunKontrolaButton;
    private JButton usunDecyzjaButton;
    private Kierownik kier;

    public Zlecenia(Kierownik kier) {
        $$$setupUI$$$();

        this.kier = kier;
        try {
            List<Zgloszenie> zgloszenia = Context.daoZgloszenie.readAllBy("status", Status.zlozone);
            List<Zgloszenie> decyzje = Context.daoZgloszenie.readAllBy("status", Status.oczekujace);
            List<Kontroler> kontrolerzy = Context.daoKontroler.readAll();
            DefaultTableModel tmz = (DefaultTableModel) zleceniaTable.getModel();
            DefaultTableModel tmk = (DefaultTableModel) kontrolerTable.getModel();
            DefaultTableModel tmo = (DefaultTableModel) opiniaTable.getModel();

            for (Zgloszenie z : zgloszenia) {
                tmz.addRow(z.toTableRow());
            }

            for (Zgloszenie z : decyzje) {
                tmo.addRow(z.toTableRow());
            }

            for (Kontroler k : kontrolerzy) {
                tmk.addRow(k.toTableRow());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, Object> toChange = new HashMap<>();
                toChange.put("id_kontrolera", kontrolerTable.getValueAt(kontrolerTable.getSelectedRow(), 0));
                toChange.put("status", Status.przyjete);

                DefaultTableModel tmz = (DefaultTableModel) zleceniaTable.getModel();

                for (int i = zleceniaTable.getSelectedRows().length - 1; i >= 0; i--) {
                    if (zleceniaTable.getValueAt(zleceniaTable.getSelectedRows()[i], 1).equals(Status.zlozone)) {
                        int zid = (Integer) zleceniaTable.getValueAt(zleceniaTable.getSelectedRows()[i], 0);
                        try {
                            Context.daoZgloszenie.update(toChange, zid);
                            tmz.setValueAt(Status.przyjete, zleceniaTable.getSelectedRows()[i], 1);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
        decisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tmo = (DefaultTableModel) opiniaTable.getModel();
                if (opiniaTable.getValueAt(opiniaTable.getSelectedRow(), 1).equals(Status.oczekujace)) {
                    try {
                        Opinia.start(
                                kier.id(),
                                Context.daoRaport.readAllBy("id_zgloszenia", opiniaTable.getValueAt(opiniaTable.getSelectedRow(), 0)),
                                tmo,
                                opiniaTable.getSelectedRow()
                        );
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        szczegolyKontrolaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (zleceniaTable.getSelectedRow() != -1) {
                    Drzewa.start((Integer) zleceniaTable.getValueAt(zleceniaTable.getSelectedRow(), 0));
                }
            }
        });
        usunKontrolaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tmzg = (DefaultTableModel) zleceniaTable.getModel();
                for (int i = zleceniaTable.getSelectedRows().length - 1; i >= 0; i--) {
                    try {
                        Context.daoZgloszenie.delete((Integer) zleceniaTable.getValueAt(zleceniaTable.getSelectedRows()[i], 0));
                        tmzg.removeRow(zleceniaTable.getSelectedRows()[i]);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        szczegolyDecyzjaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (opiniaTable.getSelectedRow() != -1) {
                    Drzewa.start((Integer) opiniaTable.getValueAt(opiniaTable.getSelectedRow(), 0));
                }
            }
        });
        usunDecyzjaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tmo = (DefaultTableModel) opiniaTable.getModel();
                for (int i = opiniaTable.getSelectedRows().length - 1; i >= 0; i--) {
                    try {
                        Context.daoZgloszenie.delete((Integer) opiniaTable.getValueAt(opiniaTable.getSelectedRows()[i], 0));
                        tmo.removeRow(opiniaTable.getSelectedRows()[i]);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    public static void start(Kierownik kier) {
        JFrame frame = new JFrame("Zlecenia");
        frame.setContentPane(new Zlecenia(kier).main);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        DefaultTableModel tmz = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tmz.addColumn("Numer Zgłoszenia");
        tmz.addColumn("Status");
        tmz.addColumn("Data");

        zleceniaTable = new JTable(tmz);


        DefaultTableModel tmk = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tmk.addColumn("Numer Kontrolera");
        tmk.addColumn("Nazwa");

        kontrolerTable = new JTable(tmk);


        DefaultTableModel tmo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tmo.addColumn("Numer Zgłoszenia");
        tmo.addColumn("Status");
        tmo.addColumn("Data");

        opiniaTable = new JTable(tmo);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        main = new JPanel();
        main.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 4, new Insets(0, 0, 0, 0), -1, -1));
        final JScrollPane scrollPane1 = new JScrollPane();
        main.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        scrollPane1.setViewportView(zleceniaTable);
        final JScrollPane scrollPane2 = new JScrollPane();
        main.add(scrollPane2, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        scrollPane2.setViewportView(kontrolerTable);
        decisionButton = new JButton();
        decisionButton.setText("Wydaj Decyzje");
        main.add(decisionButton, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sendButton = new JButton();
        sendButton.setText("Przekarz do Kontroli");
        main.add(sendButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(246, 30), null, 0, false));
        final JScrollPane scrollPane3 = new JScrollPane();
        main.add(scrollPane3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        scrollPane3.setViewportView(opiniaTable);
        szczegolyKontrolaButton = new JButton();
        szczegolyKontrolaButton.setText("Szczegóły");
        main.add(szczegolyKontrolaButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        szczegolyDecyzjaButton = new JButton();
        szczegolyDecyzjaButton.setText("Szczegóły");
        main.add(szczegolyDecyzjaButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        usunKontrolaButton = new JButton();
        usunKontrolaButton.setText("Usun");
        main.add(usunKontrolaButton, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        usunDecyzjaButton = new JButton();
        usunDecyzjaButton.setText("Usun");
        main.add(usunDecyzjaButton, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return main;
    }

}
