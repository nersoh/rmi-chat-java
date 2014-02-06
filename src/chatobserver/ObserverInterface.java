/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatobserver;

import java.rmi.RemoteException;

/**
 *
 * @author Nelson Henrique
 */
public interface ObserverInterface {
    public void update(ChatInterface chat) throws RemoteException;
}
