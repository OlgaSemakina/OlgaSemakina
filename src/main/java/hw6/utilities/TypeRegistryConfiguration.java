package hw6.utilities;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import hw6.entities.UserFromTable;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;
import java.util.Map;

import static java.util.Locale.ENGLISH;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(
                UserFromTable.class, (Map<String, String> row) -> new UserFromTable(
                Integer.parseInt(row.get("number")),
                row.get("user"),
                row.get("description")
        )
        ));
    }
}
