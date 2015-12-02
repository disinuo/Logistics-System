package dataservice.managementdataservice.bankaccountdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.BankAccountPO;

public interface BankAccountDataService {
	public ResultMessage insert(BankAccountPO po) throws RemoteException, IOException;

	public ResultMessage update(BankAccountPO po) throws RemoteException, ClassNotFoundException, IOException;

	public ResultMessage delete(BankAccountPO po) throws RemoteException, ClassNotFoundException, IOException;

	public ArrayList<BankAccountPO> show() throws RemoteException, ClassNotFoundException, IOException;

	public BankAccountPO findByName(String name) throws RemoteException, FileNotFoundException, NameNotFoundException, ClassNotFoundException, IOException;

	public BankAccountPO findByBankAccountNum(String bankAccountNum)
			throws RemoteException, FileNotFoundException, NumNotFoundException, ClassNotFoundException, IOException;
}
