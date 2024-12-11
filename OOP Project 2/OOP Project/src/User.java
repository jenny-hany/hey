import java.util.List;
import java.util.Scanner;
import static filehandlingexample.FileHandling.readFromFile;

public abstract class User
{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNum;

    public User(String username, String password, String firstName, String lastName, String email, String mobileNum) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNum = mobileNum;
    }

    public static boolean login(String username, String password) {
        int maxSize = Math.max(data.Patients.size(),
                Math.max(data.Doctors.size(), data.Receptionists.size()));

        for (int i = 0; i < maxSize; i++) {
            if (i < data.Patients.size() &&
                    data.Patients.get(i).getUsername().equals(username) &&
                    data.Patients.get(i).getPassword().equals(password)) {
                return true;
            }

            if (i < data.Doctors.size() &&
                    data.Doctors.get(i).getUsername().equals(username) &&
                    data.Doctors.get(i).getPassword().equals(password)) {
                return true;
            }

            if (i < data.Receptionists.size() &&
                    data.Receptionists.get(i).getUsername().equals(username) &&
                    data.Receptionists.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }




        /*
        public void is_loggedIn(int choice,  String fileName ) {
        Scanner input = new Scanner(System.in);
        boolean is_exist = false;  // Initially assume the user doesn't exist
        String username, password;

        while (!is_exist) {  // Keep looping until login is successful


            if (choice == 1) { // log in
                System.out.println("Enter your username :");
                username = input.next();
                System.out.println("Enter your password :");
                password = input.next();


                // Step 1: Read existing data from the file into a list
                List<String> existingData = readFromFile(fileName);
                boolean found = false;

                // Step 2: Validate login by checking if the username and password match
                for (int i = 0; i < existingData.size(); i += 2) { // Each user has a username/password pair (2 lines per user)
                    if (i + 1 < existingData.size()) {  // Ensure we don't go out of bounds
                        String storedUsername = existingData.get(i);
                        String storedPassword = existingData.get(i + 1); // Password follows username in file

                        if (storedUsername.equals(username) && storedPassword.equals(password)) {
                            found = true; // User found, login successful
                            is_exist = true; // exit loop for login
                            System.out.println("Login successful.");
                            break;
                        }
                    }
                }

                if (!found) {
                    System.out.println("Incorrect username or password. Try again.");
                }

            } else if (choice == 2) { // sign up
                System.out.println("Enter username :");
                username = input.next();
                System.out.println("Enter password :");
                password = input.next();
                System.out.println("Enter first name :");
                firstName = input.next();
                System.out.println("Enter last name :");
                lastName = input.next();
                System.out.println("Enter email :");
                email = input.next();
                System.out.println("Enter mobile number :");
                mobileNum = input.next();

                // Save the new user details to the file
                String[] newUserData = {username, password, firstName, lastName, email, mobileNum};

                System.out.println("Signup successful. You can now login.");
                break;  // Break out of the loop after a successful signup
            }
        }
    }
*/

    // Getters and Setters
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }
    public String getMobileNumber()
    {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


    @Override
    public String toString()
    {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}