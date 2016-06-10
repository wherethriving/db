package scopa.cona.database.constant;

/**
 * Created by panda on 6/8/16.
 */
public enum IncrementalType {
    NOT_INCREMENTAL(0),
    WHOLE_INCREMENTAL(1),
    PARTIAL_INCREMENTAL(2);

    private int nCode;

    private IncrementalType(int _nCode) {
        this.nCode = _nCode;
    }

    public int toInt() {
        return nCode;
    }


}
