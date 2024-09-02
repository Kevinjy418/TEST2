package gitlet;

import java.io.File;
import java.io.IOException;

import static gitlet.Utils.*;

//stage the link between file_added and blob
public class StagingArea {
    public static final File STAGE_FOLDER = join(Repository.GITLET_DIR, "StagingArea");
    public static final File Addition = join(STAGE_FOLDER, "Addition");

    public static final File Remvove = join(STAGE_FOLDER, "Remvove");

    public static boolean Add_is_exist(String tocheck){
        File filetocheck = new File(Addition, tocheck);
        return filetocheck.exists();
    }
    /** return if "WorkTocheck" same with "Staged to check" for Add cmd */
    public static boolean Add_hadSame(String WorkTocheck){
        return hadSame(WorkTocheck, Addition);
    }

    /** return if "WorkTocheck" same with "Staged to check" for rm cmd */
    public static boolean Remove_hadSame(String RemoveTocheck){
        return hadSame(RemoveTocheck, Remvove);
    }

    /** return if "WorkTocheck" same with "Staged to check" */
    public static boolean hadSame(String Worktocheck, File AddorRem){
        File Work = new File(Repository.CWD, Worktocheck);
        File Staged = new File(Addition, Worktocheck);
        return Content_isSame(Work, Staged);
    }

    public static boolean Content_isSame(File A, File B){
        String ContentA = readContentsAsString(A);
        String ContentB = readContentsAsString(B);
        return ContentA.equals(ContentB);
    }

    public static void Add_overwrite(String Work_Towrite_name){
        overwrite(Work_Towrite_name, Addition);
    }
    //overwrite "Staged towrite" with "Work towrite"
    public static void overwrite(String Work_towrite_name , File AddorRem){
        File Stage_towrite_File = join(AddorRem, Work_towrite_name);
        File Work_towrite_File = join(Repository.CWD, Work_towrite_name);
        String Work_towrite_content = readContentsAsString(Work_towrite_File);
        Blob blob = new Blob(sha1(Work_towrite_File), Work_towrite_content);
        //overwrite. Will method "writeContents" delete the current content??
        writeContents(Stage_towrite_File, blob.getHashName());
        
    }


    public static void Add_SaveFile(String NametoSave){
        StagedFile(NametoSave, Addition);
    }

    //Give it a Blob and File, record Blob.hashName in File.
    public static void StagedFile(String NametoSave, File AddorRem){
        File toStaged = join(AddorRem, NametoSave);
        File Work = join(Repository.CWD, NametoSave);
        String contentToSave = readContentsAsString(Work);
        Blob blob = new Blob(sha1(Work), contentToSave);
        //Link new_blob with new_added_file
        writeContents(toStaged, blob.getHashName());
    }

    public static void Remove_SaveFile(String toRemove){}
}
