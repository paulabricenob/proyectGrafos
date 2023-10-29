/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Ventana5 extends javax.swing.JFrame {
    public static Ventana1 v1;
    public static String name_user = "";
    public static String add_conocido = "" ;
    

    /** Creates new form Ventana5 */
    public Ventana5(Ventana1 v1) {
        initComponents();
        this.v1 = v1;
        v1.setVisible(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        title5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        next = new javax.swing.JButton();
        conocidosUser = new javax.swing.JTextField();

        title4.setFont(new java.awt.Font("Artifakt Element Heavy", 0, 36)); // NOI18N
        title4.setForeground(new java.awt.Color(204, 0, 0));
        title4.setText("ELIMINAR USUARIO");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title5.setFont(new java.awt.Font("Artifakt Element Heavy", 0, 36)); // NOI18N
        title5.setText("RELACIONES DE USUARIO");
        jPanel1.add(title5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 0));
        jLabel2.setText("@TUREDSOCIAL");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/seguidores.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-220, 10, -1, -1));

        title.setFont(new java.awt.Font("Artifakt Element Book", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(0, 204, 102));
        title.setText("(AÑADIR)");
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Nombre del usuario principal:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, -1));

        nameUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameUserActionPerformed(evt);
            }
        });
        jPanel1.add(nameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 440, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Nombre del usuario que se relaciona con el principal:  ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        exit.setForeground(new java.awt.Color(255, 0, 0));
        exit.setText("X");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 40, 20));

        next.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        next.setText("GUARDAR");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        jPanel1.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, -1, -1));
        jPanel1.add(conocidosUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 440, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameUserActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.setVisible(false);
        v1.setVisible(true);
    }//GEN-LAST:event_exitActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        this.name_user = "@" + nameUser.getText().toLowerCase();
        try{
            if (name_user.isEmpty()){
               JOptionPane.showMessageDialog(null, "ERROR! Debe ingresar el nombre del usuario"); 
               
            }else{
                
                if (v1.grafo.EncontrarPersona(name_user) != null){
                    this.add_conocido = "@" + conocidosUser.getText().toLowerCase();
                    if (v1.grafo.edgeExist(name_user, add_conocido, v1.grafo.EncontrarPersona(name_user))){
                       JOptionPane.showMessageDialog(null, "La relación entre: " + name_user +" y "+ add_conocido+" ya existe!"); 

                    }else{
                        if(v1.grafo.EncontrarPersona(add_conocido)!= null){
                        v1.grafo.AgregarArco(name_user, add_conocido);
                        JOptionPane.showMessageDialog(null, "Se agregó con éxito la relación entre: " + name_user +" y "+ add_conocido);
                        this.setVisible(false);
                        v1.setVisible(true);

                        }else{
                            JOptionPane.showMessageDialog(null, "ERROR: el usuario "+ add_conocido+ " no está añadido en el programa, intente registrarlo!");
                        }
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "ERROR: el usuario "+ name_user+ " no está añadido en el programa, intente registrarlo!");
                }
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de usuarios.");
        }
    }//GEN-LAST:event_nextActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana5(v1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField conocidosUser;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameUser;
    private javax.swing.JButton next;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title4;
    private javax.swing.JLabel title5;
    // End of variables declaration//GEN-END:variables

}
