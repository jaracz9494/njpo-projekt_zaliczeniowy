package projekt_zaliczeniowy;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.abs;
import java.util.Random;
import javax.swing.JOptionPane;

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
    
    public int wartosc=0, szansa;
    public int Mapx,Mapy;
    public int Statkicount=0, Pojazdycount=0;
    
    boolean start=true;
    boolean wpiszStatek=false, wpiszPojazd=false;
    boolean WCelu=false;
    boolean ustawianie=true;
    boolean statekisselected=false, pojazdisselected=false;
    
    Statek[] statki = new Statek[Singleton.inst().iloscStatkowSoj()];
    Pojazd[] pojazdy = new Pojazd[Singleton.inst().iloscPojazdowSoj()];
    
    Statek[] statkiwroga = new Statek[4];
    Pojazd[] pojazdywroga = new Pojazd[3];   
    
    public boolean Stateknachodzi() {
        
    for (int i=0; i<Pojazdycount; i++) {
        if (pojazdy[i].pozx==Mapx && pojazdy[i].pozy==Mapy) {
            return true;
        }
    }
        
    return false;
    }
    
      
    public void sprawdz() {                   
        
        if (Mapa.getValueAt(Mapy, Mapx)=="-") {
            wpiszStatek = true;
        } else {
            wpiszStatek = false;
        }
        
        if (Mapa.getValueAt(Mapy, Mapx)==null) {
            wpiszPojazd = true;
        } else {
            wpiszPojazd = false;
        }
        
        if (wpiszStatek) {
            wpiszStatek=false;
            
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

            
        if (wpiszPojazd) {
            wpiszPojazd=false;
            
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
    
    
    
    
    public void wybierz() {
        for (int i=0; i<Statkicount; i++) {
            if (statki[i].pozx==Mapx && statki[i].pozy==Mapy) {
                statekisselected=true;               
                wartosc = statki[i].id;
                Mapa.setSelectionBackground(Color.yellow);
            }
        }
        
        for (int i=0; i<Pojazdycount; i++) {
            if (pojazdy[i].pozx==Mapx && pojazdy[i].pozy==Mapy) {
                pojazdisselected=true;               
                wartosc = pojazdy[i].id;
                Mapa.setSelectionBackground(Color.yellow);
            }
        }
    }
    
    public void liczSzanse() {
        if (statekisselected) {
            szansa = 100-(abs(statki[wartosc].pozx-Mapx)+abs(statki[wartosc].pozy-Mapy))*10;            
        }
        
        if (pojazdisselected) {
            szansa = 100-(abs(pojazdy[wartosc].pozx-Mapx)+abs(pojazdy[wartosc].pozy-Mapy))*16;
        }
        
        if (szansa>100) {
            szansa=100;
        }
        if (szansa<0) {
            szansa=0;
        }
        
        SzansaTrafienia.setText(Integer.toString(szansa)+"%");
    }
    
    public void celuj() {
        
        if (statekisselected && !(statki[wartosc].pozx==Mapx && statki[wartosc].pozy==Mapy) && (Mapa.getValueAt(Mapy, Mapx)!="-" && Mapa.getValueAt(Mapy, Mapx)!=null)){
            Mapa.setSelectionBackground(Color.green);
            WCelu=true;              
        } else {
            if (pojazdisselected && !(pojazdy[wartosc].pozx==Mapx && pojazdy[wartosc].pozy==Mapy) && (Mapa.getValueAt(Mapy, Mapx)!="-" && Mapa.getValueAt(Mapy, Mapx)!=null)){
                Mapa.setSelectionBackground(Color.green);
                WCelu=true;               
            } else {
                if ((statekisselected && (statki[wartosc].pozx==Mapx && statki[wartosc].pozy==Mapy)) || pojazdisselected && (pojazdy[wartosc].pozx==Mapx && pojazdy[wartosc].pozy==Mapy)) {
                    Mapa.setSelectionBackground(Color.yellow);
                    WCelu=false;
                } else {
                    Mapa.setSelectionBackground(Color.red);
                    WCelu=false;
                }
            }
        }
        liczSzanse();
    }
    
    public void oznacz() {
        if (statekisselected && !(statki[wartosc].pozx==Mapx && statki[wartosc].pozy==Mapy) && Mapa.getValueAt(Mapy, Mapx)=="-" && (abs(statki[wartosc].pozx-Mapx)<2 && abs(statki[wartosc].pozy-Mapy)<2)){
            Mapa.setSelectionBackground(Color.green);
            wpiszStatek=true;
        } else {
            if (pojazdisselected && !(pojazdy[wartosc].pozx==Mapx && pojazdy[wartosc].pozy==Mapy) && Mapa.getValueAt(Mapy, Mapx)==null && (abs(pojazdy[wartosc].pozx-Mapx)<2 && abs(pojazdy[wartosc].pozy-Mapy)<2)){
                Mapa.setSelectionBackground(Color.green);
                wpiszPojazd=true;
            } else {
                if ((statekisselected && (statki[wartosc].pozx==Mapx && statki[wartosc].pozy==Mapy)) || pojazdisselected && (pojazdy[wartosc].pozx==Mapx && pojazdy[wartosc].pozy==Mapy)) {
                    Mapa.setSelectionBackground(Color.yellow);
                    wpiszStatek=false;
                    wpiszPojazd=false;
                } else {
                    Mapa.setSelectionBackground(Color.red);
                    wpiszStatek=false;
                    wpiszPojazd=false;
                }
            }
        }           
    }
    
    // USUNIETO Z SPODU W WARUNKU:
    //!(statki[wartosc].pozx==Mapx && statki[wartosc].pozy==Mapy) && Mapa.getValueAt(Mapy, Mapx)=="-"
    public void przesun() {
        if (statekisselected && wpiszStatek) {
            Mapa.setValueAt("-", statki[wartosc].pozy, statki[wartosc].pozx);
            statki[wartosc].setpozycje(Mapx, Mapy);
            Mapa.setValueAt("+"+statki[wartosc].typ, Mapy, Mapx);
            statekisselected=false;
            wpiszStatek=false;
        }
        
        if (pojazdisselected && wpiszPojazd) {
            Mapa.setValueAt(null, pojazdy[wartosc].pozy, pojazdy[wartosc].pozx);
            pojazdy[wartosc].setpozycje(Mapx, Mapy);
            Mapa.setValueAt("#"+pojazdy[wartosc].typ, Mapy, Mapx);
            pojazdisselected=false;
            wpiszPojazd=false;
        }
    }
    
    public void strzal() {
        if (WCelu) {
            Random r = new Random();
            
            if (r.nextInt(100)<szansa) {
            
                for (int i=0; i<statkiwroga.length; i++) {
                    if (statkiwroga[i].pozx==Mapx && statkiwroga[i].pozy==Mapy) {
                        statkiwroga[i].ustawtyp(statkiwroga[i].typ-1);
                        if (statkiwroga[i].typ==0) {
                            statkiwroga[i].setpozycje(100, 100);
                            Mapa.setValueAt("-", Mapy, Mapx);
                        } else {
                            Mapa.setValueAt("+"+statkiwroga[i].typ, Mapy, Mapx);
                        }
                    }
                }
                for (int i=0; i<pojazdywroga.length; i++) {
                    if (pojazdywroga[i].pozx==Mapx && pojazdywroga[i].pozy==Mapy) {
                        pojazdywroga[i].ustawtyp(pojazdywroga[i].typ-1);
                        if (pojazdywroga[i].typ==0) {
                            statkiwroga[i].setpozycje(100, 100);
                            Mapa.setValueAt(null, Mapy, Mapx);
                        } else {
                            Mapa.setValueAt("#"+pojazdywroga[i].typ, Mapy, Mapx);
                        }
                    } 
                } 
            } else {
                SzansaTrafienia.setText("PUDŁO!");
            }
            
        WCelu=false;    
        statekisselected=false;  
        pojazdisselected=false;
        
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
        SzansaTrafienia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        LiczbaOddanychStrzalow = new javax.swing.JLabel();
        LiczbaStrzalow = new javax.swing.JLabel();
        Zapisz = new javax.swing.JButton();
        Odczyt = new javax.swing.JButton();

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

    Maszt2.setText("2");

    Maszt3.setText("1");

    Maszt4.setText("1");

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

    Poj2.setText("2");

    Poj3.setText("2");

    Poj4.setText("1");

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

    SzansaTrafienia.setEditable(false);
    SzansaTrafienia.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            SzansaTrafieniaActionPerformed(evt);
        }
    });

    jTextArea1.setEditable(false);
    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jTextArea1.setText("BETAv0.21\n\tZasady:\nZnak: \"-\":\n-woda\n-mozna postawic na niej okręty \ni tylko one mogą się po niej poruszać\n\nZnak: \" \":\n-ziemia\n-analogicznie jak do okrętów \n(mogą na niej być tylko pojazdy) :)\n\nZnak: \"#1\":\n-od cyfry 1 do 4 oznacza\npojazd lądowy\n\nZnak: \"+1\":\n-od cyfry 1 do 4 oznacza\nokręt\n\nPo umieszczeniu wszystkich jednostek\nrozpoczyna się bitwa\n\nChwilowo z braku Sztucznej\nInteligencji przeciwnicy\numieszczeni są w lini: A\n\nRuch:\n-Pojazdy i Statki mogą się\nporuszyc tylko na odległość\n1 kratki.\nMożliwe przesuniecię\noznaczone jest polem ZIELONYM.\nNa pola koloru CZERWONEGO nie\nmożna się przemieścić.\n\nStrzał:\n-Po wybraniu jednostki\noznacza sie ona polem ŻÓŁTYM.\nPola ZIELONE oznaczają\nmożliwość oddania strzału.\nPola CZERWONE oznaczają brak\nstrzału.");
    jScrollPane2.setViewportView(jTextArea1);

    LiczbaOddanychStrzalow.setText("Liczba oddanych strzalow:");

    LiczbaStrzalow.setText("0");

    Zapisz.setText("Zapisz");
    Zapisz.setEnabled(false);
    Zapisz.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ZapiszActionPerformed(evt);
        }
    });

    Odczyt.setText("Odczyt");
    Odczyt.setEnabled(false);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(Akcja))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(Ruch)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LiczbaOddanychStrzalow, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Strzal)
                                .addComponent(SzansaTrafienia, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LiczbaStrzalow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Zapisz)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Odczyt)))))))
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)))
            .addGap(11, 11, 11)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Jednostki)
                .addComponent(Akcja))
            .addGap(17, 17, 17)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Masztowiec1)
                        .addComponent(Maszt1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pojazd1)
                        .addComponent(Poj1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Masztowiec2)
                        .addComponent(Maszt2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pojazd2)
                        .addComponent(Poj2)))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Ruch)
                        .addComponent(Strzal))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(SzansaTrafienia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Masztowiec3)
                .addComponent(Maszt3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Pojazd3)
                .addComponent(Poj3)
                .addComponent(LiczbaOddanychStrzalow))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Masztowiec4)
                .addComponent(Maszt4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Pojazd4)
                .addComponent(Poj4)
                .addComponent(LiczbaStrzalow))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Zapisz)
                .addComponent(Odczyt))
            .addContainerGap(29, Short.MAX_VALUE))
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

    private void MapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapaMouseClicked
    if (ustawianie) {    
        sprawdz();
        
        if (wpiszStatek) {
            
            statki[Statkicount] = new Statek();
            statki[Statkicount].ustaw(wartosc,Mapx,Mapy,Statkicount);
            Statkicount+=1;
            
            Mapa.setSelectionBackground(Color.green);
            //Mapa.setValueAt(wartosc, Mapa.getSelectedRow(), Mapa.getSelectedColumn());
            Mapa.setValueAt("+"+wartosc, Mapy, Mapx);
            
        }
        if (wpiszPojazd) {
            pojazdy[Pojazdycount] = new Pojazd();
            pojazdy[Pojazdycount].ustaw(wartosc,Mapx,Mapy,Pojazdycount);
            Pojazdycount+=1;
            
            Mapa.setSelectionBackground(Color.green);
            //Mapa.setValueAt(wartosc, Mapa.getSelectedRow(), Mapa.getSelectedColumn());
            Mapa.setValueAt("#"+wartosc, Mapy, Mapx);
        }
        
        if (Statkicount+Pojazdycount==statki.length+pojazdy.length) {
            
            ustawianie = false;            
            wpiszStatek=false;
            wpiszPojazd=false;
            Ruch.setEnabled(true);
            Strzal.setEnabled(true);
            Zapisz.setEnabled(true);
            Odczyt.setEnabled(true);
        }
        
    } else {        
        
        if (Ruch.isSelected()) {
            wybierz();
            przesun();
        }
        
        if (Strzal.isSelected() && !WCelu) {
            wybierz();
        }
        
        if (Strzal.isSelected() && WCelu) {
            strzal();
            LiczbaStrzalow.setText(Integer.toString(Integer.parseInt(LiczbaStrzalow.getText())+1));
            Mapa.setSelectionBackground(Color.BLUE);
        }
        
        
        
    }    
        //test.setText(Integer.toString(Mapa.getSelectedRow()));
        //test.setText(Mapa.getSelectionBackground().toString());
        
        //statki[Statkicount-1].wyswietl();
    }//GEN-LAST:event_MapaMouseClicked

    private void MapaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapaMouseMoved
        if (start) {
        pojazdywroga[0] = new Pojazd();
        pojazdywroga[0].ustaw(3,10,0,0); 
        pojazdywroga[1] = new Pojazd();
        pojazdywroga[1].ustaw(2,9,0,0);
        pojazdywroga[2] = new Pojazd();
        pojazdywroga[2].ustaw(1,9,0,0);
        
        statkiwroga[0] = new Statek();
        statkiwroga[0].ustaw(4,5,0,0);
        statkiwroga[1] = new Statek();
        statkiwroga[1].ustaw(3,4,0,0);
        statkiwroga[2] = new Statek();
        statkiwroga[2].ustaw(2,3,0,0);
        statkiwroga[3] = new Statek();
        statkiwroga[3].ustaw(1,2,0,0);
        
        start=false;
        }
        
        int x=21,y;       
        if (evt.getX()>20) {
            x=evt.getX();
        }
        y=evt.getY();
        
        Mapx = ((x-21)/25)+1;
        Mapy = y/16;        
        Mapa.changeSelection(Mapy, Mapx, false, false);
        
        
        if (!statekisselected && !pojazdisselected) {
            Mapa.setSelectionBackground(Color.BLUE);
        }
        
        if (statekisselected || pojazdisselected) {
            oznacz();
        }
        
        if (Strzal.isSelected() && (statekisselected || pojazdisselected)) {
            celuj();
        }
        
        
            //test.setText(Integer.toString(Mapy));
            //test.setText(Integer.toString(pojazdywroga[0].pozx));
        
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

    private void SzansaTrafieniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SzansaTrafieniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SzansaTrafieniaActionPerformed

    private void ZapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZapiszActionPerformed
        PrintWriter pw;
            try{
                FileWriter file = new FileWriter("zapis.txt", true);
                BufferedWriter out = new BufferedWriter(file);
                for (int i=0; i<Singleton.inst().iloscStatkowSoj(); i++) {
                    out.append(statki[i].dane());
                }  
                for (int i=0; i<Singleton.inst().iloscPojazdowSoj(); i++) {
                    out.append(pojazdy[i].dane());
                }
                out.newLine();
                out.close();

            } catch (IOException ex) {
                System.out.println ("Brak pliku");
            }
        JOptionPane.showMessageDialog(this, "Zapisano pod nazwą zapis.txt");
    }//GEN-LAST:event_ZapiszActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println();
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
    private javax.swing.JLabel LiczbaOddanychStrzalow;
    private javax.swing.JLabel LiczbaStrzalow;
    private javax.swing.JTable Mapa;
    public javax.swing.JLabel Maszt1;
    public javax.swing.JLabel Maszt2;
    public javax.swing.JLabel Maszt3;
    public javax.swing.JLabel Maszt4;
    public javax.swing.JRadioButton Masztowiec1;
    public javax.swing.JRadioButton Masztowiec2;
    public javax.swing.JRadioButton Masztowiec3;
    public javax.swing.JRadioButton Masztowiec4;
    private javax.swing.JButton Odczyt;
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
    private javax.swing.JTextField SzansaTrafienia;
    private javax.swing.JButton Zapisz;
    private javax.swing.ButtonGroup grupa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
