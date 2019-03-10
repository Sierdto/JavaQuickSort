package nl.hva.ict.ss;

import java.util.Arrays;

/**
 * Player keeps track of the name and the highscore for a player.
 * Once created the name can't be changed. The best score for this player
 * can be changed during the lifetime of an instance.
 */
public class Player implements Comparable<Player> {
    private String firstName;
    private String lastName;
    private long highScore;

    public Player(String firstName, String lastName, long highScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.highScore = highScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getHighScore() {
        return highScore;
    }

    public void setHighScore(long highScore) {
        this.highScore = highScore;
    }

    @Override
    public int compareTo(Player other) {
        // Should sort accending on highscore
        // In case the highscores are equal the last and first name should be taken into account.
        // First sort by lastname and only take the first name into consideration if the
        // lastnames are identical.

        //Take this case for every example : A.COMPARETO(B)
        //if A results higher then b 1 is returned
        //If b results higher then a 0 is returned
        //If the end up the same or something wrong happen -1 is returned

        if (other != null) {
            //Highscore a higher then b return 1
            if (highScore > other.highScore) {
                return 1;

            } else if (other.highScore > highScore) {
                //highscore b higher then a
                return 0;
                //IGNORE INTELLIJ WARNING
            } else if (highScore == other.highScore) {
                //Highscores the same? then check the lastname

                String a = lastName;
                String b = other.lastName;

                int compareLastname = a.compareTo(b);

                //a compared higher then b
                if (compareLastname < 0) {
                    return 1;
                }

                //b compared higher then a
                else if (compareLastname > 0) {
                    return 0;
                }
                //a and b both the same, now start to compare the firstnames
                else {
                    String c = firstName;
                    String d = other.firstName;

                    int compareFirstname = c.compareTo(d);
                    //c compared higher then d
                    if (compareFirstname < 0) {
                        return 1;
                    }

                    //d compared higher then c
                    else if (compareFirstname > 0) {
                        return 0;
                    }

                    //highscores, ab and cd are the same to it must be the same object
                    else {
                        return -1;
                    }
                }
            }
        }
        return -1;
    }

    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", highScore=" + highScore +
                '}';
    }
}
