package co.uniandes.serverBaymaxPi.domain.business;

import com.mongodb.client.MongoDatabase;

import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.IException;
import co.uniandes.serverBaymaxPi.persistence.db.datamappers.MedicalDataDataMapper;
import fj.data.Either;

public class MedicalDataBusiness {

	/**
	 * DataMapper object
	 */
	private MedicalDataDataMapper contentDataMapper;

	/**
	 * Object that represents mongo DB
	 */
	private final MongoDatabase mongoDB;

	public MedicalDataBusiness(MedicalDataDataMapper contentDataMapper, MongoDatabase mongoDatabase) {
		this.contentDataMapper = contentDataMapper;
		this.mongoDB = mongoDatabase;
	}
	
	public Either<IException, String> ok(){
	    return Either.right("");
	}

}
