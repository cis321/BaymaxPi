package co.uniandes.serverBaymaxPi.domain.business;

import org.bson.Document;

import com.mongodb.client.MongoDatabase;

import co.uniandes.serverBaymaxPi.infrasctructure.DTOs.UserDTO;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.BusinessException;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.IException;
import co.uniandes.serverBaymaxPi.persistence.db.datamappers.AuthorizationDataMapper;
import fj.data.Either;

public class AuthorizationBusiness {
    
    private final AuthorizationDataMapper authorizationDataMapper;
    
    /**
     * Object that represents mongoDB
     */
    private final MongoDatabase mongoDatabase;
    
    public AuthorizationBusiness (AuthorizationDataMapper authorizationDataMapper, MongoDatabase mongoDatabase) {
       
        this.authorizationDataMapper = authorizationDataMapper;
        this.mongoDatabase = mongoDatabase;
    }

    public Either<IException, Boolean> createUser(UserDTO userDTO) {
        
        return authorizationDataMapper.createUser(userDTO, mongoDatabase);
    }

    public Either<IException, Document> login(String username, String contrasena) {

        Either<IException, Document> either = authorizationDataMapper.getUserByUsername(username, mongoDatabase);
        
        if (either.isLeft()){
            
            return Either.left(either.left().value());
        }
        
        if (either.right().value().get("contrasena").equals(contrasena)){
            
            return Either.right(either.right().value());
        }
        
        return Either.left(new BusinessException("Unathorized", null)); 
    }

    public Either<IException, Boolean> updateUser(UserDTO userDTO) {
        return authorizationDataMapper.updateUser(userDTO, mongoDatabase);
    }
}
