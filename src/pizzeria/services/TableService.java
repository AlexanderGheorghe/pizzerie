package pizzeria.services;

import pizzeria.configuration.RepositoryConfig;
import pizzeria.domain.entity.Table;
import pizzeria.domain.repository.TableRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class TableService {
    private TableRepository pizzaRepository= RepositoryConfig.getInstance().getTableRepository();
    public String getRandomTable(){
        AuditService.audit("get random table");
        HashMap<String, Table> tables = pizzaRepository.getTables();
        return tables.get("Table 1").getName();
    }
    public void listTables(){
        AuditService.audit("list tables");
        HashMap<String, Table> tables = pizzaRepository.getTables();
        for(Table table : tables.values()){
            System.out.println(table.getName());
        }
    }
}
