package sofaScore.models.gameIecidents;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class IncidentsGameDeserializer implements JsonDeserializer<IncidentInGame>{

	
	  String incidentTypeElementName;
	  Gson gson;
	  Map<String, Class<? extends IncidentInGame>> incidentsTypeRegistry;

	  public IncidentsGameDeserializer(String incidentTypeElementName)
	  {
	    this.incidentTypeElementName = incidentTypeElementName;
	    gson = new Gson();
	    incidentsTypeRegistry = new HashMap<>();
	  }

	  public void registerIncidentType(String incidentTypeName, Class<? extends IncidentInGame> incidentType)
	  {
		  incidentsTypeRegistry.put(incidentTypeName, incidentType);
	  }

	  @Override
	  public IncidentInGame deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
	      throws JsonParseException {
		  
	    JsonObject incidentObject = json.getAsJsonObject();
	    JsonElement incidentTypeElement = incidentObject.get("incidentType");
	    IncidentInGame incident = new IncidentInGame();
	    incident.incidentType = incidentTypeElement.getAsString(); 
	    Class<? extends IncidentInGame> incidentType = incidentsTypeRegistry.get(incident.incidentType);
	    incident = gson.fromJson(incidentObject, incidentType);
	    return incident;
	  }

}
