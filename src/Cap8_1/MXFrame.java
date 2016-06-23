/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cap8_1;

//import java.awt.Component;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author anatol
 */
public class MXFrame extends JFrame{
  JLabel jLabel3;  
  JPanel jPanelMX1,jPanelMX2;
  JTextField jTextMX1;

  public MXFrame(){
   OpenLab();
  }

    /**
     *
     */
  private void OpenLab(){
        //LayuotManager manager=new 
        setBounds(10, 10, 350, 100);
        getContentPane().setLayout( new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
                
        jPanelMX1 = new JPanel();
       // jPanelMX1.setBounds(10,10,200,50);
        //jPanelMX1.setMaximumSize(new Dimension (200,50));
        jPanelMX1.setBorder(BorderFactory.createEtchedBorder(Color.lightGray, Color.yellow));
        jPanelMX1.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(jPanelMX1);
        
        jLabel3= new  JLabel("Matrix size");        
        //jLabel3.setBorder(BorderFactory.createLineBorder(Color.RED));
        jPanelMX1.add(jLabel3);
    
        jTextMX1 = new JTextField();
        jTextMX1.setColumns(10);
        //jTextMX1.setText("           ");
        jTextMX1.setSize(25, 10);
        jPanelMX1.add(jTextMX1);
        
        JButton jButtonMX1 = new JButton();
        jButtonMX1.setText("Creat matrix");
        jButtonMX1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                jButtonMX1Action(evt);
            }
        }
        );
        jPanelMX1.add(jButtonMX1);
        
        jPanelMX2 = new JPanel();
        jPanelMX2.setBounds(10,10,200,50);
        jPanelMX2.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.PINK));
        add(jPanelMX2);
 } 
  
  private void  jButtonMX1Action(ActionEvent evt){
      JTable matrix1 = new JTable();
      
  }  
}
