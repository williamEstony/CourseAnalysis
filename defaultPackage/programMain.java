package defaultPackage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import guiPackage.guiManager;

public class programMain {

	public static void main(String[] args) {
		
		//guiManager gm = new guiManager();
		
		//AllTeamParser atp = new AllTeamParser();
		//Spreadsheet.exportTeams(atp.getTeams());
		//ArrayList<HashMap<String, String>> both = Spreadsheet.importTeams();
		
		//Athlete a = Athlete.createNew(5984486);
		//a.parse();
		//a.printPRs();
		//a.printPerformances();
		
		/*
		long l = 6891464;
		Athlete a1 = Athlete.createNew(l);
		a1.parse();
		a1.printPRs();
		System.out.println();
		a1.printPerformances();
		a1.printSeasonBests();
		*/
		

//		Team browdies = Team.createNew("https://www.tfrrs.org/teams/xc/CT_college_m_Trinity_CT");
//		browdies.parse();
		//browdies.printTeam();

/*		ArrayList<Athlete> browdieMembers = browdies.getTeammates();
		
		System.out.println(browdies.getName());
*/		
		
		
//		RunningDatabase db = new RunningDatabase("sql7.freemysqlhosting.net", "sql7343847");
//        if (!db.login("sql7343847", "Pm4Cmy2Dg2"))
//        	return;
		
		RunningDatabase db = new RunningDatabase("localhost", "test_db");
		if (!db.login("root", "password"))
			return;
        db.executeQuery("show tables");
        
        Athlete erkin = Athlete.createNew(6424194);
        Athlete will = Athlete.createNew(6424195);
        erkin.insert_into(db);
        will.insert_into(db);

//        db.insert_into_athlete(466, null);
        //athlete, course, meet, performance
        System.out.println();
        db.executeQuery("SELECT * FROM athlete");
        System.out.println();
        db.executeQuery("SELECT * FROM course");
        System.out.println();
        db.executeQuery("SELECT * FROM meet");
        System.out.println();
        db.executeQuery("SELECT * FROM performance");
        
//        db.executeUpdate("DELETE FROM athlete");	// deletes everything in athlete table
/*        
        // iterate along every athlete encountered so far
        String insertString = "";
        Set<Entry<Long, Athlete>> athleteEntries = ((HashMap<Long, Athlete>) Athlete.getAllAthletes().clone()).entrySet();
        for (Entry<Long, Athlete> e : athleteEntries) {
        	Athlete a = e.getValue();
        	a.parse();	// parse athlete
        	insertString = "insert into athlete(ID, name) values ('" + e.getKey() + "', '"
        			+ a.getName() + "');";
        	db.executeUpdate(insertString);
        
        }
		//Meet Regionals2018 = Meet.createNew("https://www.tfrrs.org/results/xc/14521/NCAA_Division_III_New_England_Region_Cross_Country_Championships");
		//Regionals2018.parse();
		
		/*
		System.out.println("Predicting results for browdies at REGIONALS 2018 meet");
		Predictor p = new Predictor();
		HashMap<Athlete, Double> estimatedResults = p.meetPrediction(Regionals2018, browdies.getTeammates(), 2019);
		for (Athlete a : estimatedResults.keySet())
			System.out.println("Athlete " + a.getName() + ":\t" + Performance.timeDoubleToString(estimatedResults.get(a)));
		
		
		
		/*Meet NESCACs2019 = Meet.createMeet("https://www.tfrrs.org/results/xc/16670/NESCAC_Cross_Country_Championships");
		MeetParser mp = new MeetParser(Regionals2018);
		mp.parseMeet();
		
		System.out.println("Predicting results for browdies at REGIONALS 2018 meet");
		Predictor p = new Predictor();
		HashMap<Athlete, Double> estimatedResults = p.meetPrediction(Regionals2018, browdies.getTeammates(), 2019);
		for (Athlete a : estimatedResults.keySet())
			System.out.println("Athlete " + a.getName() + ":\t" + Performance.timeDoubleToString(estimatedResults.get(a)));
		*/
		
	

		/*long l = 6891464;
		Athlete a = new Athlete(l, true);
		a.printPRs();
		System.out.println();
		a.printPerformances();

		
		
		
		
		Athlete a = new Athlete(7421730, true);
		a.printPerformances();
		a.printSeasonBests();*/
	
		//Athlete a = new Athlete(5997232, true);
		//a.printSeasonBests();

		//Meet m = Meet.createMeet("https://www.tfrrs.org/results/xc/16670/NESCAC_Cross_Country_Championships");
		
	}
}
