package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;


public class Bank extends JFrame implements ActionListener {

// ########################## ATTRIBUTES ######################################
    public static Scanner scan = new Scanner(System.in);                        // Scanner Object
    public static ArrayList<Customer> customers = new ArrayList<Customer>();  // this list contains customer objects
    
    // Variables used as flag
    private int isDuplicateID=0;                
    private int Gcheck=0;
    private int Gcheck2=0;
    
    // Variables for GUI
    private JPanel p0 = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();
    private JPanel p6 = new JPanel();
    private JPanel p7 = new JPanel();
    private JPanel p8 = new JPanel();

    private JButton back = new JButton("Back");
    private JButton b1,b2,b3,b4,b5,b6,b7,b8;
    private JButton b11,b21,b31,b41,b51,b61,b71,b81;
    
    private JLabel l11,l12,l13,l14,
           l21,l22,
           l31,
           l41,l42,l43,l44,l45,l46, 
           l51,l52,l53,l54,l55,l56, 
           l61,l62,l63,l64,l65,l66, 
           l71,l72,l73,l74,l75,l76,l77, 
           l81,l82,l83;
    
    private String s_ID   ,    s_Password,   s_show  ,   s_amount ,s_name  , s_surname   ,  s_IBAN  ,  s_newpassword;
    

    //##########################################################################################
    //####################################### GUI ##############################################
    //##########################################################################################

