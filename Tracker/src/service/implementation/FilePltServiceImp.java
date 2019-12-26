package service.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import model.Location;
import repository.LocationRepository;
import service.FileService;

public class FilePltServiceImp extends FileService{
	
	private BufferedReader br;
	private LocationRepository locationRepository;
	
	public FilePltServiceImp() {
		locationRepository = new LocationRepository();
	}
	
	@Override
	public Boolean importData(File file, String plate) {
		String line = "";
		try {
            br = new BufferedReader(new FileReader(file));
            //The first 6 lines have useless information
            for(int i = 0; i < 7; ++i)
            	  br.readLine();
            while ((line = br.readLine()) != null) {
                Object[] location = line.split(",");
                
                Location l = new Location();

                l.setLatitude((Double.parseDouble((String) location[0])));
                l.setLongitude((Double.parseDouble((String) location[1])));
                l.setAltitude((Double.parseDouble((String) location[3])));
                l.setDate((LocalDate.parse((CharSequence) location[5])));
                l.setTime((LocalTime.parse((CharSequence) location[6])));
                l.setPlate(plate);
                
                locationRepository.saveLocation(l);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return Boolean.TRUE;
	}

	@Override
	public File exportData() {
		// TODO Auto-generated method stub
		return null;
	}
}
