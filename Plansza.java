package projekt_zaliczeniowy;

import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dominik
 */


public class Plansza extends javax.swing.JFrame {
    public int wartosc=0;
    public int Mapx,Mapy;
    public int Statkicount=0, Pojazdycount=0;
    
    boolean wpiszStatek=false;
    boolean wpiszPojazd=false;
    boolean ustawianie=true;
    
    Statek[] statki = new Statek[9];
    Pojazd[] pojazdy = new Pojazd[10];
    
    Statek[] statkiwroga = new Statek[5];
    Pojazd[] pojazdywroga = new Pojazd[6];
    
    public boolean Stateknachodzi() {
        
    for (int i=0; i<Pojazdycount; i++) {
        if (pojazdy[i].pozx==Mapx && pojazdy[i].pozy==Mapy) {
            return true;
        }
    }
        
    return false;
    }
    
      
    public void sprawdz() {
        try {
            
            int w=Integer.parseInt((Mapa.getValueAt(Mapy, Mapx).toString()));

            wpiszStatek=false;
            wpiszPojazd=false;
            Mapa.setSelectionBackground(Color.red);
            
        } catch (IllegalArgumentException e) {           
        
        wpiszPojazd=false;
        Mapa.setSelectionBackground(Color.red);
        
        if (Stateknachodzi()) {
            wpiszStatek=false;
        } else {
            
        if (Masztowiec1.isSelected()) {  
            
            if (Integer.parseInt(Maszt1.getText())==0) {
                wpiszStatek=false;  
            } else {
                wartosc=1;
                Maszt1.setText(Integer.toString(Integer.parseInt(Maszt1.getText())-1)); 
                if (Integer.parseInt(Maszt1.getText())==0) {
                    Masztowiec1.setEnabled(false);
                }
                wpiszStatek=true;
            }            
            
        }
        
        if (Masztowiec2.isSelected()) {  
            
            if (Integer.parseInt(Maszt2.getText())==0) {
                wpiszStatek=false;      
            } else {
                wartosc=2;
                Maszt2.setText(Integer.toString(Integer.parseInt(Maszt2.getText())-1));
                if (Integer.parseInt(Maszt2.getText())==0) {
                    Masztowiec2.setEnabled(false);
                }
                wpiszStatek=true;
            }            
            
        }
        
        if (Masztowiec3.isSelected()) {  
            
            if (Integer.parseInt(Maszt3.getText())==0) {
                wpiszStatek=false; 
            } else {
                wartosc=3;
                Maszt3.setText(Integer.toString(Integer.parseInt(Maszt3.getText())-1));
                if (Integer.parseInt(Maszt3.getText())==0) {
                    Masztowiec3.setEnabled(false);
                }
                wpiszStatek=true;
            }            
            
        }
        
        if (Masztowiec4.isSelected()) {  
            
            if (Integer.parseInt(Maszt4.getText())==0) {
                wpiszStatek=false; 
            } else {
                wartosc=4;
                Maszt4.setText(Integer.toString(Integer.parseInt(Maszt4.getText())-1));
                if (Integer.parseInt(Maszt4.getText())==0) {
                    Masztowiec4.setEnabled(false);
                }
                wpiszStatek=true;
            }            
            
        }
        }
        
        } catch (NullPointerException e) {
            
            wpiszStatek=false;
            Mapa.setSelectionBackground(Color.red);
            
            if (Pojazd1.isSelected()) {  
            
            if (Integer.parseInt(Poj1.getText())==0) {
                wpiszPojazd=false;           
            } else {
                wartosc=1;
                Poj1.setText(Integer.toString(Integer.parseInt(Poj1.getText())-1)); 
                if (Integer.parseInt(Poj1.getText())==0) {
                    Pojazd1.setEnabled(false);
                }
                wpiszPojazd=true;
            }            
            
        }
            if (Pojazd2.isSelected()) {  
            
            if (Integer.parseInt(Poj2.getText())==0) {
                wpiszPojazd=false;           
            } else {
                wartosc=2;
                Poj2.setText(Integer.toString(Integer.parseInt(Poj2.getText())-1));  
                if (Integer.parseInt(Poj2.getText())==0) {
                    Pojazd2.setEnabled(false);
                }
                wpiszPojazd=true;
            }            
            
        }       
            
            if (Pojazd3.isSelected()) {  
            
            if (Integer.parseInt(Poj3.getText())==0) {
                wpiszPojazd=false;           
            } else {
                wartosc=3;
                Poj3.setText(Integer.toString(Integer.parseInt(Poj3.getText())-1));  
                if (Integer.parseInt(Poj3.getText())==0) {
                    Pojazd3.setEnabled(false);
                }
                wpiszPojazd=true;
            }            
            
        }
            
            if (Pojazd4.isSelected()) {  
            
            if (Integer.parseInt(Poj4.getText())==0) {
                wpiszPojazd=false;           
            } else {
                wartosc=4;
                Poj4.setText(Integer.toString(Integer.parseInt(Poj4.getText())-1));
                if (Integer.parseInt(Poj4.getText())==0) {
                    Pojazd4.setEnabled(false);
                }
                wpiszPojazd=true;
            }            
            
        }
            
        }
        
    }
    

    
    
    

