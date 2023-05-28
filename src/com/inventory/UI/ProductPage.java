package com.inventory.UI;

import com.inventory.DAO.ProductDAO;
import com.inventory.DAO.SupplierDAO;
import com.inventory.DTO.ProductDTO;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.sql.SQLException;

public class ProductPage extends JPanel {

    ProductDTO productDTO;
    String username = null;
    String supplier = null;
    int userID;
    Dashboard dashboard;

    private JButton addButton;
    private JButton addSuppButton;
    private JTextField brandText;
    private JButton clearButton;
    private JTextField codeText;
    private JTextField costText;
    private JButton deleteButton;
    private JButton editButton;
    private JPanel entryPanel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JTextField nameText;
    private JTable productTable;
    private JTextField quantityText;
    private JButton refreshButton;
    private JTextField searchText;
    private JTextField sellText;
    private JComboBox<String> suppCombo;


    public ProductPage() {
    }

    public ProductPage(String username, Dashboard dashboard) {
        initComponents();
        this.username = username;
        this.dashboard = dashboard;
        loadComboBox();
        loadDataSet();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        entryPanel = new JPanel();
        suppCombo = new JComboBox<>();
        addSuppButton = new JButton();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        codeText = new JTextField();
        nameText = new JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        quantityText = new JTextField();
        costText = new JTextField();
        sellText = new JTextField();
        brandText = new JTextField();
        addButton = new JButton();
        editButton = new JButton();
        deleteButton = new JButton();
        clearButton = new JButton();
        jScrollPane1 = new JScrollPane();
        productTable = new JTable();
        refreshButton = new JButton();
        searchText = new JTextField();
        jLabel9 = new JLabel();

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24));
        jLabel1.setText("PRODUCTS");

        entryPanel.setBorder(BorderFactory.createTitledBorder("Enter Product Details"));

        suppCombo.setModel(new DefaultComboBoxModel<>(new String[]{"Select a supplier"}));
        suppCombo.setToolTipText("Select a supplier");

        addSuppButton.setText("Click to add a New Supplier");
        addSuppButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addSuppButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSuppButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Product Code:");

        jLabel3.setText("Product Name:");

        jLabel4.setText("Date:");

        jLabel5.setText("Quantity:");

        jLabel6.setText("Cost Price:");

        jLabel7.setText("Selling Price:");

        jLabel8.setText("Brand:");

        jDateChooser1.setForeground(new java.awt.Color(102, 102, 102));

        addButton.setText("Add");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
        clearButton.setText("CLEAR");
        clearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        GroupLayout entryPanelLayout = new GroupLayout(entryPanel);
        entryPanel.setLayout(entryPanelLayout);
        entryPanelLayout
                .setHorizontalGroup(entryPanelLayout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(entryPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(clearButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(suppCombo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addSuppButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(codeText))
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(nameText)).addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(brandText)).addGroup(entryPanelLayout.createSequentialGroup().addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jDateChooser1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(entryPanelLayout.createSequentialGroup().addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(quantityText))
                                        .addGroup(entryPanelLayout.createSequentialGroup().addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(costText))
                                        .addGroup(entryPanelLayout.createSequentialGroup().addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(sellText))
                                        .addGroup(entryPanelLayout.createSequentialGroup().addComponent(addButton).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(editButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))).addContainerGap()));

        entryPanelLayout.setVerticalGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(entryPanelLayout.createSequentialGroup().addContainerGap()
                        .addComponent(suppCombo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addSuppButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(codeText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(entryPanelLayout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(jDateChooser1, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(quantityText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(costText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sellText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(entryPanelLayout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(brandText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(addButton).addComponent(editButton).addComponent(deleteButton)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        productTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        productTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        refreshButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        refreshButton.setText("REFRESH");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });

        jLabel9.setText("Search:");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel9)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(searchText, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18).addComponent(refreshButton)).addComponent(jSeparator1).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(entryPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))).addContainerGap()));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(refreshButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(entryPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)).addGap(64, 64, 64)));
    }

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (productTable.getSelectedRow() < 0)
            JOptionPane.showMessageDialog(null, "Please select product from the table.");
        else {
            productDTO = new ProductDTO();
            if (nameText.getText().equals("") || costText.getText().equals("") || sellText.getText().equals("") || brandText.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Please enter all the required details.");
            else {
                productDTO.setProdCode(codeText.getText());
                productDTO.setProdName(nameText.getText());
                productDTO.setDate(jDateChooser1.getDateFormatString());
                productDTO.setQuantity(Integer.parseInt(quantityText.getText()));
                productDTO.setCostPrice(Double.parseDouble(costText.getText()));
                productDTO.setSellPrice(Double.parseDouble(sellText.getText()));
                productDTO.setBrand(brandText.getText());
                productDTO.setUserID(userID);

                new ProductDAO().editProdDAO(productDTO);
            }
            loadDataSet();
        }
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        productDTO = new ProductDTO();
        if (nameText.getText().equals("") || costText.getText().equals("") || sellText.getText().equals("") || brandText.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Please enter all the required details.");
        else {
            productDTO.setProdCode(codeText.getText());
            productDTO.setProdName(nameText.getText());
            productDTO.setDate(jDateChooser1.getDateFormatString());
            productDTO.setQuantity(Integer.parseInt(quantityText.getText()));
            productDTO.setCostPrice(Double.parseDouble(costText.getText()));
            productDTO.setSellPrice(Double.parseDouble(sellText.getText()));
            productDTO.setBrand(brandText.getText());
            productDTO.setUserID(userID);

            new ProductDAO().addProductDAO(productDTO);
            loadDataSet();
        }
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (productTable.getSelectedRow() < 0)
            JOptionPane.showMessageDialog(null, "Please select product from the table.");
        else {
            int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this product?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                new ProductDAO().deleteProductDAO((String) productTable.getValueAt(productTable.getSelectedRow(), 0));
                loadDataSet();
            }
        }
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        codeText.setText("");
        nameText.setText("");
        jDateChooser1.setDate(null);
        quantityText.setText("");
        costText.setText("");
        sellText.setText("");
        brandText.setText("");
        searchText.setText("");
    }


    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {
        int row = productTable.getSelectedRow();
        int col = productTable.getColumnCount();

        Object[] data = new Object[col];
        for (int i = 0; i < col; i++)
            data[i] = productTable.getValueAt(row, i);

        codeText.setText(data[0].toString());
        nameText.setText(data[1].toString());
        costText.setText(data[2].toString());
        sellText.setText(data[3].toString());
        brandText.setText(data[4].toString());

        // productName = data[1].toString();

    }

    private void addSuppButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dashboard.addSuppPage();
    }

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loadDataSet();
        loadComboBox();
        clearButtonActionPerformed(evt);
    }

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {
        loadSearchData(searchText.getText());
    }


    public void loadComboBox() {
        try {
            SupplierDAO supplierDAO = new SupplierDAO();
            suppCombo.setModel(supplierDAO.setComboItems(supplierDAO.getQueryResult()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void loadDataSet() {
        try {
            ProductDAO productDAO = new ProductDAO();
            productTable.setModel(productDAO.buildTableModel(productDAO.getQueryResult()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void loadSearchData(String text) {
        try {
            ProductDAO productDAO = new ProductDAO();
            productTable.setModel(productDAO.buildTableModel(productDAO.getProductSearch(text)));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
