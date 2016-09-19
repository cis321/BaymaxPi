package co.uniandes.serverBaymaxPi.persistence.db.datamappers;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.IException;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.TechnicalException;
import fj.data.Either;

public class MedicalDataDataMapper {

	private static final String MONGO_ID = "_id";

	private static final String MEDICAL_DATA_COLLECTION = "medial_data";

	private final static Logger LOGGER = LoggerFactory.getLogger(MedicalDataDataMapper.class);

	private final ObjectMapper objectMapper;

	public MedicalDataDataMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public Either<IException, List<String>> getContentNames(MongoDatabase mongoDB, String tenantId) {

		Either<IException, List<String>> either;

		try {

			MongoCollection<Document> collection = mongoDB.getCollection(MEDICAL_DATA_COLLECTION + tenantId);

			MongoCursor<Document> result = collection.find().iterator();

			List<String> contentNamesList = new ArrayList<String>();

			if (result.hasNext()) {

				Document document = result.next();
				contentNamesList.add(document.getString("_id"));
			}

			either = Either.right(contentNamesList);

		} catch (Exception e) {

			LOGGER.error("ContentDataMapper :: getContentNames", e);
			TechnicalException technicalException = new TechnicalException(e.getMessage(), e);
			either = Either.left(technicalException);

		}

		return either;

	}
}
