import java.util.Scanner;

public class Main {

    public static class User {
        public String name = "undefined_user";
        public double balance = 100.0;
    }

    public static void print(String text) {
        System.out.println(text);
    }

    public static User getUser(User[] users) {
        Scanner scanner = new Scanner(System.in);
        print("User list: \n");

        int key = 0;
        for(User user : users) {
            key++;
            print(key + ". " + user.name);
        }

        print("\n Select user: ");
        String username = scanner.nextLine();

        User _user = null;

        for(User user : users) {
            if(user.name.equals(username)) _user = user;
        }

        print("\n\n\n\n\n\n");
        print("Hello, " + _user.name + "!");
        return _user;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        User user1 = new User();
        User user2 = new User();

        user1.name = "Test1";
        user2.name = "SuperUser2391";

        User[] users = { user1, user2 };

        print("ATM Software");
        
        User user_ = getUser(users);

        while(true) {
            print("Your balance: $" + user_.balance);
            print("What do you want to do?");
            print("1. Logout");
            print("2. Transfer money");

            String action = scanner.nextLine();
            if(action.equals("1")) {
                user_ = getUser(users);
            }
            else {
                print("To who?: ");
                String username = scanner.nextLine();

                print("How much?: ");
                String much = scanner.nextLine();
                double parsed = Double.parseDouble(much);

                if(!(user_.balance >= parsed)) {
                    print("Not enought money!");
                    continue;
                }

                for(User user : users) {
                    if(user.name.equals(username)) {
                        user.balance += parsed;
                    }
                    else if(user.name.equals(user_.name)) {
                        user.balance -= parsed;
                    }
                }
            }
        }
    }
}