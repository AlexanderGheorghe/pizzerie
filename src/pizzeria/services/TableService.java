package pizzeria.services;

import pizzeria.configuration.RepositoryConfig;
import pizzeria.domain.entity.Table;
import pizzeria.domain.repository.TableRepository;

import java.util.Random;

public class TableService {
    private TableRepository pizzaRepository= RepositoryConfig.getInstance().getTableRepository();
    public String getRandomTable(){
        Random rand = new Random();
        Table[] tables = pizzaRepository.getTables();
        int x = rand.nextInt(tables.length);
        return tables[x].getName();
    }
    public void listTables(){
        Table[] tables = pizzaRepository.getTables();
        for(Table table : tables){
            System.out.println(table.getName());
        }
    }
}
