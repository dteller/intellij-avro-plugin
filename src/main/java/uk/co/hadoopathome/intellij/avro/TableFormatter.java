package uk.co.hadoopathome.intellij.avro;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.intellij.openapi.diagnostic.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Takes the JSON records and places them into the format expected by JTable.
 */
class TableFormatter {
    private static final Logger LOGGER = Logger.getInstance(TableFormatter.class);
    private final List<JsonObject> flattenedRecords;
    private String[] columns;

    TableFormatter(List<String> rawRecords) {
        this.flattenedRecords = new ArrayList<>();
        for (String rawRecord : rawRecords) {
            String flatten = JsonFlattener.flatten(rawRecord);
            JsonObject jsonObject = new JsonParser().parse(flatten).getAsJsonObject();
            this.flattenedRecords.add(jsonObject);
        }
        this.columns = constructAllColumns();
    }

    /**
     * Get all of the populated rows for the table, in the format expected by JTable.
     *
     * @return the rows for the table
     */
    String[][] getRows() {
        String[][] rows = new String[this.flattenedRecords.size()][this.columns.length];
        for (int i = 0; i < this.flattenedRecords.size(); i++) {
            JsonObject flattenedRecord = this.flattenedRecords.get(i);
            String[] values = new String[this.columns.length];
            for (int j = 0; j < this.columns.length; j++) {
                String column = this.columns[j];
                if (flattenedRecord.has(column) && !flattenedRecord.get(column).isJsonNull()) {
                    values[j] = flattenedRecord.get(column).getAsString();
                }
            }
            rows[i] = values;
        }
        return rows;
    }

    String[] getColumns() {
        return columns;
    }

    /**
     * Get every (flattened) column from every record to be displayed. This is required for the table view.
     *
     * @return a Set of all possible columns
     */
    private String[] constructAllColumns() {
        Set<String> totalKeys = new HashSet<>();
        for (JsonObject flattenedRecord : flattenedRecords) {
            totalKeys.addAll(flattenedRecord.keySet());
        }
        LOGGER.info("Found " + totalKeys.size() + " unique columns");
        return totalKeys.toArray(new String[0]);
    }
}
