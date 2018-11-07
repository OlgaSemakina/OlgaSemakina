package hw8JDI.dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import hw8JDI.entities.MetalColorsData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class DataProviders {

    @DataProvider
    public Object[][] metalsColorsDataProvider() throws FileNotFoundException {
        String jsonPathJDI = "src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json";

        Gson gson = new Gson();
        JsonObject jsonData = new JsonParser().parse(new FileReader(jsonPathJDI)).getAsJsonObject();

        Type type = new TypeToken<Map<String, MetalColorsData>>() {
        }.getType();
        Map<String, MetalColorsData> dataSet = gson.fromJson(jsonData, type);

        Object[][] dataObjects = new Object[dataSet.size()][1];
        int index = 0;
        for (String key : dataSet.keySet()) {
            dataObjects[index++][0] = dataSet.get(key);
        }
        return dataObjects;
    }
}
