package gitlet;

// TODO: any imports you need here

import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static gitlet.Utils.*;

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
    private final String message;
    private final Date date;
    private List<String> parents_id; //hashName of parent
    private String hashName;
    private final Map<String, String> Tracked_files;
    public static String Head_id;
    public static String Active_branch_id;
    private final File this_file;
    public static final File COMMIT_FOLDER = join(Repository.GITLET_DIR, "Commits");

    /* TODO: fill in the rest of this class. */


    public Commit(String message, List<String> parents_id, Map<String, String> TrackedFiles_Map, Date date){
        this.date = new Date();
        this.message = message;
        this.parents_id = parents_id;
        this.Tracked_files = new HashMap<String, String>();
        this.AssignHashName();
        this.this_file = join(COMMIT_FOLDER, this.hashName);
    }

    /**
     * Initial commit
     */
    public Commit(){
        this.date = new Date(0);
        message = "initial commit";
        parents_id = new ArrayList<>();
        Tracked_files = new HashMap<>();
        this.AssignHashName();
        this.this_file = join(COMMIT_FOLDER, this.hashName);
    }

    public void AssignHashName(){
        this.hashName = sha1(this);
    }

    public void SaveCommit(Commit commit_toSave){
        //create a file in COMMITS_FOLDER for commit
        //name in hashName!
        File File_toSaveIn = join(COMMIT_FOLDER, commit_toSave.hashName);
        //interact with StagingArea
        //clear StagingArea
    }

    public Commit Clone(){

    }

    /** varities of get */
    public String getHashName() {
        return hashName;
    }


    public String getLogMessage() {
        return logMessage;
    }

    public String getMessage() {
        return message;
    }

    public String getNamesMap() {
        return namesMap;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getTracked_files() {
        return Tracked_files;
    }

    public Commit getParent(){

    }

}
