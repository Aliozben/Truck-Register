
import java.awt.Color;
import java.awt.Event;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ali
 */
public class FmTruckRegister extends javax.swing.JFrame {

    /**
     * Creates new form FmTruckRegister
     */
    
    public String Username;
    
    public FmTruckRegister() {
        initComponents();
        showTable();
        showTableWayout();
        PanelWayout.setVisible(false);
        PanelRegister.setVisible(false);
        SPTblWayoutTrucks.setVisible(false);
       
    }
     public void showTable(){
         try { 
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/DBtir","aliozben","410109");
           PreparedStatement ps =con.prepareStatement("SELECT RT_PLAKA, RT_DRIVER,RT_DATE, RT_REGISTERER, RT_WEIGHT FROM REGISTEREDTRUCKS");
            DefaultTableModel tm=(DefaultTableModel)TblRegisteredTrucks.getModel();
             tm.setRowCount(0);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){               
               Object o[]={rs.getString(1), rs.getString(2), rs.getDate(3),
                   rs.getString(4), rs.getInt(5)+" kg"};
               tm.addRow(o);
               
            }
             LblAracSayisi.setText("Iceride Bulunan Toplam Arac Sayisi : "+String.valueOf(tm.getRowCount()));
         }
         catch(Exception e){
             
         }
        
     }
     public void showTableWayout(){
           try { 
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/DBtir","aliozben","410109");
           PreparedStatement ps =con.prepareStatement("SELECT WOT_PLAKA, WOT_DRIVER,WOT_DATEENTERED,"
                   + " WOT_DATEWAYOUT, WOT_RAWWEIGHT,WOT_WEIGHT,WOT_PRODUCTWEIGHT FROM WAYOUTTRUCKS");
            DefaultTableModel tm=(DefaultTableModel)TblWayoutTrucks.getModel();
             tm.setRowCount(0);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){               
               Object o[]={rs.getString(1), rs.getString(2), rs.getDate(3),
                   rs.getDate(4), rs.getInt(5)+"Kg",rs.getInt(6)+"Kg",rs.getInt(7)+"Kg"};
               tm.addRow(o);
               
            }
            
         }
         catch(Exception e){
             System.out.println(e);
         }
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelRegister = new javax.swing.JPanel();
        TxtBoxPlaka = new javax.swing.JTextField();
        TxtBoxDriver = new javax.swing.JTextField();
        TxtBoxWeight = new javax.swing.JTextField();
        BtnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PanelHeader = new javax.swing.JPanel();
        LblDate = new javax.swing.JLabel();
        LblUser = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PanelButtons = new javax.swing.JPanel();
        BtnWayout = new javax.swing.JButton();
        BtnRegister = new javax.swing.JButton();
        PanelTable = new javax.swing.JPanel();
        LblAracSayisi = new javax.swing.JLabel();
        SpTblRegisteredTrucks = new javax.swing.JScrollPane();
        TblRegisteredTrucks = new javax.swing.JTable();
        LblTableHead = new javax.swing.JLabel();
        BtnShowWayoutTrucks = new javax.swing.JButton();
        BtnShowEnteredTrucks = new javax.swing.JButton();
        SPTblWayoutTrucks = new javax.swing.JScrollPane();
        TblWayoutTrucks = new javax.swing.JTable();
        TxtBoxDate1 = new javax.swing.JTextField();
        TxtBoxDate2 = new javax.swing.JTextField();
        BtnSearch = new javax.swing.JButton();
        BtnExit = new javax.swing.JButton();
        PanelWayout = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtBoxPlakaWO = new javax.swing.JTextField();
        TxtBoxDriverWO = new javax.swing.JTextField();
        TxtBoxWeightRawWO = new javax.swing.JTextField();
        TxtBoxWeightWO = new javax.swing.JTextField();
        TxtBoxWeightProductWO = new javax.swing.JTextField();
        BtnKaydetWO = new javax.swing.JButton();
        PanelWeight = new javax.swing.JPanel();
        lblWeight = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        TxtBoxWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBoxWeightKeyReleased(evt);
            }
        });

        BtnSave.setText("Save");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Plate Number :");

        jLabel2.setText("Driver");

        jLabel3.setText("Weight");

        javax.swing.GroupLayout PanelRegisterLayout = new javax.swing.GroupLayout(PanelRegister);
        PanelRegister.setLayout(PanelRegisterLayout);
        PanelRegisterLayout.setHorizontalGroup(
            PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegisterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelRegisterLayout.createSequentialGroup()
                        .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtBoxPlaka)
                            .addComponent(TxtBoxDriver)
                            .addComponent(TxtBoxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        PanelRegisterLayout.setVerticalGroup(
            PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegisterLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtBoxPlaka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtBoxDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtBoxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnSave))
        );

        LblDate.setText("jLabel5");

        LblUser.setText("Kullanici : ");

        jLabel4.setText("User :");

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblUser)
                .addGap(33, 33, 33)
                .addComponent(LblDate)
                .addContainerGap())
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblDate)
                    .addComponent(LblUser)
                    .addComponent(jLabel4)))
        );

        BtnWayout.setText("Truck Log Out");
        BtnWayout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnWayoutActionPerformed(evt);
            }
        });

        BtnRegister.setText("Turck Log In");
        BtnRegister.setToolTipText("");
        BtnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelButtonsLayout = new javax.swing.GroupLayout(PanelButtons);
        PanelButtons.setLayout(PanelButtonsLayout);
        PanelButtonsLayout.setHorizontalGroup(
            PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnWayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PanelButtonsLayout.setVerticalGroup(
            PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelButtonsLayout.createSequentialGroup()
                .addComponent(BtnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnWayout, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        LblAracSayisi.setText("Truck count :");

        TblRegisteredTrucks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plate Number", "Driver", "Login Date", "Person that loged in", "Weight"
            }
        ));
        TblRegisteredTrucks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblRegisteredTrucksMouseClicked(evt);
            }
        });
        SpTblRegisteredTrucks.setViewportView(TblRegisteredTrucks);

        LblTableHead.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LblTableHead.setLabelFor(TblRegisteredTrucks);
        LblTableHead.setText("Loged in Trucks ");
        LblTableHead.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnShowWayoutTrucks.setText("Loged out trucks");
        BtnShowWayoutTrucks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnShowWayoutTrucksActionPerformed(evt);
            }
        });

        BtnShowEnteredTrucks.setText("Loged in trucks");
        BtnShowEnteredTrucks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnShowEnteredTrucksActionPerformed(evt);
            }
        });

        TblWayoutTrucks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plate Number", "Driver", "Login Date", "Log out Date", "Truck Weight", "Total Weight", "Product Weight"
            }
        ));
        SPTblWayoutTrucks.setViewportView(TblWayoutTrucks);

        TxtBoxDate1.setText("YYYY-MM-DD");

        TxtBoxDate2.setText("YYYY-MM-DD");

        BtnSearch.setText("Search");
        BtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTableLayout = new javax.swing.GroupLayout(PanelTable);
        PanelTable.setLayout(PanelTableLayout);
        PanelTableLayout.setHorizontalGroup(
            PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SPTblWayoutTrucks)
                    .addComponent(SpTblRegisteredTrucks)
                    .addGroup(PanelTableLayout.createSequentialGroup()
                        .addComponent(BtnShowEnteredTrucks, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnShowWayoutTrucks, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTableLayout.createSequentialGroup()
                        .addComponent(LblAracSayisi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelTableLayout.createSequentialGroup()
                        .addComponent(LblTableHead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtBoxDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtBoxDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnSearch)))
                .addContainerGap())
        );
        PanelTableLayout.setVerticalGroup(
            PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblAracSayisi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTableHead)
                    .addComponent(TxtBoxDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtBoxDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SpTblRegisteredTrucks, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPTblWayoutTrucks, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnShowEnteredTrucks, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnShowWayoutTrucks, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        BtnExit.setText("EXIT");
        BtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExitActionPerformed(evt);
            }
        });

        jLabel5.setText("Plate Number :");

        jLabel6.setText("Driver :");

        jLabel7.setText("Login Weight");

        jLabel8.setText("Log out Weight");

        jLabel9.setText("Produckt Weight");

        TxtBoxPlakaWO.setEditable(false);

        TxtBoxDriverWO.setEditable(false);

        TxtBoxWeightRawWO.setEditable(false);

        TxtBoxWeightWO.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TxtBoxWeightWOInputMethodTextChanged(evt);
            }
        });
        TxtBoxWeightWO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBoxWeightWOActionPerformed(evt);
            }
        });
        TxtBoxWeightWO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtBoxWeightWOKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBoxWeightWOKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtBoxWeightWOKeyTyped(evt);
            }
        });

        TxtBoxWeightProductWO.setEditable(false);

        BtnKaydetWO.setText("Save");
        BtnKaydetWO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKaydetWOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelWayoutLayout = new javax.swing.GroupLayout(PanelWayout);
        PanelWayout.setLayout(PanelWayoutLayout);
        PanelWayoutLayout.setHorizontalGroup(
            PanelWayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelWayoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelWayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnKaydetWO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelWayoutLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(TxtBoxPlakaWO))
                    .addGroup(PanelWayoutLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(TxtBoxWeightProductWO, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                    .addGroup(PanelWayoutLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(TxtBoxDriverWO))
                    .addGroup(PanelWayoutLayout.createSequentialGroup()
                        .addGroup(PanelWayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(20, 20, 20)
                        .addGroup(PanelWayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtBoxWeightWO)
                            .addComponent(TxtBoxWeightRawWO))))
                .addContainerGap())
        );
        PanelWayoutLayout.setVerticalGroup(
            PanelWayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelWayoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelWayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtBoxPlakaWO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelWayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtBoxDriverWO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelWayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtBoxWeightRawWO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelWayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TxtBoxWeightWO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelWayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(TxtBoxWeightProductWO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnKaydetWO)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblWeight.setFont(new java.awt.Font("OCR A Std", 1, 48)); // NOI18N
        lblWeight.setText("0 Kg");

        javax.swing.GroupLayout PanelWeightLayout = new javax.swing.GroupLayout(PanelWeight);
        PanelWeight.setLayout(PanelWeightLayout);
        PanelWeightLayout.setHorizontalGroup(
            PanelWeightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
            .addGroup(PanelWeightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelWeightLayout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(lblWeight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(85, 85, 85)))
        );
        PanelWeightLayout.setVerticalGroup(
            PanelWeightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(PanelWeightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelWeightLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblWeight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(PanelWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PanelWayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(PanelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelWayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
       try{
        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/DBtir","aliozben","410109");
       PreparedStatement ps=con.prepareStatement("INSERT INTO REGISTEREDTRUCKS(RT_PLAKA,RT_DRIVER,RT_DATE,RT_REGISTERER,RT_WEIGHT)"
               + "VALUES(?,?,CURRENT_DATE,?,?)");
       ps.setString(1, TxtBoxPlaka.getText());
       ps.setString(2, TxtBoxDriver.getText());      
       ps.setString(3, Username);
       ps.setInt(4, Integer.parseInt(TxtBoxWeight.getText()));
       ps.execute();
       PreparedStatement ps2=con.prepareStatement("DELETE From WAYOUTTRUCKS Where WOT_PLAKA=?");
       ps2.setString(1, TxtBoxPlaka.getText());
       showTable();
       showTableWayout();
       }
       catch(Exception e){
        System.out.println(e);  //JOptionPane.showMessageDialog(this,"Giriş yapmış bir tırı tekrar giriş yapamazsınız.");
       }
        
    }//GEN-LAST:event_BtnSaveActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          date();
          LblUser.setText(Username);
          PanelHeader.setBackground(Color.orange);
          PanelWeight.setBackground(Color.orange);
          lblWeight.setForeground(Color.white);
          SPTblWayoutTrucks.resize(0, 0);
    }//GEN-LAST:event_formWindowOpened

    private void BtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegisterActionPerformed
       PanelRegister.setVisible(!PanelRegister.isVisible());
       PanelWayout.setVisible(false);
    }//GEN-LAST:event_BtnRegisterActionPerformed

    private void BtnKaydetWOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKaydetWOActionPerformed
        try{
        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/DBtir","aliozben","410109");
        PreparedStatement ps=con.prepareStatement("DELETE FROM REGISTEREDTRUCKS WHERE RT_PLAKA=?");
        ps.setString(1, TxtBoxPlakaWO.getText());
        ps.execute();
        PreparedStatement ps2=con.prepareStatement("INSERT INTO WAYOUTTRUCKS(WOT_PLAKA,WOT_DRIVER,WOT_DATEENTERED,WOT_DATEWAYOUT,"
                + "WOT_RAWWEIGHT,WOT_WEIGHT,WOT_PRODUCTWEIGHT)"
               + "VALUES(?,?,?,CURRENT_DATE,?,?,?)");
      
            
        ps2.setString(1, TxtBoxPlakaWO.getText());
        ps2.setString(2, TxtBoxDriverWO.getText());
        ps2.setString(3, date);
        ps2.setInt(4,Integer.parseInt(TxtBoxWeightRawWO.getText()));
        ps2.setInt(5,Integer.parseInt(TxtBoxWeightWO.getText()));
        ps2.setInt(6,Integer.parseInt(TxtBoxWeightProductWO.getText()));
        ps2.execute();
      
       
       showTable();
       showTableWayout();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_BtnKaydetWOActionPerformed

    private void BtnWayoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnWayoutActionPerformed
       PanelWayout.setVisible(!PanelWayout.isVisible());
       PanelRegister.setVisible(false);
    }//GEN-LAST:event_BtnWayoutActionPerformed
    
    String date;
    private void TblRegisteredTrucksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblRegisteredTrucksMouseClicked
        
        int selection = TblRegisteredTrucks.getSelectedRow();
         TxtBoxPlakaWO.setText(TblRegisteredTrucks.getValueAt(selection, 0).toString());
         TxtBoxDriverWO.setText(TblRegisteredTrucks.getValueAt(selection, 1).toString());
         
         date=TblRegisteredTrucks.getValueAt(selection, 2).toString();
         
         String x=TblRegisteredTrucks.getValueAt(selection, 4).toString();
         String nx="";
         for (int i = 0; i < x.length()-3; i++) {
            nx+=x.charAt(i);
        }
         TxtBoxWeightRawWO.setText(nx);
         lblWeight.setText(TblRegisteredTrucks.getValueAt(selection, 4).toString());
   // selection is now in terms of the underlying TableModel
    }//GEN-LAST:event_TblRegisteredTrucksMouseClicked

    private void TxtBoxWeightWOInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TxtBoxWeightWOInputMethodTextChanged
    }//GEN-LAST:event_TxtBoxWeightWOInputMethodTextChanged

    private void TxtBoxWeightWOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBoxWeightWOActionPerformed
    }//GEN-LAST:event_TxtBoxWeightWOActionPerformed

    private void TxtBoxWeightWOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBoxWeightWOKeyPressed
     
    }//GEN-LAST:event_TxtBoxWeightWOKeyPressed

    private void TxtBoxWeightWOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBoxWeightWOKeyReleased
      String xsd=TxtBoxWeightWO.getText();
      int lenght=xsd.length();
      try{
          int x=Integer.parseInt( TxtBoxWeightWO.getText());
          lblWeight.setText(TxtBoxWeightWO.getText()+" Kg");
      }
      catch(Exception e){
             try {
                 TxtBoxWeightWO.setText(TxtBoxWeightWO.getText(0, lenght-1));
                 lblWeight.setText(TxtBoxWeightWO.getText(0,lenght-1)+" Kg");
             } 
             catch (BadLocationException ex) {
                
             }
            
      }
       //lblWeight.setText(xsd+" Kg");
      TxtBoxWeightProductWO.setText(String.valueOf(Integer.parseInt(TxtBoxWeightWO.getText())-Integer.parseInt(TxtBoxWeightRawWO.getText())));
    }//GEN-LAST:event_TxtBoxWeightWOKeyReleased

    private void TxtBoxWeightWOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBoxWeightWOKeyTyped
    }//GEN-LAST:event_TxtBoxWeightWOKeyTyped

    private void BtnShowWayoutTrucksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnShowWayoutTrucksActionPerformed
        LblTableHead.setText("Çıkış Yapmış Araçlar :");
        SpTblRegisteredTrucks.setVisible(false);   
        SPTblWayoutTrucks.setVisible(true);
        
       
    }//GEN-LAST:event_BtnShowWayoutTrucksActionPerformed

    private void BtnShowEnteredTrucksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnShowEnteredTrucksActionPerformed
        LblTableHead.setText("İçerdeki Araçlar :");
        showTable();
        SpTblRegisteredTrucks.setVisible(true);
        SPTblWayoutTrucks.setVisible(false);
    }//GEN-LAST:event_BtnShowEnteredTrucksActionPerformed

    private void TxtBoxWeightKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBoxWeightKeyReleased
         String xsd=TxtBoxWeight.getText();
      int lenght=xsd.length();
      try{
          int x=Integer.parseInt( TxtBoxWeight.getText());
      }
      catch(Exception e){
             try {
                 TxtBoxWeight.setText(TxtBoxWeight.getText(0, lenght-1));
             } 
             catch (BadLocationException ex) {
                
             }
      }
      
    }//GEN-LAST:event_TxtBoxWeightKeyReleased

    private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_BtnExitActionPerformed

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
       try { 
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/DBtir","aliozben","410109");
            PreparedStatement ps=con.prepareStatement("SELECT RT_PLAKA, RT_DRIVER, RT_DATE, RT_REGISTERER,RT_WEIGHT FROM REGISTEREDTRUCKS "
                    + "WHERE RT_DATE BETWEEN ? AND ? ");
            ps.setDate(1, Date.valueOf(TxtBoxDate1.getText()));
            ps.setDate(2, Date.valueOf(TxtBoxDate2.getText()));
            DefaultTableModel tm=(DefaultTableModel)TblRegisteredTrucks.getModel();
             tm.setRowCount(0);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){               
               Object o[]={rs.getString(1), rs.getString(2), rs.getDate(3),
                   rs.getString(4), rs.getInt(5)+" kg"};
               tm.addRow(o);
               
            }
             LblAracSayisi.setText("Iceride Bulunan Toplam Arac Sayisi : "+String.valueOf(tm.getRowCount()));
         }
         catch(Exception e){
             System.out.println(e);
         }
       
    }//GEN-LAST:event_BtnSearchActionPerformed
     
    public void date(){
        Thread date=new Thread(){
            public void run(){
                try {
                    for(;;){
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
                        LocalDateTime now = LocalDateTime.now();  
                        LblDate.setText(dtf.format(now));
                    }
                } 
                catch (Exception e) {
                }
            }          
       };
       
       date.start();
    }
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
            java.util.logging.Logger.getLogger(FmTruckRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FmTruckRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FmTruckRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FmTruckRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FmTruckRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExit;
    private javax.swing.JButton BtnKaydetWO;
    private javax.swing.JButton BtnRegister;
    private javax.swing.JButton BtnSave;
    private javax.swing.JButton BtnSearch;
    private javax.swing.JButton BtnShowEnteredTrucks;
    private javax.swing.JButton BtnShowWayoutTrucks;
    private javax.swing.JButton BtnWayout;
    private javax.swing.JLabel LblAracSayisi;
    private javax.swing.JLabel LblDate;
    private javax.swing.JLabel LblTableHead;
    private javax.swing.JLabel LblUser;
    private javax.swing.JPanel PanelButtons;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JPanel PanelRegister;
    private javax.swing.JPanel PanelTable;
    private javax.swing.JPanel PanelWayout;
    private javax.swing.JPanel PanelWeight;
    private javax.swing.JScrollPane SPTblWayoutTrucks;
    private javax.swing.JScrollPane SpTblRegisteredTrucks;
    private javax.swing.JTable TblRegisteredTrucks;
    private javax.swing.JTable TblWayoutTrucks;
    private javax.swing.JTextField TxtBoxDate1;
    private javax.swing.JTextField TxtBoxDate2;
    private javax.swing.JTextField TxtBoxDriver;
    private javax.swing.JTextField TxtBoxDriverWO;
    private javax.swing.JTextField TxtBoxPlaka;
    private javax.swing.JTextField TxtBoxPlakaWO;
    private javax.swing.JTextField TxtBoxWeight;
    private javax.swing.JTextField TxtBoxWeightProductWO;
    private javax.swing.JTextField TxtBoxWeightRawWO;
    private javax.swing.JTextField TxtBoxWeightWO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblWeight;
    // End of variables declaration//GEN-END:variables
}
