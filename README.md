# Pokémon Card Pack Opening Simulator

A Java GUI program that simulates opening Pokémon card packs, tracking a collection, and managing a favorites grid.

## Features
- Load card data from `src/Data/PokemonList.csv`
- Open a randomized pack of cards
- Add opened cards to a collection with quantity tracking
- View the collection as image cards in a paged GUI
- Add, replace, and remove favorite cards in a 4x4 favorites grid

## How to Run
1. Open a terminal in the project root folder.
2. Compile the Java source files:
   ```bash
   javac src/*.java
   ```
3. Run the application from the project root:
   ```bash
   java -cp src App
   ```

> The program expects the CSV file and card images to be available under `src/Data/`.

## Project Structure
- `src/App.java` - Application entry point and main GUI menu.
- `src/Card.java` - Represents an individual card with name, rarity, and image identifier.
- `src/CardPack.java` - Builds a pack, stores cards, and opens the pack.
- `src/CardSlot.java` - Tracks a card and its count in the collection.
- `src/Collection.java` - Manages the card collection and displays card images in pages.
- `src/Favorite.java` - Stores favorite cards in a fixed 4x4 grid and handles updates.
- `src/Data/PokemonList.csv` - Source card data used by the application.

## How It Works
- `App` reads the CSV file and creates `Card` objects for each row.
- The main menu allows the user to:
  - Rip a pack and add pulled cards to the collection.
  - View the collection in a GUI window.
  - Manage chase/favorite cards using console prompts.
- The collection groups duplicate cards by name and counts how many of each card were pulled.

## Notes
- This program was developed with the help of Github Copilot AI
- The GUI windows are built with `JFrame` and show card images using `ImageIcon`.
- Favorite card selection currently uses console input for add/replace/remove actions.
- Card images are loaded dynamically from `src/Data` using the image name stored in each card.

## Limitations
- The program relies on the CSV file path being available relative to the project root.
- Favorite replacement logic assumes the named card exists in the grid.
- There is no validation for invalid user input in the console menu.

## Future Improvements
- Add input validation and error handling for the console menu.
- Improve the GUI to let users select favorites directly from buttons.
- Support card image loading from a configurable resource path.