    //---------------------------------------------------- CONSTRUCTOR
    public Bank() throws FileNotFoundException, ClassNotFoundException, IOException{
        
        deserializeList();

        G_menu();
        
        this.setSize(300,500);
        this.setVisible(true);
        this.setLocation(500, 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        
        back.addActionListener(this);
        
    }   

    @SuppressWarnings("unchecked")
    public void deserializeList() throws FileNotFoundException, IOException, ClassNotFoundException {

        String fileName = "customers.dat";

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName))) {
            customers = (ArrayList<Customer>)reader.readObject();
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }


    public void serializeList() throws FileNotFoundException, IOException {

        String fileName = "customers.dat";

        try{
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));
            writer.writeObject(customers);
            writer.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }


    }
    

    public void G_menu(){
        
        this.setTitle("Menu");
        
        b1 = new JButton("Open Account");
        b2 = new JButton("Close Account");
        b3 = new JButton("Show Customer Information");
        b4 = new JButton("Deposit");
        b5 = new JButton("Withdraw");
        b6 = new JButton("Currency Exchange");
        b7 = new JButton("Transfer Money");
        b8 = new JButton("Change Password");
        
        p0.setVisible(true);
        p0.setLayout(new GridLayout(8,1));
        p0.setBackground(Color.black);
        
        p0.add(b1);p0.add(b2);p0.add(b3);p0.add(b4);
        p0.add(b5);p0.add(b6);p0.add(b7);p0.add(b8);
        
        b1.addActionListener(this);b1.setBackground(Color.decode("#77b5cc"));b1.setForeground(Color.decode("#651100"));
        b2.addActionListener(this);b2.setBackground(Color.decode("#77b5cc"));b2.setForeground(Color.decode("#651100"));             
        b3.addActionListener(this);b3.setBackground(Color.decode("#77b5cc"));b3.setForeground(Color.decode("#651100"));
        b4.addActionListener(this);b4.setBackground(Color.decode("#77b5cc"));b4.setForeground(Color.decode("#651100"));
        b5.addActionListener(this);b5.setBackground(Color.decode("#77b5cc"));b5.setForeground(Color.decode("#651100"));
        b6.addActionListener(this);b6.setBackground(Color.decode("#77b5cc"));b6.setForeground(Color.decode("#651100"));
        b7.addActionListener(this);b7.setBackground(Color.decode("#77b5cc"));b7.setForeground(Color.decode("#651100"));
        b8.addActionListener(this);b8.setBackground(Color.decode("#77b5cc"));b8.setForeground(Color.decode("#651100"));
        
        this.add(p0);
    }


    public void G_openAccount(){

        this.setTitle("Open Account");
        
        b11 = new JButton("Open"); 
        final JTextField t11 = new JTextField();
        final JTextField t12 = new JTextField();
        final JTextField t13 = new JTextField();
        final JTextField t14 = new JTextField();
        
        l11 = new JLabel("Name");
        l12 = new JLabel("Surname");
        l13 = new JLabel("ID");
        l14 = new JLabel("Password");
        
        p1.setVisible(true);
        p1.setLayout(null);
        p1.setBackground(Color.decode("#043671"));
        l11.setBounds(20, 20,75, 20);l11.setForeground(Color.decode("#ffe7ab"));
        t11.setBounds(110, 20, 100, 20);
        
        l12.setBounds(20, 60,75, 20);l12.setForeground(Color.decode("#ffe7ab"));
        t12.setBounds(110, 60, 100, 20);
        
        l13.setBounds(20, 100,75, 20);l13.setForeground(Color.decode("#ffe7ab"));
        t13.setBounds(110, 100, 100, 20);
        
        l14.setBounds(20, 140,75, 20);l14.setForeground(Color.decode("#ffe7ab"));
        t14.setBounds(110, 140, 100, 20);
        
        b11.setBounds(20, 180, 100, 30);
        
        p1.add(l11);p1.add(l12);p1.add(l13);p1.add(l14);
        p1.add(t11);p1.add(t12);p1.add(t13);p1.add(t14);
        p1.add(b11);
        
        back.setBounds(20, 360, 75, 20);
        
        this.add(p1);
        
        b11.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s_name=t11.getText();
                    s_surname=t12.getText();
                    s_ID=t13.getText();
                    s_Password=t14.getText();

                    try {
                        openAccount();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    if(isDuplicateID == 0){
                        JOptionPane.showMessageDialog(p1, "-Your account has been opened-");
                        t11.setText("");
                        t12.setText("");
                        t13.setText("");
                        t14.setText("");
                    }
                    else if(isDuplicateID == 1){
                        JOptionPane.showMessageDialog(p1, "-This ID is Duplicate. Choose another ID-");
                        t11.setText("");
                        t12.setText("");
                        t13.setText("");
                        t14.setText("");
                        isDuplicateID=0;
                    }
                }
            }
        );

        b11.addActionListener(this);
        p1.add(back);
                
    }


    public void G_CloseAccount(){

        this.setTitle("Close Account");
        
        b21 = new JButton("Close"); 
        final JTextField t21 = new JTextField();
        final JTextField t22 = new JTextField();
        
        l21 = new JLabel("ID");
        l22 = new JLabel("Password");
        p2.setVisible(true);
        p2.setLayout(null);
        p2.setBackground(Color.decode("#043671"));
        l21.setBounds(20, 20,75, 20);l21.setForeground(Color.decode("#ffe7ab"));
        t21.setBounds(110, 20, 100, 20);
        
        l22.setBounds(20, 60,75, 20);l22.setForeground(Color.decode("#ffe7ab"));
        t22.setBounds(110, 60, 100, 20);
        
        b21.setBounds(20, 110, 100, 30);
                
        p2.add(l21);p2.add(l22);
        p2.add(t21);p2.add(t22);
        p2.add(b21);
        this.add(p2);
        
        back.setBounds(20, 360, 75, 20);

        b21.addActionListener(new ActionListener() 
            {

                @Override
                public void actionPerformed(ActionEvent e) {
                
                    s_ID = t21.getText();
                    s_Password = t22.getText();
                    try {
                        closeAccount();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    if(Gcheck == 0){
                        JOptionPane.showMessageDialog(p2,"-Account Closed Succesfully.-");
                        t21.setText("");
                        t22.setText("");
                    }else if(Gcheck == 1){
                        JOptionPane.showMessageDialog(p2,"-The password or ID is incorrect-");
                        t21.setText("");
                        t22.setText("");

                        Gcheck = 0;
                    }
                }

            }
        
        );
        
        p2.add(back);
        b21.addActionListener(this);
    }


    public void G_ShowCustomerInformation(){
        
        this.setTitle("Show Customer Information");
        b31 = new JButton("Enter"); 

        final JTextField t31 = new JTextField();

        l31 = new JLabel("ID");
        p3.setVisible(true);
        p3.setLayout(null);
        p3.setBackground(Color.decode("#043671"));
        l31.setBounds(20, 20,75, 20);l31.setForeground(Color.decode("#ffe7ab"));
        t31.setBounds(110, 20, 100, 20);
        b31.setBounds(20, 110, 100, 30);
        p3.add(l31);
        p3.add(t31);
        p3.add(b31);
        this.add(p3);
        
        back.setBounds(20, 360, 75, 20);
        
        b31.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s_ID = t31.getText();

                    showCustomerInfo();

                    if(Gcheck == 0){
                        JOptionPane.showMessageDialog(p3,s_show);
                        t31.setText("");
                    }
                    else if(Gcheck == 1){
                        JOptionPane.showMessageDialog(p3, "The ID is wrong ,please try again ");
                        t31.setText("");
                        Gcheck = 0;
                    }
                }
            }
        );
        
        p3.add(back);
        b31.addActionListener(this);
    }

    
    public void G_Deposit(){

        this.setTitle("Deposit");
        b41 =  new JButton("Deposit");
        
        final JTextField t41 = new JTextField();
        final JTextField t42 = new JTextField();
        final JTextField t43 = new JTextField();
        
        l41 = new JLabel("ID");
        l42 = new JLabel("Password");
        l43 = new JLabel("Amount");
        l44 = new JLabel("Currency :");
        l45 = new JLabel("TL");
        l46 = new JLabel("USD");
        
        final JRadioButton r41 = new JRadioButton();
        final JRadioButton r42 = new JRadioButton();
        final ButtonGroup g41 = new ButtonGroup();
        
        p4.setVisible(true);
        p4.setLayout(null);
        p4.setBackground(Color.decode("#043671"));
        
        l41.setBounds(20, 20,75, 20);l41.setForeground(Color.decode("#ffe7ab"));
        t41.setBounds(110, 20, 100, 20);
        
        l42.setBounds(20, 60,75, 20);l42.setForeground(Color.decode("#ffe7ab"));
        t42.setBounds(110, 60, 100, 20);
        
        l43.setBounds(20, 100,75, 20);l43.setForeground(Color.decode("#ffe7ab"));
        t43.setBounds(110, 100, 100, 20);
        
        l44.setBounds(20, 140,75, 20);l44.setForeground(Color.decode("#ffe7ab"));
        
        l45.setBounds(20, 180 ,30, 20);l45.setForeground(Color.decode("#ffe7ab"));
        r41.setBounds(50, 180, 30, 30);r41.setBackground(Color.decode("#043671"));
        
        l46.setBounds(100, 180 ,30, 20);l46.setForeground(Color.decode("#ffe7ab"));
        r42.setBounds(130, 180, 30, 30);r42.setBackground(Color.decode("#043671"));
        
        b41.setBounds(20, 220, 100, 30);
        
        g41.add(r41);g41.add(r42);
        p4.add(l41);p4.add(l42);p4.add(l43);p4.add(l44);p4.add(l45);p4.add(l46);
        p4.add(t41);p4.add(t42);p4.add(t43);
        p4.add(r41);p4.add(r42);
        
        p4.add(b41);
        
        this.add(p4);
        back.setBounds(20, 360, 75, 20);
        
        b41.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s_ID = t41.getText();
                    s_Password = t42.getText();                                   //Deposit
                    s_amount = t43.getText();                             

                    if(r41.isSelected()){
                        Gcheck2=1;
                    }
                    else if(r42.isSelected()){
                        Gcheck2=2;
                    }

                    try {
                        deposit();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    if(Gcheck == 0){
                        JOptionPane.showMessageDialog(p4,"Deposit Succsesful");
                        t41.setText("");
                        t42.setText("");
                        t43.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(p4,"-The password or ID is incorrect-");
                        t41.setText("");
                        t42.setText("");
                        t43.setText("");
                        Gcheck=0;
                    }
                    Gcheck2=0;
                }
            }

        );
        
        b41.addActionListener(this);
        r41.addActionListener(this);r42.addActionListener(this);
        p4.add(back);
    }


    public void G_withdraw(){

        this.setTitle("Withdraw");
        b51 = new JButton("Withdraw");
        
        final JTextField t51 = new JTextField();
        final JTextField t52 = new JTextField();
        final JTextField t53 = new JTextField();
        
        l51 = new JLabel("ID");
        l52 = new JLabel("Password");
        l53 = new JLabel("Amount");
        l54 = new JLabel("Currency :");
        l55 = new JLabel("TL");
        l56 = new JLabel("USD");
        
        final JRadioButton r51 = new JRadioButton();
        final JRadioButton r52 = new JRadioButton();
        final ButtonGroup g51 = new ButtonGroup();
        
        p5.setVisible(true);
        p5.setLayout(null);
        p5.setBackground(Color.decode("#043671"));
        
        l51.setBounds(20, 20,75, 20);l51.setForeground(Color.decode("#ffe7ab"));
        t51.setBounds(110, 20, 100, 20);
        
        l52.setBounds(20, 60,75, 20);l52.setForeground(Color.decode("#ffe7ab"));
        t52.setBounds(110, 60, 100, 20);
        
        l53.setBounds(20, 100,75, 20);l53.setForeground(Color.decode("#ffe7ab"));
        t53.setBounds(110, 100, 100, 20);
        
        l54.setBounds(20, 140,75, 20);l54.setForeground(Color.decode("#ffe7ab"));
        
        l55.setBounds(20, 180 ,30, 20);l55.setForeground(Color.decode("#ffe7ab"));
        r51.setBounds(50, 180, 30, 30);r51.setBackground(Color.decode("#043671"));
        
        l56.setBounds(100, 180 ,30, 20);l56.setForeground(Color.decode("#ffe7ab"));
        r52.setBounds(130, 180, 30, 30);r52.setBackground(Color.decode("#043671"));
        
        b51.setBounds(20, 220, 100, 30);
        
        g51.add(r51);g51.add(r52);
        p5.add(l51);p5.add(l52);p5.add(l53);p5.add(l54);p5.add(l55);p5.add(l56);
        p5.add(t51);p5.add(t52);p5.add(t53);
        p5.add(r51);p5.add(r52);
        
        p5.add(b51);
        
        this.add(p5);
        back.setBounds(20, 360, 75, 20);
        
        b51.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s_ID=t51.getText();
                    s_Password=t52.getText();
                    s_amount=t53.getText();
                    if(r51.isSelected()){
                        Gcheck2=1;
                    }else if(r52.isSelected()){                         //Withdrow                             
                        Gcheck2=2;
                    }

                    try {
                        withdraw();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    
                    if(Gcheck==1){
                        JOptionPane.showMessageDialog(p5, "-The password or ID is incorrect-");
                        t51.setText("");
                        t52.setText("");
                        t53.setText("");
                        Gcheck=0;
                   }
                   t51.setText("");
                   t52.setText("");
                   t53.setText(""); 
                   Gcheck2=0;
                }
            }
        
        );
        
        
        b51.addActionListener(this);
        r51.addActionListener(this);r52.addActionListener(this);
        p5.add(back);
    }


    public void G_exchangeCurrency(){

        this.setTitle("exchangeCurrency");
        b61 = new JButton("Exchange");
        
        final JTextField t61 = new JTextField();
        final JTextField t62 = new JTextField();
        final JTextField t63 = new JTextField();
        
        l61 = new JLabel("ID");
        l62 = new JLabel("Password");
        l63 = new JLabel("Amount");
        l64 = new JLabel("Currency :");
        l65 = new JLabel("TL->USD ");
        l66 = new JLabel("USD->TL");
        
        final JRadioButton r61 = new JRadioButton();
        final JRadioButton r62 = new JRadioButton();
        final ButtonGroup g61 = new ButtonGroup();
        
        p6.setVisible(true);
        p6.setLayout(null);
        p6.setBackground(Color.decode("#043671"));
        
        l61.setBounds(20, 20,75, 20);l61.setForeground(Color.decode("#ffe7ab"));
        t61.setBounds(110, 20, 100, 20);
        
        l62.setBounds(20, 60,75, 20);l62.setForeground(Color.decode("#ffe7ab"));
        t62.setBounds(110, 60, 100, 20);
        
        l63.setBounds(20, 100,75, 20);l63.setForeground(Color.decode("#ffe7ab"));
        t63.setBounds(110, 100, 100, 20);
        
        l64.setBounds(20, 140,75, 20);l64.setForeground(Color.decode("#ffe7ab"));
        
        l65.setBounds(20, 180 ,60, 20);l65.setForeground(Color.decode("#ffe7ab"));
        r61.setBounds(80, 180, 30, 30);r61.setBackground(Color.decode("#043671"));
        
        l66.setBounds(120, 180 ,60, 20);l66.setForeground(Color.decode("#ffe7ab"));
        r62.setBounds(200, 180, 30, 30);r62.setBackground(Color.decode("#043671"));
        
        b61.setBounds(20, 220, 100, 30);
        
        g61.add(r61);g61.add(r62);
        p6.add(l61);p6.add(l62);p6.add(l63);p6.add(l64);p6.add(l65);p6.add(l66);
        p6.add(t61);p6.add(t62);p6.add(t63);
        p6.add(r61);p6.add(r62);
        
        p6.add(b61);
        
        this.add(p6);
        back.setBounds(20, 360, 75, 20);
        
        b61.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s_ID=t61.getText();
                    s_Password=t62.getText();
                    s_amount=t63.getText();
                    if(r61.isSelected()){
                        Gcheck2=1;
                    }
                    else if(r62.isSelected()){                         //Withdrow                             
                        Gcheck2=2;
                    }
                     
                    try {
                        exchangeCurrency();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    if(Gcheck==1){
                        JOptionPane.showMessageDialog(p5, "-The password or ID is incorrect-");
                        t61.setText("");
                        t62.setText("");
                        t63.setText("");
                        Gcheck=0;
                   }

                   t61.setText("");
                   t62.setText("");
                   t63.setText(""); 
                   Gcheck2=0;
                }
            }
        );
        
        b61.addActionListener(this);
        r61.addActionListener(this);r62.addActionListener(this);
        p6.add(back);
    }


    public void G_transferMoney(){
        
        this.setTitle("transferMoney");
        b71=new JButton("Transfer");
        
        final JTextField t71 = new JTextField();
        final JTextField t72 = new JTextField();
        final JTextField t73 = new JTextField();
        final JTextField t74 = new JTextField("TR");
        
        l71 = new JLabel("ID");
        l72 = new JLabel("Password");
        l73 = new JLabel("Amount");
        l74 = new JLabel("IBAN");
        l75 = new JLabel("Currency :");
        l76 = new JLabel("TL");
        l77 = new JLabel("USD");
        
        
        final JRadioButton r71 = new JRadioButton();
        final JRadioButton r72 = new JRadioButton();
        final ButtonGroup g71 = new ButtonGroup();
        
        p7.setVisible(true);
        p7.setLayout(null);
        p7.setBackground(Color.decode("#043671"));
        
        l71.setBounds(20, 20,75, 20);l71.setForeground(Color.decode("#ffe7ab"));
        t71.setBounds(110, 20, 100, 20);
        
        l72.setBounds(20, 60,75, 20);l72.setForeground(Color.decode("#ffe7ab"));
        t72.setBounds(110, 60, 100, 20);
        
        l73.setBounds(20, 100,75, 20);l73.setForeground(Color.decode("#ffe7ab"));
        t73.setBounds(110, 100, 100, 20);
        
        l74.setBounds(20, 140,75, 20);l74.setForeground(Color.decode("#ffe7ab"));
        t74.setBounds(110, 140,100,20);
        
        l75.setBounds(20, 165, 70, 20);l75.setForeground(Color.decode("#ffe7ab"));
        
        l76.setBounds(20, 200 ,40, 20);l76.setForeground(Color.decode("#ffe7ab"));
        r71.setBounds(80, 200, 30, 30);r71.setBackground(Color.decode("#043671"));
        
        l77.setBounds(120, 200 ,40, 20);l77.setForeground(Color.decode("#ffe7ab"));
        r72.setBounds(200, 200, 30, 30);r72.setBackground(Color.decode("#043671"));
        
        b71.setBounds(20, 250, 100, 30);
        
        g71.add(r71);g71.add(r72);
        p7.add(l71);p7.add(l72);p7.add(l73);p7.add(l74);p7.add(l75);p7.add(l76);p7.add(l77);
        p7.add(t71);p7.add(t72);p7.add(t73);p7.add(t74);
        p7.add(r71);p7.add(r72);
        
        p7.add(b71);
        
        this.add(p7);
        back.setBounds(20, 360, 75, 20);
        
        b71.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s_ID=t71.getText();
                    s_Password=t72.getText();
                    s_amount=t73.getText();
                    s_IBAN= t74.getText();

                    if(r71.isSelected()){
                        Gcheck2=1;
                    }
                    else if(r72.isSelected()){                         //Withdrow                             
                        Gcheck2=2;
                    }

                    try {
                        transferMoney();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    
                    if(Gcheck==1){
                        JOptionPane.showMessageDialog(p5, "-The password or ID is incorrect-");
                        t71.setText("");
                        t72.setText("");
                        t73.setText("");
                        t74.setText("TR");
                        Gcheck=0;
                   }
                   t71.setText("");
                   t72.setText("");
                   t73.setText("");
                   t74.setText("TR");
                   Gcheck2=0;

                }
            }
        );
        
        b71.addActionListener(this);
        r71.addActionListener(this);r72.addActionListener(this);
        p7.add(back);
    }


    public void G_changePassword(){
        
        this.setTitle("changePassword");
        b81=new JButton("Change");
        
        final JTextField t81=new JTextField();
        final JTextField t82=new JTextField();
        final JTextField t83=new JTextField();
        
        l81 =new JLabel("ID");
        l82 =new JLabel("Password");
        l83 =new JLabel("New Password");
        
        
        p8.setVisible(true);
        p8.setLayout(null);
        p8.setBackground(Color.decode("#043671"));
        
        l81.setBounds(20, 20,100, 20);l81.setForeground(Color.decode("#ffe7ab"));
        t81.setBounds(120, 20, 100, 20);
        
        l82.setBounds(20, 60,100, 20);l82.setForeground(Color.decode("#ffe7ab"));
        t82.setBounds(120, 60, 100, 20);
        
        l83.setBounds(20, 100,100, 20);l83.setForeground(Color.decode("#ffe7ab"));
        t83.setBounds(120, 100, 100, 20);
        
        b81.setBounds(20, 220, 100, 30);
        
        p8.add(l81);p8.add(l82);p8.add(l83);
        p8.add(t81);p8.add(t82);p8.add(t83);
        
        p8.add(b81);
        
        this.add(p8);
        back.setBounds(20, 360, 75, 20);
        
        b81.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s_ID=t81.getText();
                    s_Password=t82.getText();
                    s_newpassword=t83.getText();

                    try {
                        changePassword();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    if(Gcheck==1){
                        JOptionPane.showMessageDialog(p8, "-The password or ID is incorrect-");
                        t81.setText("");
                        t82.setText("");
                        t83.setText("");
                        Gcheck=0;
                   }
                    t81.setText("");
                    t82.setText("");
                    t83.setText("");

                }
            }
        
        );
        
        b81.addActionListener(this);
        
        p8.add(back);

    }
    

 
