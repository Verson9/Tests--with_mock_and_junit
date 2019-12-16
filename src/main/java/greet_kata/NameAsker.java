package greet_kata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NameAsker {
    Scanner sc = new Scanner(System.in);
    List<String> friends;

    public String[] askName() {
        friends = new ArrayList<>();
        while (!sc.hasNext(" ")) {
            friends.add(sc.nextLine());
        }
        return friends.toArray(String[]::new);
    }
}
