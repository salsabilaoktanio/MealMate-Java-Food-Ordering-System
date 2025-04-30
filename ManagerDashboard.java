package final_assignment;

import java.io.IOException; // For handling file-related exceptions
import java.util.ArrayList; // For ArrayList
import javax.swing.JOptionPane; // For displaying messages
import javax.swing.table.DefaultTableModel; // For table model handling


/**
 * Manager Dashboard GUI class Handles complaints, vendor performance, and menu management.
 */
public class ManagerDashboard extends javax.swing.JFrame {

    // Instance variables
    private ArrayList<Complaint> complaints; // To store complaints in memory
    private ArrayList<MenuItem> menuItems; // To store menu items in memory
    


    // Constructor
    public ManagerDashboard() {
        initComponents(); // Initializes the GUI components
        
    }

    /**
     * Method to load complaints into the table from the file
     */
private void loadComplaintData() {
    try {
        // Load complaints from the file
        complaints = dataloader.loadComplaints("complains.txt");

        // Get the table model
        DefaultTableModel model = (DefaultTableModel) ComplaintTable.getModel();
        model.setRowCount(0); // Clear any existing rows

        // Add rows to the table model
        for (Complaint complaint : complaints) {
            model.addRow(new Object[]{
                complaint.getReview_id(),
                complaint.getOrder_id(),
                complaint.getUser_id(),
                complaint.getVendor_name(),
                complaint.getVendor_review(),
                complaint.getRunner_name(),
                complaint.getRunner_review(),
                complaint.getComplaint_status()
            });
        }

        // Refresh the GUI to ensure the table updates
        ComplaintTable.repaint();

        // Optional: Show success message
        JOptionPane.showMessageDialog(this, "Complaints loaded successfully!");
    } catch (IOException ex) {
        // Show an error message if loading fails
        JOptionPane.showMessageDialog(this, "Error loading complaints: " + ex.getMessage());
    }
}

private void loadMenuItems() {
    try {
        // Load menu items from the file
        menuItems = dataloader.loadMenuItems("themenu.txt");

        // Get the table model
        DefaultTableModel model = (DefaultTableModel) MenuTable.getModel();
        model.setRowCount(0); // Clear any existing rows

        // Add rows to the table model
        for (MenuItem item : menuItems) {
            model.addRow(new Object[]{
                item.getVendor_id(),
                item.getVendor_name(),
                item.getItem_id(),
                item.getItem_name(),
                item.getItem_price()
            });
        }

        // Refresh the GUI to ensure the table updates
        MenuTable.repaint();

        // Optional: Show success message
        JOptionPane.showMessageDialog(this, "Menu items loaded successfully!");
    } catch (IOException ex) {
        // Show an error message if loading fails
        JOptionPane.showMessageDialog(this, "Error loading menu items: " + ex.getMessage());
    }
}


private void loadReviewData() { 
    try {
        // Load reviews from the file
        ArrayList<review> reviews = dataloader.loadReviews("review.txt");

        // Get the table model
        DefaultTableModel model = (DefaultTableModel) ReviewTable.getModel();
        model.setRowCount(0); // Clear any existing rows

        // Add rows to the table model
        for (review review : reviews) {
            model.addRow(new Object[]{
                review.getReview_id(),
                review.getOrder_id(),
                review.getUser_id(),
                review.getVendor_name(),
                review.getVendor_review(),
                review.getRunner_name(),
                review.getRunner_review()
            });
        }

        // Refresh the GUI to ensure the table updates
        ReviewTable.repaint();

        // Optional: Show success message
        JOptionPane.showMessageDialog(this, "Reviews loaded successfully!");
    } catch (IOException ex) {
        // Show an error message if loading fails
        JOptionPane.showMessageDialog(this, "Error loading reviews: " + ex.getMessage());
    }
}

private void loadVendorPerformance() {
    try {
        ArrayList<VendorPerformance> vendorPerformanceList = dataloader.loadVendorPerformance("order.txt");

        // Get table model and clear existing data
        DefaultTableModel model = (DefaultTableModel) VendorTable.getModel();
        model.setRowCount(0);

        // Add vendor revenue details to the table
        for (VendorPerformance vendor : vendorPerformanceList) {
            model.addRow(new Object[]{
                vendor.getVendorName(),
                vendor.getTotalRevenue()
            });
        }

        JOptionPane.showMessageDialog(this, "Vendor performance loaded successfully!");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error loading vendor performance: " + ex.getMessage());
    }
}






    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        Vendor_btn = new javax.swing.JButton();
        complains_btn = new javax.swing.JButton();
        menu_btn = new javax.swing.JButton();
        delivery_btn = new javax.swing.JButton();
        managerLogout = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        VendorTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ComplaintTable = new javax.swing.JTable();
        ResolveButton = new javax.swing.JButton();
        view_btn3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        MenuTable = new javax.swing.JTable();
        remove_btn4 = new javax.swing.JButton();
        view_btn4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ReviewTable = new javax.swing.JTable();
        view_btn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(255, 249, 244));

        jTextField1.setBackground(new java.awt.Color(151, 214, 207));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Manager Dashboard");
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(151, 214, 207));

        Vendor_btn.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Vendor_btn.setText("vendor performance ");
        Vendor_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Vendor_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vendor_btnActionPerformed(evt);
            }
        });

        complains_btn.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        complains_btn.setText("complaint managment");
        complains_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        complains_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complains_btnActionPerformed(evt);
            }
        });

        menu_btn.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        menu_btn.setText("menu managment");
        menu_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_btnActionPerformed(evt);
            }
        });

        delivery_btn.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        delivery_btn.setText("Delivery runner reviews");
        delivery_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delivery_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delivery_btnActionPerformed(evt);
            }
        });

        managerLogout.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        managerLogout.setText("Log Out");
        managerLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        managerLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(complains_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Vendor_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delivery_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(managerLogout)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Vendor_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(complains_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(menu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(delivery_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(managerLogout)
                .addGap(15, 15, 15))
        );

        jTabbedPane1.setBackground(new java.awt.Color(151, 214, 207));

        jPanel3.setBackground(new java.awt.Color(255, 249, 244));

        jButton2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton2.setText("view vendor performance");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        VendorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "VendorName", "TotalRevenue"
            }
        ));
        VendorTable.setPreferredSize(new java.awt.Dimension(525, 320));
        jScrollPane1.setViewportView(VendorTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("vendor performance", jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 249, 244));

        ComplaintTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "complainID", "orderID", "userID", "VendorName", "VendorReview", "RunnerName", "RunnerReview", "ComplaintsStatus"
            }
        ));
        ComplaintTable.setPreferredSize(new java.awt.Dimension(525, 320));
        jScrollPane2.setViewportView(ComplaintTable);

        ResolveButton.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        ResolveButton.setText("resolve");
        ResolveButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResolveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResolveButtonActionPerformed(evt);
            }
        });

        view_btn3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        view_btn3.setText("View");
        view_btn3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        view_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_btn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(view_btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178)
                        .addComponent(ResolveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 187, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(view_btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResolveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("complaint managment", jPanel6);

        jPanel5.setBackground(new java.awt.Color(255, 249, 244));

        MenuTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MenuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "VendorID", "VendorName", "ItemID", "ItemName", "ItemPrice"
            }
        ));
        MenuTable.setPreferredSize(new java.awt.Dimension(525, 320));
        jScrollPane3.setViewportView(MenuTable);

        remove_btn4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        remove_btn4.setText("Remove Item");
        remove_btn4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        remove_btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_btn4ActionPerformed(evt);
            }
        });

        view_btn4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        view_btn4.setText("view menu");
        view_btn4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        view_btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_btn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(view_btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(remove_btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(view_btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(remove_btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("menu managment", jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 249, 244));

        ReviewTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ReviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ReviewID", "OrderID", "UserID", "VendorName", "VendorReview", "RunnerName", "RunnerReview"
            }
        ));
        jScrollPane4.setViewportView(ReviewTable);

        view_btn2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        view_btn2.setText("view reviews");
        view_btn2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        view_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(view_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(348, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addGap(15, 15, 15))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(view_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("delivery runner reviews", jPanel7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void complains_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complains_btnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_complains_btnActionPerformed

    private void Vendor_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vendor_btnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_Vendor_btnActionPerformed

    private void menu_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_btnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_menu_btnActionPerformed

    private void ResolveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResolveButtonActionPerformed
   int selectedRow = ComplaintTable.getSelectedRow(); // Get the selected row index
if (selectedRow != -1) { // Ensure a row is selected
    DefaultTableModel model = (DefaultTableModel) ComplaintTable.getModel();
    String complain_id = (String) model.getValueAt(selectedRow, 0); // Get complain_id

    // Update the status of the selected complaint
    for (Complaint complaint : complaints) {
        if (complaint.getReview_id().equals(complain_id)) {
            complaint.setComplaint_status("Resolved");
            model.setValueAt("Resolved", selectedRow, 7); // Update table cell
            System.out.println("Complaint status updated in ArrayList for ID: " + complain_id); // Debug log
            break;
        }
    }

    try {
        // Save the updated complaints back to the file
        dataloader.saveComplaints("complains.txt", complaints);
        JOptionPane.showMessageDialog(this, "Complaint resolved and saved to file.");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error saving complaints: " + ex.getMessage());
        ex.printStackTrace(); // Debugging purpose
    }
} else {
    JOptionPane.showMessageDialog(this, "Please select a complaint to resolve.");
}
    }//GEN-LAST:event_ResolveButtonActionPerformed

    private void view_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_btn3ActionPerformed
  
        loadComplaintData(); // Load the complaints into the table
       
    }//GEN-LAST:event_view_btn3ActionPerformed

    private void remove_btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_btn4ActionPerformed
      int selectedRow = MenuTable.getSelectedRow(); // Get the selected row index
    if (selectedRow != -1) { // Ensure a row is selected
        DefaultTableModel model = (DefaultTableModel) MenuTable.getModel();
        String item_id = (String) model.getValueAt(selectedRow, 2); // Get item_id

        // Remove the item from the list
        menuItems.removeIf(item -> item.getItem_id().equals(item_id));

        // Update the table model
        model.removeRow(selectedRow);

        try {
            // Save the updated menu items back to the file
            dataloader.saveMenuItems("themenu.txt", menuItems);
            JOptionPane.showMessageDialog(this, "Item removed and changes saved to file.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving menu items: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select an item to remove.");
    }
    }//GEN-LAST:event_remove_btn4ActionPerformed

    private void delivery_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delivery_btnActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_delivery_btnActionPerformed

    private void view_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_btn2ActionPerformed
        // TODO add your handling code here:
        loadReviewData();
    }//GEN-LAST:event_view_btn2ActionPerformed

    private void view_btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_btn4ActionPerformed
        // TODO add your handling code here:
         loadMenuItems(); // Load the menu items into the table
    }//GEN-LAST:event_view_btn4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        loadVendorPerformance();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void managerLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerLogoutActionPerformed
        // TODO add your handling code here:
        login loginframe = new login();
        loginframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_managerLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ManagerDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ComplaintTable;
    private javax.swing.JTable MenuTable;
    private javax.swing.JButton ResolveButton;
    private javax.swing.JTable ReviewTable;
    private javax.swing.JTable VendorTable;
    private javax.swing.JButton Vendor_btn;
    private javax.swing.JButton complains_btn;
    private javax.swing.JButton delivery_btn;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton managerLogout;
    private javax.swing.JButton menu_btn;
    private javax.swing.JButton remove_btn4;
    private javax.swing.JButton view_btn2;
    private javax.swing.JButton view_btn3;
    private javax.swing.JButton view_btn4;
    // End of variables declaration//GEN-END:variables
}