//####################################################################################################
//######################### METHODS ##################################################################
//####################################################################################################

//-------------------------------------------------------------------- openAccount
    public  void openAccount() throws FileNotFoundException, IOException {
        String name, surName, ID, password;
        name = s_name;
        surName = s_surname;
        ID = s_ID;
        password = s_Password;
        
        for(Customer c : customers) {
            if(c.getID().equals(ID))
                isDuplicateID=1;
        }
                
        if(isDuplicateID==0){
            Customer newCustomer = new Customer(name, surName, ID, password);   // create new Customer object
            customers.add(newCustomer);
            serializeList();
        }
        
    }

//------------------------------------------------------------ closeAccount
    public  void closeAccount() throws FileNotFoundException, IOException {
        Customer tmpCustomer;
        tmpCustomer = userLogin();
        // check if login was successful
        if (tmpCustomer != null) {
            customers.remove(tmpCustomer);
            serializeList();
        }
    }

//-------------------------------------------------------- showCustomerInfo
    public  void showCustomerInfo() {
        String ID;
        Customer tmpCustomer = null;
        ID = s_ID;
        tmpCustomer = searchCustomerByID(ID);

        // check if customer with this ID exists
        if (tmpCustomer != null) {
            
            s_show=("\nAccount Owner = " + tmpCustomer.getName() +" "+ tmpCustomer.getSurName()
                            +"\n ID = " + tmpCustomer.getID() 
                            +"\nPassword = " + tmpCustomer.getPassword()
                            +"\nIBAN = " + tmpCustomer.account.getIBAN()    
                            +"\nTL Balance = " + tmpCustomer.account.getBalanceTL()
                            +"\nUSD Balance = " + tmpCustomer.account.getBalanceUSD()    
            );
        }
        else{
            Gcheck=1;
        }
        

    }

