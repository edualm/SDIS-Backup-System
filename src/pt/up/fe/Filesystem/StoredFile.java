package pt.up.fe.Filesystem;

import java.io.Serializable;
import java.util.Vector;

/**
 *      A file belonging to other systems that is backed up locally.
 */

public class StoredFile extends File implements Serializable {
    Vector<Integer> _chunksStored;

    public StoredFile(String identifier, Vector<Integer> fileChunksStored) {
        super();

        _id = identifier;
        _chunksStored = fileChunksStored;
        _numberOfChunks = _chunksStored.size();
    }

    public Vector<Integer> getChunksStored() {
        return _chunksStored;
    }

    public void setChunkStoredStatus(Integer chunk, boolean status) {
        if (status) {
            for (Integer i : _chunksStored)
                if (chunk.equals(i))
                    return;

            _chunksStored.add(chunk);
        } else
            for (Integer i : _chunksStored)
                if (chunk.equals(i)) {
                    _chunksStored.remove(i);

                    return;
                }
    }
}
