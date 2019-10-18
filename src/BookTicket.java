
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class BookTicket extends javax.swing.JFrame {

    /**
     * Creates new form BookTicket
     */
    Connection connect = null;
    int id=0;
    int busNumber=0;
    String selectedSeats="";
    String[] availableSeat;
    String str="";
    
    public BookTicket() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        connectDatabase();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        jDateChooser1.setMinSelectableDate(date);
        jDateChooser2.setMinSelectableDate(date);
        jLabel1.setVisible(false);
        jLabel3.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
        jLabel18.setVisible(false);
        jLabel39.setVisible(false);
        jLabel40.setVisible(false);
        jLabel41.setVisible(false);
        jLabel42.setVisible(false);
        jLabel43.setVisible(false);
        jLabel44.setVisible(false);
        jLabel45.setVisible(false);
        jLabel46.setVisible(false);
        jLabel47.setVisible(false);
        jLabel48.setVisible(false);
        jLabel49.setVisible(false);
        jLabel50.setVisible(false);
        jLabel51.setVisible(false);
        jLabel52.setVisible(false);
        jLabel53.setVisible(false);
        jLabel54.setVisible(false);
        jLabel55.setVisible(false);
        jLabel56.setVisible(false);
        jLabel57.setVisible(false);
        jLabel58.setVisible(false);
        jPanel1.setVisible(false);
    }
    
    public void connectDatabase(){
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost/busticket","root","");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cannot connect to database");
        }
    }
    
    public void getSeatNumbers(){
        ResultSet resultSet = null;
        try{
            System.out.println("busnumber: "+busNumber);
            String query = "SELECT * FROM bus where busID="+busNumber;
            Statement statement ;
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                str=resultSet.getString("availableSeats");
            }
            availableSeat=str.split(" ");
            for(int i=0;i<availableSeat.length;i++){
                if(jLabel14.getText().toString().equals(availableSeat[i])){
                    jLabel14.setVisible(true);
                }else if(jLabel1.getText().toString().equals(availableSeat[i])){
                    jLabel1.setVisible(true);
                }else if(jLabel3.getText().toString().equals(availableSeat[i])){
                    jLabel3.setVisible(true);
                }else if(jLabel13.getText().toString().equals(availableSeat[i])){
                    jLabel13.setVisible(true);
                }else if(jLabel18.getText().toString().equals(availableSeat[i])){
                    jLabel18.setVisible(true);
                }else if(jLabel15.getText().toString().equals(availableSeat[i])){
                    jLabel15.setVisible(true);
                }else if(jLabel16.getText().toString().equals(availableSeat[i])){
                    jLabel16.setVisible(true);
                }else if(jLabel17.getText().toString().equals(availableSeat[i])){
                    jLabel17.setVisible(true);
                }else if(jLabel42.getText().toString().equals(availableSeat[i])){
                    jLabel42.setVisible(true);
                }else if(jLabel41.getText().toString().equals(availableSeat[i])){
                    jLabel41.setVisible(true);
                }else if(jLabel12.getText().toString().equals(availableSeat[i])){
                    jLabel12.setVisible(true);
                }else if(jLabel40.getText().toString().equals(availableSeat[i])){
                    jLabel40.setVisible(true);
                }else if(jLabel39.getText().toString().equals(availableSeat[i])){
                    jLabel39.setVisible(true);
                }else if(jLabel46.getText().toString().equals(availableSeat[i])){
                    jLabel46.setVisible(true);
                }else if(jLabel45.getText().toString().equals(availableSeat[i])){
                    jLabel45.setVisible(true);
                }else if(jLabel44.getText().toString().equals(availableSeat[i])){
                    jLabel44.setVisible(true);
                }else if(jLabel43.getText().toString().equals(availableSeat[i])){
                    jLabel43.setVisible(true);
                }else if(jLabel50.getText().toString().equals(availableSeat[i])){
                    jLabel50.setVisible(true);
                }else if(jLabel49.getText().toString().equals(availableSeat[i])){
                    jLabel49.setVisible(true);
                }else if(jLabel48.getText().toString().equals(availableSeat[i])){
                    jLabel48.setVisible(true);
                }else if(jLabel47.getText().toString().equals(availableSeat[i])){
                    jLabel47.setVisible(true);
                }else if(jLabel54.getText().toString().equals(availableSeat[i])){
                    jLabel54.setVisible(true);
                }else if(jLabel53.getText().toString().equals(availableSeat[i])){
                    jLabel53.setVisible(true);
                }else if(jLabel52.getText().toString().equals(availableSeat[i])){
                    jLabel52.setVisible(true);
                }else if(jLabel51.getText().toString().equals(availableSeat[i])){
                    jLabel51.setVisible(true);
                }else if(jLabel58.getText().toString().equals(availableSeat[i])){
                    jLabel58.setVisible(true);
                }else if(jLabel57.getText().toString().equals(availableSeat[i])){
                    jLabel57.setVisible(true);
                }else if(jLabel56.getText().toString().equals(availableSeat[i])){
                    jLabel56.setVisible(true);
                }else if(jLabel55.getText().toString().equals(availableSeat[i])){
                    jLabel55.setVisible(true);
                }
            }
        }catch(Exception e){
            System.out.println("Error in Query..");
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bus Ticket Reservation Manager");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(null);

        jLabel1.setText("A2");
        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 0, 22, 40);

        jLabel3.setText("A3");
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 0, 30, 40);

        jLabel13.setText("A4");
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13);
        jLabel13.setBounds(210, 10, 29, 20);

        jLabel14.setText("A1");
        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14);
        jLabel14.setBounds(30, 0, 30, 40);

        jLabel15.setText("B2");
        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15);
        jLabel15.setBounds(80, 40, 30, 30);

        jLabel16.setText("B3");
        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jLabel16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel16KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel16);
        jLabel16.setBounds(160, 40, 30, 30);

        jLabel17.setText("B4");
        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17);
        jLabel17.setBounds(210, 40, 30, 28);

        jLabel18.setText("B1");
        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel18);
        jLabel18.setBounds(30, 40, 28, 30);

        jButton3.setText("Cancel");
        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 255, 255));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(140, 280, 80, 27);

        jButton4.setText("OK");
        jButton4.setBackground(new java.awt.Color(0, 153, 51));
        jButton4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(153, 255, 255));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(60, 280, 60, 27);

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel39.setText("C4");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel39);
        jLabel39.setBounds(210, 80, 30, 28);

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel40.setText("C3");
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });
        jLabel40.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel40KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel40);
        jLabel40.setBounds(160, 80, 30, 30);

        jLabel41.setText("C2");
        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel41);
        jLabel41.setBounds(80, 80, 30, 30);

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel42.setText("C1");
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel42);
        jLabel42.setBounds(30, 80, 28, 30);

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel43.setText("D4");
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel43);
        jLabel43.setBounds(210, 120, 30, 28);

        jLabel44.setText("D3");
        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
        });
        jLabel44.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel44KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel44);
        jLabel44.setBounds(160, 120, 30, 30);

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel45.setText("D2");
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel45);
        jLabel45.setBounds(80, 120, 30, 30);

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel46.setText("D1");
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel46);
        jLabel46.setBounds(30, 120, 30, 30);

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel47.setText("E4");
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel47);
        jLabel47.setBounds(210, 160, 30, 28);

        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel48.setText("E3");
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });
        jLabel48.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel48KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel48);
        jLabel48.setBounds(160, 160, 30, 30);

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel49.setText("E2");
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel49MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel49);
        jLabel49.setBounds(80, 160, 30, 30);

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel50.setText("E1");
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel50);
        jLabel50.setBounds(30, 160, 27, 30);

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel51.setText("F4");
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel51);
        jLabel51.setBounds(210, 200, 30, 28);

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel52.setText("F3");
        jLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel52MouseClicked(evt);
            }
        });
        jLabel52.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel52KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel52);
        jLabel52.setBounds(160, 200, 30, 30);

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel53.setText("F2");
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel53);
        jLabel53.setBounds(80, 200, 30, 30);

        jLabel54.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel54.setText("F1");
        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel54);
        jLabel54.setBounds(30, 200, 25, 30);

        jLabel55.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel55.setText("G4");
        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel55);
        jLabel55.setBounds(210, 240, 30, 28);

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel56.setText("G3");
        jLabel56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel56MouseClicked(evt);
            }
        });
        jLabel56.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel56KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel56);
        jLabel56.setBounds(160, 240, 30, 30);

        jLabel57.setText("G2");
        jLabel57.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel57MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel57);
        jLabel57.setBounds(80, 240, 30, 30);

        jLabel58.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel58.setText("G1");
        jLabel58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel58MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel58);
        jLabel58.setBounds(30, 240, 29, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(290, 20, 260, 320);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrow.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 10, 50, 30);

        jLabel4.setText("Departure Time:");
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 204));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 240, 140, 30);

        jLabel5.setText("Issue Date:");
        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 204));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 290, 110, 30);

        jLabel6.setText("Seat Type:");
        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 204));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 140, 90, 30);

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(210, 340, 180, 30);

        jLabel7.setText("Journey Date:");
        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 255, 204));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 190, 140, 30);

        jLabel9.setText("Total Tickets:");
        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 255, 204));
        getContentPane().add(jLabel9);
        jLabel9.setBounds(60, 390, 130, 30);

        jLabel10.setText("Seat No:");
        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 255, 204));
        getContentPane().add(jLabel10);
        jLabel10.setBounds(60, 340, 110, 30);

        jLabel12.setText("Payment Type:");
        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 255));
        getContentPane().add(jLabel12);
        jLabel12.setBounds(590, 350, 140, 30);

        jTextField8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField8);
        jTextField8.setBounds(210, 390, 330, 30);

        jButton1.setText("Book");
        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 255, 255));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 500, 150, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Seat Type...", "Classic", "Economy" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(210, 140, 330, 30);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Route...", "Dhaka-Sylhet", "Dhaka-Rajshahi", "Dhaka-Chittagong", "Dhaka-Khulna" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(210, 90, 330, 30);

        jButton2.setText("Show Available Seats");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(400, 340, 150, 30);

        jLabel19.setText("Route:");
        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 255, 204));
        getContentPane().add(jLabel19);
        jLabel19.setBounds(60, 90, 120, 30);

        jLabel20.setText("Total Price:");
        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 255));
        getContentPane().add(jLabel20);
        jLabel20.setBounds(590, 190, 120, 30);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(590, 270, 170, 30);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Payment Type...", "Cash", "Credit Card" }));
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(590, 390, 170, 30);

        jButton5.setText("Calculate");
        jButton5.setBackground(new java.awt.Color(0, 102, 0));
        jButton5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 255, 255));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(590, 230, 93, 30);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bt1.png"))); // NOI18N
        getContentPane().add(jLabel21);
        jLabel21.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        AdminArea ob=new AdminArea();
        ob.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a="",b="",c="",d="",e="",f="",h="";
        int g=0;
        a=jComboBox2.getSelectedItem().toString();
        b=jComboBox1.getSelectedItem().toString();
        c=jTextField3.getText().toString();
        d= ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        System.out.println(d);
        e=((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();
        if(timePicker1.getText().contains("am")){
            String arr[]=timePicker1.getText().split(":");
            f=arr[0]+":"+(arr[1].replace("am",""))+":"+"00";
        }else if(timePicker1.getText().contains("pm")){
            String arr[]=timePicker1.getText().split(":");
            f=(12+Integer.parseInt(arr[0]))+":"+(arr[1].replace("pm",""))+":"+"00";
        }
        g=Integer.parseInt(jTextField8.getText().toString());
        h=jComboBox3.getSelectedItem().toString();
        if(a.equals("Choose Route...")){
            JOptionPane.showMessageDialog(null, "Please select route");
        }else if(b.equals("Choose Seat Type...")){
            JOptionPane.showMessageDialog(null, "Please select seat type");
        }else if(c.equals("")){
            JOptionPane.showMessageDialog(null, "Please select seat number");
        }else if(d.equals("")){
            JOptionPane.showMessageDialog(null, "Please select issue date");
        }else if(e.equals("")){
            JOptionPane.showMessageDialog(null, "Please select journey date");
        }else if(f.equals("")){
            JOptionPane.showMessageDialog(null, "Please select departure time");
        }else if(g==0){
            JOptionPane.showMessageDialog(null, "Please enter total number of tickets");
        }else if(h.equals("Select Payment Type...")){
            JOptionPane.showMessageDialog(null, "Please select payment type");
        }else{
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
//                String query = "INSERT INTO ticket (numberofTickets,seatType,journeyDate,price,seatNumber,issueDate,route,departureTime,paymentType) values(?,?,?,?,?,?,?,?,?)";
//                PreparedStatement pStatement = connect.prepareStatement(query);
//                pStatement.setInt(1, g);
//                pStatement.setString(2, b);
//                pStatement.setString(3, e);
//                pStatement.setDouble(4, price);
//                pStatement.setString(5, c);
//                pStatement.setString(6, d);
//                pStatement.setString(7, a);
//                pStatement.setString(8, f);
//                pStatement.setString(9, h);
//                pStatement.executeUpdate();
                String[] selectedSeat=jTextField3.getText().toString().split(" ");
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
                ConfirmTicket ob=new ConfirmTicket();
                ob.initiliazeData(ticketCounter+1,b,c,busNumber,a,g,f,e,counter,price,h,staffName);
                ob.initializeInsertData(a, b, c, d, e, f, g, h, busNumber,str);
                ob.setVisible(true);
                dispose();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Cannot insert in the database");
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jComboBox2.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Please select route first");
        }else{
            jPanel1.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void initializeSeatNumbers(String s){
        jTextField3.setText(s);
        jTextField3.revalidate();
    }
    
    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
        int a=jComboBox2.getSelectedIndex();
        busNumber=a;
        getSeatNumbers();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        jLabel1.setForeground(Color.BLUE);
        selectedSeats+=" A2";
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        jLabel3.setForeground(Color.BLUE);
        selectedSeats+=" A3";
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        jLabel13.setForeground(Color.BLUE);
        selectedSeats+=" A4";
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        jLabel14.setForeground(Color.BLUE);
        selectedSeats+=" A1";
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        jLabel15.setForeground(Color.BLUE);
        selectedSeats+=" B2";
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel16KeyPressed
        // TODO add your handling code here:\
    }//GEN-LAST:event_jLabel16KeyPressed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        jLabel17.setForeground(Color.BLUE);
        selectedSeats+=" B4";
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        jLabel18.setForeground(Color.BLUE);
        selectedSeats+=" B1";
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTextField3.setText(selectedSeats);
        jPanel1.setVisible(false);
        String[] counterStr=selectedSeats.split(" ");
        int counter=counterStr.length-1;
        jTextField8.setText(counter+"");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        // TODO add your handling code here:
        jLabel39.setForeground(Color.BLUE);
        selectedSeats+=" C4";
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel40KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel40KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel40KeyPressed

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        // TODO add your handling code here:
        jLabel41.setForeground(Color.BLUE);
        selectedSeats+=" C2";
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        // TODO add your handling code here:
        jLabel42.setForeground(Color.BLUE);
        selectedSeats+=" C1";
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        // TODO add your handling code here:
        jLabel43.setForeground(Color.BLUE);
        selectedSeats+=" D4";
    }//GEN-LAST:event_jLabel43MouseClicked

    private void jLabel44KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel44KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel44KeyPressed

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        // TODO add your handling code here:
        jLabel45.setForeground(Color.BLUE);
        selectedSeats+=" D2";
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        // TODO add your handling code here:
        jLabel46.setForeground(Color.BLUE);
        selectedSeats+=" D1";
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        // TODO add your handling code here:
        jLabel47.setForeground(Color.BLUE);
        selectedSeats+=" E4";
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jLabel48KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel48KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel48KeyPressed

    private void jLabel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseClicked
        // TODO add your handling code here:
        jLabel49.setForeground(Color.BLUE);
        selectedSeats+=" E2";
    }//GEN-LAST:event_jLabel49MouseClicked

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        // TODO add your handling code here:
        jLabel50.setForeground(Color.BLUE);
        selectedSeats+=" E1";
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        // TODO add your handling code here:
        jLabel51.setForeground(Color.BLUE);
        selectedSeats+=" F4";
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jLabel52KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel52KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel52KeyPressed

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
        // TODO add your handling code here:
        jLabel53.setForeground(Color.BLUE);
        selectedSeats+=" F2";
    }//GEN-LAST:event_jLabel53MouseClicked

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
        // TODO add your handling code here:
        jLabel54.setForeground(Color.BLUE);
        selectedSeats+=" F1";
    }//GEN-LAST:event_jLabel54MouseClicked

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
        // TODO add your handling code here:
        jLabel55.setForeground(Color.BLUE);
        selectedSeats+=" G4";
    }//GEN-LAST:event_jLabel55MouseClicked

    private void jLabel56KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel56KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel56KeyPressed

    private void jLabel57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel57MouseClicked
        // TODO add your handling code here:
        jLabel57.setForeground(Color.BLUE);
        selectedSeats+=" G2";
    }//GEN-LAST:event_jLabel57MouseClicked

    private void jLabel58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseClicked
        // TODO add your handling code here:
        jLabel58.setForeground(Color.BLUE);
        selectedSeats+=" G1";
    }//GEN-LAST:event_jLabel58MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        jLabel16.setForeground(Color.BLUE);
        selectedSeats+=" B3";
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
        jLabel40.setForeground(Color.BLUE);
        selectedSeats+=" C3";
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        // TODO add your handling code here:
        jLabel44.setForeground(Color.BLUE);
        selectedSeats+=" D3";
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
        jLabel48.setForeground(Color.BLUE);
        selectedSeats+=" E3";
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseClicked
        // TODO add your handling code here:
        jLabel52.setForeground(Color.BLUE);
        selectedSeats+=" F3";
    }//GEN-LAST:event_jLabel52MouseClicked

    private void jLabel56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel56MouseClicked
        // TODO add your handling code here:
        jLabel56.setForeground(Color.BLUE);
        selectedSeats+=" G3";
    }//GEN-LAST:event_jLabel56MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try{
            String priceQuery="";
            double price=0;
            String b=jComboBox1.getSelectedItem().toString();
            int g=Integer.parseInt(jTextField8.getText().toString());
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
            jTextField1.setText(price+"");
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
