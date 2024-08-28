package gitlet;

import java.io.File;
import java.io.Serializable;
import static gitlet.Utils.*;

public class Blob implements Serializable {
    private String hashName;
    private String content;

    public static final File BLOB_DIR = join(Repository.CWD, "Blob");

    public Blob(String hashName, String content){
        this.hashName = hashName;
        this.content = content;
    }

    public String getHashName(){
        return hashName;
    }

}
