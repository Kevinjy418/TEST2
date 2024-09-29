package gitlet;

import java.io.File;
import java.io.Serializable;
import static gitlet.Utils.*;

public class Blob implements Serializable {
    private String hashName;
    private String content;

    public static final File BLOB_FOLDER = join(Repository.CWD, "Blob");

    public Blob(String hashName, String content){
        this.hashName = hashName;
        this.content = content;
    }

    public String getHashName(){
        return hashName;
    }

    public void SaveBlob(Blob blob_toSave){
        //hello
        //create File to save blob
        //name in hash
        File File_toSaveIn = join(BLOB_FOLDER, blob_toSave.hashName);
        //write blob.content in
        writeContents(File_toSaveIn, blob_toSave.content);
    }

}
