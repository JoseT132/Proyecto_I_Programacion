package proyecto_i;

import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class Menu2 extends javax.swing.JFrame {

    private ArrayList<Character> letras = new ArrayList<>();
    private ArrayList<Integer> valores = new ArrayList<>();
    private String expresionOriginal = "";

    private Menu2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Menu2(String expresionMat) {
        initComponents();
        expresionOriginal = expresionMat;
        for (int i = 0; i < expresionMat.length(); i++) {
            char caracter = expresionMat.charAt(i);
            if (Character.isLetter(caracter) && !letras.contains(caracter)) {
                letras.add(caracter);
            }
        }
        jLabel2.setText("Ingrese el valor de la letra " + letras.get(0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 330, -1));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 550));

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String num = jTextField1.getText();
        try {
            int valor = Integer.parseInt(num);
            valores.add(valor);
            jTextField1.setText("");
            if (valores.size() < letras.size()) {
                jLabel2.setText("Ingrese el valor de la letra " + letras.get(valores.size()));
            } else {
                StringBuilder expresionModificada = new StringBuilder(expresionOriginal);
                for (int i = 0; i < letras.size(); i++) {
                    char letra = letras.get(i);
                    int valorLetra = valores.get(i);
                    expresionModificada = new StringBuilder(expresionModificada.toString().replaceFirst(String.valueOf(letra), String.valueOf(valorLetra)));
                }
                String expresionModificada1 = expresionModificada.toString();
                jLabel2.setText("Expresión modificada: " + expresionModificada1);

                Menu ver = new Menu(expresionModificada1);
                ver.setVisible(true);
                this.setVisible(false);
            }
        } catch (NumberFormatException e) {
            jLabel2.setText("Ingrese un valor numérico válido.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
