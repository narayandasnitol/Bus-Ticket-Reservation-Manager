
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MubeenDev
 */
public class ConfirmTicket extends javax.swing.JFrame {

    /**
     * Creates new form ConfirmTicket
     */
    int paymentFlag=0;
    Connection connect=null;
    String a="",b="",c="",d="",e="",f="",h="",str="",priceStr="";
    int g=0,busNumber;
    
    public ConfirmTicket() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        connectDatabase();
    }
    
    public void connectDatabase(){
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost/busticket","root","");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cannot connect to database");
        }
    }
    
    public void initiliazeData(int ticketID,String seatType,String seatNumber,int busNumber,String route,int numberofTicket,String time,String journeyDate,String pickup,double price,String payment,String name){
        jLabel3.setText(jLabel3.getText()+" "+ticketID);
        String bus="";
        if(busNumber==1){
            bus="Bus1";
        }else if(busNumber==2){
            bus="Bus2";
        }else if(busNumber==3){
            bus="Bus3";
        }else if(busNumber==4){
            bus="Bus4";
        }
        jLabel4.setText(jLabel4.getText()+" "+bus);
        jLabel5.setText(jLabel5.getText()+" "+seatNumber);
        jLabel6.setText(jLabel6.getText()+" "+seatType);
        String[] arr=route.split("-");
        jLabel7.setText(jLabel7.getText()+" "+arr[0]);
        jLabel8.setText(jLabel8.getText()+" "+arr[1]);
        jLabel9.setText(jLabel9.getText()+" "+time);
        jLabel10.setText(jLabel10.getText()+" "+journeyDate);
        jLabel11.setText(jLabel11.getText()+" "+pickup);
        jLabel13.setText(jLabel13.getText()+" "+numberofTicket);
        jLabel12.setText(jLabel12.getText()+" "+price);
        jLabel1.setText(jLabel1.getText()+" "+payment);
        jLabel14.setText(jLabel14.getText()+" "+name);
        priceStr=price+"";
        if(payment.equals("Cash")){
            paymentFlag=1;
        }else if(payment.equals("Credit Card")){
            paymentFlag=2;
            jButton2.setText("Proceed to Payment");
        }
    }
    
    public void initializeInsertData(String a,String b,String c,String d,String e,String f,int g,String h,int busNumber,String str){
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
//            ConfirmTicket ob=new ConfirmTicket();
//            ob.initiliazeData(ticketCounter+1,b,c,busNumber,a,g,f,e,counter,price,h,staffName);
//            ob.setVisible(true);
//            dispose();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Payment type:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(460, 350, 280, 30);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ticket No:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 100, 190, 30);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Bus No:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 150, 190, 30);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seat No:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 200, 190, 30);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Seat Type:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 250, 260, 30);

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("From:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 300, 250, 30);

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("To:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 350, 230, 30);

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Journey Time:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(460, 100, 280, 30);

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Journey Date:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(460, 150, 290, 30);

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Pickup Point:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(460, 200, 290, 30);

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Price:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(460, 300, 260, 30);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Number of Tickets:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(460, 250, 280, 30);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 255, 255));
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(510, 500, 180, 30);

        jButton2.setBackground(new java.awt.Color(0, 102, 0));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 255, 255));
        jButton2.setText("Confirm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(140, 500, 180, 30);

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 255, 255));
        getContentPane().add(jLabel14);
        jLabel14.setBounds(460, 450, 240, 30);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tt.png"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(paymentFlag==1){
            insertData();
            JOptionPane.showMessageDialog(null, "Ticket booked successfully");
            AdminArea ob=new AdminArea();
            ob.setVisible(true);
            dispose();
        }else if(paymentFlag==2){
            Transaction ob=new Transaction();
            ob.initializeInsertData(a, b, c, d, e, f, g, h, busNumber,str,priceStr);
            ob.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AdminArea ob=new AdminArea();
        ob.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ConfirmTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