//--------------------------------------------------------------- deposit
    public  void deposit() throws FileNotFoundException, IOException {

        String amount;
        Customer tmpCustomer=null;
        tmpCustomer = userLogin();
        
        

        // check if login was successful
        if (tmpCustomer != null) {
            
            amount = s_amount;
            
            // if the currency is TL
            if (Gcheck2==1) {
                tmpCustomer.account.depositBalanceTL(Integer.parseInt(amount));
                serializeList();
            }
            // if the currency is USD
            else if (Gcheck2==2) {
                tmpCustomer.account.depositBalanceUSD(Integer.parseInt(amount));
                serializeList();
            }
        }
        
        

    }

//--------------------------------------------------------------------- withdraw
    public  void withdraw() throws FileNotFoundException, IOException {
        String amount;
        Customer tmpCustomer=null;
        tmpCustomer = userLogin();
        amount = s_amount;
        // check if login was successful
        if (tmpCustomer != null) {
            //if the currency is TL
            if (Gcheck2==1) {    
                
                if (Integer.parseInt(amount) <= tmpCustomer.account.getBalanceTL()) {
                    tmpCustomer.account.withdrawBalanceTL(Integer.parseInt(amount));
                    JOptionPane.showMessageDialog(p5,"-Withdraw Succesful-");
                    serializeList();
                }
                else {
                    JOptionPane.showMessageDialog(p5, "Balance is not Enough!\nCurrent Balance = " + tmpCustomer.account.getBalanceTL());
                }
                 
            }
                
            // if the currency is USD
            else if (Gcheck2==2) {
                
                if (Integer.parseInt(amount) <= tmpCustomer.account.getBalanceUSD()) {
                    tmpCustomer.account.withdrawBalanceUSD(Integer.parseInt(amount));
                    JOptionPane.showMessageDialog(p5,"Withdraw Succsesful");
                    serializeList();
                }
                else{
                    JOptionPane.showMessageDialog(p5, "Balance is not Enough!\nCurrent Balance = " + tmpCustomer.account.getBalanceUSD());
                }
                    

            }
        }
        
        
        
    }

