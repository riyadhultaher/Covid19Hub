COVID 19 HUB
__________________________________________________________________________________________________________________________________________________________

Application Link: https://covid19hubproject.herokuapp.com/login
__________________________________________________________________________________________________________________________________________________________

Github Link: https://github.com/riyadhultaher/Covid19Hub.git
__________________________________________________________________________________________________________________________________________________________

Background: 
This project began as several different ideas. The first idea was to create an automatic tracker with the ability to track vendor
websites that offered the COVID 19 vaccine. Securing an appointment became very difficult so he premise was for the tracker
to detect any changes in the HTML document representing the vendor webpage. After detecting a change, the program would
send an email to users that signed up with the corresponding information. As time went on, the project seemed to encapsulate
more of a stretch goal. Thus, the project was altered to operate more like a hub for users to quickly access COVID 19 regulations
based on US states. Users can create an account and add an initial US state then add any additional states once they are logged
in. A table will be displayed on their homepage, hyperlinking to the government site based on that US state.
__________________________________________________________________________________________________________________________________________________________

Instructions:
In order to access the project, you can import it into your current project. Make sure to import the folder titled "CaseStudy" which is located in
the parent foldeer, "Covid19Hub-master". After this, you will want to right click on the project and navigate to "Configure" then select "Convert to Maven Project".
You also need to "Convert to Faceted Form" in the same location and check "Dynamic Web Module". Please make sure you are using "Java 1.8".

The first step is to calibrate the project to your database settings. Open up "application.properties" in the "src/main/resources" folder and update
"spring.datasource.username" and "spring.datasource.password" to match the values within your HeidiSQL database.

Prior to running the program, you must create the "casestudy" database. You can open up the "createDatabase.sql" file with a text editor located in
the "src/main/resources" folder. Run the selection in HeidiSQL query and the "casestudy" database should be created.

You can now run the application in Eclipse as a Spring Boot App. You can navigate to "localhost:8080" in your desired browser and you will be directed to
the login page. 

Make sure to click on the actual words of the button to access it.

The login page has "Login" and "New User" functionality. If you already created a user account, you can log into your account with your credentials. 
If not, you can create a new account by inputting a username, password, and initial state. The username must be unique and the password must be at
least 8 characters.

Once you are logged in, you will be directed to your homepage with your current list of states. 

Navigation is handled through the drop down button located in the top left corner. The buttons include "Welcome", "Options", "About", "Contact", "Logout", and "Delete Account".

The "Options" button will allow you to "Change Password" or to "Add State". In order to change your password, your new password must be at least 8 characters.
In order to add a state, you must choose a state from the drop down menu that is displayed. States that are already added to your account will not be displayed
in the drop down meru. Both of these options will redirect you back to your homepage upon successful completion.

The "About" button provides information regarding the progress of this project.

The "Contact" button allows you to input an email address to then be redirected to a confirmation page. Functionality for this process has not been implemented.

The "Logout" button will log out of your account and redirect you back to the login page, saving any changes to your account that you may have made while you were
logged in.

The "Delete Account" button will delete your account and remove it from the database. Once you delete your account, you will no longer have access to that account's
information. This button will redirect you back to the login page.
_____________________________________________________________________________________________________________________________________________________________

User Stories:
As a user, I want to have the ability to create an account and login with saved data.
As a user, I want to have the ability to seamlessly navigate between pages.
As a user, I wannt to have the ability to link official state websites regarding COVID 19.
As a user, I want to have the ability to add a new state to an account.
As a user, I want to have the ability to change a user password.
As a user, I want to have the ability to delete my account if I wish.
