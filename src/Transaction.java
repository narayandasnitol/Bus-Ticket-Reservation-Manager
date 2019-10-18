
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MubeenDev
 */
public class Transaction extends javax.swing.JFrame {

    /**
     * Creates new form Transaction
     */
    
    String a="",b="",c="",d="",e="",f="",h="",str="";
    int g=0,busNumber;
    Connection connect=null;
    
    public Transaction() {
        initComponents();
        connectDatabase();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    public void connectDatabase(){
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost/busticket","root","");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cannot connect to database");
        }
    }
    
    public void initializeInsertData(String a,String b,String c,String d,String e,String f,int g,String h,int busNumber,String str,String price){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e;
        this.f=f;
        this.g=g;
        this.h=h;
        this.busNumber=busNumber;
        this.str=str;
        jTextField1.setText(price);
    }
    
    public void insertData(){
        try{
            String priceQuery="";
            double price=0;
            if(b.toLowerCase().equals("classic")){
                priceQuery="select priceClassic from bus where busID="+busNumber;
                Statement statement ;
                statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(priceQuery);
                if(resultSet.next()){
                    price=resultSet.getDouble("priceClassic");
                }
            }else if(b.toLowerCase().equals("economy")){
                priceQuery="select priceEconomy from bus where busID="+busNumber;
                Statement statement ;
                statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(priceQuery);
                if(resultSet.next()){
                    price=resultSet.getDouble("priceEconomy");
                }
            }
            price=price*g;
            String query = "INSERT INTO ticket (numberofTickets,seatType,journeyDate,price,seatNumber,issueDate,route,departureTime,paymentType) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pStatement = connect.prepareStatement(query);
            pStatement.setInt(1, g);
            pStatement.setString(2, b);
            pStatement.setString(3, e);
            pStatement.setDouble(4, price);
            pStatement.setString(5, c);
            pStatement.setString(6, d);
            pStatement.setString(7, a);
            pStatement.setString(8, f);
            pStatement.setString(9, h);
            pStatement.executeUpdate();
            String[] selectedSeat=c.split(" ");
            String newStr=str;
            for(int i=0;i<selectedSeat.length;i++){
                //System.out.println("selected seat "+selectedSeat[i]);
                //System.out.println("contains: "+str.contains(selectedSeat[i]));
                newStr=newStr.replace(selectedSeat[i], "");
            }
            //System.out.println("update seat "+newStr);
            String updateQuery="UPDATE bus SET availableSeats = ? where busID="+busNumber;
            PreparedStatement ps = connect.prepareStatement(updateQuery);
            ps.setString(1,newStr);
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Ticket booked successfully");
            String query1 = "SELECT ticketID FROM ticket";
            Statement statement ;
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query1);
            int ticketCounter=0;
            while(resultSet.next()){
                ticketCounter++;
            }
            MainMenu mn=new MainMenu();
            int staffID=mn.getID();
            String query2 = "SELECT * FROM staff WHERE staffID="+staffID;
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query2);
            String counter="",staffName="";
            if(resultSet.next()){
                counter=resultSet.getString("staffCounter");
                staffName=resultSet.getString("staffName");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Cannot insert in the database");
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Amount:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 400, 190, 40);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Payment Type:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 60, 150, 40);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Transaction No:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 130, 160, 40);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cardholder Name:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 200, 190, 40);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Card No:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 270, 190, 40);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Expiry Date:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 340, 190, 40);

        jRadioButton1.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(102, 255, 204));
        jRadioButton1.setText("Master Card");
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(560, 60, 170, 40);

        jRadioButton2.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(102, 255, 204));
        jRadioButton2.setText("Visa");
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(250, 60, 90, 40);

        jRadioButton3.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(102, 255, 204));
        jRadioButton3.setText("Credit Card");
        getContentPane().add(jRadioButton3);
        jRadioButton3.setBounds(370, 60, 170, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(250, 400, 270, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(250, 140, 270, 30);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(250, 210, 270, 30);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(250, 280, 270, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(510, 520, 170, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 0));
        jButton2.setText("Confirm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(120, 520, 160, 30);

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(250, 340, 270, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AdminArea ob=new AdminArea();
        ob.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String paymentType="";
        boolean select=false;
        if(jRadioButton1.isSelected()){
            paymentType="Master Card";
            select=true;
        }else if(jRadioButton2.isSelected()){
            paymentType="Visa";
            select=true;
        }else if(jRadioButton3.isSelected()){
            paymentType="Credit Card";
            select=true;
        }
        if(jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField3.getText().equals("") || jTextField4.getText().equals("") || ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        }else{
            try{
                String transactionNumber=jTextField2.getText().toString();
                String name=jTextField3.getText().toString();
                String cardNumber=jTextField4.getText().toString();
                String expire=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
                String amount=jTextField1.getText().toString();
                String query = "INSERT INTO transaction (transactionNumber,cardType,cardNumber,expiryDate,cardHolderName) values(?,?,?,?,?)";
                PreparedStatement pStatement = connect.prepareStatement(query);
                pStatement.setString(1, transactionNumber);
                pStatement.setString(2, paymentType);
                pStatement.setString(3, cardNumber);
                pStatement.setString(4, expire);
                pStatement.setString(5, amount);
                pStatement.executeUpdate();
                insertData();
                JOptionPane.showMessageDialog(null, "Ticket booked successfully");
                AdminArea ob=new AdminArea();
                ob.setVisible(true);
                dispose();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
