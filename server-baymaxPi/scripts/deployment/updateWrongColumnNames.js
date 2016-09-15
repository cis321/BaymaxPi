try {

	var conn = new Mongo("localhost:27017");
	var db = conn.getDB("SWD_DB");
	db.auth("swd_db", "swd_db");
	
	print("About to update termsAndConsitions");
	
	var collectionNames = db.getCollectionNames();
	for(var i=0;i < collectionNames.length; i++) {
		
		if(collectionNames[i].startsWith('content_web_')) {
			
			var collectionName =  collectionNames[i];
			print("------------------------------------------");
			printjson("Collection name: " + collectionName);
			
			var cursor = db[collectionName].find();
			while ( cursor.hasNext() ) {
				var webContent = cursor.next();
				printjson( "web content id: " + webContent._id );
				
				var updateResult = db[collectionName].update(
							{}, { $rename:{ 'termsAndConsitions':'termsAndConditions' } } 
					);				
			}
			
		}
		
	}
	
	
} catch (err){
    print('oops: '+err.name + ': "' + err.message );
}
