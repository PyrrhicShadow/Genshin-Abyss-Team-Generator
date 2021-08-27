package abyssTeamGen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CharacterIO {

    public CharacterIO(){
        super();
    }

    /**
     * Takes a formatted CSV and converts it into an ArrayList of Character objects
     * @param fileName the file path for a formatted CSV
     * @return an ArrayList of characters
     */
    public ArrayList<Character> readDataFromFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        ArrayList characters = new ArrayList<Character>();
        String line = "";
        br.readLine(); // The first line is a header, which needs to be consumed before Temperature objects can be constructed.
        while ((line = br.readLine()) != null) {
            Character chara = new Character(line);
            characters.add(chara);
        }
        fr.close();
        br.close();

        return characters;
    }

}
