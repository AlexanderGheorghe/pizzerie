# Pizzerie
Features:\
-> listPizzas\
-> existsByName\
-> listIngredientsOf\
-> order\
-> registerCustomer\
-> addIngredients\
-> addPizza\
-> listIngredients\
-> checkAvailability\
-> listStaff\
PizzeriaService\
CustomerService\
Customer(id, name, preferences, allergies, registrationDate, birthDate)\
Staff(id,name,salary)\
Waiter(Staff, orders)\
Chef(Staff)\
Order(id, price, customer)\
Pizza(name, ingredients)\
Ingredient(name, quantity, measurementUnit)\
Drink(name,quantity)\
Cocktail(Drink,ingredients)\
Soda(Drink)
