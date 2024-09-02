package gitlet;

import java.io.File;
import java.io.Serializable;
import static gitlet.Utils.*;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        // TODO: what if args is empty?
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                init(args);
                break;
            case "add":
                // TODO: handle the `add [filename]` command
                add(args);
                break;
            // TODO: FILL THE REST IN
            case "commit":
                commit(args);
                break;
        }
    }

    public static void init(String [] args) {
        //one commit with "initial commit"
        //
        //set master as curr branch"
        String message = args[1];
        File CWD = new File(System.getProperty("user.dir"));
        Commit initial = new Commit(message, null, "00:00:00 UTC, Thursday, 1 January 1970");
        initial.AssignHashName();
    }

    /**
     * Adds a copy of the file as it currently exists to the staging area (see the description of the commit command).
     * For this reason, adding a file is also called staging the file for addition.
     * Staging an already-staged file overwrites the previous entry in the staging area with the new contents.
     * The staging area should be somewhere in .gitlet. If the current working version of the file is identical to
     * the version in the current commit, do not stage it to be added, and remove it from the staging area if
     * it is already there (as can happen when a file is changed, added, and then changed back to it’s original version).
     * The file will no longer be staged for removal (see gitlet rm), if it was at the time of the command.
     *
     */
    public static void add(String [] args){
        //check if File in "stage" == "be tracked"
        //copy
        String toAdd = args[1];
        File toAddFile = join(Repository.CWD, toAdd);
        //Failure case
        if(! toAddFile.exists()){
            System.out.println("File does not exist");
            return;
        }
        //if toAdd has been in stage
        if(StagingArea.Add_is_exist(toAdd)){
            //check if "been" same?
            if(StagingArea.Add_hadSame(toAdd)){
                return;
            }
            // else -> overwrite
            else{
                StagingArea.Add_overwrite(toAdd);
            }
        }
        else{
            StagingArea.Add_SaveFile(toAdd);
        }
        //add to stage
        //if create blob?
        //
    }


    public static void commit(String [] args) {
        //clone the parent ->new_commit
        Commit new_commit = new Commit()
        //change metadata
        //look up stagingArea, change link blob -- name.txt
        //clean the staged area
        //denote who is the parent of new_commit
        //advance the Head and Branch
    }

    public static void rm(String [] args) {
        File toRemove = join(Repository.CWD, args[2]);
        //if in adding
        //if in curr_commit
          //stage it in "Staging_removing"
          //remove it from CWD
    }

    public static void log(String [] args) {

    }
}
