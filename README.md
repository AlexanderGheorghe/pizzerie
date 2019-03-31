# Pizzerie
Features:\
-> listPizzas\
-> existsByName\
-> listIngredientsOf\
-> makeReservation\
-> registerCustomer\
-> addIngredients\
-> addPizza\
-> listIngredients\
-> checkAvailability\
-> listStaff\
Customer(id, name)\
Staff(id,name,salary)\
Waiter(Staff, orders)\
Chef(Staff)\
Reservation(customer,date,table)
Table(id)
Pizza(name, ingredients)\
Ingredient(name, quantity, measurementUnit)\
Drink(name,quantity)\
Cocktail(Drink,ingredients)\
Soda(Drink)
