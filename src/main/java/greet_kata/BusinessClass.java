package greet_kata;

import java.util.ArrayList;
import java.util.List;

public class BusinessClass {
    NameAsker nameAsker;

    public BusinessClass(NameAsker nameAsker) {
        this.nameAsker = nameAsker;
    }

    String[] myFriends;
    String[] tabOfFriendsTakenFromNameAsker;
    String greetingMyFriends;
    List<String> myFriendsButNormal;
    List<String> myFriendsButThoseWhoAreStillShouting;
    List<String> myFriendsAfterChecking;

    public String greet() {
//        Ściągamy z NameAskera tablicy imion.
        tabOfFriendsTakenFromNameAsker = nameAsker.askName();
//        Jeśli jakiś debil wstawi nulla to wypisze text z returna.
        if (tabOfFriendsTakenFromNameAsker[0] == null)
            return "Hello, my friend.";
//        Sprawdzamy czy wprowadzoe w tabliczy Imiona są błędne i czy ktoś ma dwa imiona.
        checkFriendsBeforeChecking();
//        Przekształcamy tę tablicę w nową i tworzymy przywitanie dla każdego przypadku inne.
        multipleNames();
        return greetingMyFriends;
    }

    void checkFriendsBeforeChecking(){
        myFriendsAfterChecking = new ArrayList<>();
        for (String s : tabOfFriendsTakenFromNameAsker) {
            if (s.contains(", ") && !s.contains("\""))
                for (String friendButBadlyWrited : s.split(", ")) {
                    myFriendsAfterChecking.add(friendButBadlyWrited);
                }
            else {
                myFriendsAfterChecking.add(s.replace("\"", ""));
            }
        }
        myFriends = myFriendsAfterChecking.toArray(String[]::new);
    }
    void multipleNames() {
        myFriendsButThoseWhoAreStillShouting = new ArrayList<>();
        myFriendsButNormal = new ArrayList<>();

//        Segregacja imion z tablicy do list.
        for (String friend : myFriends) {
            if (friend.equals(friend.toUpperCase())) {
                myFriendsButThoseWhoAreStillShouting.add(friend);
                continue;
            }
            myFriendsButNormal.add(friend);
        }

//        Przypadek gdy występują oba rodzaje przyjaciół.
        if (myFriendsButNormal.size() > 0 && myFriendsButThoseWhoAreStillShouting.size() > 0) {
            hopeThatYouWillTryToGetBetterFriends();
            return;
        }

//        Przypadek gdy masz tylko normalnych przyjaciół.
        if (myFriendsButNormal.size() > 0 && myFriendsButThoseWhoAreStillShouting.size() == 0) {
            iAmGladThatYouHaveOnlyNormalFriends();
            return;
        }

//        Przypadek gdy wszyscy twoi przyjaciele drą się jak poje****.
        if (myFriendsButThoseWhoAreStillShouting.size() > 0 && myFriendsButNormal.size() == 0) {
            youShouldSilentTheseFuckers();
            return;
        }
    }

    void hopeThatYouWillTryToGetBetterFriends() {
        greetingMyFriends = "Hello";
        if (myFriendsButNormal.size() == 1)
            greetingMyFriends += ", " + myFriendsButNormal.get(0) + ".";
        else if (myFriendsButNormal.size() > 2) {
            for (int i = 0; i < myFriendsButNormal.size() - 1; i++)
                greetingMyFriends += ", " + myFriendsButNormal.get(i);
            greetingMyFriends += " and " + myFriendsButNormal.get(myFriendsButNormal.size() - 1) + '.';
        } else {
            greetingMyFriends += ", " + myFriendsButNormal.get(0) + " and " + myFriendsButNormal.get(1) + ".";
        }
        greetingMyFriends += " AND HELLO ";
        for (int i = 0; i < myFriendsButThoseWhoAreStillShouting.size(); i++)
            greetingMyFriends += myFriendsButThoseWhoAreStillShouting.get(i);
        greetingMyFriends += '!';
    }

    void youShouldSilentTheseFuckers() {
        greetingMyFriends = "HELLO";
        for (String friend : myFriendsButThoseWhoAreStillShouting) {
            greetingMyFriends += " " + friend;
        }
        greetingMyFriends += '!';
    }

    void iAmGladThatYouHaveOnlyNormalFriends() {
        greetingMyFriends = "Hello";
        if (myFriendsButNormal.size() == 1) {
            greetingMyFriends += ", " + myFriendsButNormal.get(0) + ".";
            return;
        } else if (myFriendsButNormal.size() > 2) {
            for (int i = 0; i < myFriendsButNormal.size() - 1; i++)
                greetingMyFriends += ", " + myFriendsButNormal.get(i);
            greetingMyFriends += ", and " + myFriendsButNormal.get(myFriendsButNormal.size() - 1) + '.';
            return;
        }
        greetingMyFriends += ", " + myFriendsButNormal.get(0) + " and " + myFriendsButNormal.get(1) + ".";
    }
}
