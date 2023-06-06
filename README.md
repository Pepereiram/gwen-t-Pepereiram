# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---
# Observations for Tarea 3 - Entrega Parcial 4.

## State Diagram

![Diagrama de estados](docs/state-diagram-v2.png)


# Observations for Tarea 2- Entrega Final.

Here you can find important observations about the design and structure of the project while developing
this assignment. It will be divided in subsection depending on the subject that requires to be addressed.

### Board implementation

While designing the board for Gwen't, the main problem question was if it should be one whole board that
contained both players or if it could be implemented as two sides of the board. Both ideas have their own
advantages and challenges, but in the end it was decided that the easier way was to make it so each player
has an independent side of the board. This avoids the problem of knowing which player was doing certain actions
on the board, like placing cards.

### The ClimateCard slot

Given that each player has its own board, we have a Slot for a ClimateCard on each side. This is the main
problem with the design that has been noticed, but if the implementation of the game loop (turn flow and so)
takes into account that given that a player placed a ClimateCard also place it on the opponent's field, then
there should be no problems (inb4 it there are problems).


### Changes in visibility and privatization

Almost every variable has been made protected or private, depending on if the variables where going
to be used on a inheriting class. Most Traits have protected variables.



