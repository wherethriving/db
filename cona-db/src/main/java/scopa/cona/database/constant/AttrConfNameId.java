package scopa.cona.database.constant;

/**
 * Created by panda on 6/10/16.
 */
public enum AttrConfNameId {
    primaryType(0),
    searchType(1),
    isUniqueKey(2),
    des(3),
    primary(4),
    isLongString(5),
    isCommonKey(6),
    primaryName(7),
    offset(8),
    timeFormat(9),
    isSearchKey(10),
    isPrimary(11),
    reference(12);

    private int nCode;

    private AttrConfNameId(int _nCode) {
        this.nCode = _nCode;
    }

    public int toInt() {
        return nCode;
    }
}
