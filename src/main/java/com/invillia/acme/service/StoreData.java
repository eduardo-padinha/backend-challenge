package com.invillia.acme.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.invillia.acme.dao.StoreDaoImpl;
import com.invillia.acme.model.Store;

public class StoreData {

	private static StoreData mockedDataInstance = null;
	private List<Store> storesList;
	
	public static StoreData getInstance() {
		if(mockedDataInstance == null) {
			mockedDataInstance = new StoreData();
		}
		
		return mockedDataInstance;
	}
	
	public StoreData() {
		storesList = new ArrayList<Store>();
		storesList.add(new Store(1, "Teste 1", "endereço 1"));
		storesList.add(new Store(2, "Teste 2", "endereço 2"));
		storesList.add(new Store(3, "Teste 3", "endereço 3"));
		storesList.add(new Store(4, "Teste 4", "endereço 4"));
		storesList.add(new Store(5, "Teste 5", "endereço 5"));
	}
	
	/**
	 * Returns a specific store filtering by id
	 * 
	 * @param id The store id
	 * @return A single store that has the same passed id
	 */
    public Store getStoreById(int id) {
    	Store result = null;
		try {
			result = StoreDaoImpl.getStoreById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
    }

    /**
     * 
     * Used to create a new store and register on BD
     * 
     * @param newStore New order to be created on BD
     * @return Returns the created Store
     */
    public Store createNewStore(Store newStore) {
    	try {
    		StoreDaoImpl.createNewStore(newStore);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newStore;
    }
    
    /**
     * 
     * Used to update a pre-existing store
     * 
     * @param payment Payment to be added into the order
     * @param orderId Id of the order
     * @return The modified order
     */
    public Store updateStore(Store modifiedStore) {
    	try {
			StoreDaoImpl.updateStore(modifiedStore);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return modifiedStore;
    }
}
