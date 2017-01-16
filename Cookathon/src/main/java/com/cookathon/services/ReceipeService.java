package com.cookathon.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.cookathon.dao.DataBaseConnector;
import com.cookathon.model.Receipes;

/**
 * 
 * This is a service class which interacts with the 
 * Database layer and provides data to the JAX-RS resource layers
 *  
 * @author Ganesh
 *
 */
public class ReceipeService {
	
	DataBaseConnector doa = new DataBaseConnector();
	
	public Receipes createReceipe(Receipes receipe) throws Exception
	{
		return doa.createReceipe(receipe);
	}
	
	public List<Receipes> getAllReceipes() throws Exception{
		ArrayList<Receipes> receipesList = new ArrayList<Receipes>();
		HashMap<String,Receipes> allReceipes = doa.getAllReceipes();
		Set<String> allReceipesKeySet = allReceipes.keySet();
		Iterator<String> keySetItr = allReceipesKeySet.iterator();
		while(keySetItr.hasNext()){
			receipesList.add(allReceipes.get(keySetItr.next()));
		}
		return receipesList;
	}
	
	public Receipes updateReceipe(Receipes receipe) throws Exception{
		return doa.updateReceipe(receipe);
	}
	
	public void deleteReceie(int receipeId) throws Exception{
		doa.deleteReceipe(receipeId);
	}

}