    /**
     * Creates new form Plansza
     */
    public Plansza() {
        initComponents();
        
        grupa.add(Masztowiec1);
        grupa.add(Masztowiec2);
        grupa.add(Masztowiec3);
        grupa.add(Masztowiec4);
        grupa.add(Pojazd1);
        grupa.add(Pojazd2);
        grupa.add(Pojazd3);
        grupa.add(Pojazd4);
        
        ActionGroup.add(Ruch);
        ActionGroup.add(Strzal);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupa = new javax.swing.ButtonGroup();
        ActionGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        Mapa = new javax.swing.JTable();
        Masztowiec1 = new javax.swing.JRadioButton();
        Masztowiec2 = new javax.swing.JRadioButton();
        Masztowiec3 = new javax.swing.JRadioButton();
        Masztowiec4 = new javax.swing.JRadioButton();
        Jednostki = new javax.swing.JLabel();
        Maszt1 = new javax.swing.JLabel();
        Maszt2 = new javax.swing.JLabel();
        Maszt3 = new javax.swing.JLabel();
        Maszt4 = new javax.swing.JLabel();
        test = new javax.swing.JTextField();
        test1 = new javax.swing.JLabel();
        Pojazd1 = new javax.swing.JRadioButton();
        Pojazd2 = new javax.swing.JRadioButton();
        Pojazd3 = new javax.swing.JRadioButton();
        Pojazd4 = new javax.swing.JRadioButton();
        Poj1 = new javax.swing.JLabel();
        Poj2 = new javax.swing.JLabel();
        Poj3 = new javax.swing.JLabel();
        Poj4 = new javax.swing.JLabel();
        Ruch = new javax.swing.JRadioButton();
        Strzal = new javax.swing.JRadioButton();
        Akcja = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Mapa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"A", "-", "+1", "+2", "+3", "+4", "-", "-", "#1", "#2", "#3", null, null, null, null, null, null, null, null, null, null, null, null},
                {"B", "-", "-", "-", "-", "-", "-", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"C", "-", "-", "-", "-", "-", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"D", "-", "-", "-", "-", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"E", "-", "-", "-", "-", "-", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"F", "-", "-", "-", "-", "-", "-", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"G", "-", "-", "-", "-", "-", "-", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"H", "-", "-", "-", "-", "-", "-", "-", "-", null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", null, null, null, null, null, null, null, null, null, null, null, null},
                {"J", "-", "-", "-", "-", "-", "-", "-", "-", null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"K", "-", "-", "-", "-", "-", "-", "-", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"L", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", null, null, null, null, null, null, null, null, null},
                {"M", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", null, null, null, null, null, null, null, null, null},
                {"N", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", null, null, null, null, null, null}
            },
            new String [] {
                "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    Mapa.setCellSelectionEnabled(true);
    Mapa.getTableHeader().setReorderingAllowed(false);
    Mapa.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        public void mouseMoved(java.awt.event.MouseEvent evt) {
            MapaMouseMoved(evt);
        }
    });
    Mapa.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            MapaMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(Mapa);

    Masztowiec1.setText("1-masztowiec  X");
    Masztowiec1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Masztowiec1ActionPerformed(evt);
        }
    });

    Masztowiec2.setText("2-masztowiec  X");
    Masztowiec2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Masztowiec2ActionPerformed(evt);
        }
    });

    Masztowiec3.setText("3-masztowiec  X");
    Masztowiec3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Masztowiec3ActionPerformed(evt);
        }
    });

    Masztowiec4.setText("4-masztowiec  X");
    Masztowiec4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Masztowiec4ActionPerformed(evt);
        }
    });

    Jednostki.setText("Jednostki");

    Maszt1.setText("3");

    Maszt2.setText("3");

    Maszt3.setText("2");

    Maszt4.setText("1");

    test.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            testActionPerformed(evt);
        }
    });

    Pojazd1.setText("Pojazd 1-osobowy  X");
    Pojazd1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Pojazd1ActionPerformed(evt);
        }
    });

    Pojazd2.setText("Pojazd 2-osobowy  X");

    Pojazd3.setText("Pojazd 3-osobowy  X");
    Pojazd3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Pojazd3ActionPerformed(evt);
        }
    });

    Pojazd4.setText("Pojazd 4-osobowy  X");

    Poj1.setText("3");

    Poj2.setText("3");

    Poj3.setText("2");

    Poj4.setText("2");

    Ruch.setText("Ruch");
    Ruch.setEnabled(false);
    Ruch.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            RuchActionPerformed(evt);
        }
    });

    Strzal.setText("Strzał");
    Strzal.setEnabled(false);

    Akcja.setText("Akcja");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Masztowiec1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Maszt1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Pojazd1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Poj1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Masztowiec3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Maszt3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Pojazd3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Poj3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Masztowiec2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Maszt2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Pojazd2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Poj2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Masztowiec4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Maszt4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Pojazd4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Poj4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(Jednostki)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Ruch)
                            .addGap(18, 18, 18)
                            .addComponent(Strzal))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(test1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(100, 100, 100))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(Akcja)
                    .addGap(222, 222, 222))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Jednostki)
                    .addGap(17, 17, 17))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(Akcja)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Masztowiec1)
                .addComponent(Maszt1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Pojazd1)
                .addComponent(Poj1)
                .addComponent(Ruch)
                .addComponent(Strzal))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Masztowiec2)
                .addComponent(Maszt2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Pojazd2)
                .addComponent(Poj2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Masztowiec3)
                .addComponent(Maszt3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Pojazd3)
                .addComponent(Poj3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Masztowiec4)
                .addComponent(Maszt4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Pojazd4)
                .addComponent(Poj4))
            .addGap(27, 27, 27)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(test)
                .addComponent(test1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Masztowiec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Masztowiec1ActionPerformed
        
               
    }//GEN-LAST:event_Masztowiec1ActionPerformed

    private void Masztowiec2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Masztowiec2ActionPerformed
        
        
    }//GEN-LAST:event_Masztowiec2ActionPerformed

    private void Masztowiec3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Masztowiec3ActionPerformed
        
        
    }//GEN-LAST:event_Masztowiec3ActionPerformed

    private void Masztowiec4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Masztowiec4ActionPerformed
        
        
    }//GEN-LAST:event_Masztowiec4ActionPerformed

    private void testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testActionPerformed

    private void MapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapaMouseClicked
    if (ustawianie) {    
        sprawdz();
        
        if (wpiszStatek) {
            
            statki[Statkicount] = new Statek();
            statki[Statkicount].ustaw(wartosc,Mapx,Mapy);
            Statkicount+=1;
            
            Mapa.setSelectionBackground(Color.green);
            //Mapa.setValueAt(wartosc, Mapa.getSelectedRow(), Mapa.getSelectedColumn());
            Mapa.setValueAt("+"+wartosc, Mapy, Mapx);
            
        }
        if (wpiszPojazd) {
            pojazdy[Pojazdycount] = new Pojazd();
            pojazdy[Pojazdycount].ustaw(wartosc,Mapx,Mapy);
            Pojazdycount+=1;
            
            Mapa.setSelectionBackground(Color.green);
            //Mapa.setValueAt(wartosc, Mapa.getSelectedRow(), Mapa.getSelectedColumn());
            Mapa.setValueAt("#"+wartosc, Mapy, Mapx);
        }
        
        if (Statkicount+Pojazdycount==19) {
            System.out.println("ok, do dzieła!");
            ustawianie = false;
            Ruch.setEnabled(true);
            Strzal.setEnabled(true);
        }
        
    } else {    
        System.out.println("yep");
        
    }    
        //test.setText(Integer.toString(Mapa.getSelectedRow()));
        //test.setText(Mapa.getSelectionBackground().toString());
        
        //statki[Statkicount-1].wyswietl();
    }//GEN-LAST:event_MapaMouseClicked

    private void MapaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapaMouseMoved
        
        int x=21,y;
        
        if (evt.getX()>20) {
            x=evt.getX();
        }
        y=evt.getY();
        
        Mapx = ((x-21)/25)+1;
        Mapy = y/16;
        
        //Mapa.setValueAt("#", Mapy, Mapx);
        //Mapa.addColumnSelectionInterval(Mapx, Mapx+1);
        Mapa.changeSelection(Mapy, Mapx, false, false);
        
            //test.setText(Integer.toString(y));

        
    }//GEN-LAST:event_MapaMouseMoved

    private void Pojazd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pojazd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pojazd1ActionPerformed

    private void Pojazd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pojazd3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pojazd3ActionPerformed

    private void RuchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RuchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RuchActionPerformed

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
            java.util.logging.Logger.getLogger(Plansza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Plansza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Plansza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Plansza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Plansza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ActionGroup;
    private javax.swing.JLabel Akcja;
    private javax.swing.JLabel Jednostki;
    private javax.swing.JTable Mapa;
    public javax.swing.JLabel Maszt1;
    public javax.swing.JLabel Maszt2;
    public javax.swing.JLabel Maszt3;
    public javax.swing.JLabel Maszt4;
    public javax.swing.JRadioButton Masztowiec1;
    public javax.swing.JRadioButton Masztowiec2;
    public javax.swing.JRadioButton Masztowiec3;
    public javax.swing.JRadioButton Masztowiec4;
    private javax.swing.JLabel Poj1;
    private javax.swing.JLabel Poj2;
    private javax.swing.JLabel Poj3;
    private javax.swing.JLabel Poj4;
    private javax.swing.JRadioButton Pojazd1;
    private javax.swing.JRadioButton Pojazd2;
    private javax.swing.JRadioButton Pojazd3;
    private javax.swing.JRadioButton Pojazd4;
    private javax.swing.JRadioButton Ruch;
    private javax.swing.JRadioButton Strzal;
    private javax.swing.ButtonGroup grupa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField test;
    private javax.swing.JLabel test1;
    // End of variables declaration//GEN-END:variables
}
