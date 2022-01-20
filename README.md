Rocket Racoon Inventory - An basic Inventory Management System.

Rocket is theme of the store and is used as a brand name.

The Inventory Management System it is still a working progress.

The database schema has been created scalable - based on a franchise store model. More stores can be add and there can be branch-franchises.

Initial scope was to:

Requirements:

    - A database to store the information.
    - Addition of new items into the system. The items need a full name, a unique item code, a quantity, a
    purchase price, and a markup.
    - Removal of items from the system.
    - Addition/subtraction of stock items
    - A way to view the stock of an item.
    - A way to see the cost value of their inventory.
To do's are: -validation and general touch up of input and output data. -there is an database connection class -however most of the CRUD functions is in the RocketController class -i will change this by moving the sql related functions to a data access object class

This is the first version of the Rocket Management inventory system.

-The next version will have multi-client server architecture functionality. -A website & API.
