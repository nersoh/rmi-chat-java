/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi_chat;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JOptionPane;
import rmi_chat.ChatInterface;
import rmi_chat.Cliente;
import rmi_chat.ClienteInterface;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brunopaulino
 */
public class ClienteChat extends javax.swing.JFrame implements ClienteInterface, ChatController {
    
    public ChatInterface chat;
    public ClienteInterface cliente;
    public List<String> nomeClientes = new ArrayList<String>();
    
    @Override
    public void atualizarMensagens(Mensagem msg) throws RemoteException {
        // Exibe as mensagens Privadas para o remetente e destinatario da mesma
        if(msg.getTipo() == MensagemType.PRIVATE) {
            if(cliente.getNome().equals(msg.getRemetente()) ||
                    cliente.getNome().equals(msg.getDestinatario())) {
                txtAreaMensagens.append(msg.getTexto() + "\n");
            }
        }
        else {
            txtAreaMensagens.append(msg.getTexto() + "\n");
        }
    }

    @Override
    public void atualizarClientes(List<String> clientes) throws RemoteException {
        this.listUsuarios.setListData(clientes.toArray());
    }

//    @Override
//    public void atualizarContatos(List<String> nomes) throws RemoteException{
//        System.out.println("ENTROU");
//        this.listUsuarios.setListData(nomes.toArray());
//    }
//    
//    @Override
//    public void atualizarMensagens(String mensagem) throws RemoteException {
//        this.txtAreaMensagens.append(mensagem + "\n");
//    }
    
    
    
    /**
     * Creates new form TelaPrincipal
     */
    public ClienteChat() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMensagens = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        listUsuarios = new javax.swing.JList();
        lblMensagem = new javax.swing.JLabel();
        txtMensagem = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        lblServidor = new javax.swing.JLabel();
        lblPorta = new javax.swing.JLabel();
        txtServidor = new javax.swing.JTextField();
        txtPorta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDesconectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtAreaMensagens.setColumns(20);
        txtAreaMensagens.setRows(5);
        jScrollPane1.setViewportView(txtAreaMensagens);

        listUsuarios.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "aguardando login" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listUsuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listUsuariosValueChanged(evt);
            }
        });
        listUsuarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listUsuariosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                listUsuariosFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(listUsuarios);

        lblMensagem.setText("Mensagem:");

        btnEnviar.setText("enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        lblNome.setText("Digite seu nome:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logarHandler(evt);
            }
        });

        lblServidor.setText("Servidor:");

        lblPorta.setText("Porta:");

        jLabel1.setText("Mensagens");

        jLabel2.setText("Usuarios");

        btnDesconectar.setText("Desconectar");
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblMensagem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblServidor)
                                        .addComponent(lblNome)
                                        .addComponent(lblPorta))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                        .addComponent(txtServidor)
                                        .addComponent(txtPorta))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(btnConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(btnDesconectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(43, 43, 43)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblServidor)
                            .addComponent(txtServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPorta)
                            .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMensagem)
                    .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logarHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logarHandler
        String nome = txtNome.getText();
        String servidor = txtServidor.getText().equals("") ? "localhost" : txtServidor.getText();
        int porta = txtPorta.getText().equals("") ? 1099 : Integer.parseInt(txtPorta.getText());
        try {
            String url = "rmi://" + servidor + ":" + porta + "/" + "Chat";
            System.out.println(url);
            chat = (ChatInterface) Naming.lookup(url);
            System.out.println("CHAT -> " + chat);
            for (ClienteInterface cli : chat.getClientes()) {
                if( cli.getNome().equals(nome) ) {
                   JOptionPane.showMessageDialog(null, "Cliente já cadastrado, escolha outro nome");
                   return; 
                }
            }
             cliente = new Cliente(nome);
             cliente.setChatGUI(this);
             this.chat.registrarObserver(cliente);
             //cliente.setDelegate(this);
             //Naming.bind(cliente.getNome(), cliente);
             this.chat.registrarCliente(cliente.getNome());
             //listUsuarios.setListData(chat.getNomeClientes().toArray());
             System.out.println(chat.getNomeClientes());
             JOptionPane.showMessageDialog(null, "Cliente Cadastrado");
             btnConectar.setEnabled(false);
             txtNome.setEnabled(false);
             txtServidor.setEnabled(false);
             txtPorta.setEnabled(false);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar conectar.");
        }
        
    }//GEN-LAST:event_logarHandler

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        int usuarioIndex = listUsuarios.getSelectedIndex();
        try {
            // Verifica ha algum usuario na lista p/ enviar mensagem privada
            if(this.listUsuarios.isSelectionEmpty()) {
                System.out.println("NULLLLLOOOO");
                this.chat.enviarMensagem( cliente.getNome(), null, txtMensagem.getText(), MensagemType.PUBLIC );
            }
            else {
                String destinatario = (String) this.listUsuarios.getSelectedValue();
                System.out.println("Destino:" + destinatario);
                this.chat.enviarMensagem( cliente.getNome(), destinatario, txtMensagem.getText(), MensagemType.PRIVATE );
                listUsuarios.setSelectedIndex(usuarioIndex);
                
            }
            
        } catch (RemoteException ex) {
            System.out.println("MSG ERRO: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Mensagem nao enviada");
        }
        // Limpa o campo de mensagem
        txtMensagem.setText("");
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void listUsuariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listUsuariosFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_listUsuariosFocusGained

    private void listUsuariosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listUsuariosFocusLost
        // TODO add your handling code here:
        // Retira todas as seleções da lista de usuários
        //this.listUsuarios.clearSelection();
    }//GEN-LAST:event_listUsuariosFocusLost

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        this.listUsuarios.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnDesconectarActionPerformed

    private void listUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listUsuariosValueChanged
        // TODO add your handling code here:
        System.out.println(this.listUsuarios.getSelectedIndex());
    }//GEN-LAST:event_listUsuariosValueChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            
            //this.chat.removerObserver(cliente);
            this.chat.removerCliente("");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(ClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteChat().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPorta;
    private javax.swing.JLabel lblServidor;
    private javax.swing.JList listUsuarios;
    private javax.swing.JTextArea txtAreaMensagens;
    private javax.swing.JTextField txtMensagem;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPorta;
    private javax.swing.JTextField txtServidor;
    // End of variables declaration//GEN-END:variables


    @Override
    public String getNome() throws RemoteException {
        return cliente.getNome();
    }

    @Override
    public void setNome(String nome) throws RemoteException {
        cliente.setNome(nome);
    }

    @Override
    public List<Mensagem> getMensagens() throws RemoteException {
        return chat.getMensagens();
    }

    @Override
    public void update(ChatInterface chat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setChatGUI(ChatController chat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
