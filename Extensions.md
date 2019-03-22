Extensions of Battleship
===

Current Extensions
---

We extended the original Battleship game, by adding our own twist to it. Instead of war at sea, we implemented war in space.

* Added a space themed background.
* Added spaceships instead sea ships.
* Used pins instead of the classic grid layout.

---

Future Extensions
---

* Add a feature that allows the player to take another turn if a hit was landed.
* Add a feature that allows a player to move their ship every 5 turns.
* Add a Quick-Game mode. Players get two successive attacks instead of one.
* Add a save feature. If playing against the AI, a player should be allowed to save and close the application. When reopening the game, the player should be able to continue the game where they left off.
* Add a HINT feature. A player should have one hint per game. The HINT feature will provide the player with either the column or row coordinate of a hit.
* Add a Leaderboard list. This list will rank players who win games with the least amount of moves. 

---

How to Implement Extensions
---

Although some extensions mentioned above are difficult and would take long, other extensions are a quick fix. For example, the extension that allows the player to take another successive turn can be implemented by modifying the `isHit()` function in a such way that the GameModel will only notify/change observers if the shot was a miss.
