1. Overview
The provided Java project implements a Voting System that allows:
•	Admin functionalities: Adding voters, candidates, and viewing results.
•	Voter functionalities: Logging in and casting votes.
•	Result viewing: Displaying election results to all users.
The project leverages a Java Swing GUI for a user-friendly interface and organizes its features into various components for maintainability.
________________________________________
2. Key Features
1.	User Interfaces:
o	Main Window: Entry point for admin and voters.
o	Admin Login & Dashboard: Secure admin access to manage voters and candidates.
o	Voter Login: Allows registered voters to log in and cast their votes.
o	Results Window: Displays election results in a tabular format.
2.	Core Functionality:
o	Registration: Handles voter and candidate registration with unique identifiers.
o	Authentication: Validates admin credentials.
o	Voting Logic: Ensures each voter can only vote once, and updates vote counts accordingly.

________________________________________
3. Structure & Code Organization
The project is divided into multiple files for modularity:
•	Main Application (Main.java): Launches the application and initializes data.
•	GUI Windows:
o	MainWindow.java
o	AdminLoginWindow.java, AdminDashboardWindow.java
o	AddVoterWindow.java, AddCandidateWindow.java
o	ResultsWindow.java, VotingWindow.java
•	Data Classes:
o	Voter: Represents a voter with ID, name, and voting status.
o	Candidate: Represents a candidate with ID, name, and vote count.
•	Logic:
o	Registration: Handles storage and addition of voters and candidates.
o	Admin: Provides hardcoded admin credentials and authentication logic.
