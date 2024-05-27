//Ucitavanje java package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


 //Kreiranje klase za korisnika
 class User {
    private int id;
    private String username;
    private String email;
    private int age;
    //Dodeljivanje klasi korisnik parametre
    public User(int id, String username, String email, int age) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
    }
    
    //Kreiranje funkcije bez rekurzije
    public static void Userr() {
        User user = null;
        
        try {
        	//Konektovanje sa bazom root korinsik i sifra admin 
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/korisnik", "root", "admin");
            //Kreiranje konekcije
            Statement statement = connection.createStatement();
            //Koriscenje MySQL komande SELECT
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            
            //While petlja ucitava sve podatke iz baze
            while(resultSet.next()) {
                user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getInt("age"));
                System.out.print("User details:");
                System.out.print(" /ID: " + user.id);
                System.out.print(" /Username: " + user.username);
                System.out.print(" /Email: " + user.email);
                System.out.print(" /Age: " + user.age);
                System.out.println();
            }
            
            //zatvaranje baze podataka i konekcije sa istom
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
        	//Pokazuje ako je doslo do greske gde je
            e.printStackTrace();
        }
        
    }

    //Glavna funkcija u javi
    public static void main(String[] args) {
    	//Pozivanje funkcije bez rekurzije
        Userr();
    }
}