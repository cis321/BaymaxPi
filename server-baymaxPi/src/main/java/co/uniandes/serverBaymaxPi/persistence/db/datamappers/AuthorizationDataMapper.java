package co.uniandes.serverBaymaxPi.persistence.db.datamappers;

import java.util.Map;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import co.uniandes.serverBaymaxPi.infrasctructure.DTOs.UserDTO;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.IException;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.TechnicalException;
import fj.data.Either;

public class AuthorizationDataMapper {
    
    private static final String USERS_COLLECTION = "users";
    
    private final ObjectMapper objectMapper;
    
    public AuthorizationDataMapper(ObjectMapper objectMapper){
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

}
