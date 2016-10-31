package co.uniandes.serverBaymaxPi.persistence.db.datamappers;

import java.util.Map;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import co.uniandes.serverBaymaxPi.infrasctructure.DTOs.UserDTO;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.BusinessException;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.IException;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.TechnicalException;
import fj.data.Either;

public class AuthorizationDataMapper {

    private static final String USERS_COLLECTION = "users_baymaxPi";

    private final ObjectMapper objectMapper;

    public AuthorizationDataMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Either<IException, Boolean> createUser(UserDTO userDTO, MongoDatabase mongoDB) {

        try {

            String requestCreatedJson = objectMapper.writeValueAsString(userDTO);
            @SuppressWarnings("unchecked")
            Map<String, Object> mapNewUser = (Map<String, Object>) JSON.parse(requestCreatedJson);
            Document documentUser = new Document(mapNewUser);
            MongoCollection<Document> requestsCollection = mongoDB.getCollection(USERS_COLLECTION);
            requestsCollection.insertOne(documentUser);
            return Either.right(true);

        } catch (Exception e) {

            TechnicalException technicalException = new TechnicalException(e.getMessage(), e);
            return Either.left(technicalException);
        }
    }

    public Either<IException, Document> getUserByUsername(String username, MongoDatabase mongoDB) {

        try {
            
            MongoCollection<Document> requestsCollection = mongoDB.getCollection(USERS_COLLECTION);

            BasicDBObject query = new BasicDBObject("username", username);

            MongoCursor<Document> iterator = requestsCollection.find(query).iterator();

            if (iterator.hasNext()) {

                Document result = iterator.next();
                return Either.right(result);
            }
            
            return Either.left(new BusinessException("user not found", null));
        
        } catch (Exception e) {
            e.printStackTrace();
            
            TechnicalException technicalException = new TechnicalException(e.getMessage(), e);
            return Either.left(technicalException);
        }
    }
}
