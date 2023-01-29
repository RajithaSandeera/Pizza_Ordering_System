
package com.mycompany.pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rajit
 */
public class Pizza1 extends javax.swing.JFrame {

  
DefaultTableModel model;
String item;
int price;
Connection con;
PreparedStatement pst;
PreparedStatement pst1;

public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Register the mysql driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza","root","");    
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }
    
    
    public Pizza1() {
       initComponents();
    }
    // </editor-fold>

    
   

  
      public void sales()
    {
        int lastid =0;
        try {
            String total = Total.getText();
            String bal = Balance.getText();
            String pay = Payment.getText();
            String query = "insert into sales(subTotal,pay,balance)values(?,?,?)";
           
            pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
         
            pst.setString(1, total);
            pst.setString(2, pay);
             pst.setString(3, bal);
             pst.executeUpdate();
             ResultSet rs = pst.getGeneratedKeys();
            
            if(rs.next())
            {
                lastid = rs.getInt(1);
            }
            int row = jTable1.getRowCount();
            String query1 = "insert into sales_product(sales_id,ProductName,price,Qty,Total)values(?,?,?,?,?)";
            pst1 = con.prepareStatement(query1);
            
            String prodname = "";
            int price;
            int qty;
            int tot = 0;
 
            for(int i=0; i<jTable1.getRowCount(); i++)
                    {
                        prodname = (String)jTable1.getValueAt(i, 0);
                         price = (int)jTable1.getValueAt(i, 1);
                         qty = (int)jTable1.getValueAt(i, 2);
                         tot = (int)jTable1.getValueAt(i, 3);
                        
                          pst1.setInt(1,lastid);
                          pst1.setString(2,prodname);
                          pst1.setInt(3,price);
                          pst1.setInt(4,qty);
                          pst1.setInt(5,tot);
                          pst1.executeUpdate();
                        
                    }
//            
//            JOptionPane.showMessageDialog(this, "Saless Completeeeeddddddd");
//            HashMap a = new HashMap();
//            a.put("invo", lastid);
// 
//            try {
//                JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\kobinath\\Documents\\NetBeansProjects\\Pizza\\src\\Pizza\\report1.jrxml");
//                JasperReport jreport = JasperCompileManager.compileReport(jdesign);
//                
//                JasperPrint jprint = JasperFillManager.fillReport(jreport, a, con);
//                JasperViewer.viewReport(jprint);
// 
//            } catch (JRException ex) {
//                Logger.getLogger(pizza.class.getName()).log(Level.SEVERE, null, ex);
//            }
 
        } catch (SQLException ex) {
//            Logger.getLogger(pizza.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }
    
 
    
 
                                    
    // </editor-fold>

 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        RemoveButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        Preview = new javax.swing.JButton();
        Qty1 = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        Balance = new javax.swing.JTextPane();
        Payment = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LbSmall = new javax.swing.JRadioButton();
        LbMedian = new javax.swing.JRadioButton();
        LbLarge = new javax.swing.JRadioButton();
        LbExtraLarge = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Qty");

        RemoveButton.setText("Remove");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Payment");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Balance");

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        Preview.setText("Preview Invoice");
        Preview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviewActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(Balance);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setForeground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("Pizza Ordering System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        LbSmall.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbSmall.setText("Small");

        LbMedian.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbMedian.setText("Median");

        LbLarge.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbLarge.setText("Large");

        LbExtraLarge.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LbExtraLarge.setText("Extra Large");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbExtraLarge, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbLarge, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbSmall, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbMedian, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(LbSmall)
                .addGap(18, 18, 18)
                .addComponent(LbMedian)
                .addGap(18, 18, 18)
                .addComponent(LbLarge)
                .addGap(18, 18, 18)
                .addComponent(LbExtraLarge)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Price", "Qty", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Payment, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(Preview)
                        .addGap(66, 66, 66)
                        .addComponent(Qty1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(261, 261, 261))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Payment, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Preview, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Qty1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed

        model.removeRow(jTable1.getSelectedRow());

        int sum = 0;

        for(int a=0; a<jTable1.getRowCount(); a++)
        {
            sum = sum + Integer.parseInt(jTable1.getValueAt(a, 3).toString());
        }
        Total.setText(Integer.toString(sum));
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed

        if(LbSmall.isSelected() == true)
        {
            item = "Small";
            price = 200;
        }
        else if(LbMedian.isSelected() == true)
        {
            item = "Medium";
            price = 300;
        }
        else if(LbLarge.isSelected() == true)
        {
            item = "Large";
            price = 400;
        }
        else if(LbExtraLarge.isSelected() == true)
        {
            item = "ExLarge";
            price = 700;
        }

        int Qty = Integer.parseInt(Qty1.getValue().toString());
        int tot = Qty * price;

        model = (DefaultTableModel)jTable1.getModel();

        model.addRow(new Object[]

            {
                item,
                price,
                Qty,
                tot

            });
            int sum = 0;

            for(int a=0; a<jTable1.getRowCount(); a++)
            {
                sum = sum + Integer.parseInt(jTable1.getValueAt(a, 3).toString());
            }
            Total.setText(Integer.toString(sum));

    }//GEN-LAST:event_AddButtonActionPerformed

    private void PreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviewActionPerformed

        int tot = Integer.parseInt(Total.getText());
        int pay = Integer.parseInt(Payment.getText());

        int bal = pay - tot;

        Balance.setText(String.valueOf(bal));

        sales();

    }//GEN-LAST:event_PreviewActionPerformed

    public static void main(String args[]) {
       
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pizza1().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify                     



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextPane Balance;
    private javax.swing.JRadioButton LbExtraLarge;
    private javax.swing.JRadioButton LbLarge;
    private javax.swing.JRadioButton LbMedian;
    private javax.swing.JRadioButton LbSmall;
    private javax.swing.JTextField Payment;
    private javax.swing.JButton Preview;
    private javax.swing.JSpinner Qty1;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JTextField Total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