//------------------------------------------------------------- exchangeCurrency
    public  void exchangeCurrency() throws FileNotFoundException, IOException {
        String  amount;
        Customer tmpCustomer=null;
        
        tmpCustomer = userLogin();

        // check if login was successful
        if (tmpCustomer != null) {
            amount = s_amount;
            if (Gcheck2==1){
                    
                //if customer has enough TL balance
                if (Integer.parseInt(amount) <= tmpCustomer.account.getBalanceTL()) {
                    tmpCustomer.account.convertToUSD(Integer.parseInt(amount));
                    JOptionPane.showMessageDialog(p6, "Successful Exchange.");
                    serializeList();
                }
                else JOptionPane.showMessageDialog(p6, "Your Balance is not Enough!");
                    
            }
                
            // if convert USD to TL
            else if (Gcheck2==2) {
                if (Integer.parseInt(amount) <= tmpCustomer.account.getBalanceUSD()) {
                    tmpCustomer.account.convertToTL(Integer.parseInt(amount));
                    JOptionPane.showMessageDialog(p6, "Successful Exchange.");
                    serializeList();
                }
                else JOptionPane.showMessageDialog(p6, "Your Balance is not Enough!");
            }    
            
            
        } 

    }
        
//--------------------------------------------------------------- transferMoney
    public  void transferMoney() throws FileNotFoundException, IOException {
        String  amount, IBAN ;
        Customer tmpCustomer=null, receiver=null;
        
        tmpCustomer = userLogin();

        // check if login was successful
        if (tmpCustomer != null) {
            
            amount = s_amount;
            IBAN = s_IBAN;
            receiver = searchCustomerByIBAN(IBAN);
            // Send TL
            if (Gcheck2==1) {

                //if customer has enough TL balance
                if (Integer.parseInt(amount) <= tmpCustomer.account.getBalanceTL()) {
                    
                    //check if receiver with this IBAN number exists
                    if (receiver != null) {
                        receiver.account.depositBalanceTL(Integer.parseInt(amount));
                        tmpCustomer.account.withdrawBalanceTL(Integer.parseInt(amount));
                        
                        JOptionPane.showMessageDialog(p7, "Successful Tarsnfer.");
                        serializeList();
                    }
                    else JOptionPane.showMessageDialog(p7, "Wrong IBAN!");

                }
                else JOptionPane.showMessageDialog(p7, "Your Balance is not Enough!");
            }

            // Send USD
            else if (Gcheck2==2) {
                //if customer has enough USD balance
                if (Integer.parseInt(amount) <= tmpCustomer.account.getBalanceUSD()) {
                                        
                    //check if receiver with this IBAN number exists
                    if (receiver != null) {
                        
                        receiver.account.depositBalanceUSD(Integer.parseInt(amount));
                        tmpCustomer.account.withdrawBalanceUSD(Integer.parseInt(amount));
                        
                        JOptionPane.showMessageDialog(p7, "Successful Tarsnfer.");
                        serializeList();
                    }
                    else JOptionPane.showMessageDialog(p7, "Wrong IBAN!");
                        
                }
                else JOptionPane.showMessageDialog(p7, "Your Balance is not Enough!");

            }
            

        } 
        
        
    }

    public  void changePassword() throws FileNotFoundException, IOException {
        Customer tmpCustomer=null;
        String newPassword;
        
        tmpCustomer = userLogin();
        newPassword = s_newpassword;
        
        if (tmpCustomer != null) {
            
            tmpCustomer.setPassword(newPassword);

            //  check if password is changed successfully
            if (tmpCustomer.getPassword().equals(newPassword)) {
               
                JOptionPane.showMessageDialog(p8,"Changed successfully");
                serializeList();
            }
            else JOptionPane.showMessageDialog(p8,"Something went Wrong");
        }

    }
    
