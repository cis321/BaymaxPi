package co.uniandes.serverBaymaxPi.domain.business;

import com.mongodb.client.MongoDatabase;

import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.IException;
import co.uniandes.serverBaymaxPi.persistence.db.datamappers.ContentDataMapper;
import fj.data.Either;

public class ContentBusiness {

	/**
	 * DataMapper object
	 */
	private ContentDataMapper contentDataMapper;

	/**
	 * Object that represents mongo DB
	 */
	private final MongoDatabase mongoDB;

	public ContentBusiness(ContentDataMapper contentDataMapper, MongoDatabase mongoDatabase) {
		this.contentDataMapper = contentDataMapper;
		this.mongoDB = mongoDatabase;
	}
	
	public Either<IException, String> ok(){
	    return Either.right("");
	}

}
