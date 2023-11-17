package POM;

import CommonMethods.RandomStrings;
import TestCases.TestLogin;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CSVHelper  extends TestLogin {


	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\r\n";
	public static void appendCsvRecords(String fileName,  String[] headerList, String[] rowValues) throws Exception {

		FileWriter fileWriter = null;
		ArrayList<String> rowList = new ArrayList<String>(
				Arrays.asList(rowValues));
		ArrayList<String> columnList = new ArrayList<String>(
				Arrays.asList(headerList));


		try {
			if (columnList.size() != rowList.size()) {
				throw new Exception("rows and columns size is not equal in csv file");
			}

			fileWriter = new FileWriter(fileName,true);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < rowList.size(); i++) {
				if (i == (rowList.size() - 1)) {
					sb.append(rowList.get(i));
				} else {
					sb.append(rowList.get(i));
					sb.append(",");
				}
			}
			fileWriter.append(sb);
			fileWriter.append(NEW_LINE_SEPARATOR);
			System.out.println("Record added to CSV successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}

	}
	public static void appendHeader(String fileName,  String[] headerList) throws Exception {

		FileWriter fileWriter = null;

		ArrayList<String> columnList = new ArrayList<String>(
				Arrays.asList(headerList));


		try {


			fileWriter = new FileWriter(fileName);
			StringBuilder header = new StringBuilder();
				for (int i = 0; i < columnList.size(); i++) {
					if (i == (columnList.size() - 1)) {
						header.append(columnList.get(i));
					} else {
						header.append(columnList.get(i));
						header.append(",");
					}


				}
				fileWriter.append(header);

			fileWriter.append(NEW_LINE_SEPARATOR);

			System.out.println("Header added to CSV successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}

	}
	public static void ImportMeterNumber(String fileName, String header , String serviceId, String meterNo, String status, String Consumption_Type, String Configuration, String Multiplier,String Constant, String Hazard, String Location, String Additional_Site_Info, String Meter_Point_ID, String Next_Scheduled_Read_Date, String Manufacturer, String Model, String Meter_Read_Type, String Route, String Walk_Order, String Meter_Installation_Type, String Date, String Date2) {

		String FILE_HEADER = header;
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);
			fileWriter.append(FILE_HEADER.toString());
			fileWriter.append(NEW_LINE_SEPARATOR);
			    fileWriter.append(serviceId);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( meterNo);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( status);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(Consumption_Type);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Configuration);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Multiplier);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Constant);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Hazard);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Location);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Additional_Site_Info);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Meter_Point_ID);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Next_Scheduled_Read_Date);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Manufacturer);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Model);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Meter_Read_Type);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Route);
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append( Walk_Order);
				fileWriter.append(COMMA_DELIMITER);


				fileWriter.append( Meter_Installation_Type);
				fileWriter.append(COMMA_DELIMITER);


				fileWriter.append( Date);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append( Date2);
				fileWriter.append(NEW_LINE_SEPARATOR);
			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}


		}

	}

	public static void createCSVGeneric(String fileName,  String[] headerList, String[] rowValues) throws Exception {

		FileWriter fileWriter = null;
		ArrayList<String> rowList = new ArrayList<String>(
				Arrays.asList(rowValues));
		ArrayList<String> columnList = new ArrayList<String>(
				Arrays.asList(headerList));


		try {
			if (columnList.size() != rowList.size()) {
				throw new Exception("rows and columns size is not equal in csv file");
			}

			fileWriter = new FileWriter(fileName);
			StringBuilder header = new StringBuilder();
			for (int i = 0; i < columnList.size(); i++) {
				if (i == (columnList.size() - 1)) {
					header.append(columnList.get(i));
				} else {
					header.append(columnList.get(i));
					header.append(",");
				}


			}
			fileWriter.append(header);
			fileWriter.append(NEW_LINE_SEPARATOR);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < rowList.size(); i++) {
				if (i == (rowList.size() - 1)) {
					sb.append(rowList.get(i));
				} else {
					sb.append(rowList.get(i));
					sb.append(",");
				}
			}
			fileWriter.append(sb);
			fileWriter.append(NEW_LINE_SEPARATOR);
			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}

	}
	public static String  billingAddress() {
		String []array ={"Kangaroo Crescent","Eucalyptus Drive","Boomerang Road","Koala Avenue","Wattle Street","Sydney Court","Barossa Parade","Great Barrier Place","Ayers Rock Boulevard","Didgeridoo Lane","Australian Alps Way","Gold Coast Track","Blue Mountains Court","Opal Path","Platypus Green","Bondi Terrace","Kookaburra Alley","Byron Bay Grove","Surfers Paradise Place","Outback Street","Uluru Crescent","Waratah Drive","Quokka Road","Whitsunday Avenue","Boat Harbour Close","Alice Springs Parade","Great Ocean Road Place","Kangaroo Island Boulevard","Nullarbor Lane","Tasmanian Devil Way","Ayers Rock Track","Murray River Court","Koala Path","Bushland Green","Reef Terrace","Sydney Harbour Alley","Outback Grove","Australian Open Place","Golden Beach Street","Opera House Crescent","Bondi Beach Drive","Red Centre Road","Surf Coast Avenue","Great Dividing Range Street","Federation Close","Snowy Mountains Parade","Blue Reef Place","Victorian Alps Boulevard","Coral Coast Lane","Koala Sanctuary Way","Harbour Bridge Track","Australian Rules Court","Golden Sunset Path","Coastal Breeze Green","Mountain View Terrace","Australian Wildlife Alley","Koala Forest Grove","Desert Oasis Place","Sunset Beach Street","Rainforest Crescent","Great Southern Drive","Whale Watch Road","Barbecue Avenue","Sunflower Street","Palm Cove Close","Bushfire Parade","Tropical Rainforest Place","Kangaroo Crossing Boulevard","Golden Sand Lane","Surfside Way","Wildflower Track","Kangaroo Jump Court","Sunset View Path","Native Garden Green","Seaside Terrace","Emu Walk Alley","Reef View Grove","Island Paradise Place","Wildlife Street","Wombat Crescent","Great Barrier Reef Drive","Blue Lake Road","Green Valley Avenue","Golden Gate Street","Sunny Side Close","Wilderness Parade","Hidden Cove Place","Coastal Drive Boulevard","Australian Dream Lane","Gumtree Way","Harmony Track","Summer Breeze Court","Riverbank Path","Sunrise Green","Aussie Bush Terrace","Quandong Alley","Australia Fair Grove","Sapphire Shores Place","Wide Horizon Street","Sydney Opera Crescent"};


		Random r=new Random();
		int randomNumber=r.nextInt(array.length);
		String address= array[randomNumber];
		return address;


	}

	public static String readCSVSuburb(String readFilePath,int i) throws IOException {
		//"C:\Users\Itsqe\eclipse-workspace\MarketBilling\TestData\AddressFile.csv"
		//"C:\Users\Itsqe\Downloads\MarketBilling-main\MarketBilling-main\TestData\AdressFile (1).csv"
		//String path = "C:/Users/Itsqe/Downloads/MarketBilling-main/MarketBilling-main/TestData/Address.csv";

		// Create a new BufferReader object and pass the path of CSV file
		Reader reader = Files.newBufferedReader(Paths.get(readFilePath));
		// parse the file into csv values
		CSVParser parse = new CSVParser(reader, CSVFormat.DEFAULT);
		CSVRecord record =parse.getRecords().get(i);
	   return	record.get(0);
	}

	public static String readCSVState(String readFilePath,int i) throws IOException {
		// Create a new BufferReader object and pass the path of CSV file
		Reader reader = Files.newBufferedReader(Paths.get(readFilePath));

		// parse the file into csv values
		CSVParser parse = new CSVParser(reader, CSVFormat.DEFAULT);
		CSVRecord record =parse.getRecords().get(i);
		return	record.get(1);
	}


	public static String readCSVPostal(String readFilePath,int i) throws IOException {

		// Create a new BufferReader object and pass the path of CSV file
		Reader reader = Files.newBufferedReader(Paths.get(readFilePath));

		// parse the file into csv values
		CSVParser parse = new CSVParser(reader, CSVFormat.DEFAULT);
		CSVRecord record =parse.getRecords().get(i);
		return	record.get(2);
	}




	public static void ImportMeterRegister(String fileName, String header , String serviceId, String meterNo, String register, String networkTariffCode, String UnitOfMeasure, String timeOfDay,String multiplier, String dialFormat, String suffix, String controlledLoad, String status, String consumptionType, String Demand1, String Demand2, String dateConnected, String dateRemoved) {

			String FILE_HEADER = header;
			FileWriter fileWriter = null;

			try {
				fileWriter = new FileWriter(fileName);

				//Write the CSV file header
				fileWriter.append(FILE_HEADER.toString());

				//Add a new line separator after the header
				fileWriter.append(NEW_LINE_SEPARATOR);

				//Write a new student object list to the CSV file


				    fileWriter.append(serviceId);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( meterNo);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( register);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append(networkTariffCode);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( UnitOfMeasure);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( timeOfDay);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( multiplier);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( dialFormat);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( suffix);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( controlledLoad);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( status);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( consumptionType);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( Demand1);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( Demand2);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( dateConnected);
					fileWriter.append(COMMA_DELIMITER);

					fileWriter.append( dateRemoved);
					//fileWriter.append(COMMA_DELIMITER);

					fileWriter.append(NEW_LINE_SEPARATOR);



				System.out.println("CSV file was created successfully !!!");

			} catch (Exception e) {
				System.out.println("Error in CsvFileWriter !!!");
				e.printStackTrace();
			} finally {

				try {
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e) {
					System.out.println("Error while flushing/closing fileWriter !!!");
	                e.printStackTrace();
				}

		}


	}

	public static void ImportMeterReads(String fileName, String header , String serviceId, String meterNo, String dateOfRead, String meterRead, String period, String readType,String notes, String isReadrollOver, String unit, String dataStream, String specialType) {

		String FILE_HEADER = header;
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			//Write a new student object list to the CSV file


			fileWriter.append(serviceId);
			fileWriter.append(COMMA_DELIMITER);

			fileWriter.append( meterNo);
			fileWriter.append(COMMA_DELIMITER);

			fileWriter.append( dateOfRead);
			fileWriter.append(COMMA_DELIMITER);

			fileWriter.append(meterRead);
			fileWriter.append(COMMA_DELIMITER);

			fileWriter.append( period);
			fileWriter.append(COMMA_DELIMITER);

			fileWriter.append( readType);
			fileWriter.append(COMMA_DELIMITER);

			fileWriter.append( notes);
			fileWriter.append(COMMA_DELIMITER);

			fileWriter.append( isReadrollOver);
			fileWriter.append(COMMA_DELIMITER);

			fileWriter.append( unit);
			fileWriter.append(COMMA_DELIMITER);

			fileWriter.append( dataStream);
			fileWriter.append(COMMA_DELIMITER);

			fileWriter.append( specialType);
			fileWriter.append(NEW_LINE_SEPARATOR);
			System.out.println("CSV file was created successfully !!!");
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}


	}

}
