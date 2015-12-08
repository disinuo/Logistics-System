package blservice.loginblservice;

import java.rmi.RemoteException;

import util.enumData.Authority;
import util.enumData.ResultMessage;

public interface LoginBLService {
	public ResultMessage login(String accountNum, String key)
			throws RemoteException;

	public Authority loginChoose(String accountNum) throws RemoteException;

	/**
	 * 获得当前登录人员的编号
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public String getCurrentOptorId() throws RemoteException;
}
