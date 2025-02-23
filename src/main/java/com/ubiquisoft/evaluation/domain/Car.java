package com.ubiquisoft.evaluation.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

	private String year;
	private String make;
	private String model;

	private List<Part> parts;

	public Map<PartType, Integer> getMissingPartsMap() {
		/*
		 * Return map of the part types missing.
		 *
		 * Each car requires one of each of the following types:
		 *      ENGINE, ELECTRICAL, FUEL_FILTER, OIL_FILTER
		 * and four of the type: TIRE
		 *
		 * Example: a car only missing three of the four tires should return a map like this:
		 *
		 *      {
		 *          "TIRE": 3
		 *      }
		 */
		int count = 0; //variable to count the number of tires missing
		Map<PartType, Integer> missingTypes = new HashMap<>(); //map to find missing parts
		for(int i=0; i<parts.size(); i++){
			if(parts[i] != "ENGINE"){	//if 'ENGINE' is absent
				missingTypes.put("ENGINE", 1)
			}
			else if(parts[i] != "ELECTRICAL"){	//if 'ELECTRICAL' is absent
				missingTypes.put("ELECTRICAL", 1)
			}
			else if(parts[i] != "FUEL_FILTER"){	//if 'FUEL_FILTER' is absent
				missingTypes.put("FUEL_FILTER", 1)
			}
			else if(parts[i] != "OIL_FILTER"){	//if 'OIL_FILTER' is absent
				missingTypes.put("OIL_FILTER", 1)
			}
			else if(parts[i] != "TIRE"){	//if 'TIRE' is absent
				count++;
				missingTypes.put("TIRE", count)
			}
		}

		return missingTypes;
	}
	}

	@Override
	public String toString() {
		return "Car{" +
				       "year='" + year + '\'' +
				       ", make='" + make + '\'' +
				       ", model='" + model + '\'' +
				       ", parts=" + parts +
				       '}';
	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/*  Getters and Setters *///region
	/* --------------------------------------------------------------------------------------------------------------- */

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/*  Getters and Setters End *///endregion
	/* --------------------------------------------------------------------------------------------------------------- */

}
