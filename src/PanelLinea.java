import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;

public class PanelLinea extends JPanel {
 
 XYSeries series;
 XYDataset datos;
 JFreeChart linea;
 JTextField txtval;
 JLabel grafico;
 JButton b;
 int x=0;
 
 public PanelLinea(){
  
  txtval=new JTextField(7);
  b=new JButton("Actualizar");
  b.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e) {
    series.add(Integer.parseInt(txtval.getText()),x);
    x++;
    BufferedImage graficotorta=linea.createBufferedImage(450, 300);
    ImageIcon img=new ImageIcon(graficotorta);
    grafico.setIcon(img);
   }
   
  });
  
  series= new XYSeries("Popularidad Java Zone");
  series.add(5,x);
  x++;
  series.add(30,x);
  x++;
  series.add(40,x);
  x++;
  
  datos = new XYSeriesCollection(series);
  linea = ChartFactory.createXYLineChart("Ejemplo Grafico de Linea","Popularidad","Meses",datos,PlotOrientation.HORIZONTAL,true,true,true);
  
  BufferedImage graficotorta=linea.createBufferedImage(450, 300);
  ImageIcon img=new ImageIcon(graficotorta);
  grafico=new JLabel(img);
  
  JPanel p=new JPanel();
  p.add(new JLabel("Valor Popularidad:"));
  p.add(txtval);
  p.add(b);
  add(grafico);
  add(p,BorderLayout.SOUTH);
  
 }
}