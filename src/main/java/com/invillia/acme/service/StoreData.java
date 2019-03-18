package com.invillia.acme.service;

import java.util.ArrayList;
import java.util.List;

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
        for(Store store: storesList) {
            if(store.getId() == id) {
                return store;
            }
        }
        return null;
    }

    /**
     * 
     * Used to create a new store and register on BD
     * 
     * @param newStore New order to be created on BD
     * @return Returns TRUE if success or FALSE if it fails
     */
    public boolean createNewStore(Store newStore) {
        storesList.add(newStore);
        return true;
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
    	for(Store store: storesList) {
            if(store.getId() == modifiedStore.getId()) {
                int storeIndex = storesList.indexOf(store);
                store.setAddress(modifiedStore.getAddress());
                store.setName(modifiedStore.getName());
                storesList.set(storeIndex, store);
                return store;
            }

        }
    	
    	return null;
    }
}
