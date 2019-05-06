package pizzeria.domain.repository;

import pizzeria.domain.entity.Table;

import java.util.HashMap;
import java.util.List;

public interface TableRepository {
    HashMap<String, Table> getTables();
}
