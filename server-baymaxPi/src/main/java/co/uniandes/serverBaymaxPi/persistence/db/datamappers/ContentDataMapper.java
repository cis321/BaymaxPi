package co.uniandes.serverBaymaxPi.persistence.db.datamappers;

import java.util.ArrayList;
import java.util.List;

import org.bson.BSONException;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import co.uniandes.serverBaymaxPi.api.representations.ContentDTONew;
import co.uniandes.serverBaymaxPi.domain.entities.Content;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.BusinessException;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.ExceptionCodes;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.IException;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.TechnicalException;
import fj.data.Either;

public class ContentDataMapper {

	private static final String MONGO_ID = "_id";

	private static final String CONTENT_WEB_COLLECTION = "content_web_";

	private final static Logger LOGGER = LoggerFactory.getLogger(ContentDataMapper.class);

	private final ObjectMapper objectMapper;

	public ContentDataMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public Either<IException, List<String>> getContentNames(MongoDatabase mongoDB, String tenantId) {

		Either<IException, List<String>> either;

		try {

			MongoCollection<Document> collection = mongoDB.getCollection(CONTENT_WEB_COLLECTION + tenantId);

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
