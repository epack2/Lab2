I implemented the observer pattern to tell the user that the events were created succesfully.
To accomplish this, I created an interface called EventListener that passed a void method eventOccurred(String name).
Then I created an EventCreationListener class that implemented EventListener. 
The class took in the name of the event and added it to a list of strings. 
A method called listOfEvents() returns the names of the newly created events.
The event names are collected when the addEventButton is pressed. 
The names are added to the control panel as a JLabel.
I added this pattern so that the user can be alerted that the events were created and show the names incase there was an error. 
