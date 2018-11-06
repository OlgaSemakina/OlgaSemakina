package hw8JDI.dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hw8JDI.entities.MetalColorsData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataProviders {

    @DataProvider
    public Object[][] metalsColorsDataProvider() throws FileNotFoundException {
        String jsonPathJDI = "src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json";
        Gson gson = new Gson();
        JsonElement jsonData = new JsonParser().parse(new FileReader(jsonPathJDI));
        JsonObject dataSet = jsonData.getAsJsonObject();

        Object[][] dataObjects = new Object[dataSet.size()][1];
        int index = 0;
        for (String key : dataSet.keySet()) {
            dataObjects[index++][0] = gson.fromJson(dataSet.get(key), MetalColorsData.class);
        }
        return dataObjects;
    }
}
