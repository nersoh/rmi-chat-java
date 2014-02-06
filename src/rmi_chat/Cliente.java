/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi_chat;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nelson Henrique
 */
class Cliente extends UnicastRemoteObject implements ClienteInterface, ObserverInterface, Serializable {
    private String nome;
    private List<Mensagem> mensagens;
    private Observable chat;
    private ChatController chatGUI;

    public void setChatGUI(ChatController chatGUI) {
        this.chatGUI = chatGUI;
    }

    public List<Mensagem> getMensagens() throws RemoteException {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente(String nome) throws RemoteException {
        this.nome = nome;
        //this.chat = chat;
        //this.chatGUI.atualizarClientes(chat.);
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    public void update(ChatInterface chat) throws RemoteException {
        
        chatGUI.atualizarClientes(chat.getNomeClientes());
        // Envia como parâmetro apenas a última mensagem adicionada ao chat
        chatGUI.atualizarMensagens(chat.getMensagens().get(chat.getMensagens().size() - 1 ));
        System.out.println(this.chatGUI);
    }

    
}
