package nl.hva.ict.ss;

import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;

/**
 * Put your tests that show you implemented the code correctly in this class.
 * Any test placed at a different class will be ignored!
 * Failing to add tests here will result in failing the assignment!
 */
public class ExtendedAdvancedSortingTest extends AdvancedSortingTest {

    static LinkedList<Player> extendedUnsortedPlayers = new LinkedList<>();

    @Test
    public void testArrayQuickSortSorts() {
        extendedUnsortedPlayers.clear();

        Player harry = new Player("Harry", "Potter", 100);
        Player onmisbareHenk = new Player("Henk", "Timmerman", 1000);
        Player papaPotter = new Player("James", "Potter", 95);
        Player harryDeTweede = new Player("Harry2", "Potter", 100);
        Player Koen = new Player("Koen", "Potter", 180);
        Player Sierd = new Player("Sierd", "Potter", 250);

        int numberOfPlayers = 6;

        extendedUnsortedPlayers.addLast(harry);
        extendedUnsortedPlayers.addLast(onmisbareHenk);
        extendedUnsortedPlayers.addLast(papaPotter);
        extendedUnsortedPlayers.addLast(harryDeTweede);
        extendedUnsortedPlayers.addLast(Koen);
        extendedUnsortedPlayers.addLast(Sierd);

        Player[] players = getSubList(extendedUnsortedPlayers, numberOfPlayers).toArray(new Player[numberOfPlayers]);
        AdvancedSorts.quickSort(players);

        //for testing purpose, show that it sorted
//        System.out.println("sorted array:");
//        for (Player pot : players) {
//            System.out.println(pot + " ");
//        }

        //still 6 players, henk on top and james is shit?
        assertEquals(6, players.length);
        assertEquals(onmisbareHenk, players[0]);
        assertEquals(papaPotter, players[5]);
    }

    @Test
    public void testLinkedListQuickSort() {
        extendedUnsortedPlayers.clear();

        Player harryIsTerug = new Player("Harry", "Potter", 800);
        Player henkIsErOokWeer = new Player("Henk", "Timmerman", 900);
        Player vaderPotter = new Player("James", "Potter", 810);
        Player harryTweelingbroer = new Player("Harry2", "Potter", 10);
        Player Koen = new Player("Koen", "Potter", 180);
        Player Sierd = new Player("Sierd", "Potter", 250);

        int numberOfPlayers = 6;

        extendedUnsortedPlayers.addLast(harryIsTerug);
        extendedUnsortedPlayers.addLast(henkIsErOokWeer);
        extendedUnsortedPlayers.addLast(vaderPotter);
        extendedUnsortedPlayers.addLast(harryTweelingbroer);
        extendedUnsortedPlayers.addLast(Koen);
        extendedUnsortedPlayers.addLast(Sierd);

        LinkedList<Player> players = getSubList(extendedUnsortedPlayers, numberOfPlayers);
        AdvancedSorts.quickSort(players);

        //for testing purpose, show that it sorted
//        System.out.println("sorted linkedlist:");
//        for (Player pot : players) {
//            System.out.println(pot + " ");
//        }

        //still 6 players, henk on top and harry twin is shit?
        assertEquals(6, players.size());
        assertEquals(henkIsErOokWeer, players.get(0));
        assertEquals(harryTweelingbroer, players.get(5));
    }
}
