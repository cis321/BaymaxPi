package co.uniandes.serverBaymaxPi.domain.business;

import com.mongodb.client.MongoDatabase;

import co.uniandes.serverBaymaxPi.infrasctructure.DTOs.UserDTO;
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
}
