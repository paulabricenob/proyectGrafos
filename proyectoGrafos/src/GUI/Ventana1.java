/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Objetos.*;
import TDatos.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author diego
 */
public class Ventana1 extends javax.swing.JFrame {
    Grafo grafo ;
    Funciones f;
    Lista<Persona> usuarios;
    public static Ventana2 v2;
    public static Ventana3 v3;
    public static Ventana4 v4;
    public static Ventana5 v5;
    public static Ventana6 v6;
    
    

    /**
     * Creates new form Ventana1
     */
    public Ventana1() {
        initComponents();
        this.grafo = new Grafo() ;
        this.f = new Funciones();
        this.usuarios = new Lista();
        this.setVisible(true);
        this.setLocationRelativeTo(null);//muestra la interfáz en el centro
      
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
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        loadFile = new javax.swing.JButton();
        addUser = new javax.swing.JButton();
        design1 = new javax.swing.JLabel();
        deleteUser = new javax.swing.JButton();
        design2 = new javax.swing.JLabel();
        showGraph = new javax.swing.JButton();
        updateRepository = new javax.swing.JButton();
        addConocidos = new javax.swing.JButton();
        deleteConocidos = new javax.swing.JButton();
        design3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        design4 = new javax.swing.JLabel();
        design5 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("--------------------------------------------");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Artifakt Element Heavy", 0, 60)); // NOI18N
        title.setForeground(new java.awt.Color(204, 0, 51));
        title.setText("TU RED SOCIAL");
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        exit.setForeground(new java.awt.Color(255, 0, 0));
        exit.setText("X");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 40, 20));

        loadFile.setFont(new java.awt.Font("Artifakt Element Book", 1, 14)); // NOI18N
        loadFile.setText("DESCARGAR ARCHIVO");
        loadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileActionPerformed(evt);
            }
        });
        jPanel1.add(loadFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, -1, -1));

        addUser.setFont(new java.awt.Font("Artifakt Element Book", 1, 14)); // NOI18N
        addUser.setText("AÑADIR USUARIO");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });
        jPanel1.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        design1.setFont(new java.awt.Font("Artifakt Element Black", 1, 100)); // NOI18N
        design1.setForeground(new java.awt.Color(0, 204, 102));
        design1.setText("+");
        jPanel1.add(design1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        deleteUser.setFont(new java.awt.Font("Artifakt Element Book", 1, 14)); // NOI18N
        deleteUser.setText("ELIMINAR USUARIO");
        deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserActionPerformed(evt);
            }
        });
        jPanel1.add(deleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        design2.setFont(new java.awt.Font("Artifakt Element Heavy", 1, 100)); // NOI18N
        design2.setForeground(new java.awt.Color(204, 0, 0));
        design2.setText("-");
        jPanel1.add(design2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        showGraph.setFont(new java.awt.Font("Artifakt Element Book", 1, 14)); // NOI18N
        showGraph.setText("MOSTRAR RED SOCIAL");
        showGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGraphActionPerformed(evt);
            }
        });
        jPanel1.add(showGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        updateRepository.setFont(new java.awt.Font("Artifakt Element Book", 1, 14)); // NOI18N
        updateRepository.setText("GUARDAR REPOSITORIO");
        updateRepository.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRepositoryActionPerformed(evt);
            }
        });
        jPanel1.add(updateRepository, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 210, -1));

        addConocidos.setFont(new java.awt.Font("Artifakt Element Book", 1, 14)); // NOI18N
        addConocidos.setText("AÑADIR RELACIONES DE USUARIO");
        addConocidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addConocidosActionPerformed(evt);
            }
        });
        jPanel1.add(addConocidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        deleteConocidos.setFont(new java.awt.Font("Artifakt Element Book", 1, 14)); // NOI18N
        deleteConocidos.setText("ELIMINAR RELACIONES DE USUARIO");
        deleteConocidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteConocidosActionPerformed(evt);
            }
        });
        jPanel1.add(deleteConocidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, -1));

        design3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        design3.setForeground(new java.awt.Color(204, 204, 204));
        design3.setText("->");
        jPanel1.add(design3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setText("->");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setText("->");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        design4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        design4.setForeground(new java.awt.Color(204, 204, 204));
        design4.setText("->");
        jPanel1.add(design4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        design5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        design5.setForeground(new java.awt.Color(204, 204, 204));
        design5.setText("->");
        jPanel1.add(design5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.jpeg"))); // NOI18N
        background.setText("X");
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        //SALIR POR COMPLETO DEL PROGRAMA -->
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void loadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileActionPerformed
        Ventana2 v2 = new Ventana2(this);
    }//GEN-LAST:event_loadFileActionPerformed

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        Ventana3 v3 = new Ventana3(this);
    }//GEN-LAST:event_addUserActionPerformed

    private void deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserActionPerformed
        Ventana4 v4 = new Ventana4(this);
    }//GEN-LAST:event_deleteUserActionPerformed

    private void addConocidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addConocidosActionPerformed
        Ventana5 v5 = new Ventana5(this);
    }//GEN-LAST:event_addConocidosActionPerformed

    private void deleteConocidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteConocidosActionPerformed
        Ventana6 v6 = new Ventana6(this);
    }//GEN-LAST:event_deleteConocidosActionPerformed

    private void showGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGraphActionPerformed
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Tutorial 1");
                graph.setAttribute("ui.stylesheet", "node { text-alignment: under; }");
               
                
               
                graph.addNode("A");
                graph.addNode("B");
                graph.addNode("C");
                graph.addEdge("AB", "A", "B");
                graph.addEdge("BC", "B", "C");
                graph.addEdge("CA", "C", "A");
                for (Node node : graph) {
                node.setAttribute("ui.label", node.getId());
                }
               
                for (Node node : graph) {
                node.setAttribute("ui.style", "text-size: 25;");
                }
                graph.display();
    }//GEN-LAST:event_showGraphActionPerformed

    private void updateRepositoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRepositoryActionPerformed
        f.write_Txt(grafo.getusuarios(), "test\\usuarios.txt");
    }//GEN-LAST:event_updateRepositoryActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addConocidos;
    private javax.swing.JButton addUser;
    private javax.swing.JLabel background;
    private javax.swing.JButton deleteConocidos;
    private javax.swing.JButton deleteUser;
    private javax.swing.JLabel design1;
    private javax.swing.JLabel design2;
    private javax.swing.JLabel design3;
    private javax.swing.JLabel design4;
    private javax.swing.JLabel design5;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loadFile;
    private javax.swing.JButton showGraph;
    private javax.swing.JLabel title;
    private javax.swing.JButton updateRepository;
    // End of variables declaration//GEN-END:variables
}
