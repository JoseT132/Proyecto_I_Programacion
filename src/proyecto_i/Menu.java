package proyecto_i;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author angel
 */
public class Menu extends javax.swing.JFrame {

    private String expresionMat, ExprArbol;
    int dato;
    Menu right, left;
    private Menu raizArbol;

    public Menu() {
        //Si lo eliminamos causa error :[
    }

    public Menu(String expresionMat) {
        initComponents();
        this.ExprArbol = expresionMat;
        this.expresionMat = expresionMat;
        this.dato = 0;
        this.right = null;
        this.left = null;
        this.raizArbol = this;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Que desea hacer???");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 140, 30));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, -1, -1));

        jLabel3.setText("Recorridos del árbol");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        jLabel4.setText("Resultado de la notación polaca");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        jLabel5.setText("El árbol de forma gráfica");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, -1));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 550));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        procesarExpresion();
        procesarExpresion2();
        procesarExpresion3();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jLabel6.setText(" ");
        jLabel7.setText(" ");
        jLabel8.setText(" ");
        String resultado = convertirAnotacionPolaca(expresionMat);
        jLabel6.setText("La expresión en notacion polaca inversa es: " + resultado);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        double resultado = procesarArbol(raizArbol);
        System.out.println("Resultado de la expresión: " + resultado);
    }//GEN-LAST:event_jButton3ActionPerformed
    private void procesarExpresion() {
        Map<Character, Integer> jerarquiaOperadores = new HashMap<>();
        jerarquiaOperadores.put('+', 1);
        jerarquiaOperadores.put('-', 1);
        jerarquiaOperadores.put('*', 2);
        jerarquiaOperadores.put('/', 2);
        jerarquiaOperadores.put('^', 3);
        jerarquiaOperadores.put('√', 3);

        StringBuilder expresionOrdenada = new StringBuilder();
        for (int i = 0; i < expresionMat.length(); i++) {
            char caracter = expresionMat.charAt(i);

            if (jerarquiaOperadores.containsKey(caracter)) {
                expresionOrdenada.append(caracter).append(" ");
                System.out.print(caracter + " ");
            }
        }

        for (int i = 0; i < expresionMat.length(); i++) {
            char caracter = expresionMat.charAt(i);
            if (!jerarquiaOperadores.containsKey(caracter) && caracter != ' ') {
                expresionOrdenada.append(caracter).append(" ");
                System.out.print(caracter + " ");
            }
        }

        String expresionOrdenadaStr = expresionOrdenada.toString();
        System.out.println(expresionOrdenadaStr);

        jLabel6.setText("Expresion en el recorrido preorden: " + expresionOrdenadaStr);
    }

    private void procesarExpresion2() {
        Map<Character, Integer> jerarquiaOperadores = new HashMap<>();
        jerarquiaOperadores.put('+', 1);
        jerarquiaOperadores.put('-', 1);
        jerarquiaOperadores.put('*', 2);
        jerarquiaOperadores.put('/', 2);
        jerarquiaOperadores.put('^', 3);
        jerarquiaOperadores.put('√', 3);

        StringBuilder expresionOrdenada = new StringBuilder();
        Stack<Character> pila = new Stack<>();
        for (int i = expresionMat.length() - 1; i >= 0; i--) {
            char caracter = expresionMat.charAt(i);
            pila.push(caracter);
        }

        while (!pila.isEmpty()) {
            char caracter = pila.pop();
            if (jerarquiaOperadores.containsKey(caracter)) {
                expresionOrdenada.append(caracter).append(" ");
                System.out.print(caracter + " ");
            }
        }

        for (int i = expresionMat.length() - 1; i >= 0; i--) {
            char caracter = expresionMat.charAt(i);
            if (!jerarquiaOperadores.containsKey(caracter) && caracter != ' ') {
                expresionOrdenada.append(caracter).append(" ");
                System.out.print(caracter + " ");
            }
        }

        String expresionOrdenadaStr = expresionOrdenada.toString();
        System.out.println(expresionOrdenadaStr);

        jLabel7.setText("Expresion en el recorrido inorden: " + expresionOrdenadaStr);
    }

    private void procesarExpresion3() {
        Map<Character, Integer> jerarquiaOperadores = new HashMap<>();
        jerarquiaOperadores.put('+', 1);
        jerarquiaOperadores.put('-', 1);
        jerarquiaOperadores.put('*', 2);
        jerarquiaOperadores.put('/', 2);
        jerarquiaOperadores.put('^', 3);
        jerarquiaOperadores.put('√', 3);

        StringBuilder expresionOrdenada = new StringBuilder();
        Stack<Character> pila = new Stack<>();
        for (int i = expresionMat.length() - 1; i >= 0; i--) {
            char caracter = expresionMat.charAt(i);
            pila.push(caracter);
        }

        while (!pila.isEmpty()) {
            char caracter = pila.pop();
            if (!jerarquiaOperadores.containsKey(caracter) && caracter != ' ') {
                expresionOrdenada.append(caracter).append(" ");
                System.out.print(caracter + " ");
            }
        }

        for (int i = expresionMat.length() - 1; i >= 0; i--) {
            char caracter = expresionMat.charAt(i);
            if (jerarquiaOperadores.containsKey(caracter)) {
                expresionOrdenada.append(caracter).append(" ");
                System.out.print(caracter + " ");
            }
        }

        String expresionOrdenadaStr = expresionOrdenada.toString();
        System.out.println(expresionOrdenadaStr);

        jLabel8.setText("Expresion en el recorrido postorden: " + expresionOrdenadaStr);
    }

    private String convertirAnotacionPolaca(String expresionMat) {
        Map<Character, Integer> jerarquiaOperadores = new HashMap<>();
        jerarquiaOperadores.put('+', 1);
        jerarquiaOperadores.put('-', 1);
        jerarquiaOperadores.put('*', 2);
        jerarquiaOperadores.put('/', 2);
        jerarquiaOperadores.put('^', 3);
        jerarquiaOperadores.put('√', 3);

        StringBuilder notacionPolaca = new StringBuilder();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < expresionMat.length(); i++) {
            char caracter = expresionMat.charAt(i);
            if (Character.isDigit(caracter)) {

                notacionPolaca.append(caracter).append(" ");
            } else if (jerarquiaOperadores.containsKey(caracter)) {

                while (!operadores.isEmpty() && jerarquiaOperadores.get(operadores.peek()) >= jerarquiaOperadores.get(caracter)) {
                    notacionPolaca.append(operadores.pop()).append(" ");
                }
                operadores.push(caracter);
            }
        }
        while (!operadores.isEmpty()) {
            notacionPolaca.append(operadores.pop()).append(" ");
        }

        return notacionPolaca.toString().trim();
    }

    private double procesarArbol(Menu raiz) {
        if (raiz == null) {
            throw new IllegalArgumentException("Árbol vacío");
        }
        if (raiz.left == null && raiz.right == null) {
            // Convertir dato a double antes de devolverlo
            return (double) raiz.dato;
        }
        double izquierdo = procesarArbol(raiz.left);
        double derecho = procesarArbol(raiz.right);
       char operador = String.valueOf(raiz.dato).charAt(0);
        switch (operador) {
            case '+':
                return izquierdo + derecho;
            case '-':
                return izquierdo - derecho;
            case '*':
                return izquierdo * derecho;
            case '/':
                return izquierdo / derecho;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
