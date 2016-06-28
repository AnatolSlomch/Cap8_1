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
import javax.swing.SwingUtilities;

/**
 *
 * @author anatol
 */
public class MXFrame extends JFrame{
  JLabel jLabel3;  
  JPanel jPanelMX1;
  JPanel jPanelMX2;
  JTextField jTextMX1;
  int matrixSize;
  Object[][] databank,databank2;
  JTable matrix1,matrix2,matrix3;
  final int PLUS=1, MINE=2, MULTIPLY=3;
  String[] header;
  JScrollPane jscp,jscp2,jscp3;

  public MXFrame(){
   OpenLab();
  }

    /**
     *
     */
  private void OpenLab(){
        //LayuotManager manager=new 
        setBounds(10, 10, 700, 100);
        getContentPane().setLayout( new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
                
        jPanelMX1 = new JPanel();
       // jPanelMX1.setBounds(10,10,200,50);
        jPanelMX1.setMaximumSize(new Dimension (1000,50));
        jPanelMX1.setBorder(BorderFactory.createEtchedBorder(Color.lightGray, Color.yellow));
        jPanelMX1.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(jPanelMX1);
        
        jLabel3= new  JLabel("Matrix size");
        //jLabel3.setBorder(BorderFactory.createLineBorder(Color.RED));
        jPanelMX1.add(jLabel3);
    
        jTextMX1 = new JTextField();
        jTextMX1.setColumns(10);
        jTextMX1.setText("5");
        jTextMX1.setSize(25, 10);
        jPanelMX1.add(jTextMX1);
        
        JButton jButtonMX1 = new JButton();
        jButtonMX1.setText("Creat matrix");
        jButtonMX1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                jButtonMX1Action(evt);
            }
        }
        );
        jPanelMX1.add(jButtonMX1);

        JButton jButtonPlus = new JButton();
        jButtonPlus.setText("PLUS");
        jButtonPlus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                jButtonEvent(PLUS);
            }
        }
        );
        jPanelMX1.add(jButtonPlus);

        JButton jButtonMine = new JButton();
        jButtonMine.setText("MINE");
        jButtonMine.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                jButtonEvent(MINE);
            }
        }
        );
        jPanelMX1.add(jButtonMine);

        JButton jButtonMULTIPLY = new JButton();
        jButtonMULTIPLY.setText("MULTIPLY");
        jButtonMULTIPLY.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                jButtonEvent(MULTIPLY);
            }
        }
        );
        jPanelMX1.add(jButtonMULTIPLY);
      
        jPanelMX2 = new JPanel();
        jPanelMX2.setBounds(10,10,200,50);
        jPanelMX2.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.PINK));
        jPanelMX2.setLayout(new BoxLayout(jPanelMX2,BoxLayout.Y_AXIS));
        add(jPanelMX2);
 } 

  private void  jButtonEvent(int evt){
      String TabName="";
      databank2 = new Object[matrixSize][matrixSize];
      for (int w=0;w<=matrixSize-1;++w){
       for (int y=0;y<=matrixSize-1;++y){
           switch (evt){
               case PLUS:
                 TabName="PLUS";
                 databank2[y][w]= (int)matrix1.getValueAt(y, w) + (int)matrix1.getValueAt(y, w);
                 break;
               case MINE:
                 TabName="MINE";
                 databank2[y][w]= (int)matrix1.getValueAt(y, w) - (int)matrix1.getValueAt(y, w);
                 break;
               case MULTIPLY:
                 TabName="MULTIPLY";
                 databank2[y][w]= (int)matrix1.getValueAt(y, w) * (int)matrix1.getValueAt(y, w);
                 break;                  
           }
      }}
      if (matrix3 != null){
         jscp3.remove(matrix3);
         jPanelMX2.remove(jscp3);
          jPanelMX2.repaint();
       } 
      matrix3 = new JTable( databank2,header);
      matrix3.setPreferredScrollableViewportSize(new Dimension(500,100));
      jscp3=new JScrollPane(matrix3);
      jscp3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Tab "+TabName));
      jPanelMX2.add(jscp3);
      jPanelMX2.revalidate();
     
      
      
  }  
  private void  jButtonMX1Action(ActionEvent evt){
      //массив с заголовками столбцов
      try{
        matrixSize=Integer.parseInt(jTextMX1.getText());
      } catch(NumberFormatException e){
         JOptionPane.showMessageDialog(rootPane, e);
         return; 
      }
      jPanelMX2.removeAll();
      header=new String[matrixSize];
      for (Integer k=0;k<=matrixSize-1;++k){
          header[k]=String.valueOf(Character.toChars(k+1+64));
      }
      
      databank = new Object[matrixSize][matrixSize];
      for (int w=0;w<=matrixSize-1;++w){
       for (int y=0;y<=matrixSize-1;++y){
         databank[y][w]=w+y;
      }}

      matrix1 = new JTable( databank,header);
      matrix1.setPreferredScrollableViewportSize(new Dimension(500,100));
      matrix2 = new JTable( databank,header);
      matrix2.setPreferredScrollableViewportSize(new Dimension(500,100));
      matrix2.setSize(getContentPane().getWidth(), 100);

      jscp=new JScrollPane(matrix1);
      jscp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Tab 1"));

      jscp2=new JScrollPane(matrix2);
      jscp2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Tab 2"));
      jPanelMX2.add(jscp);
      jPanelMX2.add(jscp2);
      jPanelMX2.revalidate();
  }  
}
