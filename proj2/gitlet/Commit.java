package gitlet;

// TODO: any imports you need here

import java.util.Date; // TODO: You'll likely use this in this class

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private String message;
    private String logMessage;
    private String timestamp;
    private String namesMap;
    private String parentName; //hashName of parent
    private String hashName;

    /* TODO: fill in the rest of this class. */

    public Commit(String message, String parent, String timestamp){
        this.message = message;
        this.parentName = parent;
        this.timestamp = timestamp;
    }
}
