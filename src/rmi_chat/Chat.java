/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi_chat;

/**
 *
 * @author Nelson Henrique
 */

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class Chat extends UnicastRemoteObject implements ChatInterface {
    private static final long serialVersionUID = 1L;
    private List<ClienteInterface> clientes;
    private List<String>mensagensPublicas;
    private List<Mensagem> mensagens;
    private List<String> nomeClientes;
    private List<ClienteInterface> observers;
    
    public List<String> getNomeClientes() {
        return nomeClientes;
    }

    public Chat() throws RemoteException{
        //UnicastRemoteObject.exportObject(this, 0);
        this.clientes = new ArrayList<ClienteInterface>();
        this.mensagens = new ArrayList<Mensagem>();
        this.nomeClientes = new ArrayList<String>();
        this.observers = new ArrayList<ClienteInterface>();
    }

    public String registrarCliente(String cli) throws RemoteException {
        try {
            if(!clientes.isEmpty()){
                for(ClienteInterface cliente : clientes){
                    if(cliente.getNome().equals(cli)){
                        return "Cliente ja registrado";
                    }
                }
            }
            ClienteInterface cliente = new Cliente(cli);
            this.clientes.add( cliente );
            this.nomeClientes.add( cli );
            this.notificarObservers();
        } catch (Exception e) {
           System.out.println("Erro (chat): " + e.getMessage());
           e.printStackTrace();
       }
       return "Cliente Registrado com sucesso";
    }


    public void enviarMensagem(String remetente, String destinatario, String texto, MensagemType tipo) throws RemoteException {
        String msg = "";
        if(!this.clientes.isEmpty()) {
            this.mensagens.add( new Mensagem(remetente, destinatario, texto, tipo) );
            this.notificarObservers();
        }
    }

    public List<String> getMensagensPublicas() throws RemoteException{
            return this.mensagensPublicas;
    }

    @Override
    public List<Mensagem> getMensagens() throws RemoteException {
        return this.mensagens;
    }
    
    public List<ClienteInterface> getClientes() throws RemoteException {
        return this.clientes;
    }
    
    
    @Override
    public void registrarObserver(ClienteInterface cli) throws RemoteException {
        this.observers.add(cli);
        this.mensagens.add( new Mensagem(cli.getNome(), null, null, MensagemType.LOGIN) );
        
    }

    @Override
    public void removerObserver(ClienteInterface cli) throws RemoteException {
        this.observers.remove(cli);
    }

    @Override
    public void notificarObservers() throws RemoteException {
        for (ClienteInterface observer : this.observers) {
            observer.update(this);
        }
    }

    @Override
    public void removerCliente(String cli) throws RemoteException {
        // Verifica se o cliente existe setando uma flag que indica a exclusão.
        try {
            if(!clientes.isEmpty()){
                boolean clienteEncontrado = false;
                ClienteInterface clienteARemover = null;
                for(ClienteInterface cliente : clientes){
                    if(cliente.getNome().equals(cli)){
                        clienteEncontrado = true;
                        clienteARemover = cliente;
                        this.mensagens.add( new Mensagem(cliente.getNome(), null, null, MensagemType.LOGOUT) );
                        
                    }
                }
                if(clienteEncontrado) {
                    this.clientes.remove(clienteARemover);
                    this.nomeClientes.remove(clienteARemover.getNome());
                    System.out.println("Excluido:" + clienteARemover.hashCode() + "\n");
                    this.notificarObservers();
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
