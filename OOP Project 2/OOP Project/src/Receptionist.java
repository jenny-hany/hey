public class Receptionist extends User {

    private int age;
    private String gender;


    public Receptionist(String username, String password, String firstName, String lastName, String email,
                        String mobileNum, int age, String gender)
    {
        super(username, password, firstName, lastName, email, mobileNum);
        this.age = age;
        this.gender = gender;

    }
    public static void changeEmail(String email,String newEmail )
    {
        int size= data.Receptionists.size();
        for (int i = 0; i <size; i++)
        {
            if(data.Receptionists.get(i).getEmail().equals (email))
            {
                data.Receptionists.get(i).setEmail(newEmail);
                break;
            }

        }
    }
    public static void changeMobileNum(String mobilenum,String newMobileNm )
    {
        int size= data.Receptionists.size();
        for (int i = 0; i <size; i++)
        {
            if(data.Receptionists.get(i).getMobileNumber().equals (mobilenum))
            {
                data.Receptionists.get(i).setMobileNum(newMobileNm);
                break;
            }

        }
    }

    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
/*
    // Method to convert receptionist data into a file-friendly format
    public String toFileFormat() {
        return getFirstName() + "," + getLastName() + "," + getEmail() + "," +
                age + "," + gender;
    }

    // Static method to create a Receptionist object from file data
    public static Receptionist fromFileFormat(String data) {
        String[] fields = data.split(",");
        Receptionist receptionist = new Receptionist();
        receptionist.setFirstName(fields[0]);
        receptionist.setLastName(fields[1]);
        receptionist.setEmail(fields[2]);
        receptionist.setAge(Integer.parseInt(fields[3]));
        receptionist.setGender(fields[4]);
        return receptionist;
    }

    // Method to save receptionist data to file
    public void save() {
        // Use FileHandling to append the receptionist's details to the file
        FileHandling.writeToFile("receptionists.txt", List.of(this.toFileFormat()), true);  // Append to file
    }

    // Method to load all receptionists from file
    public static List<Receptionist> loadAll() {
        // Read the file and convert each line to a Receptionist object
        List<String> lines = FileHandling.readFromFile("receptionists.txt");
        List<Receptionist> receptionists = new ArrayList<>();
        for (String line : lines) {
            receptionists.add(Receptionist.fromFileFormat(line));
        }
        return receptionists;
    }

    // Receptionist Menu for interacting with the clinic
    static public void menuReceptionist() {
        Scanner input = new Scanner(System.in);
        String firstName, lastName, email;

        System.out.println("Choose an action: \n" +
                "1) Enter your information \n" +
                "2) Update your information \n" +
                "3) Exit");

        int x = input.nextInt();
        input.nextLine(); // Consume the newline

        if (x == 1) {
            // Enter new receptionist information
            System.out.println("Please enter your First name:");
            firstName = input.nextLine();
            System.out.println("Please enter your Last name:");
            lastName = input.nextLine();
            System.out.println("Please enter your email:");
            email = input.nextLine();
            System.out.println("Please enter your Age:");
            int age = input.nextInt();
            input.nextLine(); // Consume the newline
            System.out.println("Please enter your Gender:");
            String gender = input.nextLine();

            // Create a new receptionist object
            Receptionist receptionist = new Receptionist();
            receptionist.setFirstName(firstName);
            receptionist.setLastName(lastName);
            receptionist.setEmail(email);
            receptionist.setAge(age);
            receptionist.setGender(gender);

            // Save the new receptionist data
            receptionist.save();
            System.out.println("Your details have been saved successfully.");

        } else if (x == 2) {
            // Update receptionist information
            System.out.println("Updating your information is not implemented yet.");
        } else if (x == 3) {
            System.out.println("Exiting...");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "age=" + age +
                ", gender='" + gender + '\'' +
                ", User Info=" + super.toString() +
                '}';

    }
    */
}


