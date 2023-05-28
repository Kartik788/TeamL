package com.inventory.UI;

import com.inventory.DAO.UserDAO;
import com.inventory.DTO.UserDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;


public class Dashboard extends JFrame {

    CardLayout layout;
    String userSelect;
    String username;
    String fullName;
    UserDTO userDTO;
    LocalDateTime outTime;

    private JButton custButton;
    private JPanel displayPanel;
    private JButton homeButton;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JButton logoutButton;
    private JButton logsButton;
    private JPanel mainPanel;
    private JButton menuButton;
    private JPanel menuPanel;
    private JLabel nameLabel;
    private JPanel navPanel;
    private JButton prodButton;
    private JButton purchaseButton;
    private JButton salesButton;
    private JButton stockButton;
    private JButton suppButton;
    private JPanel userPanel;
    private JButton usersButton;

    public Dashboard(String username, String userType, UserDTO userDTO) {
        initComponents();

        navPanel.setVisible(false);
        menuPanel.setVisible(true);
        layout = new CardLayout();
        userSelect = userType;
        this.username = username;
        this.userDTO = userDTO;
        if ("EMPLOYEE".equalsIgnoreCase(userType))
            notForEmployee();
        currentUserSession();

        displayPanel.setLayout(layout);
        displayPanel.add("Home", new HomePage(username));
        displayPanel.add("Users", new UsersPage());
        displayPanel.add("Customers", new CustomerPage());
        displayPanel.add("Products", new ProductPage(username, this));
        displayPanel.add("Suppliers", new SupplierPage());
        displayPanel.add("Current Stock", new CurrentStockPage(username));
        displayPanel.add("Sales", new SalesPage(username, this));
        displayPanel.add("Purchase", new PurchasePage(this));
        displayPanel.add("Logs", new UserLogsPage());

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                outTime = LocalDateTime.now();
                userDTO.setOutTime(String.valueOf(outTime));
                userDTO.setUsername(username);
                new UserDAO().addUserLogin(userDTO);
                super.windowClosing(e);
            }
        });

        setTitle("Inventory Manager");
        setVisible(true);
    }


    public void addHomePage() {
        layout.show(displayPanel, "Home");
    }

    public void addUsersPage() {
        layout.show(displayPanel, "Users");
    }

    public void addCustPage() {
        layout.show(displayPanel, "Customers");
    }

    public void addProdPage() {
        layout.show(displayPanel, "Products");
    }

    public void addSuppPage() {
        layout.show(displayPanel, "Suppliers");
    }

    public void addStockPage() {
        layout.show(displayPanel, "Current Stock");
    }

    public void addSalesPage() {
        layout.show(displayPanel, "Sales");
    }

    public void addPurchasePage() {
        layout.show(displayPanel, "Purchase");
    }

    public void addLogsPage() {
        layout.show(displayPanel, "Logs");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        mainPanel = new JPanel();
        menuPanel = new JPanel();
        menuButton = new JButton();
        navPanel = new JPanel();
        homeButton = new JButton();
        prodButton = new JButton();
        stockButton = new JButton();
        custButton = new JButton();
        suppButton = new JButton();
        salesButton = new JButton();
        usersButton = new JButton();
        purchaseButton = new JButton();
        logsButton = new JButton();
        displayPanel = new JPanel();
        userPanel = new JPanel();
        nameLabel = new JLabel();
        logoutButton = new JButton();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Manager");
        setBounds(new java.awt.Rectangle(400, 100, 0, 0));

        menuPanel.setPreferredSize(new java.awt.Dimension(120, 26));

        menuButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        menuButton.setIcon(new ImageIcon(getClass().getResource("/com/inventory/UI/Icons/menu_icon_150667.png")));
        menuButton.setText("MENU");
        menuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(menuButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addComponent(menuButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        navPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        homeButton.setIcon(new ImageIcon(getClass().getResource("/com/inventory/UI/Icons/homepages_home_house_icon_150665.png")));
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        prodButton.setText("Products");
        prodButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButtonActionPerformed(evt);
            }
        });

        stockButton.setText("Current Stock");
        stockButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockButtonActionPerformed(evt);
            }
        });

        custButton.setText("Customers");
        custButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        custButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custButtonActionPerformed(evt);
            }
        });

        suppButton.setText("Suppliers");
        suppButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        suppButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppButtonActionPerformed(evt);
            }
        });

        salesButton.setText("Sales");
        salesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesButtonActionPerformed(evt);
            }
        });

        usersButton.setText("Users");
        usersButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersButtonActionPerformed(evt);
            }
        });

        purchaseButton.setText("Purchase");
        purchaseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseButtonActionPerformed(evt);
            }
        });

        logsButton.setText("User Logs");
        logsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logsButtonActionPerformed(evt);
            }
        });

        GroupLayout navPanelLayout = new GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
                navPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(navPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(navPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(homeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(prodButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(stockButton, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                        .addComponent(custButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(suppButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(salesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(usersButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(purchaseButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(logsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        navPanelLayout.setVerticalGroup(
                navPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(navPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(prodButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(stockButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(custButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(suppButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(salesButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(purchaseButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(usersButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logsButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        displayPanel.setLayout(new CardLayout());

        nameLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12));
        nameLabel.setIcon(new ImageIcon(getClass().getResource("/com/inventory/UI/Icons/user_icon_150670.png")));
        nameLabel.setText("User: ");
        nameLabel.setVerticalAlignment(SwingConstants.TOP);

        logoutButton.setIcon(new ImageIcon(getClass().getResource("/com/inventory/UI/Icons/log-out_icon-icons.com_50106.png")));
        logoutButton.setText("Sign out");
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        GroupLayout userPanelLayout = new GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
                userPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(userPanelLayout.createSequentialGroup()
                                .addContainerGap(401, Short.MAX_VALUE)
                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoutButton))
        );
        userPanelLayout.setVerticalGroup(
                userPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(userPanelLayout.createSequentialGroup()
                                .addGroup(userPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(GroupLayout.Alignment.LEADING, userPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(navPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(userPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(userPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(navPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int opt = JOptionPane.showConfirmDialog(
                null,
                "<html>Are you sure you want to logout?<br>You will have to login again.<html>",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);
        if (opt == JOptionPane.YES_OPTION) {
            outTime = LocalDateTime.now();
            userDTO.setOutTime(String.valueOf(outTime));
            userDTO.setUsername(username);
            new UserDAO().addUserLogin(userDTO);
            dispose();
            LoginPage logPage = new LoginPage();
            logPage.setVisible(true);
        }
    }

    private void usersButtonActionPerformed(java.awt.event.ActionEvent evt) {
        addUsersPage();
    }

    private void salesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        addSalesPage();
    }

    private void suppButtonActionPerformed(java.awt.event.ActionEvent evt) {
        addSuppPage();
    }

    private void custButtonActionPerformed(java.awt.event.ActionEvent evt) {
        addCustPage();
    }

    private void stockButtonActionPerformed(java.awt.event.ActionEvent evt) {
        addStockPage();
    }

    private void prodButtonActionPerformed(java.awt.event.ActionEvent evt) {
        addProdPage();
    }

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //dispose();
        addHomePage();
    }

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        navPanel.setVisible(!navPanel.isVisible());
    }

    private void purchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        addPurchasePage();
    }

    private void logsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        addLogsPage();
    }


    public void currentUserSession() {
        UserDTO userDTO = new UserDTO();
        new UserDAO().getFullName(userDTO, username);
        nameLabel.setText("User: " + userDTO.getFullName() + " (" + userSelect + ")");
    }


    public void notForEmployee() {
        navPanel.remove(usersButton);
        navPanel.remove(logsButton);
        //navPanel.remove(salesButton);
    }


}
