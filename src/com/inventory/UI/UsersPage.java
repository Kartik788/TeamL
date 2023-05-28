package com.inventory.UI;

import com.inventory.DAO.UserDAO;
import com.inventory.DTO.UserDTO;

import javax.swing.*;
import java.sql.SQLException;

public class UsersPage extends JPanel {

    private JButton addButton;
    private JButton clearButton;
    private JButton deleteButton;
    private JPanel entryPanel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JTextField locationText;
    private JTextField nameText;
    private JPasswordField passText;
    private JTextField phoneText;
    private JTable userTable;
    private JComboBox<String> userTypeCombo;
    private JTextField usernameText;


    public UsersPage() {
        initComponents();
        loadDataSet();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        entryPanel = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        nameText = new JTextField();
        locationText = new JTextField();
        phoneText = new JTextField();
        usernameText = new JTextField();
        passText = new JPasswordField();
        userTypeCombo = new JComboBox<>();
        addButton = new JButton();
        deleteButton = new JButton();
        clearButton = new JButton();
        jScrollPane1 = new JScrollPane();
        userTable = new JTable();

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24));
        jLabel1.setText("USERS");

        entryPanel.setBorder(BorderFactory.createTitledBorder("Enter User Details"));

        jLabel2.setText("Full Name:");

        jLabel3.setText("Location:");

        jLabel4.setText("Contact:");

        jLabel5.setText("Username:");

        jLabel6.setText("Password:");

        userTypeCombo.setModel(new DefaultComboBoxModel<>(new String[]{"ADMINISTRATOR", "EMPLOYEE"}));

        addButton.setText("Add");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
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

        GroupLayout entryPanelLayout = new GroupLayout(entryPanel);
        entryPanel.setLayout(entryPanelLayout);
        entryPanelLayout.setHorizontalGroup(
                entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(entryPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(userTypeCombo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nameText))
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(locationText))
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(phoneText))
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passText))
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(usernameText)))
                                .addContainerGap())
                        .addGroup(entryPanelLayout.createSequentialGroup()
                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        entryPanelLayout.setVerticalGroup(
                entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(entryPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(locationText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(userTypeCombo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addButton)
                                        .addComponent(deleteButton)
                                        .addComponent(clearButton))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userTable.setBorder(BorderFactory.createEtchedBorder());
        userTable.setForeground(new java.awt.Color(102, 102, 102));
        userTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        userTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userTable.setName("Users"); // NOI18N
        userTable.setShowGrid(true);
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(entryPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(entryPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(95, 95, 95))
        );
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        nameText.setText("");
        locationText.setText("");
        phoneText.setText("");
        usernameText.setText("");
        passText.setText("");
    }

    String userType;

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        UserDTO userDTO = new UserDTO();

        if (nameText.getText().equals("") || locationText.getText().equals("") || phoneText.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Please fill all the required fields.");
        else {
            userType = (String) userTypeCombo.getSelectedItem();
            userDTO.setFullName(nameText.getText());
            userDTO.setLocation(locationText.getText());
            userDTO.setPhone(phoneText.getText());
            userDTO.setUsername(usernameText.getText());
            userDTO.setPassword(passText.getText());
            userDTO.setUserType(userType);
            new UserDAO().addUserDAO(userDTO, userType);
            loadDataSet();
        }
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (userTable.getSelectedRow() < 0)
            JOptionPane.showMessageDialog(null, "Please select an entry from the table");
        else {
            int opt = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this user?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                new UserDAO().deleteUserDAO(
                        String.valueOf(
                                userTable.getValueAt
                                        (userTable.getSelectedRow(), 4)));
                loadDataSet();
            }
        }
    }

    String username;

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {
        int row = userTable.getSelectedRow();
        int col = userTable.getColumnCount();
        Object[] val = new Object[col];

        for (int i = 0; i < col; i++) {
            val[i] = userTable.getValueAt(row, i);
        }
        nameText.setText(val[1].toString());
        locationText.setText(val[2].toString());
        phoneText.setText(val[3].toString());
        usernameText.setText(val[4].toString());
        userTypeCombo.setSelectedItem(val[6].toString());
    }

    public void loadDataSet() {
        try {
            UserDAO userDAO = new UserDAO();
            userTable.setModel(userDAO.buildTableModel(userDAO.getQueryResult()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
