/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi_chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Observer;

/**
 *
 * @author Nelson Henrique
 */
public interface ChatInterface extends Remote {
    public void enviarMensagem(String remetente, String destinatario, String texto, MensagemType tipo) throws RemoteException;
    public String registrarCliente(String cli) throws RemoteException;
    public void removerCliente(String cli) throws RemoteException;
    public List<Mensagem> getMensagens() throws RemoteException;
    public List<ClienteInterface> getClientes() throws RemoteException;
    public List<String> getNomeClientes() throws RemoteException;
    
    public void registrarObserver(ClienteInterface o) throws RemoteException;
    public void removerObserver(ClienteInterface o) throws RemoteException;
    public void notificarObservers() throws RemoteException;
}
