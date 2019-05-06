package pizzeria.domain.repository;

import pizzeria.domain.entity.Table;
import pizzeria.tool.TestData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TableRepositoryImpl implements TableRepository {
    private HashMap<String, Table> tables;

    public TableRepositoryImpl() {
//        String[] data = TestData.getInstance().getTableData();
        tables = new HashMap<>();
//        for (int i = 0; i < data.length; i++) {
//            tables.add(new Table(data[i]));
//        }
    }

    @Override
    public HashMap<String, Table> getTables() {
        return tables;
    }
}
