package pl.edu.pwr.student.djablonski.Customer.UI.GUI;

import pl.edu.pwr.student.Common.Data.Person;
import pl.edu.pwr.student.Common.Enums.Role;
import pl.edu.pwr.student.djablonski.Customer.Customer;
import pl.edu.pwr.student.djablonski.Customer.Handler.RequestHandler;
import pl.edu.pwr.student.djablonski.Customer.UI.UI;
import pl.edu.pwr.tkubik.jp.shop.api.IDeliverer;
import pl.edu.pwr.tkubik.jp.shop.api.ISeller;
import pl.edu.pwr.tkubik.jp.shop.api.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class GUI implements UI {
    private JTable Items;
    private JButton Button;
    private JTextField Receipt;
    private JPanel Main;
    private JLabel Label;

    private Customer C;
    private Integer step = 0;
    private List<Item> stock;

    public GUI(Customer C) {
        super();
        this.C = C;
        $$$setupUI$$$();
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (step) {
                    case 0: {
                        Button.setEnabled(false);
                        ArrayList<Item> order = new ArrayList<>();
                        int[] rows = Items.getSelectedRows();
                        for (int i = rows.length - 1; i >= 0; i--) {
                            String id = (String) Items.getValueAt(rows[i], 0);
                            Integer index = getIndexOfID(stock.toArray(Item[]::new), id);
                            if (index != null) {
                                order.add(stock.get(index));
                            }
                        }
                        Count.start(order, GUI.this::sendOrder, Button);
                        step = 1;
                    }
                    break;
                    case 1: {
                        Button.setEnabled(false);

                        int[] rows = Items.getSelectedRows();
                        for (int i = rows.length - 1; i >= 0; i--) {
                            String id = (String) Items.getValueAt(rows[i], 0);
                            Integer index = getIndexOfID(C.getOrder().items, id);
                            if (index != null) {
                                Item item = C.getOrder().items[index];
                                C.retD.add(item);
                                C.getOrder().delItem(item);
                            }
                        }

                        if (C.getOrder() != null && C.getDeliverer() != null) {
                            try {
                                ((IDeliverer) C.getDeliverer().getIc()).returnOrder(C.retD);
                            } catch (RemoteException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        DefaultTableModel dtm = (DefaultTableModel) Items.getModel();
                        dtm.setRowCount(0);

                        for (int i = C.getOrder().items.length - 1; i >= 0; i--) {
                            dtm.addRow(new Object[]{C.getOrder().items[i].getDescription(), C.getOrder().items[i].getQuantity()});
                        }

                        Label.setText("Select products that you want to return");
                        Button.setText("Return To Seller");
                        Button.setEnabled(true);
                        step = 2;
                    }
                    break;
                    case 2: {
                        Button.setEnabled(false);
                        C.retS = new ArrayList<>();
                        int[] rows = Items.getSelectedRows();
                        for (int i = rows.length - 1; i >= 0; i--) {
                            String id = (String) Items.getValueAt(rows[i], 0);
                            Integer index = getIndexOfID(C.getOrder().items, id);
                            if (index != null) {
                                Item item = C.getOrder().items[index];
                                C.retS.add(item);
                                C.getOrder().delItem(item);
                            }
                        }

                        Random r = new Random();
                        try {
                            List<ISeller> is = C.getKeeper().getSellers();
                            C.setSeller(new Person(Role.Seller, is.get(r.nextInt(0, is.size()))));
                        } catch (RemoteException ex) {
                            throw new RuntimeException(ex);
                        }

                        DefaultTableModel dtm = (DefaultTableModel) Items.getModel();
                        dtm.setRowCount(0);

                        for (int i = C.getOrder().items.length - 1; i >= 0; i--) {
                            dtm.addRow(new Object[]{C.getOrder().items[i].getDescription(), C.getOrder().items[i].getQuantity()});
                        }

                        Label.setText("Your items:");
                        Button.setText("Next Order");
                        Button.setEnabled(true);
                        step = 3;
                    }
                    break;
                    case 3: {
                        try {
                            C.getKeeper().getOffer(C.getIDe());
                        } catch (RemoteException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    break;
                    default:
                        break;
                }
            }
        });
    }

    public static void start(GUI gui) {
        JFrame frame = new JFrame("Simulation");
        frame.setContentPane(gui.Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void getRecipe() {
        Receipt.setText(C.getRecipe());
//        C.interrupt();
    }

    @Override
    public void getSeller() {
        if (C.getOrder() != null && C.getSeller() != null) {
            try {
                ((ISeller) C.getSeller().getIc()).acceptOrder(new RequestHandler(C), C.getOrder().items(), C.retS);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void getDeliverer() {
    }

    @Override
    public void getOrder() {
        if (C.getOrder() != null) {
            C.retD = new ArrayList<>();

            DefaultTableModel dtm = (DefaultTableModel) Items.getModel();
            dtm.setRowCount(0);

            for (int i = C.getOrder().items.length - 1; i >= 0; i--) {
                dtm.addRow(new Object[]{C.getOrder().items[i].getDescription(), C.getOrder().items[i].getQuantity()});
            }

            Label.setText("Select products that you want to return to Deliverer");
            Button.setText("Return to Deliverer");
            Button.setEnabled(true);
            step = 1;
        }
    }

    @Override
    public void getID() {
        try {
            C.getKeeper().getOffer(C.getIDe());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void putOrder(List<Item> s) {
        if (s != null) {
            this.stock = s;
            DefaultTableModel dtm = (DefaultTableModel) Items.getModel();
            for (int i = stock.size() - 1; i >= 0; i--) {
                dtm.addRow(new Object[]{stock.get(i).getDescription(), stock.get(i).getQuantity()});
            }

            Label.setText("Select products that you want to order");
            Button.setText("Place Order");
            Button.setEnabled(true);
            step = 0;
        }
    }

    public void sendOrder(ArrayList<Item> order) {
        if (!order.isEmpty()) {
            try {
                C.getKeeper().putOrder(C.getIDe(), order);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Integer getIndexOfID(Item[] stock, String id) {
        for (int i = 0; i < stock.length; i++) {
            if (Objects.equals(stock[i].getDescription(), id)) {
                return i;
            }
        }
        return null;
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
        Main = new JPanel();
        Main.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        Main.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        Button = new JButton();
        Button.setEnabled(false);
        Button.setText("Send");
        panel1.add(Button, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Receipt = new JTextField();
        Receipt.setEditable(false);
        Main.add(Receipt, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        Main.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        scrollPane1.setViewportView(Items);
        Label = new JLabel();
        Label.setText("Order");
        Main.add(Label, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return Main;
    }

    private void createUIComponents() {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dtm.addColumn("Name");
        dtm.addColumn("Stock");

        Items = new JTable(dtm);
    }
}
