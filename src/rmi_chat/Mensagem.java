/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi_chat;

import java.io.Serializable;
import java.rmi.Remote;

/**
 *
 * @author Nelson Henrique
 */
public class Mensagem implements Serializable {
    private static final int MSG_PUBLIC = 1;
    private static final int MSG_PRIVATE = 2;
    private static final int MSG_LOGIN = 3;
    private static final int MSG_LOGOUT = 4;
    
    private String remetente, destinatario, texto;
    private MensagemType tipo;

    public MensagemType getTipo() {
        return tipo;
    }

    public String getRemetente() {
        return remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getTexto() {
        return texto;
    }
    
    public Mensagem(String remetente, String destinatario, String texto, MensagemType tipo) {
        String msg = "";
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.tipo = tipo;
        switch (this.tipo) {
            case LOGIN:
                msg = "(" + remetente + ") entrou na sala.";
                break;
            case LOGOUT:
                msg = "(" + remetente + ") saiu da sala.";
                break;
            case PUBLIC:
                msg = "(" + remetente + ") escreveu: " + texto;
                break;
            case PRIVATE:
                msg = "(" + remetente + ") para (" + destinatario + ") escreveu: " + texto;
                break;
        }
        this.texto = msg;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "remetente=" + remetente + ", destinatario=" + destinatario + ", texto=" + texto + '}';
    }
}