//------------------------------------------------------------- searchCustomerByID
    public  Customer searchCustomerByID(String ID) {
        int i=0;
        boolean found=false;
        Customer tmpCustomer=null;

        while (i < customers.size() && !found) {
            if (ID.equals(customers.get(i).getID())) {
                tmpCustomer = customers.get(i);
                found = true;
            }
            i++;
        }
        return tmpCustomer;   // returns null if Customer is not found 
    }

//------------------------------------------------------------- searchCustomerByIBAN
    public  Customer searchCustomerByIBAN(String IBAN) {
        int i=0;
        boolean found=false;
        Customer tmpCustomer=null;

        while (i < customers.size() && !found) {
            if (IBAN.equals(customers.get(i).account.getIBAN())) {
                tmpCustomer = customers.get(i);
                found = true;
            }
            i++;
        }

        return tmpCustomer;   // returns null if Customer is not found 
    }

//------------------------------------------------------------------------ checkPassword
    public  boolean checkPassword(Customer c, String password) {
        if (c.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

//--------------------------------------------------------- userLogin

    public  Customer userLogin() {        // this method returns Customer object of the given ID and password
        Customer tmpCustomer=null;
        String ID, password;
        
        ID = s_ID;
        password = s_Password;

        tmpCustomer = searchCustomerByID(ID);

        // check if customer with thid ID exists
        if (tmpCustomer != null   &&    checkPassword(tmpCustomer, password) ) {
            return tmpCustomer;                     // if login was successful , return Customer object
        }
        Gcheck=1;
        return null;    // if login was unsuccessful , return null
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
        
        //////////////////////////////////////////////////////////////////////////////////
        
        if(e.getSource()==b1){
            p0.setVisible(false);          
            G_openAccount();
            
        }
        //////////////////////////////////////////////////////////////////////////////////////
        
        if(e.getSource()==b2){
            p0.setVisible(false);           
            G_CloseAccount();
        }
        
        
        /////////////////////////////////////////////////////////////////////////////////////
        if(e.getSource()==b3){              
            p0.setVisible(false);
            G_ShowCustomerInformation();                               
        }
        
        //////////////////////////////////////////////////////////////////////////////////////////
        if(e.getSource()==b4){                                              
            p0.setVisible(false);
            G_Deposit();  
        }
        
        /////////////////////////////////////////////////////////////////////////////////////
        
        if(e.getSource()==b5){
            p0.setVisible(false);
            G_withdraw();
        }
        
        ///////////////////////////////////////////////////////////////////////////////////////////
        if(e.getSource()==b6){
            p0.setVisible(false);
            G_exchangeCurrency();
        }
        
        //////////////////////////////////////////////////////////////////////////////////////////
        if(e.getSource()==b7){
            p0.setVisible(false);
            G_transferMoney();
        }

        /////////////////////////////////////////////////////////////////////////////////////////
        if(e.getSource()==b8){
            p0.setVisible(false);
            G_changePassword();
        }

        //////////////////////////////////////////////////////////////////////////////////////////////
        if(e.getSource()  == back){
                p1.setVisible(false);
                p2.setVisible(false);
                p3.setVisible(false);                                                      
                p4.setVisible(false);
                p5.setVisible(false);
                p6.setVisible(false);
                p7.setVisible(false);                                      //back                   
                p8.setVisible(false);

                p0.setVisible(true);
            
            
         }
        ////////////////////////////////////////////////////////////////////////////////////////////
        
    }

    
    
}