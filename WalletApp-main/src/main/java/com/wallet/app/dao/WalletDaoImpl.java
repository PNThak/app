package com.wallet.app.dao;

import java.util.HashMap;
import java.util.Map;
//import java.util.HashMap;

import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;
import com.wallet.app.exception.WalletRepositoryException;

public class WalletDaoImpl implements WalletDao {

	// Create collection to store the Wallet information.
	Map<Integer, Wallet> wallets = new HashMap<>();

	public Wallet addWallet(Wallet newWallet) throws WalletException {

		this.wallets.put(newWallet.getId(), newWallet);
		return this.wallets.get(newWallet.getId());

	}

	public Wallet getWalletById(Integer walletId) throws WalletException {

		return this.wallets.get(walletId);
	}

	public Wallet updateWallet(Wallet updateWallet) throws WalletException {

		Wallet updatingWallet = this.wallets.get(updateWallet.getId());
		updatingWallet.setBalance(updateWallet.getBalance());
		updatingWallet.setName(updateWallet.getName());
		updatingWallet.setPassword(updateWallet.getPassword());
		return this.wallets.get(updateWallet.getId());
	}

	public Wallet deleteWalletById(Integer walletID) throws WalletRepositoryException {

		if (!this.wallets.containsKey(walletID))
			throw new WalletRepositoryException("Id does not exists to Delete");

		return this.wallets.remove(walletID);
	}

}
