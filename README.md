# Transporter
Project Authors: Jay Flowers, Kyle Ruane, Sam Maskey, Blair Hendrickson, Robert Tai, Adewale Salami and Ebenezer Addae

Project Concept:  
1. To develop a Text-based resource gathering and map traversing adventure game.
2. To develop a GUI version of the game using SWING. 

## Story:
You are a truck driver tasked with picking up and delivering loads from State to State. Before you can get on the road, you must collect the necessary items from your home office. Once you have all the items, you get in your truck and drive to a predetermined location to pick up your load. Then, you have to drive to the load delivery station in another state. Upon pickup or delivery of your load, you are paid. You also make bonus income from picking up golden coins randomly distributed on the map. This cash can be used to purchase gas along your route. If you run out of gas, you lose the game. Your goal is to pick up and deliver as many loads in the shortest possible time. 

## General Flow:
1. The program will select from a set of scenarios indicating home office, pickup and delivery locations.
2. The player will move from room to room in the home office checking off items/resources in order to start driving.
3. The player will navigate from the home office state to the pickup state.
4. The player will navigate from the pickup state to the delivery state.
5. The player will navigate from the delivery state back to the home office state.
6. The player would be able to see help options when they press h.
7. The player would be able to see a map when they press m.
8. The player will monitor their gas tank and purchase gas when needed. 

## Code Design Pattern
The code has the following packages and classes in its architecture:
1. App Package
    - AppLauncher class
    - GameFrame class
    - GamePanel class
2. Client Package
    - Transporter class
3. Communication Package
    - CommunicationManager class
4. Controller Package
    - AssetSetter class
    - CollisionChecker class
    - Controller class
    - GamePanelB class
    - GameRecord class
    - GameSaver class
    - KeyHandlerB class
    - MainB class
    - UI class
5. Model Package
    - Objects Package
      - OBJ class ...
    - EntityB class...
6. Util Package
    - Actions class ...
7. View Package
    - Sound class
    - View class


##### Future Improvements
The following features are planned for future releases: 
1. The player will be able to change speed.
2. There will be speed limits on the road.
3. The player will be pulled over by the police if driving too fast in an area.
4. Each state will have a more unique map tile eg: mountains and the Ocean in North Carolina.
5. When the player navigates into a state that has an issue/roadblock the player will navigate through a sub-map collecting items/services needed to get back on the road.

**Support:**
For support and correspondence in regard to this project,  reach out to a team member through jaurif@amazon.com, ruanek@amazon.com, maskesam@amazon.com,
henblair@amazon.com, tairobea@amazon.com, adsalami@amazon.com, ebenadda@amazon.com 


