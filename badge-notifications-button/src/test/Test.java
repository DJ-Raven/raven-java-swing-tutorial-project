package test;

import java.awt.Color;

/**
 *
 * @author RAVEN
 */
public class Test extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    public Test() {
        initComponents();
        getContentPane().setBackground(new Color(240, 240, 240));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        badgeButton1 = new raven.notibutton.BadgeButton();
        badgeButton2 = new raven.notibutton.BadgeButton();
        badgeButton3 = new raven.notibutton.BadgeButton();
        badgeButton4 = new raven.notibutton.BadgeButton();
        badgeButton5 = new raven.notibutton.BadgeButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Badge Notifications Button");

        body.setBackground(new java.awt.Color(250, 250, 250));

        badgeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/icon.png"))); // NOI18N
        badgeButton1.setText("80");
        badgeButton1.setBadgeColor(new java.awt.Color(131, 46, 203));
        badgeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badgeButton1ActionPerformed(evt);
            }
        });

        badgeButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/icon.png"))); // NOI18N
        badgeButton2.setText("2");
        badgeButton2.setBadgeColor(new java.awt.Color(13, 162, 136));
        badgeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badgeButton2ActionPerformed(evt);
            }
        });

        badgeButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/icon.png"))); // NOI18N
        badgeButton3.setText("1");
        badgeButton3.setBadgeColor(new java.awt.Color(25, 122, 196));
        badgeButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badgeButton3ActionPerformed(evt);
            }
        });

        badgeButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/icon.png"))); // NOI18N
        badgeButton4.setText("9");
        badgeButton4.setBadgeColor(new java.awt.Color(199, 197, 22));
        badgeButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badgeButton4ActionPerformed(evt);
            }
        });

        badgeButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test/icon.png"))); // NOI18N
        badgeButton5.setText("999");
        badgeButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badgeButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(badgeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(badgeButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(badgeButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(badgeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(badgeButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(badgeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(badgeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(badgeButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(badgeButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(badgeButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(225, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void badgeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badgeButton1ActionPerformed
        badgeButton1.setText(Integer.parseInt(badgeButton1.getText()) + 1 + "");
    }//GEN-LAST:event_badgeButton1ActionPerformed

    private void badgeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badgeButton2ActionPerformed
        badgeButton2.setText(Integer.parseInt(badgeButton2.getText()) + 1 + "");
    }//GEN-LAST:event_badgeButton2ActionPerformed

    private void badgeButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badgeButton3ActionPerformed
        badgeButton3.setText(Integer.parseInt(badgeButton3.getText()) + 1 + "");
    }//GEN-LAST:event_badgeButton3ActionPerformed

    private void badgeButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badgeButton4ActionPerformed
        badgeButton4.setText(Integer.parseInt(badgeButton4.getText()) + 1 + "");
    }//GEN-LAST:event_badgeButton4ActionPerformed

    private void badgeButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badgeButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_badgeButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.notibutton.BadgeButton badgeButton1;
    private raven.notibutton.BadgeButton badgeButton2;
    private raven.notibutton.BadgeButton badgeButton3;
    private raven.notibutton.BadgeButton badgeButton4;
    private raven.notibutton.BadgeButton badgeButton5;
    private javax.swing.JPanel body;
    // End of variables declaration//GEN-END:variables
}