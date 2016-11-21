package co.uniandes.serverSensor.domain.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import co.uniandes.serverSensor.infrasctructure.exceptions.IException;
import fj.data.Either;

public class SensorBusiness {

	public SensorBusiness() {
	}
	
	public Either<IException, String> ok(){
	    return Either.right("");
	}

    public Either<IException, String> getPresionData() {
        
        String[] command = {"/bin/bash","-c","/home/pi/ardupi/cooking/arduPi/presion"};

        String output = executeCommand(command);

        System.out.println(output);

        return Either.right(output);
    }
    
    private String executeCommand(String[] command) {

        StringBuffer output = new StringBuffer();

        ProcessBuilder pb = new ProcessBuilder(command);
        pb.directory(new File("/"));
        pb. redirectErrorStream(true);
        Process p;
        try {
            p = pb.start();
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }
}
