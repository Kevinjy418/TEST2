package gitlet;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;

import static gitlet.MyUtils.*;
import static gitlet.Utils.*;

// TODO: any imports you need here

/**
 * Represents a gitlet repository
 *
 * @author Kevin && Exuanbo
 */
public class Repository {

    /**
     * Default branch name.
     */
    private static final String DEFAULT_BRANCH_NAME = "master";
    private static final String HEAD_BRANCK_REF_PREFIX = "ref: refs/heads/";
    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");
    private static final File INDEX = join(GITLET_DIR, "index");
    private static final File OBJECTS_DIR = join(GITLET_DIR, "objects");
    private static final File HEAD = join(GITLET_DIR, "HEAD");
    private static final File REFS_DIR = join(GITLET_DIR, "refs");
    private static final File BRANCH_HEADS_DIR = join(REFS_DIR, "heads");
    private static final Lazy<File[]> currentFiles = lazy(() -> CWD.listFiles(File::isFile));
    



    /* TODO: fill in the rest of this class. */
    public static void setupRepo() {
        GITLET_DIR.mkdir();
        StagingArea.STAGE_FOLDER.mkdir();
        Blob.BLOB_FOLDER.mkdir();
        Commit.COMMIT_FOLDER.mkdir();
    }


}
