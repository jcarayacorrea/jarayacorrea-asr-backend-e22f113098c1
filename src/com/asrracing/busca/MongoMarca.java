package com.asrracing.busca;


import java.net.UnknownHostException;


import com.asrracing.db.MongoDB;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;



public class MongoMarca implements MongoDB {
	private DB basedato;

	public MongoMarca(){
		conectar();
	}
	
	public boolean conectar() {
		// TODO Auto-generated method stub
		boolean cnx = false;
		try {
			Mongo mongodb =  new Mongo("127.0.0.1", 27017);
			basedato = mongodb.getDB("cardb");
			cnx = true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnx;
	}

	@Override
	public boolean desconectar() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String buscaMarca(String nomMarca){
		//String result = "{"+'"'+"data"+'"'+":[";
		String result="[";
		DBCollection coleccion = basedato.getCollection("marcas");
		 //BasicDBObject docto = new BasicDBObject();
				 
		 BasicDBObject searchQuery = new BasicDBObject();
	 	 searchQuery.put("niceName",new BasicDBObject("$regex",nomMarca));
	 	 
/*	 	 BasicDBObject keys = new BasicDBObject();
	 	 keys.put("username", 1); */
	 	 
	 	 DBCursor cursor = coleccion.find(searchQuery);
	 	 
	 	 while (cursor.hasNext()) {
	 	// msg += cursor.next();
	 	 BasicDBObject obj = (BasicDBObject) cursor.next();
	    
	    	result+= obj.toString()+",";
	    }
	 	result = result.substring(0, result.length() -1);
		 	 result = result + "]";
		return result;

}
}