package pizzeria.domain.repository;

import pizzeria.domain.entity.Table;
import pizzeria.tool.TestData;

public class TableRepositoryImpl implements TableRepository {
    private Table[] tables;

    public TableRepositoryImpl() {
        String[] data = TestData.getInstance().getTableData();
        tables = new Table[data.length];
        for (int i = 0; i < data.length; i++) {
            tables[i] = new Table(data[i]);
        }
    }

    @Override
    public Table[] getTables() {
        return tables;
    }
}
