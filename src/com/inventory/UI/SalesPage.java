
package com.inventory.UI;

import com.inventory.DAO.CustomerDAO;
import com.inventory.DAO.ProductDAO;
import com.inventory.DTO.ProductDTO;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SalesPage extends JPanel {

    String username;
    Dashboard dashboard;
    int quantity;
    String prodCode;

    private JButton addCustButton;
    private JButton clearButton;
    private JTextField custCodeText;
    private JLabel custNameLabel;
    private JButton deleteButton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JTextField priceText;
    private JTextField prodCodeText;
    private JLabel prodNameLabel;
    private JTextField quantityText;
    private JTable salesTable;
    private JTextField searchText;
    private JButton sellButton;
    private JPanel sellPanel;


    public SalesPage(String username, Dashboard dashboard) {
        initComponents();
        this.username = username;
        this.dashboard = dashboard;
        custNameLabel.setVisible(false);
        prodNameLabel.setVisible(false);
        loadDataSet();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        sellPanel = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        custCodeText = new JTextField();
        prodCodeText = new JTextField();
        priceText = new JTextField();
        quantityText = new JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        sellButton = new JButton();
        deleteButton = new JButton();
        clearButton = new JButton();
        addCustButton = new JButton();
        custNameLabel = new JLabel();
        prodNameLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        salesTable = new JTable();
        searchText = new JTextField();
        jLabel7 = new JLabel();

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24));
        jLabel1.setText("SALES");

        sellPanel.setBorder(BorderFactory.createTitledBorder("Sell Product"));

        jLabel2.setText("Customer Code:");

        jLabel3.setText("Product Code:");

        jLabel4.setText("Date:");

        jLabel5.setText("Selling Price:");

        jLabel6.setText("Quantity:");

        custCodeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                custCodeTextKeyReleased(evt);
            }
        });

        prodCodeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prodCodeTextKeyReleased(evt);
            }
        });

        sellButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        sellButton.setText("SELL PRODUCT");
        sellButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        addCustButton.setText("Click to add a New Customer");
        addCustButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCustButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustButtonActionPerformed(evt);
            }
        });

        custNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        custNameLabel.setLabelFor(custCodeText);

        prodNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        prodNameLabel.setLabelFor(prodCodeText);

        GroupLayout sellPanelLayout = new GroupLayout(sellPanel);
        sellPanel.setLayout(sellPanelLayout);
        sellPanelLayout.setHorizontalGroup(
                sellPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sellPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(prodNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(custNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addCustButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sellButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(sellPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(custCodeText))
                                        .addGroup(sellPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prodCodeText))
                                        .addGroup(sellPanelLayout.createSequentialGroup()
                                                .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearButton, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                        .addGroup(sellPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(quantityText))
                                        .addGroup(sellPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(priceText))
                                        .addGroup(sellPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jDateChooser1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        sellPanelLayout.setVerticalGroup(
                sellPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sellPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(sellPanelLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(custCodeText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(custNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(addCustButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(prodCodeText, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prodNameLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(priceText, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quantityText, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sellButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(sellPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteButton)
                                        .addComponent(clearButton))
                                .addContainerGap())
        );

        salesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        salesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(salesTable);

        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });

        jLabel7.setText("Search:");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(searchText, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator1)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sellPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(sellPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap(70, Short.MAX_VALUE))
        );
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (salesTable.getSelectedRow() < 0)
            JOptionPane.showMessageDialog(this, "Please select an entry from the table you wish to delete.");
        else {
            int opt = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete this sale from the database?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                new ProductDAO().deleteSaleDAO(Integer.parseInt(
                        salesTable.getValueAt(salesTable.getSelectedRow(), 0).toString()));
                new ProductDAO().editSoldStock(
                        salesTable.getValueAt(salesTable.getSelectedRow(), 1).toString(), quantity);
                loadDataSet();
            }
        }
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        custCodeText.setText("");
        custNameLabel.setText("");
        custNameLabel.setVisible(false);
        prodCodeText.setText("");
        prodNameLabel.setText("");
        prodNameLabel.setVisible(false);
        jDateChooser1.setDate(null);
        priceText.setText("");
        quantityText.setText("");
        loadDataSet();
    }

    private void addCustButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dashboard.addCustPage();
    }

    private void sellButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (custCodeText.getText().equals("") || prodCodeText.getText().equals("")
                || jDateChooser1.getDate() == null || quantityText.getText().equals("") || priceText.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Please fill all the required fields.");
        else {
            try {
                ResultSet resultSet = new CustomerDAO().getCustName(custCodeText.getText());
                if (resultSet.next()) {
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setCustCode(custCodeText.getText());
                    productDTO.setDate(jDateChooser1.getDate().toString());
                    productDTO.setProdCode(prodCodeText.getText());
                    Double sellPrice = Double.parseDouble(priceText.getText());
                    Double totalRevenue = sellPrice * Integer.parseInt(quantityText.getText());
                    productDTO.setTotalRevenue(totalRevenue);
                    productDTO.setQuantity(Integer.parseInt(quantityText.getText()));
                    new ProductDAO().sellProductDAO(productDTO, username);
                    loadDataSet();
                } else
                    JOptionPane.showMessageDialog(this, "This customer does not exist.\n" +
                            "Add new customer or use a valid customer code.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void salesTableMouseClicked(java.awt.event.MouseEvent evt) {
        int row = salesTable.getSelectedRow();
        int col = salesTable.getColumnCount();
        Object[] data = new Object[col];
        for (int i = 0; i < col; i++)
            data[i] = salesTable.getValueAt(row, i);
        quantity = Integer.parseInt(data[3].toString());
        prodCode = data[1].toString();
    }

    private void custCodeTextKeyReleased(java.awt.event.KeyEvent evt) {
        try {
            ResultSet resultSet = new CustomerDAO().getCustName(custCodeText.getText());
            if (resultSet.next())
                custNameLabel.setText("Name: "
                        + resultSet.getString("fullname")
                        + " | Location: "
                        + resultSet.getString("location"));
            else
                custNameLabel.setText("||   Customer doesn't exist in database.   ||");
            custNameLabel.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void prodCodeTextKeyReleased(java.awt.event.KeyEvent evt) {
        try {
            ResultSet resultSet = new CustomerDAO().getProdName(prodCodeText.getText());
            if (resultSet.next()) {
                prodNameLabel.setText("Name: "
                        + resultSet.getString("productname")
                        + " | Available quantity: "
                        + resultSet.getString("quantity"));
                Double sellPrice = new ProductDAO().getProdSell(prodCodeText.getText());
                priceText.setText(sellPrice.toString());
            } else
                prodNameLabel.setText("||   Product doesn't exist in Inventory.  ||");
            prodNameLabel.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {
        loadSearchData(searchText.getText());
    }


    public void loadDataSet() {
        try {
            ProductDAO productDAO = new ProductDAO();
            salesTable.setModel(productDAO.buildTableModel(productDAO.getSalesInfo()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void loadSearchData(String text) {
        try {
            ProductDAO productDAO = new ProductDAO();
            salesTable.setModel(productDAO.buildTableModel(productDAO.getSalesSearch(text)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
