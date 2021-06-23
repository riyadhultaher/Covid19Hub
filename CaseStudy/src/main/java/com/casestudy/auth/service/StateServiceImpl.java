package com.casestudy.auth.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.auth.model.State;
import com.casestudy.auth.repository.StateRepository;
import com.casestudy.auth.repository.UserRepository;
import com.casestudy.auth.utilities.ProgramException;

/*
 * This class implements the StateService DAO
 * interface. The state and user repositories are
 * autowired into the class.
 */
@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository repo;

	@Autowired
	UserRepository userRepo;

	/*
	 * This method will add all the states to the
	 * database as soon as a user hits the registration
	 * page. If the state table is already populated then
	 * this method will not try to attempt to persist the 
	 * data again.
	 */
	@Override
	public List<String> addStates() throws ProgramException {

		List<String> list;

		list = Arrays.asList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
				"Delaware", "District Of Columbia", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana",
				"Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
				"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
				"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
				"Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah",
				"Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");
		
		ArrayList<String> allStates = new ArrayList<String>(list);

		if (findAll().isEmpty()) {
			for (String s : allStates) {
				State state = new State();
				state.setName(s);
				save(state);
			}
		}
		return allStates;
	}

	/*
	 * This method saves a state to a user account within
	 * the database.
	 */
	@Override
	public void save(State state) {
		repo.save(state);
	}

	/*
	 * This method finds all states meant to persist in the
	 * state table and returns the result.
	 */
	@Override
	public List<State> findAll() {
		return repo.findAll();
	}

	/*
	 * This method finds a specific state within the state
	 * table.
	 */
	@Override
	public State findByName(String name) {
		return repo.findByName(name);
	}

	/*
	 * This method deletes a state from a user account based
	 * on the state id.
	 */
	@Override
	@Transactional
	public void delete(State state) {
		repo.deleteById(state.getId());
	}

	/*
	 * This method assigns hyperlinks to the respective
	 * states, linking to that state's official COVID 19
	 * website.
	 */
	@Override
	public void assignHyperlink(State state) {
		String name = state.getName();

		switch (name) {

		case "Alabama":
			state.setHyperlink("https://www.alabamapublichealth.gov/covid19/");
			break;

		case "Alaska":
			state.setHyperlink("https://covid19.alaska.gov/");
			break;

		case "Arizona":
			state.setHyperlink("https://www.azdhs.gov/covid19/data/index.php");
			break;

		case "Arkansas":
			state.setHyperlink("https://www.healthy.arkansas.gov/programs-services/topics/novel-coronavirus");
			break;

		case "California":
			state.setHyperlink("https://covid19.ca.gov/");
			break;

		case "Colorado":
			state.setHyperlink("https://covid19.colorado.gov/");
			break;

		case "Connecticut":
			state.setHyperlink("https://portal.ct.gov/coronavirus/covid-19-data-tracker");
			break;

		case "Delaware":
			state.setHyperlink("https://coronavirus.delaware.gov/");
			break;

		case "District Of Columbia":
			state.setHyperlink("https://coronavirus.dc.gov/");
			break;

		case "Florida":
			state.setHyperlink("https://floridahealthcovid19.gov/");
			break;

		case "Georgia":
			state.setHyperlink("https://dph.georgia.gov/covid-19-daily-status-report");
			break;

		case "Hawaii":
			state.setHyperlink("https://hawaiicovid19.com/");
			break;

		case "Idaho":
			state.setHyperlink("https://coronavirus.idaho.gov/");
			break;

		case "Illinois":
			state.setHyperlink("https://www.dph.illinois.gov/covid19");
			break;

		case "Indiana":
			state.setHyperlink("https://www.coronavirus.in.gov/2393.htm");
			break;

		case "Iowa":
			state.setHyperlink("https://coronavirus.iowa.gov/");
			break;

		case "Kansas":
			state.setHyperlink("https://www.coronavirus.kdheks.gov/");
			break;

		case "Kentucky":
			state.setHyperlink("https://govstatus.egov.com/kycovid19");
			break;

		case "Louisiana":
			state.setHyperlink("https://ldh.la.gov/Coronavirus/");
			break;

		case "Maine":
			state.setHyperlink("https://www.maine.gov/covid19/");
			break;

		case "Maryland":
			state.setHyperlink("https://coronavirus.maryland.gov/");
			break;

		case "Massachusetts":
			state.setHyperlink("https://www.mass.gov/covid-19-updates-and-information");
			break;

		case "Michigan":
			state.setHyperlink("https://www.michigan.gov/coronavirus/");
			break;

		case "Minnesota":
			state.setHyperlink("https://www.health.state.mn.us/diseases/coronavirus/");
			break;

		case "Mississippi":
			state.setHyperlink("https://msdh.ms.gov/msdhsite/_static/14,0,420.html");
			break;

		case "Missouri":
			state.setHyperlink(
					"https://health.mo.gov/living/healthcondiseases/communicable/novel-coronavirus/data/public-health/");
			break;

		case "Montana":
			state.setHyperlink("https://dphhs.mt.gov/publichealth/cdepi/diseases/coronavirusmt");
			break;

		case "Nebraska":
			state.setHyperlink("https://dhhs.ne.gov/Pages/Coronavirus.aspx");
			break;

		case "Nevada":
			state.setHyperlink("https://nvhealthresponse.nv.gov/");
			break;

		case "New Hampshire":
			state.setHyperlink("https://www.covid19.nh.gov/");
			break;

		case "New Jersey":
			state.setHyperlink("https://covid19.nj.gov/");
			break;

		case "New Mexico":
			state.setHyperlink("https://cv.nmhealth.org/");
			break;

		case "New York":
			state.setHyperlink("https://coronavirus.health.ny.gov/home");
			break;

		case "North Carolina":
			state.setHyperlink("https://covid19.ncdhhs.gov/dashboard");
			break;

		case "North Dakota":
			state.setHyperlink("https://www.health.nd.gov/diseases-conditions/coronavirus");
			break;

		case "Ohio":
			state.setHyperlink("https://coronavirus.ohio.gov/wps/portal/gov/covid-19/home");
			break;

		case "Oklahoma":
			state.setHyperlink("https://oklahoma.gov/covid19.html");
			break;

		case "Oregon":
			state.setHyperlink("https://govstatus.egov.com/OR-OHA-COVID-19");
			break;

		case "Pennsylvania":
			state.setHyperlink("https://www.health.pa.gov/topics/disease/coronavirus/Pages/Coronavirus.aspx");
			break;

		case "Rhode Island":
			state.setHyperlink("https://covid.ri.gov/");
			break;

		case "South Carolina":
			state.setHyperlink("https://scdhec.gov/covid19");
			break;

		case "South Dakota":
			state.setHyperlink("https://covid.sd.gov/");
			break;

		case "Tennessee":
			state.setHyperlink("https://www.tn.gov/health/cedep/ncov.html");
			break;

		case "Texas":
			state.setHyperlink("https://dshs.texas.gov/coronavirus/AdditionalData.aspx");
			break;

		case "Utah":
			state.setHyperlink("https://coronavirus.utah.gov/");
			break;

		case "Vermont":
			state.setHyperlink("https://www.healthvermont.gov/covid-19");
			break;

		case "Virginia":
			state.setHyperlink("https://www.vdh.virginia.gov/coronavirus/");
			break;

		case "Washington":
			state.setHyperlink("https://www.doh.wa.gov/emergencies/COVID19");
			break;

		case "West Virginia":
			state.setHyperlink("https://dhhr.wv.gov/covid-19/pages/vaccine.aspx");
			break;

		case "Wisconsin":
			state.setHyperlink("https://www.dhs.wisconsin.gov/covid-19/index.htm");
			break;

		case "Wyoming":
			state.setHyperlink(
					"https://health.wyo.gov/publichealth/infectious-disease-epidemiology-unit/disease/novel-coronavirus/");
			break;
		}
	}
}
