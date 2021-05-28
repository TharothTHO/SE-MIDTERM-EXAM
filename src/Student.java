import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Student{
    String Id, city, country, groupName, name, telephoneNumber;
    LocalDate dateOfBirth;

    @Override
    public String toString(){
        return "Student{" + "Name: " +name + ", Telephone Number: "+ telephoneNumber + ", City: " + city+ ", Country: "+country+", Group Name"+groupName+", Date of birth: "+dateOfBirth+"}";
    }

    public static Student dataInput(){
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input student name: ");
        student.setName(sc.nextLine());

        System.out.print("Please input City: ");
        student.setCity(sc.nextLine());

        System.out.print("Please input Country: ");
        student.setCountry(sc.nextLine());

        System.out.print("Please input Group's Name: ");
        try {
            student.setGroupName(sc.nextLine());
        } catch (GroupException e1) {
            e1.printStackTrace();
            sc.close();
        }

        System.out.print("Input Birth date (yyyy-mm-dd): ");
        String date;
        date = sc.nextLine();
        LocalDate dob = LocalDate.parse(date);
        
        try {
            student.setDateOfBirth(dob);
        } catch (BirthDateException e) {
            e.printStackTrace();
            sc.close();
        }

        System.out.print("Input Phone number: ");
        try {
            student.setTelephoneNumber(sc.nextLine());
        } catch (TelephoneNumberException e) {
            e.printStackTrace();
            sc.close();
        }
        return student;

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getId(){
        return Id;
    }
    public void setId(String Id){
        this.Id = Id;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }

    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }

    public String groupName(){
        return groupName;
    }
    public void setGroupName(String groupName) throws GroupException{
        if(groupName.charAt(0) != 'I' && groupName.charAt(0) != 'T'){S
        }
        else if(groupName.length()!=3){
            throw new GroupException("Invalid Group's name");
        }
        else{
            if((groupName.charAt(0) == 'I') && (groupName.charAt(1) == '1' || groupName.charAt(1) == '2' || groupName.charAt(1) == '3' || groupName.charAt(1) == '4' || groupName.charAt(1) == '5') && (Character.isAlphabetic(groupName.charAt(2)))){
                this.groupName = groupName;
            }
            else if((groupName.charAt(0) == 'T') && (groupName.charAt(1) == '1' || groupName.charAt(1) == '2') && (Character.isAlphabetic(groupName.charAt(2)))){
                this.groupName = groupName;
            }
            else{
                throw new GroupException("Invalid Group's name (year number must between 1 to 5 for Engineering and 1 to 2 for Technician and end with Labels)");
            }
        }

        
    }

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) throws BirthDateException{
        LocalDate date = LocalDate.now();
        Period diff = Period.between(dateOfBirth, date);
        // System.out.println(diff.getYears());
        if(diff.getYears()>=15){
            this.dateOfBirth = dateOfBirth;
        }
        else{
            throw new BirthDateException();
        }
    }

    public String getTelephoneNumber(){
        return telephoneNumber;
    }
    public void setTelephoneNumber(String telephoneNumber) throws TelephoneNumberException{

        if(telephoneNumber.charAt(0) != '0'){
            throw new TelephoneNumberException("Telephone number must follow Cambodia's phone number formats!");
        }
        else if(telephoneNumber.matches(".*[a-z].*") || telephoneNumber.matches(".*[A-Z].*")){
            throw new TelephoneNumberException("Invalid Phone Number!");
        }
        else if(telephoneNumber.length()!=9){
            throw new TelephoneNumberException("Telephone number must follow Cambodia's phone number formats!");
        }
        else{
            this.telephoneNumber = telephoneNumber;
        } 
    }
}