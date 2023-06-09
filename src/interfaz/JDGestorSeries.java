/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package interfaz;

import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import modelo.ModeloListaSeries;
import vergeflix.Media;
import vergeflix.Serie;
import vergeflix.Vergeflix;

/**
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class JDGestorSeries extends javax.swing.JDialog {
    
    private int numSeries;
    private ArrayList<Serie> listaSeries;
    private ArrayList<Media> listaMedia;
    private ModeloListaSeries modelo;
    private Serie serieSeleccionada;

    /**
     * Creates new form JDGestorSeries
     */
    public JDGestorSeries(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public JDGestorSeries(java.awt.Frame parent, boolean modal, ArrayList<Media> listaMedia, int numSeries) {
        super(parent, modal);
        initComponents();
        //setting the initial values
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("play-icon.png");
        setIconImage(icon.getImage());
        setTitle("VERGEFLIX");
        JTableHeader header = tableSeries.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 14));
        tableSeries.setRowHeight(25);
        
        this.listaMedia = listaMedia;
        this.listaSeries = Vergeflix.seriesCatalogo(listaMedia, numSeries);
        modelo = new ModeloListaSeries(this.listaSeries);
        tableSeries.setModel(modelo);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        pItemGestionar = new javax.swing.JMenuItem();
        pItemEliminar = new javax.swing.JMenuItem();
        pItemModificar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSeries = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mItemAñadir = new javax.swing.JMenuItem();

        pItemGestionar.setText("Gestionar");
        pItemGestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pItemGestionarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pItemGestionar);

        pItemEliminar.setText("Eliminar");
        pItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pItemEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pItemEliminar);

        pItemModificar.setText("Modificar");
        pItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pItemModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pItemModificar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableSeries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableSeries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableSeriesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableSeries);

        jMenu1.setText("OPCIONES");

        mItemAñadir.setText("Añadir Serie");
        mItemAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemAñadirActionPerformed(evt);
            }
        });
        jMenu1.add(mItemAñadir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pItemEliminarActionPerformed
        int result = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quiere eliminar? " + this.serieSeleccionada.getNombre(), "Baja del sistema", JOptionPane.WARNING_MESSAGE);
        
        if (result == 0) {
            this.listaSeries.remove(this.serieSeleccionada);
            this.listaMedia.remove(this.serieSeleccionada);
            this.numSeries--;
        }
        modelo.fireTableDataChanged();
    }//GEN-LAST:event_pItemEliminarActionPerformed

    private void pItemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pItemModificarActionPerformed
        JDModificarSerie modificar = new JDModificarSerie(null, true, this.serieSeleccionada);
        modificar.setVisible(true);
        modelo.fireTableDataChanged();
    }//GEN-LAST:event_pItemModificarActionPerformed

    private void tableSeriesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSeriesMousePressed
        //Sample 06: Show Popup menu at right click location
        if (evt.getButton() == MouseEvent.BUTTON3) {
            Point b = MouseInfo.getPointerInfo().getLocation();
            jPopupMenu1.setVisible(true);
            int row = tableSeries.rowAtPoint(evt.getPoint());
            int column = tableSeries.columnAtPoint(evt.getPoint());
            jPopupMenu1.show(this, (int) b.x - 245, (int) b.y - 110);
            tableSeries.setRowSelectionInterval(row, row);
            tableSeries.setColumnSelectionInterval(column, column);
            serieSeleccionada = this.listaSeries.get(row);
        }
    }//GEN-LAST:event_tableSeriesMousePressed

    private void mItemAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemAñadirActionPerformed
        JDNuevaSerie nuevaSerie = new JDNuevaSerie(null, true);
        nuevaSerie.setVisible(true);
        
        if (nuevaSerie.getHaAñadido()) {
            Serie nuevaPeli = nuevaSerie.getNuevaSerie();
            this.listaMedia.add(nuevaPeli);
            this.numSeries++;
            this.listaSeries.add(nuevaSerie.getNuevaSerie());
            this.modelo.fireTableDataChanged();
        }
    }//GEN-LAST:event_mItemAñadirActionPerformed

    private void pItemGestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pItemGestionarActionPerformed
        JDGestorTemporada gestionarSerie = new JDGestorTemporada(null, true, this.serieSeleccionada);
        gestionarSerie.setVisible(true);
        this.modelo.fireTableDataChanged();
    }//GEN-LAST:event_pItemGestionarActionPerformed

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
            java.util.logging.Logger.getLogger(JDGestorSeries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDGestorSeries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDGestorSeries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDGestorSeries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDGestorSeries dialog = new JDGestorSeries(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mItemAñadir;
    private javax.swing.JMenuItem pItemEliminar;
    private javax.swing.JMenuItem pItemGestionar;
    private javax.swing.JMenuItem pItemModificar;
    private javax.swing.JTable tableSeries;
    // End of variables declaration//GEN-END:variables
}
