package capers;

import java.io.File;
import java.io.IOException;

import static capers.Utils.*;

/** A repository for Capers 
 * @author jason
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = join(CWD, ".capers");

    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    public static void setupPersistence() {
        CAPERS_FOLDER.mkdir();
        File dogFolder = join(CAPERS_FOLDER, "dogs");
        dogFolder.mkdir();
        File storyFile = join(CAPERS_FOLDER, "story");
        try{
            storyFile.createNewFile();
        } catch (IOException excp) {
            throw new IllegalArgumentException(excp.getMessage());
        }
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * Also prints out the hole story.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) {
        File storyFile = join(CAPERS_FOLDER, "story");
        String lastStory = Utils.readContentsAsString(storyFile);
        Utils.writeContents(storyFile, lastStory, text, "\n");
        String story = Utils.readContentsAsString(storyFile);
        System.out.print(story);
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        Dog newDog = new Dog(name, breed, age);
        newDog.saveDog();
        System.out.println(newDog.toString());
    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        Dog dog = Dog.fromFile(name);
        dog.haveBirthday();
        dog.saveDog();
    }
}